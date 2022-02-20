
import java.net.*;
import java.io.*;
import java.util.Scanner;


public class SocketCliente
 {
     public static void main (String [] args)
     {
         new SocketCliente();
     }
     
     public SocketCliente()
     {
         try
         {
            // Se crea el socket cliente 
            Socket socket = new Socket ("localhost", 15557);
            System.out.println ("conectado");
            String resta;

            do{
                socket.setSoLinger (true, 100);
                 
                // Creamos un buffer que nos permitira leer
                DataInputStream bufferEntrada = new DataInputStream (socket.getInputStream()); 
                // leemos del socket con ayuda del buffer
                DatoSocket dato = new DatoSocket("");
                dato.readObject(bufferEntrada);
                //imorimimos el mensaje en pantalla
                System.out.println ("ClienteJava Recibido: " + dato.toString());

                // Creamos un nuevo buffer que nos permita enviar datos
                DataOutputStream bufferSalida =new DataOutputStream (socket.getOutputStream());
                // esperamos que la entrada por teclado
                Scanner in = new Scanner(System.in);
                resta = in.nextLine();
                //Se crea el dato y se escribe en el flujo de salida 
                DatoSocket aux = new DatoSocket (resta);
                aux.writeObject (bufferSalida);
                System.out.println ("ClienteJava Enviado: " + aux);

            }while(resta.compareTo("adios") != 0);

            socket.close();
         }
         catch (Exception e)
         {
             e.printStackTrace();
         }
     }
}