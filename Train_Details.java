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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Train_Details {
    JFrame f = new JFrame("train details");
	
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JLabel label1 = new JLabel();
    Container c;

    JTable table1;
    JComboBox cmb_source;
    JComboBox cmb_dest;
    JTextField get_date;
    JScrollPane p1;
    DefaultTableModel t1;
    
    static String train_no;
    public static String date;
    public static String namee;
    
 public Train_Details(){
    setNavigationPanel();	    
      showTrain();
    }
    
    public void showTrain() {
              
		
        final JLabel label = new JLabel();          
        label.setSize(500,100); 

    	Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Images\\logo.png");
		f.setIconImage(icon);

	      JLabel back=new JLabel();
		    back.setBounds(30,490,90,50);
			ImageIcon backbutton = new ImageIcon(new ImageIcon("D:\\Images\\back1.png").getImage().getScaledInstance(45,45, Image.SCALE_DEFAULT));
			back.setIcon(backbutton);
			f.add(back);
			
	        back.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent e){              
	               f.dispose();
	                new Main_Page();
	            } 
	});		

        c = f.getContentPane();

        f.setLayout(null);
        c.setBackground(new Color(135,206,250));
        f.setSize(750,600);

        f.setLocationRelativeTo(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        f.setResizable(false);

        f.add(panel);
        f.add(label);		
        panel.add(label);
        panel.add(label1);
        
        JLabel tsource = new JLabel("FROM:");
        tsource.setBounds(50,125,80,20);
        tsource.setForeground(Color.black);
	tsource.setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(tsource);
        
        String city[]={"CHENNAI","COIMBATORE","MADHURAI","TRICHY"};
        cmb_source = new JComboBox(city);
        cmb_source.setBounds(135,125, 90,20);
        cmb_source.setForeground(Color.black);
	cmb_source.setFont(new Font("Times Newroman",Font.BOLD,10));
        c.add(cmb_source);
        
        JLabel tdest = new JLabel("TO:");
        tdest.setBounds(300,125,80,20);
        tdest.setForeground(Color.black);
	tdest.setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(tdest);
        
        cmb_dest = new JComboBox(city);
        cmb_dest.setBounds(340,125,90,20);
        cmb_dest.setForeground(Color.black);
	cmb_dest.setFont(new Font("Times Newroman",Font.BOLD,10));
        c.add(cmb_dest);
        
        
        JLabel tdate = new JLabel("DATE:");
        tdate.setBounds(525,125,80,20);
        tdate.setForeground(Color.black);
	tdate.setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(tdate);
        
        get_date = new JTextField("");
        get_date.setBounds(600,125,80,20);
        get_date.setForeground(Color.black);
	get_date.setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(get_date);

        JLabel traindetails_label= new JLabel("TRAIN DETAILS");        
        traindetails_label.setBounds(325,250,200,40);
        traindetails_label.setForeground(Color.black);
	traindetails_label.setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(traindetails_label);
        
        table1 = new JTable();
        p1 = new JScrollPane(table1);
        p1.setBounds(0, 300, 750, 130);
        p1.setWheelScrollingEnabled(true);
        
        JButton search_button =new JButton("SEARCH");		
        search_button.setBounds(300,180,150,25);
	search_button.setBackground(new Color(65,105,225));
	search_button.setForeground(Color.WHITE);
	search_button.setFont(new Font("Times Newroman", Font.BOLD,12));
        c.add(search_button);
        
        search_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	  String date_regex = get_date.getText();
                  String regex = "^[0-3][0-9]-[0-3][0-9]-(?:[0-9][0-9])?[0-9][0-9]$";
                  Pattern pattern = Pattern.compile(regex);
                  Matcher matcher = pattern.matcher(date_regex );
                  
                if(get_date.getText().isEmpty()){
                     JOptionPane.showMessageDialog(null,"enter date");
                } 
                else if(cmb_source.getSelectedItem().toString()==cmb_dest.getSelectedItem().toString()){
                     JOptionPane.showMessageDialog(null,"source and destination can't be same");
                }
                   
                else if(matcher.matches()) {
                	 search_buttonActionPerformed();  
                }
                else {
                	  JOptionPane.showMessageDialog(null,"Date format should be : dd-mm-yyyy");
                }
                
            }
        });
        
        table1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                train_no = table1.getValueAt(table1.getSelectedRow(),0).toString();
                date = table1.getValueAt(table1.getSelectedRow(),4).toString();
               namee=table1.getValueAt(table1.getSelectedRow(),1).toString();
                f.dispose();
                new Passenger_Details();
            } 
});
        
        t1 = (DefaultTableModel) table1.getModel();
        t1.addColumn("Train_Number");
        t1.addColumn("Train_Name");
        t1.addColumn("Source");
        t1.addColumn("Destination");
        t1.addColumn("Date");
        t1.addColumn("Time");
        
         table1.setBackground(new Color(65,105,225));
         table1.setForeground(Color.white);
        
         table1.setModel(t1);
        c.add(p1);
        f.setVisible(true);
        
       
    }
    
    
     public void search_buttonActionPerformed(){
        
       
            String strQry = "";
            try {
                int flag =0;
            	Class.forName("com.mysql.jdbc.Driver");
            	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
                String q = "SELECT * from train_details WHERE source = '"+cmb_source.getSelectedItem().toString()+"' AND destination ='"+cmb_dest.getSelectedItem().toString()+"' AND date ='"+get_date.getText()+"'  ";
                Statement  pst = con.createStatement();
                
            
                ResultSet rs = pst.executeQuery(q);
                while(rs.next()){
                    flag=1;
                    String tno = rs.getString("train_no");
                    String tname = rs.getString("train_name");
                    String from = rs.getString("source");
                    String to = rs.getString("destination");
                    String date = rs.getString("date");
                    String time = rs.getString("time");
                    
                    t1.addRow(new Object[]{tno,tname,from,to,date,time});
                    
                }
                if(flag==0){
                    JOptionPane.showMessageDialog(null,"No train found!");
                }
            }catch(Exception f) {
                
                JOptionPane.showMessageDialog(null,"Error!please check the details");
            }
 
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
       
   
  
    public static void main(String ss[]){
       new Train_Details();
        
        
    }
}
