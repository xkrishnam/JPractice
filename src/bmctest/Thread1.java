package bmctest;

public class Thread1 extends Thread {

   // public void start(){
     //   System.out.println("start");
    //}

    public void run(){
        System.out.println("run");
    }

    public static void main(String[] args) {
        Thread1 a=new Thread1();
        Thread1 b=new Thread1();
        a.start();
        b.start();
    }

}
