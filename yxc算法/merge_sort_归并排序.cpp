#include<bits/stdc++.h>

using namespace std;

const int N=10000;
int n;
int a[N],temp[N];

void merge_sort(int a[],int left,int right)
{
	if(left>=right) return;
	
	int mid=(left+right)/2;
	merge_sort(a,left,mid);
	merge_sort(a,mid+1,right);
	
	int k=0,i=left,j=mid+1;
	while(i<=mid&&j<=right){
		if(a[i]>a[j]) temp[k++]=a[j++];
		if(a[i]<a[j]) temp[k++]=a[i++];
	}
	while(i<=mid) temp[k++]=a[i++];
	while(j<=right) temp[k++]=a[j++];
	
	for(i=left,j=0;i<=right;i++,j++) a[i]=temp[j];
}
int main()
{
	void merge_sort(int a[],int l,int r);
	scanf("%d",&n);
	for(int i=0;i<n;i++) scanf("%d",&a[i]);
	
	merge_sort(a,0,n-1);
	
	for(int i=0;i<n;i++) printf("%d ",a[i]);
	
	return 0;
 } 
 
 
 
