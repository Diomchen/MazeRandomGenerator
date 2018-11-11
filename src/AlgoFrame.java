import javax.swing.*;
import java.awt.*;

public class AlgoFrame extends JFrame {
    private int canvasWidth;
    private int canvasHeight;

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    public AlgoFrame(String title , int canvasWidth , int canvasHeight ){
        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public AlgoFrame(String title){
        this(title,1024,768);
    }

    //data渲染
    private MazeData data;
    public void render(MazeData data){
        this.data = data;
        repaint();
    }

    private class AlgoCanvas extends JPanel{
        //双缓存
        public AlgoCanvas(){
            super(true);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth,canvasHeight);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D graphics2D = (Graphics2D)g;

            //抗锯齿
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
//
//            hints.put(RenderingHints.KEY_COLOR_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
            graphics2D.addRenderingHints(hints);

            //绘制
            int w = canvasWidth/data.getM();
            int h = canvasWidth/data.getN();

            for(int i=0 ; i<data.getN() ; i++){
                for(int j=0 ; j<data.getM() ; j++){
                    if(data.Maze[i][j] == MazeData.WALL){
                        AlgoVisHelper.setColor(graphics2D,AlgoVisHelper.LightBlue);
                    }
                    else if(data.Maze[i][j] == MazeData.ROAD){
                        AlgoVisHelper.setColor(graphics2D,AlgoVisHelper.White);
                    }
                    AlgoVisHelper.fillRectangle(graphics2D,j*w,i*h,w,h);
                }
            }


        }
    }

}
