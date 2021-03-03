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

public class SignupPage extends JFrame{
	
	Container c=getContentPane();
	
	public int userid;
	
	JPanel panel=new JPanel();
	
	JLabel label_firstName=new JLabel();
	JLabel label_lastName=new JLabel();
	JLabel label_age=new JLabel();
	JLabel label_gender=new JLabel();
	JLabel label_phonenum=new JLabel();
	JLabel label_username=new JLabel();
	JLabel label_password=new JLabel();
	JLabel label_male=new JLabel();
	JLabel label_female=new JLabel();
	
	JTextField textfield_firstName=new JTextField();
	JTextField textfield_lastName=new JTextField();
	JTextField textfield_age=new JTextField();
	JTextField textfield_phonenum=new JTextField();
	JTextField textfield_username=new JTextField();
	
	JPasswordField passwordfield_password=new JPasswordField();
	
	JRadioButton radiobutton_male=new JRadioButton();
	JRadioButton radiobutton_female=new JRadioButton();
	
	Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Images\\logo.png");
	
	JLabel headingLabel=new JLabel();
	
	JButton signupButton=new JButton();
	JButton exitButton=new JButton();
	JButton backbutton=new JButton();
	
	
		
	public SignupPage(){
		setLayoutManager();
		setNavigationPanel();
		setLocationAndSize();
		addCompenentsToTheConatiner();
		addActionEvent();
		buttonGroup();
		frame();
		
	}
	public void buttonGroup() {
		ButtonGroup bg=new ButtonGroup();
		bg.add(radiobutton_male);
		bg.add(radiobutton_female);
	}
	public void frame() {
		setTitle("Signup");
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
	
	
	public void setLocationAndSize(){
		
		headingLabel.setBounds(90,0,550,80);
		headingLabel.setText("Create an Account");
		headingLabel.setHorizontalAlignment(JLabel.CENTER); 
        headingLabel.setFont(new Font("Times Newroman", Font.BOLD,20));
        headingLabel.setForeground(Color.white);
        
        label_firstName.setBounds(235,100,100,50);
        label_firstName.setText("First Name");
        label_firstName.setFont(new Font("Times Newroman", Font.BOLD,15));
        label_firstName.setForeground(Color.black);
        
        label_lastName.setBounds(235,150,100,50);
        label_lastName.setText("Last Name");
        label_lastName.setFont(new Font("Times Newroman", Font.BOLD,15));
        label_lastName.setForeground(Color.black);
        
        label_age.setBounds(235,200,100,50);
        label_age.setText("Age");
        label_age.setFont(new Font("Times Newroman", Font.BOLD,15));
        label_age.setForeground(Color.black);
        
        label_gender.setBounds(235,250,100,50);
        label_gender.setText("Gender");
        label_gender.setFont(new Font("Times Newroman", Font.BOLD,15));
        label_gender.setForeground(Color.black);
        
        label_phonenum.setBounds(235,300,150,50);
        label_phonenum.setText("Phone number");
        label_phonenum.setFont(new Font("Times Newroman", Font.BOLD,15));
        label_phonenum.setForeground(Color.black);
        
        label_username.setBounds(235,350,150,50);
        label_username.setText("Username");
        label_username.setFont(new Font("Times Newroman", Font.BOLD,15));
        label_username.setForeground(Color.black);
        
        label_password.setBounds(235,400,150,50);
        label_password.setText("Password");
        label_password.setFont(new Font("Times Newroman", Font.BOLD,15));
        label_password.setForeground(Color.black);
        
        label_male.setBounds(380,250,150,50);
        label_male.setText("male");
        label_male.setFont(new Font("Times Newroman", Font.BOLD,15));
        label_male.setForeground(Color.black);
        
        label_female.setBounds(460,250,150,50);
        label_female.setText("female");
        label_female.setFont(new Font("Times Newroman", Font.BOLD,15));
        label_female.setForeground(Color.black);
        

        textfield_firstName.setBounds(360, 112, 150, 30);
        textfield_lastName.setBounds(360, 162, 150, 30);
        textfield_age.setBounds(360, 212, 150, 30);
        textfield_phonenum.setBounds(360, 312, 150, 30);
        textfield_username.setBounds(360, 362, 150, 30);
        
        passwordfield_password.setBounds(360, 412, 150, 30);
        
        radiobutton_male.setBounds(360,265,20,20);
        radiobutton_male.setBackground(new Color(135,206,250));
        
        radiobutton_female.setBounds(440,265,20,20);
        radiobutton_female.setBackground(new Color(135,206,250));
        radiobutton_male.setSelected(true);
		
		signupButton.setBounds(200, 482, 100, 30);
		signupButton.setText("Sign up");
		signupButton.setBackground(new Color(65,105,225));
		signupButton.setForeground(Color.white);
		
		exitButton.setBounds(500, 482, 100, 30);
		exitButton.setText("Exit");
		exitButton.setBackground(new Color(65,105,225));
		exitButton.setForeground(Color.white);
		
		backbutton.setBounds(350, 482, 100, 30);
		backbutton.setText("Back");
		backbutton.setBackground(new Color(65,105,225));
		backbutton.setForeground(Color.white);
		
	}
	
	public void addCompenentsToTheConatiner(){
		c.add(panel);
		
		c.setBackground(new Color(135,206,250));
		
		c.add(label_firstName);
		c.add(label_lastName);
		c.add(label_age);
		c.add(label_gender);
		c.add(label_phonenum);
		c.add(label_username);
		c.add(label_password);
		c.add(label_male);
		c.add(label_female);
		
		c.add(signupButton);
		c.add(exitButton);
		c.add(backbutton);
		
		c.add(textfield_firstName);
		c.add(textfield_lastName);
		c.add(textfield_age);
		c.add(textfield_phonenum);
		c.add(textfield_username);
		
		c.add(passwordfield_password);
		
		c.add(radiobutton_male);
		c.add(radiobutton_female);
		
	}
	
	
	public void addActionEvent(){
		signupButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					signup();
				} 
				catch (Exception ex) {
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
		
		backbutton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginPage();
				
			}
		});
	}
	
	
	
	public void signup() throws Exception{
		try{
			int flag=0;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
			Statement stmt=con.createStatement();
			Statement stmt1=con.createStatement();
			Statement stmt2=con.createStatement();
			String first_name=textfield_firstName.getText();
			String last_name=textfield_lastName.getText();
			String s_age=textfield_age.getText();
			String gender;
			String phone_num=textfield_phonenum.getText();
			String user_name=textfield_username.getText();
			String pass_word=passwordfield_password.getText();
			if(radiobutton_male.isSelected()==true) {
				gender="male";
			}
			else {
				gender="female";
			}
			Boolean a=Pattern.matches("^([a-zA-Z]+\\s)*[a-zA-Z]+$", first_name);
			Boolean b=Pattern.matches("^([a-zA-Z]+\\s)*[a-zA-Z]+$", last_name);
			Boolean d=Pattern.matches("^\\d{10}$", phone_num);
			Boolean e=Pattern.matches("^[aA-zZ]\\w{4,20}$", user_name);
			String query="SELECT * from user_details";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				if(rs.getString("username").equals(user_name)) {
					JOptionPane.showMessageDialog(new JFrame(), "Username not vaild", "USERNAME ALREADY EXISTS", JOptionPane.ERROR_MESSAGE);
					flag=1;
					con.close();
					break;
				}
			}
			if(flag==0) {
				if(first_name.isEmpty()) {
					JOptionPane.showMessageDialog(new JFrame(), "Firstname cannot be empty", "INVALID FIRSTNAME", JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				else if(a==false) {
					JOptionPane.showMessageDialog(new JFrame(), "Firstname should contain only characters", "INVALID FIRSTNAME", JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				else if(last_name.isEmpty()) {
					JOptionPane.showMessageDialog(new JFrame(), "Lastname cannot be empty", "INVALID LASTNAME", JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				else if(b==false) {
					JOptionPane.showMessageDialog(new JFrame(), "Lastname should contain only characters", "INVALID LASTNAME", JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				else if(s_age.isEmpty()){
					JOptionPane.showMessageDialog(new JFrame(), "Age should not be empty", "AGE IS EMPTY", JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				else if(Pattern.matches("^\\d{1,2}$",s_age)==false) {
					JOptionPane.showMessageDialog(new JFrame(), "Age should be a valid value ", "INVALID AGE", JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				else if(Integer.parseInt(s_age)<18) {
					JOptionPane.showMessageDialog(new JFrame(), "Age should be greater than 17", "INVALID AGE", JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				else if(phone_num.isEmpty()) {
					JOptionPane.showMessageDialog(new JFrame(), "Phonenumber cannot be empty", "INVALID PHONE NUMBER", JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				else if(d==false) {
					JOptionPane.showMessageDialog(new JFrame(), "Phone must be 10-digit number", "INVALID PHONE NUMBER", JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				else if(user_name.isEmpty()) {
					JOptionPane.showMessageDialog(new JFrame(), "Username cannot be empty", "INVALID USERNAME", JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				else if(e==false) {
					JOptionPane.showMessageDialog(new JFrame(), "Username must be 5-20 characters", "INVALID USERNAME", JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				else if(pass_word.isEmpty()) {
					JOptionPane.showMessageDialog(new JFrame(), "Password cannot be empty", "INVALID PASSWORD", JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				else if(pass_word.length()<8 || pass_word.length()>20) {
					JOptionPane.showMessageDialog(new JFrame(), "Password must contain 8-20 characters", "INVALID PASSWORD", JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				if(flag==0) {
					String query1="INSERT into user_details(firstname,lastname,age,gender,phonenumber,username,password) values('"+first_name+"','"+last_name+"','"+Integer.parseInt(s_age)+"','"+gender+"','"+phone_num+"','"+user_name+"','"+pass_word+"')";
					stmt1.executeUpdate(query1);
					
					JOptionPane.showMessageDialog(new JFrame(),"Account created successfully","ACCOUNT CREATED",JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(new JFrame(),"Please remember your username and password\n             Username is "+user_name+"\n             Password is "+pass_word,"ACCOUNT CREATED",JOptionPane.WARNING_MESSAGE);
					
					dispose();
					new LoginPage();
					
				}
				con.close();
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		new SignupPage();
		
	}
}
