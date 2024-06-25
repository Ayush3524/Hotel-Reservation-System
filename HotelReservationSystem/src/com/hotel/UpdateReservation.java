package com.hotel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateReservation {

    public static void updateReservation(Connection con, Scanner sc){
        try {
            System.out.println("Enter Reservation ID to update: ");
            int reservationId = sc.nextInt();
            sc.nextLine();

            if (!AdditionalMethods.reservationExists(con,reservationId)){
                System.out.println("Reservation not fount for the given id");
                return;
            }

            System.out.println("Enter new guest name: ");
            String newGuestName = sc.nextLine();
            System.out.println("Enter new room number: ");
            int newRoomNumber = sc.nextInt();
            System.out.println("Enter new contact number: ");
            String newContactNumber= sc.next();

            String sql = "UPDATE reservations SET guest_name = '" + newGuestName + "', " +
                    "room_number = " + newRoomNumber + ", "+
                    "contact_number = '" + newContactNumber + "' "+
                    "WHERE reservation_id = " + reservationId;

            try (Statement statement = con.createStatement()){
                int affectedRows  = statement.executeUpdate(sql);

                if (affectedRows>0){
                    System.out.println("Reservation Updated Successfully!");
                }else {
                    System.out.println("Reservation Update failed.");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
