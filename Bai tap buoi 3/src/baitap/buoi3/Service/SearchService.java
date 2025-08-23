package baitap.buoi3.Service;

import baitap.buoi3.model.Show;
import baitap.buoi3.model.ProductBase;
import baitap.buoi3.model.Show;
import baitap.buoi3.util.Formatters;
import baitap.buoi3.util.TableRenderer;
import baitap.buoi3.util.VnText;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchService {
    private final ProductService productService;
    public SearchService(ProductService productService){ this.productService = productService; }

    public void run(Scanner sc){
        System.out.print("Nhập thông tin muốn tìm kiếm: ");
        String q = sc.nextLine();

        List<ProductBase> items = search(q);

        System.out.print("Hiển thị (1) Bảng  (2) Danh sách ? ");
        String opt = sc.nextLine().trim();
        if ("1".equals(opt)) renderTable(items, q);
        else renderList(items, q);
    }

    public List<ProductBase> search(String query){
        if (query == null) query = "";
        String qn = VnText.normalize(query);
        return productService.all().stream().filter(p -> {
            String joined = (p.getTen()+" "+p.getThuongHieu()+" "+p.getLoai().toString()+" "+p.getGiaBan()+" "+
                    p.attributes().stream().map(a -> a.getName()+" "+a.getValue()).collect(Collectors.joining(" ")))
                    .toLowerCase(Locale.ROOT);
            String hay = VnText.normalize(joined);
            for (String t : qn.split("\\s+")) if (!t.isBlank() && !hay.contains(t)) return false;
            return true;
        }).collect(Collectors.toList());
    }

    private void renderList(List<ProductBase> items, String q){
        System.out.println("Kết quả tìm kiếm"+(q==null||q.isBlank()?"":": "+q));
        if (items.isEmpty()) { System.out.println("(Không có kết quả)"); return; }
        for (ProductBase p : items) {
            System.out.println("------");
            System.out.println("Tên: " + p.getTen());
            System.out.println("Giá: " + Formatters.vnd(p.getGiaBan()));
            System.out.println("Thương hiệu: " + p.getThuongHieu());
            for (Show a : p.attributes()) System.out.println(a.getName()+": "+a.getValue());
        }
    }

    private void renderTable(List<ProductBase> items, String q){
        String[] headers = {"Tên sản phẩm","Giá bán","Thương hiệu","Thông tin thêm"};
        TableRenderer t = new TableRenderer(headers, new int[]{28,12,18,56});
        for (ProductBase p : items) {
            String info = p.attributes().stream()
                    .map(a -> "- " + a.getName() + ": " + a.getValue())
                    .collect(Collectors.joining("\n"));
            t.addRow(new String[]{p.getTen(), Formatters.vnd(p.getGiaBan()), p.getThuongHieu(), info});
        }
        System.out.println("Kết quả tìm kiếm"+(q==null||q.isBlank()?"":": "+q));
        System.out.println(t.render());
        if (items.isEmpty()) System.out.println("(Không có kết quả)");
    }
}
