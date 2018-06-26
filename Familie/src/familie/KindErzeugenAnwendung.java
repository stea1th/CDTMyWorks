package familie;
public class KindErzeugenAnwendung {
 
    public static void main(String[] args) {
        Kind[] Kindlein =new Kind[3];
            Kindlein[0] = new KindEhelich("Meier","Lilly","ehelich");
            Kindlein[1] = new KindNichtEhelich("Meier","Jimmy","vom Postboten");
            Kindlein[2] = new KindErsteEheVater("Meier","Maria","aus erster Ehe des Vaters");
         
            System.out.println("******************Ihr Kinderlein kommet**********************************");
            for (Kind def : Kindlein) {
               System.out.println(def);
               System.out.println("***************************************************************************");
            }
    }
}

