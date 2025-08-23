package baitap.buoi3.model;

import lombok.Getter;
import java.util.List;

@Getter
public class Pencil extends ProductBase {
    private final String mauSac, chatLieu, doCung;

    public Pencil(String ten, long giaBan, String thuongHieu,
                  String mauSac, String chatLieu, String doCung) {
        super(ten, giaBan, thuongHieu, ProductType.BUT_CHI);
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.doCung = doCung;
    }

    @Override public List<Show> attributes() {
        return List.of(
                new Show("Màu sắc", mauSac),
                new Show("Chất liệu", chatLieu),
                new Show("Độ cứng", doCung)
        );
    }
}
