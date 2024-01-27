/*
 * キャラクター設定クラス 
 */

public class CharacterSetting {

    HashDigest Hash = new HashDigest();

    // ▼定数の命名規則はスネークケースで
    // 例）hashHpIndex ⇒ HASH_HP_INDEX
    final int hashHpIndex = 0;
    final int hashStrIndex = 1;
    final int hashDefIndex = 2;
    final int hashLuckIndex = 3;

    private String playerName;
    private int playerHp;
    private int playerStr;
    private int playerDef;
    private int playerLuck;
    private boolean isDeath = false;

    CharacterSetting(String playerName) {
        this.playerName = playerName;
        this.playerHp = Hash.generateNumber(playerName, hashHpIndex);
        this.playerStr = Hash.generateNumber(playerName, hashStrIndex);
        this.playerDef = Hash.generateNumber(playerName, hashDefIndex);
        this.playerLuck = Hash.generateNumber(playerName, hashLuckIndex);
    }

    // ▼onはメソッド名としては分かりずらい
    // フラグの更新になるから有効にするなら「valid」「enabled」とかの方がしっくりくる。
    // 値の更新などなら「update」、フラグの有効/無効切り替えなら「switch」なんかの方がプログラムではよく使われる。
    // https://blog.77jp.net/guidelines-for-variables-and-method-names-summary
    // https://codic.jp/engine
    public void onIsDeath() {
        isDeath = true;
    }

    // ▼今はダメージを受けるだけだけど、将来的に回復する事もあるかもだから、「update」とかの方が良いと思うよ。
    public void decreasePlayerHp(int damage) {
        playerHp -= damage;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerHp() {
        return playerHp;
    }

    public int getPlayerStr() {
        return playerStr;
    }

    public int getPlayerDef() {
        return playerDef;
    }

    public int getPlayerLuck() {
        return playerLuck;
    }

    public Boolean getIsDeath() {
        return isDeath;
    }
}
