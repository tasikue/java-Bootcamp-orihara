import java.util.List;
import java.util.ArrayList;

/**
 * 捕獲玉を管理するクラス
 * @author orihara
 * @version 1.0
 */
public class CaptureBallList {
    
    List<CaptureBall> balls = new ArrayList<>();

    /** ボールをセットする */
    public CaptureBallList(){
        balls.add(new CaptureBall("ノーマル捕獲玉", 0, 6));
        balls.add(new CaptureBall("スーパー捕獲玉", 20, 3));
        balls.add(new CaptureBall("ミラクル捕獲玉", 50, 1));
    }

    /** セットした配列の長さを取得 */
    public int getListLength(){
        return balls.size();
    }

    /** 個数が0になったボールを配列から消去する */
    public void deleteCaptureBall(){
        for(CaptureBall captureBall : balls){
            if(captureBall.getCount() == 0){
                balls.remove(captureBall);
                return ;
            }
        }
    }

    /**
     * 
     * @return 配列は空かどうか
     */
    public boolean isEmptyBallList(){
        return balls.isEmpty();
    }

    /** 
     * インデックスで指定してボールを取得する
     * @param index リストの指定するインデックス
     * @return 指定したボールクラス
     */
    public CaptureBall getCaptureBall(int index){
        return balls.get(index);
    }
}
