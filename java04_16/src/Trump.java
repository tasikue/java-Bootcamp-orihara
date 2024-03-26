/**
 * javabootcamp 04-16
 * 課題1
 * Trump
 */
public class Trump {

    // 変数
    /** トランプ数値 */
    private int number;
    /** 絵柄ID */
    private int markId;
    
    /** 
     * トランプカードを設定するコンストラクタ
     * mark: 1-4, number: 1-13
     * @param markId 絵柄ID
     * @param number トランプ数値
     */
    Trump(int markId, int number){
        this.markId = markId;
        this.number = number;
    }
    
    /**
     * カードの番号を文字列で出力する処理
     * @return 数値文字列
     */
    public String toString(){

        switch(this.number){
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return String.valueOf(this.number);
        }
    }
    
    /**
     * トランプの数値を出力する処理
     * @return 数値
     */
    public int getNumber(){
        return this.number;
    }

    /**
     * トランプの絵柄文字列を出力する処理
     * @return 絵柄文字列
     */
    public String getMark(){
        return Mark.getMarkById(markId).toString();
    }
}