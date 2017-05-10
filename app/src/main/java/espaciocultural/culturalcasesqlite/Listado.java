package espaciocultural.culturalcasesqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import culturalcase.*;

public class Listado extends AppCompatActivity {

    ListView listCase;
    Adaptador adaptador;
    TextView localizacion;
    Singleton singleton = Singleton.initInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        adaptador = new Adaptador(getApplicationContext());
        listCase =(ListView) findViewById(R.id.listCasas);
        localizacion = (TextView) findViewById(R.id.lblLocalidad);
//        localizacion.setText(singleton.getLocalidad());
        mostra();

        listCase.setOnItemClickListener(new AdapterView.OnItemClickListener(){
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               listCase.setAdapter(adaptador.getAdaptador());
               Toast.makeText(getApplicationContext(), "seleccion ->\t" +
                       String.valueOf(adaptador.getCentrosCulturales().get(position)),Toast.LENGTH_SHORT).show();
           }
       });


    }

    public void mostra(){
        listCase.setAdapter(adaptador.getAdaptador());
    }

}
