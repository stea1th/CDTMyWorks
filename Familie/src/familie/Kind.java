
package familie;

public class Kind extends Vater{
    private final String vorname;
    private String status;
    
   public Kind (String nname, String vorname){
       super(nname);
       this.vorname=vorname;
       this.status=status;
     }
    
   
   public void setStatus(){
        this.status=status;
    }
   
public String getStatus(){
        return status;
    }
    @Override
    public String toString()
    {
    String elternstring = super.toString();
        return String.format("Status:\t%s\n%s\nVorname:\t%s",getStatus(), elternstring, vorname);
}
}

