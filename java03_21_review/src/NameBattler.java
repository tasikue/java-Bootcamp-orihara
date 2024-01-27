import java.util.Scanner;
import java.util.Random;

/*
 * メイン
 */

// ▼Javadocコメントをクラス・メソッドにつける癖をつけよう。

// ▼全体的にコメントが少ない。
// 主にコメントを付ける場所
//  1.クラス・メソッドにはjavadocコメントを付ける(これはルールとして絶対付けて)
//  2.メンバー変数
//  3.if文やfor・whileなどのループの前
//  4.メソッドの呼び出し
//  5.設計的思想に基づいている処理(+1して調整している箇所などパッと見で意図が分からない場所など)

// ▼表示しているメッセージの文言も定数にしてみよう

public class NameBattler {

    final static int NUMBER_OF_PLAYER = 2;
    final static int MAX_HUSH = 256;

    // 日本語入力文字化け対策 Shift-JIS or UTF-8
    static Scanner scan = new Scanner(System.in, "Shift-JIS");
    static Random ram = new Random();

    // ▼mainメソッドはプログラム起動時に最初に実行されるメソッド
    // 基本的にmainメソッドに処理はほとんど書かない
    // プログラム全体の流れを書いたメソッドを別に呼び出すイメージ
    public static void main(String[] args) throws Exception {

        String[] playerNamelist = new String[NUMBER_OF_PLAYER];

        // 全プレイヤー名設定
        for (int i = 0; i < NUMBER_OF_PLAYER; i++) {
            playerNamelist[i] = inputNameText(i + 1);
        }

        // プレイヤーの作成
        CharacterSetting Player1 = new CharacterSetting(playerNamelist[0]);
        CharacterSetting Player2 = new CharacterSetting(playerNamelist[1]);

        StatusChack.statusChack(Player1, Player2);

        SystemText.showBattleStartText();
        playMainBattle(Player1, Player2);
        SystemText.showBattleEndText(Player1, Player2);
    }

    // ▼Player1,Player2,PlayerA,PlayerBと統一感が無く、分かりずらい。
    static void playMainBattle(CharacterSetting PlayerA, CharacterSetting PlayerB) {

        while (!PlayerA.getIsDeath() || !PlayerB.getIsDeath()) {
            // player1 -> player2
            showBattleDamege(PlayerA, PlayerB);

            if (PlayerB.getPlayerHp() <= 0) {
                PlayerB.onIsDeath();
                return;
            }

            // player 2 -> player1
            showBattleDamege(PlayerB, PlayerA);

            if (PlayerA.getPlayerHp() <= 0) {
                PlayerA.onIsDeath();
                return;
            }

            SystemText.showTurnChangeText(PlayerA, PlayerB);
        }
    }

    static String inputNameText(int playerNumber) {

        System.out.printf("プレイヤー %d の名前を入力してください: ", playerNumber);
        // ▼入力処理を行う場合は入力チェック処理を入れよう
        // 今回は時に指定とかはないけど、意図せずエラーになって処理が落ちないようにtry catch処理を入れておく事を意識しよう
        String playerName = scan.nextLine();

        return playerName;
    }

    private static boolean isLuck(CharacterSetting Player) {

        // 乱数0-255
        int dice = ram.nextInt(MAX_HUSH);
        return Player.getPlayerLuck() - dice >= 0;
    }

    private static int getDamageCalc(CharacterSetting PlayerA, CharacterSetting PlayerB) {

        int attackDamage = PlayerA.getPlayerStr() - PlayerB.getPlayerDef();

        // ダメージがマイナスになる場合
        if (attackDamage < 0) {
            attackDamage = 1;
        }

        // 乱数0-attack
        return ram.nextInt(attackDamage);
    }

    // ▼メソッド名と処理内容が合っていない
    // メソッド名からは「バトルのダメージ結果を表示するメソッド」と読み手は受け取れる
    // 実際の処理は以下の4つを行っている。
    // 1.ダメージの計算
    // 2.会心の一撃判定
    // 3.防御側のHP計算
    // 4.攻撃中の文言表示
    private static void showBattleDamege(CharacterSetting PlayerA, CharacterSetting PlayerB) {
        // ▼呼び出し元でPlayerA,PlayerBが逆になっているパターンもあるので、ややこしい。
        // バトル内メソッドであれば、「attcker」「defender」とか分かりやすくしてもいいかも
        int damage = getDamageCalc(PlayerA, PlayerB);
        System.out.printf("%sの攻撃！\n", PlayerA.getPlayerName());

        // 会心の一撃
        if (isLuck(PlayerA)) {
            damage = PlayerA.getPlayerStr();
            System.out.println("会心の一撃！");
        }

        PlayerB.decreasePlayerHp(damage);

        if (damage == 0) {
            System.out.println("攻撃がミス");
            return;
        }
        System.out.printf("%sに %d のダメージ！\n", PlayerB.getPlayerName(), damage);
    }
}
