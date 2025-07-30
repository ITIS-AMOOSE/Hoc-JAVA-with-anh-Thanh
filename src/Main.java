import java.util.Scanner;

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
    private Student[] students;
    private int size = 0;

    public StudentManger(int sz){
        students = new Student[sz];
    }

    public void add(Student s){
        if(size < students.length){
            students[size++] = s;
        }
    }

    public Student get(int i){
        if(i >= 1 && i <= size){
            return students[i - 1];
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        StudentManger SM = new StudentManger(n);

        for(int i = 0; i < n; i++){
            String name =  sc.nextLine();
            int age = Integer.parseInt(sc.nextLine());
            String address = sc.nextLine();
            double math = Double.parseDouble(sc.nextLine());
            double literature = Double.parseDouble(sc.nextLine());
            double english = Double.parseDouble(sc.nextLine());

            SM.add(new Student(name,age,address,math,literature,english));
        }

        int q = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < q; i++){
            int idx = Integer.parseInt(sc.nextLine());
            Student s = SM.get(idx);
            System.out.println(s.getName());
            System.out.println(s.getAge());
            System.out.println(s.getAddress());
            System.out.println(s.getMath());
            System.out.println(s.getLiterature());
            System.out.println(s.getEnglish());
            System.out.printf("%.2f\n", s.average());
            System.out.println(s.rank());
        }
        sc.close();
    }
}