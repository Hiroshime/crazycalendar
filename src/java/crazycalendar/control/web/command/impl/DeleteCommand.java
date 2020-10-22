/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altair2018.control.web.command.impl;

import altair2018.core.application.Result;
import altair2018.domain.DomainEntity;

/**
 *
 * @author Luiz
 */
public class DeleteCommand extends AbstractCommand{
    
    @Override
    public Result execute(DomainEntity entity)
    {
        return facade.delete(entity);
    }
}
