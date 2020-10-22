/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazycalendar.core;

import crazycalendar.domain.DomainEntity;

/**
 *
 * @author Luiz
 */
public interface IStrategy {
    public String process(DomainEntity entity);
}
