/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazycalendar.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import crazycalendar.domain.DomainEntity;
import crazycalendar.domain.User;

/**
 *
 * @author Luiz
 */
public class UserDAO extends AbstractJdbcDAO {
    
    public UserDAO()
    {
        super("tb_user","id");
    }
    
    public void save(DomainEntity entity)
    {/*
        openConnection();
        PreparedStatement pst=null;
        Customer customer = (Customer)entity;
        
        try 
        {
		connection.setAutoCommit(false);			
		StringBuilder sql = new StringBuilder();			
		
                //INSERT DE CONTATOS EMERGENCIAIS
                sql.append("INSERT INTO tb_customer(name,dt_birth,CPF,email,password,dt_reg,RG,telephone) VALUES (?,?,?,?,?,?,?,?)");
                pst = connection.prepareStatement(sql.toString());
                
                pst.setString(1, customer.getName());
                java.sql.Date dateSQL = new java.sql.Date(customer.getDtCadastro().getTime());
                pst.setDate(2, dateSQL);
                pst.setString(3, customer.getCPF());
                pst.setString(4, customer.getEmail());
                pst.setString(5, customer.getPassword());
                dateSQL = new java.sql.Date(customer.getDtBrith().getTime());
                pst.setDate(6, dateSQL);
                pst.setString(7, customer.getRG());
                pst.setString(8, customer.getTelefone());
                pst.executeUpdate();			
		connection.commit();
                
    
               		
	} 
        catch (SQLException e) 
        {
			try 
                        {
				connection.rollback();
			} 
                        catch (SQLException e1) 
                        {
				e1.printStackTrace();
			}
			e.printStackTrace();			
	}
        finally
        {
			try 
                        {
				pst.close();
				connection.close();
			} 
                        catch (SQLException e) 
                        {
				e.printStackTrace();
			}
	}
    */}
    
    public DomainEntity view (DomainEntity entity)
    {
        PreparedStatement pst =null;
        String sql = null;
        User user = (User)entity;
        
        sql = "SELECT id,"
                + "username,"
                + "name,"
                + "email,"
                + "password,"
                + "dt_registro"
                + " FROM tb_user "
                + "WHERE username=? "
                + "AND "
                + "password=?";

        try
        {
            openConnection();
            pst = connection.prepareStatement(sql);
            if(!user.getUsername().equals(""))
            {
                pst.setString(1, user.getUsername());
                pst.setString(2, user.getPassword());
            }
            
            ResultSet reset = pst.executeQuery();
             while(reset.next())
            {
                user = new User();
                user.setId(reset.getInt("id"));
                user.setUsername(reset.getString("username"));
                user.setName(reset.getString("name"));
                user.setEmail(reset.getString("email"));
                java.sql.Date dtGenerica = reset.getDate("dt_registro");
                Date dtNormal = new Date(dtGenerica.getTime());
                user.setDtCadastro(dtNormal);
                return user;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return null;
     
    }
    
    public List<DomainEntity> consult (DomainEntity entity)
    {
        return null;
    }
    
    public void change(DomainEntity entity)
    {
        
    }
}
