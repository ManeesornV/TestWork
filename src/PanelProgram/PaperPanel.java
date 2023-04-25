package PanelProgram;

import Palette.CreateColor;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaperPanel extends JPanel implements MouseListener, MouseMotionListener {
    public Color color = CreateColor.getColor();
    int r = 20;
    int x = 0;
    int y = 0;

    Point sPoint = new Point(-1, -1);
    Point ePoint = new Point(-1, -1);
    Vector points = new Vector();

    public PaperPanel(Color color){
        init(CreateColor.getColor());
    }

    PaperPanel(){
        init(this.color);
    }

    public void init(Color color) {
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.color = CreateColor.getColor();
        this.setPreferredSize(new Dimension(200,200));
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        //repaint();
    }

    public void mouseClicked(MouseEvent e) {
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
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {
        e.consume();
        ePoint.x = e.getX();
        ePoint.y = e.getY();
        points.addElement(new Point(ePoint));
        repaint();
    }
    public void mousePressed(MouseEvent e) {
        e.consume();
        sPoint.x = e.getX();
        sPoint.y = e.getY();
        points.addElement(new Point(sPoint));
    }
    public void mouseMoved(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {
//        Graphics g = getGraphics();
//        if (e.getModifiersEx() == InputEvent.BUTTON1_DOWN_MASK){
//            g.setColor(this.color);
//            g.drawLine(x, y, e.getX(), e.getY());
//        } else {
//            g.setColor(getBackground());
//            g.fillOval(x-r, y-r, 2*r, 2*r);
//        }
//        x = e.getX();
//        y = e.getY();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Point p1, p2;
        /* Draw old lines.Every 2 points construct a line.*/
        for (int i=0; i < points.size()-1; i+=2) {
            p1 = (Point)points.elementAt(i);
            p2 = (Point)points.elementAt(i+1);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
        /* Draw current line.*/
        g.drawLine(sPoint.x, sPoint.y, ePoint.x, ePoint.y);
        System.out.println(points);
    }

    public static void main(String arg[])
    {
        PaperPanel line= new PaperPanel(Color.BLUE);
        JFrame f= new JFrame();
        f.add(line);
        f.setSize(new Dimension(300,300));
        f.getContentPane().add(line);
        f.setVisible(true);
    }

}