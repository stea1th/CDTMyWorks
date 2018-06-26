/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution3;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* 
Почему сет не содержит элемент?
*/

public class Test {
    private Set<Date> dates;
    private Date lastDate;

    public static void main(String[] args) {
        Test solution = new Test();
        solution.initializeDates();
        solution.updateLastDate(3_600_000L);
        System.out.println(solution.isLastDateContainsInDates());
    }

    public boolean isLastDateContainsInDates() {
        return dates.contains(lastDate);
    }

    private void initializeDates() {
        dates = new HashSet<>();
        lastDate = new Date(9999999L);
        dates.add(lastDate);
        dates.add(new Date(2222222L));
        dates.add(new Date(3333333L));
        dates.add(new Date(4444444L));
        dates.add(new Date(5555555L));
    }

    protected void updateLastDate(long delta) {
        dates.remove(lastDate);
        lastDate.setTime(lastDate.getTime() + delta);
        dates.add(lastDate);
        
    }
}
