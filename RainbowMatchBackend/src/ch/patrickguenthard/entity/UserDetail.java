package ch.patrickguenthard.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import ch.patrickguenthard.entity.inf.BaseEntity;
import ch.patrickguenthard.exceptions.UnsupportedException;
import ch.patrickguenthard.service.UserRoleService;
import ch.patrickguenthard.service.UserRoleServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class UserDetail implements BaseEntity {

	private Long userId;
	private String userName;
	private List<Role> userRoles;
	
	@Override
	public String createPersistanceString() throws UnsupportedException {
		throw new UnsupportedException();
	}

	@Override
	public void createFromResultSet(ResultSet rs) throws SQLException {
		UserRoleService userRoleService = new UserRoleServiceImpl();
		
		setUserId(rs.getLong("USER_ID"));
		setUserName(rs.getString("USER_NAME"));
		setUserRoles(new ArrayList<>());
		for(UserRole ur : userRoleService.searchUserRolesByUserId(getUserId())){
			getUserRoles().add(ur.getRole());
		}
		System.out.println(this.toString());
	}

}
