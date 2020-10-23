/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazycalendar.control.web.command.impl;

import crazycalendar.control.web.command.ICommand;
import crazycalendar.core.IFacade;
import crazycalendar.core.impl.control.Facade;

/**
 *
 * @author Luiz
 */
public abstract class AbstractCommand implements ICommand{
    
    
    protected IFacade facade = new Facade();
    
}
