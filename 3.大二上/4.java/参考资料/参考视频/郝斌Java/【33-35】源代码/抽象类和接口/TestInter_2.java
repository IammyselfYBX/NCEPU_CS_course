class A
{
}

interface It1
{
}

interface It2 {
}

//�ӿڿ��Զ��ؼ̳У���һ���ӿڿ����ж�����ӿڣ�����һ����ֻ����һ�����࣬Java�಻�����̳У��ӿ�ȴ�����̳�
interface It3  extends It1, It2
{
}

interface It4
{
	int i = 20;
}

//һ��������ڼ̳�һ�������ͬʱʵ��һ�������ӿڣ���extends�ؼ��ֱ������implements ֮ǰ
class T  extends A implements It4,It3
{
}


class TestInter_2
{
	public static void main(String[] args)
	{
		System.out.println("�ٺ�!");
	}
}