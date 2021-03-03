package nishit;
import static nishit.Train_Details.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.event.AncestorListener;


public class  Passenger_Details  {	
	public int available1;
	
	public static String no;
	String a;
	 public static String number = Train_Details.train_no;
	  public static JLabel back;
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel label1 = new JLabel();
	JFrame 	f = new JFrame("Check Availability");
	JTextField trainNumber;
	JTextField available;
	Passenger_Details() { 	 
		
		setNavigationPanel();
		
	    
	    JButton button=new JButton("Check Availability");		
		button.setBounds(280,200,160,40);
		button.setBackground(new Color(65,105,225));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Times Newroman", Font.BOLD,15));
	    button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				checkAvailability();
				available.setText(Integer.toString(available1));
				
			}
		});

	    
	   
	    JLabel l2=new JLabel("Train Number");  
	    l2.setBounds(60,120, 200,70);
	    l2.setForeground(Color.black);
	    l2.setFont(new Font("Times Newroman",Font.BOLD,18));
	    
		 trainNumber=new JTextField();
		trainNumber.setBounds(190,140, 120,30);
		trainNumber.setText(number);
		trainNumber.setEditable(false);
	    
	    JLabel l3=new JLabel("Available Seats");  
	    l3.setBounds(430,105, 200,100);
	    l3.setForeground(Color.black);
	    l3.setFont(new Font("Times Newroman",Font.BOLD,18));
	    
		available=new JTextField();
		available.setBounds(590,140, 75,30);
		available.setEditable(false);     

		   JLabel seat=new JLabel();
		    seat.setBounds(30,250,700,200);
			ImageIcon iconLogo = new ImageIcon(new ImageIcon("D:\\Images\\se_arr.png").getImage().getScaledInstance(685,135, Image.SCALE_DEFAULT));
			seat.setIcon(iconLogo);
		
		final JLabel label = new JLabel();          
        label.setSize(500,100);  
		
      
     /*   JLabel back=new JLabel();
	    back.setBounds(30,490,90,50);
		ImageIcon backbutton = new ImageIcon(new ImageIcon("D:\\Images\\back1.png").getImage().getScaledInstance(45,45, Image.SCALE_DEFAULT));
		back.setIcon(backbutton);

        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){              
               f.dispose();
                new Train_Details();
            } 
});
	 
        JLabel home=new JLabel();
	    home.setBounds(640,490,50,50);
		ImageIcon homebutton = new ImageIcon(new ImageIcon("D:\\Images\\home.png").getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));
		home.setIcon(homebutton);
		
        home.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){              
               f.dispose();
                new Main_Page();
            } 
});*/
        
        JButton back=new JButton("Back");		
		back.setBounds(30,490,90,30);
		back.setBackground(new Color(65,105,225));
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Times Newroman", Font.BOLD,15));
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				   f.dispose();
	                new Train_Details();
			}
		});
		
		  JButton home=new JButton("Home");		
			home.setBounds(610,490,90,30);
			home.setBackground(new Color(65,105,225));
			home.setForeground(Color.WHITE);
			home.setFont(new Font("Times Newroman", Font.BOLD,15));
			home.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					f.dispose();
	                new Main_Page();
				}
			});
        
        JButton b4=new JButton("Add Passenger");		
		b4.setBounds(50,440,180,30);
		b4.setBackground(new Color(65,105,225));
		b4.setForeground(Color.WHITE);
		b4.setFont(new Font("Times Newroman", Font.BOLD,15));
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				
				no = trainNumber.getText();
				
			//	f.setVisible(false);
				//f.dispose();
				new Add_Passenger();
				back.setEnabled(false);	
				
				home.setEnabled(false);
				  f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
				
			}
		});
		
		
		  JButton b5=new JButton("Delete Passenger");		
			b5.setBounds(275,440,180,30);
			b5.setBackground(new Color(65,105,225));
			b5.setForeground(Color.WHITE);
			b5.setFont(new Font("Times Newroman", Font.BOLD,15));
			b5.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				new 	Delete_Passenger();
					
				}
			});
			
		
			 JButton b6=new JButton("Proceed to Payment");		
				b6.setBounds(500,440,180,30);
				b6.setBackground(new Color(65,105,225));
				b6.setForeground(Color.WHITE);
				b6.setFont(new Font("Times Newroman", Font.BOLD,15));
				b6.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						f.dispose();
						new Payment_Page();
						
					}
				});
		
				
		
		
		  
		Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Images\\logo.png");
		f.setIconImage(icon);
		
	
		Container c = f.getContentPane();
	
		f.setLayout(null);
		c.setBackground(new Color(135,206,250));
		f.setSize(750,600);
		
		f.setLocationRelativeTo(null);  
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    f.setResizable(false);

		f.add(panel);
		f.add(label);
		
	
		f.add(trainNumber);
		f.add(available);
		
		
	
		f.add(l2);
		f.add(l3);
		f.add(seat);
		f.add(back);
		f.add(home);
		f.add(button);
		f.add(b4);			
		f.add(b5);
		f.add(b6);
		f.setVisible(true);
		
		 
		
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
		 
		new Passenger_Details();
		
	            
	        }
	public void checkAvailability() {
		String train = trainNumber.getText();
		try {
			int count=0;
			Class.forName("com.mysql.jdbc.Driver");
        	Connection 	conne = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
        	  Statement stmt ;
              stmt = conne.createStatement();
              String availqry = "SELECT * FROM availability WHERE train_no =  '"+train+"' AND status = 'not booked' AND process='not processed' ";
              ResultSet rs = stmt.executeQuery(availqry);
              while(rs.next()) {
            	  count++;
            
              }
              available1 =count;
		}
			 catch (Exception ex) {
	               JOptionPane.showMessageDialog(null, ex );
	    
	            }
		
	}

	    }
		
		
		
