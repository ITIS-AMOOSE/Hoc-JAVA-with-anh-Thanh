public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.seed();
        java.util.Scanner sc = new java.util.Scanner(System.in);

        UI ui = new UI(lib, sc);
        ui.run();
    }
}
