package ch.patrickguenthard.dataaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ch.patrickguenthard.entity.inf.BaseEntity;
import ch.patrickguenthard.entity.inf.EntityFactory;
import ch.patrickguenthard.exceptions.UnsupportedException;

public class DataAccessManager<E extends BaseEntity> {
    private Connection conn;
	
    public DataAccessManager(Connection conn){
	this.conn = conn;
    }
	
    public boolean persist(E obj) throws UnsupportedException{
	try {
	    Statement stmt = conn.createStatement();
	    stmt.executeUpdate(obj.createPersistanceString());
	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}
	return true;
    }
	
    @SuppressWarnings("unchecked")
    public List<E> searchValues(String query, Class<E> clss){
	List<E> results = new ArrayList<>();
	Statement stmt;
	ResultSet rs;
	try {
	    stmt = conn.createStatement();
	    rs = stmt.executeQuery(query);
	    while(rs.next()){
		BaseEntity tmp = EntityFactory.createEmptyEntity(clss);
		tmp.createFromResultSet(rs);
		results.add((E)tmp);
	    }
			
	} catch (SQLException e) {
	    e.printStackTrace();
	    return null;
	}
	return results;
		
    }
	
}
