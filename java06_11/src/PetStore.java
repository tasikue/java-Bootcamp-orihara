public class PetStore{

    public static void main(String[] args){

        Cage<Bird> birdCage = new Cage<>();
        birdCage.addBird(new Eagle("ハクトウワシ"));
        birdCage.addBird(new Pigeon("伝書鳩"));
        birdCage.addBird(new Eagle("オジロワシ"));
        
        for (Bird bird : birdCage.getBirds()) {
            bird.fly();
            bird.showDetails();
            System.out.println();
        }
    }
}