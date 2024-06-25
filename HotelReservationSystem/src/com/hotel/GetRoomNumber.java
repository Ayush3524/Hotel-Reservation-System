package com.hotel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GetRoomNumber {

    public static void getRoomNumber(Connection con, Scanner sc){
        try {
            System.out.println("Enter Reservation ID: ");
            int reservationId = sc.nextInt();
            System.out.println("Enter guest Name: ");
            String guestName= sc.next();

            String sql = "SELECT room_number FROM reservations " +
                    "WHERE reservation_id = " + reservationId +
                    " AND guest_name = '" + guestName + "'";

            try (Statement statement = con.createStatement();
                 ResultSet rs = statement.executeQuery(sql)){

                if (rs.next()){
                    int roomNumber = rs.getInt("room_number");
                    System.out.println("Room number for Reservation ID "+reservationId+
                            " and Guest "+guestName+" is: "+roomNumber);
                }else {
                    System.out.println("reservation not found for the given id and guest.");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
