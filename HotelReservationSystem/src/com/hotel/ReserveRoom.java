package com.hotel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ReserveRoom {

    public static void reserveRoom(Connection con, Scanner sc){
        try {
            System.out.println("Enter guest name: ");
            String guestName=sc.next();
            sc.nextLine();
            System.out.println("Enter room Number: ");
            int roomNumber = sc.nextInt();
            System.out.println("Enter Contact Number: ");
            String contactNumber= sc.next();

            String sql = "INSERT INTO reservations (guest_name, room_number, contact_number)" +
                    "VALUES ('" + guestName + "'," + roomNumber + ", '" +contactNumber + "')";

            try (Statement statement = con.createStatement()){
                int affectedRows = statement.executeUpdate(sql);

                if (affectedRows>0){
                    System.out.println("Reservation Successful");
                }else {
                    System.out.println("Reservation Failed");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
