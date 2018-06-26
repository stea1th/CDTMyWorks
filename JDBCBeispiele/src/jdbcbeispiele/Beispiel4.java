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

/**
 *
 * @author vvlasov
 */
public class Beispiel4 {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlserver://10.140.130.16:1433; databaseName=Firma21";
        try (Statement stm = DriverManager.getConnection(url, "dba21", "dba21").createStatement()) {
            ResultSet result = stm.executeQuery("select p.pr_nr, pr_name, m_vorname, m_name\n"
                    + "from mitarbeiter m join arbeiten a on m.m_nr=a.m_nr\n"
                    + "right join projekt p on a.pr_nr=p.pr_nr\n"
                    + "order by 1");
            String number = null;
            int count = 0;
            while (result.next()) {
                String s = result.getString(1) + " " + result.getString(2) + " " + result.getString(3) + " " + result.getString(4);
                String[] arr = s.split(" ");
                if (number == null || !s.contains(number)) {
                    System.out.println(count > 0 ? "Das sind " + count + " Mitarbeiter\n" : "");
                    count = 0;
                    number = arr[0] + " " + arr[1];
                    System.out.printf("Im Projekt %s arbeiten:\n", number);
                } 
                if (arr[2].equals("null") || arr[3].equals("null")) {
                    System.out.println("***Keine Mitarbeiter***");
                    count = 0;
                } else {
                    System.out.println("\t" + arr[2] + " " + arr[3]);
                    count++;
                }
            }
            System.out.println(count > 0 ? "Das sind " + count + " Mitarbeiter\n" : "");
        }
    }
}
