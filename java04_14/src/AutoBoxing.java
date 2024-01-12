/**
 * AutoBoxing
 */
public class AutoBoxing {

    public static void main(String[] args) {
        
        AutoBoxing app = new AutoBoxing();
        final int PRIMITIVE_INT = 12;

        Integer autoboxing = app.autobox(PRIMITIVE_INT);
        System.out.printf("%d\n", autoboxing);

        int unbox = app.unbox(autoboxing);
        System.out.printf("%d\n", unbox);
    }

    public Integer autobox(int primitiveInt){
        return primitiveInt;
    }

    public int unbox(Integer wrapperInt){
        return wrapperInt;
    }
}