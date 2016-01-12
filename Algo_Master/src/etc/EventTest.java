package etc;

import java.util.PriorityQueue;
import java.util.Queue;

public class EventTest {

	
	public static void main(String... args) {
		
		Queue<String> q = new PriorityQueue<String>();
		
		EventListener el = new EventListener(q);
		el.start();
		
		EventMaker em = new EventMaker(q);
		em.start();
	}
}

class EventListener extends Thread {
	
	private Queue<String> q;
	
	public EventListener(Queue<String> q) {
		this.q = q;
	}
	
	@Override
	public void run() {
		
		while(true) {
			if(! q.isEmpty()) {
				String str = q.poll();
				System.out.println("POLLED : " + str);
			} else { 
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class EventMaker extends Thread {
	
	private Queue<String> q;
	
	public EventMaker(Queue<String> q) {
		this.q = q;
	}
	
	@Override
	public void run() {
		
		while(true) {
			long time = (long) (Math.random() * 10000);
			
			try {
				sleep(time);
				String now = "Now : " + System.currentTimeMillis();
				q.add(now);
				System.out.println("- ADDED   " + now);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}