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