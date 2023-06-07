package com.hubstc.listener;

class CarTarget implements Runnable{
	public void run(){
		for(int i=1;i<=5;i++){
			System.out.print("½Î³µ"+i+" ");
		}
	}
}

public class ThreadTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread carThread;
		CarTarget carTarget=new CarTarget();
		carThread=new Thread(carTarget);
		carThread.start();
		for(int i=1;i<=10;i++){
			System.out.print("Ö÷Ìå"+i+" ");
		}
	}

}
