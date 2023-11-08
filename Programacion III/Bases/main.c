#include <stdio.h>  
#include <stdlib.h>
#include <time.h>

int main () {
system("clear");
char name[30];
short int age;
printf("Nombre    :");
fgets(name, 30 , stdin);
printf("Edad…..");
scanf("%",&age);
printf("Hola % tienes % eres % /n" , name, age, age>=18 "Mayor":"menor");

system("cls");
srand(time(NULL));
for (int i=0;i<50; ++i){
printf("(%d)\\t \\n", rand() %21+10);
}
return 0;
}