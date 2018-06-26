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
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 *
 * @author vvlasov
 */
public class Beispiel3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String url = "jdbc:sqlserver://10.140.130.16:1433; databaseName=Firma21";
        List<String> list = new LinkedList<>();
        Set<String> set = new LinkedHashSet<>();
        try (Statement stm = DriverManager.getConnection(url, "dba21", "dba21").createStatement()) {
            ResultSet result = stm.executeQuery("select p.pr_nr, pr_name, m_vorname, m_name\n"
                    + "from mitarbeiter m join arbeiten a on m.m_nr=a.m_nr\n"
                    + "right join projekt p on a.pr_nr=p.pr_nr\n"
                    + "order by 1 desc");

            while (result.next()) {
                set.add(result.getString(1) + " " + result.getString(2));
                list.add(result.getString(1) + " " + result.getString(2) + " " + result.getString(3) + " " + result.getString(4));
            }
        }
        set.stream().map((String s) -> {
            int count = 0;
            boolean status = true;
            System.out.printf("Im Projekt %s arbeiten:\n", s);
            for (String string : list) {
                String[] arr = string.split(" ");
                if (string.contains(s)) {
                    if (arr[2].equals("null") & arr[3].equals("null")) {
                        System.out.println("***Keine Mitarbeiter***");
                        status = false;
                    } else {
                        System.out.println("\t" + arr[2] + " " + arr[3]);
                        count++;
                    }
                }
            }
            if (status) {
                System.out.printf("Das sind %d Mitarbeiter\n", count);
            }
            return s;
        }).forEachOrdered(i -> {
            System.out.println("");
        });
    }
}
