package advanced.abstracts.animal.entity;

public abstract class Animal implements Barkable {

    private String name;
    private boolean isMale;
    private String feedingType;

    protected Animal (String name, boolean isMale, String feedingType){
        this.name = name;
        this.isMale = isMale;
        this.feedingType = feedingType;
    }

    public void eat(){
        showFeedingType();
    }

    private void showFeedingType(){
        System.out.format("%s は %s ........", this.name, this.feedingType);
    }

    @Override
    public String toString(){
        return String.format(
            "名前=%s::性別=%s::食性=%s",
            this.name, 
            toStringGender(), 
            this.feedingType
        );
    }

    public void changeName(String newName){
        this.name = newName;
    }

    private String toStringGender(){
        if(this.isMale) return "オス";
        return "メス";
    }
}
