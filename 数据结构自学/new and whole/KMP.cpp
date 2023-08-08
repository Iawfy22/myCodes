#include <stdio.h>
#include <stdlib.h>

typedef struct String
{
	char* data;
	int len;
}String, *pString;

pString initString()
{
	pString s = (pString)malloc(sizeof(String));
	s -> data = NULL;
	s -> len = 0;
	
	return s;
}
void stringAssign(pString s, char* data)
{
	if(s -> data) free(s -> data);
	
	char* temp = data;
	int len = 0;
	while(*temp) temp ++, len ++;
	
	if(len == 0){
		s -> data = NULL;
		s -> len = 0;
	}
	else{
		temp = data;
		s -> len = len;
		s -> data = (char*)malloc(sizeof(char) * (len + 1));
		for(int i = 0; i < len; i ++, temp ++) 
			s -> data[i] = *temp;
	}
	
}
void printString(pString s)
{
	for(int i = 0; i < s -> len; i ++)
		printf("%c ", s -> data[i]);
	
	printf("\n");
}
int* getNxet(pString s)
{
	int i = 0;   //前指针
	int j = -1;  //后指针
	int* next = (int*)malloc(sizeof(int) * s -> len);
	next[i] = j;
	
	while(i < s -> len)
	{
		if(j == -1 || s -> data[i] == s -> data[j]) i ++, j ++, next[i] = j;
		else j = next[j];
	}
	
	return next;
}
void kmpMatch(pString s, pString t, int* next)
{
	int i = 0;   //主串
	int j = 0;   //子串
	
	while(i < s -> len && j < t -> len)
	{
		if(j == -1 || s -> data[i] == t -> data[j]) i ++, j ++;
		else j = next[j];
	}
	
	if(j == t -> len){
		printf("Kmp match success, idex is %d\n", i - j);
	}
	else{
		printf("Kmp match fail\n");
	}
}

int main()
{
	pString s = initString();
	stringAssign(s, "abcdef");
	pString s1 = initString();
	stringAssign(s1, "def");
	printString(s);
	printString(s1);
	
	int* next = getNxet(s1);
	kmpMatch(s, s1, next);
	return 0;
}
