package ch.patrickguenthard.entity.inf;

import ch.patrickguenthard.entity.NonBinaryGender;
import ch.patrickguenthard.entity.Profile;
import ch.patrickguenthard.entity.Region;
import ch.patrickguenthard.entity.Role;
import ch.patrickguenthard.entity.SexualOrientation;
import ch.patrickguenthard.entity.User;
import ch.patrickguenthard.entity.UserDetail;
import ch.patrickguenthard.entity.UserRole;

/**
 * This class is a helper-class for ch.patrickguenthard.dataaccess.DataAccessManager
 * @author Patrick
 *
 */
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
		} else if(clss.equals(Profile.class)){
			return new Profile();
		} else if(clss.equals(NonBinaryGender.class)){
			return new NonBinaryGender();
		} else if(clss.equals(SexualOrientation.class)){
			return new SexualOrientation();
		} else if(clss.equals(Region.class)){
			return new Region();
		} 
		
		return null;
	}
}
