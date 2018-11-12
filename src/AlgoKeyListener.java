import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AlgoKeyListener extends KeyAdapter {
    private MazeData data;
    private AlgoFrame frame;
    private boolean isPath;

    public static int d[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    private final int DENY = 5;

    public AlgoKeyListener(MazeData data,AlgoFrame frame){
        this.data = data;
        this.frame = frame;
    }

    @Override
    public void keyReleased(KeyEvent event){
        if(event.getKeyChar() == ' '){
            System.out.println("Come...");
            for(int i=0 ; i<data.getN() ; i++){
                for(int j=0 ; j<data.getM() ; j++){
                    data.visited[i][j] = false;
                }
            }
            new Thread(()->{
               run();
            }).start();
        }
    }

    private void run(){
        setData(-1,-1,false);

        GoLine(data.getStartX(),data.getStartY()+1);

        setData(-1,-1,false);
    }

    private void setData(int x ,int y,boolean isPath){
        if(data.inArea(x,y)){
            data.path[x][y] = isPath;
        }
        frame.render(data);
        AlgoVisHelper.pause(DENY);
    }

    private boolean GoLine(int x,int y){
        if(!data.inArea(x,y)){
            throw new IllegalArgumentException("error");
        }
        data.visited[x][y] = true;
        setData(x,y,true);
        if (x == data.getEndX() && y == data.getEndY()){
            return true;
        }

        for(int i=0 ; i<4 ; i++){
                int newX = x+d[i][0];
                int newY = y+d[i][1];
                if(data.inArea(newX,newY) && !data.visited[newX][newY] && data.Maze[newX][newY] == MazeData.ROAD){
                    if(GoLine(newX,newY)){
                        return true;
                    }
                }
        }
        setData(x,y,false);
        return false;
    }

}
