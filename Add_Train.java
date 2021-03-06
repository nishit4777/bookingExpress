package nishit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Add_Train {
            
    JFrame f = new JFrame("new train details");
	
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JLabel label1 = new JLabel();
    Container c;
    
    JTextField get_tno;
    JTextField get_tname;
    JComboBox cmb_source;
    JComboBox cmb_dest;
    JTextField get_date;
    JTextField get_time;
    
    JTable table1;
    JScrollPane p1;
    DefaultTableModel t1;
    
    
    public Add_Train(){
        
        trainDetails();
    }
    
    
    public void trainDetails(){
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
       
		
        final JLabel label = new JLabel();          
        label.setSize(500,100); 

        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Images\\logo.png");
        f.setIconImage(icon);
        
        JLabel back=new JLabel();
	    back.setBounds(30,490,90,50);
		ImageIcon backbutton = new ImageIcon(new ImageIcon("D:\\Images\\back1.png").getImage().getScaledInstance(45,45, Image.SCALE_DEFAULT));
		back.setIcon(backbutton);
		
        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){              
               f.dispose();
                new Admin_Options();
            } 
});


        c = f.getContentPane();

        
        c.setBackground(new Color(135,206,250));
        f.setSize(750,600);
        
        f.setLayout(null);
        f.setLocationRelativeTo(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        f.setResizable(false);

        f.add(panel);
        f.add(label);		
        f.add(back);
        panel.add(label);
        panel.add(label1);
        JLabel tno = new JLabel("TRAIN NO:");
        tno.setBounds(50,125,80,20);
        tno.setForeground(Color.black);
	tno.setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(tno);
        
        get_tno = new JTextField("");
        get_tno.setBounds(135,125, 90,20);
        get_tno.setForeground(Color.black);
	get_tno.setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(get_tno);
        
        JLabel tname = new JLabel("TRAIN NAME:");
        tname.setBounds(280,125,80,20);
        tname.setForeground(Color.black);
	tname.setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(tname);
        
        get_tname = new JTextField("");
        get_tname.setBounds(360,125,90,20);
        get_tname.setForeground(Color.black);
	get_tname.setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(get_tname);
        
        JLabel tsource = new JLabel("FROM:");
        tsource.setBounds(525,125,80,20);
        tsource.setForeground(Color.black);
	tsource.setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(tsource);
        
        String city[]={"CHENNAI","COIMBATORE","MADURAI","TRICHY"};
        cmb_source = new JComboBox(city);
        cmb_source.setBounds(600,125,80,20);
        cmb_source.setForeground(Color.black);
	cmb_source.setFont(new Font("Times Newroman",Font.BOLD,10));
        c.add(cmb_source);
        
        JLabel tdest = new JLabel("TO:");
        tdest.setBounds(50,160,80,20);
        tdest.setForeground(Color.black);
	tdest.setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(tdest);
        
        cmb_dest = new JComboBox(city);
        cmb_dest.setBounds(135,160, 90,20);
        cmb_dest.setForeground(Color.black);
	cmb_dest.setFont(new Font("Times Newroman",Font.BOLD,10));
        c.add(cmb_dest);
        
        
        JLabel tdate = new JLabel("DATE:");
        tdate.setBounds(300,160,80,20);
        tdate.setForeground(Color.black);
	tdate.setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(tdate);
        
        get_date = new JTextField("");
        get_date.setBounds(360,160,90,20);
        get_date.setForeground(Color.black);
	get_date.setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(get_date);
        
        
        JLabel ttime = new JLabel("TIME:");
        ttime.setBounds(525,160,80,20);
        ttime.setForeground(Color.black);
	ttime.setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(ttime);
        
        get_time = new JTextField("");
        get_time .setBounds(600,160,80,20);
        get_time .setForeground(Color.black);
	get_time .setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(get_time);
               
        JButton add_button =new JButton("SUBMIT");		
        add_button.setBounds(350,200,80,20);
	add_button.setBackground(new Color(65,105,225));
	add_button.setForeground(Color.WHITE);
	add_button.setFont(new Font("Times Newroman", Font.BOLD,12));
        c.add(add_button);
        
        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            String date_regex = get_date.getText();
                String regex = "^[0-3][0-9]-[0-3][0-9]-(?:[0-9][0-9])?[0-9][0-9]$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(date_regex );    
            if(get_tno.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"please enter train number");
            }else if(get_tname.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"please enter train name");
            }else if(get_date.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"please enter date");
            }else if(get_time.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"please enter time");
            }else if(cmb_source.getSelectedItem().toString()==cmb_dest.getSelectedItem().toString()){
                     JOptionPane.showMessageDialog(null,"source and destination can't be same");
                }else if(matcher.matches()){
                 add_buttonActionPerformed();
                
            }else{
                    JOptionPane.showMessageDialog(null,"date should be in format dd-mm-yyyy");
                }
               
            }
        });
        
        
        JLabel traindetails_label= new JLabel("TRAIN DETAILS");        
        traindetails_label.setBounds(325,250,200,40);
        traindetails_label.setForeground(Color.black);
	traindetails_label.setFont(new Font("Times Newroman",Font.BOLD,12));
        c.add(traindetails_label);
        
        table1 = new JTable();
        p1 = new JScrollPane(table1);
        p1.setBounds(0, 300, 750, 130);
        p1.setWheelScrollingEnabled(true);
        
        t1 = (DefaultTableModel) table1.getModel();
        t1.addColumn("train_no");
        t1.addColumn("train_name");
        t1.addColumn("source");
        t1.addColumn("destination");
        t1.addColumn("date");
        t1.addColumn("time");
        
        
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
    
   
    
    private void add_buttonActionPerformed() {                                         
        try{
             
            String query ="INSERT INTO `train_details`(`train_no`, `train_name`, `source`, `destination`, `date`, `time`) VALUES (?,?,?,?,?,?)";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1,get_tno.getText());
            pst.setString(2,get_tname.getText());
            pst.setString(3,cmb_source.getSelectedItem().toString());
            pst.setString(4,cmb_dest.getSelectedItem().toString());
            pst.setString(5,get_date.getText());
            pst.setString(6,get_time.getText());
            
            
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"details updated successfully");
            
           String q = "SELECT * from train_details";
            pst = con.prepareStatement(q);
            
            
            ResultSet rs = pst.executeQuery();
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
            JOptionPane.showMessageDialog(null,"Please Check Train Number & Date");
        }
    }
    public static void main(String ss[]){
        new Add_Train();
    }
    
}