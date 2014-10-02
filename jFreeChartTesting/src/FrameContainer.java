import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Steve on 9/20/2014.
 */
public class FrameContainer extends JFrame {

    public TempChart tempChart;
    public SidePanel sidePanel;

    public double incomingVal;

    public FrameContainer(){
        super("Temperature GUI");

        sidePanel = new SidePanel();
        tempChart = new TempChart();
        tempChart.validate();


        setLayout(new BorderLayout());
        add(tempChart, BorderLayout.NORTH);
        add(sidePanel, BorderLayout.SOUTH);
        pack();

       // Add action listeners here
       sidePanel.inZoomButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                    tempChart.mode60 = true;
           }
       });
       sidePanel.outZoomButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               tempChart.mode60 = false;
           }
       });
       sidePanel.tempButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               sidePanel.inCelcius = !sidePanel.inCelcius;
               printTemperature();
           }
       });
       sidePanel.graphTypeButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                sidePanel.bContinuous = !sidePanel.bContinuous;
                // Testing error mode
                tempChart.modeError = !tempChart.modeError;

               printGraphType();
           }
       });
    }

    public void printTemperature(){
        if(sidePanel.inCelcius)
            sidePanel.temperatureLabel.setText(Double.toString(incomingVal)+"°C");
        else
            sidePanel.temperatureLabel.setText(Double.toString((incomingVal*9.0 / 5.0) +32.0) + " °F");

    }

    public void printGraphType(){
        /*
        if(sidePanel.bContinuous)
            sidePanel.graphTypeLabel.setText("Continuous");
        else
            sidePanel.graphTypeLabel.setText("Not Continuous");
        */
        // TESTING ERROR MODE
        if(tempChart.modeError)
            sidePanel.graphTypeLabel.setText("Error!");
        else
            sidePanel.graphTypeLabel.setText("No Error");
    }
}


























