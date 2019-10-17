import java.util.*;
public class Objects2D{
    ArrayList<Properties2D> objects;
    private double tickRate;
    public Objects2D(double tr){
        objects = new ArrayList<Properties2D>();
        tickRate = tr;
    }
    public Objects2D(ArrayList<Properties2D> objs, double tr){
        objects = objs;
        tickRate = tr;
    }
    public ArrayList<Properties2D> getObjects(){
        return objects; 
    }
    public void addObject(Properties2D p){
        objects.add(p);
    }
    public void update(){
        for(Properties2D p: objects){
            //System.out.println("Updateing position\nX:"+p.getMappedX());
            p.updatePosition(tickRate);
        }   
    }   
    
}