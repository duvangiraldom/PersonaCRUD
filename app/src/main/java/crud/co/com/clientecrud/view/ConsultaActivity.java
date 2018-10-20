package crud.co.com.clientecrud.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import crud.co.com.clientecrud.R;
import crud.co.com.clientecrud.cliente.ConsultaCliente;
import crud.co.com.clientecrud.util.ViewUtil;


public class ConsultaActivity extends AppCompatActivity {

    private TextView lbNombre;
    private TextView lbApellido;
    private  TextView lbTelefono;
    private TextView txtNombre;
    private TextView txtApellido;
    private TextView txtTelefono;
    private EditText txtId;
    private ViewUtil viewUtil;
    private ConsultaCliente consultaCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        initComponents();
        showComponents(View.GONE);
    }

    private void initComponents(){
        lbNombre = findViewById(R.id.lbNombre);
        lbApellido = findViewById(R.id.lbApellido);
        lbTelefono = findViewById(R.id.lbTelefono);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtId = findViewById(R.id.txtId);
        viewUtil = new ViewUtil(this);
        viewUtil.setToolBar("Consultar");
        consultaCliente = new ConsultaCliente();
    }


    private void showComponents(int gone) {
        lbNombre.setVisibility( gone);
        lbApellido.setVisibility(gone);
        lbTelefono.setVisibility(gone);
        txtNombre.setVisibility(gone);
        txtApellido.setVisibility(gone);
        txtTelefono.setVisibility(gone);
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    public void consultarOnClick(View view) {
        int id = "".equals(txtId.getText().toString()) ? 0 : Integer.parseInt(txtId.getText().toString());
        if(validateId(id)){
            consultaCliente.start(this, id, txtNombre, txtApellido, txtTelefono);
            showComponents(View.VISIBLE);
        }
    }

    private boolean validateId(int id) {
        txtId.setError(null);
        boolean esValido = true;
        if(id == 0){
            esValido = false;
            txtId.setError(getString(R.string.requerido));
        }
        return esValido;
    }
}
