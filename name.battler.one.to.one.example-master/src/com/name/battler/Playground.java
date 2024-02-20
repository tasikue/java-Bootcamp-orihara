package com.name.battler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.name.battler.player.IPlayer;
import com.name.battler.player.Job;

public class Playground {

    private static List<IPlayer> players = new ArrayList<>();
    private static final int FIRST_IDX = 0;
    private static final int SECOND_IDX = 1;

    public void start() {

        this.callPlayers();

        int cntTurn = 0;

        while (this.isLive()) {
            this.battle(++cntTurn);
            this.showStatus();
        }
        System.out.println();
    }

    private void callPlayers() {

        System.out.println("[プレイヤのランダム生成] : ====================");
        try {
            players.add(this.getRandomPlayer("Joe"));
            players.add(this.getRandomPlayer("Mary"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        this.showStatus();
    }

    private void battle(int cntTurn) {

        this.showTrun(cntTurn);

        int[] attackerIndexArray = {0, 0};
        this.randomShufflePlayers(attackerIndexArray);

        System.out.print("[先攻]: ");
        players.get(attackerIndexArray[FIRST_IDX])
                .attackTo(players.get(attackerIndexArray[SECOND_IDX]));

        if (!players.get(attackerIndexArray[SECOND_IDX]).isLive())
            return;

        System.out.println("-----");
        System.out.print("[後攻]: ");
        players.get(attackerIndexArray[SECOND_IDX])
                .attackTo(players.get(attackerIndexArray[FIRST_IDX]));
    }

    private void showTrun(int cntTurn) {

        String mess = String.format("ターン(%d) : ====================", cntTurn);
        System.out.println(mess);
    }

    private void randomShufflePlayers(int[] attackerIndexArray) {

        Random rand = new Random();
        attackerIndexArray[FIRST_IDX] = rand.nextInt(2);
        attackerIndexArray[SECOND_IDX] = Math.abs(attackerIndexArray[FIRST_IDX] - 1);
    }

    private boolean isLive() {

        for (IPlayer player : players) {

            if (!player.isLive()) {

                String mess = String.format("%s は力尽きた...", player.tellName());
                System.out.println(mess);
                return false;
            }
        }

        return true;
    }

    private void showStatus() {

        for (IPlayer player : players) {
            player.showStatus();
        }
        System.out.println();
    }

    private IPlayer getRandomPlayer(String name) throws Exception {

        Class<?> clazz = Class.forName(this.getRandomInstance().className());

        IPlayer randomPlayer = (IPlayer) clazz.getDeclaredConstructor().newInstance();

        return randomPlayer.giveName(name);
    }

    private Job getRandomInstance() {

        Random rand = new Random();
        int randNum = rand.nextInt(2) + 1;

        Job job = Job.of(randNum);

        return job;
    }

}
