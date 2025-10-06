package com.pyw.a69threadtest.test6;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread extends Thread{

    ArrayList<Integer> arrayList;

    //线程一
    static ArrayList<Integer> list1 = new ArrayList<>();
    //线程二
    static ArrayList<Integer> list2 = new ArrayList<>();

    public MyThread(){}

    public MyThread(ArrayList<Integer> arrayList){
        this.arrayList = arrayList;
    }

    @Override
    public void run() {
        //1.循环
        //2.同步代码块
        //3.判断到末尾
        //4.判断没到末尾
        while (true){
            synchronized (MyThread.class){
                if(arrayList.isEmpty()){
                    //这个方法不好，有几个线程就要写几个判断
                    int list1Sum = list1.stream().reduce(0, Integer::sum);
                    int list2Sum = list2.stream().reduce(0, Integer::sum);

                    if("抽奖箱1".equals(getName())){
                        if(list1.isEmpty()){
                            System.out.println("抽奖箱1没有产生任何奖项");
                        }else {
                            System.out.println("抽奖箱1总共产生了"+list1.size()+"个奖项。" +
                                    "分别为："+ list1 +
                                    "。最高奖项为"+Collections.max(list1)+"元，" +
                                    "总计额为"+list1Sum+"元");
                        }

                    }else {
                        if (list2.isEmpty()) {
                            System.out.println("抽奖箱2没有产生任何奖项");
                        } else {
                            System.out.println(
                                    "抽奖箱2总共产生了" + list2.size() + "个奖项。" +
                                    "分别为：" + list2 +
                                    "。最高奖项为" + Collections.max(list2) + "元，" +
                                    "总计额为" + list2Sum + "元");
                        }
                    }
                    break;
                }else {
                    Collections.shuffle(arrayList);
                    Integer integer = arrayList.remove(0);
                    if("抽奖箱1".equals(getName())){
                        list1.add(integer);
                    }else {
                        list2.add(integer);
                    }
                }
            }
        }
    }
}
