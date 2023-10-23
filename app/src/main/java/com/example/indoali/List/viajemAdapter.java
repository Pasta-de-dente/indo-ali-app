package com.example.indoali.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.indoali.R;
import com.example.indoali.javaScreens.objects.ObjectViajem;
import com.example.indoali.javaScreens.objects.entretenimento;

import java.util.ArrayList;

public class viajemAdapter extends BaseAdapter {

    private ArrayList<ObjectViajem> productList;
    private final Activity activity;

    public viajemAdapter(final Activity activity) {
        this.activity = activity;
    }

    public void setProductList(final ArrayList<ObjectViajem> products) {
        productList = products;
    }

    @Override
    public int getCount() {
        return productList != null ? productList.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return productList != null ? productList.get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = activity.getLayoutInflater().inflate(R.layout.viajem_lista, viewGroup, false);
        }
        ObjectViajem ent = productList.get(i);

        TextView data = view.findViewById(R.id.AdapterDataViajem);
        data.setText(ent.getData()+"");

        TextView destino = view.findViewById(R.id.AdapterDestinoViajem);
        destino.setText(ent.getDestinario()+"");

        TextView total = view.findViewById(R.id.AdapterTotalViajem);
        double totalVariavel = ((ent.getTotalEstimadoKm() / ent.getMediaKmLitro()) * ent.getCustoMedioLitro()) / ent.getTotalVeiculo();


        total.setText(totalVariavel + "");

        return view;
    }
}
