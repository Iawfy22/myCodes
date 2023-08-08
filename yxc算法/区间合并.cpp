#include<bits/stdc++.h>

using namespace std;

typedef pair<int,int> PII;

int n;
vector<PII> as;

void hb(vector<PII> &as)
{
    vector<PII> res;
    sort(as.begin(),as.end());
    int st=-2e9,ed=-2e9;
    for(auto a: as){
        if(ed<a.first){
            if(st!=-2e9) res.push_back({st,ed});
            st=a.first;
            ed=a.second;
        }else{
            ed=max(ed,a.second);
        }
    }
    
    if(st!=-2e9) res.push_back({st,ed});
    as=res;
}
int main()
{
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        int l,r;
        cin>>l>>r;
        as.push_back({l,r});
    }
    
    //sort(as.begin(),as.end());
    hb(as);
    
    cout<<as.size()<<endl;
    return 0;
}
