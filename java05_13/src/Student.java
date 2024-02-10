public class Student {

    private static final String COLLEDGE_NAME = "フリスタ大学";
    private static int countForId;
    public int id;
    public String name;
    public int age;
    
    public Student(){
        incrementId();
        this.id = countForId;
    }

    public Student name(String name){
        this.name = name;
        return this;
    }

    public Student age(int age){
        this.age = age;
        return this;
    }

    private static void incrementId(){
        countForId++;
    }

    public void showDetails(){
        System.out.format("%s [生徒ID %d] 名前: %s, 年齢: %d 歳 %n", 
                COLLEDGE_NAME, this.id, this.name, this.age
        );
    }
}
