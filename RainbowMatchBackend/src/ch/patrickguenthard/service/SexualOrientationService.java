package ch.patrickguenthard.service;

import java.util.List;

import ch.patrickguenthard.entity.SexualOrientation;

public interface SexualOrientationService {
	public List<SexualOrientation> searchAllSexualOrientation();
	public SexualOrientation getSexualOrientationById(Long id);
}
