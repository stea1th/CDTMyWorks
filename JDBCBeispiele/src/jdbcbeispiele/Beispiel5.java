/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcbeispiele;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Beispiel5 {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlserver://10.140.130.16:1433; databaseName=Firma21";
        boolean status = true;
        try (PreparedStatement statement = DriverManager.getConnection(url, "dba21", "dba21")
                .prepareStatement("select * from mitarbeiter where wohnort=?")) {
            System.out.print("Bitte geben Sie ein Wohnort ein: ");
            statement.setString(1, new Scanner(System.in).nextLine());
            ResultSet result = statement.executeQuery();
            System.out.println("Hier wohnen:");
            while (result.next()) {
                System.out.printf("\t%-7s\t%10s %10s %10s\n", result.getString(1), result.getString(2), result.getString(3), result.getString(5));
                status = false;
            }
            if (status) {
                System.out.println("\t***keine Mitarbeiter***");
            }
        }
    }
}
