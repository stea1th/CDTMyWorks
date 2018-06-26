/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcbeispiele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author vvlasov
 */
public class Beispiel6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://10.140.130.16:1433; databaseName=Firma21";
        Set<String> a = new LinkedHashSet<>();
        List<String> b = new LinkedList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = null;
        Statement statement = null;
        try {
            con = DriverManager.getConnection(url, "dba21", "dba21");
            statement = con.createStatement();
            ResultSet set = statement.executeQuery("select a.abt_nr, a.abt_name, m.m_vorname, m.m_name\n"
                    + "from mitarbeiter m right join abteilung a on m.abt_nr=a.abt_nr\n"
                    + "order by 1");
            while (set.next()) {
                a.add(set.getString(1) + " " + set.getString(2));
                b.add(set.getString(1) + " " + set.getString(3) + " " + set.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null & con != null) {
                try {
                    statement.close();
                    con.close();
                } catch (SQLException e) {

                }
            }
        }
        a.stream().map((string) -> {
            System.out.println("Abteilung: " + string);
            return string;
        }).forEachOrdered((string) -> {
            b.stream().map((string2) -> string2.split(" ")).filter((arr) -> (arr[0].contains(string.split(" ")[0]))).forEachOrdered((arr) -> {

                System.out.println("\t" + arr[1] + " " + arr[2]);
            });
        });
    }
}
