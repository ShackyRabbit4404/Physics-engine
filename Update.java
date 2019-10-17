public class Update extends Thread{
    Objects2D objects;
    public Update(Objects2D objs){
        objects = objs;
    }
    public void run(){
        objects.update();
    }
}   