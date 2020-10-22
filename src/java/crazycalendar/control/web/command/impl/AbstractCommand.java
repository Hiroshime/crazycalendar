/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altair2018.control.web.command.impl;

import altair2018.control.web.command.ICommand;
import altair2018.core.IFacade;
import altair2018.core.impl.control.Facade;

/**
 *
 * @author Luiz
 */
public abstract class AbstractCommand implements ICommand{
    
    
    protected IFacade facade = new Facade();
    
}
