package nishit;

import java.util.regex.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.*;

public class LoginPage extends JFrame{
	
	Container c=getContentPane();
	
	public static  int user_id;

	
	JPanel panel=new JPanel();
	
	Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Images\\logo.png");
	
	JLabel headingLabel=new JLabel();
	JLabel usertypeLabel=new JLabel();
	JLabel usernameLabel=new JLabel();
	JLabel passwordLabel=new JLabel();
	JLabel nothavingLabel=new JLabel();
	
	
	JTextField usernameField=new JTextField();
	
	JPasswordField passwordField=new JPasswordField();
	
	String usertype[]={"User","Admin"};
	JComboBox usertypeCombobox=new JComboBox(usertype);
	
	JButton signinButton=new JButton();
	JButton signupButton=new JButton();
	JButton exitButton=new JButton();
		
	public LoginPage(){
		setLayoutManager();
		setNavigationPanel();
		setLocationAndSize();
		addCompenentsToTheConatiner();
		addItemEvent();
		addActionEvent();
		frame();
	}
	public void frame() {
		setTitle("Login");
		setSize(750,600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(icon);
		setLocationRelativeTo(null); 
		setVisible(true);
	}
	public void setLayoutManager(){
		c.setLayout(null);
	}
	public void setNavigationPanel() {
		panel.setBackground(new Color(65,105,225));
		panel.setBounds(0, 0, 750, 80); 
		panel.add(headingLabel);
	}
	
	public void addItemEvent() {
		usertypeCombobox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(usertypeCombobox.getSelectedItem()=="Admin") {
					signupButton.setEnabled(false);
				}
				if(usertypeCombobox.getSelectedItem()=="User") {
					signupButton.setEnabled(true);
				}
				
			}
		});
	}
	
	public void setLocationAndSize(){
		
		headingLabel.setBounds(90,0,550,80);
		headingLabel.setText("Railway Reservation System");
		headingLabel.setHorizontalAlignment(JLabel.CENTER); 
        headingLabel.setFont(new Font("Times Newroman", Font.BOLD,20));
        headingLabel.setForeground(Color.white);
        
		usertypeLabel.setBounds(235,150,100,50);
		usertypeLabel.setText("Usertype");
		usertypeLabel.setFont(new Font("Times Newroman", Font.BOLD, 18));
		
		usernameLabel.setBounds(235,250,100,50);
		usernameLabel.setText("Username");
		usernameLabel.setFont(new Font("Times Newroman", Font.BOLD, 18));
		
		passwordLabel.setBounds(235,350,100,50);
		passwordLabel.setText("Password");
		passwordLabel.setFont(new Font("Times Newroman", Font.BOLD, 18));
		
		usernameField.setBounds(360, 262, 150, 30);
		
		
		passwordField.setBounds(360, 362, 150, 30);
		
		usertypeCombobox.setBounds(360, 162, 150, 30);
		
		
		signinButton.setBounds(210, 462, 100, 30);
		signinButton.setText("Sign in");
		signinButton.setBackground(new Color(65,105,225));
		signinButton.setForeground(Color.white);
		
		signupButton.setBounds(330, 462, 100, 30);
		signupButton.setText("Sign up");
		signupButton.setBackground(new Color(65,105,225));
		signupButton.setForeground(Color.white);
		
		exitButton.setBounds(450, 462, 100, 30);
		exitButton.setText("Exit");
		exitButton.setBackground(new Color(65,105,225));
		exitButton.setForeground(Color.white);
		
	}
	
	public void addCompenentsToTheConatiner(){
		c.add(panel);
		c.setBackground(new Color(135,206,250));
		c.add(usertypeLabel);
		c.add(usernameLabel);
		c.add(passwordLabel);
		c.add(usernameField);
		c.add(passwordField);
		c.add(usertypeCombobox);
		c.add(signinButton);
		c.add(signupButton);
		c.add(exitButton);
		
		
	}
	
	
	public void addActionEvent(){
		signupButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					new SignupPage();
				} 
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		signinButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					signin();
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
	}
	
	
	
	
	public void signin() throws Exception{
		if(usertypeCombobox.getSelectedItem()=="User") {
			try{
				int flag=0;
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
				Statement stmt=con.createStatement();
				String user_name=usernameField.getText();
				String pass_word=passwordField.getText();
				String query="Select * from user_details";
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next()){
					if(rs.getString("username").equals(user_name) && rs.getString("password").equals(pass_word)){
						flag=1;
						break;
					}
				}
				if(flag==1){					
				Statement stmt1=con.createStatement();
				
				ResultSet r = stmt1.executeQuery(" SELECT user_id from user_details WHERE username = '"+user_name+"'");
				if(r.next()) {
				user_id=	r.getInt("user_id");
			
				}
				//System.out.println(user_id);
					new Main_Page();
					dispose();
				}
				if(flag==0){
					JOptionPane.showMessageDialog(new JFrame(),"Check the username and password or Please create an account ", " Account not found ",JOptionPane.WARNING_MESSAGE);
					dispose();
					new SignupPage();
				}
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		else {
			try{
				int flag=0;
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
				Statement stmt=con.createStatement();
				String user_name=usernameField.getText();
				String pass_word=passwordField.getText();
				String query="Select * from admin_details";
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next()){
					if(rs.getString("username").equals(user_name) && rs.getString("password").equals(pass_word)){
						flag=1;
						break;
					}
				}
				if(flag==1){
					dispose();
					new Admin_Options();
					
				}
				if(flag==0){
					JOptionPane.showMessageDialog(new JFrame(),"Make sure the username and password is correct", " Access Denied",JOptionPane.ERROR_MESSAGE);
					dispose();
					new LoginPage();
				}
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		new LoginPage();

		
		
	}
}
