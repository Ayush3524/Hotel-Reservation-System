import com.hotel.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Scanner;


public class HotelReservationSystem {

    public static void main(String[] args) throws ClassNotFoundException, SQLException{

        try {
            Connection con = DriverManager.getConnection(DatabaseConnection.url, DatabaseConnection.username, DatabaseConnection.password);
            while (true){
                System.out.println();
                System.out.println("HOTEL MANAGEMENT SYSTEM");
                Scanner sc = new Scanner(System.in);
                System.out.println("1. Reserve a room");
                System.out.println("2. View Reservations");
                System.out.println("3. Get Room Number");
                System.out.println("4. Update Reservation");
                System.out.println("5. Delete Reservation");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        ReserveRoom.reserveRoom(con, sc);
                        break;
                    case 2:
                        ViewReservation.viewReservation(con);
                        break;
                    case 3:
                        GetRoomNumber.getRoomNumber(con,sc);
                        break;
                    case 4:
                        UpdateReservation.updateReservation(con,sc);
                        break;
                    case 5:
                        DeleteReservation.deleteReservation(con,sc);
                        break;
                    case 0:
                        AdditionalMethods.exit();
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid Choice. Try again.");
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}