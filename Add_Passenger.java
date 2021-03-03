package nishit;
import java.awt.*;
import java.util.*;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.EventQueue;
import static nishit.Payment_Page.*;
import static nishit.LoginPage.*;
import static nishit.Train_Details.*;

public class Add_Passenger   implements ActionListener {
	
public int pnrno;
public int uid=user_id;
public String da=date; 

  String nos = Passenger_Details.no;
  int co=0;
	    JPanel panel;
	    JFrame frame = new JFrame();
	    JLabel name_label, age_label, coach_label,seat_label,no_label,gender_label;
	   public JTextField name_text, age_text,no_text;
	    JLabel message_label;
	    JComboBox coach_combo,seat_combo,gender_combo;
	    JButton add_btn, view_btn;
	    
	   public static String pno_text ;
	   public static String pcoach;
	 public static   Vector<String> seat1 = new Vector<String>();
	    
	    Add_Passenger() {  	

	        frame.setLayout(null);
	        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Images\\logo.png");
			frame.setIconImage(icon);

	        name_label = new JLabel("Passenger Name :");
	        name_text = new JTextField(50);

	       age_label = new JLabel("Age :");
	        age_text = new JTextField(2);

			
			  coach_label = new JLabel("Coach Preference :");
		     String coach[]={"none","S1","S2","S3","S4"};
			 coach_combo=new JComboBox(coach);
			 
			 coach_combo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					seat_combo.removeAllItems();
					 //coachSeat();
					try {  
						
			    		Class.forName("com.mysql.jdbc.Driver");  

			    		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");  
			    		Statement st = conn.createStatement();
			 
			    		 ResultSet r=st.executeQuery("select * from availability WHERE train_no = '"+no_text.getText()+"'   AND coach = '"+coach_combo.getSelectedItem()+"'  AND status = 'not booked'  AND process ='not processed' ");
			    		
			    		 while (r.next() ) {  

			    		     seat_combo.addItem(r.getString("seat"));  
			    		     
			    		     
			    		 }
			    		
			    	

			    		 conn.close();
			    		 frame.repaint();
			    		 frame.validate();
			    		   
			    		    } catch (Exception ex) {  
			    		JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);
			    		//ex.printStackTrace();
			    		//System.exit(0);  
			    		
			    		}
					
					
				}
			});
			 
		        seat_label = new JLabel("Seat Number :");
		        seat_combo=new JComboBox();
				 
			   gender_label = new JLabel("Gender :");
			     String gender[]={"Male","Female","Others"};
			    gender_combo=new JComboBox(gender);
				
				 no_label =new JLabel("Train Number: ");
				 no_text = new JTextField(10);
				 no_text.setText(nos);
				 no_text.setEditable(false);
				 
				 
				
	        name_label.setBounds(30, 90, 120, 30);
	        age_label.setBounds(360, 90, 100, 30);
	        coach_label.setBounds(30, 150, 120, 30);
	        seat_label.setBounds(360, 150, 100, 30);
	         no_label.setBounds(360, 200, 120, 30);
	         gender_label.setBounds(30, 200, 120, 30);
	         
	        name_text.setBounds(140, 90, 170, 30);
	        age_text.setBounds(400, 90, 70, 30);
	        coach_combo.setBounds(160, 150, 70, 30);
	        seat_combo.setBounds(450, 150, 100, 30);
	        gender_combo.setBounds(140, 200, 120, 30);
	        no_text.setBounds(450, 200, 80, 30);

	        add_btn = new JButton("Add");
	        view_btn = new JButton("Show Passenger");

	       
	        view_btn.setBounds(80,250,170,30);
			view_btn.setBackground(new Color(65,105,225));
			view_btn.setForeground(Color.WHITE);
			view_btn.setFont(new Font("Times Newroman", Font.BOLD,14));
	        
	        
	        add_btn.setBounds(400,250,100,30);
	        add_btn.setBackground(new Color(65,105,225));
	        add_btn.setForeground(Color.WHITE);
	        add_btn.setFont(new Font("Times Newroman", Font.BOLD,14));
	        if(co==6) {
				add_btn.setEnabled(false);
			}
	        add_btn.addActionListener(new ActionListener() {
	    		
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
					if(name_text.getText().isEmpty() ) {
			       		JOptionPane.showMessageDialog(null, "Enter Passenger Name");
			       	
			       	}
			          	else if(Pattern.matches("^([a-zA-Z]+\\s)*[a-zA-Z]+$", name_text.getText())==false) {
			          		JOptionPane.showMessageDialog(null, "Passenger Name Should not contain Numbers");
			          	
			          	}
			          	else if(age_text.getText().isEmpty() ) {
			       		JOptionPane.showMessageDialog(null, "Enter Passenger Age");
			       		
			       	}
			          	else if(Pattern.matches("^\\d{1,2}$",age_text.getText())==false) {
			          		JOptionPane.showMessageDialog(null, "Enter Valid Age");
			          		
			          	}
			          	else {
			          		co++;
							addPass();
							seat1.add(seat_combo.getSelectedItem().toString());
							 seat_combo.removeItem(seat_combo.getSelectedItem());
							 frame.dispose();
			          	}
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Please Select Coach and Seat Number");
					}
					
				}
			});

	        message_label = new JLabel(); // Error Message for invalid create

	        frame.add(name_label);
	        frame.add(name_text);
	        frame.add(age_label);
	        frame.add(age_text);
	        frame.add(coach_label);
	        frame.add(coach_combo);
	        frame.add(seat_label);
	        frame.add(seat_combo);
	        frame.add(no_label);
	        frame.add(no_text);
	        frame.add(gender_combo);
	        frame.add(gender_label);
	       

	        frame.add(message_label);
	        frame.add(add_btn);
	        frame.add(view_btn);

	
	      view_btn.addActionListener(this);

	        Container c = frame.getContentPane();
	        frame.setTitle("Add Passenger - Details");
	        frame.setBounds(1315, 300, 600, 450);
	        c.setBackground(new Color(135,206,250));
	        frame.setResizable(false);
	      
	        frame.setVisible(true);

	    }

	public static void main(String[] args) {
		
	new  Add_Passenger();

	}
	
	@Override
    public void actionPerformed(ActionEvent e) {   
          showPassenger();
    }

    public void clearForm() {
        name_text.setText("");
     age_text.setText("");       
        name_text.requestFocus();
    }

    public void showPassenger() {
    	 seat_combo.removeItem(seat_combo.getSelectedItem());
        
        JTable table1 = new JTable();
        JScrollPane p1 = new JScrollPane(table1);
        p1.setBounds(30, 310, 520, 130);
        p1.setWheelScrollingEnabled(true);
        p1.setBackground(new Color(135,206,250));
        table1.setBackground(new Color(135,206,250));
        table1.setForeground(Color.black);
        DefaultTableModel t1 = (DefaultTableModel) table1.getModel();
        t1.addColumn(" name");
        t1.addColumn("age");
    
        t1.addColumn("gender");
        t1.addColumn("coach");
        t1.addColumn("seat");
        // Fetching all details of passenger from DB       
 
            
            
            
            String strQry = "";
            try {
            	Class.forName("com.mysql.jdbc.Driver");
            	  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
            	  Statement     smt = con.createStatement();

            	  ResultSet   rs= smt.executeQuery("select * from passenger_details WHERE pnr=-1 AND train_no = '"+nos +"' ");
                while(rs.next()){
                    String name = rs.getString("name");
                    String age = rs.getString("age");
                    String gender = rs.getString("gender");
                    String coach = rs.getString("coach");
                    String seat = rs.getString("seat");
                    t1.addRow(new Object[]{name,age,gender,coach,seat});
                }
            }catch(Exception f) {
                System.out.println(f);
            }
       
        table1.setModel(t1);
        frame.add(p1);
        frame.setSize(600, 500);
       
    }


    public void addPass() {
    	
            pno_text = no_text.getText();
           String pname = name_text.getText();
            String page = age_text.getText();
            String pgender = gender_combo.getSelectedItem().toString();
             pcoach = coach_combo.getSelectedItem().toString();
            String pseat = seat_combo.getSelectedItem().toString();
       
           int age = Integer.parseInt(age_text.getText());
           int pnr=-1;
        //  int flag=0;
          	
          // if(flag==0) {
        	   try {
            	
        		   Class.forName("com.mysql.jdbc.Driver");
            
        		   	Connection 	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
        		   	Statement smt,stmt,stmt1 ;
        		   	smt = con.createStatement();   
        		   	stmt1=con.createStatement();
                  
            
  
           	
            String    strQry =      " INSERT INTO `passenger_details`(`train_no`, `train_name`, `name`, `age`, `gender`, `coach`, `seat`, `pnr`, `user_id`) VALUES ('"+pno_text+"','"+namee+"','"+pname+"','"+age+"','"+pgender+"','"+pcoach+"','"+pseat+"','"+pnr+"','"+uid+"')	";
             
            int Count = smt.executeUpdate(strQry);
               
              
                if (Count == 1) {
                    JOptionPane.showMessageDialog(null, "Passenger Added ");
                    stmt1.executeUpdate(" INSERT INTO `details`(`train_no`, `train_name`, `name`, `age`, `gender`, `coach`, `seat`, `date`, `pnr`, `user_id`) VALUES ('"+pno_text+"','"+namee+"','"+pname+"','"+age+"','"+pgender+"','"+pcoach+"','"+pseat+"','"+da+"','"+pnr+"','"+uid+"' ) ");
                  //  clearForm();
                } else {
                    JOptionPane.showMessageDialog(null, "Error - Passenger not added. Verify!!");
                }
                stmt = con.createStatement();  
                stmt.executeUpdate("UPDATE availability set process = 'in process' WHERE seat='"+seat_combo.getSelectedItem()+"' AND coach='"+coach_combo.getSelectedItem()+"'  AND train_no = '"+nos+"'  ");
            
            }
      
           
             catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "Enter the fields properly" );
      // ex.printStackTrace();
            }
    }
    //}
    
}


