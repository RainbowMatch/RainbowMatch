package ch.patrickguenthard.service;

import java.util.List;

import ch.patrickguenthard.dataaccess.DataAccessConnectionInitiator;
import ch.patrickguenthard.dataaccess.DataAccessManager;
import ch.patrickguenthard.entity.NonBinaryGender;
import ch.patrickguenthard.exceptions.UnsupportedException;

public class NonBinaryGenderServiceImpl implements NonBinaryGenderService{
	private DataAccessManager<NonBinaryGender> dam = new DataAccessManager<NonBinaryGender>(DataAccessConnectionInitiator.getInstance().getConnection());

	@Override
	public List<NonBinaryGender> searchAllNonBinaryGender() {
		return dam.searchValues("SELECT * FROM TBAE_NON_BINARY_GENDER", NonBinaryGender.class);
	}

	@Override
	public void addNonBinaryGender(NonBinaryGender nbg) throws UnsupportedException{
		dam.persist(nbg);
	}
}
