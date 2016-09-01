package ch.patrickguenthard.entity.inf;

import java.sql.ResultSet;
import java.sql.SQLException;

import ch.patrickguenthard.exceptions.UnsupportedException;

/**
 * BaseEntity is an interface used in the persistance functionality of the application.
 * It includes methods for creating INSERT strings and can create a object from a resultset.
 * 
 * @author Patrick
 *
 */
public interface BaseEntity {
	public String createPersistanceString() throws UnsupportedException;
	public void createFromResultSet(ResultSet rs) throws SQLException;
}
