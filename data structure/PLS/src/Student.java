
public class Student extends Person{
	int num;
	String spe;

    public Student(String name, int age,int num,String spe)          //构造方法
    {
        this.name = name;
        this.age = age;
        this.num = num;
        this.spe = spe;
    } 
    public Student()          //构造方法
    {
        this.name = "";
        this.age = 0;
        this.num = 0;
        this.spe = "";
    } 

    public void setNum(int num)                 //设置成员变量值
    {
    	if(num<0)
    		this.num=0;
    	else
            this.num = num;
    }

    public void setSpe(String spe)                     //set()方法重载
    {
        if (spe==null)
         this.spe="";
        else
            this.spe = spe;
    }

    public int getNum()                      //获得成员变量值
    {
        return this.num;
    }

    public String getSpe()
    {
        return this.spe;
    }

    public String toString()                     //覆盖Object类的toString()方法
    {
        return this.name+"\t"+this.age+"\t"+this.num+"\t"+this.spe;
    }

    public boolean equals(Object obj)                 //覆盖Object类中方法
    {
        if (obj  instanceof  Person) 
        {
            Student p2 = (Student)obj;
            return this.num==p2.num;
        }
        return false;
    }
}
