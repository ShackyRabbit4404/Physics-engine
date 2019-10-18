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
    private boolean touchingObject;
    //rotation speed in radians per second
    private double rotationSpeed;
    //center of the object
    double[] centroid;
    public Properties2D(){
        xVelocity = 0;
        yVelocity = 0;
        xAcceleration = 0;
        yAcceleration = 0;
        xPosition = 0;
        yPosition = 0;
        shape = new Polygon();
        touchingObject = false;
        rotationSpeed = 0;
        centroid = new double[2];
    }
    public Properties2D(double xv, double yv, double xa, double ya, double xp, double yp,int w,int h,int[] xps,int[] yps,boolean to,double rs){
        xVelocity = xv;
        yVelocity = yv;
        xAcceleration = xa;
        yAcceleration = ya;
        xPosition = xp;
        yPosition = yp;
        width = w;
        height = h;
        shape = new Polygon(xps,yps,xps.length);
        touchingObject = to;
        double rotationSpeed = rs;
    }
    public double getRotationSpeed(){
        return rotationSpeed;
    }
    public void setRotationSpeed(double rs){
        rotationSpeed = rs;
    }
    public double[] getXCords(){
        return xCords;
    }
    public double[] getYCords(){
        return yCords;
    }
    public boolean getTouchingObject(){
        return touchingObject;
    }
    public void setTouchingObject(boolean to){
        touchingObject = to;
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
    public double[] calculateCentroid(){
        double x = 0;
        double y = 0;
        for(int i = 0; i < xCords.length; i++){
            x+=xCords[i];
            y+=yCords[i];
        }
        return new double[]{x/xCords.length,y/xCords.length};
    }
    public void updateRotation(double tickRate){
        double[][] points = transformToOrigin();
        for(int i = 0; i < xCords.length;i++){
            double x = points[0][i];
            double y = points[1][i];
            points[0][i] = x*Math.cos(rotationSpeed*tickRate)-y*Math.sin(rotationSpeed*tickRate);
            points[1][i] = x*Math.sin(rotationSpeed*tickRate)+y*Math.cos(rotationSpeed*tickRate);
        }
        points = transformAwayFromOrigin(points);
        xCords = points[0];
        yCords = points[1];
    }
    public double[][] transformAwayFromOrigin(double[][] xys){
        for(int i = 0; i < xys.length;i++){
            xys[0][i] = xys[0][i]+centroid[0];
            xys[1][i] = xys[1][i]+centroid[1];
        }
        return xys;
    }
    public double[][] transformToOrigin(){
        double[][] ret = new double[2][xCords.length];
        for(int i = 0; i < xCords.length;i++){
            ret[0][i] = xCords[i]-centroid[0];
            ret[1][i] = yCords[i]-centroid[1];
        }
        return ret;
    }
    public double[][] scaleShape(double scaleFactor){
        double[][] ret = new double[2][xCords.length];
        for(int i = 0; i < xCords.length; i++){
            ret[0][i] = (xCords[i]+xPosition)*scaleFactor;
            ret[1][i] = (yCords[i]+yPosition)*scaleFactor;
        }
        return ret;
    }
    public boolean collidesWith(double[] xpoints, double[] ypoints,double xp, double yp){
        double scale = 100;
        double[][] temp = scaleShape(scale+1);
        int[] x = new int[temp[0].length];
        int[] y = new int[temp[0].length];
        for(int i = 0; i < x.length; i++){
            x[i] = (int)(temp[0][i]+0.5);
            y[i] = (int)(temp[1][i]+0.5);
        }
        for(int i = 0; i < xpoints.length; i++){
            if(new Polygon(x,y,x.length).contains((xpoints[i]+xp)*scale,(ypoints[i]+yp)*scale)){
                return true;
            }
        }
        return false;
    }
    public void setShape(double[] xps, double[] yps){
        xCords = xps;
        yCords = yps;
        centroid = calculateCentroid();
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
        for(int i = 0; i < xCords.length;i++){
            cords[0][i] = xCords[i]+xPosition;
            cords[1][i] = yCords[i]+yPosition;
        }
        return cords;
    }
}