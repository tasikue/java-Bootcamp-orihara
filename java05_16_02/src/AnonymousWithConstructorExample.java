public class AnonymousWithConstructorExample {
    
    public static void main(String[] args) {
        
        Hello anonymousObj = new Hello("山本一郎"){

            @Override
            public void sayHello(){
                System.out.format("こんにちは匿名クラスの %s さん %n", this.name);
            }
        };

        anonymousObj.sayHello();
    }
}
