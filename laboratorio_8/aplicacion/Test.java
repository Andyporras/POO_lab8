package aplicacion;
public class Test {
 
    public static void main(String[] args) throws InterruptedException {
         
        long inicio = System.currentTimeMillis();
         
        Thread.sleep(2000);
         
        long fin = System.currentTimeMillis();
         
        int tiempo = (int) ((fin - inicio)/1000);
         
        System.out.println(tiempo +" horas");
         
    }
     
     
}
    