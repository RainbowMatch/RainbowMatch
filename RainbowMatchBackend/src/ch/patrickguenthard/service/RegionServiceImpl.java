package ch.patrickguenthard.service;

import java.util.List;

import ch.patrickguenthard.dataaccess.DataAccessConnectionInitiator;
import ch.patrickguenthard.dataaccess.DataAccessManager;
import ch.patrickguenthard.entity.Region;
import ch.patrickguenthard.exceptions.UnsupportedException;

public class RegionServiceImpl implements RegionService {

	private DataAccessManager<Region> dam = new DataAccessManager<>(DataAccessConnectionInitiator.getInstance().getConnection());
	
	@Override
	public List<Region> searchAllRegion() {
		return dam.searchValues("SELECT * FROM TBAE_REGION", Region.class);
	}
	
	@Override
	public Region getRegionById(Long id){
		try {
			return dam.searchValues("SELECT * FROM TBAE_REGION", Region.class).get(0);
		} catch(IndexOutOfBoundsException ex) {
			return null;
		}
	}

	@Override
	public void addRegion(Region region) throws UnsupportedException{
		dam.persist(region);
	}

}
