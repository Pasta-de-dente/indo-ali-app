package com.example.indoali.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.indoali.R;
import com.example.indoali.javaScreens.objects.ObjectViagem;
import com.example.indoali.javaScreens.viewViagemActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class viagemAdapter extends BaseAdapter {

    private ArrayList<ObjectViagem> productList;
    private final Activity activity;

    DecimalFormat decimalFormat = new DecimalFormat("0.00");


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

        view.setOnClickListener(view1 -> {
            Intent intent = new Intent(activity, viewViagemActivity.class);
            intent.putExtra("Viagem", ent);
            activity.startActivity(intent);
        });

        TextView data = view.findViewById(R.id.AdapterDataViagem);
        data.setText(ent.getData() + "");

        TextView destino = view.findViewById(R.id.AdapterDestinoViagem);
        destino.setText(ent.getDestino() + "");

        TextView total = view.findViewById(R.id.AdapterTotalViagem);

        double totalGasolina = ((ent.getTotalEstimadoKm() / ent.getMediaKmLitro()) * ent.getCustoMedioLitro()) / ent.getTotalVeiculo();

        if (Double.isNaN(totalGasolina)) {
            totalGasolina = 0.0;
        }

        double totalHospedagem = (ent.getCustoMedioPorNoite() * ent.getTotalNoite()) * ent.getTotalQuartos();
        double totaltarifaArea = ((ent.getCustoPorPessoa() * ent.getTotalViajante()) + ent.getAluguelVeiculo());
        double totalRefeicao = ((ent.getQtdaRefeicaoPorDia() * ent.getTotalViajante()) * ent.getCustoEstimadoPorRefeicao()) * ent.getDuracaoDaViagem();

        double totalEnt = 0;

        for (int j = 0; j < ent.listEntretenimento.size(); j++) {
            totalEnt = totalEnt + ((ent.listEntretenimento.get(j).getPreco() * ent.listEntretenimento.get(j).getQtdaVezes()) * ent.listEntretenimento.get(j).getQtdaPessoas());
        }

        ent.setTotalEntretenimento(totalEnt);

        double totalCalc = totalGasolina + totalHospedagem + totaltarifaArea + totalRefeicao + totalEnt;
        total.setText("R$ " + decimalFormat.format(totalCalc));

        return view;
    }
}
