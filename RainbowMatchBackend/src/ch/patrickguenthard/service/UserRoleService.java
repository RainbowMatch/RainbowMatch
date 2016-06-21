package ch.patrickguenthard.service;

import java.util.List;

import ch.patrickguenthard.entity.Role;
import ch.patrickguenthard.entity.User;
import ch.patrickguenthard.entity.UserRole;
import ch.patrickguenthard.exceptions.UnsupportedException;

public interface UserRoleService {
	public void addUserRole(UserRole role) throws UnsupportedException;
	public List<UserRole> searchAllUserRoles();
	public List<UserRole> searchUserRolesByUserId(Long userid);
}
