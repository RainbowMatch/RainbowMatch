package ch.patrickguenthard.service;

import java.util.List;

import ch.patrickguenthard.entity.Region;
import ch.patrickguenthard.exceptions.UnsupportedException;

public interface RegionService {
	public List<Region> searchAllRegion();
	
	public Region getRegionById(Long id);
	
	public void addRegion(Region region) throws UnsupportedException;
}
