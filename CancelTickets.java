package nishit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.*;


public class CancelTickets extends JFrame{	
	
	Container c = getContentPane();
	
	JPanel panel = new JPanel();
	
	JLabel label_image = new JLabel();
	JLabel label_heading = new JLabel();
	JLabel label_passenger=new JLabel();
	JLabel label_trainnum=new JLabel();
	JLabel label_coachno=new JLabel();
	JLabel label_seatno=new JLabel();
	JLabel back1=new JLabel();
	
	JTextField textfield_name=new JTextField();
	JTextField textfield_trainnum=new JTextField();
	JTextField textfield__coachno=new JTextField();
	JTextField textfield_seatno=new JTextField();
	
	JButton button_delete=new JButton();
	
	Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Images\\logo.png");
	
	ImageIcon iconLo = new ImageIcon(new ImageIcon("D:\\Images\\logo.png").getImage().getScaledInstance(110,90, Image.SCALE_DEFAULT));
	
	public CancelTickets() {
	 	 
		setNavigationPanel();
		setLayoutManager();
		setLocationAndSize();
		addComponentsToTheContainer();
		addActionEvent();
		frame();
		
	}
	public void setLayoutManager() {
		c.setLayout(null);
	}
	public void addComponentsToTheContainer() {
		c.add(panel);
		c.add(label_image);
		c.setBackground(new Color(135,206,250));
		c.add(textfield_name);
		c.add(textfield_trainnum);
		c.add(textfield__coachno);
		c.add(textfield_seatno);
		c.add(label_passenger);
		c.add(label_trainnum);
		c.add(label_coachno);
		c.add(label_seatno);
		c.add(button_delete);
		  c.add(back1);
		
		
	}

