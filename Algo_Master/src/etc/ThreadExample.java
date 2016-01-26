package etc;

import org.junit.Test;

public class ThreadExample {

	public MyThread mt = new MyThread();

	public static class MyThread extends Thread {
		
		@Override
		public synchronized void start() {
			System.out.println("START");
			super.start();
		}
		
		@Override
		public void run() {
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
			
			super.run();
		}
		
		@Override
		public void destroy() {
			super.destroy();
		}
	}
	
	@Test
	public void test() {
		
		ThreadExample.MyThread mt = new ThreadExample.MyThread();
		System.out.println(mt.isAlive());
		mt.start();
		System.out.println(mt.isAlive());
		
		
		System.out.println(mt.isAlive());
		
		try {
			mt.join();
			System.out.println(mt.isAlive());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
