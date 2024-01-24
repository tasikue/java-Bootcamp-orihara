package advanced.relationship.entity;

public class Bike {
    
   private String color;
   private int maxSpeed;
   
   public void showBikeInfo(){
        System.out.format(
            "バイクの色: %s, 最高速度: %dkm %n",
            color, maxSpeed
         );
   }

   public void setColor(String color){
        this.color = color;
   }

   public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
   }
}
