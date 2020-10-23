/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazycalendar.control.web.command.impl;

import crazycalendar.core.application.Result;
import crazycalendar.domain.DomainEntity;

/**
 *
 * @author Luiz
 */
public class ConsultCommand extends AbstractCommand {
    
    @Override
    public Result execute(DomainEntity entity)
    {
        return facade.consult(entity);
    }
}
