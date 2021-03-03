package nishit;
import java.awt.*;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;

import javax.swing.*;



public class Book_Tickets {	
	
	JFrame f;
	
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel label1 = new JLabel();
	
	public Book_Tickets() { 	 
	    
		setNavigationPanel();
		
		   
		 
		
		JLabel l=new JLabel("Source");  
	    l.setBounds(100,140, 200,70);
	    l.setForeground(Color.black);
	    l.setFont(new Font("Times Newroman",Font.BOLD,18)); 
	   
		
		String source[]={"Coimbatore","Chennai","Madurai"};
		JComboBox source1=new JComboBox(source);
		source1.setBounds(170,160, 150,30);
	 //   source1.setBackground(new Color(65,105,225));
	    
	    
	    JLabel l1=new JLabel("Destination");  
	    l1.setBounds(400,140, 200,70);
	    l1.setForeground(Color.black);
	    l1.setFont(new Font("Times Newroman",Font.BOLD,18));
	    
	    
		String destination[]={"Coimbatore","Chennai","Madurai"};
		JComboBox destination1=new JComboBox(destination);
		destination1.setBounds(510,160, 150,30);
	//    destination1.setBackground(new Color(65,105,225));
	   
	    JLabel l2=new JLabel("Date");  
	    l2.setBounds(100,240, 200,70);
	   l2.setForeground(Color.black);
	    l2.setFont(new Font("Times Newroman",Font.BOLD,18));
	   
	    
		JTextField date=new JTextField();
		date.setBounds(170,260, 150,30);
	//   date.setBackground(new Color(65,105,225));

	    
	    JLabel l3=new JLabel("Quota");  
	    l3.setBounds(400,240, 200,70);
	    l3.setForeground(Color.black);
	    l3.setFont(new Font("Times Newroman",Font.BOLD,18));
	    
	    String quota[]={"Genral","Tatkal","Ladies"};
		JComboBox quota1=new JComboBox(quota);
		quota1.setBounds(510,260, 150,30);
	  //  quota1.setBackground(new Color(65,105,225));
	    
		f = new JFrame();
		
		final JLabel label = new JLabel();          
        label.setSize(500,100);  
		
      
        
        
        JButton b=new JButton("Search Train");		
		b.setBounds(300,410,150,50);
		b.setBackground(new Color(65,105,225));
		b.setForeground(Color.WHITE);
		b.setFont(new Font("Times Newroman", Font.BOLD,18));
		
		JFrame f= new JFrame("Book tickets"); 
		
		  
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
		f.add(source1);
		f.add(destination1);
		f.add(quota1);
		f.add(date);
		
		f.add(l);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(b);		
	
		
		 
		
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
		 
		new Book_Tickets();
		
		
		
		
	}
	
	
	}