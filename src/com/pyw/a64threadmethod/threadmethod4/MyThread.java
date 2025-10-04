package com.pyw.a64threadmethod.threadmethod4;

public class MyThread extends Thread{

    @Override
    public void run() {//"飞机"  "坦克"
        for (int i = 1; i <= 100; i++) {

            System.out.println(getName() + "@" + i);
            //表示出让当前CPU的执行权，可以让结果尽可能均匀
            Thread.yield();
        }
    }
}
