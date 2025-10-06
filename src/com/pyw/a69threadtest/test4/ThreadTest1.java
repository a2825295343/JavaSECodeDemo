package com.pyw.a69threadtest.test4;

public class ThreadTest1 {
    public static void main(String[] args) {
        /*
            TODO 抢红包
            要求：100块，分成了三个包，五个人去抢
            红包是共享数据
            5个人是5条线程
            打印结果如下
            xxx抢到了xxx元
            xxx抢到了xxx元
            xxx抢到了xxx元
            xxx没抢到
            xxx没抢到
         */
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        MyThread t4 = new MyThread();
        MyThread t5 = new MyThread();

        t1.setName("k");
        t2.setName("kk");
        t3.setName("kkk");
        t4.setName("kkkk");
        t5.setName("kkkkk");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
