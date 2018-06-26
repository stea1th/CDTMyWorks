/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcbeispiele;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 *
 * @author vvlasov
 */
public class DateFormatierung {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlserver://10.140.130.16:1433; databaseName=Firma21", abt, mr_nr = "";
        String sql = new Scanner(System.in).nextLine();
        try (Statement stm = DriverManager.getConnection(url, "dba21", "dba21").createStatement()) {
            ResultSet rs = stm.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int z = 0;
            String[] sp = new String[meta.getColumnCount()];
            
            for (int i = 0; i < meta.getColumnCount(); i++) {
                sp[i] = meta.getColumnLabel(i+1);
                
            }
            while(rs.next()){
                System.out.printf("%n%3d. Zeile:%n", ++z);
                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    System.out.printf("%5d. Spalte: Spaltenname: %-20s"+
                            "Spaltenwert: %s%n", i, sp[i-1], rs.getString(i));
                    
                }
            }
        }
        
    }
    
}
