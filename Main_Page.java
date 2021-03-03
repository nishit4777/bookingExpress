package nishit;
import static nishit.Train_Details.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Main_Page {	
	
	
	JFrame f;

	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel label1 = new JLabel();
	
	Main_Page() { 	  
	    
setNavigationPanel();	 
		
		JLabel l=new JLabel("Welcome to Booking Express");  
	    l.setBounds(200,190, 500,70);
	    l.setForeground(Color.black);
	    l.setFont(new Font("Times Newroman",Font.BOLD,24));
	    
	    JLabel l1=new JLabel();
	    l1.setBounds(330,100,500,70);
		ImageIcon iconLogo = new ImageIcon(new ImageIcon("D:\\Images\\logo.png").getImage().getScaledInstance(90,75, Image.SCALE_DEFAULT));
		l1.setIcon(iconLogo);
	    
	 
	    
	  
		f = new JFrame("Home Page");
		
		final JLabel label = new JLabel();          
        label.setSize(500,100);  
		
      
        JLabel logout=new JLabel();
	    logout.setBounds(640,485,50,50);
		ImageIcon logoutbutton = new ImageIcon(new ImageIcon("D:\\Images\\logout.png").getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));
		logout.setIcon(logoutbutton);
		
        logout.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){              
               f.dispose();
                new LoginPage();
            } 
});
        
		JButton b1=new JButton("Book Tickets");
		b1.setBounds(300,270,150,50);
		b1.setBackground(new Color(65,105,225));
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Times Newroman", Font.BOLD,16));
	    b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Train_Details();

				f.dispose();
			}
		});
		
		JButton b2=new JButton("Cancel  Tickets");
		b2.setBounds(300,340,150,50);
		b2.setBackground(new Color(65,105,225));
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Times Newroman", Font.BOLD,16));
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new CancelTickets();
				
			}
		});
		
		
		JButton b3=new JButton("Check Status");		
		b3.setBounds(300,410,150,50);
		b3.setBackground(new Color(65,105,225));
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Times Newroman", Font.BOLD,16));
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new PnrDetails();
				
			}
		});
		
		
		JButton b33=new JButton("Booking History");		
		b33.setBounds(300,480,150,50);
		b33.setBackground(new Color(65,105,225));
		b33.setForeground(Color.WHITE);
		b33.setFont(new Font("Times Newroman", Font.BOLD,15));
		b33.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new ViewTicketHistory();
				
			}
		});
		
		  
		Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Images\\logo.png");
		f.setIconImage(icon);
	
	
		Container c = f.getContentPane();
	
		f.setLayout(null);
		c.setBackground(new Color(135,206,250));
		f.setSize(750,600);
		f.setVisible(true);
		f.setLocationRelativeTo(null);  
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    f.setResizable(false);
	    
		f.add(panel);
		f.add(label);
		
		f.add(l);
		f.add(l1);
		f.add(b1);
		f.add(b2);
		f.add(b3);			
		f.add(b33);
		f.add(logout);
		 
		
		 }  
	
	public void setNavigationPanel() {
		panel.setBackground(new Color(65,105,225));
		panel.setBounds(0, 0, 750, 80); 
       ImageIcon iconLo = new ImageIcon(new ImageIcon("D:\\Images\\logo.png").getImage().getScaledInstance(75,70, Image.SCALE_DEFAULT));
       label.setIcon(iconLo);
       label.setBounds(0, 0,75, 75);
       panel.setLayout(null);
       
        JLabel label1= new JLabel(" RAILWAY RESERVATION SYSTEM");
        label1.setHorizontalAlignment(JLabel.CENTER);
       label1.setBounds(90,0,550,80);
       
       label1.setFont(new Font("Times Newroman", Font.BOLD,20));
       label1.setForeground(Color.white);      
            
       panel.add(label);
       panel.add(label1);
	}
	
	

	public static void main(String[] args) {	 
		new Main_Page();
		
		}	
	}