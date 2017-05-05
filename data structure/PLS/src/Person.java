//【例0.3】  封装的Person类。

public class Person		//源程序文件中声明为public的类只有一个，且必须与文件同名
{
    protected  String name;               //姓名，实例成员变量，保护成员
    protected  int age;                           //年龄

    public Person(String name, int age)          //构造方法
    {
        this.name = name;
        this.age = age;
    } 

    public Person()          //构造方法
    {
        this.name = "";
        this.age = 0;
    } 

    public void setName(String name)                 //设置成员变量值
    {
        if (name==null)
            this.name = "";
        else
            this.name = name;
    }

    public void setAge(int age)                     //set()方法重载
    {
        if (age>0 && age<100)
            this.age = age;
        else
            this.age = 0;
    }

    public String getName()                      //获得成员变量值
    {
        return this.name;
    }

    public int getAge()
    {
        return this.age;
    }

    public String toString()                     //覆盖Object类的toString()方法
    {
        return this.name+"\t"+this.age;
    }

    public int olderThan(Person p2)              //比较两个人的年龄
    {
        return this.age - p2.age;
    }

    public boolean equals(Object obj)                 //覆盖Object类中方法
    {
        if (obj  instanceof  Person) 
        {
            Person p2 = (Person)obj;
            return this.name.equals(p2.name) && this.age==p2.age;
        }
        return false;
    }
}

