/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazycalendar.core.application;

import java.util.ArrayList;
import crazycalendar.domain.DomainEntity;
import java.util.List;

/**
 *
 * @author Luiz
 */
public class Result extends EntityApplication{
    private String msg;
    private List<DomainEntity> entities;
    
    /**
     * @return msg
     */
    public String getMsg()
    {
        return msg;
    }

    public void addEntities(DomainEntity entity)
    {
        entities = new ArrayList<>();
        entities.add(entity);
    }
    
    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the entities
     */
    public List<DomainEntity> getEntities() {
        return entities;
    }

    /**
     * @param entities the entities to set
     */
    public void setEntities(List<DomainEntity> entities) {
        this.entities = entities;
    }
}

