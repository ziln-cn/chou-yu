package com.hubstc.listener;

class CarTarget implements Runnable{
	public void run(){
		for(int i=1;i<=5;i++){
			System.out.print("轿车"+i+" ");
		}
	}
}

public class ThreadTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread carThread;
		CarTarget carTarget=new CarTarget();
		carThread=new Thread(carTarget); //构造方法的参数是Runnable
		carThread.start();
		for(int i=1;i<=10;i++){
			System.out.print("主体"+i+" ");
		}
	}

}
