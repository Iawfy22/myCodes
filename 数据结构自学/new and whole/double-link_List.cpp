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
	pNode head = (pNode)malloc(sizeof(Node));
	head -> data = 0;
	head -> pre = NULL;
	head -> next = NULL;
	
	return head;
}
void headINsert(pNode List, int data)
{
	pNode node = (pNode)malloc(sizeof(Node));
	node -> data = data;
	node -> pre = List;
	node -> next = List -> next;
	if(List -> next){  //判断链表是否为空——第一个元素的插入和其他元素的插入不一样
		List -> next -> pre = node;  //注意顺序
		List -> next = node;
	}
	else{
		List -> next = node;
	}
	List -> data ++;
}
void tailInsert(pNode List, int data)
{
	pNode cur = List -> next;
	while(cur -> next) cur = cur -> next;
	
	pNode node = (pNode)malloc(sizeof(Node));
	node -> data = data;
	node -> next = NULL;
	node -> pre = cur;
	cur -> next = node;
	List -> data ++;
}
int delet(pNode List, int data)
{
	pNode node = List -> next;  //因为是双链表，存在pre指针，所以只需要一个查询节点即可
	while(node)
	{
		if(node -> data == data){
			/*
			  node -> pre -> next = node -> next;
			  node -> next -> pre = node -> pre; 
			  free(node);
			  List -> data --;
			  return TRUE;       由于尾节点的next不存在，所以这种方法不能删除尾节点
			*/  
			node -> pre -> next = node -> next;
			if(node -> next){  //不是尾节点
				node -> next -> pre = node -> pre;
			}
			//是尾节点的话不用操作
			free(node);
			List -> data --;
			
			return TRUE;
		}
		node = node -> next;
	}
	
	return FALSE;
}
void printfList(pNode List)
{
	pNode node = List -> next;
	while(node)
	{
		printf("%d -> ", node -> data);
		node = node -> next;
	}
	printf("NULL\n");
}
int main()
{
	pNode List = initList();
	headINsert(List, 1);
	headINsert(List, 2);
	headINsert(List, 3);
	tailInsert(List, 4);
	tailInsert(List, 5);
	tailInsert(List, 6);
	printfList(List);
	delet(List, 6);
	delet(List, 3);
	printfList(List);
	
	return 0;
}
