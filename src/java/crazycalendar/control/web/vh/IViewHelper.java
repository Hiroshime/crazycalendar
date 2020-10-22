/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazycalendar.control.web.vh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import crazycalendar.core.application.Result;
import crazycalendar.domain.DomainEntity;

/**
 *
 * @author Luiz
 */
public interface IViewHelper {
    
    public DomainEntity getEntity(HttpServletRequest request);
    
    public void setView(Result result, HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException;
}
