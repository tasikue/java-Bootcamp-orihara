package com.name.battler.magic;

public enum MagicType {
    
    FIRE(1, "Fire", 20, 30, 0),
    HEAL(2, "Heal", 10, 0, 20),
    ;

private final String MAGIC_PKG_PATH = "com.name.battler.magic";

    private final int id;
    private final String name;
    private final int mp;
    private final int recoveryPoint;
    private final int power;

    private MagicType(final int id, final String name, final int mp, final int power, final int recoveryPoint) {

        this.id = id;
        this.name = name;
        this.mp = mp;
        this.recoveryPoint = recoveryPoint;
        this.power = power;
    }

    public static MagicType of(final int id) {

        MagicType[] magics = MagicType.values();

        for (MagicType magic : magics) {

            if (magic.getId() == id) {

                return magic;
            }
        }
        return null;
    }

    public int getId() {

        return this.id;
    }

    public String getName() {

        return this.name;
    }

    public int mp() {
        return this.mp;
    }

    public int power() {
        return this.power;
    }

    public int recoveryPoint() {
        return this.recoveryPoint;
    }

    public String getClassName() {
        String className = String.format("%s.%s", MAGIC_PKG_PATH, this.name);
        return className;
    }

}