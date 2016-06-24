package ch.patrickguenthard.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import ch.patrickguenthard.dataaccess.DataAccessConnectionInitiator;
import ch.patrickguenthard.dataaccess.DataAccessManager;
import ch.patrickguenthard.entity.Profile;
import ch.patrickguenthard.entity.User;
import ch.patrickguenthard.exceptions.UnsupportedException;
import ch.patrickguenthard.exceptions.UserException;
import ch.patrickguenthard.exceptions.UserNotFoundException;
import ch.patrickguenthard.exceptions.IncorrectLoginException;
import ch.patrickguenthard.util.HashingUtil;
import ch.patrickguenthard.util.logger.Logger;
import ch.patrickguenthard.exceptions.UserException;

public class UserServiceImpl implements UserService{

    private DataAccessManager<User> dam;
    private Logger LOG = new Logger(UserServiceImpl.class.getName());
    private ProfileService profileService;
    
    
    public UserServiceImpl() {
    	dam = new DataAccessManager<User>(DataAccessConnectionInitiator.getInstance().getConnection());
    	profileService = new ProfileServiceImpl();
    }
	
    @Override
    public void addUser(User user) throws UnsupportedException{
		try {
		    user.setUserPassword(HashingUtil.SHAsum(user.getUserPassword().getBytes()));
		} catch (NoSuchAlgorithmException e) {
		    e.printStackTrace();
		}
		Long userId = dam.persist(user);
		Profile prof = new Profile();
		prof.setUserId(userId);
		prof.setBiography("");
		prof.setGender(0f);
		prof.setNonBinaryGender(false);
		prof.setNonBinaryGenderId(-1L);
		prof.setProfilePicture("");
		profileService.addProfile(prof);
    }
	
    @Override
    public List<User> searchAllUser(){
	return dam.searchValues("SELECT * FROM TBAE_USER",User.class);
    }

    @Override
    public Long checkUser(User user) throws UserException {
	System.out.println(user);
	User singleUser;
	try{
	    singleUser = dam.searchValues("SELECT * FROM TBAE_USER WHERE USER_NAME = '" + user.getUserName() + "'", User.class).get(0);
	} catch (NullPointerException ex) {
	    ex.printStackTrace();
	    throw new UserNotFoundException();
	}
	try {
		System.out.println(HashingUtil.SHAsum(user.getUserPassword().getBytes()) + ", " + singleUser.getUserPassword());
	    if(singleUser.getUserPassword().equals(HashingUtil.SHAsum(user.getUserPassword().getBytes()))) {
	    	return singleUser.getUserId();
	    } else {
		throw new IncorrectLoginException();
	    }
	} catch (NoSuchAlgorithmException e) {
	    e.printStackTrace();
	}
	return null;
    }

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}
}
