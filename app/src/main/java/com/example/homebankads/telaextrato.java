package com.example.homebankads;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class telaextrato extends AppCompatActivity {
    Button btextratoret,btconsulta;
    Spinner spmeses,spano;
    ListView listaextrato;
    int idusr;

    movimentoscontrole movi = new movimentoscontrole(telaextrato.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telaextrato);

        listaextrato=(ListView)findViewById(R.id.listaextrato);
        Bundle extras = getIntent().getExtras();
        idusr = extras.getInt("id");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,movi.Lista_movimentos(idusr));
        listaextrato.setAdapter(adapter);

        btextratoret=(Button) findViewById(R.id.btextratret);
        spmeses = (Spinner)findViewById(R.id.spmes);
        spano = (Spinner)findViewById(R.id.spano);
        btconsulta=(Button)findViewById(R.id.btconsultaext);
        btconsulta.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
     String mes=spmeses.getSelectedItem().toString();

     String ano=spano.getSelectedItem().toString();

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(telaextrato.this,android.R.layout.simple_list_item_1,movi.Lista_movimentos(idusr,mes,ano));
        listaextrato.setAdapter(adapter2);
    }
});

        btextratoret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent i = new Intent(getApplicationContext(), telaprincipal.class);
               // i.putExtra("id",idusr);
               // startActivity(i);
            finish();



            }
        });
    }
}