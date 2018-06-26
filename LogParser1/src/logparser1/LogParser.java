/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logparser1;

import logparser1.query.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {

    private Path logDir;
    private List<Log> logList;

    public LogParser(Path logDir) {
        this.logDir = logDir;
        logList = transformStrings();

    }

    private List<Log> getUniqueLogs(Date after, Date before) {
        if (after == null & before == null) {
            return logList;
        } else if (after == null) {
            return logList.stream().filter(i -> i.getDate().compareTo(before) <= 0)
                    .collect(Collectors.toList());
        } else if (before == null) {
            return logList.stream().filter(i -> i.getDate().compareTo(after) >= 0)
                    .collect(Collectors.toList());
        } else {
            return logList.stream().filter(i -> (i.getDate().compareTo(before) <= 0) && (i.getDate().compareTo(after) >= 0))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return getUniqueLogs(after, before).stream().map(Log::getIp).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getUser().equals(user)).map(Log::getIp).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getEvent().equals(event)).map(Log::getIp).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getStatus().equals(status)).map(Log::getIp).collect(Collectors.toSet());
    }

    private List<String> getAllLogsAsStrings() {
        List<String> list = new ArrayList<>();
        File[] logs = logDir.toFile().listFiles(pathname -> pathname.toString().endsWith(".log"));
        for (File file : Objects.requireNonNull(logs)) {
            try {
                List<String> tempList = Files.readAllLines(file.toPath());
                list.addAll(tempList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //list.forEach(System.out::println);
        return list;
    }

    private List<Log> transformStrings() {
        List<Log> list = new ArrayList<>();
        Event event;
        String taskNumber = "";
        SimpleDateFormat format = new SimpleDateFormat("d.M.y H:m:s");
        for (String s : getAllLogsAsStrings()) {
            String[] parts = s.split("\t");
            if (parts[3].contains("TASK")) {
                String[] eventParts = parts[3].split(" ");
                event = Event.valueOf(eventParts[0]);
                taskNumber = eventParts[1];
            } else {
                event = Event.valueOf(parts[3]);
            }
            try {
                list.add(new Log(parts[0], parts[1], format.parse(parts[2]), event, taskNumber, Status.valueOf(parts[4])));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public Set<String> getAllUsers() {
        return logList.stream().map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return getUniqueLogs(after, before).stream().map(Log::getUser).collect(Collectors.toSet()).size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getUser().equals(user)).map(Log::getEvent).collect(Collectors.toSet()).size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getIp().equals(ip)).map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getEvent().equals(Event.LOGIN))
                .map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getEvent().equals(Event.DOWNLOAD_PLUGIN) && i.getStatus().equals(Status.OK))
                .map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getEvent().equals(Event.WRITE_MESSAGE) && i.getStatus().equals(Status.OK))
                .map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getEvent().equals(Event.SOLVE_TASK))
                .map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getEvent().equals(Event.SOLVE_TASK) && i.getTaskNumber().equals(String.valueOf(task)))
                .map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getEvent().equals(Event.DONE_TASK))
                .map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getEvent().equals(Event.DONE_TASK)
                && i.getTaskNumber().equals(String.valueOf(task)))
                .map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getUser().equals(user) && i.getEvent().equals(event))
                .map(Log::getDate).collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getStatus().equals(Status.FAILED))
                .map(Log::getDate).collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getStatus().equals(Status.ERROR))
                .map(Log::getDate).collect(Collectors.toSet());
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getUser().equals(user) && i.getEvent().equals(Event.LOGIN))
                .sorted(Comparator.comparing(Log::getDate)).map(Log::getDate).findFirst().orElse(null);
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getUser().equals(user) && i.getTaskNumber().equals(String.valueOf(task)) && i.getEvent().equals(Event.SOLVE_TASK))
                .sorted(Comparator.comparing(Log::getDate)).map(Log::getDate).findFirst().orElse(null);
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getUser().equals(user) && i.getTaskNumber().equals(String.valueOf(task)) && i.getEvent().equals(Event.DONE_TASK))
                .sorted(Comparator.comparing(Log::getDate)).map(Log::getDate).findFirst().orElse(null);
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getUser().equals(user) && i.getStatus().equals(Status.OK) && i.getEvent().equals(Event.WRITE_MESSAGE))
                .map(Log::getDate).collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getUser().equals(user) && i.getStatus().equals(Status.OK) && i.getEvent().equals(Event.DOWNLOAD_PLUGIN))
                .map(Log::getDate).collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return getUniqueLogs(after, before).stream().map(Log::getEvent).collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getIp().equals(ip)).map(Log::getEvent).collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getUser().equals(user)).map(Log::getEvent).collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getStatus().equals(Status.FAILED)).map(Log::getEvent).collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getStatus().equals(Status.ERROR)).map(Log::getEvent).collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getEvent().equals(Event.SOLVE_TASK) && i.getTaskNumber().equals(String.valueOf(task)))
                .collect(Collectors.toList()).size();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getEvent().equals(Event.DONE_TASK) && i.getTaskNumber().equals(String.valueOf(task)))
                .collect(Collectors.toList()).size();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getEvent().equals(Event.SOLVE_TASK))
                .collect(Collectors.toMap(i -> Integer.valueOf(i.getTaskNumber()), i -> 1, Integer::sum));
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        return getUniqueLogs(after, before).stream().filter(i -> i.getEvent().equals(Event.DONE_TASK))
                .collect(Collectors.toMap(i -> Integer.valueOf(i.getTaskNumber()), i -> 1, Integer::sum));
    }

    /*@Override
    public Set<Object> execute(String query) {
        switch(query){
            case "get ip" :
                return logList.stream().map(Log::getIp).collect(Collectors.toSet());
            case "get user" :
                return logList.stream().map(Log::getUser).collect(Collectors.toSet());
            case "get date" :
                return logList.stream().map(Log::getDate).collect(Collectors.toSet());
            case "get event" :
                return logList.stream().map(Log::getEvent).collect(Collectors.toSet());
            case "get status" :
                return logList.stream().map(Log::getStatus).collect(Collectors.toSet());
        }
        return null;
    }*/
    @Override
    public Set<Object> execute(String query) {
        String[] arr = parseQueryToArray(query);
        if (arr.length == 1) {
            return logList.stream().map(i -> {
                try {
                    return transformToMethod(i, arr[0]).invoke(i);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(LogParser.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }).collect(Collectors.toSet());
        } else {
            
            return logList.stream().filter(i -> {
                try {
                    return transformToMethod(i, arr[1]).invoke(i).toString().equals(arr[2]);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(LogParser.class.getName()).log(Level.SEVERE, null, ex);
                }
                return false;
            })
                    .map(i -> {
                        try {
                            return transformToMethod(i, arr[0]).invoke(i);
                        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                            Logger.getLogger(LogParser.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        return null;
                    })
                    .collect(Collectors.toSet());
        }
    }

    private Method transformToMethod(Log log, String query) {
        Method method = null;
        try {
            String methodName = "get" + query.replaceFirst(query.substring(0, 1), query.substring(0, 1).toUpperCase());
            method = log.getClass().getMethod(methodName);
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(LogParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return method;
    }

    public String[] parseQueryToArray(String query) {
        String[] parts = query.split(" ");
        if (parts.length == 2) {
            return new String[]{parts[1]};
        } else {
            Pattern pattern = Pattern.compile("\".*\"");
            Matcher matcher = pattern.matcher(query);
            if (matcher.find()) {
                return new String[]{parts[1], parts[3], matcher.group().replace("\"", "")};
            }

        }
        return null;
    }
}
