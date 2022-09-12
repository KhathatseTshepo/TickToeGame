import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reset extends JFrame implements ActionListener {
     Tick tick;

    JButton resetButton;

    Reset(){

       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(400 ,300);
       this.setLayout(null);

        resetButton = new JButton();
        resetButton.setText("Restart");
        resetButton.setSize(100 , 50);
        resetButton.setLocation(0 ,200);
        resetButton.addActionListener(this);


        tick = new Tick();

        this.add(resetButton);
       // this.add(tick);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==resetButton){
          //  this.remove(tick);
            tick = new Tick();
          //  this.add(tick);
            SwingUtilities.updateComponentTreeUI(this);

        }
    }


}
