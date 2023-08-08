#include<stdio.h>
#include<malloc.h>
#include<time.h>

typedef struct Node
{
	int data;
	struct Node * pNext;
}NODE, *PNODE;

PNODE creat_list()  //初始化创建
{
	PNODE pHead = (PNODE)malloc(sizeof(NODE));
	if(pHead == NULL){
		printf("分配失败");
		exit(0);
	}
	PNODE pTail = pHead;
	pTail -> pNext = NULL;
	
	srand(time(0));
	for(int i = 0; i < 10; i ++){
		PNODE pNew = (PNODE)malloc(sizeof(NODE));
		
		pNew -> data = /*rand() % 100 + 1*/ i + 1;
		pTail -> pNext = pNew;
		pNew -> pNext = NULL;
		pTail = pNew;
	}
	
	return pHead;
}
void traverse_list(PNODE list)  //遍历
{
	PNODE p = list -> pNext;
	while(p){
		printf("%d ", p -> data);
		p = p -> pNext;
	}
	
	printf("\n");
}
int length(PNODE list)  //求长度
{
	int len = 0;
	PNODE p = list -> pNext;
	while(p){
		len ++;
		p = p -> pNext;
	}

	return len;
}

void sort_list(PNODE list)
{
	PNODE i, j;
	for(i = list -> pNext; i; i = i -> pNext){
		for(j = i -> pNext; j; j = j -> pNext){
			if(i -> data > j -> data){
				int t = i -> data;
				i -> data = j -> data;
				j -> data = t;
			}
		}
	}
}
bool insert_list(PNODE list, int pos, int val)
{
	int i = 1;  //计数器
	PNODE p = list -> pNext;
	
	while(i < pos - 1 && p){
		i ++;
		p = p -> pNext;
	}
	
	if(i > pos - 1 || !p) return false;
	
	PNODE pNew = (PNODE)malloc(sizeof(NODE));
	if(pNew == NULL){
		printf("分配失败");
		exit(0);
	}
	pNew -> data = val;
	pNew -> pNext = p -> pNext;
	p -> pNext = pNew;
	
	return true;
}
bool delete_list(PNODE list, int pos, int * val)
{
	int i = 1;
	PNODE p = list -> pNext;
	
	while(i < pos - 1 && p){
		i ++;
		p = p -> pNext;
	}
	
	if(i > pos - 1 || !p) return false;
	
	PNODE q = p -> pNext;
	*val = q -> data;
	p -> pNext = p -> pNext -> pNext;
	free(q);
	q = NULL;
	
	return true;
}

int main()
{
	PNODE list = NULL;
	list = creat_list();
	printf("链表长度为：%d\n", length(list));
	traverse_list(list);
	//sort_list(list);
	insert_list(list, 2, 99);
	traverse_list(list);
	int val;
	delete_list(list, 2, &val);
	printf("删除的数据为%d\n", val);
	traverse_list(list);
	return 0;
}
