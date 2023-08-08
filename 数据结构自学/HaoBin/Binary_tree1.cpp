#include <stdio.h>
#include<malloc.h>

typedef struct BTNode  //二叉树节点
{
	char data;
	struct BTNode * pLchild;  //p 是指针 L是左 child是孩子
	struct BTNode * pRchild;  //p 是指针 R是右 child是孩子
}BTNODE, *pBTNODE;

pBTNODE creatBT()
{
	pBTNODE pA = (pBTNODE)malloc(sizeof(BTNODE));
	pBTNODE pB = (pBTNODE)malloc(sizeof(BTNODE));
	pBTNODE pC = (pBTNODE)malloc(sizeof(BTNODE));
	pBTNODE pD = (pBTNODE)malloc(sizeof(BTNODE));
	pBTNODE pE = (pBTNODE)malloc(sizeof(BTNODE));
//	pBTNODE pF = (pBTNODE)malloc(sizeof(BTNODE));
//	pBTNODE pG = (pBTNODE)malloc(sizeof(BTNODE));
//	pBTNODE pH = (pBTNODE)malloc(sizeof(BTNODE));
	
	pA -> data = 'A';
	pB -> data = 'B';
	pC -> data = 'C';
	pD -> data = 'D';
	pE -> data = 'E';
//	pF -> data = 'F';
//	pG -> data = 'G';
//	pH -> data = 'H';
	
	pA -> pLchild = pB;
	pA -> pRchild = pC;
	pB -> pLchild = pB -> pRchild = NULL;
//	pB -> pRchild = pE;
	pC -> pLchild = pD;
	pC -> pRchild = NULL;
	pD -> pLchild = NULL;
	pD -> pRchild = pE;
	pE -> pLchild = pE -> pRchild = NULL;
//	pF -> pLchild = pH;
//	pF -> pRchild = NULL;
//	pG -> pLchild = pF -> pRchild = NULL;
//	pH -> pLchild = pH -> pRchild = NULL;
	
	return pA;
}

void PreTraverseBTree(pBTNODE pBT)
{	
	if(pBT == NULL) return ;  //递归结束条件
	
	printf("%c ", pBT -> data);  //先访问根
	PreTraverseBTree(pBT -> pLchild);  //再先序访问左子树
	PreTraverseBTree(pBT -> pRchild);  //再先序访问右子树
	
	//递归！！！
}
void InTraverseBTree(pBTNODE pBT)
{
	if(pBT == NULL) return ;
	
	InTraverseBTree(pBT -> pLchild);  //先中序访问左子树
	printf("%c ", pBT -> data);   //再访问根节点
	InTraverseBTree(pBT -> pRchild);  //再中序访问右子树
}
void PostTraverseBTree(pBTNODE pBT)
{
	if(pBT == NULL) return ;
	
	PostTraverseBTree(pBT -> pLchild);  //先中序访问左子树
	PostTraverseBTree(pBT -> pRchild);  //再中序访问右子树	
	printf("%c ", pBT -> data);   //最后访问根节点
}

int main()
{
	pBTNODE pBT = creatBT();
	printf("----------------------\n");
	printf("前序遍历：");
	PreTraverseBTree(pBT);
	printf("\n----------------------\n");
	printf("中序遍历：");
	InTraverseBTree(pBT);
	printf("\n----------------------\n");
	printf("后序遍历：");
	PostTraverseBTree(pBT);
	printf("\n----------------------\n");
	return 0;
}
