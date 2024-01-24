package advanced.inheritance.entity;

public class Dog extends Animal{
    
    public void display(){
        System.out.printf("[Dog] 名前は %s です.\n", getName());
    }
}
