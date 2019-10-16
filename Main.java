public class Main{
    public static void main(String[] args){
        Simulation2D simulation = new Simulation2D();
        
        Properties2D obj = new Properties2D();
        obj.setWidth(1);
        obj.setHeight(1);
        obj.setXVelocity(15);
        obj.setYVelocity(20);
        obj.setYAcceleration(-9.8);
        obj.setXAcceleration(0);
        obj.setXPosition(-30);
        obj.setYPosition(-10);
        simulation.addObject(obj);
        
        simulation.simulate();
    }
}