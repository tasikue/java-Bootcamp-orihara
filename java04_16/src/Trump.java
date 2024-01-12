/**
 * javabootcamp 04-16
 * 課題1
 * Trump
 */
public class Trump {

    protected enum Mark{
        Diamonds(1),
        Hearts(2),
        Clubs(3),
        Spades(4);

        private int id;
        private Mark(int id){
            this.id = id;
        }

        public int getId(){
            return id;
        }

        // idからMarkを特定する
        public static Mark getById(int id){
            for(Mark mark : Mark.values()){
                if(mark.getId() == id){
                    return mark;
                }
            }
            return null;
        }
    }

    private int number;
    private int markIndex;
    
    // mark: 1-4, number: 1-13
    Trump(int mark, int number){
        this.markIndex = mark;
        this.number = number;
    }
    
    // カードの番号を文字列にする
    private String changeNumberIntToString(int number){

        switch(number){
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return String.valueOf(number);
        }
    }
    
    public String getTrumpNumber(){
        return changeNumberIntToString(number);
    }

    public String getTrumpMark(){
        return Mark.getById(markIndex).toString();
    }
}