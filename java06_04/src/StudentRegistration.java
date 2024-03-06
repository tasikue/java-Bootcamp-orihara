import java.util.ArrayList;
import java.util.List;


public class StudentRegistration {

    public static void main(String[] args) {

        StudentList studentList = new StudentList();

        Student yamamoto = new Student("山本", "一郎");
        Student jiro = new Student("", "次郎");
        Student tamada = new Student("山田", "太郎");
        Student yamashita = new Student("山下");

        List<Student> students = new ArrayList<>();
        students.add(yamamoto);
        students.add(jiro);
        students.add(tamada);
        students.add(yamashita);

        for(Student student : students){
            try { 
                studentList.addStudent(student);
            } catch (AppException e){
                String message = e.getMessage();
                System.out.println(message);
            }
        }

        studentList.showAllStudents();
    }
}
class Student {

    public static int maxId;
    public int id;
    public String firstName;
    public String lastName;

    static {
        maxId = 0;
    }

    public Student(String firstName, String lastName) {
        this.id = ++maxId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName) {
        this.id = ++maxId;
        this.firstName = firstName;
        this.lastName = null;
    }

    public boolean isValidFirstName() {
        return this.firstName != null
            && !this.firstName.isEmpty();
    }

    public boolean isValidLastName() {
        return this.lastName != null
            && !this.lastName.isEmpty();
    }
}

class StudentList {
    public List<Student> students;

    public StudentList() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (!student.isValidFirstName()) {

            String errorMessage =
                String.format(
                    "ID %d: %s%s は登録できません. %n"
                    + " => 姓が空です. \n",
                    student.id,
                    student.firstName,
                    student.lastName);

            throw new AppException(errorMessage);
        }

        if (!student.isValidLastName()) {
            
            String errorMessage =
                String.format (
                "ID %d: %s%s は登録できません. %n"
                + " => 名が空です. \n",
                student.id,
                student.firstName,
                student.lastName);

                throw new AppException(errorMessage);
        }

        if (student.isValidLastName()) {
            System.out.printf(
                "ID %d: %s%s を登録しました. %n%n",
                student.id,
                student.firstName,
                student.lastName
            );
            this.students.add(student);
        }
    }

    public void showAllStudents() {
        System.out.println("登録者一覧を表示します");
        System.out.println("-----");
        for (Student student : this.students) {
            System.out.printf(
                "ID %d: %s%s %n",
                student.id,
                student.firstName,
                student.lastName
            );
        }
    }
}

class AppException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AppException(String errorMessage) {
        super(errorMessage);
    }
}