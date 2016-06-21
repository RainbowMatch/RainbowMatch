package ch.patrickguenthard.service;

import java.util.List;

import ch.patrickguenthard.entity.Role;
import ch.patrickguenthard.exceptions.UnsupportedException;

public interface RoleService {
	public void addRole(Role role) throws UnsupportedException;
	public List<Role> searchAllRoles();
	public Role searchById(Long id);
}
