#include<iostream>

using namespace std;

//¿ìËÙÅÅÐò 
void quick_sort(int a[],int l,int r)
{
	if(l>=r) return;
	int x=a[l],i=l-1,j=r+1;
	while(i<j){
		do{
			i++;
		}while(a[i]<x);
		do{
			j--;
		}while(a[j]>x);
		if(i<j){
			swap(a[i],a[j]);
		}
	}
	quick_sort(a,l,j);
	quick_sort(a,j+1,r);
}
int main()
{
	void quick_sort(int a[],int l,int r);
	int arr[1000];
	int n;
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		scanf("%d",&arr[i]);
	}
	
	quick_sort(arr,0,n-1);
	
	for(int i=0;i<n;i++){
		printf("%d ",arr[i]);
	}
	
	system("pause");
	return 0;
}

