package com.name.battler.setting;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * ハッシュダイジェストから数値を取り出す
 * ハッシュ値は40文字の文字列
 * @param name 名前
 * @param index 何番目の数値を取り出すか, 最大20番まで
 * @return 数値(0 ～ 255)
 */

public class HashDigest {

    public int generateNumber(String name, int index) {
        
        try {
            String digest = getHashDigest(name);
            String hex = digest.substring(
                index * 2, index * 2 + 2
            );        
        
            return Integer.parseInt(hex, 16);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return 0;
    }

    public String getHashDigest(String name) {
    
        try {
            // ハッシュ値を取得する
            byte[] result =
                MessageDigest.getInstance("SHA-1")
                .digest(name.getBytes());
            
            return String.format(
                "%040x",
                new BigInteger(1, result)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
