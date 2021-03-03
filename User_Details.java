package nishit;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class User_Details {
    JFrame f = new JFrame("user details");
	
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JLabel label1 = new JLabel();
    Container c;
    User_Details(){
        showUserDetails();
    }
     public void showUserDetails() {
        panel.setBackground(new Color(65,105,225));
        panel.setBounds(0, 0, 750, 80); 
        ImageIcon iconLo = new ImageIcon(new ImageIcon("D:\\Images\\logo.png").getImage().getScaledInstance(75,90, Image.SCALE_DEFAULT));
        label.setIcon(iconLo);
        label.setBounds(0, 0,75, 75);
        panel.setLayout(null);
       
        JLabel label1= new JLabel(" RAILWAY RESERVATION SYSTEM");
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setBounds(90,0,550,80);
       
        label1.setFont(new Font("Times Newroman", Font.BOLD,20));
        label1.setForeground(Color.white);
       
        JLabel l1=new JLabel();
	    l1.setBounds(330,100,500,70);
		ImageIcon iconLogo = new ImageIcon(new ImageIcon("D:\\Images\\logo.png").getImage().getScaledInstance(90,75, Image.SCALE_DEFAULT));
		l1.setIcon(iconLogo);
       
		
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
                new Admin_Options();
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
        f.add(l1);
        panel.add(label);
        panel.add(label1);
        
        JLabel userdetails_label= new JLabel("USER DETAILS");        
        userdetails_label.setBounds(325,250,200,40);
        userdetails_label.setForeground(Color.black);
	userdetails_label.setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(userdetails_label);
        
        JTable table1 = new JTable();
        JScrollPane p1 = new JScrollPane(table1);
        p1.setBounds(0, 300, 750, 170);
        p1.setWheelScrollingEnabled(true);

        DefaultTableModel t1 = (DefaultTableModel) table1.getModel();
        t1.addColumn("FIRST NAME");
        t1.addColumn("LAST NAME");
        t1.addColumn("AGE");
        t1.addColumn("GENDER");
        t1.addColumn("PHONE NO.");
        t1.addColumn("USER NAME");
        
        Connection con = null;
            Statement smt = null;
            ResultSet rs = null;
            String strQry = "";
            try {
            	Class.forName("com.mysql.jdbc.Driver");
            	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
                smt = con.createStatement();
               
                rs= smt.executeQuery("select * from user_details;");
                while(rs.next()){
                    String fname = rs.getString("firstname");
                    String lname = rs.getString("lastname");
                    int age = rs.getInt("age");
                    String gender = rs.getString("gender");
                    
                   
                    String ph_no = rs.getString("phonenumber");
                    String uname = rs.getString("username");
                    t1.addRow(new Object[]{fname,lname,age,gender,ph_no,uname});
                }
            }catch(Exception f) {
                System.out.println(f);
            }
        // Fetch all product from DB        
         table1.setBackground(new Color(65,105,225));
         table1.setForeground(Color.white);
         
        table1.setModel(t1);
        c.add(p1);
        f.setVisible(true);
        
        //
    }
     public static void main(String ss[]){
         new User_Details();
     }
}