#include <stdio.h>
#include <malloc.h>

typedef struct Node
{
	int data;
	struct Node * pNext;
}NODE, *PNODE;

typedef struct Stack
{
	PNODE pTop;
	PNODE pBottom;
}STACK, *PSTACK;

void init(PSTACK pS)
{
	pS -> pTop = (PNODE)malloc(sizeof(NODE));
	if(pS -> pTop == NULL){
		printf("分配失败");
		exit(0);
	}
	else{
		pS -> pBottom = pS -> pTop;
		pS -> pBottom -> pNext = NULL;
	}
}
void push(PSTACK pS, int val)  //压栈
{
	PNODE pNew = (PNODE)malloc(sizeof(NODE));
	pNew -> data = val;
	pNew -> pNext = pS -> pTop;
	pS -> pTop = pNew;
}
bool empty(PSTACK pS)
{
	if(pS -> pTop == pS -> pBottom) return true;
	else return false;
}
bool pop(PSTACK pS, int * pVal)
{
	if(empty(pS)) return false;
	else{
		PNODE r = pS -> pTop;
		*pVal = r -> data;
		pS -> pTop = pS -> pTop -> pNext;
		free(r);
		r -> pNext = NULL;
		
		return true;
	}
}
void traverse(PSTACK pS)
{
	PNODE p = pS -> pTop;
	while(p != pS -> pBottom)
	{
		printf("%d ", p -> data);
		p = p -> pNext;
	}
	
	printf("\n");
}
void clear(PSTACK pS)
{
	while(pS -> pTop != pS -> pBottom)
	{
		PNODE p = pS -> pTop;
		pS -> pTop = p -> pNext;
		free(p);
		p  -> pNext = NULL;
	}
}

int main()
{
	STACK stack;
	init(&stack);
	
	push(&stack, 15);
	push(&stack, 44);
	push(&stack, 36);
	push(&stack, 100);
	push(&stack, 72);
	traverse(&stack);
	
	int val;
	pop(&stack, &val);
	printf("%d\n", val);
	traverse(&stack);
	
	clear(&stack);
	if(empty(&stack)) printf("全部清空\n");
	else printf("清空失败\n");
	
	return 0;
}
