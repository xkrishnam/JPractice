package bmctest;

import java.util.concurrent.TimeUnit;

public class Thread3 extends Thread {
    public void run(){
        System.out.println("start");
        for(int i=0;i<1000;i++){
            System.out.print("B");
//            try {
//                TimeUnit.MILLISECONDS.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            if(i==7)
                yield();
        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        new Thread3().start();
        Object obj;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    System.out.print("A");
//                    try {
//                       // TimeUnit.MILLISECONDS.sleep(200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        }).start();
    }
}


