#include <iostream>

using namespace std;

int cnt;

void hannuota(int n, char A, char B, char C)  //从A柱子借助B柱子移到C柱子
{
	/*
	  if n 为1
		  直接把盘子从A柱子移到C柱子
	  else
		  把n - 1个盘子从A借助C移到B
		  把第n个盘子从A直接移到C
		  把n - 1个盘子从B借助A移到C
	 */
	
	if(n == 1){
		printf("把编号为%d的盘子从%c柱子移到%c柱子\n", n, A, C);
		cnt ++;
	}
	else{
		hannuota(n - 1, A, C, B);
		printf("把编号为%d的盘子从%c柱子移到%c柱子\n", n, A, C), cnt ++;
		hannuota(n - 1, B, A, C);
	}
}

int main()
{
	char ch1 = 'A', ch2 = 'B', ch3 = 'C';
	int n;
	cin>>n;
	
	hannuota(n, ch1, ch2, ch3);
	
	cout << "移动总次数为：" << cnt << endl;
	return 0;
}
