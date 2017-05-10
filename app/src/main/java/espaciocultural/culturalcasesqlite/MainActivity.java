package espaciocultural.culturalcasesqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import culturalcase.Singleton;

public class MainActivity extends AppCompatActivity {

    Button btnlistado;
    EditText textLocalidad;
    Singleton singleton = Singleton.initInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textLocalidad = (EditText) findViewById(R.id.txtLocalidad);
        btnlistado=(Button) findViewById(R.id.button);
        btnlistado.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                singleton.setLocalidad(String.valueOf(textLocalidad.getText()));
                startActivity(new Intent(MainActivity.this, Listado.class));
                Toast.makeText(getApplicationContext(), singleton.getLocalidad(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
