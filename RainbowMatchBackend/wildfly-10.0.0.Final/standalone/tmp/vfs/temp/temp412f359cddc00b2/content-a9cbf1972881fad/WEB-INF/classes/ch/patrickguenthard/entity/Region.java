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
public class Region implements BaseEntity{

    private Long regionId;
    private String region;
	
    @Override
    public String createPersistanceString() {
    	return "INSERT INTO TBAE_REGION (REGION) VALUE('"+region+"')";
    }

    @Override
    public void createFromResultSet(ResultSet rs) throws SQLException {
    	this.regionId = rs.getLong("REGION_ID");
    	this.region = rs.getString("REGION");
    }
}
