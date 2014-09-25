import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Steve on 9/20/2014.
 */



public class Main {

    private static final Random randNum = new Random();
    public static double incomingVal;
    public static void main(String [] Args){

        FrameContainer frameContainer = new FrameContainer();
        frameContainer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameContainer.setSize(700, 550);
        frameContainer.setMinimumSize(new Dimension(700,550));
        frameContainer.setLocation(200, 100);
        frameContainer.setVisible(true);

        while(true){
            try{
                incomingVal = randNum.nextInt(30)+15;
                frameContainer.tempChart.updatePanel(incomingVal);
                frameContainer.incomingVal = incomingVal;
                frameContainer.printTemperature();
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
