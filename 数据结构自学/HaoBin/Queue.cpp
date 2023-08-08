#include <stdio.h>
#include <malloc.h>

const int LENGTH = 10;

typedef struct Queue
{
	int * pBase;
	int front;
	int rear;
}QUEUE, *PQUEUE;

void init(PQUEUE pQ)
{
	pQ -> pBase = (int *)malloc(sizeof(int) * (LENGTH + 1));  // n个长度的队列只放 n - 1 个数据 -> 便于操作
	if(NULL == pQ -> pBase){
		printf("分配失败");
		exit(0);
	}
	else{
		pQ -> front = pQ -> rear = 0;
	}
}
bool full_queue(PQUEUE pQ)
{
	if((pQ -> rear + 1) % LENGTH == pQ -> front) return true;
	else return false;
}
bool empty_queue(PQUEUE pQ)
{
	if(pQ -> rear == pQ -> front) return true;
	else return false;
}
bool en_list(PQUEUE pQ, int val)  //入队
{
	if(full_queue(pQ)) return false;
	else{
		pQ -> pBase[pQ -> rear] = val;
		pQ -> rear = (pQ -> rear + 1) % LENGTH;
		
		return true;
	}
}
void traverse(PQUEUE pQ)
{
	int i = pQ -> front;
	while(i != pQ -> rear)
	{
		printf("%d ", pQ -> pBase[i]);
		i = (i + 1) % LENGTH;
	}
	
	printf("\n");
}
bool out_queue(PQUEUE pQ, int * pVal)  //出队
{
	if(empty_queue(pQ)) return false;
	else{
		*pVal = pQ -> pBase[pQ -> front];
		pQ -> front = (pQ -> front + 1) % LENGTH;
		
		return true;
	}
}

int main()
{
	QUEUE queue;
	init(&queue);
	
	en_list(&queue, 5);
	en_list(&queue, 67);
	en_list(&queue, 0);
	en_list(&queue, 4);
	en_list(&queue, 12);
	traverse(&queue);
	
	int val;
	out_queue(&queue, &val);
	printf("%d\n", val);
	traverse(&queue);
	
	return 0;
}
