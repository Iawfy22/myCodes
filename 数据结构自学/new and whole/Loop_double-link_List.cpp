#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0

typedef struct NODE
{
	int data;
	struct NODE* pre;
	struct NODE* next;
}Node, *pNode;

pNode initList()
{
	pNode node = (pNode)malloc(sizeof(Node));
	
	node -> data = 0;
	node -> pre = node;
	node -> next = node;
	
	return node;
}
void headInsert(pNode L, int data)
{
	pNode node = (pNode)malloc(sizeof(Node));
	node -> data = data;
	
	if(L -> next){  //链表非空
		node -> next = L -> next;
		node -> pre = L;
		L -> next -> pre = node;   //注意顺序不能调换
		L -> next = node;
	}
	else{   //链表为空
		node -> next = L;
		node -> pre = L;
		L -> next = node;
		L -> pre = node;
	}
}
void tailInsert(pNode L, int data)
{
	pNode cur = L;
	while(cur -> next != L) cur = cur -> next;
	
	pNode node = (pNode)malloc(sizeof(Node));
	node -> data = data;
	node -> pre = cur;
	node -> next = L;
	L -> pre = node;
	cur -> next = node;
}
int delet(pNode L, int data)
{
	pNode node = L -> next;
	while(node != L)
	{
		if(node -> data == data){
			node -> pre -> next = node -> next;
			node -> next -> pre = node -> pre;
			free(node);
			
			return TRUE;
		}	
		
		node = node -> next;
	}
	
	return FALSE;
}
void printfList(pNode L)
{
	pNode node = L -> next;
	while(node != L)
	{
		printf("%d -> ", node -> data);
		node = node -> next;
	}
	printf("NULL\n");
}

int main()
{
	pNode L = initList();
	headInsert(L, 1);
	headInsert(L, 2);
	headInsert(L, 3);
	printfList(L);
	tailInsert(L, 4);
	tailInsert(L, 5);
	tailInsert(L, 6);
	printfList(L);
	delet(L, 3);
	delet(L, 6);
	delet(L, 1);
	printfList(L);
	return 0;
}
