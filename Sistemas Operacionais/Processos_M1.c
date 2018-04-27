#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
//#include <sys/wait.h>
#include <sys/time.h>
#include <sys/resource.h>
#include <time.h>
#include <string.h>
#include <fcntl.h>

#define MAX_WORD 10
#define MAX_CHAR 100

//--------------------------------------------------------
void remove_endOfLine(char line[])
{

    int i =0;
    while(line[i] != '\n')
    i++;

    line[i] = '\0';
}
//-------------------------------------------------------
void read_line(char line[])
{

    char* ret = fgets(line,MAX_CHAR,stdin);

    remove_endOfLine(line);

    if(strcmp(line,"exit") == 0 || ret == NULL)
    {
        exit(0);
    }

}
//--------------------------------------------------------
int process_line(char* args[], char line[])
{

    int i =0;
    args[i] = strtok(line," ");

    if(args[i] == NULL)
    {
        printf("NO COMMAND\n");
        return 1;
    }

    while(args[i] != NULL)
    {
        i++;
        args[i] = strtok(NULL," ");
    }
    return 1;
}
//--------------------------------------------------------
int read_parse_line(char* args[], char line[])
{
    read_line(line);
    process_line(args,line);

    return 1;

}
//--------------------------------------------------------
void print_cpu_time( struct rusage usage)
{
printf("\n");

    getrusage (RUSAGE_SELF, &usage);

	printf(" /* user time used */                   %8d  %8d\n",  usage.ru_utime.tv_sec,usage.ru_utime.tv_usec   );
	printf(" /* system time used */                 %8d  %8d\n",  usage.ru_stime.tv_sec,usage.ru_stime.tv_usec   );
	printf(" /* integral shared memory size */      %8d\n",  usage.ru_ixrss           );
	printf(" /* integral unshared data  */          %8d\n",  usage.ru_idrss           );
	printf(" /* integral unshared stack  */         %8d\n",  usage.ru_isrss           );
	printf(" /* page reclaims */                    %8d\n",  usage.ru_minflt          );
	printf(" /* page faults */                      %8d\n",  usage.ru_majflt          );
	printf(" /* swaps */                            %8d\n",  usage.ru_nswap           );
	printf(" /* block input operations */           %8d\n",  usage.ru_inblock         );
	printf(" /* block output operations */          %8d\n",  usage.ru_oublock         );
	printf(" /* messages sent */                    %8d\n",  usage.ru_msgsnd          );
	printf(" /* messages received */                %8d\n",  usage.ru_msgrcv          );
	printf(" /* signals received */                 %8d\n",  usage.ru_nsignals        );
	printf(" /* voluntary context switches */       %8d\n",  usage.ru_nvcsw           );
	printf(" /* involuntary  */                     %8d\n",  usage.ru_nivcsw          );

}

int main(int argc, char *argv[])
{
    char* args[MAX_WORD];
    char line[MAX_CHAR];
    char* input = argv[1];
   	pid_t child = fork();
   	int status;
   	time_t inicio, fim,inicio2, fim2;
	float tempo,tempo2;
    inicio = time(NULL);
    inicio2 = time(NULL);
    if(child == 0){

        printf("Pid Processo filho: %d\n", getpid() );
        printf("\n");
        if (argc > 1) {
            execvp(input, &argv[1]);
            _exit(0);
        }else
        if (argc == 1) {
            printf("-----------------------------------Mod Shell------------------------------------\n\n");
            while(read_parse_line(args,line))
            {
                pid_t child = fork();
                if(child == 0){

                    execvp(args[0],args);
                }
            }
        }
    }else{
        printf("\n");
        printf("Pid Processo Pai: %d",getpid());
        printf("\n");
        struct rusage usage;
        waitpid(child,&status,0);
        printf("\n");
        printf("\nFim do processo filho: %d",child);
        fim2 = time(NULL);
        tempo2 = difftime(fim2,inicio2);
        printf("\nTempo de execuçao total processo filho :%.2f\n", tempo2) ;
        printf("\n");
        printf("\nEstatisticas:");
        print_cpu_time(usage);
        printf("\n");
        printf("\nFim do processo Pai: %d",getpid());
        printf("\n");
    }

    fim = time(NULL);
	 tempo = difftime(fim,inicio);
	printf("Tempo de execuçao total: %.2f\n", tempo) ;

    return 0;

}
//system("pwd");mostra caminho atual
