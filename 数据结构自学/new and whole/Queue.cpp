#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0

typedef struct NODE
{
	int data;
	struct NODE* next;
}Node, *pNode;

pNode initQueue()
{
	pNode Q = (pNode)malloc(sizeof(Node));
	Q -> data = 0;
	Q -> next = NULL;
	
	return Q;
}
int isEmpty(pNode Q)
{
	if(Q -> next == NULL) return TRUE;
	else return FALSE;
}
void enQueue(pNode Q, int data)   //队尾进
{
	pNode cur = Q;
	while(cur -> next) cur = cur -> next;
	
	pNode node = (pNode)malloc(sizeof(Node));
	node -> data = data;
	node -> next = NULL;
	cur -> next = node;
	Q -> data ++;
}
int deQueue(pNode Q)  //对头出
{
	if(isEmpty(Q)) return FALSE;
	else{
		pNode node = Q -> next;
		Q -> next = node -> next;
		free(node);
		Q -> data --;
		
		return TRUE;
	}
}
void printfQueue(pNode Q)
{
	pNode node = Q -> next;
	while(node)
	{
		printf("%d -> ", node -> data);
		node = node -> next;
	}
	printf("NULL\n");
}

int main()
{
	pNode Q = initQueue();
	enQueue(Q, 1);
	enQueue(Q, 2);
	enQueue(Q, 3);
	enQueue(Q, 4);
	enQueue(Q, 5);
	printfQueue(Q);
	deQueue(Q);
	deQueue(Q);
	printfQueue(Q);
	return 0;
}
