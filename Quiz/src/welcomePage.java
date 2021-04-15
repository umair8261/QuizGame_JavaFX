import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.* ;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.event.ActionListener;

class welcomePage extends JPanel {
    
    JButton math,
            comp,
            gen,
            exit ;
    
    static boolean go  = false ;
    static int code=0;
    
    welcomePage(JFrame window) {
        
        setSize(800,500);
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        window.setContentPane(this);
        
        comp = new JButton ("Computer");
        comp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        comp.setBackground(Color.WHITE) ;
        comp.setBounds(300,201,200,50);
        add(comp);
        
        exit = new JButton ("Exit");
        exit.setBackground(new Color(255,255,255)) ;
        exit.setBounds(300,316,200,50);
        add(exit);
        
        math = new JButton("Math");
        math.setBackground(Color.WHITE) ;
        math.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        math.setBounds(63, 201, 200, 50);
        add(math);
        
        gen = new JButton("General Science");
        gen.setBackground(Color.WHITE);
        gen.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        gen.setBounds(534, 201, 200, 50);
        add(gen);
        
        JLabel lblNewLabel = new JLabel("Who wants to be a Zillionaire");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(63, 28, 671, 50);
        add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Select Category");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(175, 117, 452, 56);
        add(lblNewLabel_1);
        
        window.setVisible(true);
        
    }
    
    void choose (int time) {
        
        comp.addActionListener((ActionEvent e) -> {
        	code=1;
            go = true ;
          
            setVisible(false);
        });
        gen.addActionListener((ActionEvent e) -> {
        	code=2;
            go = true ;
            setVisible(false);
        });
        math.addActionListener((ActionEvent e) -> {
        	code=3;
            go = true ;
            setVisible(false);
        });
        
        
        exit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        
        while (!go) {
            try {
                Thread.sleep(0);
            } 
            catch (InterruptedException ex) {}
        }
        
        go = false ;
    
    }
}