package crud.co.com.clientecrud.cliente;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import crud.co.com.clientecrud.constantes.Constantes;
import cz.msebera.android.httpclient.Header;

public class EliminacionCliente {
    public void start(final Activity eliminacionActivity, final Integer id) {

        final AsyncHttpClient client = new AsyncHttpClient();
        String uri = Constantes.URL_ELIMINAR.concat("/").concat(id.toString());
        try {
            client.get(uri, null, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    if (statusCode==200) {
                        Toast.makeText(eliminacionActivity, "La persona ha sido eliminada exitosamente", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(eliminacionActivity, "La persona NO pudo ser eliminada, intentelo de nuevo mas tarde",
                                Toast.LENGTH_SHORT).show();
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