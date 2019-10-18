public class positionUpdateThread extends Thread{
    Objects2D objects;
    public positionUpdateThread(Objects2D objs){
        objects = objs;
    }
    public void run(){
        objects.update();
    }
}   