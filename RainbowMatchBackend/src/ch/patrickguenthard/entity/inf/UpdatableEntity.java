package ch.patrickguenthard.entity.inf;

/**
 * This class extends BaseEntity with the functionality to update entities
 * @author Patrick
 *
 */
public interface UpdatableEntity extends BaseEntity{
	public String createUpdateString();
}
