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
import static nishit.SignupPage.*;
import static nishit.LoginPage.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewTicketHistory extends JFrame{	
	
	
	Container c = getContentPane();
	
	JPanel panel = new JPanel();
	
	JLabel label_image = new JLabel();
	JLabel label_heading = new JLabel();
	
	JButton viewbutton=new JButton();
	JLabel back=new JLabel();
	
	
	Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Images\\logo.png");
	
    ImageIcon iconLo = new ImageIcon(new ImageIcon("D:\\Images\\logo.png").getImage().getScaledInstance(100,90, Image.SCALE_DEFAULT));
    

	
	public ViewTicketHistory() {	 	
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
		c.add(viewbutton);
		c.add(back);
	}
	
	public void addActionEvent() {
		viewbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				viewTickets();
			}
		});
		
		   back.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent e){              
	               dispose();
	                new Main_Page();
	            } 
	});
	}
	
	public void viewTickets() {
		DefaultTableModel t1=new DefaultTableModel();
		
		JTable table = new JTable(t1);
	    
		JScrollPane scroll = new JScrollPane(table);
        t1.addColumn("Name");
        t1.addColumn("Age");
        t1.addColumn("Gender");
        t1.addColumn("Train name");
        t1.addColumn("Train number");
        t1.addColumn("coach");
        t1.addColumn("seat");
        try {	
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
        	Statement stmt=con.createStatement();
        	String query="SELECT name,age,gender,train_name,train_no,coach,seat from details where user_id='"+user_id+"'  ";
        	ResultSet rs=stmt.executeQuery(query);
        	while(rs.next()) {
        		String name=rs.getString("name");
        		int age=rs.getInt("age");
        		String gender=rs.getString("gender");
				String train=rs.getString("train_name");
				String train_num=rs.getString("train_no");
				String coach=rs.getString("coach");
				String seat=rs.getString("seat");
				t1.addRow(new Object[] {name,age,gender,train,train_num,coach,seat});
			}
        	table.setModel(t1);
        	table.getColumnModel().getColumn(0).setPreferredWidth(100);
        	table.getColumnModel().getColumn(1).setPreferredWidth(10);
        	table.getColumnModel().getColumn(2).setPreferredWidth(50);
        	table.getColumnModel().getColumn(3).setPreferredWidth(100);
        	table.getColumnModel().getColumn(4).setPreferredWidth(70);
        	table.getColumnModel().getColumn(5).setPreferredWidth(10);
        	table.getColumnModel().getColumn(6).setPreferredWidth(10);
        	con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
        
        c.add(scroll);
        scroll.setBounds(43, 380, 650, 100);
	    scroll.setWheelScrollingEnabled(true);
	    
	    
	    table.setBackground(new Color(65,105,225));
	    table.setForeground(Color.white);
	    viewbutton.setEnabled(false);
	}  
	
	public void setLocationAndSize() {
	    
	    back.setBounds(30,490,90,50);
		ImageIcon backbutton = new ImageIcon(new ImageIcon("D:\\Images\\back1.png").getImage().getScaledInstance(45,45, Image.SCALE_DEFAULT));
		back.setIcon(backbutton);

     
		label_heading.setText("Booking History");
		label_heading.setBounds(160, 10, 400, 100);
		label_heading.setFont(new Font("Times Newroman", Font.BOLD,20));
	    label_heading.setForeground(Color.white);
		label_heading.setHorizontalAlignment(JLabel.CENTER);
	       
	    label_image.setIcon(iconLo);
	    label_image.setBounds(308, 180,130,100);
	 
		viewbutton.setText("View Tickets");
		viewbutton.setBackground(new Color(65,105,225));
		viewbutton.setForeground(Color.white);
		viewbutton.setBounds(290, 310, 150, 30);
		viewbutton.setFont(new Font("Times Newroman", Font.BOLD,15));
	    
	   
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
		new ViewTicketHistory();	
	}	
}