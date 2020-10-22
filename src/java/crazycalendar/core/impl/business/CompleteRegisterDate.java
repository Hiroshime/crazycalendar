/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altair2018.core.impl.business;

import java.util.Date;
import altair2018.core.IStrategy;
import altair2018.domain.DomainEntity;

/**
 *
 * @author Luiz
 */
public class CompleteRegisterDate implements IStrategy {
    
    
    @Override
    public String process(DomainEntity entity)
    {
        if(entity != null)
        {
            Date date = new Date();
            entity.setDtCadastro(date);
        }
        else
        {
            return "Entidade: " + entity.getClass().getCanonicalName()+ " nula!";
        }
        return null;
    }
    
}