	public void addActionEvent() {
		button_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelTicket();
				
			}
		});
		  back1.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent e){              
	             dispose();
	                new Main_Page();
	            } 
	});
	}

	public void setLocationAndSize() {
		
		
	    back1.setBounds(30,490,90,50);
		ImageIcon backbutton = new ImageIcon(new ImageIcon("D:\\Images\\back1.png").getImage().getScaledInstance(45,45, Image.SCALE_DEFAULT));
		back1.setIcon(backbutton);
		
      
		label_heading.setText("Cancel Tickets");
		label_heading.setBounds(160, 10, 400, 100);
		label_heading.setFont(new Font("Times Newroman", Font.BOLD,25));
	    label_heading.setForeground(Color.white);
		label_heading.setHorizontalAlignment(JLabel.CENTER);
		
		label_passenger.setText("Passenger Name");
		label_passenger.setBounds(90, 260, 200, 30);
		label_passenger.setFont(new Font("Times Newroman", Font.BOLD,15));
		label_passenger.setForeground(Color.black);
	    
		label_trainnum.setText("Train Number");
		label_trainnum.setBounds(250, 260, 200, 30);
		label_trainnum.setFont(new Font("Times Newroman", Font.BOLD,15));
		label_trainnum.setForeground(Color.black);
	    
	    label_coachno.setText("Coach Number");
		label_coachno.setBounds(395, 260, 200, 30);
		label_coachno.setFont(new Font("Times Newroman", Font.BOLD,15));
	    label_coachno.setForeground(Color.black);
		
	    label_seatno.setText("Seat Number");
		label_seatno.setBounds(553, 260, 200, 30);
		label_seatno.setFont(new Font("Times Newroman", Font.BOLD,15));
	    label_seatno.setForeground(Color.black);
	    
		label_image.setIcon(iconLo);
	    label_image.setBounds(320, 95,100,100);
	    
	    textfield_name.setBounds(100, 300, 100, 30);
	    textfield_trainnum.setBounds(250, 300, 100, 30);
	    textfield__coachno.setBounds(400, 300, 100, 30);
	    textfield_seatno.setBounds(550, 300, 100, 30);
	    
	    button_delete.setBounds(300, 425, 150, 30);
	    button_delete.setText("Cancel Ticket");
	    button_delete.setFont(new Font("Times Newroman", Font.BOLD,15));
	    button_delete.setBackground(new Color(65,105,225));
	    button_delete.setForeground(Color.white);
	}


	public void frame() {
		setLayout(null);
		setSize(750,600);
		setIconImage(icon);
		setLocationRelativeTo(null); 
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    setResizable(false);
	    setVisible(true);	
	}
	
	public void setLayoutManger() {
		c.setLayout(null);
	}
	  	
	public void setNavigationPanel() {
		panel.setBackground(new Color(65,105,225));
		panel.setBounds(0, 0, 750, 80); 
		panel.add(label_heading);
	}
	
	public void cancelTicket() {
		int flag=0;
		String name=textfield_name.getText();
		String trainnum=textfield_trainnum.getText();
		String coachnum=textfield__coachno.getText();
		String seatnum=textfield_seatno.getText();
		if(name.isEmpty()==true) {
			flag=1;
			JOptionPane.showMessageDialog(new JFrame(),"Name can't be empty", "INVALID ENTRY",JOptionPane.ERROR_MESSAGE);
		}
		else if(trainnum.isEmpty()==true) {
			flag=1;
			JOptionPane.showMessageDialog(new JFrame(),"Train number can't be empty", "INVALID ENTRY",JOptionPane.ERROR_MESSAGE);
		}
		else if(coachnum.isEmpty()==true) {
			flag=1;
			JOptionPane.showMessageDialog(new JFrame(),"Coach number can't be empty", "INVALID ENTRY",JOptionPane.ERROR_MESSAGE);
		}
		else if(seatnum.isEmpty()==true) {
			flag=1;
			JOptionPane.showMessageDialog(new JFrame(),"Seat number can't be empty", "INVALID ENTRY",JOptionPane.ERROR_MESSAGE);
		}
		else if(Pattern.matches("^\\d{1,2}$",seatnum)==false) {
			flag=1;
			JOptionPane.showMessageDialog(new JFrame(),"Seat number must be 1-2 digits", "INVALID ENTRY",JOptionPane.ERROR_MESSAGE);
		}
		else if(flag==0){
			try{
				Class.forName("com.mysql.jdbc.Driver");
	        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
	        	Statement stmt=con.createStatement();
	        	ResultSet rs=stmt.executeQuery("SELECT * FROM passenger_details");
	        	while(rs.next()) {
	        		if(rs.getString("name").equals(name) && rs.getString("train_no").equals(trainnum) && rs.getString("coach").equals(coachnum) && Integer.toString(rs.getInt("seat")).equals(seatnum)) {
	        			flag=1;
	        			break;
	        		}
	        	}
	        	if(flag==1) {
	        		Statement stmt1=con.createStatement();
	        		Statement stmt2=con.createStatement();
	        		Statement stmt3=con.createStatement();
			       	String query="DELETE FROM details WHERE name='"+name+"' AND train_no='"+trainnum+"' AND coach='"+coachnum+"' AND seat='"+Integer.parseInt(seatnum)+"'";
		        	stmt1.executeUpdate(query);
		        	stmt2.executeUpdate("UPDATE availability SET status='not booked',process='not processed' WHERE train_no='"+trainnum+"' AND coach='"+coachnum+"' AND seat='"+Integer.parseInt(seatnum)+"'");
		        	stmt3.executeUpdate("DELETE FROM passenger_details WHERE train_no='"+trainnum+"' AND coach='"+coachnum+"' AND seat='"+Integer.parseInt(seatnum)+"'");
		        	JOptionPane.showMessageDialog(new JFrame(),"Ticket has been cancelled successfully", "TICKET CANCELLED",JOptionPane.INFORMATION_MESSAGE);
			        dispose();
			        new PnrDetails();
			        
	        	}
	        	else{
	    			JOptionPane.showMessageDialog(new JFrame()," Ticket details not found ", "INVALID TICKET",JOptionPane.ERROR_MESSAGE);
	    		}
		       	
	        }
			catch(Exception e){
				e.printStackTrace();
				}
			}	
		}
	public static void main(String[] args) {
		new CancelTickets();	
	}	
}