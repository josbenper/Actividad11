package com.example.mati.aplicacion17;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by mati on 20/10/16.
 */

public class MyArrayAdapter<T> extends ArrayAdapter<T> {

    static final String XML_CONTACT_LIST_TAG = "ListaComida";
    static final String XML_CONTACT_TAG = "Comida";

    static final String XML_CONTACT_TIPO = "Tipo";
    static final String XML_CONTACT_NOMBRE = "Nombre";
    static final String XML_CONTACT_PRECIO = "Precio";
    static final String XML_CONTACT_IDIMAGEN = "IdImagen";
    static final String XML_CONTACT_URL = "Url";

    static final String XML_FILE_NAME = "pruebaXML.xml";

    public MyArrayAdapter(Context context, int resource, List objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        return super.getView(position, convertView, parent);

        //Obteniendo una instancia del inflater
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Salvando la referencia del View de la fila
        View listItemView = convertView;

        //Comprobando si el View no existe
        if (null == convertView) {
        //Si no existe, entonces inflarlo con two_line_list_item.xml

            listItemView = inflater.inflate(R.layout.image_list_item, parent, false);

        }

        //Obteniendo instancias de los text views
//        TextView titulo = (TextView)listItemView.findViewById(R.id.text1);
//        TextView subtitulo = (TextView)listItemView.findViewById(R.id.text2);
//        ImageView categoria = (ImageView)listItemView.findViewById(R.id.category);
//        TextView precio = (TextView)listItemView.findViewById(R.id.precio);

        //Obteniendo instancia de la Tarea en la posición actual
//        Tarea item = (Tarea) getItem(position);
//
//        titulo.setText(item.getNombre());
//        subtitulo.setText(item.getHora());
//        categoria.setImageResource(item.getCategoria());
//        precio.setText(item.getPrecio());


        try{
            BufferedReader _fin = new BufferedReader(new InputStreamReader(openFileInput(R.raw.pruebaXML)));
//
//            EditText _etContentRecovered = (EditText)findViewById(R.id.etXMLContent);
//            _etContentRecovered.setText("");

            //Obteniendo instancias de los text views
            TextView titulo = (TextView)listItemView.findViewById(R.id.text1);
            TextView subtitulo = (TextView)listItemView.findViewById(R.id.text2);
            ImageView categoria = (ImageView)listItemView.findViewById(R.id.category);
            TextView precio = (TextView)listItemView.findViewById(R.id.precio);


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
//                        _etContentRecovered.setText(_etContentRecovered.getText().toString()+ "  START_TAG ["+_parser.getName()+"]\n");
                        titulo.setText(_parser.getAttributeValue(null,XML_CONTACT_TIPO));
                        subtitulo.setText(_parser.getAttributeValue(null,XML_CONTACT_NOMBRE));
//                        categoria.setText(_parser.getAttributeValue(null,XML_CONTACT_IDIMAGEN));
                        precio.setText(_parser.getAttributeValue(null,XML_CONTACT_PRECIO));
//                        _etContentRecovered.setText(_etContentRecovered.getText().toString()+ "    ["+_parser.getName()+"]:"+_parser.getAttributeValue(null,XML_CONTACT_NAME)+"\n");
//                        _etContentRecovered.setText(_etContentRecovered.getText().toString()+ "    ["+_parser.getName()+"]:"+_parser.getAttributeValue(null,XML_CONTACT_PHONE)+"\n");
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

        //Devolver al ListView la fila creada
        return listItemView;
    }

}
