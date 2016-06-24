package ch.patrickguenthard.service;

import java.util.List;

import ch.patrickguenthard.entity.NonBinaryGender;
import ch.patrickguenthard.exceptions.UnsupportedException;

public interface NonBinaryGenderService {
	public List<NonBinaryGender> searchAllNonBinaryGender();
	public void addNonBinaryGender(NonBinaryGender nbg) throws UnsupportedException;
}
