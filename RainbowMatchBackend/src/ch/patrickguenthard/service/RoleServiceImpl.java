package ch.patrickguenthard.service;

import java.util.List;

import ch.patrickguenthard.dataaccess.DataAccessConnectionInitiator;
import ch.patrickguenthard.dataaccess.DataAccessManager;
import ch.patrickguenthard.entity.Role;
import ch.patrickguenthard.exceptions.UnsupportedException;

public class RoleServiceImpl implements RoleService {

	private DataAccessManager<Role> dam;
	
	public RoleServiceImpl() {
		dam = new DataAccessManager<>(DataAccessConnectionInitiator.getInstance().getConnection());
	}
	
	@Override
	public void addRole(Role role) throws UnsupportedException {
		dam.persist(role);
	}

	@Override
	public List<Role> searchAllRoles() {
		return dam.searchValues("SELECT * FROM TBAE_ROLE", Role.class);
	}
	
	@Override
	public Role searchById(Long id){
		try{
			return dam.searchValues("SELECT * FROM TBAE_ROLE WHERE ROLE_ID = "+id, Role.class).get(0);
		} catch(NullPointerException ex){
			return null;
		}
		
	}

}
