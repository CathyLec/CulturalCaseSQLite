package culturalcase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by cathe on 10/05/2017.
 */

public class Adaptador
{
    private final ArrayList<CulturalCase> centrosCulturales = new ArrayList<>();
    private final ArrayAdapter<CulturalCase> adapter;
    private CulturalCase culturalCase;
    private Singleton singleton = Singleton.initInstance();

    public Adaptador (Context context){
        this.adapter= new ArrayAdapter<CulturalCase> (context,android.R.layout.simple_list_item_1,centrosCulturales);
    }

    private void listarcCentros() {

        CulturalCaseSQLiteHelper usuario = new CulturalCaseSQLiteHelper(adapter.getContext(), "DBCentrosCulturales", null, 1);
        SQLiteDatabase db = usuario.getWritableDatabase();

        String[] campos = new String[]{"Nombre", "Telefono", "Direccion"};
        //Cursor c = db.query("CentrosCulturales", campos, "Localidad = '" + singleton.getLocalidad() + "'", null, null, null, null);
        Cursor c = db.query("CentrosCulturales", campos, null, null, null, null, null);

        if (c.moveToFirst()) {

            do {
                culturalCase.setLocalidad(c.getString(0));
                culturalCase.setNombre(c.getString(1));
                culturalCase.setTelefono(c.getString(2));
                culturalCase.setDireccion(c.getString(3));
                centrosCulturales.add(culturalCase);
            } while (c.moveToNext());
        }
    }


    public ArrayAdapter<CulturalCase> getAdaptador () {
        return adapter;
    }
    public ArrayList<CulturalCase> getCentrosCulturales () {
        return centrosCulturales;
    }
}
