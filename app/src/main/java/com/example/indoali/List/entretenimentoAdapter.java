package com.example.indoali.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.indoali.R;
import com.example.indoali.javaScreens.objects.Entretenimento;

import java.util.ArrayList;

public class entretenimentoAdapter extends BaseAdapter {

    private ArrayList<Entretenimento> productList;
    private final Activity activity;

    public entretenimentoAdapter(final Activity activity) {
        this.activity = activity;
    }

    public void setProductList(final ArrayList<Entretenimento> products) {
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
            view = activity.getLayoutInflater().inflate(R.layout.list_item, viewGroup, false);
        }

        Entretenimento ent = productList.get(i);

        TextView productName = view.findViewById(R.id.NameEntretenimento);
        productName.setText(ent.getNome());

        TextView item_preco = view.findViewById(R.id.precoEntretenimento);
        item_preco.setText("Preço: " + ent.getPreco());

        TextView item_qtda_pessoas = view.findViewById(R.id.qtdaPessoasEntretenimento);
        item_qtda_pessoas.setText("Qtda Pessoa: " + ent.getQtdaPessoas());

        TextView item_Qtda_vezes = view.findViewById(R.id.qtdaVezesEntretenimento);
        item_Qtda_vezes.setText("Qtda Vezes: " + ent.getQtdaVezes());

        TextView total = view.findViewById(R.id.totalEntretenimento);
        total.setText("TOTAL: " + ((ent.getPreco() * ent.getQtdaPessoas())) * ent.getQtdaVezes());

        // Button btnDetails = view.findViewById(R.id.btnDeletar);
        // btnDetails.setOnClickListener(new View.OnClickListener() {
        // @Override
        // public void onClick(View view) {
        // Toast.makeText(activity,
        // "Clicou no produto: " + productList.get(i).getNome(),
        // Toast.LENGTH_SHORT
        // ).show();
        // }
        // });

        return view;
    }
}