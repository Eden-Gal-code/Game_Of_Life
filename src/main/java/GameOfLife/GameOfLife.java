package GameOfLife;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JPanel {
    JFrame JF=new JFrame("Game Of Life");
    CellArr CA;
    public GameOfLife(){
        super();
        CA=new CellArr(this);
        //check
        CA.CellArr[6][6].setAlive(true);
        CA.CellArr[5][6].setAlive(true);
        CA.CellArr[5][7].setAlive(true);
        CA.CellArr[4][7].setAlive(true);
        CA.CellArr[4][5].setAlive(true);

        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(CA);
        this.addMouseListener(CA);
        this.addMouseMotionListener(CA);
        JF.add(this);
        JF.setSize(500,600);
        JF.setResizable(false);
        JF.setUndecorated(false);

        JF.setVisible(true);


        this.repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);


       CA.draw(g);
    }
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
    public static void main (String[] args){
        GameOfLife g=new GameOfLife();

    }
}
