/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazycalendar.domain;

/**
 *
 * @author rossatol
 */
public class Device extends DomainEntity{
    
    private String hostname = "";
    private Type type = new Type();
    private String Serial = "";
    private String ipAddress = "";
    private Location location = new Location();
    private Manufactor manufactor = new Manufactor();
    private OperationalSystem os = new OperationalSystem();
    private Owner owner = new Owner();
    private Status status = new Status();
    private String note = "";
    private SupportTeam supteam = new SupportTeam();
    private HostStatus hoststats = new HostStatus();
    

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * @return the Serial
     */
    public String getSerial() {
        return Serial;
    }

    /**
     * @param Serial the Serial to set
     */
    public void setSerial(String Serial) {
        this.Serial = Serial;
    }

    /**
     * @return the ipAddress
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress the ipAddress to set
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @return the manufactor
     */
    public Manufactor getManufactor() {
        return manufactor;
    }

    /**
     * @param manufactor the manufactor to set
     */
    public void setManufactor(Manufactor manufactor) {
        this.manufactor = manufactor;
    }

    /**
     * @return the os
     */
    public OperationalSystem getOs() {
        return os;
    }

    /**
     * @param os the os to set
     */
    public void setOs(OperationalSystem os) {
        this.os = os;
    }

    /**
     * @return the owner
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }



    /**
     * @return the hostname
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * @param hostname the hostname to set
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the supteam
     */
    public SupportTeam getSupteam() {
        return supteam;
    }

    /**
     * @param supteam the supteam to set
     */
    public void setSupteam(SupportTeam supteam) {
        this.supteam = supteam;
    }

    /**
     * @return the hoststats
     */
    public HostStatus getHoststats() {
        return hoststats;
    }

    /**
     * @param hoststats the hoststats to set
     */
    public void setHoststats(HostStatus hoststats) {
        this.hoststats = hoststats;
    }

   
    
    
    
}
