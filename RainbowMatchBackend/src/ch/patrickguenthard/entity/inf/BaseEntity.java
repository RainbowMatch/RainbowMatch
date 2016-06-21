package ch.patrickguenthard.entity.inf;

import java.sql.ResultSet;
import java.sql.SQLException;

import ch.patrickguenthard.exceptions.UnsupportedException;

public interface BaseEntity {
	public String createPersistanceString() throws UnsupportedException;
	public void createFromResultSet(ResultSet rs) throws SQLException;
}
