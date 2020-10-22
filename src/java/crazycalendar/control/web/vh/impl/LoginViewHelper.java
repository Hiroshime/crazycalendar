/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altair2018.control.web.vh.impl;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import altair2018.control.web.vh.IViewHelper;
import altair2018.core.application.Result;
import altair2018.domain.DomainEntity;
import altair2018.domain.User;

/**
 *
 * @author Luiz
 */
public class LoginViewHelper implements IViewHelper{
    
      // private Order order;
       //private Customer customer;
    private User user;
       
       public DomainEntity getEntity(HttpServletRequest request)
       {
           
                user = new User();
                user.setUsername(request.getParameter("txtUsername"));
                user.setPassword(request.getParameter("txtPassword"));
           
           return user;
       }
       
       public void setView(Result result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
       {
                RequestDispatcher dispatcher = null;
                user = null;
                user = (User) result.getEntities().get(0);
           
                if(user == null)
                {
                    result.setMsg("Usuario ou senha incorretos ");
                    request.getSession().setAttribute("result", result);
                    dispatcher = request.getRequestDispatcher("login.jsp");
                }
                else
                {
                    request.getSession().setAttribute("login", user);
                    dispatcher = request.getRequestDispatcher("index.jsp");
                }
                dispatcher.forward(request, response);
                
       }
}
