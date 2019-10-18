import javax.swing.*;
import java.awt.*;
import java.util.*;
public class GUI extends JComponent{
    private Objects2D objects;
    private int width;
    private int height;
    private double zoom;
    private boolean gridVisible;
    public GUI(Objects2D objs,int w, int h){
        super();
        objects = objs;
        width = w;
        height = h;
        zoom = 20;
        gridVisible = true;
    }
    public void draw(){
        super.repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(gridVisible){
            g.setColor(new Color(212, 212, 212));
            for(int i = 1; i < (int)(width/zoom); i++){
                g.fillRect((int)(i*zoom),0,1,height);
            }
            for(int i = 1; i < (int)(height/zoom); i++){
                g.fillRect(0,(int)(i*zoom),width,1);
            }
            g.setColor(Color.BLACK);
            g.fillRect(width/2,0,1,height);
            g.fillRect(0,height/2,width,1);
        }
        for(Properties2D p: objects.getObjects()){
            //g.fillRect((int)(((width/2)+p.getMappedX()*zoom)),(int)(((height/2)+p.getMappedY()*-1*zoom)),(int)(p.getWidth()*zoom),(int)(p.getHeight()*zoom));
            if(p.getTouchingObject()){
                g.setColor(Color.RED);
            }
            else{
                g.setColor(Color.GREEN);
            }
            g.fillPolygon(getScaledPolygon(p.getDrawPolygon()));
        }
    }
    public Polygon getScaledPolygon(double[][] cords){
        int[] xpoints = new int[cords[0].length];
        int[] ypoints = new int[cords[0].length];
        for(int i = 0; i < xpoints.length; i++){
            xpoints[i] = (int)(cords[0][i]*zoom+(width/2));
            ypoints[i] = (int)(cords[1][i]*zoom*-1+(height/2));
        }
        return new Polygon(xpoints, ypoints,xpoints.length);
    }
}   