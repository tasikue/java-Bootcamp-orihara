/*
 * キャラクター設定クラス 
 */

public class CharacterSetting {
    
    HashDigest Hash = new HashDigest();

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
    
    CharacterSetting(String playerName){
        this.playerName = playerName;
        this.playerHp = Hash.generateNumber(playerName, hashHpIndex);
        this.playerStr = Hash.generateNumber(playerName, hashStrIndex);
        this.playerDef = Hash.generateNumber(playerName, hashDefIndex);
        this.playerLuck = Hash.generateNumber(playerName, hashLuckIndex);
    }

    public void onIsDeath(){
        isDeath = true;
    }

    public void decreasePlayerHp(int damage){
        playerHp -= damage;
    }

    public String getPlayerName(){
        return playerName;
    }

    public int getPlayerHp(){
        return playerHp;
    }

    public int getPlayerStr(){
        return playerStr;
    }

    public int getPlayerDef(){
        return playerDef;
    }

    public int getPlayerLuck(){
        return playerLuck;
    }

    public Boolean getIsDeath(){
        return isDeath;
    }
}
