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

public class Category3 extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton mangojuice, bananajuice, strawberryjuice, back, order;
    private JLabel prmangojuice, prbananajuice, prstrawberryjuice, banner;
    private JButton cmangojuice, cbananajuice, cstrawberryjuice;
    private JCheckBox rmangojuice, rbananajuice, rstrawberryjuice;
    private JComboBox<String> bmangojuice;
    private JComboBox<String> bbananajuice;
    private JComboBox<String> bstrawberryjuice;
    private String a[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private String b[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private String d[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private String f;

    public Category3(String user) {

        ImageIcon framelogo = new ImageIcon("Image/logo.png");
        setIconImage(framelogo.getImage());

        f = user;

        Icon bicon = new ImageIcon("Image/manu1.png");
        Icon mangojuicei = new ImageIcon("Image/mango200.png");
        Icon bananajuicei = new ImageIcon("Image/bananajuice200.png");
        Icon strawberryjuicei = new ImageIcon("Image/sto200.png");

        setTitle("Juice");
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
        back.setForeground(Color.BLACK);
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

        mangojuice = new JButton(mangojuicei);
        mangojuice.setBounds(120, 175, 200, 200);
        mangojuice.addActionListener(this);
        panel.add(mangojuice);

        rmangojuice = new JCheckBox("Mango Juice");
        rmangojuice.setBounds(120, 385, 200, 30);
        rmangojuice.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(rmangojuice);

        prmangojuice = new JLabel("50 Tk");
        prmangojuice.setBounds(150, 415, 150, 20);
        prmangojuice.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(prmangojuice);

        bmangojuice = new JComboBox<String>(a);
        bmangojuice.setBounds(120, 445, 70, 20);
        panel.add(bmangojuice);

        bananajuice = new JButton(bananajuicei);
        bananajuice.setBounds(350, 175, 200, 200);
        bananajuice.addActionListener(this);
        panel.add(bananajuice);

        rbananajuice = new JCheckBox("Banana Juice");
        rbananajuice.setBounds(350, 385, 200, 30);
        rbananajuice.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(rbananajuice);

        prbananajuice = new JLabel("50 Tk");
        prbananajuice.setBounds(380, 415, 150, 20);
        prbananajuice.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(prbananajuice);

        bbananajuice = new JComboBox<String>(b);
        bbananajuice.setBounds(350, 445, 70, 20);
        panel.add(bbananajuice);

        strawberryjuice = new JButton(strawberryjuicei);
        strawberryjuice.setBounds(600, 175, 200, 200);
        strawberryjuice.addActionListener(this);
        panel.add(strawberryjuice);

        rstrawberryjuice = new JCheckBox("Strawberry Juice");
        rstrawberryjuice.setBounds(600, 385, 200, 30);
        rstrawberryjuice.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(rstrawberryjuice);

        prstrawberryjuice = new JLabel("200 Tk");
        prstrawberryjuice.setBounds(630, 415, 150, 20);
        prstrawberryjuice.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(prstrawberryjuice);

        bstrawberryjuice = new JComboBox<String>(b);
        bstrawberryjuice.setBounds(600, 445, 70, 20);
        panel.add(bstrawberryjuice);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Shop(f);
            setVisible(false);
        } else if (e.getSource() == order) {
            double totalAmount = 0;
            double mangojuiceamount = 0;
            double bananajuiceamount = 0;
            double strawberryjuiceamount = 0;
            int a = 0;
            int b = 0;
            int c = 0;

            if (rmangojuice.isSelected() == true) {
                a = (bmangojuice.getSelectedIndex()) + 1;
                mangojuiceamount = a * 50;
            }
            if (rbananajuice.isSelected() == true) {
                b = bbananajuice.getSelectedIndex() + 1;
                bananajuiceamount = b * 50;
            }
            if (rstrawberryjuice.isSelected() == true) {
                c = bstrawberryjuice.getSelectedIndex() + 1;
                strawberryjuiceamount = c * 200;
            }

            totalAmount = mangojuiceamount + bananajuiceamount + strawberryjuiceamount;
            if (totalAmount != 0) {
                int x = JOptionPane.showConfirmDialog(null, "Your Bill = " + totalAmount + " tk. Confirm Order?",
                        " Conformation of Oder", 0);
                if (x == 0) {
                    setVisible(false);
                    new Payment(totalAmount, "Category3", f);

                    try {
                        File newfile = new File("data\\Last.txt");
                        newfile.createNewFile();
                        FileWriter file = new FileWriter("data\\Last.txt");

                        file.write("Mango Juice--- " + a + mangojuiceamount + " tk."
                                + "\n Banana Juice----" + b + bananajuiceamount + " tk."
                                + "\nStrawberry Juice---" + c + strawberryjuiceamount + " tk."
                                + "\n" + totalAmount + " tk Total.");
                        file.close();

                    } catch (IOException io) {
                        JOptionPane.showMessageDialog(null, "An error Occurred and failed to create the file");
                        io.printStackTrace();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select something before placing an order!", "Message", 0);
            }
        }
    }
}
