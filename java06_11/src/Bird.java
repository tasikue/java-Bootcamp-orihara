public abstract class Bird {
    
    protected String name;

    protected Bird(String name) {
        this.name = name;
    }

    abstract void fly();

    public void showDetails(){
        System.out.format(
            "[Bird] 名前は %s です. %n",
            this.name
        );
    }
}
