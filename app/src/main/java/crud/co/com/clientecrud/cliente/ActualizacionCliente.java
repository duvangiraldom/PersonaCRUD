package crud.co.com.clientecrud.cliente;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import crud.co.com.clientecrud.constantes.Constantes;
import crud.co.com.clientecrud.dto.PersonaDTO;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class ActualizacionCliente {
    public void start(final Activity actualizacionActivity, final PersonaDTO personaDTO) {
        final AsyncHttpClient client = new AsyncHttpClient();
        String uri = Constantes.URL_ACTUALIZAR;
        JSONObject exportacion = new JSONObject();

        try {
            exportacion.put("id", personaDTO.getId());
            exportacion.put("nombre", personaDTO.getNombre());
            exportacion.put("apellidos", personaDTO.getApellidos());
            exportacion.put("telefono", personaDTO.getTelefono());

            StringEntity entity = new StringEntity(exportacion.toString(), "UTF-8");
            client.addHeader("Content-Type","application/json");
            client.put(actualizacionActivity, uri, entity, "application/json", new TextHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, String responseString) {
                    if (statusCode == 200 ) {
                        Toast.makeText(actualizacionActivity, "La actualización de la persona fue satisfactoria", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(actualizacionActivity, "La actualización de la persona NO fue satisfactoria, " +
                                "por favor intentelo más tarde", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable){
                    Log.e("", throwable.toString());
                }
            });

        } catch (Exception ex) {
            Log.e("", ex.toString());
            ex.printStackTrace();
        }
    }
}