package culturalcase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cathe on 10/05/2017.
 */

public class CulturalCaseSQLiteHelper extends SQLiteOpenHelper {

    private String sql = "CREATE TABLE CentrosCulturales (Localidad TEXT, Nombre TEXT, Telefono TEXT, Direccion TEXT)";

    public CulturalCaseSQLiteHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sql);
        db.execSQL("INSERT INTO CentrosCulturales (Localidad, Nombre, Telefono, Direccion) VALUES('localidad',' ident ','nombres','apellidos')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS CentrosCulturales");
        db.execSQL(sql);
        db.execSQL("INSERT INTO CentrosCulturales (Localidad, Nombre, Telefono, Direccion) VALUES('localidad',' ident ','nombres','apellidos')");
    }
}
