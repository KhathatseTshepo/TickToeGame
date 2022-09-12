import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Tick  implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField  = new JLabel();
    JButton[] buttons  = new JButton[9];

    JButton resetButton;


    boolean Player1Turn;
    Tick(){
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(500,500);
        frame.getContentPane().setBackground(new Color(50 ,50 ,50));
        frame.setLayout(new BorderLayout());




        resetButton = new JButton();
        resetButton.setText("Restart");
        resetButton.setSize(100 , 50);
        resetButton.setLocation(0 ,200);
        resetButton.addActionListener(this);





        frame.setVisible(true);







        textField.setBackground(new Color( 25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free ", Font.BOLD,70));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tyson's TIC - TAC - TOE");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0 ,0,500,100 );


        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150,150,150));

        for(int i=0 ; i<9 ; i++){
            buttons[i] = new JButton();
            buttonPanel.add((buttons[i]));
            buttons[i].setFont(new Font("MV Boli" ,Font.BOLD ,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        titlePanel.add(textField);
        frame.add(resetButton);
        frame.add(titlePanel,BorderLayout.NORTH);
        frame.add(buttonPanel);
        FirstTurn();


    }

    private void FirstTurn() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(random.nextInt(2)==0){
            Player1Turn =true;
            textField.setText("X Turn");
        }
        else{
            Player1Turn =false;
            textField.setText("O Turn");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0 ; i<9 ; i++){
            if(e.getSource()==buttons[i]){
                if(Player1Turn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        Player1Turn =false;
                        textField.setText("O Turn");
                        Check();
                    }
                } else
                      if(buttons[i].getText()==""){
                         buttons[i].setForeground(new Color(0,0,255));
                         buttons[i].setText("O");
                         Player1Turn = true;
                         textField.setText("X Turn");
                          Check();


                          }
                }
            }
        }








    private void Check() {

        if(
                (buttons[0].getText()=="X") &&
                (buttons[1].getText()=="X") &&
                (buttons[2].getText()=="X")
        ){
            xWin (0,1,2);
        }



        if(
                        (buttons[3].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[5].getText()=="X")
        ){
            xWin (3,4,5);
        }


        if(
                        (buttons[6].getText()=="X") &&
                        (buttons[7].getText()=="X") &&
                        (buttons[8].getText()=="X")
        )




        if(
                        (buttons[0].getText()=="X") &&
                        (buttons[3].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ){
            xWin (0,3,6);
        }


        if(
                        (buttons[1].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[7].getText()=="X")
        ){
            xWin (4,7,7);
        }


        if(
                        (buttons[2].getText()=="X") &&
                        (buttons[5].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ){
            xWin (2,5,8);
        }


        if(
                        (buttons[0].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ){
            xWin (0,4,8);
        }


        if(
                        (buttons[2].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ){
            xWin (2,4,6);
        }



        if(
                (buttons[0].getText()=="O") &&
                        (buttons[1].getText()=="O") &&
                        (buttons[2].getText()=="O")
        ){
            yWin (0,1,2);
        }



        if(
                (buttons[3].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[5].getText()=="O")
        ){
            yWin (3,4,5);
        }


        if(
                (buttons[6].getText()=="O") &&
                        (buttons[7].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ){
            yWin (6,7,8);
        }



        if(
                (buttons[0].getText()=="O") &&
                        (buttons[3].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ){
            yWin (0,3,6);
        }


        if(
                (buttons[1].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[7].getText()=="O")
        ){
            yWin (4,7,7);
        }


        if(
                (buttons[2].getText()=="O") &&
                        (buttons[5].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ){
            yWin (2,5,8);
        }


        if(
                (buttons[0].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ){
            yWin (0,4,8);
        }


        if(
                (buttons[2].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ){
            yWin (2,4,6);
        }
           
    }

    private void yWin(int a, int b, int c) {
        buttons[a].setBackground(Color.RED);
        buttons[b].setBackground(Color.RED);
        buttons[c].setBackground(Color.RED);

        for (int i=0 ; i<9 ; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("Y Wins");
        frame.setVisible(false);

    }

    private void xWin(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i=0 ; i<9 ; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("X Wins");
        frame.setVisible(false);


    }




}



