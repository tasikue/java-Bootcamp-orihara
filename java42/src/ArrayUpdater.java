public class ArrayUpdater {
    public static void main(String[] args) {
        
        int[] num = {1, 2, 3, 4, 5};

        ArrayUpdater up = new ArrayUpdater();
        up.updateArray(num);

        for(int i : num){
            System.out.println(i);
        }
    }

    public void updateArray(int[] arr){
        int len = arr.length;
        int[] tmp = new int[len];

        for(int n=0; n<len; n++){
            tmp[n] = arr[n];
        }

        for(int m=0; m<len; m++){
            arr[m] = tmp[len-m-1];
        }
    }
}
