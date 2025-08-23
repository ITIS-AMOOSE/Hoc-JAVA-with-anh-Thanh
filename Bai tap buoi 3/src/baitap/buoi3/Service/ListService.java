package baitap.buoi3.Service;

import baitap.buoi3.model.Show;
import baitap.buoi3.model.ProductBase;
import baitap.buoi3.util.Formatters;

public class ListService {
    private final ProductService productService;
    public ListService(ProductService productService){ this.productService = productService; }

    public void run(){
        for (ProductBase p : productService.all()) {
            System.out.println("------");
            System.out.println("ID: " + p.getId());
            System.out.println("Tên: " + p.getTen());
            System.out.println("Giá: " + Formatters.vnd(p.getGiaBan()));
            System.out.println("Thương hiệu: " + p.getThuongHieu());
            System.out.println("Loại: " + p.getLoai().toString());
            for (Show a : p.attributes()) System.out.println(a.getName()+": "+a.getValue());
        }
        if (productService.all().isEmpty()) System.out.println("(Trống)");
    }
}
