package ch.patrickguenthard.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;

import ch.patrickguenthard.entity.inf.BaseEntity;
import ch.patrickguenthard.service.RoleService;
import ch.patrickguenthard.service.RoleServiceImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class UserRole implements BaseEntity{

	private Long userRoleId;
	private Long userId;
	private Long roleId;
	private Role role;
	
	
	@Override
	public String createPersistanceString() {
		return "INSERT INTO TBAE_USER_ROLE (USER_ID,ROLE_ID) VALUE("+userId+","+roleId+")";
	}

	@Override
	public void createFromResultSet(ResultSet rs) throws SQLException {
		RoleService roleService = new RoleServiceImpl(); 
		this.userRoleId = rs.getLong("USER_ROLE_ID");
		this.roleId = rs.getLong("ROLE_ID");
		this.userId = rs.getLong("USER_ID");
		this.role = roleService.searchById(this.roleId);
	}
	
	
	
}
