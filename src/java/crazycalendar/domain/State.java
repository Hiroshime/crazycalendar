/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altair2018.domain;

/**
 *
 * @author Luiz
 */
public class State extends DomainEntity {
    
    private City city;
    private String fu;
    

    /**
     * @return the city
     */
    public City getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * @return the fu
     */
    public String getFu() {
        return fu;
    }

    /**
     * @param fu the fu to set
     */
    public void setFu(String fu) {
        this.fu = fu;
    }
    
}
