#include<iostream>
#include<vector>

using namespace std;

vector<int> add(vector<int> &a,vector<int> &b)
{
	vector<int> c;
	
	int t=0;
	for(int i=0;i < a.size()|| i < b.size();i++){
		if(i<a.size()) t+=a[i];
		if(i<b.size()) t+=b[i];
		c.push_back(t%10);
		t/=10;
	}
	
	if(t) c.push_back(1);
	return c;
}
int main()
{
	string a,b;  //用string类型输入
	vector<int> A,B;  //用vector 进行储存和运算;
	
	cin>>a>>b;
	for(int i=a.size()-1;i>=0;i--) A.push_back(a[i]-'0');
	for(int i=b.size()-1;i>=0;i--) B.push_back(b[i]-'0');
	
	vector<int> C=add(A,B);
	
	for(int i=C.size()-1;i>=0;i--) printf("%d",C[i]);
	return 0;
}
