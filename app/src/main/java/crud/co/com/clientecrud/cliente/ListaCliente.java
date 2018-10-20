package crud.co.com.clientecrud.cliente;


import android.app.Activity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import crud.co.com.clientecrud.constantes.Constantes;
import crud.co.com.clientecrud.dto.PersonaDTO;
import cz.msebera.android.httpclient.Header;

public class ListaCliente {

    public void start(final Activity activityLista, final List<PersonaDTO> listaPersonas) {

        final AsyncHttpClient client = new AsyncHttpClient();
        String uri = Constantes.URL_LISTAR;
        try {
            client.get(uri, null, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                    try {

                        System.out.println(response);


                        for (int item = 0; item< response.length(); item++) {

                            JSONObject objetoJson = response.getJSONObject(item);

                            System.out.println(objetoJson);

                            Integer id = objetoJson.getInt("id");
                            String nombre = objetoJson.getString("nombre");
                            String apellidos = objetoJson.getString("apellidos");
                            String telefono = objetoJson.getString("telefono");

                            PersonaDTO personaDTO = new PersonaDTO(id, nombre, apellidos, telefono);
                            listaPersonas.add(personaDTO);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
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
