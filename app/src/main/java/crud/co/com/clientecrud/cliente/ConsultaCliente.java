package crud.co.com.clientecrud.cliente;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import crud.co.com.clientecrud.R;
import crud.co.com.clientecrud.constantes.Constantes;
import cz.msebera.android.httpclient.Header;

public class ConsultaCliente {
    public void start(final Activity activityConsulta, final Integer id,
                      final TextView txtNombre, final TextView txtApellido, final TextView txtTelefono) {

        final AsyncHttpClient client = new AsyncHttpClient();
        String uri = Constantes.URL_BUSCAR.concat("/").concat(id.toString());
        try {
            client.get(uri, null, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    if (statusCode==200) {
                        try {
                            txtNombre.setText(response.getString("nombre"));
                            txtApellido.setText(response.getString("apellidos"));
                            txtTelefono.setText(response.getString("telefono"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        if(txtNombre.getText().toString().isEmpty() || txtApellido.getText().toString().isEmpty()
                                                                    || txtTelefono.getText().toString().isEmpty()){
                            txtNombre.setText("");
                            txtApellido.setText("");
                            txtTelefono.setText("");
                            Toast.makeText(activityConsulta, R.string.datos_no_encontrados, Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        txtNombre.setText("");
                        txtApellido.setText("");
                        txtTelefono.setText("");
                        Toast.makeText(activityConsulta, R.string.datos_no_encontrados, Toast.LENGTH_SHORT).show();
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
