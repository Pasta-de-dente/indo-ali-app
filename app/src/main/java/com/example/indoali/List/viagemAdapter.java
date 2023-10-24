package com.example.indoali.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.indoali.R;
import com.example.indoali.javaScreens.objects.ObjectViagem;

import java.util.ArrayList;

public class viagemAdapter extends BaseAdapter {

    private ArrayList<ObjectViagem> productList;
    private final Activity activity;

    public viagemAdapter(final Activity activity) {
        this.activity = activity;
    }

    public void setProductList(final ArrayList<ObjectViagem> products) {
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
            view = activity.getLayoutInflater().inflate(R.layout.viagem_lista, viewGroup, false);
        }
        ObjectViagem ent = productList.get(i);

        TextView data = view.findViewById(R.id.AdapterDataViagem);
        data.setText(ent.getData() + "");

        TextView destino = view.findViewById(R.id.AdapterDestinoViagem);
        destino.setText(ent.getDestino() + "");

        TextView total = view.findViewById(R.id.AdapterTotalViagem);
        double totalcarro = ((ent.getTotalEstimadoKm() / ent.getMediaKmLitro()) * ent.getCustoMedioLitro()) / ent.getTotalVeiculo();
        double totalAviao = ((ent.getCustoPorPessoa()* ent.getTotalViajanteAviao()) + ent.getAluguelVeiculo()) ;
        double totalRefeicao = ((ent.getQtdaRefeicaoPorDia()* ent.getTotalViajanteRefeicao()) * ent.getCustoEstimadoPorRefeicao())* ent.getDuracaoDaViagem();
        double totalHospedagem = (ent.getCustoMedioPorNoite()* ent.getTotalNoite()) * ent.getTotalQuartos();

        total.setText((totalcarro+totalAviao+totalRefeicao+totalHospedagem) + "");

        return view;
    }
}
