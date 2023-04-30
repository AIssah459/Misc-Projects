import javax.swing.*;
import java.awt.*;

class PaintLab extends JFrame{
    public PaintLab(){
        super("Paint");
        setLocation(0,0);
        setSize(600, 100);

        //Create color buttons
        JButton red = new JButton ("RED");
        JButton green = new JButton ("GREEN");
        JButton blue = new JButton("BLUE");
        JButton black = new JButton("Black");
        JButton clear = new JButton ("CLEAR");

        JLabel label = new JLabel ("Enter text:");
        JTextField textField = new JTextField (25);

        //Add panels
        Panel p = new Panel();
        p.add(red);
        p.add(green);
        p.add(blue);
        p.add(black);
        p.add(clear);
        this.add(p, BorderLayout.SOUTH);

        Panel p2 = new Panel();
        p2.add(label);
        p2.add(textField);
        add(p2, BorderLayout.NORTH);

        //Add button event listeners
        red.addActionListener((e) -> {textField.setForeground(Color.RED);});
        green.addActionListener((e) -> {textField.setForeground(Color.GREEN);});
        blue.addActionListener((e) -> {textField.setForeground(Color.BLUE);});
        black.addActionListener((e) -> {textField.setForeground(Color.BLACK);});

        //Clear text field
        clear.addActionListener(e -> {
            textField.setText("");
            textField.requestFocus();
            });
    }

    public static void main(String [] args) {
        PaintLab pl = new PaintLab();
        pl.setVisible(true);
    }
}