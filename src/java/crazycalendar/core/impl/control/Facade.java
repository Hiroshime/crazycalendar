/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazycalendar.core.impl.control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.smartcardio.Card;
import crazycalendar.core.IDAO;
import crazycalendar.core.IFacade;
import crazycalendar.core.IStrategy;
import crazycalendar.core.application.Result;
//import altair2018.core.impl.business.CalculateValuesExchange;
import crazycalendar.core.impl.business.CompleteRegisterDate;
import crazycalendar.core.impl.business.VerifyRegistered;
import crazycalendar.core.impl.dao.AddressDAO;
import crazycalendar.core.impl.dao.UserDAO;
import crazycalendar.core.impl.dao.DeviceDAO;
import crazycalendar.core.impl.dao.ReportCategoryMonthDAO;
import crazycalendar.domain.Address;
import crazycalendar.domain.Device;
//import les2017.domain.CreditCard;
//import les2017.domain.Customer;
import crazycalendar.domain.DomainEntity;
//import les2017.domain.OperationRequest;
//import les2017.domain.Order;
//import les2017.domain.Product;
import crazycalendar.domain.ReportCategoryMonth;
import crazycalendar.domain.User;


/**
 *
 * @author Luiz
 */
public class Facade implements IFacade {
    
    private Map<String,IDAO> daos;
    private Map<String,Map<String,List<IStrategy>>> brs;
    private Result result;
    
    public Facade()
    {
        //Mapas para Regas de Negocio e DAOS
        daos = new HashMap<>();
        brs = new HashMap<>();
        //Instancia dos DAOS a utilizar
        
        
        Map<String,List<IStrategy>> brsDevice = new HashMap<>();
        Map<String,List<IStrategy>> brsUser = new HashMap<>();
        
        
        
        
        UserDAO userDAO = new UserDAO();
        DeviceDAO deviceDAO = new DeviceDAO();
        
        daos.put(User.class.getName(), userDAO);
        daos.put(Device.class.getName(), deviceDAO);
/*
       //Insere os indices com nome das classes das entidades e linka com objeto do dao
        Map<String,List<IStrategy>> brsProduct = new HashMap<>();
        Map<String,List<IStrategy>> brsAddress = new HashMap<>();
        Map<String,List<IStrategy>> brsExchange = new HashMap<>();
             
        //Instancias de regras de Negocio
        CompleteRegisterDate cRegisterDt = new CompleteRegisterDate();
        VerifyRegistered vRegister = new VerifyRegistered();
        //CalculateValuesExchange cValues = new CalculateValuesExchange();
        
        
        List<IStrategy> brsSaveExchange = new ArrayList<>();
        brsSaveExchange.add(cValues);
        
        List<IStrategy> brsSaveProduct = new ArrayList<>();
        brsSaveProduct.add(cRegisterDt);
           
        brsProduct.put("SALVAR", brsSaveProduct);
        brsExchange.put("SALVAR", brsSaveExchange);
        
        
        brs.put(Product.class.getName(), brsProduct);
        brs.put(OperationRequest.class.getName(), brsExchange);
        
        DeviceDAO prodDAO = new DeviceDAO();
        AddressDAO addDAO = new AddressDAO();
        CardDAO credDAO = new CardDAO();
        UserDAO cusDAO = new UserDAO();
        ReportCategoryMonthDAO rcmDAO = new ReportCategoryMonthDAO();
        OrderDAO ordDAO = new OrderDAO();
        OperationDAO opDAO = new OperationDAO();
        
        
        daos.put(Product.class.getName(), prodDAO);
        daos.put(Address.class.getName(), addDAO);
        daos.put(CreditCard.class.getName(), credDAO);
        daos.put(ReportCategoryMonth.class.getName(), rcmDAO);
        daos.put(Customer.class.getName(), cusDAO);
        daos.put(Order.class.getName(), ordDAO);
        daos.put(OperationRequest.class.getName(), opDAO);
      */  
        
    }
    
    public Result save(DomainEntity entity)
    {
        result = new Result();
        String nmClass = entity.getClass().getName();
        
        String msg = executeRules(entity, "SALVAR");	
		if(msg == null)
                {
                    try{
			IDAO dao = daos.get(nmClass);
                        dao.save(entity);
                        List<DomainEntity> entities = new ArrayList<DomainEntity>();
                        entities.add(entity);
                        result.setEntities(entities);
                    }
                    catch(SQLException e){
                        e.printStackTrace();
                    }
		}
                else
                {
			result.setMsg(msg);
		}	
		return result;
    }
    
    /**
     * 
     * @param entity
     * @return 
     */
    @Override
    public Result change(DomainEntity entity)
    {
        result = new Result();
        String nmClass = entity.getClass().getName();
        
        String msg = null;
        
		if(msg == null)
                {
                    try{
			IDAO dao = daos.get(nmClass);
                        dao.change(entity);
                        result.addEntities(entity);
                    }
                    catch(SQLException e){
                        e.printStackTrace();
                    }
		}
                else
                {
			result.setMsg(msg);
		}	
        return result;
    }
    /**
     * 
     * @param entity
     * @return     /**
     * 
     * @param entity
     * @return 
     */
    
    
    @Override
    public Result consult(DomainEntity entity)
    {
        result = new Result();
        String nmClass = entity.getClass().getName();
        String msg = null;
        
        
        if(msg == null)
        {
            IDAO dao = daos.get(nmClass);
            try
            {
                result.setEntities(dao.consult(entity));
            }
            catch(SQLException e)
            {
                e.printStackTrace();
                result.setMsg("Não foi possivel realizar consulta");
            }
            
        }
        return result;
    }
    
    @Override
    public Result view(DomainEntity entity)
    {
        result = new Result();
        String nmClass = entity.getClass().getName();
        String msg = null;
        
        if(msg == null)
        {
            IDAO dao = daos.get(nmClass);
            try
            {
                
                result.addEntities(dao.view(entity));
            }
            catch(SQLException e)
            {
                e.printStackTrace();
                result.setMsg("Não foi possivel realizar consulta");
            }
            
        }
        return result;
    }
   
    
    /**
     * 
     * @param entity
     * @return 
     */
    @Override
    public Result delete(DomainEntity entity)
    {

        result = new Result();
        String nmClass = entity.getClass().getName();
        String msg = null;
        
        if(msg == null)
        {
            try
            {
                IDAO dao = daos.get(nmClass);
                dao.delete(entity);
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            result.setMsg(msg);
        }
        
        
        return result;
    }
    
    
    public String executeRules(DomainEntity entity, String operation)
    {
        String nmClass = entity.getClass().getName();
        StringBuilder msg = new StringBuilder();
        
        Map<String, List<IStrategy>> operationRules = brs.get(nmClass);
        
        if(operationRules != null)
        {
            List<IStrategy> rules = operationRules.get(operation);
            for(IStrategy s: rules)
            {
                String m = s.process(entity);
                
                if(m != null)
                {
                    msg.append(m);
                    msg.append("\n");
                }
            }
        }
        
        if(msg.length()>0)
            return msg.toString();
        else
            return null;
    }
    
}
