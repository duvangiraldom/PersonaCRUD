package crud.co.com.clientecrud.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import crud.co.com.clientecrud.R;
import crud.co.com.clientecrud.cliente.RegistroCliente;
import crud.co.com.clientecrud.dto.PersonaDTO;
import crud.co.com.clientecrud.util.ViewUtil;


public class RegistroActivity extends AppCompatActivity {

    private EditText txtNombre;
    private  EditText txtApellido;
    private EditText txtTelefono;
    private ViewUtil viewUtil;
    private RegistroCliente registroCliente;
    private PersonaDTO personaDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        initComponents();
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    private void initComponents(){
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtTelefono = findViewById(R.id.txtTelefono);
        viewUtil = new ViewUtil(this);
        viewUtil.setToolBar("Registro");
        registroCliente = new RegistroCliente();
    }

    public void registrarOnClick(View view) {
        if(validate()) {
            personaDTO = new PersonaDTO(1, txtNombre.getText().toString(), txtApellido.getText().toString(), txtTelefono.getText().toString());
            registroCliente.start(this, personaDTO);
            borrarCampos();
        }
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

    private void borrarCampos(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
    }
}
