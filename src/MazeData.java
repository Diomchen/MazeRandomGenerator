public class MazeData {

    public static final char ROAD = ' ';
    public static final char WALL = '#';

    public boolean[][] visited ;
    public boolean [][] inMist;
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

    public int startX,startY,endX,endY;

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public MazeData(int N, int M){
        if(M%2==0 || N%2==0){
            throw new IllegalArgumentException("M and N is Illegal!");
        }

        this.M = M;
        this.N = N;

        Maze = new char[N][M];
        visited = new boolean[N][M];
        inMist = new boolean[N][M];

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++) {
                if (i % 2 != 0 && j % 2 != 0) {
                    Maze[i][j] = ROAD;
                } else {
                    Maze[i][j] = WALL;
                }
                visited[i][j] = false;
                inMist[i][j] = true;
            }
        }
        this.startX = 1;
        this.startY = 0;
        this.endX = N-2;
        this.endY = M-1;
        Maze[startX][startY] = Maze[endX][endY] = ROAD;
    }

    public boolean inArea(int x,int y){
        return x>0 && y>0 && x<N && y<M;
    }

    public void openMist(int x,int y){
        if(!inArea(x,y)){
            throw new IllegalArgumentException("error");
        }
        for(int i=x-1 ; i<= x+1 ; i++){
            for(int j=y-1 ; j<= y+1 ; j++){
                if(i>=0||i<N||j>=0||j<M){
                    inMist[i][j] = false;
                }
            }
        }
    }
}
