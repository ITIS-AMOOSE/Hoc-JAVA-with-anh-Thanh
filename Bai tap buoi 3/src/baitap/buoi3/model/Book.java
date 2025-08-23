package baitap.buoi3.model;

import lombok.Getter;
import java.util.List;

@Getter
public class Book extends ProductBase {
    private final String theLoai, tacGia, nhaXB, namXB, ngonNgu;

    public Book(String ten, long giaBan, String thuongHieu,
                String theLoai, String tacGia, String nhaXB, String namXB, String ngonNgu) {
        super(ten, giaBan, thuongHieu, ProductType.SACH);
        this.theLoai = theLoai;
        this.tacGia = tacGia;
        this.nhaXB = nhaXB;
        this.namXB = namXB;
        this.ngonNgu = ngonNgu;
    }

    @Override public List<Show> attributes() {
        return List.of(
                new Show("Thể loại", theLoai),
                new Show("Tác giả",  tacGia),
                new Show("Nhà xuất bản", nhaXB),
                new Show("Năm xuất bản", namXB),
                new Show("Ngôn ngữ", ngonNgu)
        );
    }
}
