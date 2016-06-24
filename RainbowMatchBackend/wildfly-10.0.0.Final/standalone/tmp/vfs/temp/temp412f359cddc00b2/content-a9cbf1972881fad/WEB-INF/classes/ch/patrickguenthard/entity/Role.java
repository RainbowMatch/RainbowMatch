package ch.patrickguenthard.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;

import ch.patrickguenthard.entity.inf.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Role implements BaseEntity{

    private Long roleId;
    private String roleName;
	
    @Override
    public String createPersistanceString() {
	return "INSERT INTO TBAE_ROLE (ROLE_NAME) VALUE('"+roleName+"')";
    }

    @Override
    public void createFromResultSet(ResultSet rs) throws SQLException {
	this.roleId = rs.getLong("ROLE_ID");
	this.roleName = rs.getString("ROLE_NAME");
    }
}
