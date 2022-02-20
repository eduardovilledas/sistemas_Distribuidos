
# Practica_1
## Introduccion al manejo de sockets
El propósito de esta primera practica es; conectar un programa en c y otro en java, con la típica de socket conexión de cliente servidor, pero en este caso por protocolo TCP.
  * Cliente.c con SocketServidor.java
  * Servidor.c con SocketCliente.java
____
Para esto nos ayudamos de una librería, con métodos que simplifican el código, todos los archivos de la librería se encuentran en la carpeta [libreria](https://github.com/BernalSerAlonso/sistemas_Distribuidos/tree/main/Practica_1/Libreria) del repositorio y lo único que de debemos hacer para poder usarla, es compilar los archivos.

En una terminal (Linux de preferencia) nos colocamos en la carpeta y dijitamos el comando 
```bash
$ cd .../.../libreria
$ Make
```
Para esta serie de programas es necesario agregar la entrada al archivo `serices` en linux en el directorio `private/etc`
```
cpp_java    tcp/15557
```
o
```
cpp_java    15557/tcp
```
segun sea el formato del resto de entradas en dicho archivo, En neesario porque nos especicara el puerto de comunicacion para nuestros programas

## [Socket_C](https://github.com/BernalSerAlonso/sistemas_Distribuidos/tree/main/Practica_1/Socket._C)
En esta carpta podemos encontrar tanto un archivo `Cliente` como un `Servidor` y un archivo `Makefile` que nos ayudara a compilarlos, pero antes debemos modificarlo 
```
all : Servidor Cliente

PATH_CHSOCKET= DIRECTORIO

CFLAGS = -g -I. -I$(PATH_CHSOCKET)

Servidor : Servidor.o
	cc Servidor.o -L$(PATH_CHSOCKET) -lChSocket -o Servidor

Cliente : Cliente.o
	cc Cliente.o -L$(PATH_CHSOCKET) -lChSocket -o Cliente

clean :
	rm *.o Cliente Servidor
```
donde en lugar de `DIRECTORIO` debemos colocar la el directorio donde esta la carpeta de la libreria, ppr ejemplo `/Users/alonsobernal/Desktop/libreria`
y para poder compilar el archivo seguimos los mismos pasos que para la libreria, modificando el directorio
```bash
$ cd .../.../Socket_c
$ Make
```

## [Socket_Java](https://github.com/BernalSerAlonso/sistemas_Distribuidos/tree/main/Practica_1/Socket_Java)
En el caso de los archivos .java es un poco mas simple, solo debemos colocarnos en el directorio donde esten los archivos (usando la terminal) y ejecutar el comando:
```bash
$ javac SocketServidor.java SocketCliente.java DatoSocket.java
```
he irlos ejecutando uno por uno segun sea el caso con el comando: (por ejemplo)
```bash
$ java SocketServidor
```
