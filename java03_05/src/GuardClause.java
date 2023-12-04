public class GuardClause {
    public static void main(String[] args) {

        int[] targets = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, };
        String[] results = new String[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            if (targets[i] % 2 == 0) {
                results[i] = "even";
                continue;
            }
            
            results[i] = "odd";
        }
        
        for (int i = 0; i < targets.length; i++) {
            System.out.printf(
                "%d => %s %n",
                targets[i], results[i]
            );
        }
    }
}