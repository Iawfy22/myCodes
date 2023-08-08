#include<bits/stdc++.h>

using namespace std;

bool cmp(vector<int> &a,vector<int> &b)
{
	if(a.size()!=b.size()) return a.size()>b.size();
	else{
		for(int i=a.size()-1;i>=0;i--){
			if(a[i]!=b[i]) return a[i]>b[i];
		}
	}
}
vector<int> sub(vector<int> &a,vector<int> &b)
{
	int t=0;
	vector<int> c;
	for(int i=a.size()-1;i>=0;i--){
		t=a[i]-t;
		if(i<b.size()) t-=b[i];
		c.push_back((t+10)%10);
		
		if(t<0) t=1;
		else t=0;
	}
	
	while(c.size()>1&&c.back()==0) c.pop_back();
	return c;
}
int main()
{
	string a,b;
	vector<int> A,B;
	
	cin>>a>>b;
	for(int i=a.size()-1;i>=0;i--) A.push_back(a[i]-'0');
	for(int i=b.size()-1;i>=0;i--) B.push_back(b[i]-'0');
	
	if(cmp(A,B)){
		auto C=sub(A,B);
		for(int i=C.size()-1;i>=0;i--) printf("%d",C[i]); 
	}else{
		printf("-");
		auto C=sub(B,A);
		for(int i=C.size()-1;i>=0;i--) printf("%d",C[i]);
	}
	return 0;
}
