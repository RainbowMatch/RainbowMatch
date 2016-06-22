package ch.patrickguenthard.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;

import ch.patrickguenthard.entity.inf.BaseEntity;
import ch.patrickguenthard.entity.inf.DeletableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements DeletableEntity{
	
    private Long userId;
    private String userName;
    private String userPassword;
	
    @Override
    public String createPersistanceString() {
	String str = "INSERT INTO TBAE_USER(USER_NAME, USER_PASSWORD) VALUE('"+userName+"','"+userPassword+"');";
	System.out.println(str);
	return str;
    }
	
    @Override
    public void createFromResultSet(ResultSet rs) throws SQLException {

		
	this.userId = rs.getLong("USER_ID");
	this.userName = rs.getString("USER_NAME");
	this.userPassword = rs.getString("USER_PASSWORD");
		
    }

	@Override
	public String createDeleteString() {
		if(userId == null){
			throw new NullPointerException();
		}
		return "DELETE FROM TBAE_USER WHERE USER_ID = "+ userId;
	}

}
