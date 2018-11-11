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
        setData(-1,-1);

        go(data.getStartX(),data.getStartY()+1);

        setData(-1,-1);
    }

    public void setData(int x,int y){
        //判断是否是在范围内
        if(data.inArea(x,y)){
            data.Maze[x][y] = MazeData.ROAD;
        }
        frame.render(data);
        AlgoVisHelper.pause(DENY);
    }

    public void go(int x,int y){
        if(!data.inArea(x,y)){
            throw new IllegalArgumentException(" x and y is oversize... ");
        }
        data.visited[x][y] = true;
        for(int i=0 ; i<4 ; i++){
            int newX = x+MazeData.d[i][0]*2;
            int newY = y+MazeData.d[i][1]*2;
            if(data.inArea(newX,newY) && !data.visited[newX][newY]){
                //破墙
                setData(x+MazeData.d[i][0],y+MazeData.d[i][1]);
                go(newX,newY);
            }
        }
    }

    public static void main(String[] args) {

        int M = 101;
        int N = 101;
        AlogVisualizer alogVisualizer = new AlogVisualizer(N,M);
    }
}
