import java.awt.*;

public class AlogVisualizer {
    private static int DENY = 5;
    private static int blockSide = 8;

    private MazeData data;
    private AlgoFrame frame;

    public AlogVisualizer(int N , int M){
        data = new MazeData(N,M);
        int sceneHeight = data.getN()*blockSide;
        int sceneWidth = data.getM()*blockSide;

        EventQueue.invokeLater(()->{
            frame = new AlgoFrame("Maze",sceneWidth,sceneHeight);
            new Thread(() -> {
                run();
            }).start();
        });
    }

    public void run(){
        setData();
    }

    public void setData(){
        frame.render(data);
        AlgoVisHelper.pause(DENY);
    }

    public static void main(String[] args) {
        int M = 101;
        int N = 101;
        AlogVisualizer alogVisualizer = new AlogVisualizer(N,M);
    }
}
