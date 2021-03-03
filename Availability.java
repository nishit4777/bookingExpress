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

import static nishit.PnrDetails.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Availability extends JFrame{	
	
	
	Container c = getContentPane();
	
	JPanel panel = new JPanel();
	
	JLabel label_image = new JLabel();
	JLabel label_heading = new JLabel();
	JLabel label_trainnum=new JLabel();
	JLabel label_coachno=new JLabel();
	JLabel label_seatno=new JLabel();
	JLabel back=new JLabel();
	JButton addbutton=new JButton();
	
	JTextField textfield_trainnum=new JTextField();
	JTextField textfield__coachno=new JTextField();
	JTextField textfield_seatno=new JTextField();

	
	Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Images\\logo.png");
	
    ImageIcon iconLo = new ImageIcon(new ImageIcon("D:\\Images\\logo.png").getImage().getScaledInstance(100,90, Image.SCALE_DEFAULT));
    

	
	public Availability() {	 	
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
		c.add(addbutton);
		c.add(textfield_trainnum);
		c.add(textfield__coachno);
		c.add(textfield_seatno);
		c.add(label_trainnum);
		c.add(label_coachno);
		c.add(label_seatno);
		c.add(back);
	}
	
	public void addActionEvent() {
		addbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				availability();
			}
		});
		
		  back.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent e){              
	            dispose();
	                new Admin_Options();
	            } 
	});
	}
	
	
	
	public void availability() {
        try {	
        	int flag=0;
        	String trainnum=textfield_trainnum.getText();
        	String coachnum=textfield__coachno.getText();
        	int seatnum=Integer.parseInt(textfield_seatno.getText());
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
        	if(textfield_trainnum.getText().isEmpty()==false && textfield__coachno.getText().isEmpty()==false && textfield_seatno.getText().isEmpty()==false) {
        		if(Pattern.matches("^\\d{1,2}$",textfield_seatno.getText())==false || seatnum>72) {
        			JOptionPane.showMessageDialog(new JFrame(),"Seat must be number less than 73", "INVALID ENTRY",JOptionPane.ERROR_MESSAGE);
        			flag=1;
        		}
        		if(flag==0) {
        			Statement stmt=con.createStatement();
        			String query="SELECT train_no FROM train_details";
        			ResultSet rs=stmt.executeQuery(query);
        			while(rs.next()) {
        				
        				if(rs.getString("train_no").equals(trainnum)){
        					flag=1;
        					break;
        				}
        			}
        			if(flag==1) {
        				Statement stmt1=con.createStatement();
            			String query1="SELECT * FROM availability";
            			ResultSet rs1=stmt1.executeQuery(query1);
            			while(rs1.next()) {
            				if(rs1.getString("train_no").equals(trainnum) && rs1.getString("coach").equals(coachnum) && rs1.getInt("seat")==seatnum) {
            					flag=0;
            					JOptionPane.showMessageDialog(new JFrame(),"Coach number and Seat number for this train is already entered", "INVALID ENTRY",JOptionPane.ERROR_MESSAGE);
            					break;
            				}
            			}
            			if(flag==1) {
            				Statement stmt2=con.createStatement();
            				String query2="INSERT INTO `availability`(`train_no`, `coach`, `seat`, `status`, `process`) VALUES ('"+trainnum+"','"+coachnum+"','"+seatnum+"','not booked' , 'not processed')";
            				stmt2.executeUpdate(query2);
            				JOptionPane.showMessageDialog(new JFrame(),"Seats added", "ENTRY ACCEPTED",JOptionPane.INFORMATION_MESSAGE);
            			}
            			
        			}
        			else {
        				JOptionPane.showMessageDialog(new JFrame(),"Train Number not available", "INVALID ENTRY",JOptionPane.ERROR_MESSAGE);
        			}
        			
        		}
        	}
        	else {
        		JOptionPane.showMessageDialog(new JFrame(),"Fields can't be empty", "INVALID ENTRY",JOptionPane.ERROR_MESSAGE);
        	}
        	con.close();
        }
		catch(Exception e){
			System.out.print(e);
		}    
	}
        
	
	public void setLocationAndSize() {
		
        
	    back.setBounds(30,490,90,50);
		ImageIcon backbutton = new ImageIcon(new ImageIcon("D:\\Images\\back1.png").getImage().getScaledInstance(45,45, Image.SCALE_DEFAULT));
		back.setIcon(backbutton);
		
      
		
		label_heading.setText("Availability");
		label_heading.setBounds(160, 10, 400, 100);
		label_heading.setFont(new Font("Times Newroman", Font.BOLD,20));
	    label_heading.setForeground(Color.white);
		label_heading.setHorizontalAlignment(JLabel.CENTER);
	       
	    label_image.setIcon(iconLo);
	    label_image.setBounds(308, 105,100,90);
	    
	    label_trainnum.setText("Train Number");
		label_trainnum.setBounds(160, 260, 200, 30);
		label_trainnum.setFont(new Font("Times Newroman", Font.BOLD,15));
		label_trainnum.setForeground(Color.black);
	    
	    label_coachno.setText("Coach Number");
		label_coachno.setBounds(317, 260, 200, 30);
		label_coachno.setFont(new Font("Times Newroman", Font.BOLD,15));
	    label_coachno.setForeground(Color.black);
		
	    label_seatno.setText("Seat Number");
		label_seatno.setBounds(493, 260, 200, 30);
		label_seatno.setFont(new Font("Times Newroman", Font.BOLD,15));
	    label_seatno.setForeground(Color.black);
	 
		addbutton.setText("ADD");
		addbutton.setForeground(Color.white);
		addbutton.setBounds(325, 420, 80, 35);
		addbutton.setBackground(new Color(65,105,225));
		addbutton.setFont(new Font("Times Newroman", Font.BOLD,15));
		
		textfield_trainnum.setBounds(160, 300, 100, 30);
	    textfield__coachno.setBounds(320, 300, 100, 30);
	    textfield_seatno.setBounds(490, 300, 100, 30);
	   
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
	
	public static void main(String[] args) {
		new Availability();	
	}	
}