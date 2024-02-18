package animal.entity;

public abstract class Animal implements Barkable {

    public enum Gender {
        MAN("オス"),
        WOMAN("メス");

        String name;

        private Gender(String name){
            this.name = name;
        }

        public String getName(){
            return this.name;
        }
    }

    // 食性
    public enum FeedingType{
        CARNI("肉食"), // 肉食
        HERBI("草食"), // 草食
        OMNI("雑食"); // 雑食

        String name;

        private FeedingType(String name){
            this.name = name;
        }

        public String getName(){
            return this.name;
        }
    }

    private String name;
    private Gender gender;
    private FeedingType feedingType;
   
    protected Animal(String name, Gender gender, FeedingType feedingType) {
        this.name = name;
        this.gender = gender;
        this.feedingType = feedingType;
    }

    public void eat() {
        showFeedingType();
    }

    private void showFeedingType() {
        System.out.format(
                "%s は %s ........", this.name, this.feedingType
            );
    }

    @Override
    public String toString() {

        return String.format(
                "名前=%s::性別=%s::食性=%s",
                this.name,
                this.gender.getName(),
                this.feedingType.getName()
            );
    }

    public void changeName(String newName) {
        
        this.name = newName;
    }
}