package advanced.aggregation.entity;

import java.util.List;

/**
 * 学科クラス
 * 学科クラスは大学院生インスタンスのリストを持っている
 * インスタンスを通じて大学院生クラスと関連している
 */
public class Department {

    private String name;
    private List<GraduateStudent> students;
    
    public Department(String name, List<GraduateStudent> student){

        this.name = name;
        this.students = student;
    }

    public List<GraduateStudent> getStudents(){
        return this.students;
    }
}
