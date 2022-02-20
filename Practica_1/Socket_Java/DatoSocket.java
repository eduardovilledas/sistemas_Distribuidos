
import java.io.*;

public class DatoSocket implements Serializable
 {
   public DatoSocket (String cadena)
   {
      // Si la cadena no es null, se guarda la cadena y su longitud 
      if (cadena != null)
      {
         c = cadena.length();
         d = cadena;
      }
   }

   public int c = 0;
   public String d = "";
     
   //con este metodo podemos obtener solo la cadena resultante 
   public String toString ()
   {
       String resultado;
       resultado = d;
       return resultado;
   }

   //Metodo para escribir en formato que entienda C
   public void writeObject(java.io.DataOutputStream out)
         throws IOException
     {
        // Se envía la longitud de la cadena + 1 por el \0 necesario en C
        out.writeInt (c+1);

        // Se envía la cadena como bytes.
        out.writeBytes (d);

        // Se envía el \0 del final
        out.writeByte ('\0');
     }
    
    
    //Leemos los datos de entrada
    public void readObject(java.io.DataInputStream in)
    throws IOException
    {
        // Se lee la longitud de la cadena y se le resta 1 extra nos envía C.
        c = in.readInt() - 1;
         
        // leemos la cadena en un array
        byte [] aux = null;
         
        aux = new byte[c];    // Se le da el tamaño 
        in.read(aux, 0, c);   // Se leen los bytes
        d = new String (aux); // Se convierten a String

        in.read(aux,0,1);     // Se lee el \0
     }
}