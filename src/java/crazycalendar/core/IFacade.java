/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazycalendar.core;

import crazycalendar.core.application.Result;
import crazycalendar.domain.DomainEntity;

/**
 *
 * @author Luiz
 */
public interface IFacade {
    public Result save(DomainEntity entity);
    public Result change(DomainEntity entity);
    public Result delete(DomainEntity entity);
    public Result consult(DomainEntity entity);
    public Result view(DomainEntity entity);
    
}
