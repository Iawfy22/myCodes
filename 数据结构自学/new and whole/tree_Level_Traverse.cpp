#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0

typedef struct treeNode
{
	char data;
	struct treeNode* lchild;
	struct treeNode* rchild;
}treeNode;
typedef struct queueNode
{
	treeNode* data;
	struct queueNode* next;
}queueNode;

void creatTree(treeNode** T)
{
	char ch;
	scanf("%c", &ch);
	
	if(ch == '#') *T = NULL;
	else{
		*T = (treeNode*)malloc(sizeof(treeNode));
		(*T) -> data = ch;
		creatTree(&((*T) -> lchild));
		creatTree(&((*T) -> rchild));
	}
}
void preOrder(treeNode* T)
{
	if(T == NULL) return;
	else{
		printf("%c ", T -> data);
		preOrder(T -> lchild);
		preOrder(T -> rchild);
	}
}
queueNode* initQueue()
{
	queueNode* q = (queueNode*)malloc(sizeof(queueNode));
	q -> data = NULL;
	q -> next = NULL;
	
	return q;
}
void enQueue(queueNode* q, treeNode* data)
{
	queueNode* cur = q;
	while(cur -> next) cur = cur -> next;
	
	queueNode* node = (queueNode*)malloc(sizeof(queueNode));
	node -> data = data;
	node -> next = NULL;
	cur -> next = node;
	q -> data ++;
}
int isEmpty(queueNode* q)
{
	if(q -> next == NULL) return TRUE;
	else return FALSE;
}
queueNode* deQueue(queueNode* q)
{
	if(isEmpty(q)) return NULL;
	else{
		queueNode* node = q -> next;
		q -> next = q -> next -> next;
		
		return node;
	}
}
void levelTraverse(treeNode* T)
{
	queueNode* q = initQueue();
	enQueue(q, T);
	while(!isEmpty(q))
	{
		queueNode* node = deQueue(q);   //先出队
		printf("%c ", node -> data -> data);  //在打印
		if(node -> data -> lchild) enQueue(q, node -> data -> lchild);
		if(node -> data -> rchild) enQueue(q, node -> data -> rchild);
	}
}

int main()
{
	treeNode* T;
	creatTree(&T);
	preOrder(T);
	printf("\n");
	levelTraverse(T);
	return 0;
}
