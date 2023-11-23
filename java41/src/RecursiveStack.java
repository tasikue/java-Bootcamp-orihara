import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RecursiveStack {
    static Deque<Integer> A = new ArrayDeque<>();
    static Deque<Integer> B = new ArrayDeque<>();
    static Deque<Integer> C = new ArrayDeque<>();

    public static void main(String[] args) {
        RecursiveStack app = new RecursiveStack();
        app.fill();
        app.f();
        app.print();
    }

    void fill() {
        for (int i = 1; i <= 3; i++) {
            A.push(i);
            B.push(i);
            C.push(i);
        }
    }

    void f() {
        if (A.isEmpty()) {
            // nothing
        } else {
            C.push(A.pop());
            f();
            B.push(C.pop());
        }
    }

    private void print() {
        Map<String, Deque<Integer>> stackMap = new HashMap<>();
        stackMap.put("A", A);
        stackMap.put("B", B);
        stackMap.put("C", C);
        this.print(stackMap);
    }

    private void print(Map<String, Deque<Integer>> stackMap) {
        stackMap.forEach((k, v) -> {
            System.out.printf("%s=", k);
            for (int element : v) {
                System.out.print(element + ", ");
            }
            System.out.println();
        });
    }
}
