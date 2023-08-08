#include <stdio.h>
#include <stdlib.h>

/*实现二叉树非递归遍历*/

#define TRUE 1
#define FALSE 0

typedef struct treeNode
{
	char data;
	struct treeNode* lchild;
	struct treeNode* rchild;
	int flag;   //标记是否被访问过 1为访问过 0为没访问
}treeNode, *ptreeNode;

typedef struct stackNode
{
	ptreeNode data;
	struct stackNode* next;
}stackNode, *pstackNode;

void creatTree(ptreeNode* T)
{
	char ch;
	scanf("%c", &ch);
	
	if(ch == '#') *T = NULL;
	else{
		*T = (ptreeNode)malloc(sizeof(treeNode));
		(*T) -> data = ch;
		(*T) -> flag = 0;  //0为没有访问过
		creatTree(&((*T) -> lchild));
		creatTree(&((*T) -> rchild));
	}
}
pstackNode initStack()
{
	pstackNode s = (pstackNode)malloc(sizeof(stackNode));
	s -> data = 0;
	s -> next = NULL;
	
	return s;
}
void push(pstackNode s, ptreeNode t)
{
	pstackNode node = (pstackNode)malloc(sizeof(stackNode));
	node -> data = t;
	node -> next = s -> next;
	s -> next = node;
}
int isEmpty(pstackNode s)
{
	if(s -> next == NULL) return TRUE;
	else return FALSE;
}
pstackNode pop(pstackNode s)
{
	if(isEmpty(s)) return NULL;
	else{
		pstackNode node = s -> next;
		s -> next = node -> next;
		
		return node;
	}
}
pstackNode getTop(pstackNode s)
{
	if(s -> next == NULL) return NULL;
	else return s -> next;
}
/*
  前序遍历——借助栈
  
  入栈左遍历，出栈右遍历  压栈访问元素
  基本顺序：
  1.入栈根节点，访问元素
  2.循环入栈，访问元素，直到左孩子为空
  3.出栈，并且入栈右孩子，访问元素
 */
void preOrder(ptreeNode T)
{
	ptreeNode node = T;
	pstackNode s = initStack();
	
	while(node || !isEmpty(s))
	{
		if(node){  //如果不空 先访问，再入栈，再遍历左孩子
			printf("%c ", node -> data);  //访问
			push(s, node);  //入栈
			node = node -> lchild;  //遍历左孩子
		}
		else{  //如果为空 先出栈 再遍历右孩子
			node = pop(s) -> data;
			node = node -> rchild;
		}
	}
}
/*
  中序遍历——借助栈
  
  入栈左遍历，出栈右遍历  出栈访问元素
  基本顺序：
  1.入栈根节点
  2.循环入栈，直到左孩子为空
  3.出栈，访问节点  并且入栈右孩子
  
 */
void inOrder(ptreeNode T)
{
	ptreeNode node = T;
	pstackNode s = initStack();
	
	while(node || !isEmpty(s))
	{
		if(node){  //如果节点非空  入栈，遍历左孩子
			push(s, node);
			node = node -> lchild;
		}
		else{   //如果节点为空 出栈，访问节点，右孩子压栈
			node = pop(s) -> data;
			printf("%c ", node -> data);
			node = node -> rchild;
		}
	}
	
}
/*
  后序遍历
  
  基本顺序：
  1.从根节点开始，寻找最左边的节点，并依次入栈
  2.出栈前，判断栈顶元素是否有右子树，如果有，则将右子树入栈
    ！！！！并且还要判断右子树是否被访问过
 */
void postOrder(ptreeNode T)
{
	ptreeNode node = T;
	pstackNode s = initStack();
	
	while(node || !isEmpty(s))
	{
		if(node){  //如果节点不为空 则入栈，循环遍历左儿子
			push(s, node);
			node = node -> lchild;
		}
		else{   //如果节点为空 讨论是出栈还是右儿子压栈
			ptreeNode top = getTop(s) -> data;   //先找到栈顶元素
			if(top -> rchild && top -> rchild -> flag == 0){  //右儿子不空且没有访问过
				top = top -> rchild;  //右儿子入栈
				push(s, top);
				node = top -> lchild;   //遍历访问右儿子的左儿子
			}
			else{   //右儿子不存在或者被访问过——该点出栈
				top = pop(s) -> data;
				printf("%c ", top -> data);
				top -> flag = 1;  //状态更新
			}
		}
	}
}

int main()
{
	ptreeNode T;
	creatTree(&T);
	preOrder(T);
	printf("\n");
	inOrder(T);
	printf("\n");	
	postOrder(T);
}
