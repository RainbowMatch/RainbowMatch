package ch.patrickguenthard.service;

import java.util.List;

import ch.patrickguenthard.dataaccess.DataAccessConnectionInitiator;
import ch.patrickguenthard.dataaccess.DataAccessManager;
import ch.patrickguenthard.entity.Match;
import ch.patrickguenthard.entity.User;
import ch.patrickguenthard.entity.UserDetail;

public class MatchServiceImpl implements MatchService {

	private DataAccessManager<Match> dam = new DataAccessManager<>(DataAccessConnectionInitiator.getInstance().getConnection());
	
	@Override
	public List<Match> listRequestedByUser(User usr) {
		return dam.searchValues("SELECT * FROM TBAE_MATCH WHERE APPROVED = 1 AND REQUEST_USER_ID = "+usr.getUserId(), Match.class);
	}

	@Override
	public List<Match> listApprovesByUser(User usr) {
		return dam.searchValues("SELECT * FROM TBAE_MATCH WHERE APPROVED = 1 AND MATCHED_USER_ID = "+usr.getUserId(), Match.class);
	}

	@Override
	public Match searchById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void approveMatch(Match match) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void addMatch(Match match) {
		// TODO Auto-generated method stub
		
	}

}
