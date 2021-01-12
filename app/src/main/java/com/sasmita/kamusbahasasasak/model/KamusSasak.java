package com.sasmita.kamusbahasasasak.model;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.UUID;

public class KamusSasak {
    public static final String kataKerja="Kata Kerja";
    public static final String kataSifat ="Kata Sifat";
    public static final String kataBenda ="Kata Benda";
    private String id;
    private Date tanggal;
    private String arti;
    private String contoh;
    private String jenis;
    private String kata;

    public KamusSasak() {
        this.id = UUID.randomUUID().toString();
        this.tanggal = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String gerArti() {
        return arti;
    }

    public void setArti(String arti) {
        this.arti = arti;
    }

    public String getContoh() {
        return contoh;
    }

    public void setContoh(String contoh) {
        this.contoh = contoh;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getKata(){
        return kata;
    }
    public void setKata( String kata){
        this.kata = kata;
    }

    public static KamusSasak fromJSONObject(JSONObject obj) {
        KamusSasak tr = new KamusSasak();
        try {
            tr.setId(obj.getString("id"));
            tr.setTanggal(new Date(obj.getLong("tanggal")));
            tr.setArti(obj.getString("arti"));
            tr.setContoh(obj.getString("contoh"));
            tr.setJenis(obj.getString("jenis"));
            tr.setKata(obj.getString("kata"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tr;
    }

    public JSONObject toJSONObject() {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("id",this.id);
            jsonObj.put("tanggal",this.tanggal.getTime());
            jsonObj.put("jenis",this.jenis);
            jsonObj.put("contoh",this.contoh);
            jsonObj.put("arti",this.arti);
            jsonObj.put("kata",this.kata);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObj;
    }

}
