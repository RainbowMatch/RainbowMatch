package ch.patrickguenthard.service;

import java.util.List;

import ch.patrickguenthard.dataaccess.DataAccessConnectionInitiator;
import ch.patrickguenthard.dataaccess.DataAccessManager;
import ch.patrickguenthard.entity.UserRole;
import ch.patrickguenthard.exceptions.UnsupportedException;

public class UserRoleServiceImpl implements UserRoleService {

	private DataAccessManager<UserRole> dam;
	
	public UserRoleServiceImpl() {
		dam = new DataAccessManager<>(DataAccessConnectionInitiator.getInstance().getConnection());
	}
	
	@Override
	public void addUserRole(UserRole role) throws UnsupportedException {
		dam.persist(role);
	}

	@Override
	public List<UserRole> searchAllUserRoles() {
		return dam.searchValues("SELECT * FROM TBAE_USER_ROLE", UserRole.class);
	}

	@Override
	public List<UserRole> searchUserRolesByUserId(Long userId) {
		return dam.searchValues("SELECT * FROM TBAE_USER_ROLE WHERE USER_ID = "+userId, UserRole.class);
	}

}
