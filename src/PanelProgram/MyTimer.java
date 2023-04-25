package PanelProgram;

import java.util.Timer;
import java.util.TimerTask;

public class MyTimer{
   static int sec = 10;
   static Timer timer = new Timer();
   int del = 1000;
   int per = 1000;
   public MyTimer(){
        System.out.println(sec);
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.out.println(seti());
            }
        }, del, per);
    }

    private static final int seti() {
        if (sec == 1)
            timer.cancel();
        return --sec;
    }

    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
    }
}
