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
public class SexualOrientation implements BaseEntity{

    private Long sexualOrientationId;
    private String orientationDescription;
	
    @Override
    public String createPersistanceString() {
    	return "INSERT INTO TBAE_SEXUAL_ORIENTATION (ORIENTATION_DESCRIPTION) VALUE('"+orientationDescription+"')";
    }

    @Override
    public void createFromResultSet(ResultSet rs) throws SQLException {
    	this.sexualOrientationId = rs.getLong("SEXUAL_ORIENTATION_ID");
    	this.orientationDescription = rs.getString("ORIENTATION_DESCRIPTION");
    }
}
