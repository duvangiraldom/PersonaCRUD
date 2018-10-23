package crud.co.com.clientecrud.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import crud.co.com.clientecrud.R;
import crud.co.com.clientecrud.cliente.ActualizacionCliente;
import crud.co.com.clientecrud.cliente.ConsultaCliente;
import crud.co.com.clientecrud.dto.PersonaDTO;
import crud.co.com.clientecrud.util.Converter;
import crud.co.com.clientecrud.util.ViewUtil;

public class ActualizacionActivity extends AppCompatActivity {

    private EditText txtIdABuscar;
    private TextView txtId;
    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtTelefono;
    private Button btnActualizar;
    private ViewUtil viewUtil;
    private ConsultaCliente consultaCliente;
    private ActualizacionCliente actualizacionCliente;
    private PersonaDTO personaDTO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizacion);
        initComponents();
        showComponents(View.GONE);
    }

    private void initComponents(){
        txtIdABuscar = findViewById(R.id.txtIdABuscar);
        txtId = findViewById(R.id.txtId);
        txtId.setEnabled(false);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtTelefono = findViewById(R.id.txtTelefono);
        btnActualizar = findViewById(R.id.btnActualizar);
        viewUtil = new ViewUtil(this);
        consultaCliente = new ConsultaCliente();
        actualizacionCliente= new ActualizacionCliente();
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    private void showComponents(int gone) {
        txtId.setVisibility( gone);
        txtNombre.setVisibility(gone);
        txtApellido.setVisibility(gone);
        txtTelefono.setVisibility(gone);
        btnActualizar.setVisibility(gone);
        viewUtil.setToolBar("Actualizar");
    }

    public void consultarOnClick(View view) {
        int id = "".equals(txtIdABuscar.getText().toString()) ? 0 : Integer.parseInt(txtIdABuscar.getText().toString());
        if(validateId(id)){
            consultaCliente.start(this, id, txtNombre, txtApellido, txtTelefono);
            txtId.setText(txtIdABuscar.getText().toString());
            showComponents(View.VISIBLE);
        }
    }


    public void actualizarOnClick(View view) {
        if(validate()){
            personaDTO = new PersonaDTO(Converter.StringToInteger(txtId.getText().toString()), txtNombre.getText().toString(), txtApellido.getText().toString(), txtTelefono.getText().toString());
            actualizacionCliente.start(this, personaDTO);
        }
        else{
            Toast.makeText(this, R.string.persona_no_actualizada, Toast.LENGTH_SHORT).show();
        }
        vaciarCampos();
    }

    private void vaciarCampos() {
        txtIdABuscar.setText("");
        txtId.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        showComponents(View.GONE);
    }

    private boolean validateId(int id) {
        txtIdABuscar.setError(null);
        boolean esValido = true;
        if(id == 0){
            esValido = false;
            txtIdABuscar.setError(getString(R.string.requerido));
        }
        return esValido;
    }

    private boolean validate(){
        txtNombre.setError(null);
        txtApellido.setError(null);
        txtTelefono.setError(null);
        boolean esValido = true;
        if("".equals(txtNombre.getText().toString())){
            esValido = false;
            txtNombre.setError(getString(R.string.existe_nombre_persona));
        }
        if("".equals(txtApellido.getText().toString())){
            esValido = false;
            txtApellido.setError(getString(R.string.existe_apellido_persona));
        }
        if("".equals(txtTelefono.getText().toString())){
            esValido = false;
            txtTelefono.setError(getString(R.string.existe_telefono_persona));
        }
        return  esValido;
    }
}
