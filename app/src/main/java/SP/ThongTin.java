package SP;

public class ThongTin {
    private String name;
    private String mota;

    private String gia;
    private int hinh;

    public ThongTin(String name, String mota,  String gia,int hinh) {
        this.name = name;
        this.mota = mota;
        this.gia = gia;
        this.hinh = hinh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}

