package com.example.indoali.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.indoali.R;
import com.example.indoali.javaScreens.objects.Entretenimento;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class entretenimentoAdapter extends BaseAdapter {

    private ArrayList<Entretenimento> productList;
    private final Activity activity;

    DecimalFormat decimalFormat = new DecimalFormat("0.00");


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
        item_preco.setText("Preço: R$ " + decimalFormat.format(ent.getPreco()));

        TextView item_qtda_pessoas = view.findViewById(R.id.qtdaPessoasEntretenimento);
        item_qtda_pessoas.setText("Pessoas: " + ent.getQtdaPessoas());

        TextView item_Qtda_vezes = view.findViewById(R.id.qtdaVezesEntretenimento);
        item_Qtda_vezes.setText("Quantas vezes: " + ent.getQtdaVezes());

        TextView total = view.findViewById(R.id.totalEntretenimento);
        total.setText("Total: R$ " + decimalFormat.format(((ent.getPreco() * ent.getQtdaPessoas())) * ent.getQtdaVezes()));

        ImageButton btnDelete = view.findViewById(R.id.btnDeletar);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               productList.remove(i);
               notifyDataSetChanged();
                Toast.makeText(activity, "Removido com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}