
package CaseStudy_ConditionObject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsumerProducer {

public static void main(String[] args) {
    Buffer buffer = new Buffer();

    // Create a thread pool with two threads
    ExecutorService executor = Executors.newFixedThreadPool(2);
    executor.execute(new ProducerTask(buffer));
    executor.execute(new ConsumerTask(buffer));
    executor.shutdown();
}

}
