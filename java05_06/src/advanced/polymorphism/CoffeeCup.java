package advanced.polymorphism;

import advanced.polymorphism.liquid.Liquid;

public class CoffeeCup {
    private Liquid innerLiquid;

    public void addLiquid(Liquid liquid){

        this.innerLiquid = liquid;
    }

    public void stir(){
        System.out.println("コーヒーカップを持って .....");
        innerLiquid.stir();
    }
}