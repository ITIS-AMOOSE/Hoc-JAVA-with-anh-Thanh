package baitap.buoi3.Service;

import baitap.buoi3.model.*;

import java.util.Scanner;

public class AddService {
    private final ProductService productService;
    public AddService(ProductService productService){ this.productService = productService; }

    public void run(Scanner sc){

        System.out.println("Chọn loại: 1) Vở ghi  2) Bút chì  3) Bút mực  4) Sách");
        String c = sc.nextLine().trim();

        System.out.print("Tên: "); String ten = sc.nextLine();
        System.out.print("Giá bán: "); long gia = Long.parseLong(sc.nextLine());
        System.out.print("Thương hiệu: "); String th = sc.nextLine();

        switch (c) {
            case "1" -> {
                System.out.print("Số trang: "); int soTrang = Integer.parseInt(sc.nextLine());
                System.out.print("Màu bìa: "); String mauBia = sc.nextLine();
                System.out.print("Chất liệu giấy: "); String clg = sc.nextLine();
                System.out.print("Loại vở: "); String loaiVo = sc.nextLine();
                System.out.print("Kích thước (A4/A5/A6): "); String kt = sc.nextLine();
                productService.add(new NoteBook(ten, gia, th, soTrang, mauBia, clg, loaiVo, kt));
            }
            case "2" -> {
                System.out.print("Màu sắc: "); String ms = sc.nextLine();
                System.out.print("Chất liệu: "); String cl = sc.nextLine();
                System.out.print("Độ cứng: "); String dc = sc.nextLine();
                productService.add(new Pencil(ten, gia, th, ms, cl, dc));
            }
            case "3" -> {
                System.out.print("Màu sắc: "); String ms = sc.nextLine();
                System.out.print("Chất liệu: "); String cl = sc.nextLine();
                System.out.print("Loại mực: "); String lm = sc.nextLine();
                System.out.print("Độ mịn: "); String dm = sc.nextLine();
                productService.add(new Pen(ten, gia, th, ms, cl, lm, dm));
            }
            case "4" -> {
                System.out.print("Thể loại: "); String tl = sc.nextLine();
                System.out.print("Tác giả: "); String tg = sc.nextLine();
                System.out.print("Nhà XB: "); String nxb = sc.nextLine();
                System.out.print("Năm XB: "); String nam = sc.nextLine();
                System.out.print("Ngôn ngữ: "); String nn = sc.nextLine();
                productService.add(new Book(ten, gia, th, tl, tg, nxb, nam, nn));
            }
            default -> System.out.println("Không hợp lệ!");
        }
        System.out.println("Đã thêm!");
    }
}
