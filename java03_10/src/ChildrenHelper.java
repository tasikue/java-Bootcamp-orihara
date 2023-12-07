public class ChildrenHelper {

    public static void main(String[] args) {

        Child[] children = {
            new Child("山本", "一郎", Gender.MAN),
            new Child("山田", "花子", Gender.WOMAN),
            new Child("山口", "次郎", Gender.MAN),
        };

        for (Child child : children) {
            System.out.printf(
                "ID=%d のフルネームは %s です. %n",
                child.id, child.getFullNameWithHonorificTitle()
            );
        }
    }
}

enum Gender {
    MAN, WOMAN,
}

class Child {

    private static int maxId;
    public int id;
    private String firstName;
    private String lastName;
    private Gender gender;

    static {
        maxId = 0;
    }

    public Child(
            String firstName, String lastName,
            Gender gender) {
        this.id = ++maxId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getFullNameWithHonorificTitle(){
        return getFullName() + getHonorificTitle();
    }

    public String getFullName() {
        return this.firstName + this.lastName;
    }

    public String getHonorificTitle() {
        if (this.gender == Gender.MAN) return "くん";
        return "ちゃん";
    }
}