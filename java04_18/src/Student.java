public class Student {

    int rollNo;
    String name;
    float monthFee;
    
    Student(int rollNo, String name, float monthFee) {
        this.rollNo = rollNo;
        this.name = name;
        this.monthFee = monthFee;
    }
    
    void displayDetails() {
        System.out.format(
                "出席番号:%d 氏名:%S 月謝:%.0f 円 %n",
                this.rollNo, this.name, this.monthFee
            );
    }
}