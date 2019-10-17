public class UpdatingThread extends Thread{
    private Objects2D objects;
    //times per second
    private double updateRate;
    private boolean stillUpdating;
    public UpdatingThread(Objects2D objs, int ur){
        objects = objs;
        updateRate = ur;
        stillUpdating = true;
    }
    public void stopUpdating(){
        stillUpdating = false;
    }
    public void run(){
        System.out.println("Starting Updating thread");
        while(stillUpdating){
            new Update(objects).start();
            try{
                Thread.sleep((long)(1000/updateRate));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}