/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    private final Model MODELL;
    private final View VIEW;
    //private Map<Long, Service> map;

    public Controller(Model modell, View view) {
        this.MODELL = modell;
        this.VIEW = view;
        try {
            load();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save() {
        MODELL.serialize();
    }

    public void load() throws IOException {
        if (Files.readAllBytes(Paths.get(MODELL.getDbFile())).length != 0) {
            MODELL.deserialize();
        } else {
            System.out.println("Its empty DB!!");
        }
    }

    public void create() {
        Helper.print("Daten einlegen:");
        try {
            if (!MODELL.createEntity(new Service(Helper.readLong(), Helper.read(), Helper.readInt(), Helper.readDouble()))) {
                Helper.print("ID existiert schon!");
            }
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        refresh();

    }

    private void refresh() {
        VIEW.setMap(MODELL.getMap());
        VIEW.printMap();
    }

    public void mainMenu() {
        VIEW.mainMenu();
        switchChoice(Helper.readInt());
    }

    private void update() {
        int x = 0;
        while (x != 5) {

            VIEW.secondMenu();
            x = Helper.readInt();
            try {
                switchChoiceSecond(x);

            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void switchChoice(int x) {
        switch (x) {
            case 1:
                create();
                break;
            case 6:
                save();
                System.exit(0);
                break;
            case 5:
                refresh();
                break;
            case 2:
                update();
                break;
            case 3:
                delete();
                break;
            case 4:
                VIEW.inWork();
                break;
            default:
                VIEW.inWork();
                break;
        }
    }

    private void delete() {
        Helper.print("Id zum löschen eingeben:");
        try {
            MODELL.deleteEntity(Helper.readLong());
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void switchChoiceSecond(int x) throws IOException {
        switch (x) {
            case 1:
                Helper.print("Geben Sie altes und neues id ein:");
                if (MODELL.updateId(Helper.readLong(), Helper.readLong())) {
                    VIEW.good();
                } else {
                    VIEW.notGood();
                }
                break;
            case 2:
                Helper.print("Geben Sie id und neue Name ein:");
                if (MODELL.updateName(Helper.readLong(), Helper.read())) {
                    VIEW.good();
                } else {
                    VIEW.notGood();
                }
                break;
            case 3:
                Helper.print("Geben Sie id und neue Menge ein");
                if (MODELL.updateQuantity(Helper.readLong(), Helper.readInt())) {
                    VIEW.good();
                } else {
                    VIEW.notGood();
                }
                break;
            case 4:
                Helper.print("Geben Sie id und neue Preis ein");
                if (MODELL.updatePrice(Helper.readLong(), Helper.readDouble())) {
                    VIEW.good();
                } else {
                    VIEW.notGood();
                }
                break;
            case 5:
                break;
        }
    }
}
