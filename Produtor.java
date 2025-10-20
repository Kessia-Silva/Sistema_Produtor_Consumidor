import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Produtor implements Runnable{
    
    private BlockingQueue<Integer> fila;

    public Produtor(BlockingQueue<Integer> fila){
        this.fila = fila;
    }

    public void run(){
        try {
            while(true){
                if(fila.remainingCapacity() == 0){
                    // Se estiver cheia
                    System.out.println("Buffer cheio, aguardando espaço");
                }
                int numero = new Random().nextInt(10000);
                int tempoPreparo = new Random().nextInt(10);
                fila.put(numero);
                System.out.println("Produzindo: " + numero);
                Thread.sleep(1000 * tempoPreparo);
            }
            
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    };
    
}
