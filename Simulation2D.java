import javax.swing.*;
import java.awt.*;
public class Simulation2D{
    private GUI screen;
    private Objects2D objects;
    private JFrame frame;
    private drawThread screenThread;
    private double updateRate;
    private UpdateThread simulatingThread;
    private boolean screenVisible;
    private double frameRate;
    public Simulation2D(){
        screenVisible = true;
        updateRate = 60;
        frameRate = 60;
        objects = new Objects2D(1/updateRate);
        simulatingThread = new UpdateThread(objects,(int)updateRate);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screen = new GUI(objects,screenSize.width,screenSize.height);
        screenThread = new drawThread(screen,frameRate);
        frame = new JFrame();
        frame.setSize(screenSize.width, screenSize.height);
        frame.add(screen);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        Properties2D obj = new Properties2D();
        obj.setWidth(1);
        obj.setHeight(1);
        objects.addObject(obj);
        obj.setXVelocity(0);
        obj.setYVelocity(0);
        obj.setYAcceleration(0);
        obj.setXAcceleration(2);
        obj.setXPosition(-30);
        obj.setYPosition(0);
        
        simulatingThread.start();
        if(screenVisible){
            System.out.println("Starting display thread");
            screenThread.start();
        }
    }
}