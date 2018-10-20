package crud.co.com.clientecrud.cliente;

import android.util.Log;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import crud.co.com.clientecrud.constantes.Constantes;
import cz.msebera.android.httpclient.Header;

public class ActualizacionCliente {
    public void start() {
        final AsyncHttpClient client = new AsyncHttpClient();
        String uri = Constantes.URL_ACTUALIZAR;
        try {
            client.get(uri, null, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    if (statusCode==200) {
                        //try {
                            //txtNombre.setText(response.getString("nombre"));
                            //txtApellido.setText(response.getString("apellidos"));
                        //} catch (JSONException e) {
                          //  e.printStackTrace();
                        //}
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    Log.e("", throwable.toString());
                }
            });
        } catch (Exception e) {
            Log.e("", e.toString());
        }
    }
}
