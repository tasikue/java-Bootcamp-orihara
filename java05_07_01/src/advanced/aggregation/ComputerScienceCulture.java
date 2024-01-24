package advanced.aggregation;

import java.util.ArrayList;
import java.util.List;

import advanced.aggregation.entity.Department;
import advanced.aggregation.entity.GraduateStudent;
import advanced.aggregation.entity.Institute;

/**
 * コンピュータ工学系を扱うクラス
 * 集約 Aggregation の概念を説明する Java プログラム
 */
class ComputerScienceCulture {

    public static void main(String[] args) {

        GraduateStudent[] students = {
            new GraduateStudent("山本一郎", 1, "CSE: Computer Science Engineering"),
            new GraduateStudent("山下花子", 2, "CSE: Computer Science Engineering"),
            new GraduateStudent("山口恵美", 1, "EE: Electrical Engineering"),
            new GraduateStudent("山田太郎", 2, "EE: Electrical Engineering"),
        };

        // making a List of
        // CSE Students.
        List<GraduateStudent> cseStudents = new ArrayList<GraduateStudent>();
        cseStudents.add(students[0]);
        cseStudents.add(students[1]);

        // making a List of
        // EE Students
        List<GraduateStudent> eeStudents = new ArrayList<GraduateStudent>();
        eeStudents.add(students[2]);
        eeStudents.add(students[3]);
        
        Department cse = new Department("CSE", cseStudents);
        Department ee = new Department("EE", eeStudents);
        
        List<Department> departments = new ArrayList<Department>();
        departments.add(cse);
        departments.add(ee);
        
        Institute institute = new Institute(
                "CSNT: 名工大情報理工学系研究所", departments
            );
        System.out.print("研究所に所属する生徒数: ");
        System.out.print(institute.getTotalStudentsInInstitute());
    }
}