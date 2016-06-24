package ch.patrickguenthard.service;

import java.util.List;

import ch.patrickguenthard.entity.Match;

public interface MatchService {
	public List<Match> listRequestedByUser(Long userId);
	public List<Match> listApprovesByUser(Long userId);
	public Match searchById(Long id);
	public void approveMatch(Match match);
	public void addMatch(Match match);
}
