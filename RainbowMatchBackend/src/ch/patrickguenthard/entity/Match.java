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
public class Match implements BaseEntity{

    private Long matchId;
    private Long requestUserId;
	private Long matchedUserId;
    private Boolean approved;
    
    @Override
    public String createPersistanceString() {
    	return "INSERT INTO TBAE_MATCH (REQUEST_USER_ID) VALUE("+requestUserId
    			+", "+matchedUserId+", "+(approved ? 1 : 0)+")";
    }

    @Override
    public void createFromResultSet(ResultSet rs) throws SQLException {
    	this.matchId = rs.getLong("MATCH_ID");
    	this.requestUserId = rs.getLong("REQUEST_USER_ID");
    	this.matchedUserId = rs.getLong("MATCHED_USER_ID");
    	int ap = rs.getInt("APPROVED");
    	this.approved = ap == 1;
    }
}
