/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazycalendar.core.impl.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import altair2018.domain.Category;
import altair2018.domain.Device;
import altair2018.domain.DomainEntity;
import altair2018.domain.HostStatus;
import altair2018.domain.Location;
import altair2018.domain.Manufactor;
import altair2018.domain.Owner;
import altair2018.domain.Status;
import altair2018.domain.SupportTeam;
import altair2018.domain.Type;


/**
 *
 * @author Luiz
 */
public class DeviceDAO extends AbstractJdbcDAO {
    
    public DeviceDAO()
    {
        super("tb_device", "id");
    }
    
    public void save(DomainEntity entity)
    {
       /* openConnection();
        PreparedStatement pst=null;
        Product product = (Product)entity;
        
        try 
        {
		connection.setAutoCommit(false);			
		StringBuilder sql = new StringBuilder();			
		
                //INSERT DE CONTATOS EMERGENCIAIS
                sql.append("INSERT INTO tb_product(name,description,nutritionTable,id_category,id_brand,dt_reg,price,quantity) VALUES (?,?,?,?,?,?,?,?)");
                pst = connection.prepareStatement(sql.toString());
                pst.setString(1, product.getName());
                pst.setString(2, product.getDescription());
                pst.setString(3, product.getNutritionTable());
                pst.setInt(4, product.getCategory().getId());
                pst.setInt(5, product.getBrand().getId());
                java.sql.Date dateSQL = new java.sql.Date(product.getDtCadastro().getTime());
                pst.setDate(6, dateSQL);
                pst.setDouble(7, product.getPrice());
                pst.setInt(8, product.getQuantity());
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
    
    /**
     * 
     * @param entity 
     */    
    @Override
    public void change(DomainEntity entity)
    {
       /* openConnection();
        PreparedStatement pst = null;
        Product product = (Product)entity;
        
        try
        {
            connection.setAutoCommit(false);
            
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE tb_product SET"
                    + " name=?, "
                    + " description=?, "
                    + "nutritionTable=?, "
                    + "id_category=?, "
                    + "id_brand=?, "
                    + "price=? "
                    + " WHERE id=? ");
            
            pst = connection.prepareStatement(sql.toString());
            pst.setString(1, product.getName());
            pst.setString(2, product.getDescription());
            pst.setString(3, product.getNutritionTable());
            pst.setInt(4, product.getCategory().getId());
            pst.setInt(5, product.getBrand().getId());
            pst.setDouble(6, product.getPrice());
            pst.setInt(7, product.getId());
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
        
   */ }
    /**
     * 
     * @param entity
     * @return List of entities
     */
    @Override
    public List<DomainEntity> consult(DomainEntity entity)
    {
        
       PreparedStatement pst =null;
        String sql = null;
        Device device = (Device)entity;
        List<DomainEntity> devices = new ArrayList<>();
        openConnection();
        ResultSet reset = null;
        
        try
        {
            if(device.getOwner() == null || device.getOwner().getName().equals(""))
            {
                sql = "SELECT dev.id,"
                        + "dev.hostname,"
                        + "dev.dt_reg,"
                        + "dev.serial,"
                        + "dev.ip_address,"
                        + "dev.note, "
                        + "own.name, "
                        + "man.name, "
                        + "st.name, "
                        + "sup.name,"
                        + "typ.name, "
                        + "hos.name, "
                        + "loc.name "
                        + "FROM (tb_device as dev) "
                        + "INNER JOIN (tb_owner as own) ON (dev.owner_id = own.id) "
                        + "INNER JOIN (tb_manufactor as man) ON (dev.manufactor_id = man.id) "
                        + "INNER JOIN (tb_status as st) ON (dev.status_id = st.id) "
                        + "INNER JOIN (tb_supteam as sup) ON (dev.supteam_id = sup.id) "
                        + "INNER JOIN (tb_type as typ) ON (dev.type_id = typ.id) "
                        + "INNER JOIN (tb_hoststats as hos) ON (dev.hoststats_id = hos.id)"
                        + "INNER JOIN (tb_location as loc) ON (dev.location_id = loc.id)";

                pst = connection.prepareStatement(sql);
            }
            else
            {
                sql = "SELECT dev.id,"
                        + "dev.hostname,"
                        + "dev.dt_reg,"
                        + "dev.serial,"
                        + "dev.ip_address,"
                        + "dev.note, "
                        + "own.name, "
                        + "man.name, "
                        + "st.name, "
                        + "sup.name,"
                        + "typ.name, "
                        + "hos.name, "
                        + "loc.name "
                        + "FROM (tb_device as dev) "
                        + "INNER JOIN (tb_owner as own) ON (dev.owner_id = own.id) "
                        + "INNER JOIN (tb_manufactor as man) ON (dev.manufactor_id = man.id) "
                        + "INNER JOIN (tb_status as st) ON (dev.status_id = st.id) "
                        + "INNER JOIN (tb_supteam as sup) ON (dev.supteam_id = sup.id) "
                        + "INNER JOIN (tb_type as typ) ON (dev.type_id = typ.id) "
                        + "INNER JOIN (tb_hoststats as hos) ON (dev.hoststats_id = hos.id) "
                        + "INNER JOIN (tb_location as loc) ON (dev.location_id = loc.id)"
                        + "WHERE own.name = ?";
               
                pst = connection.prepareStatement(sql);
                pst.setString(1, device.getOwner().getName());
            }
            
            
            reset = pst.executeQuery();
            
            
            while(reset.next()) {
                Device dev = new Device();
                dev.setId(reset.getInt("dev.id"));
                dev.setHostname(reset.getString("dev.hostname"));;
                java.sql.Date dtGenerica = reset.getDate("dev.dt_reg");
                Date dtNormal = new Date(dtGenerica.getTime());
                dev.setSerial(reset.getString("dev.serial"));
                dev.setIpAddress(reset.getString("dev.ip_address"));
                Owner owner = new Owner();
                owner.setName(reset.getString("own.name"));
                Manufactor manufactor = new Manufactor();
                manufactor.setName(reset.getString("man.name"));
                Status status = new Status();
                status.setName(reset.getString("st.name"));
                SupportTeam spteam = new SupportTeam();
                spteam.setName(reset.getString("sup.name"));
                Type type = new Type();
                type.setName(reset.getString("typ.name"));
                HostStatus hoststatus = new HostStatus();
                hoststatus.setName(reset.getString("hos.name"));
                Location location = new Location();
                location.setName(reset.getString("loc.name"));
                dev.setOwner(owner);
                dev.setManufactor(manufactor);
                dev.setStatus(status);
                dev.setSupteam(spteam);
                dev.setType(type);
                dev.setHoststats(hoststatus);
                dev.setLocation(location);
                devices.add(dev);
                
            }
            
            return devices;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }
    
    
    
    public DomainEntity view(DomainEntity entity)
    {
        
        PreparedStatement pst =null;
        String sql = null;
        Device device = (Device)entity;
        
        

        try
        {
            openConnection();
            
            if(device.getId() != null && device.getId() > 0)
            {
                sql = "SELECT dev.id,"
                        + "dev.hostname,"
                        + "dev.dt_reg,"
                        + "dev.serial,"
                        + "dev.ip_address,"
                        + "dev.note, "
                        + "own.name, "
                        + "man.name, "
                        + "st.name, "
                        + "sup.name,"
                        + "typ.name, "
                        + "hos.name, "
                        + "loc.name "
                        + "FROM (tb_device as dev) "
                        + "INNER JOIN (tb_owner as own) ON (dev.owner_id = own.id) "
                        + "INNER JOIN (tb_manufactor as man) ON (dev.manufactor_id = man.id) "
                        + "INNER JOIN (tb_status as st) ON (dev.status_id = st.id) "
                        + "INNER JOIN (tb_supteam as sup) ON (dev.supteam_id = sup.id) "
                        + "INNER JOIN (tb_type as typ) ON (dev.type_id = typ.id) "
                        + "INNER JOIN (tb_hoststats as hos) ON (dev.hoststats_id = hos.id) "
                        + "INNER JOIN (tb_location as loc) ON (dev.location_id = loc.id)"
                        + "WHERE dev.id = ?";
                
                pst = connection.prepareStatement(sql);
                pst.setInt(1, device.getId());
            }
            
            ResultSet reset = pst.executeQuery();
             while(reset.next())
            {
                Device dev = new Device();
                dev.setId(reset.getInt("dev.id"));
                dev.setHostname(reset.getString("dev.hostname"));;
                java.sql.Date dtGenerica = reset.getDate("dev.dt_reg");
                Date dtNormal = new Date(dtGenerica.getTime());
                dev.setSerial(reset.getString("dev.serial"));
                dev.setIpAddress(reset.getString("dev.ip_address"));
                Owner owner = new Owner();
                owner.setName(reset.getString("own.name"));
                Manufactor manufactor = new Manufactor();
                manufactor.setName(reset.getString("man.name"));
                Status status = new Status();
                status.setName(reset.getString("st.name"));
                SupportTeam spteam = new SupportTeam();
                spteam.setName(reset.getString("sup.name"));
                Type type = new Type();
                type.setName(reset.getString("typ.name"));
                HostStatus hoststatus = new HostStatus();
                hoststatus.setName(reset.getString("hos.name"));
                Location location = new Location();
                location.setName(reset.getString("loc.name"));
                dev.setOwner(owner);
                dev.setManufactor(manufactor);
                dev.setStatus(status);
                dev.setSupteam(spteam);
                dev.setType(type);
                dev.setHoststats(hoststatus);
                dev.setLocation(location);
                
                
                return dev;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return null;
        
        
    }
}
