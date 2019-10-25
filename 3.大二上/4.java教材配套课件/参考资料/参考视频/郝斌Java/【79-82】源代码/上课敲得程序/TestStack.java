int[] data = new int[6];
int cnt = 0;//cnt表示的是数组有效元素的个数

public void push(int val)
{
	data[cnt] = val;
	++cnt;
}

public int pop()
{
	int Key = data[cnt-1];
	--cnt;
	
	return Key;
}