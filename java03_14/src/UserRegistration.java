import java.util.ArrayList;
import java.util.List;

public class UserRegistration {

    public static void main(String[] args) {

        UserList users = new UserList();
        User yamamoto = new User("山本", "一郎");
        User jiro = new User("", "次郎");
        User tamada = new User("山田", "太郎");
        User yamashita = new User("山下");

        users.addUser(yamamoto);
        users.addUser(jiro);
        users.addUser(tamada);
        users.addUser(yamashita);
        users.showAllUsers();
    }
}

class User {

    public static int maxId;
    public int id;
    public String firstName;
    public String lastName;

    static {
        maxId = 0;
    }

    public User(String firstName, String lastName) {
        this.id = ++maxId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName) {
        this.id = ++maxId;
        this.firstName = firstName;
        this.lastName = null;
    }

    public boolean isValidFirstName() {
        return this.firstName != null
            && !this.firstName.isEmpty();
    }

    public boolean isValidLastName() {
        return this.lastName != null
            && !this.lastName.isEmpty();
    }
}
class UserList {

    public List<User> users;

    public UserList() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {

        if(!user.isValidFirstName()){
            System.out.printf(
                "ID %d: %s%s は登録できません. %n",
                user.id, user.firstName, user.lastName
            );
            System.out.println(" => 姓が空です. \n");
            return;
        }

        if(!user.isValidLastName()){
            System.out.printf(
                    "ID %d: %s%s は登録できません. %n",
                    user.id, user.firstName, user.lastName
                );
                System.out.println(" => 名が空です. \n");
                return;
        }

        System.out.printf(
            "ID %d: %s%s を登録しました. %n%n",
            user.id, user.firstName, user.lastName
            );
            
            this.users.add(user);
    }

    public void showAllUsers() {

        System.out.println("登録者一覧を表示します");
        System.out.println("-----");

        for (User user : this.users) {

            System.out.printf(
                "ID %d: %s%s %n",
                user.id, user.firstName, user.lastName
            );
        }
    }
}