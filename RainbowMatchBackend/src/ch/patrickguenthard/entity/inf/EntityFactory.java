package ch.patrickguenthard.entity.inf;

import ch.patrickguenthard.entity.Role;
import ch.patrickguenthard.entity.User;
import ch.patrickguenthard.entity.UserDetail;
import ch.patrickguenthard.entity.UserRole;

public class EntityFactory {
	public static BaseEntity createEmptyEntity(Class clss){
		if(clss.equals(User.class)){
			return new User();
		} else if(clss.equals(Role.class)){
			return new Role();
		} else if(clss.equals(UserRole.class)){
			return new UserRole();
		} else if(clss.equals(UserDetail.class)){
			return new UserDetail();
		}
		
		return null;
	}
}
