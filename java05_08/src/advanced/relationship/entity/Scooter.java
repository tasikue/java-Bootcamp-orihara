package advanced.relationship.entity;

public class Scooter extends Bike {

        private Engine scooterEngine;

        public Scooter(){
            this.scooterEngine = new Engine();
        }

        public void driveStart(){
            scooterEngine.start();
        }

        public void driveStop(){
            scooterEngine.stop();
        }
}
