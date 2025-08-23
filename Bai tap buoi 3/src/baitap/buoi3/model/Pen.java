package baitap.buoi3.model;

import lombok.Getter;
import java.util.List;

@Getter
public class Pen extends ProductBase {
    private final String mauSac, chatLieu, loaiMuc, doMin;

    public Pen(String ten, long giaBan, String thuongHieu,
               String mauSac, String chatLieu, String loaiMuc, String doMin) {
        super(ten, giaBan, thuongHieu, ProductType.BUT_MUC);
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.loaiMuc = loaiMuc;
        this.doMin = doMin;
    }

    @Override public List<Show> attributes() {
        return List.of(
                new Show("Màu sắc", mauSac),
                new Show("Chất liệu", chatLieu),
                new Show("Loại mực", loaiMuc),
                new Show("Độ mịn", doMin)
        );
    }
}
