public class ClassRoom {

    public static void main(String[] args) {

        Student[] students = {
                new Student().name("山本一郎").age(3),
                new Student().name("山下次郎").age(312),
                new Student().name("山口三郎").age(79),
                new Student().name("山田太郎").age(2),
            };
            
        students[0].showDetails();
        students[2].showDetails();
        students[3].showDetails();
    }
}