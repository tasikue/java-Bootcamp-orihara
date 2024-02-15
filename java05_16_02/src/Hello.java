public class Hello {

    protected String name;
    
    public Hello(String name) {
        this.name = name;
    }
    
    public void sayHello() {
        System.out.println(name);
    }
    
    void foo() {
        System.out.println("Foo");
    }
}