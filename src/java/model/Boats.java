/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author FPTSHOP
 */
public class Boats {
    private String bid;
    private String bname;
    private int seat;
    private int booked;
    private DepartPlaces d;
    private Tickets t;

    public Boats() {
    }

    public Boats(String bid, String bname, int seat, int booked, DepartPlaces d, Tickets t) {
        this.bid = bid;
        this.bname = bname;
        this.seat = seat;
        this.booked = booked;
        this.d = d;
        this.t = t;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public DepartPlaces getD() {
        return d;
    }

    public void setD(DepartPlaces d) {
        this.d = d;
    }

    public Tickets getT() {
        return t;
    }

    public void setT(Tickets t) {
        this.t = t;
    }
    
    
}
