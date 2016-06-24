package ch.patrickguenthard.service;

import java.util.List;

import ch.patrickguenthard.dataaccess.DataAccessConnectionInitiator;
import ch.patrickguenthard.dataaccess.DataAccessManager;
import ch.patrickguenthard.entity.User;
import ch.patrickguenthard.entity.UserDetail;
import ch.patrickguenthard.entity.UserRole;

public class UserDetailServiceImpl implements UserDetailService {

	private DataAccessManager<UserDetail> dam;
	
	public UserDetailServiceImpl(){
		dam = new DataAccessManager<>(DataAccessConnectionInitiator.getInstance().getConnection());
	}
	
	@Override
	public List<UserDetail> searchAllUserDetails() {
		return dam.searchValues("SELECT * FROM TBAE_USER", UserDetail.class);
	}
	
	@Override
	public UserDetail searchById(Long id) {
		return dam.searchValues("SELECT * FROM TBAE_USER WHERE USER_ID = " + id, UserDetail.class).get(0);
	}

	@Override
	public void delete(User user) {
		
	}

}
