import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] argc){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,200,TimeUnit.MICROSECONDS, new ArrayBlockingQueue<>(5));
        for (int i=0;i<15;i++){
            Task task = new Task(i);
            executor.execute(task);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+ executor.getQueue().size()+"，已执行完别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

    static class  Task implements Runnable{
        private int num;
        public Task(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println(num+"正在执行-----");
            try {
                Thread.currentThread().sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(num+"执行结束-----");
        }
    }
}
