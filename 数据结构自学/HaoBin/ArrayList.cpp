#include<stdio.h>
#include<malloc.h>

struct Arr
{
	int * pBase;
	int len;
	int cnt;
	int increment;
};

bool is_full(struct Arr * parr)
{
	if(parr -> cnt == parr -> len) return true;
	else return false;
}
bool is_empty(struct Arr * parr)
{
	if(parr -> cnt == 0) return true;
	else return false;
}
void init(struct Arr * pArr, int length)
{
	pArr -> pBase = (int *)malloc(sizeof(int) * length);  //初始开辟10个单位
	if(NULL == pArr -> pBase)
	{
		printf("ERROR");
		exit(0);
	}
	else
	{
		pArr -> len = length;
		pArr -> increment = 2;
		pArr -> cnt = 0;
	}
}
void enlarge(struct Arr * parr)
{
	int * temp = (int *)malloc(sizeof(int) * parr -> len * parr ->increment);
	for(int i = 0; i < parr -> len; i ++)
		temp[i] = parr -> pBase[i];
	free(parr -> pBase);
	parr -> pBase = temp;
	
	
	if(NULL == parr -> pBase) 
	{	
		printf("ERROR");
		exit(0);
	}
}
void show(struct Arr * parr)
{
	if(is_empty(parr))  //parr已经就是地址，所以这里写parr就可以 不用再取地址
		printf("空");
	else
	{
		for(int i = 0; i < parr -> cnt; i ++)
			printf("%d ", parr -> pBase[i]);  //！！！
		printf("\n");
	}
}
void insert(struct Arr * parr, int pos, int val)
{
	if(is_full(parr)) 
	{
		enlarge((parr));
	}
	
	if(pos < 1 || pos > parr -> cnt)
	{
		printf("位置不正确\n");
		return ;
	}
	else
	{
		for(int i = parr -> cnt - 1; i >= pos - 1; i --)
			parr -> pBase[i + 1] = parr -> pBase[i];
		parr -> pBase[pos - 1] = val;
		parr -> cnt ++;
	}
}
void append(struct Arr * parr, int val)
{
	if(is_full(parr))   //满时先扩容
	{
		enlarge(parr);
	}
	
	parr -> pBase[parr -> cnt ++] = val;
}
bool delet(struct Arr * parr, int pos)
{
	if(is_empty(parr)) return false;
	else if(pos < 1 || pos > parr -> cnt) return false;
	else
	{
		for(int i = pos - 1; i < parr -> cnt - 1; i ++)
			parr -> pBase[i] = parr -> pBase[i + 1];
		parr -> cnt --;
	}
}
void sort1(struct Arr * parr)  //冒泡
{
	for(int i = 0; i < parr -> cnt - 1; i ++)
	{
		for(int j = 0; j < parr -> cnt - i - 1; j ++)
		{
			if(parr -> pBase[j] > parr -> pBase[j + 1])
			{
				int t = parr -> pBase[j];
				parr -> pBase[j] = parr -> pBase[j + 1];
				parr -> pBase[j + 1] = t;
			}
		}
	}
}
void quick_sort(int a[],int l,int r)
{
	if(l >= r) return;
	
	int x=a[l + r >> 1],i = l - 1,j = r + 1;
	while(i < j){
		do i++; while(a[i]<x);
		do j--; while(a[j]>x);
		
		if(i<j)
		{
			int t = a[i];
			a[i] = a[j];
			 a[j] = t;
		}
	}
	quick_sort(a,l,j);
	quick_sort(a,j+1,r);
}

void sort2(struct Arr * parr)
{
	quick_sort(parr -> pBase, 0, parr -> cnt - 1);
}
void inversion(struct Arr * parr)
{
	int i = 0;
	int j = parr -> cnt - 1;
	while(i < j)
	{
		int t = parr -> pBase[i];
		parr -> pBase[i] = parr -> pBase[j];
		parr -> pBase[j] = t;
		i ++, j --;
	}
}

int main()
{
	struct Arr myArr;
	init(&myArr, 5);
	append(&myArr, 1);
	append(&myArr, 4);
	append(&myArr, 7);
	insert(&myArr, 2, 99);
	append(&myArr, 3);
	append(&myArr, 4);
	append(&myArr, 100);
	append(&myArr, 12);
	show(&myArr);
	sort2(&myArr);
	show(&myArr);
	inversion(&myArr);
	show(&myArr);
	return 0;
}
