public class Dog {

    private String name;
    private int age;
    private String dogType;
    
    public Dog(String name, int age, String dogType) {
        this.name = name;
        this.age = age;
        this.dogType = dogType;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getDogType(){
        return dogType;
    }
}
