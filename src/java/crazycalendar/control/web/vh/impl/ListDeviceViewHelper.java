/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altair2018.control.web.vh.impl;

import altair2018.control.web.vh.IViewHelper;
import altair2018.core.application.Result;
import altair2018.domain.Device;
import altair2018.domain.DomainEntity;
import altair2018.domain.Location;
import altair2018.domain.Manufactor;
import altair2018.domain.OperationalSystem;
import altair2018.domain.Owner;
import altair2018.domain.Type;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rossatol
 */
public class ListDeviceViewHelper implements IViewHelper {
    
    /**
     * Metodo que pega a request http e retira dela
     * os dados de aluno criando um objeto com tais informações
     * @param request HTTP
     * @return OBJETO DE ALUNO
     */
    public DomainEntity getEntity(HttpServletRequest request)
    {
        String operation = request.getParameter("operacao");
        
       
        Device device  = new Device();
        
        
        if (request.getParameter("cliente") != null)
        {
            String cliente = request.getParameter("cliente");
            Owner owner = new Owner();
            owner.setName(cliente);
            device.setOwner(owner);
        }

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
            //envia entidade por session
            request.getSession().setAttribute("result", result);
            dispatcher = request.getRequestDispatcher("baseline_general.jsp");
        }
        
        
        //manda pagina
        dispatcher.forward(request, response);
                
    }
    
}
