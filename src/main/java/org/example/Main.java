package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static javax.swing.text.StyleConstants.setBackground;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main implements ActionListener {
    private int length = 0;
    private JLabel label, label1;
    private JFrame frame;
    private JPanel panel;
    private JTextField textField;
    private JCheckBox c1, c2, c3, c4;
    private JSpinner spinner;
    public Main() {
        frame = new JFrame();

        //frame.setLayout(new FlowLayout());

        JButton button = new JButton("Generate Password");
        JButton copyButton = new JButton("Copy");
        button.setBounds(140,350,170,30);
        button.addActionListener(this);
        copyButton.setBounds(330, 50, 70, 30);
        copyButton.addActionListener(this);

        textField = new JTextField();
        textField.setBounds(120,50, 200,30);
        textField.setEditable(false);
        textField.setBackground(UIManager.getColor("TextField.background"));

        spinner = new JSpinner(new SpinnerNumberModel(10, 4, 20, 1));
        spinner.setBounds(240,100,50,24);

        c1 = new JCheckBox("Include uppercase letters");
        c1.setBounds(120,150,200,20);
        c2 = new JCheckBox("Include lowercase letters");
        c2.setBounds(120,200,200,20);
        c3 = new JCheckBox("Include numbers");
        c3.setBounds(120,250,200,20);
        c4 = new JCheckBox("Include symbols");
        c4.setBounds(120,300,200,20);

        label = new JLabel("Password Generator");
        label.setBounds(160, 10, 200, 30);
        label1 = new JLabel("Password length");
        label1.setBounds(130,95,200, 30);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Password Generator");
        frame.add(label);

        frame.add(label1);
        frame.add(c1);
        frame.add(c2);
        frame.add(c3);
        frame.add(c4);
        frame.add(textField);
        frame.add(button);
        frame.add(spinner);
        frame.add(copyButton);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(500, 450);
    }

    public static void main(String[] args) {
        new Main();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean numbers = false;
        boolean symbols = false;

        if (c1.isSelected()) {
            upperCase = true;
        }
        if (c2.isSelected()) {
            lowerCase = true;
        }
        if (c3.isSelected()) {
            numbers = true;
        }
        if (c4.isSelected()) {
            symbols = true;
        }

        String s = e.getActionCommand();
        if (s.equals("Generate Password")) {
            try {
            spinner.commitEdit();
            } catch ( java.text.ParseException p ) { }
            int length = (Integer) spinner.getValue();

            textField.setText(PasswordGenerator.GenPassword(length, upperCase, lowerCase, numbers, symbols));
        }
        else if (s.equals("Copy")) {
            String str = textField.getText();
            Clipboard clip = Toolkit.getDefaultToolkit()
                    .getSystemClipboard();
            StringSelection strse1 = new StringSelection(str);
            clip.setContents(strse1, strse1);
            JOptionPane.showMessageDialog(null,
                    "Password copied");
        }
    }


}