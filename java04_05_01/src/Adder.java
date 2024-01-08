public class Adder {
    
    public void showReasultAdded(int a, int b){
        System.out.printf("%d + %d = %d \n", a, b, a+b);
    }

    public void showReasultAdded(int... args){

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<args.length; i++){
            if(isNotFirstIndex(i)){
                sb.append(" + ");
            }

            sb.append(String.valueOf(args[i]));
        }

        System.out.printf("%s = %d \n", sb.toString(), add(args));
    }

    private boolean isNotFirstIndex(int num){
        return num != 0;
    }

    private int add(int... args){
        int sum = 0;

        for(int element : args){
            sum += element; 
        }

        return sum;
    }
}
