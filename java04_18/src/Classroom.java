public class Classroom {

    public static void main(String[] args) {

        Student[] students = {
            new Student(111, "山本一郎", 5000f),
            new Student(112, "山下次郎", 6000f),
        };
        
        for (Student student : students) {
            student.displayDetails();
        }
    }
}