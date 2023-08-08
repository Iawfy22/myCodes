#include <stdio.h>
#include <stdlib.h>

typedef struct treeNode
{
	char data;
	struct treeNode* lchild;
	struct treeNode* rchild;
	int ltag;
	int rtag;
}treeNode;

void creatTree(treeNode** T)
{
	char ch;
	scanf("%c", &ch);
	if(ch == '#'){
		*T = NULL;
		return ;
	}
	else{
		*T = (treeNode*)malloc(sizeof(treeNode));
		(*T) -> data = ch;
		(*T) -> ltag = 0;
		(*T) -> rtag = 0;
		creatTree(&((*T) -> lchild));
		creatTree(&((*T) -> rchild));
	}
}

void inThreadTree(treeNode* T, treeNode** pre) //pre是前驱节点，且需要不停地改变，所以设置为二级指针
{
	if(T){
		inThreadTree(T -> lchild, pre);
		
		if(T -> lchild == NULL){   //处理前驱
			T -> ltag = 1;
			T -> lchild = *pre;
		}
		if(*pre != NULL && (*pre) -> rchild == NULL){  //处理前驱的后继
			(*pre) -> rtag = 1;
			(*pre) -> rchild = T;
		}
		*pre = T;
		
		inThreadTree(T  -> rchild, pre);
	}
}
treeNode* getFirst(treeNode* T)
{
	treeNode* node = T;
	while(node -> ltag == 0) node = node -> lchild;  //找到最左下方的节点
	
	return node;
}
treeNode* getNext(treeNode* T)
{
	//将每个节点看成是以此节点为根节点的树，所以遍历的下一个节点即为右儿子
	if(T -> rtag == 1) return T -> rchild; //如果右儿子为后继节点，直接返回
	else return getFirst(T -> rchild);  //如果右儿子存在，则找到右儿子最左下放的节点
}

int main()
{
	treeNode* T;
	creatTree(&T);
	
	treeNode* pre = NULL;  //线索化
	inThreadTree(T, &pre);
	pre -> rchild = NULL;
	pre -> rtag = 1;
	
	for(treeNode* node = getFirst(T); node != NULL; node = getNext(node))
	{
		printf("%c ", node -> data);
	}
	
	return 0;
}
