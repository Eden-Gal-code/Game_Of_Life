package GameOfLife;
import java.awt.*;
public class cell {

    boolean alive=false;

    public cell(){

    }

    public boolean IfAlive(){

        return alive;


    }
    public void setAlive(boolean a){
        alive=a;
    }
    public void draw(Graphics g,int x,int y){
        g.setColor(Color.BLACK);
        g.drawRect(x*10, y*10, 10, 10);


        if (alive){
            g.setColor(Color.BLACK);
            g.fillRect(x*10,y*10,10,10);
        }
    }
}
