#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0
#define MAXSIZE 5

typedef struct CircleQueue
{
	int front;
	int rear;
	int data[MAXSIZE];
}Queue, *pQueue;

pQueue initQueue()
{
	pQueue Q = (pQueue)malloc(sizeof(Queue));
	Q -> front = Q -> rear = 0;
	
	return Q;
}
int isFull(pQueue Q)
{
	if((Q -> front - Q -> rear + MAXSIZE) % MAXSIZE == 1) return TRUE;
	else return FALSE;
}
int isEmpty(pQueue Q)
{
	if(Q -> front == Q -> rear) return TRUE;
	else return FALSE;
}
int enQueue(pQueue Q, int data)
{
	if(isFull(Q)) return FALSE;
	else{
		Q -> data[Q -> rear] = data;
		Q -> rear = (Q -> rear + 1) % MAXSIZE;
		
		return TRUE;
	}
}
int deQueue(pQueue Q)
{
	if(isEmpty(Q)) return FALSE;
	else{
		Q -> front = (Q -> front + 1) % MAXSIZE;
		return TRUE;
	}
}
void printfQueue(pQueue Q)
{
	int i = Q -> front;
	while(i != Q -> rear)
	{
		printf("%d -> ", Q -> data[i]);
		i = (i + 1) % MAXSIZE;
	}
	printf("NULL\n");
}

int main()
{
	pQueue Q = initQueue();
	enQueue(Q, 1);
	enQueue(Q, 2);
	deQueue(Q);
	enQueue(Q, 3);
	enQueue(Q, 4);
	enQueue(Q, 5);
//	printfQueue(Q);
	deQueue(Q);
	deQueue(Q);
	enQueue(Q, 6);
	enQueue(Q, 4);
	enQueue(Q, 3);
	enQueue(Q, 9);
	printfQueue(Q);
	printf("%d\n", isFull(Q));
	
	return 0;
}
