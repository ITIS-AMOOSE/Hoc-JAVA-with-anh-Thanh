package baitap.buoi3.Service;


import java.util.Scanner;

public class RemoveService {
    private final ProductService productService;
    public RemoveService(ProductService productService){ this.productService = productService; }

    public void run(Scanner sc){

        System.out.print("Nhập ID sản phẩm cần xoá: ");
        String id = sc.nextLine().trim();
        boolean ok = productService.remove(id);
        System.out.println(ok ? "Đã xoá." : "Không tìm thấy ID.");
    }
}
