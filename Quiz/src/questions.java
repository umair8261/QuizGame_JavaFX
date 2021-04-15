import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.* ;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.event.ActionListener;

class questions extends JPanel {
    
    JLabel Q ,
           hintLabel;
    
    JButton option1 ,
            option2,
            option3,
            option4 ;  
    
    String correct_answer,
            hint  ;

    static boolean next = false ;
    static int score = 0 ;
    
    static JLabel timer = new JLabel ("00 : 00 : 000") ;
    static counter count = new counter ();
    static boolean state=false;
    static boolean state_50=false;
    
    questions (quiz2 obj , JFrame window) 
    {       
    	 try {
				Thread.sleep(500);
				
			} catch (InterruptedException e1) {
			}
      Q = new JLabel (obj.question);
      hintLabel = new JLabel("Ask the People");
      option1 = new JButton (obj.op1) ;
      option1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      	}
      });
      option2 = new JButton (obj.op2) ;
      option3 = new JButton (obj.op3) ;
      option4 = new JButton (obj.op4) ;
      correct_answer = obj.correct_answer ;
      hint = obj.hint ; 

      JPanel pan = new JPanel () ;     
      pan.setLayout(null);
      pan.setBorder(BorderFactory.createLineBorder(Color.gray));
      pan.setBackground(Color.DARK_GRAY);
      window.setContentPane(pan);
      setLayout(null);
      setBackground(Color.getHSBColor(154, 254, 25));
      setBounds(98,183,600,200);
      setBorder(BorderFactory.createLineBorder(Color.black));
      pan.add(this);
      
      add(Q); add(option1); add(option2); add(option3); add(option4);
      
      Q.setBounds(110,8,400,50);
      Q.setBorder(new LineBorder(Color.blue, 2, true));
      Q.setHorizontalAlignment(JLabel.CENTER);
      option1.setBounds(90,70,200,40); 
      option1.setBackground(new Color(255,255,255)) ; 
      option2.setBounds(90,140,200,40); 
      option2.setBackground(new Color(255,255,255)) ;
      option3.setBounds(330,70,200,40);  
      option3.setBackground(new Color(255,255,255)) ;
      option4.setBounds(330,140,200,40); 
      option4.setBackground(new Color(255,255,255)) ;
      option1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED)); 
      option2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
      option3.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
      option4.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
      
      timer.setBounds(250,400,300,50);
      timer.setFont(new Font("Verdana", Font.BOLD, 40));
      timer.setHorizontalAlignment(JLabel.CENTER);
      timer.setBorder(BorderFactory.createLineBorder(Color.white));
      timer.setForeground(Color.white);
      pan.add(timer);
      
      JButton hintBTN = new JButton(new ImageIcon(getClass().getResource("people.png")));
      JButton half = new JButton(new ImageIcon(getClass().getResource("50 50.png")));
      
      pan.add(half); 
      pan.add(hintBTN);
      pan.add(hintLabel);
      hintBTN.setBounds(200,50,80,80);
      hintBTN.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
      half.setBounds(500,50,80,80);
      half.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
      hintLabel.setBounds(290,50,200,80);
      hintLabel.setHorizontalAlignment(JLabel.CENTER);
      hintLabel.setForeground(Color.white);
      hintLabel.setBorder(new LineBorder(Color.white, 2, true));  
       
            hintBTN.addActionListener((ActionEvent e) -> {
            	
            	if(state==false)
            	{
            		hintLabel.setText("70% people says "+hint);
            	}
            	state=true;
                
            });
            
            half.addActionListener((ActionEvent e) -> {
            	
            	if(state_50==false)
            	{
            		if (!option1.getText().equals(correct_answer)) {
                        option1.setEnabled(false);
                        option1.setBackground(Color.red);
                      }else if (!option2.getText().equals(correct_answer)) {
                        option2.setEnabled(false);
                        option2.setBackground(Color.red);
                      }
                      if (!option3.getText().equals(correct_answer)) {
                        option3.setEnabled(false);
                        option3.setBackground(Color.red);
                      }else if (!option4.getText().equals(correct_answer)) {
                        option4.setEnabled(false);
                        option4.setBackground(Color.red);
                      }
            	}
            	state_50=true;
            	
                    
            });
            
      window.setVisible(true);              
    }
    
    void getAnswer (int time) throws InterruptedException {
        
            option1.addActionListener((ActionEvent e) -> {
                if (option1.getText().equals(correct_answer))
                {
                	 option1.setEnabled(false);
                 	option1.setBackground(new Color(0,128,0)) ; 
                	score++ ;
                	
                }
                else
                {
                	option1.setEnabled(false);
                	option1.setBackground(new Color(255,0,0));
                }
                next=true;             	
            });

            option2.addActionListener((ActionEvent e) -> {
            	if (option2.getText().equals(correct_answer))
                {
                 	option2.setBackground(new Color(0,128,0)) ; 
                	score++ ;
                }
                else
                {
                	option2.setBackground(new Color(255,0,0));
                	
                }
                next = true ;
            });

            option3.addActionListener((ActionEvent e) -> {
            	if (option3.getText().equals(correct_answer))
                {
                 	option3.setBackground(new Color(0,128,0)) ; 
                	score++ ;
                }
                else
                {
                	option3.setBackground(new Color(255,0,0));
                	
                }
                next = true ;
            });

            option4.addActionListener((ActionEvent e) -> {
            	if (option4.getText().equals(correct_answer))
                {
                 	option4.setBackground(new Color(0,128,0)) ; 
                	score++ ;
                }
                else
                {
                	option4.setBackground(new Color(255,0,0));
                	
                }
                next = true ;
           });

        while (next == false ) {
        
            timer.setText(String.format("%02d", count.M)+" : "+String.format("%02d", count.S)+" : "+String.format("%03d", count.Ms)); 
               count.Ms++ ;
               Thread.sleep(1);
               if (count.Ms==999){
                   count.S++ ;
                   count.Ms=0 ;
               }
               if (count.S==59){
                   count.M++ ;
                   count.S=0;
               }
               
               if ((count.S + count.M*60) > time-3 ) {
                   
                   timer.setForeground(Color.red);
                   
                        if ((count.S + count.M*60)==time) 
                        { 
                            return ;
                        }
               }
        
        } 
        
        next = false ;
  
    }
    
    int getScore()
    {
    	return score ;
    }
    
    counter getTime () {return count ;}
    
    void Reset () {
        
            count.M=0 ; 
            count.Ms=0 ; 
            count.S=0;
            score = 0 ;
    
    }
    
}