package nishit;
import static nishit.Add_Passenger.*;
import static nishit.LoginPage.*;
	import java.awt.*;

	//import java.text.DateFormat;
	//import java.text.SimpleDateFormat;
	//import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
public class Payment_Page {
 public static 	int pnr_value;
 
		JFrame f;
		JComboBox pay_combo;
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		JLabel label1 = new JLabel();
		
	//	 ButtonGroup bg =new ButtonGroup();    
		
		public  Payment_Page() { 	 
			
			JLabel l=new JLabel("Welcome to Payment Portal");  
		    l.setBounds(200,140, 500,70);
		    l.setForeground(Color.black);
		    l.setFont(new Font("Times Newroman",Font.BOLD,24));
		    
			JLabel l1=new JLabel("Select mode of Payment");  
		    l1.setBounds(230,190, 500,70);
		    l1.setForeground(Color.black);
		    l1.setFont(new Font("Times Newroman",Font.BOLD,20));
			
			
			
			setNavigationPanel();
			
			   
			 
			
			
		f = new JFrame();
			
			final JLabel label = new JLabel();          
	        label.setSize(500,100);  
			
	       /* JRadioButton r1=new JRadioButton("Credit Card/ Debit Card");    
	        JRadioButton r2=new JRadioButton("UPI Payment");    
	        JRadioButton r3=new JRadioButton("UPI Payment");    
	        JRadioButton r4=new JRadioButton("UPI Payment");   
	        r1.setBounds(230,250,240,40);    
	        r1.setBackground(new Color(135,206,250));
	        r1.setFont(new Font("Times Newroman", Font.BOLD,15));
	        r2.setBounds(230,290,180,40);    
	        r2.setBackground(new Color(135,206,250));
	        r2.setFont(new Font("Times Newroman", Font.BOLD,15));
	        r3.setBounds(230,330,180,40);    
	        r3.setBackground(new Color(135,206,250));
	        r3.setFont(new Font("Times Newroman", Font.BOLD,15));
	        r4.setBounds(230,370,180,40);    
	        r4.setBackground(new Color(135,206,250));
	        r4.setFont(new Font("Times Newroman", Font.BOLD,15));
	        
	       
	        bg.add(r1);
	        bg.add(r2);    
	        bg.add(r3);
	        bg.add(r4);*/
	        String pay[]={"Card Payment","Online Banking","UPI Payment"};
		 pay_combo=new JComboBox(pay);
			pay_combo.setBounds(260,280, 180,40);
	        
	      
	        JButton b7=new JButton("Confirm Payment");		
			b7.setBounds(500,475,180,40);
			b7.setBackground(new Color(65,105,225));
			b7.setForeground(Color.WHITE);
			b7.setFont(new Font("Times Newroman", Font.BOLD,17));
			b7.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					 
					JOptionPane.showMessageDialog(null, "Tickets Booked Successfully ");
					make_payment();
					try {
						Class.forName("com.mysql.jdbc.Driver");
			        	Connection 	conne = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
			        	  Statement smt11 ;
			              smt11 = conne.createStatement();
			            
			              for(int i=0;i<seat1.size();i++) {
			            	  String dqry = "UPDATE availability set status = 'booked' , process='processed' WHERE seat='"+seat1.get(i)+"' AND train_no = '" +pno_text+"' AND coach='"+ pcoach+"' AND process='in process' ";
				              smt11.executeUpdate(dqry);
							}
					}
						 catch (Exception ex) {
				               JOptionPane.showMessageDialog(null, ex );
				      // ex.printStackTrace();
				            }
					f.dispose();
					new Main_Page();		
					
				}
			});;
		
	        
	        JButton b8=new JButton("Cancel Payment");		
			b8.setBounds(70,475,180,40);
			b8.setBackground(new Color(65,105,225));
			b8.setForeground(Color.WHITE);
			b8.setFont(new Font("Times Newroman", Font.BOLD,17));
			b8.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				//	JOptionPane.showMessageDialog(null, "Payment Cancelled ");
					cancel_payment();
					new Main_Page();				
					f.dispose();
				}
			});;
			
			 f= new JFrame("Book tickets"); 
			
			  
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
			f.add(b7);		
			f.add(b8);	
			//f.add(r1);
			//f.add(r2);    
			//f.add(r3);
		//	f.add(r4);
			f.add(pay_combo);
			 
			
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
		
	
		new Payment_Page();
	}
		
		public void make_payment() {
			
			String mode = pay_combo.getSelectedItem().toString();
			
			 try {
	            	Class.forName("com.mysql.jdbc.Driver");
	            	Connection 	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
	            	  Statement smt1 ,smt2,smt3,smt4;
	                  smt1 = conn.createStatement();
	                  smt2=conn.createStatement();
	                  smt3=conn.createStatement();
	                  smt4=conn.createStatement();
	                  
	             String    qry = " INSERT INTO `payment`(`mode_of_transaction` ) VALUES ('"+mode+"')";
	             int flag = smt1.executeUpdate(qry);
             String sql = "SELECT * from payment";
           	ResultSet rs = smt2.executeQuery(sql);
          
           	if(rs.last()) {
           		pnr_value =rs.getInt(2);
           		
           	}
         //  	rs.getInt("pnr");
           	
	                if (flag == 1) {
	                    JOptionPane.showMessageDialog(null, "TICKET BOOKED " +"\n "+" Your PNR NUMBER is:  "+ pnr_value);
	              
                        String sql1 ="UPDATE passenger_details  set pnr = '"+pnr_value+"' WHERE pnr =-1";	                 
                        smt3.executeUpdate(sql1);
                        smt4.executeUpdate(" UPDATE details  set pnr = '"+pnr_value+"' WHERE pnr =-1");
	                } else {
	                    JOptionPane.showMessageDialog(null, "Error - Passenger not added. Verify!!");
	                }
	            }
			    catch (Exception ex) {
		               JOptionPane.showMessageDialog(null, ex );
		      // ex.printStackTrace();
		            }
		

	
}
		public void cancel_payment() {
			try {
			Class.forName("com.mysql.jdbc.Driver");
        	Connection 	conne = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
        	  Statement smt11,stmt,stmt21 ;
              smt11 = conne.createStatement();
              stmt21=conne.createStatement();
              String dqry = "DELETE FROM passenger_details WHERE pnr =-1  AND user_id='"+user_id+"'  ";
              smt11.executeUpdate(dqry);
              stmt21.executeUpdate("DELETE FROM details WHERE pnr =-1 AND user_id='"+user_id+"'  "  );
              JOptionPane.showMessageDialog(null, "Payment Failed! Please Book Again");
              
            stmt = conne.createStatement();  
              stmt.executeUpdate("UPDATE availability set process = 'not processed' WHERE process='in process'  ");
		}
			 catch (Exception ex) {
	               JOptionPane.showMessageDialog(null, ex );
	      // ex.printStackTrace();
	            }
}
}
       

	


