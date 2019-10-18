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
    public void checkCollision(){
        for(int i = 0; i < objects.size();i++){
            boolean touching = false;
            for(int a = 0;a < objects.size();a++){
                Properties2D p = objects.get(a);
                if(i != a && objects.get(i).collidesWith(p.getXCords(),p.getYCords(),p.getXPosition(),p.getYPosition())){
                    touching = true;
                }
            }
            objects.get(i).setTouchingObject(touching);
        }
    }
    public void updateRotations(){
        for(Properties2D p: objects){
            p.updateRotation(tickRate);
        }
    }
}