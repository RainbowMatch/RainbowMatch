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
public class Profile implements BaseEntity{

    private Long profileId;
    private Long userId;
    private Float gender;
    private boolean nonBinaryGender;
    private Long nonBinaryGenderId;
    private String biography;
    private String profilePicture;
	
    @Override
    public String createPersistanceString() {
    	return "INSERT INTO TBAE_PROFILE (USER_ID, GENDER, NON_BINARY_GENDER, "
    			+ "NON_BINARY_GENDER_ID, BIOGRAPHY,PROFILE_IMAGE) "
    			+ "VALUE("+userId+", "+gender+"," + (nonBinaryGender ? 1 : 0)
    			+ ", " + nonBinaryGenderId +", '"+biography+"','"+profilePicture+"')";
    }

    @Override
    public void createFromResultSet(ResultSet rs) throws SQLException {
		this.profileId = rs.getLong("PROFILE_ID");
		this.userId = rs.getLong("USER_ID");
		this.gender = rs.getFloat("GENDER");
		int nb = rs.getInt("NON_BINARY_GENDER");
		this.nonBinaryGender = nb == 1;
		this.nonBinaryGenderId = rs.getLong("NON_BINARY_GENDER_ID");
		this.biography = rs.getString("BIOGRAPHY");
		this.profilePicture = rs.getString("PROFILE_PICTURE");
    }
}
