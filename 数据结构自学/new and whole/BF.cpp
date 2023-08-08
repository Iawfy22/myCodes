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
	s -> len = 0;
	s -> data = NULL;
	
	return s;
}
void stringAssign(pString s, char* data)
{
	if(s -> data) free(s -> data);
	
	char* temp = data;
	int len = 0;
	while(*temp) len ++, temp ++;
	
	if(len == 0){
		s -> data = NULL;
		s -> len = 0;
	}
	else{
		temp = data;  //因为此时temp指向了末尾，想要使用就要重新赋值
		s -> data = (char*)malloc(sizeof(len + 1));  //因为存在'\0'，所以要+1
		s -> len = len;
		for(int i = 0; i < len; i ++, temp ++)
			s -> data[i] = *temp;
	}
}
void printString(pString s)
{
	for(int i = 0; i < s -> len; i ++)
		printf("%c ", s -> data[i]);  //骚操作 printf(i == 0? "%c ": "-> %c", s -> data[i]);
	
	printf("\n");
}
void BF(pString s, pString t)  //s为主串，t为子串  最后返回匹配第一个字符索引值
{
	int i = 0;  //主串指针
	int j = 0;  //子串指针
	
	while(i < s -> len && j < t -> len)
	{
		if(s -> data[i] == t -> data[j]) i ++, j ++;
		else i = i - j + 1, j = 0;
	}
	
	if(j == t -> len){  //此时i指向的是匹配的串的最后一个字符下标，故需 i - j
		printf("BF match success, idex is %d\n", i - j);
	}
	else{
		printf("BF match fail\n");
	}
}

int main()
{
	pString s = initString();
	stringAssign(s, "abcde");
	pString s1 = initString();
	stringAssign(s1, "hhh");
	printString(s);
	printString(s1);
	
	BF(s, s1);
	return 0;
}
