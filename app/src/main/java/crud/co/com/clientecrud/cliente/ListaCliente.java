package crud.co.com.clientecrud.cliente;


import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import crud.co.com.clientecrud.R;
import crud.co.com.clientecrud.constantes.Constantes;
import crud.co.com.clientecrud.util.CustomAdapter;
import crud.co.com.clientecrud.util.ItemLista;
import cz.msebera.android.httpclient.Header;

public class ListaCliente {

    public void start(final Activity activityLista, final ListView listViewListaPersonas) {

        final List<ItemLista> listaPersonas = new ArrayList<>();

        final AsyncHttpClient client = new AsyncHttpClient();
        String uri = Constantes.URL_LISTAR;
        try {
            client.get(uri, null, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                    try {
                        for (int item = 0; item < response.length(); item++) {
                            JSONObject objetoJson = response.getJSONObject(item);

                            Integer id = objetoJson.getInt("id");
                            String nombre = objetoJson.getString("nombre");
                            String apellidos = objetoJson.getString("apellidos");
                            String telefono = objetoJson.getString("telefono");

                            //System.out.println("id: "+id.toString()+ " nombre: "+nombre+ " apellidos: "+apellidos + " telefono: "+telefono);
                            listaPersonas.add(new ItemLista(R.drawable.ic_usuario, id.toString(), nombre, apellidos));
                        }
                        CustomAdapter customAdapter = new CustomAdapter(activityLista, listaPersonas);
                        listViewListaPersonas.setAdapter(customAdapter);
                        listViewListaPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                ItemLista itemLista = (ItemLista) listViewListaPersonas.getItemAtPosition(position);
                                Toast.makeText(activityLista.getApplicationContext(), itemLista.getNombre(), Toast.LENGTH_SHORT).show();
                            }
                        });

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
