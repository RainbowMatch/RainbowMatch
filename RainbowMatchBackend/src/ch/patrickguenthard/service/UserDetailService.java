package ch.patrickguenthard.service;

import java.util.List;

import ch.patrickguenthard.entity.Role;
import ch.patrickguenthard.entity.UserDetail;

public interface UserDetailService {
	public List<UserDetail> searchAllUserDetails();
	public UserDetail searchById(Long id);
}
