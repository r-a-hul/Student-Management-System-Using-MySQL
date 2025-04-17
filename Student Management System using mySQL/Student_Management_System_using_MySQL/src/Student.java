public class Student {
    private int rollNo;
    private String name;
    private String course;
    private int age;

    public Student(int rollNo, String name, String course, int age) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Course: " + course + ", Age: " + age;
    }
}

