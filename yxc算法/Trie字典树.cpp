#include<bits/stdc++.h>
using namespace std;

const int N=100010;

int son[N][26],cnt[N],idx;
char str[N];
int n;

void insert(char* str)
{
    int p=0;
    for(int i = 0; str[i]; i++){
        int u = str[i]-'a';
        if(!son[p][u]) son[p][u] = ++idx;
        p=son[p][u];
    }
    
	cnt[p]++;
}
int query(char* str)
{
    int p = 0;
    
    for(int i = 0; str[i]; i++){
        int u = str[i]-'a';
        if(!son[p][u]) return 0;
		p = son[p][u];
    }
    return cnt[p];
}
int main()
{
    scanf("%d",&n);
    
    while(n--){
        char c[2];
        scanf("%s%s",c,str);
        
        if(c[0]=='I'){
            insert(str);
        }
        if(c[0]=='Q'){
            cout<<query(str)<<endl;
        }
    }
    return 0;
}
