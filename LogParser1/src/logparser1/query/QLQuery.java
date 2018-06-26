/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logparser1.query;

import java.util.Set;

public interface QLQuery {
    Set<Object> execute(String query);
}
