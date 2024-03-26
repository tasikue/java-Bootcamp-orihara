/**
  * 絵柄を表す列挙型
  */
enum Mark{

    // 絵柄定数
    Diamonds(1),
    Hearts(2),
    Clubs(3),
    Spades(4);

    // 変数
    private int id;

    /**
     * 絵柄にIDを登録するコンストラクタ
     * @param id 絵柄のID
     */
    private Mark(int id){
        this.id = id;
    }

    /**
     * 絵柄IDを取得する処理
     * @return
     */
    public int getId(){
        return id;
    }

    /**
     * IDから絵柄を取得する処理
     * @param id 絵柄ID
     * @return 列挙型絵柄
     */
    public static Mark getMarkById(int id){
        for(Mark mark : Mark.values()){
            if(mark.getId() == id){
                return mark;
             }
        }
        return null;
    }
}
