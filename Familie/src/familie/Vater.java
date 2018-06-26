package familie;

public class Vater {
    private String nachname;
    private String haarfarbe="blond";
    private static final String adresse="Hühnerhof 17, 47587 Pastoralgarten";

    
    public Vater (String nname){
       this.nachname=nname;
     }
    
   
      
    public String getNachname(){
        return nachname;
    }
    
      public String getHaarfarbe(){
        return haarfarbe;
    }
      
    
    @Override
     public String toString() {      
return String.format("Nachname:\t%s", getNachname());
}
}
