public class NestedAnonymousExample {
    
    public static Hello nesteAnonymousObj = new Hello(){

        @Override
        public void sayHello(){
            System.out.println("こんにちはネストした匿名クラス");
        }
    };

    public static void main(String[] args) {
        
        Hello anonymousObj = new Hello(){

            @Override
            public void sayHello(){
                System.out.println("こんにち匿名クラス");
            }
        };

        anonymousObj.sayHello();
        NestedAnonymousExample.nesteAnonymousObj.sayHello();
    }
}
