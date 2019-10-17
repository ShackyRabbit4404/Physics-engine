import java.awt.*;
public class Properties2D{
    //in meters per second
    private double xVelocity;
    private double yVelocity;
    //in meters per second per second
    private double xAcceleration;
    private double yAcceleration;
    //in meters
    private double xPosition;
    private double yPosition;
    //in meters
    private double width;
    private double height;
    //shape of the object
    private Polygon shape;
    private double[] xCords;
    private double[] yCords;
    public Properties2D(){
        xVelocity = 0;
        yVelocity = 0;
        xAcceleration = 0;
        yAcceleration =0;
        xPosition = 0;
        yPosition = 0;
        shape = new Polygon();
    }
    public Properties2D(double xv, double yv, double xa, double ya, double xp, double yp,int w,int h,int[] xps,int[] yps){
        xVelocity = xv;
        yVelocity = yv;
        xAcceleration = xa;
        yAcceleration = ya;
        xPosition = xp;
        yPosition = yp;
        width = w;
        height = h;
        shape = new Polygon(xps,yps,xps.length);
    }
    public double getMappedX(){
        return xPosition-(width/2);
    }
    public double getMappedY(){
        return yPosition+(height/2);
    }
    public double getWidth(){
        return width;
    }
    public void setWidth(double w){
        width = w;
    }   
    public double getHeight(){
        return height;
    }   
    public void setHeight(double h){
        height = h;
    }
    public double getXVelocity(){
        return xVelocity;
    }
    public void setXVelocity(double xv){
        xVelocity = xv;
    }
    public double getYVelocity(){
        return yVelocity;
    }
    public void setYVelocity(double yv){
        yVelocity = yv;
    }
    public double getXAcceleration(){
        return xAcceleration;
    }
    public void setXAcceleration(double xa){
        xAcceleration = xa;
    }
    public double getYAcceleration(){
        return yAcceleration;
    }
    public void setYAcceleration(double ya){
        yAcceleration = ya;
    }
    public double getXPosition(){
        return xPosition;
    }
    public void setXPosition(double xp){
        xPosition = xp;
    }
    public double getYPosition(){
        return yPosition;
    }
    public void setYPosition(double yp){
        yPosition = yp;
    }
    public Polygon getShape(){
        return shape;
    }
    public boolean collidesWith(Polygon s2){
        for(int i = 0; i < s2.xpoints.length; i++){
            if(shape.contains(s2.xpoints[i],s2.ypoints[i])){
                return true;
            }
        }
        return false;
    }
    public void setShape(double[] xps, double[] yps){
        xCords = xps;
        yCords = yps;
    }
    public void updatePosition(double tickRate){
        //tick rate is in seconds
        xVelocity = xVelocity+xAcceleration*tickRate;
        yVelocity = yVelocity+yAcceleration*tickRate;
        xPosition = xPosition+(xVelocity*tickRate+0.5*xAcceleration*(tickRate*tickRate));
        yPosition = yPosition+(yVelocity*tickRate+0.5*yAcceleration*(tickRate*tickRate));
    }
    public double[][] getDrawPolygon(){
        double[][] cords = new double[2][xCords.length];
        System.out.println("X1: "+xCords[0]);
        for(int i = 0; i < xCords.length;i++){
            cords[0][i] = xCords[i]+xPosition;
            cords[1][i] = yCords[i]+yPosition;
        }
        System.out.println("X2: "+cords[0][0]);
        return cords;
    }
}