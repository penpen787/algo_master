package etc;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ThreadExample {

	
	public static boolean isRunning = false;
	
	public MyThread mt = new MyThread();

	public static class MyThread extends Thread {
		
		@Override
		public synchronized void start() {
			System.out.println("START");
			super.start();
		}
		
		@Override
		public void run() {
			while(true) {
				if(isRunning) {
					System.out.println("RUN");
					
					for(int i=0; i<5; i++) {
						try {
							System.out.println(i);
							Thread.sleep(1000);
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		@Override
		public void destroy() {
			super.destroy();
		}
		
		public void sleepMyself() {
			try {
				System.out.println("sleep");
				Thread.sleep(1500);
				System.out.println("sleep END");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void test() {
		
		ThreadExample.MyThread mt = new ThreadExample.MyThread();
		System.out.println("1 " + mt.isAlive());
		mt.start();
		System.out.println("2 " + mt.isAlive());
		
		try {
			mt.sleepMyself();
			System.out.println("3 " + mt.isAlive());
			mt.join();
			System.out.println("4 " + mt.isAlive());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<String> list = new ArrayList<>();
		
	}
	
	public static void main(String...args) {
		
		ThreadExample.MyThread mt = new ThreadExample.MyThread();
		System.out.println(mt.isAlive());
		mt.start();
		System.out.println(mt.isAlive());
		
		
		System.out.println(mt.isAlive());
		
//		try {
//			mt.join();
//			System.out.println(mt.isAlive());
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
		
}
