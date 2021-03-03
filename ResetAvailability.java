package nishit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ResetAvailability extends JFrame{	
	
	Container c = getContentPane();
	
	JPanel panel = new JPanel();
	
	JLabel label_trainnumber=new JLabel();
	JLabel label_image= new JLabel();
	JLabel label_headingviewtickets=new JLabel();
	

	
	JTextField textfield_trainnumber=new JTextField();

	
	JButton button_reset=new JButton();
	
	Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Images\\logo.png");
	
	ImageIcon iconLo = new ImageIcon(new ImageIcon("D:\\Images\\logo.png").getImage().getScaledInstance(100,90, Image.SCALE_DEFAULT));
	
	ResetAvailability() { 	 
		setNavigationPanel();
		setLayoutManager();
		setLocationAndSize();
		addComponentsToTheContainer();
		addActionEvent();
		frame();
	}
	
	
	public void setLocationAndSize() {
		
		label_headingviewtickets.setBounds(160, 20, 400, 100);
		label_headingviewtickets.setText("RESET");
		label_headingviewtickets.setFont(new Font("Times Newroman", Font.BOLD,20));
	    label_headingviewtickets.setForeground(Color.white);
		label_headingviewtickets.setHorizontalAlignment(JLabel.CENTER);
		
		label_trainnumber.setBounds(250, 240, 180, 30);
		label_trainnumber.setText("Train Number ");
		label_trainnumber.setFont(new Font("Times Newroman", Font.BOLD, 18));
		label_trainnumber.setForeground(Color.black);
		
		label_image.setIcon(iconLo);
		label_image.setBounds(308, 105,100,90);
		
		textfield_trainnumber.setBounds(400, 240, 70, 30);
		
		
		button_reset.setText("Search");
		button_reset.setBounds(320, 310, 100, 30);
		button_reset.setBackground(new Color(65,105,225));
		button_reset.setForeground(Color.white);
		button_reset.setFont(new Font("Times Newroman", Font.BOLD,15));
		
	}

	public void addComponentsToTheContainer(){
		c.add(panel);
		c.add(label_image);
		c.setBackground(new Color(135,206,250));
		
		c.add(button_reset);
		c.add(label_trainnumber);
		c.add(textfield_trainnumber);
		
	}
	
	public void setLayoutManager() {
		c.setLayout(null);
	}
	
	
	
	public void setNavigationPanel() {
		panel.setBackground(new Color(65,105,225));
		panel.setBounds(0, 0, 750, 80); 
		panel.add(label_headingviewtickets);
		
	}
	
	public void addActionEvent() {
		button_reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Reset();
				
				
			}
		});
	}
	public void Reset() {
		try{
			int flag=0,count=0;
			String trainno=textfield_trainnumber.getText();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
			if(trainno.isEmpty()==false) {
				Statement stmt=con.createStatement();
				String query="SELECT train_no FROM train_details";
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next()) {
					if(rs.getString("train_no").equals(trainno)){
						flag=1;
						break;
					}
				}
				if(flag==1) {
					Statement stmt3=con.createStatement();
					ResultSet rs1=stmt3.executeQuery("SELECT train_no from passenger_details WHERE train_no='"+trainno+"' ");
					while(rs1.next()){
						count++;
						break;
					}
					
					if(count!=0) {
						Statement stmt1=con.createStatement();
						Statement stmt2=con.createStatement();
						String query1="DELETE FROM passenger_details where train_no='"+trainno+"'";
						String query2="UPDATE availability SET status='not booked' , process='not processed' WHERE status='booked' AND train_no='"+trainno+"' AND process='processed' " ;
						stmt1.executeUpdate(query1);
						stmt2.executeUpdate(query2);
						JOptionPane.showMessageDialog(new JFrame(),"Train Availability have been reset", "RESET SUCCESSFUL",JOptionPane.INFORMATION_MESSAGE);

										}
					else {
						JOptionPane.showMessageDialog(new JFrame(),"No Details present to reset TRAIN DETAILS", "RESET UNSUCCESSFUL",JOptionPane.WARNING_MESSAGE);
					}
									}
				else {
					JOptionPane.showMessageDialog(new JFrame(),"Train Number not available", "INVALID ENTRY",JOptionPane.ERROR_MESSAGE);
				}
			}
			
			else {
        		JOptionPane.showMessageDialog(new JFrame(),"Fields can't be empty", "INVALID ENTRY",JOptionPane.ERROR_MESSAGE);
        	}
			
			
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void frame() {
		
		setSize(750,600);
		setIconImage(icon);
		setLocationRelativeTo(null); 
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    setResizable(false);
	    setVisible(true);	
	}
	
	public static void main(String[] args) {
		new ResetAvailability();
		
	}	
}