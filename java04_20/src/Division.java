/**
 * 部署クラス
 * 会社の事業部を表すクラス
 * @author orihara
 * @version 1.0
 */

public class Division {
    
    /** 部署ID */
    private int id;
    /** 部署名 */
    private String name;

    /**
     * 部署 ID を設定して自信を返す
     * @param id 部署 ID
     * @return 自身のインスタンス
     */
    public Division id(int id) {
        this.id = id;
        return this;
    }
    /**
     * 部署名を設定して自身を返す
     * @param name 部署名
     * @return 自身のインスタンス
     */
    public Division name(String name) {
        this.name = name;
        return this;
    }
    /**
     * インスタンスを文字列かする
     */
    @Override
    public String toString() {
        
        return String.format(
                "部署ID:%d の %s",
                this.id,
                this.name
            );
    }
}