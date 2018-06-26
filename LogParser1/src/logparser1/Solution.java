/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logparser1;

import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Solution {
    public static void main(String[] args) throws ParseException {
        LogParser logParser = new LogParser(Paths.get("C:\\Users\\vvlasov\\Desktop\\logs"));
        
        logParser.execute("get user for event = \"LOGIN\"").forEach(System.out::println);
        //Arrays.asList(logParser.parseQueryToArray("get event for date = \"03.01.2014 03:45:23\"")).forEach(System.out::println);
        //logParser.execute("get event for date = \"03.01.2014 03:45:23\"").forEach(System.out::println);
        /*logParser.getUniqueIPs(null, null).forEach(System.out::println);
        System.out.println("-------------------------------");
        logParser.getUniqueIPs(null, new SimpleDateFormat("d.M.y H:m:s").parse("03.03.2020 11:38:21")).forEach(System.out::println);
        System.out.println("-------------------------------");
        logParser.getIPsForUser("Amigo", null, null).forEach(System.out::println);
        System.out.println("-------------------------------");
        logParser.getIPsForStatus(Status.FAILED, null, null).forEach(System.out::println);
        System.out.println("-------------------------------");
        logParser.getIPsForEvent(Event.DOWNLOAD_PLUGIN, null, null).forEach(System.out::println);
        System.out.println("-------------------------------");
        logParser.getUniqueIPs(new SimpleDateFormat("dd.MM.yyyy").parse("01.01.2013"), new SimpleDateFormat("dd.MM.yyyy").parse("03.03.2020")).forEach(System.out::println);
        System.out.println("-------------------------------");*/

        //logParser.getAllLogsAsStrings().forEach(System.out::println);
        //System.out.println(logParser.getNumberOfUniqueIPs(null, new SimpleDateFormat("dd.MM.yyyy").parse("03.03.2020")));
    }
}
