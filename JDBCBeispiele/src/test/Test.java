/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vvlasov
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://10.140.130.16:1433; databaseName=Firma21";
        try {
            try (Statement stm = DriverManager.getConnection(url, "dba21", "dba21").createStatement()) {
                /*ResultSet rs = stm.executeQuery("select * from projekt");
                while (rs.next()) {
                    System.out.printf("%-5s%-20s%,11.2f\n", rs.getString(1), rs.getString(2), rs.getDouble(3));
                }*/
                System.out.println(stm.executeUpdate("insert into abteilung values('a7', 'Buchhaltung', 'Nürnberg')"));
                /*while (rs.next()) {
                System.out.println(rs.getRow() + " " + rs.getString("pr_nr") + "\t" + rs.getString("pr_name"));
            }*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
