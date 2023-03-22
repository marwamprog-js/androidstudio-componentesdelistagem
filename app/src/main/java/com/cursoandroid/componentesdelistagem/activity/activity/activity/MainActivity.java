package com.cursoandroid.componentesdelistagem.activity.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.cursoandroid.componentesdelistagem.R;
import com.cursoandroid.componentesdelistagem.activity.activity.adapter.PostagemAdapter;
import com.cursoandroid.componentesdelistagem.activity.activity.model.Postagem;

import java.util.ArrayList;
import java.util.List;

import kotlin.collections.ArrayDeque;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens = new ArrayList<Postagem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        //Define layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerPostagem.setLayoutManager( layoutManager );


        //Define adapter
        this.prepararPostagens();
        PostagemAdapter adapter = new PostagemAdapter( postagens );
        recyclerPostagem.setAdapter( adapter );

    }

    public void prepararPostagens() {

        Postagem p = new Postagem("Marwam Malta", "#tbt Viagem Legal!", R.drawable.imagem1);
        this.postagens.add( p );

        p = new Postagem("Hotel JM", "Viagem, aproveite nossos descontos!", R.drawable.imagem2);
        this.postagens.add( p );

        p = new Postagem("Maria Luiza", "#Paris!!", R.drawable.imagem3);
        this.postagens.add( p );

        p = new Postagem("Marcos Paulo", "Que foto linda!", R.drawable.imagem4);
        this.postagens.add( p );

    }

}