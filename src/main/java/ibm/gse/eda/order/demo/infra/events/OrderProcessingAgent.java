package ibm.gse.eda.order.demo.infra.events;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.kafka.streams.KafkaStreams;
import org.jboss.logging.Logger;

import ibm.gse.eda.order.demo.domain.OrderAggregator;
import io.quarkus.arc.Unremovable;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;

@Singleton
public class OrderProcessingAgent {
    private static final Logger logger = Logger.getLogger(OrderProcessingAgent.class.getName());
    private static volatile boolean shutdown = false;
    private final ExecutorService executorService;
    
    
   
    public KafkaStreams kafkaStreams;
    @Inject
    KafkaStreamConfig kafkaStreamConfig;
    @Inject
    OrderAggregator aggregator;

    public OrderProcessingAgent() {  
        this.executorService = Executors.newSingleThreadExecutor();
    }


    public synchronized void stop() {
       
    }

    

    void onStart(@Observes StartupEvent ev){
        this.kafkaStreams = initializeKafkaStreams();
		logger.info("OrderProcessingAgent started");
     }
 
     void onStop(@Observes ShutdownEvent ev){
        shutdown = true;
        if (executorService != null) {
            executorService.shutdown();
        }
        if ( kafkaStreams == null ) {
            kafkaStreams.close();
        }
      }

      @Produces
      @Singleton
      @Unremovable
      @Startup
      public KafkaStreams getKafkaStreams() {
          return kafkaStreams;
      }

      private KafkaStreams initializeKafkaStreams() {
        Properties props = kafkaStreamConfig.getStreamsProperties();
        kafkaStreams = new KafkaStreams(aggregator.buildProcessFlow(), props);
       
    executorService.execute(new Runnable() {

        @Override
        public void run() {
            if (!shutdown) {
                logger.debug("Starting Kafka Streams pipeline");
                kafkaStreams.start();
            }
        }
    });
    return kafkaStreams;
  }
}
