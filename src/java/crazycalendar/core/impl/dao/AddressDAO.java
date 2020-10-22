/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazycalendar.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import crazycalendar.domain.Address;
import crazycalendar.domain.City;
import crazycalendar.domain.DomainEntity;
import crazycalendar.domain.State;

/**
 *
 * @author Luiz
 */
public class AddressDAO extends AbstractJdbcDAO{
    
    public AddressDAO()
    {
        super("tb_address","id");
    }
    
    
    public void save(DomainEntity entity)
    {
        openConnection();
        PreparedStatement pst=null;
        Address address = (Address)entity;
        
        try 
        {
		connection.setAutoCommit(false);			
		StringBuilder sql = new StringBuilder();			

                sql.append("INSERT INTO tb_address(street,number,zip_code,id_city,id_customer,destinatary) VALUES (?,?,?,?,?,?)");
                pst = connection.prepareStatement(sql.toString());
                pst.setString(1, address.getStreet());
                pst.setInt(2, address.getNumber());
                pst.setString(3, address.getZip());
                pst.setInt(4, address.getState().getCity().getId());
                pst.setInt(5, address.getId());
                pst.setString(6, address.getDestinatary());
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
        
        
    }
    
    public DomainEntity view(DomainEntity entity)
    {
        PreparedStatement pst =null;
        String sql = null;
        Address address = (Address)entity;
        City city;
        State state;
        
        sql = "select adr.id,"
                    + "adr.street,"
                    + "adr.number,"
                    + "adr.complement,"
                    + "adr.zip_code,"
                    + "adr.destinatary,"
                    + "ct.id,"
                    + "ct.nome,"
                    + "st.id,"
                    + "st.uf from (tb_address as adr) "
                    + "inner join (tb_cidade as ct) on (adr.id_city = ct.id) "
                    + "inner join (tb_estado as st) on (ct.id_estado = st.id) "
                    + "WHERE adr.id = ?";

        try
        {
            openConnection();
            pst = connection.prepareStatement(sql);
            pst.setInt(1, address.getId());
            
            ResultSet reset = pst.executeQuery();
            List<DomainEntity> addresses = new ArrayList<>();
            while(reset.next())
            {
                address = new Address();
                address.setId(reset.getInt("adr.id"));
                address.setStreet(reset.getString("adr.street"));
                address.setNumber(reset.getInt("adr.number"));
                address.setComplement(reset.getString("adr.complement"));
                address.setZip(reset.getString("adr.zip_code"));
                address.setDestinatary(reset.getString("adr.destinatary"));
                city = new City();
                city.setId(reset.getInt("ct.id"));
                city.setName(reset.getString("ct.nome"));
                state = new State();
                state.setCity(city);
                state.setId(reset.getInt("st.id"));
                state.setFu(reset.getString("st.uf"));
                address.setState(state);
                return address;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }
    
    public List<DomainEntity> consult(DomainEntity entity)
    {  
        PreparedStatement pst =null;
    
        String sql = null;
        Address address = (Address)entity;
        City city;
        State state;

            sql = "select adr.id,"
                    + "adr.street,"
                    + "adr.number,"
                    + "adr.complement,"
                    + "adr.zip_code,"
                    + "adr.destinatary,"
                    + "ct.id,"
                    + "ct.nome,"
                    + "st.id,"
                    + "st.uf from (tb_address as adr) "
                    + "inner join (tb_cidade as ct) on (adr.id_city = ct.id) "
                    + "inner join (tb_estado as st) on (ct.id_estado = st.id) "
                    + "WHERE adr.id_customer = ?";
                          
        try
        {
            openConnection();
            pst = connection.prepareStatement(sql);
            pst.setInt(1, address.getId());
            
            ResultSet reset = pst.executeQuery();
            List<DomainEntity> addresses = new ArrayList<>();
            while(reset.next())
            {
                address = new Address();
                address.setId(reset.getInt("adr.id"));
                address.setStreet(reset.getString("adr.street"));
                address.setNumber(reset.getInt("adr.number"));
                address.setComplement(reset.getString("adr.complement"));
                address.setZip(reset.getString("adr.zip_code"));
                address.setDestinatary(reset.getString("adr.destinatary"));
                city = new City();
                city.setId(reset.getInt("ct.id"));
                city.setName(reset.getString("ct.nome"));
                state = new State();
                state.setCity(city);
                state.setId(reset.getInt("st.id"));
                state.setFu(reset.getString("st.uf"));
                address.setState(state);
                addresses.add(address);
                
            }
        return addresses;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public void change(DomainEntity entity)
    {
        
    }
}
