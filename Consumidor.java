import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumidor implements Runnable{
  
    private BlockingQueue<Integer> fila;

    public Consumidor(BlockingQueue<Integer> fila){
        this.fila = fila;
    }

    public void run(){ 
        try {
            while (true) { 
                if(fila.isEmpty()){
                    // Se estiver vazia
                    System.out.println("Buffer vazio, aguardando item ");
                }
                int tempoConsumo = new Random().nextInt(10);
                Integer take = fila.take();
                System.out.println("Consumindo: " + take);
                Thread.sleep(1000 * tempoConsumo);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    };
}
