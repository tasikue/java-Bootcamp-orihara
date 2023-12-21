/*
 * キャラクター設定クラス 
 */

public class CharacterSetting {
    
    final int MAX_HP = 10;

    private String playerName;
    private int playerHp;
    private boolean isDeath = false;
    
    CharacterSetting(String playerName){
        this.playerName = playerName;
        this.playerHp = MAX_HP;
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

    public Boolean getIsDeath(){
        return isDeath;
    }
}
