
#include <Socket_Servidor.h>
#include <Socket.h>

#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h> 
#include <unistd.h>

main (){

	int Socket_Servidor;
	int Socket_Cliente;
   	int Aux;
   	int Longitud_Cadena;
	const char* Cadena;
	const char* Salida;

	//Abrimos el socket
	Socket_Servidor = openSocket_Inet ("cpp_java");
	if (Socket_Servidor == -1)
	{
		printf ("No ha sido posible abrir Socket_Servidor\n");
		exit (-1);
	}
	Socket_Cliente = acceptsConexion_Client (Socket_Servidor);
	if (Socket_Servidor == -1)
	{
		printf ("Fallamos al recibir la peticion de conexion\n");
		exit (-1);
	}

	//Pasamos un primer mensaje predefinido con su numero de caracteres +1
   	Longitud_Cadena = 30;
	strcpy (Cadena, "Hola ¿como podemos ayudarte?");

	//Iniciamos un ciclo ce comunicacion 
   	do{
	   	Aux = htonl (Longitud_Cadena);//convertimos el entero a red
	   	//enviamos el mensaje por el socket abierto 
	   	writeSocket (Socket_Cliente, (char *)&Aux, sizeof(Longitud_Cadena));
	   	writeSocket (Socket_Cliente, Cadena, Longitud_Cadena);
	   	printf ("ServidorC Enviado: %s\n", Cadena);
	   
	   	//escuchamos el socket en espera de mensajes
	   	readSocket (Socket_Cliente, (char *)&Aux, sizeof(Longitud_Cadena));
	   	Longitud_Cadena = ntohl(Aux);
		readSocket (Socket_Cliente, Cadena, Longitud_Cadena);
	   	printf ("ServidorC Recibido: %s\n", Cadena);

	   	Salida = Cadena;
	   	Longitud_Cadena = 49;
		strcpy (Cadena, "Te recomendamos llamar a atencion a clientes");

	}while(strcmp(Salida, "adios") != 0);


	//Se cierran los sockets
	fflush( stdin );
	close (Socket_Cliente);
	close (Socket_Servidor);
}