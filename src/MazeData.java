public class MazeData {

    public static final char ROAD = ' ';
    public static final char WALL = '#';

    private int M,N;
    //   N：行      M:列
    public int getM() {
        return M;
    }

    public int getN() {
        return N;
    }

    public char[][] Maze;

    public void setMaze(char[][] maze) {
        Maze = maze;
    }

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
                    Maze[i][j] = ROAD;
                }
                else{
                    Maze[i][j] = WALL;
                }
            }
        }
        startX = 1;
        startY = 0;
        endX = N-2;
        endY = M-1;
        Maze[startX][startY] = Maze[endX][endY] = ROAD;
    }
}
