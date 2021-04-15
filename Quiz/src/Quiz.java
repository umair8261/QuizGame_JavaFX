import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.*;
import java.awt.* ;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

public class Quiz {
    public static void main(String[] args) throws InterruptedException {
        
      JFrame window = new JFrame ("Quiz Game") ;  
      window.setSize(800,500);
      window.setLocationRelativeTo(null);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setResizable(false);

    while (true) {  
      
      int nbr =0 , score=0 , m=0 , s=0 ;
      int time = 60 ;
        
      welcomePage welcome = new welcomePage (window);
      welcome.choose(time);
        
        quiz2 [] math = {
            new quiz2("2+2","4","2","22","5","4","4"),
            new quiz2("9*8","64","76","74","72","72","72"),
            new quiz2("a^2 + b^2 -2ab where a=3, b=2","3","5","1","2","1","1"),
            new quiz2("Father of Math?","Newton","Archimedes","al-Khwarizmi","George Washington","Archimedes","Archimedes")
        };
        Collections.shuffle(Arrays.asList(math));
        
        quiz2 [] comp = {
                new quiz2("RAM stands for","Random Access Memory","Read Only Memory","Hard Disk","Random Hard Drive","Random Access Memory","Random Access Memory"),
                new quiz2("Latest Computer Gen now a days?","5th","9th","10th","11th","11th","11th"),
                new quiz2("SSD Stands For","Memory Card","USB","Solid-State Drive","Hard-Disk Drive","Solid-State Drive","Solid-State Drive"),
                new quiz2("Latest Nvidia Graphics Card Series?","RTX 20 Series","RTX 30 Series","RTX 10 Series","RTX 50 Series","RTX 30 Series","RTX 30 Series")
            };
        Collections.shuffle(Arrays.asList(comp));
        
        quiz2 [] gen = {
                new quiz2("Which country has maximum languages ?","Papua New Giunea","South Africa","United States","France","Papua New Giunea","Papua New Giunea"),
                new quiz2("Kyoto City is in which Country?","China","South Korea","None of these","Japan","Japan","Japan"),
                new quiz2("Which land of country is below the sea level?","Iceland","Belgium","Netherlands","Germany","Netherlands","Netherlands"),
                new quiz2("The country also known as ” country of COPPER” is:","Zimbabwe","Zambia","China","None of these","Zambia","Zambia")
            };
        Collections.shuffle(Arrays.asList(gen));
        
        while (nbr != math.length && s<time ) 
        {
        	if(welcomePage.code==1)
        	{
        		questions quiz = new questions(comp[nbr], window);
                quiz.getAnswer(time); 
                m = quiz.getTime().M ;
                s = quiz.getTime().S ;
                score = quiz.getScore();
                if (nbr == comp.length-1 || (s==time)) quiz.Reset();
                nbr++ ;
        	}
        	else if(welcomePage.code==2)
        	{
        		questions quiz = new questions(gen[nbr], window);
                quiz.getAnswer(time); 
                m = quiz.getTime().M ;
                s = quiz.getTime().S ;
                score = quiz.getScore();
                if (nbr == gen.length-1 || (s==time)) quiz.Reset();
                nbr++ ;
        	}
        	else if(welcomePage.code==3)
        	{
        		questions quiz = new questions(math[nbr], window);
                quiz.getAnswer(time); 
                m = quiz.getTime().M ;
                s = quiz.getTime().S ;
                score = quiz.getScore();
                if (nbr == math.length-1 || (s==time)) quiz.Reset();
                nbr++ ;
        	}
        	else
        	{
        		questions quiz = new questions(gen[nbr], window);
                quiz.getAnswer(time); 
                m = quiz.getTime().M ;
                s = quiz.getTime().S ;
                score = quiz.getScore();
                if (nbr == gen.length-1 || (s==time)) quiz.Reset();
                nbr++ ;
        	}
        	
        	
        	
           
        }
        
        int nbrQ = gen.length ;  
        scorePane scorePane = new scorePane (window,score,nbrQ) ;
        scorePane.choose();
        questions.state=false;
        questions.state_50=false;
        
     
     }    
      
    }    
}