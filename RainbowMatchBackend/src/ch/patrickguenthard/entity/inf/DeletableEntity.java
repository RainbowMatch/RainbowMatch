package ch.patrickguenthard.entity.inf;

/**
 * adds possibility to create a delete string for a entity
 * @author Patrick
 *
 */
public interface DeletableEntity extends BaseEntity {
	public String createDeleteString();
}
