package ch.patrickguenthard.service;

import ch.patrickguenthard.entity.Profile;
import ch.patrickguenthard.exceptions.UnsupportedException;

public interface ProfileService {
	public Profile getProfileByUser(Long usrid);
	public void addProfile(Profile prof) throws UnsupportedException;
	public void updateProfile(Profile prof) throws UnsupportedException;
}
