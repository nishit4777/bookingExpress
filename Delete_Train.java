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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Delete_Train {
    JFrame f = new JFrame("delete train details");
	
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JLabel label1 = new JLabel();
    Container c;
    
     JTable table1;
    JTextField txtno,dateno;
    JScrollPane p1;
    DefaultTableModel t1;
    
    public Delete_Train(){
        
        deleteDetails();
    }
    public void deleteDetails(){
       
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
        
        
        JLabel tno_label= new JLabel("ENTER TRAIN NUMBER:");        
        tno_label.setBounds(200,200,200,20);
        tno_label.setForeground(Color.black);
	tno_label.setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(tno_label);
        
        txtno = new JTextField("");
        txtno.setBounds(400,200,100,20);
        txtno.setForeground(Color.black);
	txtno.setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(txtno);
        
        JLabel date_label= new JLabel("ENTER DATE:");        
        date_label.setBounds(200,255,200,20);
        date_label.setForeground(Color.black);
	date_label.setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(date_label);
        
        dateno = new JTextField("");
        dateno.setBounds(400,255,100,20);
        dateno.setForeground(Color.black);
	dateno.setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(dateno);
        
        table1 = new JTable();
        p1 = new JScrollPane(table1);
        p1.setBounds(0, 400, 750, 70);
        p1.setWheelScrollingEnabled(true);
        
        JButton delete_button =new JButton("DELETE");		
        delete_button.setBounds(300,300,90,25);
	delete_button.setBackground(new Color(65,105,225));
	delete_button.setForeground(Color.WHITE);
	delete_button.setFont(new Font("Times Newroman", Font.BOLD,12));
        c.add(delete_button);
        
        delete_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete_buttonActionPerformed();
               // f.dispose();//To change body of generated methods, choose Tools | Templates.
            }
        });
        
        JLabel traindetails_label= new JLabel("TRAIN DETAILS");        
        traindetails_label.setBounds(325,350,200,40);
        traindetails_label.setForeground(Color.black);
	traindetails_label.setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(traindetails_label);
        
        t1 = (DefaultTableModel) table1.getModel();
        t1.addColumn("Train Number");
        t1.addColumn("Train Name");
        t1.addColumn("Source");
        t1.addColumn("Destination");
        t1.addColumn("Date");
        t1.addColumn("Time");
        
        
        table1.getColumnModel().getColumn(0).setPreferredWidth(10);
        table1.getColumnModel().getColumn(1).setPreferredWidth(100);
        table1.getColumnModel().getColumn(2).setPreferredWidth(20);
        table1.getColumnModel().getColumn(3).setPreferredWidth(20);
        table1.getColumnModel().getColumn(4).setPreferredWidth(10);
        table1.getColumnModel().getColumn(5).setPreferredWidth(5);
        
        table1.setBackground(new Color(65,105,225));
         table1.setForeground(Color.white);
         
         table1.setModel(t1);
        c.add(p1);
        f.setVisible(true);
    }
    
     
     private void delete_buttonActionPerformed(){
         int f=0;
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
            String value=txtno.getText();
            String value1=dateno.getText();
            String query="Select * from train_details where train_no="+value;
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeQuery();
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                f=1;
                query="DELETE FROM train_details WHERE train_no='"+value+"'  AND date='"+value1+"'  ";
                pst = con.prepareStatement(query);
                pst.executeUpdate();
            }
            
            if(f==1){
                JOptionPane.showMessageDialog(null,"Successfully deleted!");
            }
            else{
                JOptionPane.showMessageDialog(null,"no trains found!");
            }
            
            String q = "SELECT * from train_details";
            pst = con.prepareStatement(q);
            
            
            rs = pst.executeQuery();
             while(rs.next()){
                 
                    String tno = rs.getString("train_no");
                    String tname = rs.getString("train_name");
                    String from = rs.getString("source");
                    String to = rs.getString("destination");
                    String date = rs.getString("date");
                    String time = rs.getString("time");
                    
                    t1.addRow(new Object[]{tno,tname,from,to,date,time});
              
                    
                }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"please enter train number to delete" );
        }
     }
    public static void main(String[] ss){
        new Delete_Train();
    }
}