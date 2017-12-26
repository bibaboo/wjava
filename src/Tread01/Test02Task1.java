package Tread01;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Test02Task1 implements Runnable{
	private final List<String> list;
	private CountDownLatch latch;
	
	protected Test02Task1(List<String> list) {
        this.list = list;
    }
	
    @Override
    public void run() {
    	this.latch = new CountDownLatch(list.size());
    	for(String str : list){
    		Test02Task2 task2 = new Test02Task2(this.latch, str);
    		Thread thread = new Thread(task2);
			thread.start();
		}
    	
    	try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	
    	System.out.println("complete..");
    }
    
    class  Test02Task2 implements Runnable{
    	private final String str;
    	private final CountDownLatch latch;
    	
    	protected Test02Task2(CountDownLatch latch, String str) {
    		this.latch = latch;
            this.str = str;
        }
    	
        @Override
        public void run() {
        	try {
        		/*
        		System.out.println(Thread.currentThread().getName() + " " + str);
        		Thread.sleep(1000);
        		*/
        		print(str);
            }catch(Exception e){
            	e.printStackTrace();
            }finally {
                latch.countDown();
            }
        	
        }
    }
    
    public synchronized void print(String str){
    	System.out.println(Thread.currentThread().getName() + " " + str);
    }
    
}