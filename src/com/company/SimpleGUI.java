package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI extends JFrame{
    private JButton button = new JButton("Итог");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel(" ");
    private JRadioButton radio1 = new JRadioButton("Кнопка 1");
    private JRadioButton radio2 = new JRadioButton("Кнопка 2");
    private JCheckBox check = new JCheckBox("Я уверен в решении", false);

    public SimpleGUI(){
        super("Кнопки");
        this.setBounds(150, 100, 350, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout( 3, 2, 2, 2));
        container.add(label);
        container.add(input);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);

        container.add(radio1);
        radio2.setSelected(true);
        container.add(radio2);
        container.add(check);
        button.addActionListener(new ButtonEventListener());
        container.add(button);


    }
    class ButtonEventListener implements ActionListener {
        public  void actionPerformed (ActionEvent e){
            String message ="";
            message += "Кнопка была нажата\n";
            message += "Подведем некий итог нажатия кнопки: " + input.getText() + "\n";
            message +=(radio1.isSelected() ? "Натажа кнопка 1" : "Нажата кнопка 2") + " И это было невероятное нажатие на кнопку!\n";
            message += "На счет уверенности в решении... " + ((check.isSelected()) ? "Уверен?Молодец!" : "Ты не уверен в принятии решения");
            JOptionPane.showMessageDialog(null, message, " Перейдем к результатам", JOptionPane.PLAIN_MESSAGE);

        }
    }
}