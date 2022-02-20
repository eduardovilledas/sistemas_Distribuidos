
#ifndef _SOCKET_H
#define _SOCKET_H

#include <sys/socket.h>

int readSocket (int fd, char *Datos, int Longitud);

int writeSocket (int fd, char *Datos, int Longitud);


#endif
