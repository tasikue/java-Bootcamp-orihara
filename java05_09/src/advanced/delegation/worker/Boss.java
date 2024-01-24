package advanced.delegation.worker;

public class Boss implements Worker{

    private Secretary secretary;
    
    public void work(){
        if(secretary == null){
            System.out.println("秘書がいません.");
            return;
        }
        this.secretary.work();
    }

    public void callSecretary(Secretary secretary){
        this.secretary = secretary;
    }
}
