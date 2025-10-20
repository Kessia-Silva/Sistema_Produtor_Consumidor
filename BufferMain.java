
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;


public class BufferMain {
    private static final BlockingQueue<Integer> fila = new LinkedBlockingDeque<>(5);

    public static void main(String[] args) {

        System.out.println("\n=====================");
        System.out.println("Consumidor - Produtor");
        System.out.println("=====================\n");

        Produtor produtor = new Produtor(fila);
        Consumidor consumidor = new Consumidor(fila);


        // Executor com 2 threads — uma para o produtor e uma para o consumidor
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(produtor);
        executor.submit(consumidor);

        executor.shutdown();

      
    }
}
