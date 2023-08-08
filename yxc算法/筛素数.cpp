#include <iostream>

using namespace std;

const int N = 1000;

int primes[N];
int cnt;
bool st[N];

void get_primes(int x)
{
	for(int i = 2; i <= x; i ++)
	{
		if(!st[i]) primes[cnt ++] = i;
		
		for(int j = 0; primes[j] * i <= x; j ++)
		{
			st[primes[j] * i] = true;
			if(i % primes[j] == 0) break;
		}
	}
}

int main()
{
	get_primes(N - 1);
	
	for(int i = 0; i < cnt; i ++) cout<<primes[i]<<endl;
	
	return 0;
}

