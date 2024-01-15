/**
 * 従業員クラス
 * 会社の従業員を表すクラス
 * @author orihara
 * @version 1.0
 */
public class Employee {
    
    /** 従業員 ID */
    private int id;
    /** 氏名 */
    private String name;
    /** 年齢 */
    private int age;
    /** 部署 */
    private Division division;
    
    /**
     * 部署 ID を設定して自身を返す
     * @param id 部署 ID
     * @return 自身のインスタンス
     */
    public Employee id(int id) {
        this.id = id;
        return this;
    }

    /**
     * インスタンスの内容を表示する
     */
    public void showDetails() {
        System.out.printf(
                "従業員ID:%d %s（%d 歳）さんは、%s 所属です. %n",
                this.id,
                this.name,
                this.age,
                this.division.toString()
            );
    }

    /**
     * 氏名を設定して自身を返す
     * @param name 氏名
     * @return this;
     */
    public Employee name(String name) {
        this.name = name;
        return this;
    }

    /**
     * 年齢を設定して自身を返す
     * @param age 年齢
     * @return this;
     */
    public Employee age(int age) {
        this.age = age;
        return this;
    }
    /**
     * 部署インスタンスを設定して自身を返す
     * @param division 部署
     * @return 自身のインスタンス
     */
    public Employee division(Division division) {
        this.division = division;
        return this;
    }
}