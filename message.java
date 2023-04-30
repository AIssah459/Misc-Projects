package com.company;
class Person
{
    public String name;
    public int age;
    public String ssn;
    public boolean alive;
    Person()
    {}
    Person(String newName, int  newAge, String newSsn, boolean newAlive, Teacher[] listTeachers, Student[] listStudents)
    {
        name=newName;
        age=newAge;
        ssn=newSsn;
        alive=newAlive;
    }
    String getName()
    {
        return name;
    }
    int getAge()
    {
        return age;
    }
    String getSsn()
    {
        return ssn;
    }
    boolean getAlive()
    {
        return alive;
    }
    void setName(String newName)
    {
        name=newName;
    }
    void setAge(int newAge)
    {
        age=newAge;
    }
    void setSsn(String newSsn)
    {
        ssn=newSsn;
    }
    void setAlive(boolean newAlive)
    {
        alive=newAlive;
    }
}
class Student extends Person
{
    public String stu_id;
    public double gpa;
    public String grade;
    Student(){}
    Student(String newStu_id, double newGpa, String newGrade)
    {
        stu_id=newStu_id;
        gpa=newGpa;
        grade=newGrade;
    }
    String getStu_id()
    {
        return stu_id;
    }
    double getGpa()
    {
        return gpa;
    }
    String getGrade()
    {
        return grade;
    }
    void setStu_id(String newStu_id)
    {
        stu_id=newStu_id;
    }
    void setGpa(double newGpa)
    {
        gpa=newGpa;
    }
    void setGrade(String newGrade)
    {
        grade=newGrade;
    }
    public String toString()
    {
        String result = "";
        result+="Student ID: "+ stu_id +"\n";
        result+="GPA: "+ gpa +"\n";
        result+="Grade: "+ grade +"\n";
        result+="Name: "+ getName() +"\n";
        result+="Age: "+ getAge() +"\n";
        result+="SSN: "+ getSsn() +"\n";
        result+="Alive: "+ getAlive() +"\n";
        return result;
    }
}
class Teacher extends Person
{
    public String id;
    public int salary;
    public int num_yr_prof;
    Teacher(){}
    Teacher(String newId, int newSalary, int newNum_yr_Prof)
    {
        id=newId;
        salary=newSalary;
        num_yr_prof=newNum_yr_Prof;
    }
    String getId()
    {
        return id;
    }
    int getSalary()
    {
        return salary;
    }
    int getNum_yr_prof()
    {
        return num_yr_prof;
    }
    void setId(String newId)
    {
        id=newId;
    }
    void setSalary(int newSalary)
    {
        salary=newSalary;
    }
    void setNum_yr_prof(int newNum_yr_Prof)
    {
        num_yr_prof=newNum_yr_Prof;
    }
    public String toString()
    {
        String result = "";
        result+="Teacher ID: "+ id +"\n";
        result+="Salary: "+ salary +"\n";
        result+="Number of years as Professor: "+ num_yr_prof +"\n";
        result+="Name: "+ getName() +"\n";
        result+="Age: "+ getAge() +"\n";
        result+="SSN: "+ getSsn() +"\n";
        result+="Alive: "+ getAlive() +"\n";
        return result;
    }
}
class Department
{
    private String deptName;
    private int numMajors;
    private Teacher[] listTeachers;
    private Student[] listStudents;
    Department(){}
    Department(String newDeptname, int newNummajors,Teacher[] listTeachers, Student[] listStudents)
    {
        deptName=newDeptname;
        numMajors=newNummajors;
        setListTeachers(listTeachers);
        setListStudents(listStudents);
    }
    String getDeptName()
    {
        return deptName;
    }
    int getNummajors()
    {
        return numMajors;
    }
    void setDeptName(String newDeptname)
    {
        deptName=newDeptname;
    }
    void setNumMajors(int newNummajors)
    {
        numMajors=newNummajors;
    }
    void setListTeachers(Teacher[] listTeachers)
    {
        this.listTeachers= new Teacher[listTeachers.length];
        for(int i = 0; i < listTeachers.length; i++)
        {
            this.listTeachers[i]=listTeachers[i];
        }
    }
    void setListStudents(Student[] listStudents)
    {
        this.listStudents= new Student[listStudents.length];
        for(int i = 0; i < listStudents.length; i++)
        {
            this.listStudents[i]=listStudents[i];
        }
    }
    public Teacher[] getListTeachers()
    {
        Teacher[] t = new Teacher[this.listTeachers.length];
        for (int i = 0; i < this.listTeachers.length; i++) {
            t[i] = listTeachers[i];
        }
        return t;
    }
    public Student[] getListStudents()
    {
        Student[] s = new Student[this.listStudents.length];
        for (int i = 0; i < this.listStudents.length; i++) {
            s[i] = listStudents[i];
        }
        return s;
    }
    public String toString()
    {
        String result = "";
        result+="Department Name: "+ deptName +"\n";
        result+="Number of majors: "+ numMajors +"\n";
        for(int i = 0; i < this.listTeachers.length; i++)
        {
            result+="\nTeacher: \n" + listTeachers[i].toString() + "\n";
        }
        for(int i = 0; i < getListStudents().length; i++)
        {
            result+="\nStudent: \n" + listStudents[i].toString() + "\n";
        }
        return result;
    }

}
public class Main
{
    public static void main(String[] args)
    {
        Teacher[] Tlist= new Teacher[3];
        Student[] Slist= new Student[5];

        Student student1 = new Student("1010",5.0,"A");
        student1.setName("Bob");
        student1.setAge(21);
        student1.setSsn("10000000");
        student1.setAlive(true);

        Student student2 = new Student("2020",4.0,"B");
        student2.setName("Joe");
        student2.setAge(21);
        student2.setSsn("200000000");
        student2.setAlive(true);

        Student student3 = new Student("3030",3.0,"C");
        student3.setName("Zoe");
        student3.setAge(21);
        student3.setSsn("300000000");
        student3.setAlive(true);

        Student student4 = new Student("4040",5.0,"A");
        student4.setName("John");
        student4.setAge(21);
        student4.setSsn("400000000");
        student4.setAlive(true);

        Student student5 = new Student("5050",4.0,"B");
        student5.setName("Mat");
        student5.setAge(21);
        student5.setSsn("500000000");
        student5.setAlive(true);

        Teacher teacher1 = new Teacher("1010",70000,5);
        teacher1.setName("Rob");
        teacher1.setAge(40);
        teacher1.setSsn("60000000");
        teacher1.setAlive(true);

        Teacher teacher2 = new Teacher("1010",70000,5);
        teacher2.setName("Guy");
        teacher2.setAge(40);
        teacher2.setSsn("70000000");
        teacher2.setAlive(true);

        Teacher teacher3 = new Teacher("1010",70000,5);
        teacher3.setName("Rum");
        teacher3.setAge(40);
        teacher3.setSsn("8000000");
        teacher3.setAlive(true);

        Tlist[0]=teacher1;
        Tlist[1]=teacher2;
        Tlist[2]=teacher3;
        Slist[0]=student1;
        Slist[1]=student2;
        Slist[2]=student3;
        Slist[3]=student4;
        Slist[4]=student5;

        Department department1 = new Department("Math",5,Tlist,Slist);
        Department department2 = new Department("Science", 4, Tlist, Slist);
        System.out.println(department1.toString());
        System.out.println(department2.toString());
    }
}
