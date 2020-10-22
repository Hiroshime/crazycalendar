/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altair2018.control.web.vh.impl;

import java.awt.Image;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import altair2018.control.web.vh.IViewHelper;
import altair2018.core.application.Result;
import altair2018.domain.Category;
import altair2018.domain.Device;
import altair2018.domain.DomainEntity;
import altair2018.domain.Location;
import altair2018.domain.Manufactor;
import altair2018.domain.OperationalSystem;
import altair2018.domain.Owner;
import altair2018.domain.Type;

/**
 *
 * @author Luiz
 */
public class CreateDeviceViewHelper implements IViewHelper{
    
    
    /**
     * Metodo que pega a request http e retira dela
     * os dados de aluno criando um objeto com tais informações
     * @param request HTTP
     * @return OBJETO DE ALUNO
     */
    public DomainEntity getEntity(HttpServletRequest request)
    {
        String operation = request.getParameter("operacao");
        Device device  = null;
        
        if(operation.equals("SALVAR"))
        {
            String hostname = request.getParameter("txtHostname");
            String serial = request.getParameter("txtSerial");
            String ip_address = request.getParameter("txtIpaddress");
            Type type = new Type();
            type.setId(Integer.parseInt(request.getParameter("sctType")));
            Location location = new Location();
            location.setId(Integer.parseInt(request.getParameter("sctLocation")));
            Manufactor manufactor = new Manufactor();
            manufactor.setId(Integer.parseInt(request.getParameter("sctManufactor")));
            OperationalSystem os = new OperationalSystem();
            os.setId(Integer.parseInt(request.getParameter("sctOperationalSystem")));
            Owner owner = new Owner();
            owner.setId(Integer.parseInt(request.getParameter("sctOwner")));
            
            device.setHostname(hostname);
            device.setIpAddress(ip_address);
            device.setSerial(serial);
            device.setType(type);
            device.setLocation(location);
            device.setManufactor(manufactor);
            device.setOs(os);
            device.setOwner(owner);

        }
        /*
        if(operation.equals("CONSULTAR")  )
        {
            String hostname = request.getParameter("txtName");
            
            device  = new Device();
            
            device.setHostname(hostname);
            
            
        }
        
        if(operation.equals("EXCLUIR"))
        {
            int id = Integer.parseInt(request.getParameter("produto"));
            device = new Device();
            
            device.setId(id);
        }
        
        if(operation.equals("VISUALIZAR"))
        {
            String name = request.getParameter("produto").replaceAll("_", " ");
            device = new Device();
            device.setHostname(name);
        }
        
        if(operation.equals("ALTERAR"))
        {
            Brand brand;
            Category category;
            Result res;
            res = (Result)request.getSession().getAttribute("result");
            product = (Product)res.getEntities().get(0);
            
            if(!request.getParameter("txtName").equals("")){
                String name = request.getParameter("txtName");
                product.setName(name);
            }
            if(!request.getParameter("txtDescription").equals(""))
            {
                String description = request.getParameter("txtDescription");
                product.setDescription(description);
            }
            
            if(!request.getParameter("txtPrice").equals(""))
            {
                double price = Double.parseDouble(request.getParameter("txtPrice"));
                product.setPrice(price);
            }
            
            if(!request.getParameter("sctBrand").equals(""))
            {
                int id_brand = Integer.parseInt(request.getParameter("sctBrand"));
                brand = new Brand();
                brand.setId(id_brand);
                product.setBrand(brand);
            }
            
            if(!request.getParameter("sctCategory").equals(""))
            {
                int id_category = Integer.parseInt(request.getParameter("sctCategory"));
                category = new Category();
                category.setId(id_category);
                product.setCategory(category);
            }
            
           if(request.getParameter("fileImage")!= null )
            {
                String image = request.getParameter("fileImage");
                product.setNutritionTable(image);
            }
            
        }
        */
        
        return device;
    }
    
    
    /**
     * 
     * @param result
     * @param request
     * @param response 
     */
    public void setView(Result result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        RequestDispatcher dispatcher = null;
        
        
        String operation = request.getParameter("operacao");
        
        //se mensagem de resultado for null temos entidade
        if(result.getMsg() == null)
        {
            //operacao salvar adicione mensagem a exibir
            if(operation.equals("SALVAR"))
            {
                result.setMsg("Produto salvo com sucesso!");
                request.getSession().setAttribute("result", result);
                dispatcher = request.getRequestDispatcher("productList.jsp");
            }
            //opercação excluir adicione mensagem a exibir
            if(operation.equals("EXCLUIR"))
            {
                request.getSession().setAttribute("result", result);
                dispatcher = request.getRequestDispatcher("productList.jsp");
                
            }
            
            //mostre o objeto da entidade na tela enviando por session
            
        }
        
        //manda pagina
        dispatcher.forward(request, response);
                
    }
}
