class A
{
	public void asdadadmsadwASDwq()
	{
		System.out.println("AAAA");
	}
}

class B extends A
{
	@OVerride
	public void asdadadmsadwASDwq()
	{
		System.out.println("BBBB");
	}
}

public class TestOverride
{
	public static void main(String[] args)
	{
		A aa = new B();
		aa.asdadadmsadwASDwq();
	}
}