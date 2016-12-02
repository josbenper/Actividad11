package com.example.mati.aplicacion17;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mati on 20/10/16.
 */

public class DatosTarea extends AppCompatActivity {


    static List TAREAS = new ArrayList<Tarea>();

    static String tipo;
    static String nombre;
    static String precio;
    static String IdImagen;
    static String Url;



    static final String XML_CONTACT_LIST_TAG = "ListaComida";
    static final String XML_CONTACT_TAG = "Comida";

    static final String XML_CONTACT_TIPO = "Tipo";
    static final String XML_CONTACT_NOMBRE = "Nombre";
    static final String XML_CONTACT_PRECIO = "Precio";
    static final String XML_CONTACT_IDIMAGEN = "IdImagen";
    static final String XML_CONTACT_URL = "Url";

    static final String XML_FILE_NAME = "pruebaXML.xml";

    try{
        BufferedReader _fin = new BufferedReader(new InputStreamReader(openFileInput(R.raw.pruebaXML)));
//
//            EditText _etContentRecovered = (EditText)findViewById(R.id.etXMLContent);
//            _etContentRecovered.setText("");

//        //Obteniendo instancias de los text views
//        TextView titulo = (TextView)listItemView.findViewById(R.id.text1);
//        TextView subtitulo = (TextView)listItemView.findViewById(R.id.text2);
//        ImageView categoria = (ImageView)listItemView.findViewById(R.id.category);
//        TextView precio = (TextView)listItemView.findViewById(R.id.precio);


        XmlPullParser _parser = XmlPullParserFactory.newInstance().newPullParser();
        _parser.setInput(_fin);

        int _eventType = _parser.getEventType(); // Al comienzo XmlPullParser.START_DOCUMENT
        while (_eventType != XmlPullParser.END_DOCUMENT){
            switch (_eventType){
//                    case XmlPullParser.START_DOCUMENT:
//
//                        titulo.setText(item.getNombre());
//
//                        _etContentRecovered.setText(_etContentRecovered.getText().toString()+ "START_DOCUMENT\n");
//                        break;
                case XmlPullParser.START_TAG:
                    tipo = _parser.getAttributeValue(null,XML_CONTACT_TIPO);
                    nombre = _parser.getAttributeValue(null,XML_CONTACT_NOMBRE);
                    IdImagen = _parser.setImageResource(null,XML_CONTACT_IDIMAGEN);
                    precio = (_parser.getAttributeValue(null,XML_CONTACT_PRECIO));
                    Url = (_parser.getAttributeValue(null,XML_CONTACT_URL));
                    TAREAS.add(new Tarea(tipo, nombre, IdImagen,"5€","http://www.burgerking.es/menu-item/long-chicken"));

                    break;
//                    case XmlPullParser.END_TAG:
//                        _etContentRecovered.setText(_etContentRecovered.getText().toString()+ "  END_TAG ["+_parser.getName()+"]\n");
//                        break;
                default:
                    break;
            }
            _parser.next();
            _eventType = _parser.getEventType();
        }
//            if (_eventType == XmlPullParser.END_DOCUMENT) _etContentRecovered.setText(_etContentRecovered.getText().toString()+ "END_DOCUMENT\n");
        _fin.close();
    }catch (Exception ex){
        Log.e("ejemplos.alamacenamiento", "Error leyendo XML desde fichero");
    }


//    static{
//        TAREAS.add(new Tarea("Burger","Long chiken",R.drawable.ic_long_chicken,"5€","http://www.burgerking.es/menu-item/long-chicken"));
//        TAREAS.add(new Tarea("Burger","Crispy Chicken",R.drawable.ic_crispy_chicken,"3€","http://www.burgerking.es/menu-item/crispy-chicken%C2%AE"));
//        TAREAS.add(new Tarea("Pizza","Steak House",R.drawable.ic_steak_house,"9€","http://www.telepizza.es/producto/pizzas/pizza-steak-house-999990005044316"));
//    }
}
