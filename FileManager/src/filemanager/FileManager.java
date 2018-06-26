/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vvlasov
 */
public class FileManager {

    private final static Stack<File> FOLDERS = new Stack<>();
    private final static Map<File, File> FILES = new HashMap<>();
    private final static List<String> MENU = new ArrayList<>();

    static {
        MENU.add("1. - Verzeichnisinhalt auflisten");
        MENU.add("2. - Files suchen");
        MENU.add("3. - CopyFiles");
        MENU.add("4. - Verzeichnis löschen");
        MENU.add("6. - Programm beenden");
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            menu();
        }
    }

    public static void menu() throws Exception {
        MENU.forEach(System.out::println);
        
        switchMenu();
    }

    public static void switchMenu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pfad eingeben: ");
        String s = scanner.next();
        if(s.equals("6")) System.exit(0);
        FOLDERS.push(Paths.get(s).toFile());
        System.out.print("Command eingeben: ");
        
        switch (scanner.nextInt()) {
            case 1:
                printIt(FOLDERS.peek().toPath());
                clear();
                break;
            case 4:
                delete(FOLDERS.peek().toPath());
                clear();
                break;
            case 6:
                System.out.println("Programme wird beendet...");
                System.exit(0);
                break;
            case 2:
                goInside(FOLDERS.peek().toPath());
                System.out.print("Geben sie Dateienart ein: ");
                findFilesMenu(scanner.next());
                clear();
                break;
            case 3:
                copyFolder(FOLDERS.peek().toPath(), Paths.get(scanner.next()));
                clear();
                break;
            default:
                System.out.println("Falsche Taste!!!");
        }
    }

    public static void clear() {
        FILES.clear();
        FOLDERS.clear();

    }

    public static void copyFolder(Path start, Path destination) throws Exception {
        goInside(start);
        if (!destination.toFile().exists()) {
            Files.createDirectory(destination);
        }
        for (File f : FOLDERS) {
            Files.createDirectory(destination.resolve(start.getParent().relativize(f.toPath())));
        }
        FILES.keySet().forEach(i -> {
            try {
                Files.copy(i.toPath(), destination.resolve(start.getParent().relativize(i.toPath())), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public static void goInside(Path file) throws Exception {
        if (file.toFile() != null) {
            for (File f : file.toFile().listFiles()) {
                if (f.isDirectory()) {
                    FOLDERS.push(f);
                    goInside(f.toPath());
                } else if (f.isFile()) {
                    FILES.put(f, f.getParentFile());
                }
            }
        } else {
            System.out.println("Verzeichnis existiert nicht");
        }
    }

    public static void printIt(Path file) throws Exception {
        goInside(file);
        Path path = FOLDERS.firstElement().toPath().getParent();

        FOLDERS.stream().map((f) -> {
            System.out.println("Directory - " + path.relativize(f.toPath()));
            return f;
        }).forEachOrdered((f) -> {
            FILES.entrySet().stream().filter((entry) -> (f.getAbsolutePath().equals(entry.getValue().getAbsolutePath()))).forEachOrdered((entry) -> {
                System.out.println("\t\tFile - " + entry.getKey().getName());
            });
        });
    }

    public static void printIt(String s) {
        Path path = FOLDERS.firstElement().toPath().getParent();
        FOLDERS.stream().map((f) -> {
            System.out.println("Directory - " + path.relativize(f.toPath()));
            return f;
        }).forEachOrdered((f) -> {
            FILES.entrySet().stream().filter((entry) -> entry.getKey().toString().endsWith(s)).filter((entry) -> (f.getAbsolutePath().equals(entry.getValue().getAbsolutePath()))).forEachOrdered((entry) -> {
                System.out.println("\t\tFile - " + entry.getKey().getName());
            });
        });
    }

    public static void delete(Path dir) throws Exception {
        goInside(dir);
        FILES.keySet().forEach(i -> {
            try {
                Files.delete(i.toPath());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        while (!FOLDERS.isEmpty()) {
            Files.delete(FOLDERS.pop().toPath());
        }
        System.out.println("Verzeichnis " + dir.getFileName() + " wurde erfolgreich gelöscht!");
    }

    public static void findFilesMenu(String s) {
        switch (s.toLowerCase()) {
            case "text":
                printIt(".txt");
                break;
            case "music":
                printIt(".mp3");
                break;
            case "document":
                printIt(".docx");
                break;
            default:
                System.out.println("Falsche Eingabe!!!");
        }
    }
}
