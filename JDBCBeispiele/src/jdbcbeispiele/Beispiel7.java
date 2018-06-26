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
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Beispiel7 {

    public static void main(String[] args) {
        String url = "jdbc:sqlserver://10.140.130.16:1433; databaseName=Firma21", abt, mr_nr = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        int countM = 0, countP = 0;
        System.out.print("Geben Sie Abteilungsnummer ein: ");
        try {
            try (PreparedStatement statement = DriverManager.getConnection(url, "dba21", "dba21")
                    .prepareStatement("select m.m_nr, m.m_vorname, m.m_name, p.pr_nr, p.pr_name, a.einst_dat\n"
                            + "from mitarbeiter m left join arbeiten a on m.m_nr=a.m_nr\n"
                            + "join projekt p on a.pr_nr= p.pr_nr\n"
                            + "where m.abt_nr= ?")) {
                statement.setString(1, (abt = new Scanner(System.in).nextLine()));
                ResultSet result = statement.executeQuery();
                System.out.printf("Projekteinsätze der Mitarbeiter aus Abteilung %s:\n", abt);
                while (result.next()) {
                    String[] arr = {result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5)};
                    /*String[] arr = IntStream.rangeClosed(1, 5).boxed().map(i -> {
                        try {
                            result.getString(i);
                        } catch (SQLException ex) {
                        }
                        return i;
                    }).toArray(String[]::new);*/
                    if (!arr[0].equals(mr_nr)) {
                        System.out.printf("\n%s %s %s:\n", (mr_nr = arr[0]), arr[1], arr[2]);
                        countM++;
                    }
                    System.out.printf("\t%s %s seit %s\n", arr[3], arr[4], formatter.format(result.getDate(6)));
                    countP++;
                }
                System.out.printf("\n%d Mitarbeiter mit %d Projekteinsätzen\n", countM, countP);
            }
        } catch (SQLException e) {
            System.out.println("SQL-Fehler");
        }
    }
}
