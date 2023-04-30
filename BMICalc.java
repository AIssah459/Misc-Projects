import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calc implements ActionListener{
    JFrame frame;
    GridLayout grid;
    JLabel title;
    JButton button;
    JTextField weight;
    JTextField height;
    String result;
    JLabel display;

    public Calc() {
        init();
    }
    private void init() {
        frame = new JFrame("BMI Calculator");
        grid = new GridLayout(5, 2, 1, 1);
        title = new JLabel("BMI Calculator");
        button = new JButton("Click to calculate BMI");
        weight = new JTextField();
        height = new JTextField();
        display = new JLabel(" ");

        title.setFont(new Font("Fira Mono for Powerline", Font.PLAIN, 20));
        frame.setLayout(grid);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.add(title);
        frame.add(new JLabel(" "));
        frame.add(new JLabel("Enter your age: "));
        frame.add(new JTextField());
        frame.add(new JLabel("Enter your weight: "));
        frame.add(weight);
        frame.add(new JLabel("Enter your height (in inches): "));
        frame.add(height);
        frame.add(button);
        frame.add(display);
        button.addActionListener(this);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent event) {
        try {
            double weight = Double.parseDouble(this.weight.getText());
            double height = Double.parseDouble(this.height.getText());
            double bmi = ((weight/ height/ height) * 703);
            result = "Your BMI is: " + bmi;
            display.setText(result);
        }
        catch(NumberFormatException e) {
            display.setText("Invalid Input!");
        }
        
    }
}


public class BMICalc {

    public static void main(String[] args) {
        Calc c = new Calc();
    }
}
