package advanced.aggregation.entity;

/**
 * 大学院生をあらわすクラス
 */
public class GraduateStudent {
    
    private String name;
    private int id;
    private String dept;

    public GraduateStudent(String name, int id, String dept){
        
        this.name = name;
        this.id = id;
        this.dept = dept;
    }
}
