
#include <Socket_Cliente.h>
#include <Socket.h>

#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h> 
#include <unistd.h>
#include <string.h>
#include <math.h>

main ()
{
	int Socket_Con_Servidor;
   	int Longitud_Cadena = 0;
   	int Aux;
   	int Entero;
	char Cadena[100];
	char EnteroC[100]; 


	Socket_Con_Servidor = openConexion_Inet ("localhost", "cpp_java");
	if (Socket_Con_Servidor == 1)
	{
		printf ("Fallo la conexion inicial\n");
		exit (-1);
	}

   	readSocket (Socket_Con_Servidor, (char *)&Aux, sizeof(int));
   	Longitud_Cadena = ntohl (Aux);//pasamos del formato de red a entero
   	readSocket (Socket_Con_Servidor, Cadena, Longitud_Cadena); //leemos el socket
   	printf ("CLIENTE escucho: %s\n", Cadena);
   
   	scanf("%d", &Entero);//ingresamos numero entero
   	snprintf(EnteroC, 100, "%d", Entero);//convertimos a cadena
	strcpy (Cadena, EnteroC);//lo pasamos a la variable cadena
   	Longitud_Cadena = strlen(Cadena)+1;//contamos el numero de letras de cadena +1

   	Aux = htonl (Longitud_Cadena);//convertimos a formato de red
   	writeSocket (Socket_Con_Servidor, (char *)&Aux, sizeof(Longitud_Cadena));
	writeSocket (Socket_Con_Servidor, Cadena, Longitud_Cadena);
   	printf ("CLIENTE dijo: %d\n", Entero);

   	//reutilizamos el codigo de escuhca, para esperar el resultado de la suma
   	readSocket (Socket_Con_Servidor, (char *)&Aux, sizeof(int));
   	Longitud_Cadena = ntohl (Aux);
   	readSocket (Socket_Con_Servidor, Cadena, Longitud_Cadena);
   	printf ("ClIENTE resibio: %s\n", Cadena);

   	//cerramos el socket del lado del cliente
	close (Socket_Con_Servidor);
}