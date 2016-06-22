package ch.patrickguenthard.dataaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ch.patrickguenthard.entity.inf.BaseEntity;
import ch.patrickguenthard.entity.inf.DeletableEntity;
import ch.patrickguenthard.entity.inf.EntityFactory;
import ch.patrickguenthard.entity.inf.UpdatableEntity;
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
    
    public boolean update(E obj) throws UnsupportedException {
		if(obj instanceof UpdatableEntity){
			try {
			    Statement stmt = conn.createStatement();
			    stmt.executeUpdate( ((UpdatableEntity)obj).createUpdateString());
			    return false;
			} catch (SQLException e) {
			    e.printStackTrace();
			}
		} else {
			throw new UnsupportedException("This entity is not updatable");
		}
    	return false;
    }
	
    public boolean delete(E obj) throws UnsupportedException{
    	if(obj instanceof DeletableEntity){
    		try {
			    Statement stmt = conn.createStatement();
			    stmt.executeUpdate( ((DeletableEntity)obj).createDeleteString());
			    return false;
			} catch (SQLException e) {
			    e.printStackTrace();
			}
    	} else {
    		throw new UnsupportedException();
    	}
    	return false;
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
