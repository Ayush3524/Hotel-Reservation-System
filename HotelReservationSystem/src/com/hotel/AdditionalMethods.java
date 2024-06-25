package com.hotel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdditionalMethods {

    public static Boolean reservationExists(Connection con, int reservationnId){
        try {
            String sql = "SELECT reservation_id FROM reservations WHERE reservation_id= "+reservationnId;

            try (Statement statement = con.createStatement();
                 ResultSet rs = statement.executeQuery(sql)){

                return rs.next();
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public static void exit() throws InterruptedException{
        System.out.print("Exiting System");
        int i=5;
        while (i!=0){
            System.out.print(".");
            Thread.sleep(450);
            i--;
        }
        System.out.println();
        System.out.println("ThankYou For Using Hotel reservation System!!!");
    }
}
