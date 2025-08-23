package baitap.buoi3.Service;

import baitap.buoi3.model.ProductBase;
import baitap.buoi3.util.Formatters;
import baitap.buoi3.util.TableRenderer;

public class TableService {
    private final ProductService productService;
    public TableService(ProductService productService){ this.productService = productService; }

    public void run(){
        String[] headers = {"ID","Tên sản phẩm","Giá bán","Thương hiệu","Thông tin thêm"};
        TableRenderer t = new TableRenderer(headers, new int[]{9,24,12,16,56});
        for (ProductBase p : productService.all()) {
            String info = p.attributes().stream()
                    .map(a -> "- " + a.getName() + ": " + a.getValue())
                    .reduce((a,b)->a+"\n"+b).orElse("");
            t.addRow(new String[]{p.getId().substring(0,8), p.getTen(), Formatters.vnd(p.getGiaBan()), p.getThuongHieu(), info});
        }
        System.out.println(t.render());
        if (productService.all().isEmpty()) System.out.println("(Trống)");
    }
}
