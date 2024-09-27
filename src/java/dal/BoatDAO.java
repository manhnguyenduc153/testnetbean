/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Boats;
import model.DepartPlaces;
import model.Tickets;

/**
 *
 * @author FPTSHOP
 */
public class BoatDAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Boats> getAllBoats(String dname) {
        ArrayList<Boats> lb = new ArrayList<>();
        String sql = "select * from Boats b\n"
                + "join DepartPlaces d\n"
                + "on b.DepartPlaceID = d.DepartPlaceID\n"
                + "join Tickets tk\n"
                + "on tk.TicketID = b.TicketID";
        if(dname != null){
            sql += " where d.DepartPlaceName = '" + dname + "'";
        }
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Boats b = new Boats();
                b.setBid(rs.getString("BoatID"));
                b.setBname(rs.getString("BoatName"));
                b.setSeat(rs.getInt("Seat"));
                b.setBooked(rs.getInt("Booked"));
                
                DepartPlaces d = new DepartPlaces();
                d.setDid(rs.getInt("DepartPlaceID"));
                d.setDname(rs.getString("DepartPlaceName"));
                
                Tickets t = new Tickets();
                t.setTid(rs.getInt("TicketID"));
                t.setTname(rs.getString("TicketName"));
                
                b.setD(d);
                b.setT(t);
                
                lb.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lb;
    }

    public ArrayList<DepartPlaces> getAllDepart() {
        ArrayList<DepartPlaces> lt = new ArrayList<>();
        String sql = "select * from DepartPlaces";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                DepartPlaces d = new DepartPlaces();
                d.setDid(rs.getInt("DepartPlaceID"));
                d.setDname(rs.getString("DepartPlaceName"));
                
                lt.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lt;
    }
}
