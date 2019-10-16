public class Main{
    public static void main(String[] args){
        Simulation2D simulation = new Simulation2D();
        
        Properties2D obj = new Properties2D();
        obj.setWidth(1);
        obj.setHeight(1);
        obj.setXVelocity(0);
        obj.setYVelocity(0);
        obj.setYAcceleration(0);
        obj.setXAcceleration(2);
        obj.setXPosition(-30);
        obj.setYPosition(0);
        simulation.addObject(obj);
        
        simulation.simulate();
    }
}