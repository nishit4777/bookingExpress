package nishit;

	import java.awt.Color;
	import java.awt.Container;
	import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
import java.sql.Statement;
import static nishit.Passenger_Details.*;
import static nishit.LoginPage.*;

import javax.swing.*;

	public class Delete_Passenger {
		
String nos1 = Passenger_Details.number;

	    JFrame f = new JFrame("Delete Passenger");
		
	    JPanel panel = new JPanel();
	    JLabel label = new JLabel();
	    JLabel label1 = new JLabel();
	    Container c;
	    
	    JTextField txtno,coach_text,seat_text;
	    Delete_Passenger(){
	        setNavigationPanel();
	        deleteDetails();
	    }
	    
	    
	    public void deleteDetails()  {
	    	Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Images\\logo.png");
			f.setIconImage(icon);
			
			JLabel back1=new JLabel();
			    back1.setBounds(30,320,90,50);
				ImageIcon backbutton = new ImageIcon(new ImageIcon("D:\\Images\\back1.png").getImage().getScaledInstance(45,45, Image.SCALE_DEFAULT));
				back1.setIcon(backbutton);
				  f.add(back1);
		        back1.addMouseListener(new MouseAdapter() {
		            public void mouseClicked(MouseEvent e){              
		               f.dispose();
		                new Passenger_Details();
		            } 
		});
			
	        JLabel tno_label= new JLabel("Train Number");        
	        tno_label.setBounds(100,120,200,20);
	        tno_label.setForeground(Color.black);
		tno_label.setFont(new Font("Times Newroman",Font.BOLD,17));
	        f.add(tno_label);
	        
	        txtno = new JTextField("");
	        txtno.setBounds(300,120,120,30);
	        txtno.setForeground(Color.black);
		txtno.setFont(new Font("Times Newroman",Font.BOLD,12));
	        f.add(txtno);
	        txtno.setText(nos1);
	        txtno.setEnabled(false);
	        
	        JLabel coach1_label= new JLabel("Coach Number");        
	        coach1_label.setBounds(100,180,200,20);
	        coach1_label.setForeground(Color.black);
		coach1_label.setFont(new Font("Times Newroman",Font.BOLD,17));
	        f.add(coach1_label);
	        
	       coach_text = new JTextField("");
	        coach_text.setBounds(300,180,120,30);
	        coach_text.setForeground(Color.black);
		coach_text.setFont(new Font("Times Newroman",Font.BOLD,12));
	        f.add(coach_text);
	        
	        JLabel seat1_label= new JLabel("Seat Number");        
	        seat1_label.setBounds(100,240,200,20);
	        seat1_label.setForeground(Color.black);
		seat1_label.setFont(new Font("Times Newroman",Font.BOLD,17));
	        f.add(seat1_label);
	        
	       seat_text = new JTextField("");
	        seat_text.setBounds(300,240,120,30);
	        seat_text.setForeground(Color.black);
		seat_text.setFont(new Font("Times Newroman",Font.BOLD,12));
	        f.add(seat_text);
	      
	       
	        
	        
	        JButton delete_button =new JButton("DELETE");		
	        delete_button.setBounds(250,300,90,25);
		delete_button.setBackground(new Color(65,105,225));
		delete_button.setForeground(Color.WHITE);
		delete_button.setFont(new Font("Times Newroman", Font.BOLD,12));
		delete_button.setVisible(true);
	        f.add(delete_button);
	        
	        delete_button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                delete_buttonActionPerformed();
	                f.dispose();
	            }
	        });
	        delete_button.setVisible(true);
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
	        label1.setBounds(30,0,550,80);
	       
	        label1.setFont(new Font("Times Newroman", Font.BOLD,17));
	        label1.setForeground(Color.white);
	       
			
	        //final JLabel label = new JLabel();          
	       // label.setSize(500,100); 

	        //Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Images\\logo.png");
	        //f.setIconImage(icon);


	        c = f.getContentPane();

	        f.setLayout(null);
	        c.setBackground(new Color(135,206,250));
	        f.setSize(600,450);

	        f.setLocationRelativeTo(null);  
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	        f.setResizable(false);

	        f.add(panel);
	        f.add(label);		
	      
	        panel.add(label);
	        panel.add(label1);
	       
		}
	     
	     private void delete_buttonActionPerformed(){
	         try{
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
	            String query="DELETE FROM passenger_details WHERE train_no='"+nos1+"'  AND coach='"+coach_text.getText()+"' AND seat ='"+seat_text.getText()+"' AND pnr ='-1' AND user_id = '"+user_id+"' ";
	            Statement stmt = con.createStatement();
	            Statement stmt41=con.createStatement();
	            
	            
	            int nishit=0,nish=0,nishi=0;
	             nishit = stmt.executeUpdate(query);
	          nish=   stmt41.executeUpdate("DELETE FROM details WHERE train_no='"+nos1+"'  AND coach='"+coach_text.getText()+"' AND seat ='"+seat_text.getText()+"' AND pnr ='-1' AND user_id = '"+user_id+"' " );
	          Statement  stmt1 = con.createStatement();  
               nishi= stmt1.executeUpdate("UPDATE availability set process = 'not processed'  WHERE train_no='"+nos1+"'  AND coach='"+coach_text.getText()+"' AND seat ='"+seat_text.getText()+"' AND process='in process'  ");
	      if(nishit==1 && nishi==1 && nish==1) {
	    	  JOptionPane.showMessageDialog(null,"Deleted Successfully");
	      }
	      else {
	    	  JOptionPane.showMessageDialog(null,"Please check entered Coach Number & Seat Number");
	      }
	         }
	         
	         catch(Exception e)
	        {
	            JOptionPane.showMessageDialog(null,"Passenger name not found");
	        }
	     }
	 

	public static void main(String[] args) {

new Delete_Passenger();

	}

}
