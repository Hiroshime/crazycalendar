/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazycalendar.core.impl.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;


import crazycalendar.core.IDAO;
import crazycalendar.domain.DomainEntity;
import crazycalendar.core.util.Conection;
/**
 *
 * @author Luiz
 */
public abstract class AbstractJdbcDAO implements IDAO{
    protected Connection connection;
    protected String table;
    protected String idTable;
    protected boolean ctrlTransaction=true;
    
    
    public AbstractJdbcDAO(Connection connection, String table, String idTable)
    {
        this.table = table;
        this.idTable =idTable;
        this.connection = connection;
    }
    
    public AbstractJdbcDAO(String table,String idTable){
        this.table = table;
        this.idTable = idTable;
    }
    
    @Override
    public void delete(DomainEntity entity){
        openConnection();
        PreparedStatement pst = null;
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(table);
        sb.append(" WHERE ");
        sb.append(idTable);
        sb.append("=");
        sb.append("?");
        
        try {
			connection.setAutoCommit(false);
			pst = connection.prepareStatement(sb.toString());
			pst.setInt(1, entity.getId());

			pst.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			
		}finally{
			
			try {
				pst.close();
				if(ctrlTransaction)
				connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
    }
    
    protected void openConnection(){
        try 
        {	
            if(connection == null || connection.isClosed())
            connection = Conection.getConnection();
        } 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
	} 
        catch (SQLException e) 
        {
            e.printStackTrace();
		
        }
    }
    
}
