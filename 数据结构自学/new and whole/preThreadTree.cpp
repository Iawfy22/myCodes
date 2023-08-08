#include <stdio.h>
#include <stdlib.h>

typedef struct treeNode
{
	char data;
	int ltag;
	int rtag;
	struct treeNode* lchild;
	struct treeNode* rchild;
}TreeNode, *pTreeNode;

void creatTree(pTreeNode* T)
{
	char ch;
	scanf("%c", &ch);
	if(ch == '#'){
		*T = NULL;
		return ;
	}
	else{
		(*T) = (pTreeNode)malloc(sizeof(TreeNode));
		(*T) -> data = ch;
		(*T) -> ltag = 0;
		(*T) -> rtag = 0;
		creatTree(&((*T) -> lchild));
		creatTree(&((*T) -> rchild));
	}
}
void preThreadTree(pTreeNode T, pTreeNode* pre)
{
	if(T)
	{
		//先办事
		if(T -> lchild == NULL){
			T -> ltag = 1;
			T -> lchild = *pre;   //已经改变了左指针的指向
		}
		if(*pre != NULL && (*pre) -> rchild == NULL){
			(*pre) -> rtag = 1;
			(*pre) -> rchild = T;
		}
		*pre = T;
		
		//遍历左右
		if(T -> ltag == 0)   //只有存在左孩子时，才会遍历，由于上方已经改变了左指针指向，所以要特判
			preThreadTree(T -> lchild, pre);
		preThreadTree(T -> rchild, pre);
	}
}
pTreeNode getNext(pTreeNode node)
{
	/*
	  if(node -> rtag == 1)   //如果右指针是后继节点
		  return node -> rchild;
	  else{
		  if(node -> ltag == 0) return node -> lchild;  //左孩子存在
		  else return node -> rhcild;   //左孩子不存在
	  
	  以上代码可以合并为下
	  }
	 */
	
	if(node -> rtag == 1 || node -> ltag == 1)  //存在后继节点  或者存在右孩子，但左孩子不存在
		return node -> rchild;
	else
		return node -> lchild;
}

int main()
{
	pTreeNode T;
	creatTree(&T);
	
	pTreeNode pre = NULL;
	preThreadTree(T, &pre);
	pre -> rchild = NULL;
	pre -> rtag = 1;
	
	for(pTreeNode node = T; node != NULL; node = getNext(node))
		printf("%c ", node -> data);
	
	return 0;
}
