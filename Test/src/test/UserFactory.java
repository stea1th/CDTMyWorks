/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author vvlasov
 */
public interface UserFactory<U extends User> {
    U create(String name, String surname);
}
