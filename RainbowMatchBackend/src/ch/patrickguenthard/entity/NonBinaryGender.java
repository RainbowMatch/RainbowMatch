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
public class NonBinaryGender implements BaseEntity{

    private Long nonBinaryGenderId;
    private String genderDescription;
	
    @Override
    public String createPersistanceString() {
    	return "INSERT INTO TBAE_NON_BINARY_GENDER (GENDER_DESCRIPTION) VALUE('"+genderDescription+"')";
    }

    @Override
    public void createFromResultSet(ResultSet rs) throws SQLException {
    	this.nonBinaryGenderId = rs.getLong("NON_BINARY_GENDER_ID");
    	this.genderDescription = rs.getString("GENDER_DESCRIPTION");
    }
}
