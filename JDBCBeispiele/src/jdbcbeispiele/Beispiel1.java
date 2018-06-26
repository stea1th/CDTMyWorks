/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcbeispiele;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vvlasov
 */
public class Beispiel1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://10.140.130.16:1433; databaseName=Firma21";

        try (Statement statement1 = DriverManager.getConnection(url, "dba21", "dba21").createStatement();
                Statement statement2 = DriverManager.getConnection(url, "dba21", "dba21").createStatement()) {
            ResultSet rs = statement1.executeQuery("select * from abteilung a");

            System.out.println("Unsere Mitarbeiter je Abteilung\n");
            while (rs.next()) {
                System.out.println("Abteilung: " + rs.getString(1) + " " + rs.getString(2));
                ResultSet rs2 = statement2.executeQuery("select * "
                        + "from mitarbeiter");
                while (rs2.next()) {
                    if (rs.getString(1).equals(rs2.getString(4))) {
                        System.out.println(rs2.getString(2) + " " + rs2.getString(3));
                    }
                }
            }
        }
    }
}

