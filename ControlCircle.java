import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.*;
import java.awt.event.*;

class ControlCircle extends Frame{
    Button enlarge = new Button("Enlarge");
    Button shrink = new Button("Shrink");
    CPanel canvas= new CPanel();

    public ControlCircle(){
        super("Control Circle");
        setLocation(0,0);
        setSize(350, 200);

        Panel p = new Panel();
        p.add(enlarge);
        p.add(shrink);

        this.add(canvas, BorderLayout.CENTER);
        this.add(p, BorderLayout.SOUTH);

        enlarge.addActionListener(new EnlargeListener());
        shrink.addActionListener(new ShrinkListener());
    }

    public static void main(String[] args) {
        Frame f = new ControlCircle();
        f.setTitle("Control Circle");
        f.setSize(200, 200);
        f.setVisible(true);
    }

    class EnlargeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            canvas.enlarge();
        }
    }

    class ShrinkListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            canvas.shrink();
        }
    }

    static class CPanel extends Panel
    {
        private int radius =5;

        public void enlarge() {
            radius++;
            repaint();
        }

        public void shrink() {
            radius--;
            repaint();
        }

        public void paint(Graphics g) {
            super.paint(g);
            g.drawOval(getWidth()/2 - radius, getHeight()/2 - radius,2*radius,2*radius);
        }
    }
}
