package advanced.delegation;

import advanced.delegation.worker.Boss;
import advanced.delegation.worker.Secretary;

public class Company {

    public static void main(String[] args) {

        Secretary secretary = new Secretary();
        Boss bossWithSecretary = new Boss();
        
        bossWithSecretary.callSecretary(secretary);
        bossWithSecretary.work();
        
        Boss bossWithNoSecretary = new Boss();
        bossWithNoSecretary.work();
    }
}