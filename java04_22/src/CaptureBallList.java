import java.util.List;
import java.util.ArrayList;

/**
 * 捕獲玉を管理するクラス
 * @author orihara
 * @version 1.0
 */
public class CaptureBallList {
    
    List<CaptureBall> balls = new ArrayList<>();

    public void setBalls(){
        balls.add(new CaptureBall("ノーマル捕獲玉", 0, 6));
        balls.add(new CaptureBall("スーパー捕獲玉", 20, 3));
        balls.add(new CaptureBall("ミラクル捕獲玉", 50, 1));
    }
}
