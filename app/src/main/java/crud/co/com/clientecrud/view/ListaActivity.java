package crud.co.com.clientecrud.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


import crud.co.com.clientecrud.R;
import crud.co.com.clientecrud.cliente.ListaCliente;
import crud.co.com.clientecrud.util.ViewUtil;

public class ListaActivity extends AppCompatActivity {

    private ViewUtil viewUtil;
    private ListView listViewListaPersonas;
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

        listaCliente.start(this, listViewListaPersonas);

    }
}
