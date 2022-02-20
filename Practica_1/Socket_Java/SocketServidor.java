
import java.net.*;
import java.io.*;

public class SocketServidor
{    
    public static void main (String [] args)
    {

        new SocketServidor();
    }

    public SocketServidor()
    {
        try
        {
            // Se crea un socket servidor atendiendo a un determinado puerto.
            ServerSocket socket = new ServerSocket (15557);
            
            // Se acepata una conexión con un cliente. Esta llamada se queda
            // bloqueada hasta que se arranque el cliente.
            System.out.println ("Esperando cliente");
            Socket cliente = socket.accept();
            System.out.println ("Conectado con cliente de " + cliente.getInetAddress());
            cliente.setSoLinger (true, 100);


            String salida2;
            int iTest, iTest2;

            // Se prepara un dato para enviar.
            DatoSocket dato = new DatoSocket("Ingrese un numero entero entre 1 y 10");
            // La clase encargadade escribir datos en el socket.
            DataOutputStream bufferSalida = new DataOutputStream (cliente.getOutputStream());
            // Se envía el dato.
            dato.writeObject (bufferSalida);
            //Imprimimos el dato en la consola de SERVIDOR
            System.out.println ("SERVIDOR enviado:" + dato.toString());


            // Clase encargada de leer datos del socket.
            DataInputStream bufferEntrada = new DataInputStream (cliente.getInputStream());
            // Se crea un dato y se le dice que se rellene con el flujo de entrada de datos.
            DatoSocket aux = new DatoSocket("");
            aux.readObject (bufferEntrada);
            //guardamos el dato como un entero, convirtiendo la cadena a entero
            iTest = Integer.parseInt(aux.toString()); 
            String salida = Integer.toString(iTest);
            System.out.println ("SERVIDOR resibio: " + salida);


            iTest2 = iTest+1;//Sumamos 1 al numero de entrada
            salida2 = Integer.toString(iTest2); //convertimos el numero en una cadena 
            DatoSocket dato2 = new DatoSocket(salida2);//preparamos la salida
            dato2.writeObject (bufferSalida);//enviamos
            System.out.println ("SERVIDOR obtuvo: " + salida2);

            
            // Se cierra el socket con el cliente.
            cliente.close();
            
            // Se cierra el socket encargado de aceptar clientes. Ya no
            // queremos más.
            socket.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
