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

import crud.co.com.clientecrud.R;
import crud.co.com.clientecrud.constantes.Constantes;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class EliminacionCliente {
    public void start(final Activity eliminacionActivity, final Integer id) {

        final AsyncHttpClient client = new AsyncHttpClient();
        String uri = Constantes.URL_ELIMINAR.concat("/").concat(id.toString());

        try {

            client.get(eliminacionActivity, uri, new TextHttpResponseHandler() {
                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable){
                    Log.e("", throwable.toString());
                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, String responseString) {
                    if (statusCode == 200 ) {
                        Toast.makeText(eliminacionActivity, R.string.persona_eliminada, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(eliminacionActivity, "La persona no se pudo eliminar, " +
                                "por favor intentelo más tarde", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        } catch (Exception ex) {
            Log.e("", ex.toString());
            ex.printStackTrace();
        }
    }
}
