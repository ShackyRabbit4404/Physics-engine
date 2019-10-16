public class UpdateThread extends Thread{
    private Objects2D objects;
    //times per second
    private double updateRate;
    private boolean stillUpdating;
    public UpdateThread(Objects2D objs, int ur){
        objects = objs;
        updateRate = ur;
        stillUpdating = true;
    }
    public void stopUpdating(){
        stillUpdating = false;
    }
    public void run(){
        while(stillUpdating){
            objects.update();
            try{
                Thread.sleep((long)(1000/updateRate));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}