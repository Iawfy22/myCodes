#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0

typedef struct NODE
{
	int data;
	struct NODE* next;
}Node, *pNode;

pNode initStack()
{
	pNode S = (pNode)malloc(sizeof(Node));
	
	S -> data = 0;
	S -> next = NULL;
	
	return S;
}
int isEmpty(pNode S)
{
	if(S -> next == NULL) return TRUE;
	else return FALSE;
}
int getTop(pNode S)
{
	if(isEmpty(S)) return -1;
	else return S -> next -> data;
}
int pop(pNode S)
{
	if(isEmpty(S)) return FALSE;
	else{
		pNode node = S -> next;
		S -> next = node -> next;
		free(node);
		S -> data --;
		
		return TRUE;
	}
}
void push(pNode S, int data)
{
	pNode node = (pNode)malloc(sizeof(Node));
	node -> data = data;
	node -> next = S -> next;
	S -> next = node;
	S -> data ++;
}
void printfStack(pNode S)
{
	pNode node = S -> next;
	while(node)
	{
		printf("%d -> ", node -> data);
		node = node -> next;
	}
	printf("NULL \n");
}
int main()
{
	pNode S = initStack();
	push(S, 1);
	push(S, 2);
	push(S, 3);
	push(S, 4);
	push(S, 5);
	printfStack(S);
	printf("%d\n", getTop(S));
	pop(S);
	printfStack(S);
	printf("%d\n", getTop(S));
	
	return 0;
}
