public class Child {
    
    private final int ADULT_AGE = 18; 
    private String name;
    private int age;

    public void showDetails(){
        System.out.printf("%s は %d 歳です．\n", this.name, this.age);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        validAge(age);
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    private void validAge(int age){
        isNotAdult(age);
        isPositiveAge(age);
    }

    private void isNotAdult(int age){
        if(age >= ADULT_AGE){
            String message = String.format("年齢は %d 未満で指定してください. ", ADULT_AGE);

            throw new IllegalArgumentException(message);
        }
    }

    private void isPositiveAge(int age){
        if(age <= 0){
            String message = String.format("年齢は正数で指定してください. ");

            throw new IllegalArgumentException(message);
        }
    }
}
