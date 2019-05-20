package com.example.obet.beacons;

import com.android.volley.toolbox.StringRequest;
import android.app.DownloadManager;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;

import java.util.HashMap;
import java.util.Map;


public class RegistroRequest extends StringRequest {
    private static final String ruta = "http://beaconsobetay.000webhostapp.com/registro.php";
    private Map<String, String> parametros;
    public RegistroRequest(String nombre, String apellido, String correo, String usuario, String clave, Response.Listener<String> listener){
        super(Request.Method.POST, ruta, listener, null);
        parametros = new HashMap<>();
        parametros.put("nombre",nombre+"");
        parametros.put("apellido",apellido+"");
        parametros.put("correo",correo+"");
        parametros.put("usuario",usuario+"");
        parametros.put("clave",clave+"");
    }

    @Override
    protected Map<String, String> getParams() {
        return parametros;
    }
}
