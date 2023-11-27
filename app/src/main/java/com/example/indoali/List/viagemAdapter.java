package com.example.indoali.List;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.indoali.API.Api;
import com.example.indoali.API.model.Aereo;
import com.example.indoali.API.model.EntretenimentoAPI;
import com.example.indoali.API.model.Gasolina;
import com.example.indoali.API.model.Hospedagem;
import com.example.indoali.API.model.Refeicao;
import com.example.indoali.API.model.Resposta;
import com.example.indoali.API.model.ViagemModel;
import com.example.indoali.R;
import com.example.indoali.javaScreens.objects.ObjectViagem;
import com.example.indoali.javaScreens.viewViagemActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = activity.getLayoutInflater().inflate(R.layout.viagem_lista, viewGroup, false);
        }

        ObjectViagem ent = productList.get(i);
        Button btnSincronizar = view.findViewById(R.id.btnSincronizar);

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

        btnSincronizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViagemModel viagemModel = new ViagemModel();
                viagemModel.setTotalViajantes(ent.getTotalViajante());
                viagemModel.setDuracaoViagem(ent.getDuracaoDaViagem());
                viagemModel.setCustoTotalViagem(ent.getCustoTotal());
                viagemModel.setCustoPorPessoa(ent.getCustoPorPessoa());
                viagemModel.setLocal(ent.getDestino());
                viagemModel.setIdConta(121753);

                Gasolina gasolina = new Gasolina();
                gasolina.setTotalEstimadoKM(3);
                gasolina.setMediaKMLitro(ent.getMediaKmLitro());
                gasolina.setCustoMedioLitro(ent.getCustoMedioLitro());
                gasolina.setTotalVeiculos(ent.getTotalVeiculo());
                viagemModel.setGasolina(gasolina);

                Aereo aereo = new Aereo();
                aereo.setCustoPessoa(ent.getCustoPorPessoa());
                aereo.setCustoAluguelVeiculo(ent.getAluguelVeiculo());
                viagemModel.setAereo(aereo);

                ArrayList<EntretenimentoAPI> entList = new ArrayList<>();

                for (int j = 0; j < ent.listEntretenimento.size(); j++) {
                    EntretenimentoAPI e = new EntretenimentoAPI();

                    e.setValor(ent.listEntretenimento.get(j).getPreco());
                    e.setEntretenimento(ent.listEntretenimento.get(j).getNome());

                    entList.add(e);
                }

                viagemModel.setListaEntretenimento(entList);

                Hospedagem hospedagem = new Hospedagem();
                hospedagem.setCustoMedioNoite(ent.getCustoMedioPorNoite());
                hospedagem.setTotalNoite(ent.getTotalNoite());
                hospedagem.setTotalQuartos(ent.getTotalQuartos());
                viagemModel.setHospedagem(hospedagem);

                Refeicao refeicao = new Refeicao();
                refeicao.setCustoRefeicao(ent.getCustoEstimadoPorRefeicao());
                refeicao.setRefeicoesDia(ent.getQtdaRefeicaoPorDia());
                viagemModel.setRefeicao(refeicao);

                Api.postViagem(viagemModel, new Callback<Resposta>() {
                    @Override
                    public void onResponse(Call<Resposta> call, Response<Resposta> response) {
                        if (response != null && response.isSuccessful()) {
                            Resposta resposta = response.body();

                            if (resposta != null) {
                                // Handle successful response
                                System.out.println(resposta.getDados());
                                System.out.println(resposta.getMensagem());
                            } else {
                                // Handle null response
                                Toast.makeText(activity, "Null response", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            // Handle unsuccessful response
                            Toast.makeText(activity, "Unsuccessful response", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Resposta> call, Throwable t) {
                        // Handle failure
                        Toast.makeText(activity, "Error in sending request", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return view;
    }
}
