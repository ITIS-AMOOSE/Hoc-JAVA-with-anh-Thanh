package baitap.buoi3.Service;

import baitap.buoi3.model.ProductBase;

import java.util.*;

public class ProductService {
    private final List<ProductBase> data;

    public ProductService(List<ProductBase> initial) {
        this.data = new ArrayList<>();
        if (initial != null) this.data.addAll(initial);
    }

    public List<ProductBase> all() { return Collections.unmodifiableList(data); }
    public void add(ProductBase p) { data.add(p); }

    public ProductBase findById(String id) {
        for (ProductBase p : data) if (p.getId().equals(id)) return p;
        return null;
    }

    public boolean remove(String id) {
        return data.removeIf(p -> p.getId().equals(id));
    }

    public boolean updateCore(String id, String ten, Long gia, String thuongHieu) {
        ProductBase p = findById(id);
        if (p == null) return false;
        if (ten != null && !ten.isBlank()) p.setTen(ten);
        if (gia != null && gia >= 0) p.setGiaBan(gia);
        if (thuongHieu != null && !thuongHieu.isBlank()) p.setThuongHieu(thuongHieu);
        return true;
    }
}
