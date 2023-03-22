package com.cursoandroid.componentesdelistagem.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.cursoandroid.componentesdelistagem.R;
import com.cursoandroid.componentesdelistagem.activity.RecyclerItemClickListener;
import com.cursoandroid.componentesdelistagem.activity.adapter.Adapter;
import com.cursoandroid.componentesdelistagem.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<Filme>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem adapter
        this.criarFilmes();

        //Configurar adapter
        Adapter adapter = new Adapter( listaFilmes );


        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter( adapter );

        //Evento de Click
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            Filme filme = listaFilmes.get( position );

                            Toast.makeText(
                                    getApplicationContext(),
                                    "Item Precionado " + filme.getTitulo(),
                                    Toast.LENGTH_LONG
                            ).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                            Filme filme = listaFilmes.get( position );

                            Toast.makeText(
                                    getApplicationContext(),
                                    "Click longo: " + filme.getTitulo(),
                                    Toast.LENGTH_LONG
                            ).show();
                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    }
            )
        );

    }

    public void criarFilmes() {

        Filme filme = new Filme("Homem Aranha - De volta ao lar", "Aventura", "2017");
        this.listaFilmes.add( filme );

        filme = new Filme("Mulher Maravilha", "Fantasia", "2019");
        this.listaFilmes.add( filme );

        filme = new Filme("Liga da Justiça", "Ficção", "2018");
        this.listaFilmes.add( filme );

        filme = new Filme("Capitão América - Guerra Civíl", "Aventura", "2017");
        this.listaFilmes.add( filme );

        filme = new Filme("It: A Coisa", "Terror", "2002");
        this.listaFilmes.add( filme );

        filme = new Filme("Pica-Pau: O Filme", "Comédia/Animação", "1998");
        this.listaFilmes.add( filme );

        filme = new Filme("A Bela e a Fera", "Romance", "2010");
        this.listaFilmes.add( filme );

        filme = new Filme("Meu Malvado Favorito 3", "Comédia", "2017");
        this.listaFilmes.add( filme );

        filme = new Filme("Carros 3", "Comédia", "2017");
        this.listaFilmes.add( filme );

    }
}