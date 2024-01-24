package advanced.aggregation.entity;

import java.util.List;

/**
 * 研究所クラス
 * 研究所クラスは学科インスタンスのリストを持っている
 * インスタンスを通じて学科クラスと関連している
 */
public class Institute {

    private String instituteName;
    private List<Department> departments;

    public Institute(String instetuteNsme, List<Department> departments){
        this.instituteName = instetuteNsme;
        this.departments = departments;
    }

    /**
     * 大学院生の人数を数える 
     * @return 大学院生の人数
     */
    public int getTotalStudentsInInstitute(){
        int noOfstudents = 0;
        List<GraduateStudent> students;

        for(Department dept : departments){
            students = dept.getStudents();
            for(GraduateStudent s : students){
                noOfstudents++;
            }
        }
        return noOfstudents;
    }
    
}
