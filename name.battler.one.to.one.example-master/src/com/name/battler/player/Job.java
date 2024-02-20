package com.name.battler.player;

public enum Job {
    
    FIGHTER(1, "Fighter", 200, 0, 40),
    PRIEST(2, "Priest", 100, 100, 20),
    ;

private final String PLAYER_PKG_PATH = "com.name.battler.player";

    private final int id;
    private final String job;
    private final int hp;
    private final int mp;
    private final int str;

    private Job(final int id, final String job, final int hp, final int mp, final int str) {

        this.id = id;
        this.job = job;
        this.hp = hp;
        this.mp = mp;
        this.str = str;
    }

    public static Job of(final int id) {

        Job[] jobs = Job.values();

        for (Job job : jobs) {

            if (job.id() == id) return job;
        }
        return null;
    }

    public int id() {
        return this.id;
    }

    public String job() {
        return this.job;
    }

    public int hp() {
        return this.hp;
    }

    public int mp() {
        return this.mp;
    }

    public int str() {
        return this.str;
    }

    public String className() {

        String className = String.format("%s.%s", PLAYER_PKG_PATH, this.job);
        return className;
    }

}