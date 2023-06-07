package com.hubstc.listener;

class CarThread extends Thread{
	public void run(){
		for(int i=1;i<=5;i++){
			System.out.print("½Î³µ"+i+" ");
		}
	}
}

public class ThreadTest1  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarThread carthread=new CarThread();
		
		carthread.start();
		for(int i=1;i<=10;i++){
			System.out.print("Ö÷Ìå"+i+" ");
		}
	}

}
