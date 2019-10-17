import java.awt.*;
public class Main{
    public static void main(String[] args){
        Simulation2D simulation = new Simulation2D();
        
        Properties2D obj = new Properties2D();
        obj.setWidth(1);
        obj.setHeight(1);
        obj.setShape(new double[]{-1,2,2,-1},new double[]{1,2,-2,-1});
        obj.setXVelocity(0);
        obj.setYVelocity(0);
        obj.setYAcceleration(0);
        obj.setXAcceleration(1);
        obj.setXPosition(0);
        obj.setYPosition(0);
        simulation.addObject(obj);
        
        simulation.simulate();
    }
}