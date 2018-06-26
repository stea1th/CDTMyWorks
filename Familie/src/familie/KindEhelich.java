package familie;

public class KindEhelich extends Kind implements Mutter{
    private String haarfarbe;
    private String augenfarbe;
    private String status;
    
     public KindEhelich (String nname,  String vorname, String status ){
        super(nname, vorname);
        this.status=status;
        
    }
    
    @Override
     public String getStatus(){
        return status;
    }
     
     
     
     @Override
     public  String getHaarfarbe(){
         haarfarbe="rot";
         return haarfarbe;
     }
     
     @Override
     public  String getAugenfarbe(){
         augenfarbe="braun";
         return augenfarbe;
     }
     
     @Override
    public String toString()
    {
    String elternstring = super.toString();
        return String.format("%s\nHaarfarbe:\t%s\nAugenfarbe:\t%s",elternstring, getHaarfarbe(),getAugenfarbe());
}
    
}
