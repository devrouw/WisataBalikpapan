package com.hermawan.wisatabalikpapan.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Travel implements Parcelable {
    @SerializedName("id")
    private String id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("judul")
    private String judul;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("lokasi")
    private String lokasi;
    @SerializedName("gambar")
    private String gambar;
    @SerializedName("harga")
    private String harga;
    @SerializedName("link")
    private String link;
    @SerializedName("waktu")
    private String waktu;
    @SerializedName("link_order")
    private String linkOrder;
    @SerializedName("deskripsi")
    private String deskripsi;
    @SerializedName("slug")
    private String slug;

    protected Travel(Parcel in) {
        id = in.readString();
        nama = in.readString();
        alamat = in.readString();
        gambar = in.readString();
        harga = in.readString();
        link = in.readString();
        deskripsi = in.readString();
        slug = in.readString();
        judul = in.readString();
        lokasi = in.readString();
        waktu = in.readString();
        linkOrder = in.readString();
    }

    public static final Creator<Travel> CREATOR = new Creator<Travel>() {
        @Override
        public Travel createFromParcel(Parcel in) {
            return new Travel(in);
        }

        @Override
        public Travel[] newArray(int size) {
            return new Travel[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getLinkOrder() {
        return linkOrder;
    }

    public void setLinkOrder(String linkOrder) {
        this.linkOrder = linkOrder;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nama);
        dest.writeString(alamat);
        dest.writeString(gambar);
        dest.writeString(harga);
        dest.writeString(link);
        dest.writeString(deskripsi);
        dest.writeString(slug);
        dest.writeString(judul);
        dest.writeString(lokasi);
        dest.writeString(waktu);
        dest.writeString(linkOrder);
    }
}
