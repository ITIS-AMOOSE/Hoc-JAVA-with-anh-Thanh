class Student{
    private String name;
    private int age;
    private String address;
    private double math;
    private double literature;
    private double english;

    public Student(String name, int age, String address, double math, double literature, double english) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.math = math;
        this.literature = literature;
        this.english = english;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getAddress() { return address; }
    public double getMath() { return math; }
    public double getLiterature() { return literature; }
    public double getEnglish() { return english; }

    public double average(){
        return (this.math + this.literature + this.english) / 3.0;
    }

    public String rank(){
        double average = average();
        if(average >= 8.0) return "Xuat Sac";
        else if(average >= 7.0) return "Gioi";
        else if(average >= 6.0) return "Kha";
        else if(average >= 5.0) return "Trung Binh";
        else return "Yeu";
    }
}

class StudentManger{

}