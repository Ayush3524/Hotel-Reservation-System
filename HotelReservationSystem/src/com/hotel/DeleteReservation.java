package com.hotel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteReservation {

    public static void deleteReservation(Connection con, Scanner sc){
        try {
            System.out.println("Enter reservation ID to delete: ");
            int reservationId = sc.nextInt();

            if (!AdditionalMethods.reservationExists(con, reservationId)){
                System.out.println("reservation not found for given id");
                return;
            }

            String sql ="DELETE FROM reservations WHERE reservation_id = "+reservationId;

            try (Statement statement = con.createStatement()){
                int affectedRows = statement.executeUpdate(sql);

                if (affectedRows>0){
                    System.out.println("Reservation Deleted Successfully!");
                }else {
                    System.out.println("Reservation failed Successfully!");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
