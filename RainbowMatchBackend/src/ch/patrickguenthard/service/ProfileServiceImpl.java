package ch.patrickguenthard.service;

import ch.patrickguenthard.dataaccess.DataAccessConnectionInitiator;
import ch.patrickguenthard.dataaccess.DataAccessManager;
import ch.patrickguenthard.entity.Profile;
import ch.patrickguenthard.entity.User;
import ch.patrickguenthard.exceptions.UnsupportedException;

public class ProfileServiceImpl implements ProfileService {

	private DataAccessManager<Profile> dam = new DataAccessManager<>(DataAccessConnectionInitiator.getInstance().getConnection());
	
	@Override
	public Profile getProfileByUser(Long usrid) {
		try {
			return dam.searchValues("SELECT * FROM TBAE_PROFILE WHERE USER_ID = " + usrid, Profile.class).get(0);
		} catch (IndexOutOfBoundsException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public void addProfile(Profile prof) throws UnsupportedException {
		System.out.println("profile id" + dam.persist(prof));
	}

	@Override
	public void updateProfile(Profile prof) throws UnsupportedException {
		dam.update(prof);
	}
	
}
