package familie;

public class KindErsteEheVater extends Kind{

    private static final String augenfarbe="grün";
    private String status;
    
     public KindErsteEheVater (String nname, String vorname, String status){
        super(nname, vorname);
        this.status=status;
        
    }
   
    public String getStatus(){
        return status;
    }
    
     @Override
    public String toString()
    {
    String elternstring = super.toString();
        return String.format("%s\nHaarfarbe:\t%s\nAugenfarbe:\t%s",elternstring, getHaarfarbe(),augenfarbe);
}
    
}
