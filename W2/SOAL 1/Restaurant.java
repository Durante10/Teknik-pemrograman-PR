public class Restaurant{
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;

    public Restaurant(){
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }
    public void tambahMenuMakanan(String nama, double harga, int stok){
        SetNama_makanan(id, nama);
        SetHarga_makanan(id, harga);
        Setstok(id, stok);
        nextId();
    }

    public void pesanMakanan(int id_makanan, int jumlah_pesanan){
        if (! cekMenu(id_makanan)) {
            return;
        }

        if (! isOutOfStock(id_makanan)){
            if (jumlah_pesanan > GetStok(id_makanan)) {
                System.out.println("Maaf, pesanan " + GetNama_makanan(id_makanan) + " Anda melebihi stok yang tersedia");
                System.out.println("Stok " + GetNama_makanan(id_makanan) + " hanya " + GetStok(id_makanan));
                return;
            } else {
                int stokTersisa = GetStok(id_makanan) - jumlah_pesanan;
                Setstok(id_makanan, stokTersisa);
                System.out.println("Berhasil memesan " + GetNama_makanan(id_makanan) + " Sebanyak " + jumlah_pesanan);

                double totalHarga = jumlah_pesanan * GetHarga_makanan(id_makanan);
                System.out.println("Total Bayar: Rp." + totalHarga);
            }
        } else {
            return;
        }
    }
    public boolean cekMenu(int id_makanan){
        if (id_makanan < 0 || id_makanan >= id){
            System.out.println("Menu yang anda pilih tidak ada!");
            return false;
        } else {
            return true;
        }
    }


    public void tampilMenuMakanan(){
        for (int i = 0; i < id; i++){
            if (!isOutOfStock(i)) {
                System.out.println((i+1)+"."+ GetNama_makanan(i) + "[" + GetStok(i) + "]" + "\tRp." + GetHarga_makanan(i));
            }
        }
    }

    public boolean isOutOfStock(int id){
        if (stok[id] <= 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void nextId(){
        id++;
    }

    public static byte GetId(){
        return id;
    }

    // Setter
    public void SetNama_makanan(int id, String nama){
        this.nama_makanan[id]=nama;
    }

    public void SetHarga_makanan(int id, double harga){
        this.harga_makanan[id]=harga;
    }

    public void Setstok(int id,int Stok){
        this.stok[id]=Stok;
    }

    //Getter
    public String GetNama_makanan(int id){
        return nama_makanan[id];
    }

    public double GetHarga_makanan(int id){
        return harga_makanan[id];
    }

    public int GetStok(int id){
        return stok[id];
    }
}
