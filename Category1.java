package classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Category1 extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton mango, banana, strawberry, back, order;
    private JLabel prclassic, prtower, prsuper, banner;
    private JCheckBox classicmango, rtower, rsuper;
    private JComboBox<String> bclassic;
    private JComboBox<String> btower;
    private JComboBox<String> bsuper;
    private String a[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private String b[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private String d[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private String f;

    public Category1(String user) {
        ImageIcon framelogo = new ImageIcon("Image/logooo.png");
        setIconImage(framelogo.getImage());

        f = user;

        // Icon bicon = new ImageIcon("Image/burgermenu.png");
        Icon bicon = new ImageIcon("Image/manu3.png");
        Icon mangoi = new ImageIcon("Image/mango20.png");
        Icon bananai = new ImageIcon("Image/banana200.png");
        Icon strawberryi = new ImageIcon("Image/strawberry.png");

        setTitle("Fruits");
        setBounds(0, 0, 900, 600);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 900, 600);
        add(panel);

        back = new JButton("Back");
        back.setBounds(145, 500, 150, 50);
        back.setBackground(Color.RED);
        back.setForeground(Color.WHITE);
        back.setOpaque(true);
        back.addActionListener(this);
        panel.add(back);

        order = new JButton("Place Order");
        order.setBounds(625, 500, 150, 50);
        order.setBackground(Color.BLACK);
        order.setForeground(Color.WHITE);
        order.setOpaque(true);
        order.addActionListener(this);
        panel.add(order);

        banner = new JLabel(bicon);
        banner.setBounds(0, 0, 900, 150);
        panel.add(banner);

        mango = new JButton(mangoi);
        mango.setBounds(120, 175, 200, 200);
        mango.addActionListener(this);
        panel.add(mango);

        classicmango = new JCheckBox("Mango");
        classicmango.setBounds(120, 385, 200, 30);
        classicmango.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(classicmango);

        prclassic = new JLabel("289 Tk Kg");
        prclassic.setBounds(150, 415, 150, 20);
        prclassic.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(prclassic);

        bclassic = new JComboBox<String>(a);
        bclassic.setBounds(120, 445, 70, 20);
        panel.add(bclassic);

        banana = new JButton(bananai);
        banana.setBounds(350, 175, 200, 200);
        banana.addActionListener(this);
        panel.add(banana);

        rtower = new JCheckBox("Banana");
        rtower.setBounds(350, 385, 200, 30);
        rtower.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(rtower);

        prtower = new JLabel("15 Tk pc");
        prtower.setBounds(380, 415, 150, 20);
        prtower.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(prtower);

        btower = new JComboBox<String>(b);
        btower.setBounds(350, 445, 70, 20);
        panel.add(btower);

        strawberry = new JButton(strawberryi);
        strawberry.setBounds(600, 175, 200, 200);
        strawberry.addActionListener(this);
        panel.add(strawberry);

        rsuper = new JCheckBox("Strawberry");
        rsuper.setBounds(600, 385, 200, 30);
        rsuper.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(rsuper);

        prsuper = new JLabel("401 Tk Kg");
        prsuper.setBounds(630, 415, 150, 20);
        prsuper.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(prsuper);

        bsuper = new JComboBox<String>(b);
        bsuper.setBounds(600, 445, 70, 20);
        panel.add(bsuper);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Shop(f);
            setVisible(false);
        } else if (e.getSource() == order) {
            double totalAmount = 0;
            double classicAmount = 0;
            double towerAmount = 0;
            double superAmount = 0;
            int a = 0;
            int b = 0;
            int c = 0;

            if (classicmango.isSelected()) {
                a = (bclassic.getSelectedIndex()) + 1;
                classicAmount = a * 289;
            }
            if (rtower.isSelected()) {
                b = btower.getSelectedIndex() + 1;
                towerAmount = b * 15;
            }
            if (rsuper.isSelected()) {
                c = bsuper.getSelectedIndex() + 1;
                superAmount = c * 401;
            }

            totalAmount = classicAmount + towerAmount + superAmount;
            if (totalAmount != 0) {
                int x = JOptionPane.showConfirmDialog(null, "Your Bill = " + totalAmount + " tk. Confirm Order?",
                        " Conformation of Oder", 0);
                if (x == 0) {
                    setVisible(false);
                    new Payment(totalAmount, "Category1", f);

                    try {
                        File newfile = new File("data\\Last.txt");
                        newfile.createNewFile();
                        FileWriter file = new FileWriter("data\\Last.txt");

                        file.write("Mango--- " + a + classicAmount + " tk."
                                + "\n Banana----" + b + towerAmount + " tk."
                                + "\n Strawberry---" + c + superAmount + " tk."
                                + "\n" + totalAmount + " tk Total.");
                        file.close();

                    } catch (IOException io) {
                        JOptionPane.showMessageDialog(null, "An error Occured and failed to create the file");
                        io.printStackTrace();
                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select something before placing order!", "Message", 0);
            }
        }
    }
}
