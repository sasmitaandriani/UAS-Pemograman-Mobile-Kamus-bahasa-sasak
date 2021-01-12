package com.sasmita.kamusbahasasasak;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.sasmita.kamusbahasasasak.model.KamusSasak;

import java.util.List;

public class Adapter extends ArrayAdapter<KamusSasak>{
    Context context;

    public Adapter(@NonNull Context context, @NonNull List<KamusSasak> objects) {
        super(context, R.layout.row_kamus, objects);
        this.context = context;
    }

    class ViewHolder{
        TextView txTgl;
        TextView txContoh; //contoh / txnilai
        TextView txArti; //arti / deskripsi
        TextView txKata; // kata /model
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        KamusSasak tr = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_kamus,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.txTgl = convertView.findViewById(R.id.row_tx_tgl_transaksi);
            viewHolder.txArti = convertView.findViewById(R.id.row_tx_desc_transaksi);
            viewHolder.txContoh = convertView.findViewById(R.id.row_tx_nilai_transaksi);
            viewHolder.txKata = convertView.findViewById(R.id.row_tx_model);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txTgl.setText(GenericUtility.DATE_FORMAT.format(tr.getTanggal()));
        viewHolder.txArti.setText(tr.gerArti());
        viewHolder.txKata.setText(tr.getKata());
        if (tr.getJenis().equals(KamusSasak.kataKerja)) {
            viewHolder.txContoh.setText(tr.getContoh());
        } else {
            viewHolder.txContoh.setText((tr.getContoh()));
        }
        return convertView;
    }
}