package com.example.mati.aplicacion17;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lista;
    private MyArrayAdapter<Tarea> adaptador;
    private WebView myWebView;
    private WebSettings webSettings;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instancia del ListView
        lista = (ListView) findViewById(R.id.lista);
        myWebView = (WebView) findViewById(R.id.web);
        webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());


        //Inicializar el adaptador con la fuente de datos
        adaptador = new MyArrayAdapter<Tarea>(this, 0, DatosTarea.TAREAS);

        //Relacionando la lista con el adaptador
        lista.setAdapter(adaptador);

        //Estableciendo la escucha
        lista.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Tarea tareaActual = (Tarea)adaptador.getItem(position);

//        String msg = "Elegiste la tarea:\n" + tareaActual.getNombre() + "-" + tareaActual.getHora();

        String url = tareaActual.getUrl();
        myWebView.loadUrl(url);
    }



}
