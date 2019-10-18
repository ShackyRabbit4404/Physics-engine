public class updateRotationThread extends Thread{
    Objects2D objects;
    public updateRotationThread(Objects2D objs){
        objects = objs;
    }
    public void run(){
        objects.updateRotations();
    }
}