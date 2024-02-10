public class MyData {
    
    static boolean isNull(String str){
        boolean tmp = false;

        if(str == null){
            tmp = true;
        }

        return tmp;
    }

    static boolean isEmpty(String str){
        boolean tmp = false;
        
        if(isNull(str) || "".equals(str)){
            tmp = true;
        }

        return tmp;
    }

    static void showResultValidate(int id, String str){
        if(isEmpty(str)){
            System.out.format("[%d] 値が設定されていません. %n", id);
            return;
        }
        System.out.format("[%d] 値が設定されています. %n", id);
    }
}
