package baitap.buoi3.Service;

import baitap.buoi3.model.ProductBase;

import java.util.Scanner;

public class UpdateService {
    private final ProductService productService;
    public UpdateService(ProductService productService){ this.productService = productService; }

    public void run(Scanner sc){

        System.out.print("Nhập ID sản phẩm cần cập nhật: ");
        String id = sc.nextLine().trim();
        ProductBase p = productService.findById(id);
        if (p == null) { System.out.println("Không tìm thấy!"); return; }

        System.out.println("Đang sửa: " + p.getTen() + " (" + p.getLoai().toString() + ")");
        System.out.print("Tên mới (Enter = giữ nguyên): "); String ten = sc.nextLine();
        System.out.print("Giá mới (Enter = giữ nguyên): "); String giaStr = sc.nextLine();
        System.out.print("Thương hiệu mới (Enter = giữ nguyên): "); String th = sc.nextLine();

        Long gia = null;
        if (!giaStr.isBlank()) try { gia = Long.parseLong(giaStr); } catch (NumberFormatException ignored){}

        boolean ok = productService.updateCore(id, ten.isBlank()?null:ten, gia, th.isBlank()?null:th);
        System.out.println(ok ? "Đã cập nhật." : "Cập nhật thất bại.");
    }
}
