/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;



public class Solution {

    private static int i = 0;

    public static void main(String[] args) throws IOException {
        while (true) {
            tryToLogin();
        }
    }

    private static void tryToLogin() throws FileNotFoundException, IOException {

        Properties property = new Properties();

        property.load(new FileInputStream("C:\\Users\\vvlasov\\Desktop\\DatenBank\\3.properties"));
        Helper.print("Login:");
        String login = Helper.read();
        Helper.print("Passwort:");
        String pass = Helper.read();
        if (property.containsKey(login) && pass.equals(property.get(login))) {
            Controller controller = new Controller(new Model(), new View());
            while (true) {
                controller.mainMenu();
            }
        } else if (property.containsKey(login) && !pass.equals(property.get(login))) {
            Helper.print("Falsches Passwort");
            i++;
            if (i == 3) {
                property.setProperty(login, "********");
                property.store(new FileOutputStream("C:\\Users\\vvlasov\\Desktop\\DatenBank\\3.properties"), "Konto ist gesperrt");
                Helper.print("Konto wurde gesperrt");
                System.exit(0);
            }
        } else {
            Helper.print("Login ist falsch");
        }
    }
}
