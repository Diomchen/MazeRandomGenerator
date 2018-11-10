public class MazeData {

    private static final char ROAD = ' ';
    private static final char WALL = '#';

    private int M,N;
    //   N：行      M:列
    private char[][] Maze;

    private int startX,startY,endX,endY;

    public MazeData(int N,int M){
        if(M%2==0 || N%2==0){
            throw new IllegalArgumentException("M and N is Illegal!");
        }

        this.M = M;
        this.N = N;

        Maze = new char[N][M];

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                if(i%2!=0 && j%2!=0){
                    Maze[i][j] = ' ';
                }
                else{
                    Maze[i][j] = '#';
                }
            }
        }
        startX = 0;
        startY = 1;
        endX = N-2;
        endY = M-1;
        Maze[startX][startY] = Maze[endX][endY] = ROAD;
    }
}
