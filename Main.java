//Stephen Duffy  (spd170330)

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Main extends Frame
{	public static void main(String[] args){new Main();}

    Main()
    {
        //Reminder, research WindowEvent
        addWindowListener(new WindowAdapter()
        {public void windowClosing(WindowEvent e) {System.exit(0);}});
        setSize(1200,1000);
        add(new createSquare());
        setVisible(true);
    }
}

class createSquare extends Canvas
{
    int clickCounter = 1;
    int x_pointA = 0;
    int y_pointA = 0;
    int x_pointB = 0;
    int y_pointB = 0;
    Point pointA, pointB;

    createSquare()
    {
        clickCounter=1;
        addMouseListener(new MouseAdapter()
        {
        public void mousePressed(MouseEvent click)
        {
            if (clickCounter == 1)
            {
                pointA = click.getPoint();
                x_pointA = pointA.x;
                y_pointA = pointA.y;
                System.out.println(pointA.x);
                System.out.println(pointA.y);
                clickCounter = 2;
            }
            else if (clickCounter == 2)
            {
                pointB = click.getPoint();
                x_pointB = pointB.x;
                y_pointB = pointB.y;
                System.out.println(pointB.x);
                System.out.println(pointB.y);
                clickCounter = 1;
                repaint();
            }
            else
            {
                System.out.println("Error");
            }
        }
    });
    }

    public int[] calculateCoordinates(int x_pointA, int y_pointA, int x_pointB, int y_pointB)
    {
        int x_pointC = (x_pointB +(y_pointA - y_pointB));
        int y_pointC = (y_pointB +(x_pointB - x_pointA));
        int x_pointD = (x_pointA +(y_pointA - y_pointB));
        int y_pointD = (y_pointA +(x_pointB - x_pointA));

        int resultingCoordinates[] = {x_pointC, y_pointC, x_pointD, y_pointD};

        return resultingCoordinates;
    }

    public void paint(Graphics g)
    {
        int results[] = calculateCoordinates(x_pointA, y_pointA, x_pointB, y_pointB);
        int x_pointC = results[0];
        int y_pointC = results[1];
        int x_pointD = results[2];
        int y_pointD = results[3];

        g.drawLine(x_pointA, y_pointA, x_pointB, y_pointB);
        g.drawLine(x_pointB, y_pointB,x_pointC,y_pointC);
        g.drawLine(x_pointC,y_pointC,x_pointD,y_pointD);
        g.drawLine(x_pointD,y_pointD, x_pointA, y_pointA);
    }
}