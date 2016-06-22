package ch.patrickguenthard.service;

import java.util.List;

import ch.patrickguenthard.dataaccess.DataAccessConnectionInitiator;
import ch.patrickguenthard.dataaccess.DataAccessManager;
import ch.patrickguenthard.entity.SexualOrientation;

public class SexualOrientationServiceImpl implements SexualOrientationService {

	private DataAccessManager<SexualOrientation> dam = new DataAccessManager<SexualOrientation>(DataAccessConnectionInitiator.getInstance().getConnection());
	
	@Override
	public List<SexualOrientation> searchAllSexualOrientation() {
		return dam.searchValues("SELECT * FROM TBAE_SEXUAL_ORIENTATION", SexualOrientation.class);
	}

	@Override
	public SexualOrientation getSexualOrientationById(Long id) {
		try {
			return dam.searchValues("SELECT * FROM TBAE_SEXUAL_ORIENTATION", SexualOrientation.class).get(0);
		} catch (IndexOutOfBoundsException ex){
			ex.printStackTrace();
			return null;
		}
	}

}
