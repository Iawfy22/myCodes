#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

typedef long long LL;

LL qmi(int a, int k ,int p)
{
	LL res = 1 % p;
	while(k)
	{
		if(k & 1) res = res * a % p;
		k >>= 1;
		a = a * (LL)a % p;
	}
	
	return res;
}

int main()
{
	int a, k, p;
	scanf("%d%d%d", &a, &k, &p);
	
	LL res = qmi(a, k, p);
	cout<<res<<endl;
	return 0;
}
