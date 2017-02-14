package mx.amper.mascotas.Pojo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import mx.amper.mascotas.MainActivity;
import mx.amper.mascotas.R;

public class Contacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        ImageButton btnBack  = (ImageButton) findViewById(R.id.ibBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Contacto.this, "Back", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Contacto.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void enviaCorreo() {
        EditText etNombte = (EditText) findViewById(R.id.etNombre);
        EditText etCorreo = (EditText) findViewById(R.id.etCorreo);
        EditText etMensaje = (EditText) findViewById(R.id.etComentarios);

        Log.i("Send email", "");
        String[] TO = {"a@a.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hola, soy " +  etNombte.getText());
        emailIntent.putExtra(Intent.EXTRA_TEXT, etMensaje.getText());

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
