/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logparser1.query;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import logparser1.Event;

public interface EventQuery {
    int getNumberOfAllEvents(Date after, Date before);

    Set<Event> getAllEvents(Date after, Date before);

    Set<Event> getEventsForIP(String ip, Date after, Date before);

    Set<Event> getEventsForUser(String user, Date after, Date before);

    Set<Event> getFailedEvents(Date after, Date before);

    Set<Event> getErrorEvents(Date after, Date before);

    int getNumberOfAttemptToSolveTask(int task, Date after, Date before);

    int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before);

    Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before);

    Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before);
}