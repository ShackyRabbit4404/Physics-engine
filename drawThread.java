public class drawThread extends Thread{
    private boolean drawScreen;
    private double frameRate;
    private GUI screen;
    public drawThread(GUI s,double fr){
        drawScreen = true;
        frameRate = fr;
        screen = s;
    }
    public void stopDrawing(){
        drawScreen = false;
    }
    public void run(){
        while(drawScreen){
            screen.draw();
            try{
                Thread.sleep((long)(1000/frameRate));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}