package advanced.superkey.entity;

public class Dog extends Animal{
    
    public Dog(){

        super("[Dog] String 引数のコンストラクタを呼び出し");

        System.out.printf("[Dog] %s Dog クラスを生成しました.\n", super.type);
    }

    @Override
    public void bark(String sound) {
        super.bark("わんわん" + sound);
    }
}
