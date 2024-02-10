public class DataChecker {

    public static void main(String[] args) {

        int id = 0;
        
        String nullMessage = null;
        MyData.showResultValidate(++id, nullMessage);
        
        String emptyMessage = "";
        MyData.showResultValidate(++id, emptyMessage);
        
        String notEmptyMessage = "山本一郎";
        MyData.showResultValidate(++id, notEmptyMessage);
    }
}