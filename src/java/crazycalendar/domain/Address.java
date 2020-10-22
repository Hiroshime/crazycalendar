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
public class Address extends DomainEntity {
    private String zip;
    private String street;
    private int number;
    private String complement;
    private State state;
    private String neighbor;
    private String destinatary;
    

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the complement
     */
    public String getComplement() {
        return complement;
    }

    /**
     * @param complement the complement to set
     */
    public void setComplement(String complement) {
        this.complement = complement;
    }

    /**
     * @return the state
     */
    public State getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(State state) {
        this.state = state;
    }


    /**
     * @return the neighbor
     */
    public String getNeighbor() {
        return neighbor;
    }

    /**
     * @param neighbor the neighbor to set
     */
    public void setNeighbor(String neighbor) {
        this.neighbor = neighbor;
    }

    /**
     * @return the destinatary
     */
    public String getDestinatary() {
        return destinatary;
    }

    /**
     * @param destinatary the destinatary to set
     */
    public void setDestinatary(String destinatary) {
        this.destinatary = destinatary;
    }
    
    
    
    
    

    
    
    
    
}
