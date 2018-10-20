package crud.co.com.clientecrud.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import crud.co.com.clientecrud.R;
import crud.co.com.clientecrud.cliente.ListaCliente;
import crud.co.com.clientecrud.dto.PersonaDTO;
import crud.co.com.clientecrud.util.CustomAdapter;
import crud.co.com.clientecrud.util.ItemLista;
import crud.co.com.clientecrud.util.ViewUtil;

public class ListaActivity extends AppCompatActivity {

    private ViewUtil viewUtil;
    private ListView listViewListaPersonas;
    private CustomAdapter customAdapter;
    private ListaCliente listaCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        initComponents();
        cargarLista();
    }

    private void initComponents() {
        viewUtil = new ViewUtil(this);
        viewUtil.setToolBar("Personas");
        listViewListaPersonas = findViewById(R.id.listViewListaPersonas);
        listaCliente = new ListaCliente();
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    private void cargarLista() {
        List<ItemLista> listaPersonas = new ArrayList<>();
        List<PersonaDTO> listaDePersonas = new ArrayList<>();

        listaCliente.start(this, listaDePersonas);

        for (PersonaDTO persona: listaDePersonas) {
           listaPersonas.add(new ItemLista(R.drawable.ic_usuario, String.valueOf(persona.getId()),
                                           persona.getNombre(), persona.getApellidos()));
        }

        customAdapter = new CustomAdapter(this, listaPersonas);
        listViewListaPersonas.setAdapter(customAdapter);
        listViewListaPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemLista itemLista = (ItemLista) listViewListaPersonas.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), itemLista.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
