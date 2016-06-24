package ch.patrickguenthard.service;

import java.util.List;

import ch.patrickguenthard.entity.Match;
import ch.patrickguenthard.entity.User;

public interface MatchService {
	public List<Match> listRequestedByUser(User usr);
	public List<Match> listApprovesByUser(User usr);
	public Match searchById(Long id);
	public void approveMatch(Match match);
	public void addMatch(Match match);
}
