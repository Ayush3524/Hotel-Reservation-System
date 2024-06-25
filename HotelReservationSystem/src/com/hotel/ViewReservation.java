package com.hotel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewReservation {

    public static void viewReservation(Connection con) throws SQLException {
        String sql = "SELECT reservation_id, guest_name, room_number, contact_number, reservation_date FROM reservations";
//        String sql = "select * FROM reservations";
        try (Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(sql)){

            System.out.println("Current Reservations: ");
            System.out.println("+----------------+-----------------+--------------+-----------------------+-------------------------+");
            System.out.println("| Reservation ID | Guest           | Room Number  | Contact number        | Reservation Date        |");
            System.out.println("+----------------+-----------------+--------------+-----------------------+-------------------------+");

            while (rs.next()){
                int reservationId = rs.getInt("reservation_id");
                String guestName= rs.getString("guest_name");
                int roomNumber = rs.getInt("room_number");
                String contactNumber = rs.getString("contact_number");
                String reservationDate = rs.getTimestamp("reservation_date").toString();

                System.out.printf("| %-14d | %-15s | %-13d | %-20s | %-19s  |\n",
                        reservationId,guestName,roomNumber,contactNumber,reservationDate);
            }
            System.out.println("+----------------+-----------------+--------------+-----------------------+-------------------------+");
        }

    }
}
