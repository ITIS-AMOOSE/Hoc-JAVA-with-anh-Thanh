package baitap.buoi3.Seed;

import baitap.buoi3.model.*;
import java.util.ArrayList;
import java.util.List;

public class Seeder {
    public static List<ProductBase> seedProducts() {
        List<ProductBase> products = new ArrayList<>();

        products.add(new Pencil("Bút chì", 5000, "Thiên Long",
                "Đen", "Gỗ", "HB"));

        products.add(new Pen("Bút mực", 10000, "Thiên Long",
                "Đen", "Nhựa", "Mực dầu", "0.5mm"));

        products.add(new Book("Sách Kí Ức Đen", 50000, "Kim Đồng",
                "Tiểu thuyết", "Nguyễn Nhật Ánh", "Kim Đồng", "2010", "Tiếng Việt"));
        products.add(new Book("Why I am gay?", 100000, "NXB Trẻ",
                "Kỹ năng sống", "NTT", "NXB Trẻ", "2024", "Tiếng Việt"));

        products.add(new NoteBook("Vở Campus A5 200 trang", 12000, "Campus",
                200, "Đỏ", "Giấy trắng", "Kẻ ngang", "A5"));

        return products;
    }
}
