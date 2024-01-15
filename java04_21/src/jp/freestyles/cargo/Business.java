package jp.freestyles.cargo;

import jp.freestyles.cargo.entity.Division;
import jp.freestyles.cargo.entity.Employee;
/**
 * 業務クラス
 * 処理の起点となるクラス
 * @author orihara
 * @version 1.0
 */

public class Business {

    /**
     * main メソッド
     * 従業員インスタンスを生成し、内容を表示する
     * @param args 使用しない
     */
    public static void main(String[] args) {

        Division division = new Division()
                .id(7)
                .name("ゲーム事業部");

        Employee employee = new Employee()
                .id(777)
                .name("山本一郎")
                .age(171)
                .division(division);
                
        employee.showDetails();
    }
}