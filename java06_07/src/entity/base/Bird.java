package entity.base;

import entity.Pigeon;
import exception.AppException;
import exception.ErrorCode;

public abstract class Bird {

    protected String className;
    protected String name;

    protected Bird(String name) {
        this.name = name;
        this.className = "Bird";
    }

    public boolean isEmptyName() {

        boolean isEmptyName = false;
        try {
            isEmptyName = this.name.equals("");
        } catch (NullPointerException e) {
            throw new AppException(ErrorCode.UNEXPECTED, e);
        }
        return isEmptyName;
    }

    public void fly() {
        System.out.format(
                "[%s] %s が飛んだ. %n",
                this.className, this.name);
    }

    public static Pigeon convertToPigeon(Bird bird){
        Pigeon pigeon;
        try {
            pigeon = (Pigeon) bird;
        } catch (ClassCastException e) {
            throw new AppException(ErrorCode.UNEXPECTED, e);
        }
        return pigeon;
    }
}