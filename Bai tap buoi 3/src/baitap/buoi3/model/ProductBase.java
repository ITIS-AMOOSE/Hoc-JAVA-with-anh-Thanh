package baitap.buoi3.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
public abstract class ProductBase {
    private final String id;
    @Setter private String ten;
    @Setter private long giaBan;
    @Setter private String thuongHieu;
    private final ProductType loai;

    protected ProductBase(String ten, long giaBan, String thuongHieu, ProductType loai) {
        this.id = UUID.randomUUID().toString();
        this.ten = ten;
        this.giaBan = giaBan;
        this.thuongHieu = thuongHieu;
        this.loai = loai;
    }

    public abstract List<Show> attributes();
}
