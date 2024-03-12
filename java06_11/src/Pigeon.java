public class Pigeon extends Bird{

    public Pigeon(String name){
        super(name);
    }

    @Override
    public void fly(){
        System.out.format(
            "[Pigeon] %s が飛んだ. %n",
            this.name
        );
    }
}
