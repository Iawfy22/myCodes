#include <stdio.h>
#include <stdlib.h>

#define TRUE 1;
#define FALSE 0;

typedef struct NODE
{
	int data;
	struct NODE* next;
}Node, *pNode;

pNode initList()
{
	pNode head = (pNode)malloc(sizeof(Node));
	head -> data = 0;   //头节点数据域存放链表长度
	head -> next = NULL;
	
	return head;
}
void headInsert(pNode List, int data)
{
	pNode node = (pNode)malloc(sizeof(Node));  //开创节点
	node -> data = data;    //新节点数据处理
	node -> next = List -> next;   //头插法
	List -> next = node;
	List -> data ++;  //链表长度增加
}
void tailInsert(pNode List, int data)
{
	// 寻找尾节点
	pNode pre = List;
	pNode cur = List -> next;
	while(cur)
	{
		pre = cur;
		cur = cur -> next;   //cur永远是pre的下一个节点
	}
	
	pNode node = (pNode)malloc(sizeof(Node));
	node -> data = data;
	node -> next = NULL;
	pre -> next = node;
	List -> data ++;
}
int delet(pNode List, int data)
{
	pNode pre = List;
	pNode node = List -> next;  //node永远是pre的下一个节点
	while(node)
	{
		if(node -> data == data){
			pre -> next = node -> next;
			free(node);
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
	while(node)
	{
		printf("%d ", node -> data);
		node = node -> next;
	}
	printf("\n");
}

int main()
{
	pNode List = initList();
	headInsert(List, 1);
	headInsert(List, 2);
	headInsert(List, 3);
	tailInsert(List, 4);
	tailInsert(List, 5);
	tailInsert(List, 6);
	printfList(List);
	delet(List, 5);
	delet(List, 3);
	printfList(List);
	
	return 0;
}
