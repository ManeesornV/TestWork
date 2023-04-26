package PanelProgram;

import Palette.CreateColor;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JPanel;

public class PaperPanel extends JPanel implements MouseListener, MouseMotionListener {
    public Color color = CreateColor.getColor();
    int r = 20;
    int x = 0;
    int y = 0;

    Point sPoint = new Point(-1, -1);
    Point ePoint = new Point(-1, -1);
    ArrayList<Color> colorArrayList = new ArrayList<Color>();
    Vector points = new Vector();


    public PaperPanel(Color color, int x, int y){
        init(CreateColor.getColor(), x, y);
    }

    PaperPanel(){
        init(this.color, this.x, this.y);
    }

    public void init(Color color, int x, int y) {
        this.x = x;
        this.y = y;
        colorArrayList.add(Color.black);
        colorArrayList.add(this.color);
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.color = CreateColor.getColor();
        this.setPreferredSize(new Dimension(200,200));
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        this.color = CreateColor.getColor();
        Point p = e.getPoint();
        System.out.println(p);
        for(int i = 0; i < points.size();i++)
        {
            Point p1=(Point)points.elementAt(i);

            if(p1.getX()==p.getX() && p1.getY()==p.getY())
            {
                System.out.println(points);
                System.out.println("clicked");
                points.remove(i);
                System.out.println(points);
                repaint();
            }

        }
    }
    public void mouseEntered(MouseEvent e) {
        this.color = CreateColor.getColor();

    }
    public void mouseExited(MouseEvent e) {
        this.color = CreateColor.getColor();
    }
    public void mouseReleased(MouseEvent e) {
        this.color = CreateColor.getColor();
        colorArrayList.add(this.color);
        e.consume();
        ePoint.x = e.getX();
        ePoint.y = e.getY();
        points.addElement(new Point(ePoint));
        repaint();
    }
    public void mousePressed(MouseEvent e) {
        this.color = CreateColor.getColor();
        colorArrayList.add(this.color);
        e.consume();
        sPoint.x = e.getX();
        sPoint.y = e.getY();
        points.addElement(new Point(sPoint));
    }
    public void mouseMoved(MouseEvent e) {
        this.color = CreateColor.getColor();
    }
    public void mouseDragged(MouseEvent e) {
        this.color = CreateColor.getColor();
        colorArrayList.add(this.color);
        e.consume();
        sPoint.x = e.getX();
        sPoint.y = e.getY();
        points.addElement(new Point(sPoint));
        ePoint.x = e.getX();
        ePoint.y = e.getY();
        points.addElement(new Point(ePoint));
        repaint();
    }

    public void paintComponent(Graphics g) {
        this.color = CreateColor.getColor();
        super.paintComponent(g);
        for(int i = 20; i< this.x; i+=50){
            g.drawLine(i,50,i,this.y);
            g.setColor(new Color(150,150,150));
        }

        for(int i = 20; i< this.y; i+=50){
            g.drawLine(50,i,this.x,i);
            g.setColor(new Color(150,150,150));
        }

        Point p1, p2;
        for (int i=0; i < points.size()-1; i+=2) {
            p1 = (Point)points.elementAt(i);
            p2 = (Point)points.elementAt(i+1);
            if(i > 2){
                g.setColor(colorArrayList.get(i/2));
            }
            g.fillOval(p1.x, p1.y, 10, 10);
        }
        g.fillOval(sPoint.x, sPoint.y, 10, 10);
    }

}