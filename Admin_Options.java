package nishit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Admin_Options {
    JFrame f = new JFrame("admin options");
	
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JLabel head = new JLabel();
    Container c;
    
    public Admin_Options(){
        
        options();
    }
   
  
    public void options(){
        panel.setBackground(new Color(65,105,225));
        panel.setBounds(0, 0, 750, 80); 
        ImageIcon iconLo = new ImageIcon(new ImageIcon("D:\\Images\\logo.png").getImage().getScaledInstance(75,90, Image.SCALE_DEFAULT));
        label.setIcon(iconLo);
        label.setBounds(0, 0,75, 75);
        panel.setLayout(null);
       
        head= new JLabel(" RAILWAY RESERVATION SYSTEM");
        head.setHorizontalAlignment(JLabel.CENTER);
        head.setBounds(90,0,550,80);
       
        head.setFont(new Font("Times Newroman", Font.BOLD,20));
        head.setForeground(Color.white);
       
		
        final JLabel label = new JLabel();          
       label.setSize(500,100); 

        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Images\\logo.png");
        f.setIconImage(icon);
        
        JLabel reset=new JLabel();
	    reset.setBounds(40,460,70,70);
		ImageIcon backbutton = new ImageIcon(new ImageIcon("D:\\Images\\reset1.png").getImage().getScaledInstance(60,60, Image.SCALE_DEFAULT));
		reset.setIcon(backbutton);
		
        reset.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){              
               f.dispose();
                new ResetAvailability();
            } 
});
        
        JLabel logout=new JLabel();
	    logout.setBounds(620,465,50,50);
		ImageIcon logoutbutton = new ImageIcon(new ImageIcon("D:\\Images\\logout.png").getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));
		logout.setIcon(logoutbutton);
		
        logout.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){              
               f.dispose();
                new LoginPage();
            } 
});
        

        c = f.getContentPane();

        f.setLayout(null);
        c.setBackground(new Color(135,206,250));
        f.setSize(750,600);

        f.setLocationRelativeTo(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        f.setResizable(false);

        f.add(panel);
        f.add(label);		
        f.add(reset);
        f.add(logout);
        panel.add(label);
        panel.add(head);
        JButton addtrain_button =new JButton("ADD NEW TRAIN DETAILS");		
        addtrain_button.setBounds(270,150,180,50);
	addtrain_button.setBackground(new Color(65,105,225));
	addtrain_button.setForeground(Color.WHITE);
	addtrain_button.setFont(new Font("Times Newroman", Font.BOLD,12));
        c.add(addtrain_button);
        
        addtrain_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 f.dispose();
                new Add_Train();
               
            }
        });
        
        JButton deletetrain_button =new JButton("DELETE TRAIN DETAILS");		
        deletetrain_button.setBounds(270,230,180,50);
	deletetrain_button.setBackground(new Color(65,105,225));
	deletetrain_button.setForeground(Color.WHITE);
	deletetrain_button.setFont(new Font("Times Newroman", Font.BOLD,12));
        c.add(deletetrain_button);
        
        deletetrain_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	  f.dispose();
                new Delete_Train();
              
            }
        });
        
        JButton edittrain_button =new JButton("EDIT TRAIN DETAILS");		
        edittrain_button.setBounds(270,310,180,50);
	edittrain_button.setBackground(new Color(65,105,225));
	edittrain_button.setForeground(Color.WHITE);
	edittrain_button.setFont(new Font("Times Newroman", Font.BOLD,12));
        c.add(edittrain_button);
        
        edittrain_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	  f.dispose();
                new Edit_Train();
              
            }
        });
        
        JButton user_button =new JButton("VIEW USER DETAILS");		
        user_button.setBounds(270,390,180,50);
	user_button.setBackground(new Color(65,105,225));
	user_button.setForeground(Color.WHITE);
	user_button.setFont(new Font("Times Newroman", Font.BOLD,12));
        c.add(user_button);
        
        user_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 f.dispose();
                new User_Details();
               
            }
        });
        JButton avail_button =new JButton("AVAILABILITY");		
        avail_button.setBounds(270,470,180,50);
	avail_button.setBackground(new Color(65,105,225));
	avail_button.setForeground(Color.WHITE);
	avail_button.setFont(new Font("Times Newroman", Font.BOLD,12));
        c.add(avail_button);
        
        avail_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 f.dispose();
                new Availability();
               
            }
        });
        
        f.setVisible(true);

    }
    public static void main(String ss[]){
        new Admin_Options();
      
    }
}