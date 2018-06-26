/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcbeispiele;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author vvlasov
 */
public class Beispiel3b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://10.140.130.16:1433; databaseName=Firma21";
        Scanner scanner = new Scanner(System.in);
        String sql = "insert into projekt values(?, ?, ?)";
        try(PreparedStatement prepared = DriverManager.getConnection(url, "dba21", "dba21").prepareStatement(sql)){
            
        //}

        //try (Statement stm = DriverManager.getConnection(url, "dba21", "dba21").createStatement()) {
            System.out.print("Projektnummer:\t");
            String pr_nr = scanner.nextLine();
            System.out.print("Projektname:\t");
            String pr_name = scanner.nextLine();
            System.out.print("Projektmittel:\t");
            int mittel = scanner.nextInt();
            prepared.setString(1, pr_nr);
            prepared.setString(2, pr_name);
            prepared.setInt(3, mittel);
            //stm.executeUpdate(String.format("insert into projekt values('%s', '%s', '%d')", pr_nr, pr_name, mittel));
            prepared.executeUpdate();
        }

    }

}
