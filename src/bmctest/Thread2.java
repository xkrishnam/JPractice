package bmctest;

public class Thread2 extends Thread{
    int x,y;
    @Override
    public void run() {
        for(int i=0;i<1000;i++) {
            synchronized (this) {
                x = 12;
                y = 12;
            }
        }
        System.out.println("X = "+x+" y = "+y);
    }

    public static void main(String[] args) {
        Thread2 t1=new Thread2();
        Thread2 t2=new Thread2();
        t1.start();
        t2.start();
    }
}
