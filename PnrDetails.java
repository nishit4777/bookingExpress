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
import javax.swing.table.DefaultTableModel;

public class PnrDetails extends JFrame{	
	
	Container c = getContentPane();
	
	JPanel panel = new JPanel();
	
	JLabel label_image= new JLabel();
	JLabel label_headingviewtickets=new JLabel();
	JLabel label_pnrheading=new JLabel();
	JLabel back1=new JLabel();
	
	JTextField textfield_pnr=new JTextField();
	

	
	String pnr;
	public static int pnrno;
	
	JButton button_search=new JButton();
	
	Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Images\\logo.png");
	
	ImageIcon iconLo = new ImageIcon(new ImageIcon("D:\\Images\\logo.png").getImage().getScaledInstance(100,90, Image.SCALE_DEFAULT));
	
	PnrDetails() { 	 
		setNavigationPanel();
		setLayoutManager();
		setLocationAndSize();
		addComponentsToTheContainer();
		addActionEvent();
		frame();
	}
	
	
	public void setLocationAndSize() {
	    back1.setBounds(30,490,90,50);
			ImageIcon backbutton = new ImageIcon(new ImageIcon("D:\\Images\\back1.png").getImage().getScaledInstance(45,45, Image.SCALE_DEFAULT));
			back1.setIcon(backbutton);
			
		label_headingviewtickets.setBounds(160, 20, 400, 100);
		label_headingviewtickets.setText("PNR STATUS");
		label_headingviewtickets.setFont(new Font("Times Newroman", Font.BOLD,20));
	    label_headingviewtickets.setForeground(Color.white);
		label_headingviewtickets.setHorizontalAlignment(JLabel.CENTER);
		
		label_pnrheading.setBounds(250, 240, 180, 30);
		label_pnrheading.setText("PNR Number ");
		label_pnrheading.setFont(new Font("Times Newroman", Font.BOLD, 18));
		label_pnrheading.setForeground(Color.black);
		
		label_image.setIcon(iconLo);
		label_image.setBounds(308, 105,100,100);
		
		textfield_pnr.setBounds(400, 240, 70, 30);
		
		
		button_search.setText("Search");
		button_search.setBounds(320, 310, 100, 30);
		button_search.setBackground(new Color(65,105,225));
		button_search.setForeground(Color.white);
		button_search.setFont(new Font("Times Newroman", Font.BOLD,15));
		
		
		
		
		
		
		
	}

	public void addComponentsToTheContainer(){
		c.add(panel);
		c.add(label_image);
		c.setBackground(new Color(135,206,250));
		c.add(label_pnrheading);
		c.add(textfield_pnr);
		c.add(button_search);
		  c.add(back1);
		
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
		button_search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				checkPNR();
				
				
			}
		});
		  back1.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent e){              
	             dispose();
	                new Main_Page();
	            } 
	});
	}
	public void checkPNR() {
		try{
			int flag=0;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
			Statement stmt=con.createStatement();
			pnr=textfield_pnr.getText();
			if(Pattern.matches("\\d+",pnr)==false){
				JOptionPane.showMessageDialog(new JFrame(),"Check the PNR number ", " INVALID TYPE ",JOptionPane.ERROR_MESSAGE);
				flag=1;
			}
			if(flag==0) {
				pnrno=Integer.parseInt(pnr);
				String query="SELECT * from passenger_details WHERE pnr='"+pnrno+"'  ";
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next()) {
					if(rs.getInt("pnr")==pnrno) {
						flag=1;
						break;
					}
				}
				if(flag==1) {
					dispose();
					new ViewTickets();
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(),"Check the PNR number ", " WRONG PNR ",JOptionPane.ERROR_MESSAGE);
				}
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
		new PnrDetails();
		
	}	
}