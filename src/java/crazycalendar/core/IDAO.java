/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazycalendar.core;

import java.sql.SQLException;
import java.util.List;
import crazycalendar.domain.DomainEntity;
/**
 *
 * @author Luiz
 */
public interface IDAO {
    
    public void save(DomainEntity entity) throws SQLException;
    public void change(DomainEntity entity) throws SQLException;
    public void delete(DomainEntity entity) throws SQLException;
    public List<DomainEntity> consult(DomainEntity entity) throws SQLException;
    public DomainEntity view(DomainEntity entity) throws SQLException;
    
}
