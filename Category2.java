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

public class Category2 extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton bitterbtn, tomatobtn, pumpkinbtn, back, order;
    private JLabel bitter, tomato, pumpkin, banner;
    private JCheckBox rbitter, rtomato, rpumpkin;
    private JComboBox<String> bbitter;
    private JComboBox<String> btomato;
    private JComboBox<String> bpumpkin;
    private String a[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private String b[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private String d[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private String f;

    public Category2(String user) {

        ImageIcon framelogo = new ImageIcon("Image/logo.png");
        setIconImage(framelogo.getImage());

        f = user;

        Icon bicon = new ImageIcon("Image/manu2.png");
        Icon bittericon = new ImageIcon("Image/bitter.png");
        Icon tomatoicon = new ImageIcon("Image/tomato200.png");
        Icon pumpkinicon = new ImageIcon("Image/kumra200.png");

        setTitle("Vegetable");
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

        bitterbtn = new JButton(bittericon);
        bitterbtn.setBounds(120, 175, 200, 200);
        bitterbtn.addActionListener(this);
        panel.add(bitterbtn);

        rbitter = new JCheckBox("Bitter");
        rbitter.setBounds(120, 385, 200, 30);
        rbitter.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(rbitter);

        bitter = new JLabel("49 Tk Kg");
        bitter.setBounds(150, 415, 150, 20);
        bitter.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(bitter);

        bbitter = new JComboBox<String>(a);
        bbitter.setBounds(120, 445, 70, 20);
        panel.add(bbitter);

        tomatobtn = new JButton(tomatoicon);
        tomatobtn.setBounds(350, 175, 200, 200);
        tomatobtn.addActionListener(this);
        panel.add(tomatobtn);

        rtomato = new JCheckBox("Tomato");
        rtomato.setBounds(350, 385, 200, 30);
        rtomato.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(rtomato);

        tomato = new JLabel("55 Tk Kg");
        tomato.setBounds(380, 415, 150, 20);
        tomato.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(tomato);

        btomato = new JComboBox<String>(b);
        btomato.setBounds(350, 445, 70, 20);
        panel.add(btomato);

        pumpkinbtn = new JButton(pumpkinicon);
        pumpkinbtn.setBounds(600, 175, 200, 200);
        pumpkinbtn.addActionListener(this);
        panel.add(pumpkinbtn);

        rpumpkin = new JCheckBox("Pumpkin");
        rpumpkin.setBounds(600, 385, 200, 30);
        rpumpkin.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(rpumpkin);

        pumpkin = new JLabel("99 Tk Kg");
        pumpkin.setBounds(630, 415, 150, 20);
        pumpkin.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(pumpkin);

        bpumpkin = new JComboBox<String>(b);
        bpumpkin.setBounds(600, 445, 70, 20);
        panel.add(bpumpkin);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Shop(f);
            setVisible(false);

        } else if (e.getSource() == order) {
            double totalAmount = 0;
            double bitteramount = 0;
            double tomatoamount = 0;
            double pumpkinamount = 0;
            int a = 0;
            int b = 0;
            int c = 0;

            if (rbitter.isSelected() == true) {
                a = (bbitter.getSelectedIndex()) + 1;
                bitteramount = a * 49;
            }
            if (rtomato.isSelected() == true) {
                b = btomato.getSelectedIndex() + 1;
                tomatoamount = b * 55;
            }
            if (rpumpkin.isSelected() == true) {
                c = bpumpkin.getSelectedIndex() + 1;
                pumpkinamount = c * 99;
            }

            totalAmount = bitteramount + tomatoamount + pumpkinamount;
            if (totalAmount != 0) {
                int x = JOptionPane.showConfirmDialog(null, "Your Bill = " + totalAmount + " tk. Confirm Order?",
                        " Conformation of Oder", 0);
                if (x == 0) {
                    setVisible(false);
                    new Payment(totalAmount, "Category2", f);

                    try {
                        File newfile = new File("data\\Last.txt");
                        newfile.createNewFile();
                        FileWriter file = new FileWriter("data\\Last.txt");

                        file.write("Bitter--- " + a + bitteramount + " tk."
                                + "\n Tomato----" + b + tomatoamount + " tk."
                                + "\n Pumpkin---" + c + pumpkinamount + " tk."
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
