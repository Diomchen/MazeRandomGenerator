import java.awt.*;
import java.util.LinkedList;
import java.util.Stack;

public class AlogVisualizer {
    private static int DENY = 3;
    private static int blockSide = 8;

    private MazeData data;
    private AlgoFrame frame;
    public static int d[][] = {{-1,0},{0,1},{1,0},{0,-1}};
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
        //recursion-DFS方法
//        go(data.getStartX(),data.getStartY()+1);

        //NotRecursion-DFS方法
//        Stack<Position> stack = new Stack<>();
//        Position position = new Position(data.getStartX(),data.getStartY()+1);
//        stack.push(position);
//        data.visited[position.getX()][position.getY()] = true;
//
//        while(!stack.empty()){
//            Position curPos = stack.pop();
//
//            for(int i=0 ; i<4 ; i++){
//                int newX = curPos.getX()+d[i][0]*2;
//                int newY = curPos.getY()+d[i][1]*2;
//
//                //判断是否超出范围或者是是否已经遍历过
//                if(data.inArea(newX,newY)&& !data.visited[newX][newY]){
//                    stack.push(new Position(newX,newY));
//                    data.visited[newX][newY] = true;
//                    setData(curPos.getX()+d[i][0],curPos.getY()+d[i][1]);
//                }
//            }
//        }

        //NotRecursion-BFS
        //方法就是把DFS的stack换成LinkedList
        LinkedList<Position> queue = new LinkedList<>();
        Position position = new Position(data.getStartX(),data.getStartY()+1);
        queue.addLast(position);
        data.visited[position.getX()][position.getY()] = true;

        while(queue.size() != 0){
            Position curPos = queue.removeFirst();
            for(int i=0 ; i<4 ; i++){
                int newX = curPos.getX()+d[i][0]*2;
                int newY = curPos.getY()+d[i][1]*2;

                //判断是否超出范围或者是是否已经遍历过
                if(data.inArea(newX,newY)&& !data.visited[newX][newY]){
                    queue.addLast(new Position(newX,newY));
                    data.visited[newX][newY] = true;
                    setData(curPos.getX()+d[i][0],curPos.getY()+d[i][1]);
                }
            }
        }
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

    //recursionGo
    public void go(int x,int y){
        if(!data.inArea(x,y)){
            throw new IllegalArgumentException(" x and y is oversize... ");
        }
        data.visited[x][y] = true;
        for(int i=0 ; i<4 ; i++){
            int newX = x+d[i][0]*2;
            int newY = y+d[i][1]*2;
            if(data.inArea(newX,newY) && !data.visited[newX][newY]){
                //破墙
                setData(x+d[i][0],y+d[i][1]);
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
