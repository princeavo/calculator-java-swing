import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EssaiCalculatrice {
    public static void main(String[] args) {
        Frame1 frame = new Frame1();
    }
}

class Frame1 extends JFrame implements ActionListener {
    String text = "0";
    JPanel panel = new JPanel();
    PaNel panelN = new PaNel();
    JLabel label = new JLabel(text + "   ");
    JLabel label1 = new JLabel("   ");
    // label.setPreferredSize(new Dimension(100,100));
    JPanel panelG = new JPanel();
    JPanel panelS = new JPanel();
    JPanel panelD = new JPanel();
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton button0 = new JButton("0");
    JButton buttonP = new JButton(".");
    JButton buttonE = new JButton("=");
    JButton buttonC = new JButton("C");
    // buttonC.setForeg7round(Color.RED);
    JButton buttonPlus = new JButton("+");
    JButton buttonMoins = new JButton("-");
    JButton buttonDiv = new JButton("/");
    JButton buttonFois = new JButton("*");
    double number1 = 0;
    double number2 = 0;
    String op = "";
    String op1 = "";
    String op2 = "";

    public Frame1() {
        // System.out.println(9 / 0);
        button0.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        extracted();
        button8.addActionListener(this);
        button9.addActionListener(this);
        buttonC.addActionListener(this);
        buttonP.addActionListener(this);
        buttonE.addActionListener(this);
        buttonPlus.addActionListener(this);
        buttonMoins.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonFois.addActionListener(this);
        label.setHorizontalAlignment(JLabel.RIGHT);
        panel.setLayout(new BorderLayout());
        panel.add(panelN, BorderLayout.NORTH);
        panelN.setLayout(new GridLayout(3, 1));
        panelN.add(label1);
        panelN.add(label);
        panelN.add(new JLabel());
        panel.add(panelS, BorderLayout.CENTER);
        panelS.setLayout(new GridLayout(1, 2, 10, 10));
        panelS.add(panelG);
        panelS.add(panelD);
        panelG.setLayout(new GridLayout(4, 3, 7, 10));
        panelG.add(button1);
        panelG.add(button2);
        panelG.add(button3);
        panelG.add(button4);
        panelG.add(button5);
        panelG.add(button6);
        panelG.add(button7);
        panelG.add(button8);
        panelG.add(button9);
        panelG.add(button0);
        panelG.add(buttonP);
        panelG.add(buttonE);
        panelD.setLayout(new GridLayout(5, 1, 5, 5));
        panelD.add(buttonC);
        panelD.add(buttonPlus);
        panelD.add(buttonMoins);
        panelD.add(buttonDiv);
        panelD.add(buttonFois);
        this.setContentPane(panel);
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Un essai");
        this.setAlwaysOnTop(true);
        this.setResizable(false);
    }

    private void extracted() {
        button7.addActionListener(this);
    }

    class PaNel extends JPanel {
        public PaNel() {
            super();
        }

        public void paintComponent(Graphics g) {
            g.setColor(Color.BLACK);
            g.drawRect(5, 5, this.getWidth() - 8, this.getHeight() - 15);
        }
    }

    public void actionPerformed(ActionEvent e) {
        // System.out.println("+-/*=".indexOf(e.getActionCommand()) > -1);
        if (e.getActionCommand().equals("C")) {
            text = "0";
            number1 = 0;
            number2 = 0;
            op = "";
            op1 = "";
            label.setText(text + " ");
            this.repaint();
        } else {
            // la personne n'a pas touché C
            if (e.getActionCommand().equals("=")) {
                // Il a touché égal
                if (!op.equals("")) {
                    if (op.equals("+")) {
                        number1 = number1 + number2;
                        label.setText(Double.toString(number1) + " ");
                    }
                    if (op.equals("-")) {
                        number1 = number1 - number2;
                        label.setText(Double.toString(number1) + " ");
                    }
                    if (op.equals("*")) {
                        number1 = number1 * number2;
                        label.setText(Double.toString(number1) + " ");
                    }
                    if (op.equals("/")) {

                        if (number2 == 0) {
                            if (number1 == 0) {
                                label.setText("Le résultat est indéfini  ");
                            } else {
                                label.setText("Nous ne pouvons pas diviser par zéro   ");
                            }
                            number1 = 0;
                            number2 = 0;
                        } else {
                            number1 = number1 / number2;
                            label.setText(Double.toString(number1) + " ");
                        }
                    }
                }
                // text = Double.toString(number1);
                text = "0";
                // op = "";
                op1 = "=";
                // number1 = 0;
                // number2 = 0;
                // op= "";
                this.repaint();
            } else {
                // Il n'a pas touché égal
                if ("+-/*".indexOf(e.getActionCommand()) > -1) {
                    // il a touché les opérateurs

                    // op = e.getActionCommand();
                    if (op1.equals("="))
                        op = "";
                    if (op.equals("")) {
                        op = e.getActionCommand();
                        text = "0";
                    } else {
                        if (op.equals("+")) {
                            number1 = number1 + number2;
                            number2 = number1;
                        }
                        if (op.equals("-")) {
                            number1 = number1 - number2;
                            number2 = number1;
                        }
                        if (op.equals("*")) {
                            number1 = number1 * number2;
                            number2 = number1;
                        }
                        label.setText(Double.toString(number1) + " ");
                        if (op.equals("/")) {

                            if (number2 == 0) {
                                if (number1 == 0) {
                                    label.setText("Le résultat est indéfini  ");
                                } else {
                                    label.setText("Nous ne pouvons pas diviser par zéro   ");
                                    System.out.println("Je suis ici");
                                }
                                number1 = 0;
                                number2 = 0;
                            } else {
                                number1 = number1 / number2;
                                number2 = number1;
                            }
                        }
                        // text = Double.toString(number1);
                        text = "0";
                        op = e.getActionCommand();
                        op1 = "";
                        this.repaint();
                    }
                } else {
                    // Il n'a pas touché les opérateurs
                    if (!text.equals("0")) {
                        if (!op.equals("")) {
                            text = text + e.getActionCommand();
                            number2 = Double.parseDouble(text);
                        } else {
                            text = text + e.getActionCommand();
                            number1 = Double.parseDouble(text);
                        }
                    } else {
                        if (!op.equals("")) {
                            text = e.getActionCommand();
                            number2 = Double.parseDouble(text);
                        } else {
                            text = e.getActionCommand();
                            number1 = Double.parseDouble(text);
                        }
                    }
                    label.setText(text + " ");
                    this.repaint();
                    op1 = "";
                }

            }
        }
        // System.out.println("number1 " + number1);
        // System.out.println("number2 " + number2);
    }
}
