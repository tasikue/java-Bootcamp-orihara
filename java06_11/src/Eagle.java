public class Eagle extends Bird {
    
    public Eagle(String name){
        super(name);
    }

    @Override
    public void fly(){
        System.out.format(
            "[Eagle] %s が飛んだ. %n",
            this.name
        );
    }
}
