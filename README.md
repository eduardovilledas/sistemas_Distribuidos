# Sistemas_Distribuidos
Repocitorio dedicado y creado para almacenar las racticas y proyecto, creados en equipo para la UA Sistemas Distribuidos del grupo 2TV13 2022/2
Integrantes:
  * Bernal Servin Alonso
  * Vargas Sánchez Andrea Liliana
  * Villedaz Gozalez Eduardo

## [Practica_1](https://github.com/BernalSerAlonso/sistemas_Distribuidos/tree/main/Practica_1)
### Introduccion al manejo de sockets
El propósito de esta primera practica es; conectar un programa en c y otro en java, con la típica de socket conexión de cliente servidor, pero en este caso por protocolo TCP.

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

El resto de archis necesarios estan separados en dos carpetas [Socket_C](https://github.com/BernalSerAlonso/sistemas_Distribuidos/tree/main/Practica_1/Socket._C) y [Socket_Java](https://github.com/BernalSerAlonso/sistemas_Distribuidos/tree/main/Practica_1/Socket_Java) 
