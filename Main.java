import java.awt.*;
public class Main{
    public static void main(String[] args){
        Simulation2D simulation = new Simulation2D();
        
        Properties2D obj = new Properties2D();
        obj.setWidth(1);
        obj.setHeight(1);
        obj.setShape(new double[]{-1,1,1,-1},new double[]{1,1,-1,-1});
        obj.setXVelocity(1);
        obj.setYVelocity(0);
        obj.setYAcceleration(0);
        obj.setXAcceleration(0);
        obj.setXPosition(-10);
        obj.setYPosition(0);
        simulation.addObject(obj);
        
        Properties2D s1 = new Properties2D();
        s1.setShape(new double[]{-1,0,1,0},new double[]{0,1,0,-1});
        s1.setXPosition(10);
        s1.setXVelocity(-1);
        simulation.addObject(s1);
        
        Properties2D s2 = new Properties2D();
        s2.setShape(new double[]{-1,0,1,0},new double[]{0,1,0,-1});
        s2.setXPosition(15);
        s2.setXAcceleration(-1);
        simulation.addObject(s2);
        
        Properties2D s3 = new Properties2D();
        s3.setShape(new double[]{-1,0,1,0},new double[]{0,1,0,-1});
        s3.setXPosition(0);
        s3.setYPosition(3);
        s3.setRotationSpeed(5);
        simulation.addObject(s3);
        
        simulation.simulate();
    }
}