
public class Student extends Person{
	int num;
	String spe;

    public Student(String name, int age,int num,String spe)          //���췽��
    {
        this.name = name;
        this.age = age;
        this.num = num;
        this.spe = spe;
    } 
    public Student()          //���췽��
    {
        this.name = "";
        this.age = 0;
        this.num = 0;
        this.spe = "";
    } 

    public void setNum(int num)                 //���ó�Ա����ֵ
    {
    	if(num<0)
    		this.num=0;
    	else
            this.num = num;
    }

    public void setSpe(String spe)                     //set()��������
    {
        if (spe==null)
         this.spe="";
        else
            this.spe = spe;
    }

    public int getNum()                      //��ó�Ա����ֵ
    {
        return this.num;
    }

    public String getSpe()
    {
        return this.spe;
    }

    public String toString()                     //����Object���toString()����
    {
        return this.name+"\t"+this.age+"\t"+this.num+"\t"+this.spe;
    }

    public boolean equals(Object obj)                 //����Object���з���
    {
        if (obj  instanceof  Person) 
        {
            Student p2 = (Student)obj;
            return this.num==p2.num;
        }
        return false;
    }
}
