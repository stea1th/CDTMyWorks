/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logparser1.query;

import java.util.Date;
import java.util.Set;

public interface UserQuery {
    Set<String> getAllUsers();

    int getNumberOfUsers(Date after, Date before);

    int getNumberOfUserEvents(String user, Date after, Date before);

    Set<String> getUsersForIP(String ip, Date after, Date before);

    Set<String> getLoggedUsers(Date after, Date before);

    Set<String> getDownloadedPluginUsers(Date after, Date before);

    Set<String> getWroteMessageUsers(Date after, Date before);

    Set<String> getSolvedTaskUsers(Date after, Date before);

    Set<String> getSolvedTaskUsers(Date after, Date before, int task);

    Set<String> getDoneTaskUsers(Date after, Date before);

    Set<String> getDoneTaskUsers(Date after, Date before, int task);
}
