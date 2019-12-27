//实现生产者和消费者
public class ProducerAndConsumer {
    public int count = 0;
    public String lock = "lock";
    public int full = 10;

    public static void main(String[] argc){
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();
        new Thread(producerAndConsumer.new Producer()).start();
        new Thread(producerAndConsumer.new Consumer()).start();
        new Thread(producerAndConsumer.new Producer()).start();
        new Thread(producerAndConsumer.new Consumer()).start();
    }

    class Producer implements Runnable{

        @Override
        public void run() {
            for (int i =0 ; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    while (count==full) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count ++;
                    System.out.println("Producer:" + i);
                    lock.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable{

        @Override
        public void run() {
            for (int i = 0;i < 10; i ++ ) {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    while (count<=0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count --;
                    System.out.println("Consumer:" + i );
                    lock.notifyAll();
                }
            }
        }
    }
}
