package dataStructure;

public class Student {		               //Student类
    private String ID;                    	//学号，子类私有成员变量
    private String name;					//姓名，子类私有成员变量
    private int	age;						//年龄，子类私有成员变量
    private String speciality;            	//专业，子类私有成员变量
    private float score;                    //成绩，子类私有成员变量

    public Student(String ID, String name, int age, String spec, float score) {
        this.ID = ID;
        this.name = name;                     
        this.age = age;
        this.speciality = spec;
        this.score = score;
    } 

    public Student(String ID) {
        this(ID,"", 0, "",0);                     
    } 

    public void setID(String ID) {
        if (ID==null)
            this.ID = "";
        else
            this.ID = ID;
    }

    public void setName(String name) {
        if (name==null)
            this.name = "";
        else
            this.name = name;
    }

    public void setAge(int age) {
            this.age = age;
    }

    public void setSpeciality(String spec) {
        if (spec==null)
            this.speciality = "";
        else
            this.speciality = spec;
    }

    public void setScore(float score) {
            this.score = score;
    }

    public String getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public int getAge()	{
        return this.age;
    }

    public String getSpeciality() {
        return this.speciality;
    }

    public float getScore()	{
        return this.score;
    }

    public String toString() {
        return ID + "\t" + name + "\t" + age + "\t" + speciality + "\t" + score;  //调用父类的同名方法
    }

    public boolean equals(Object obj) {
        if (obj  instanceof  Student) 
        {
            Student stu = (Student)obj;
            return this.ID.equals(stu.ID);
        }
        return false;
    }
    
    public String getKey() {
    	return ID;
    }
}
