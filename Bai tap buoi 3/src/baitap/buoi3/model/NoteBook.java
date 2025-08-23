package baitap.buoi3.model;

import lombok.Getter;
import java.util.List;

@Getter
public class NoteBook extends ProductBase {
    private final int soTrang;
    private final String mauBia, chatLieuGiay, loaiVo, kichThuoc;

    public NoteBook(String ten, long giaBan, String thuongHieu,
                    int soTrang, String mauBia, String chatLieuGiay,
                    String loaiVo, String kichThuoc) {
        super(ten, giaBan, thuongHieu, ProductType.VO);
        this.soTrang = soTrang;
        this.mauBia = mauBia;
        this.chatLieuGiay = chatLieuGiay;
        this.loaiVo = loaiVo;
        this.kichThuoc = kichThuoc;
    }

    @Override public List<Show> attributes() {
        return List.of(
                new Show("Số trang", String.valueOf(soTrang)),
                new Show("Loại vở", loaiVo),
                new Show("Màu sắc bìa", mauBia),
                new Show("Chất liệu giấy", chatLieuGiay),
                new Show("Kích thước", kichThuoc)
        );
    }
}
