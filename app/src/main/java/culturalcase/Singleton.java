package culturalcase;

import java.util.ArrayList;

/**
 * Created by cathe on 10/05/2017.
 */

public class Singleton {
    private static Singleton mInstance=null;
    private String localidad;

    private Singleton(){
    }

    public static Singleton initInstance(){
        if(mInstance == null){
            mInstance = new Singleton();
        }
        return mInstance;
    }

    public String getLocalidad(){
        return this.localidad;
    }

    public void setLocalidad(String value){
        localidad = value;
    }
}

