package dataStructure;

public class Student {		               //Student��
    private String ID;                    	//ѧ�ţ�����˽�г�Ա����
    private String name;					//����������˽�г�Ա����
    private int	age;						//���䣬����˽�г�Ա����
    private String speciality;            	//רҵ������˽�г�Ա����
    private float score;                    //�ɼ�������˽�г�Ա����

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
        return ID + "\t" + name + "\t" + age + "\t" + speciality + "\t" + score;  //���ø����ͬ������
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
