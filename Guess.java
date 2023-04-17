import java.util.*;
import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

 
public class Guess{
    private static JTextField input;
    private static int Guess;
    private static int counter=0;
    private static int currentDistance =1000;
    private static int lastDistance=0;
    private static JPanel mainPanel;
    private static JFrame mainFrame;
    private static JLabel gameMessageLabel;
    private static int randInt;
    private static JButton NewGame;
public static void main(String[] args){


  input = new JTextField("", 5);
  mainPanel = new JPanel(new GridLayout(0,1));//setting up my panels and frames
  gameMessageLabel = new JLabel("I have a number between 1 and 1000. Can you guess my number?");
  mainFrame = new JFrame("Guess the number!");
  NewGame = new JButton("Play again");//end of initalization 
  input.setSize(new Dimension(5,10));
  input.setEditable(true);//allows for change  
  
  mainPanel.add(gameMessageLabel);
  mainPanel.add(input);
  mainPanel.add(NewGame);
  mainFrame.add(mainPanel);
  mainFrame.setSize(600,200);
  mainFrame.setResizable(false);
  mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  mainFrame.setVisible(true);
  


  input.addActionListener(new Handler());//NewGame.addActionListener(new newGameHandler());

  
}//end of main method
public void randomNum(){
  Random rand = new Random();//need to get this out of main
  randInt = rand.nextInt(1000)+1;//random int between 1 and 1000
}
private static class Handler implements ActionListener{
    public void actionPerformed(ActionEvent event){
    if(counter == 0){
        Random rand = new Random();//need to get this out of main
        randInt = rand.nextInt(1000)+1;//random number is only generated once per game
        if(Guess > randInt){
           gameMessageLabel.setText("your guess was too high");
           Guess = Integer.parseInt(input.getText());
        }
        if(Guess < randInt){
           System.out.println(randInt);
           gameMessageLabel.setText("Your guess was too low");
           Guess = Integer.parseInt(input.getText());
        }
        if(Guess == randInt){
           gameMessageLabel.setText("your guess was correct");
           input.setEditable(false);
        }
        lastDistance = currentDistance;//lastDistance is set to current and current is changed after next guess
        
        counter++;
        input.setText("");
  }//end of the first counter instance
  else{
        currentDistance = Math.abs(Guess-randInt);//current distance is set to guess-randomInt 
  if(Guess > randInt)
        gameMessageLabel.setText("your guess was too high");
  if(Guess < randInt)
  {
        System.out.println(randInt);
        gameMessageLabel.setText("your guess was too low");
  }
  if(Guess == randInt){
        input.setEditable(false);
        gameMessageLabel.setText("your guess was correct");
        NewGame.addActionListener(new newGameHandler());
    }
  if(currentDistance <= lastDistance){
        mainPanel.setBackground(Color.RED);
        Guess = Integer.parseInt(input.getText());
  }     
  if(currentDistance >= lastDistance){
        mainPanel.setBackground(Color.BLUE);
        Guess = Integer.parseInt(input.getText());
    }
        
        lastDistance = currentDistance;//lastDistance is set to current and current is changed after next guess
        
        input.setText("");//sets textbox back to empty
  } 
        
        
    }
}
private static class newGameHandler implements ActionListener{
     public void actionPerformed(ActionEvent event){
         
         mainPanel.setBackground(Color.GRAY);
         input.setEditable(true);
         input.setText("");
         gameMessageLabel.setText("I have a number between 1 and 1000. Can you guess my number?");

         counter=0;
         currentDistance = 1000;
         lastDistance = 0;

     }
}
}//end of class Guess:wq
 
