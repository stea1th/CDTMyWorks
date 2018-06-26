/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logparser1.query;

import java.util.Date;
import java.util.Set;
import logparser1.Event;
import logparser1.Status;

public interface IPQuery {
    int getNumberOfUniqueIPs(Date after, Date before);

    Set<String> getUniqueIPs(Date after, Date before);

    Set<String> getIPsForUser(String user, Date after, Date before);

    Set<String> getIPsForEvent(Event event, Date after, Date before);

    Set<String> getIPsForStatus(Status status, Date after, Date before);
}
