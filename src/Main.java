import java.util.Scanner;

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
            System.out.println(
                    s.getName() + " " + s.getAge() + " " + s.getAddress() + " " +
                            String.format("%.2f", s.getMath()) + " " +
                            String.format("%.2f", s.getLiterature()) + " " +
                            String.format("%.2f", s.getEnglish()) + " " +
                            String.format("%.2f", s.average()) + " " +
                            s.rank()
            );
        }
        sc.close();
    }
}