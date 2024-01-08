public class Person {

    private String name;
    private int age;
    
    public Person(){
        this.name = "名無しの太郎";
        this.age = 20;
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void show(){
        System.out.printf("%s さんは %d 歳です．\n", this.name, this.age);
    }
}
