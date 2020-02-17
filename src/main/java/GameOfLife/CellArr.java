package GameOfLife;


import java.awt.*;
import java.awt.event.*;

public class CellArr implements KeyListener, MouseListener, MouseMotionListener {
    cell CellArr[][] = new cell[50][50];
    GameOfLife GoL;
    int countGen = 0;

    public CellArr(GameOfLife gl) {
        for (int y = 0; y < CellArr.length; y++) {
            for (int x = 0; x < CellArr.length; x++) {
                CellArr[y][x] = new cell();
            }
        }

        GoL = gl;
    }

    public void Generation() {
        cell temp[][] = new cell[50][50];
        countGen++;

        for (int y = 0; y < CellArr.length; y++) {
            for (int x = 0; x < CellArr.length; x++) {
                temp[y][x] = new cell();
                temp[y][x].setAlive(CheckIfAlive(y, x));

            }
        }
        CellArr = temp;
    }

    public boolean CheckIfAlive(int x, int y) {
        int numOfCellsAroundAlive = 0;
        if (x - 1 >= 0 && CellArr[x - 1][y].IfAlive()) {
            numOfCellsAroundAlive++;
        }
        if (x - 1 >= 0 && y - 1 >= 0 && CellArr[x - 1][y - 1].IfAlive()) {
            numOfCellsAroundAlive++;
        }
        if (y - 1 >= 0 && CellArr[x][y - 1].IfAlive()) {
            numOfCellsAroundAlive++;
        }
        if (x + 1 < CellArr.length && y - 1 >= 0 && CellArr[x + 1][y - 1].IfAlive()) {
            numOfCellsAroundAlive++;
        }
        if (x + 1 < CellArr.length && CellArr[x + 1][y].IfAlive()) {
            numOfCellsAroundAlive++;
        }
        if (x + 1 < CellArr.length && y + 1 < CellArr.length && CellArr[x + 1][y + 1].IfAlive()) {
            numOfCellsAroundAlive++;
        }
        if (y + 1 < CellArr.length && CellArr[x][y + 1].IfAlive()) {
            numOfCellsAroundAlive++;
        }
        if (y + 1 < CellArr.length && x - 1 >= 0 && CellArr[x - 1][y + 1].IfAlive()) {
            numOfCellsAroundAlive++;
        }
        if (CellArr[x][y].IfAlive()) {
            if (numOfCellsAroundAlive == 3 || numOfCellsAroundAlive == 2) {
                return true;

            } else {
                return false;
            }
        } else {
            if (numOfCellsAroundAlive == 3) {
                return true;
            } else {
                return false;
            }
        }

    }

    public void draw(Graphics g) {
        for (int y = 0; y < CellArr.length; y++) {
            for (int x = 0; x < CellArr.length; x++) {
                CellArr[y][x].draw(g, x, y);
            }
        }
        g.setFont(new Font(Font.DIALOG, Font.ITALIC, 50));
        g.drawString("Generation: " + countGen, 75, 550);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void Restart() {
        for (int y = 0; y < CellArr.length; y++) {
            for (int x = 0; x < CellArr.length; x++) {
                CellArr[y][x] = new cell();
            }
        }
        countGen = 0;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.Generation();
            //TODO draw evey generation
            GoL.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_R) {
            this.Restart();
            GoL.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {


    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point locSc = e.getLocationOnScreen();
        Point locJF = GoL.JF.getLocation();
        Point locOnArr = new Point((locSc.x - locJF.x) / 10, ((locSc.y - locJF.y) / 10) - 2);
        if (CellArr[locOnArr.y][locOnArr.x].IfAlive() == false) {
            CellArr[locOnArr.y][locOnArr.x].setAlive(true);
        }
        else {
            CellArr[locOnArr.y][locOnArr.x].setAlive(false);

        }
        GoL.repaint();

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point locSc = e.getLocationOnScreen();
        Point locJF = GoL.JF.getLocation();
        Point locOnArr = new Point((locSc.x - locJF.x) / 10, ((locSc.y - locJF.y) / 10) - 2);
        if (CellArr[locOnArr.y][locOnArr.x].IfAlive() == false) {
            CellArr[locOnArr.y][locOnArr.x].setAlive(true);
        }
        else {
            CellArr[locOnArr.y][locOnArr.x].setAlive(false);

        }
        GoL.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
