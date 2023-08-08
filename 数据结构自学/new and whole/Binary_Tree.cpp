#include <stdio.h>
#include <stdlib.h>

typedef struct BinaryTree
{
	char data;
	struct BinaryTree* lchild;
	struct BinaryTree* rchild;
}bTree;

void creatTree(bTree** T)    //因为一个数是一级指针，想要改变其内容
{						     // 所以要传入树的地址，是个二级指针
	char data;
	scanf("%c", &data);
	if(data == '#'){
		*T = NULL;
		return ;
	}
	else{
		*T = (bTree*)malloc(sizeof(bTree));
		(*T) -> data = data;
		creatTree(&((*T) -> lchild));  //一棵树的左右子树也是个树，所以遍历建树
		creatTree(&((*T) -> rchild));
	}
}
void preOrder(bTree* T)
{
	if(T == NULL) return;
	else{
		printf("%c ", T -> data);
		preOrder(T -> lchild);
		preOrder(T -> rchild);
	}
}
void inOrder(bTree* T)
{
	if(T == NULL) return ;
	else{
		inOrder(T -> lchild);
		printf("%c ", T -> data);
		inOrder(T -> lchild);
	}
}
void postOrder(bTree* T)
{
	if(T == NULL) return;
	else{
		postOrder(T -> lchild);
		postOrder(T -> rchild);
		printf("%c ", T -> data);
	}
}

int main()
{
	bTree* T;
	creatTree(&T);
	printf("前序遍历：");
	preOrder(T);
	printf("\n");
	printf("中序遍历：");
	inOrder(T);
	printf("\n");
	printf("后序遍历：");
	postOrder(T);
	printf("\n");
	
	return 0;
}
