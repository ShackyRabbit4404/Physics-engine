import javax.swing.*;
import java.awt.*;
public class Simulation2D{
    private GUI screen;
    private Objects2D objects;
    private JFrame frame;
    private drawThread screenThread;
    private double updateRate;
    private UpdatingThread simulatingThread;
    private boolean screenVisible;
    private double frameRate;
    public Simulation2D(){
        screenVisible = true;
        updateRate = 60;
        frameRate = 60;
        objects = new Objects2D(1/updateRate);
        simulatingThread = new UpdatingThread(objects,(int)updateRate);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screen = new GUI(objects,screenSize.width,screenSize.height);
        screenThread = new drawThread(screen,frameRate);
        frame = new JFrame();
        frame.setSize(screenSize.width, screenSize.height);
        frame.add(screen);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void addObject(Properties2D obj){
        objects.addObject(obj);
    }
    public void simulate(){
        simulatingThread.start();
        if(screenVisible){
            System.out.println("Starting display thread");
            screenThread.start();
        }
    }
}   