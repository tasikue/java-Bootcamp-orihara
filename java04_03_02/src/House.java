public class House {

    private String ownerName;
    private String color;
    private String address;

    private boolean isDoorOpen;
    private boolean isTryingToOpenDoorNow;
    private boolean isTryingToCloseDoorNow;
    
    public House(String ownerName, String color, String address){

        this.ownerName = ownerName;
        this.color = color;
        this.address = address;

        isDoorOpen = false;
        clearDoorNowStatus();
    }

    private void clearDoorNowStatus(){
        isTryingToCloseDoorNow = false;
        isTryingToOpenDoorNow = false;
    }

    private void showAction(String message){
        System.out.printf(message, this.ownerName);
    }

    private void logCanOpen(){
        if(isTryingToCloseDoorNow && !this.isDoorOpen){
            System.out.println(" => [INFO] 既にドアは閉まっています");
        }

        if(isTryingToOpenDoorNow && this.isDoorOpen){
            System.out.println(" => [INFO] 既にドアは開いています");
        }
    }

    public void closeDoor(){
        isTryingToCloseDoorNow = true;

        showAction("%s さん家のドアを閉めます \n");
        logCanOpen();

        isDoorOpen =false;
        clearDoorNowStatus();
    }

    public void openDoor(){
        isTryingToOpenDoorNow = true;

        showAction("%s さん家のドアを開けます \n");
        logCanOpen();

        isDoorOpen =true;
        clearDoorNowStatus();
    }

    public void showDetails(){

        System.out.printf("%s さん家\n", ownerName);
        System.out.printf(" => 色: %s\n", color);
        System.out.printf(" => 住所: %s\n",  address);
        System.out.printf(" => ドア: %s\n", getDoorStatus());
    }

    public String getOwnerName(){
        return ownerName;
    }

    public String getColer(){
        return color;
    }

    public String getAddress(){
        return address;
    }

    public String getDoorStatus(){
        if(this.isDoorOpen){
            return "開いています";
        }

        return "閉まっています";
    }
}
