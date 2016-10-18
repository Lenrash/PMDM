package ga.leliadoura.dam2.tarea2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Actividad2 extends Activity{

    private Uri u;
    Button botonc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_actividad2);

        u = getIntent().getData();

        //TOAST-------------------------------------------
        Context context = getApplicationContext();
        CharSequence text = "Valor de u: "+ String.valueOf(u);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        //------------------------------------------------
        // BOTON COMPROBAR--------------------------------
        botonc = (Button) findViewById(R.id.buttoncomp);
        botonc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("valor", String.valueOf(u));

            }
        });
        //------------------------------------------------
    }

    @Override
    public void onBackPressed() {
        Intent intAct2 = new Intent();
        intAct2.putExtra("textoAct2", "La respuesta de la vida, el universo y todo lo demás es... 42.");
        setResult(RESULT_OK, intAct2);
        finish();
    }
}
