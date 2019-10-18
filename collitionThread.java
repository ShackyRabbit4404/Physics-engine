public class collitionThread extends Thread{
    Objects2D objects;
    public collitionThread(Objects2D objs){
        objects = objs;
    }
    public void run(){
        objects.checkCollision();
    }
}