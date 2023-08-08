#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0

typedef struct NODE
{
	int data;
	struct NODE* next;
}Node, *pNode;

pNode initList()
{
	pNode node = (pNode)malloc(sizeof(Node));
	node -> data = 0;
	node -> next = node;
	
	return node;
}
void headInsert(pNode List, int data)
{
	pNode node = (pNode)malloc(sizeof(Node));
	node -> data = data;
	node -> next = List -> next;
	List -> next = node;
	List -> data ++;
}
void tailInsert(pNode List, int data)
{
	pNode cur = List;
	while(cur -> next != List)  //寻找尾节点  注意循环结束条件
	{					
		cur = cur -> next;
	}
	
	pNode node = (pNode)malloc(sizeof(Node));  //创建新节点
	node -> data = data;
	node -> next = List;
	cur -> next = node;
	List -> data ++;
}
int delet(pNode List, int data)
{
	pNode pre = List;
	pNode node = List -> next;
	while(node != List)
	{
		if(node -> data == data){
			pre -> next = node -> next;
			free(node);
			List -> data --;
			return TRUE;
		}
		
		pre = node;
		node = node -> next;
	}
	
	return FALSE;
}
void printfList(pNode List)
{
	pNode node = List -> next;
	while(node != List)
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
	tailInsert(L, 4);
	tailInsert(L, 5);
	tailInsert(L, 6);
	printfList(L);
	delet(L, 3);
	printfList(L);
	delet(L, 4);
	printfList(L);
	return 0;
}
