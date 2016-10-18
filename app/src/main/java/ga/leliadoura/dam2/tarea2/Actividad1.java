package ga.leliadoura.dam2.tarea2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;


public class Actividad1 extends Activity{

    Random random = new Random();
    Button botonc;

    private int i = 0;
    private Double d = 0.0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_actividad1);

        i = getIntent().getIntExtra("datoExtra", 0);
        //Log.i("valor", String.valueOf(i));

        //TOAST----------------------------------------------
        Context context = getApplicationContext();
        CharSequence text = "Valor de i: "+ String.valueOf(i);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        //----------------------------------------------------
        //BOTON COMPROBAR ------------------------------------
        botonc = (Button) findViewById(R.id.buttoncomp);
        botonc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("valor", String.valueOf(i));
                Log.i("valor", String.valueOf(d));

            }
        });
        //----------------------------------------------------
    }



    @Override
    public void onBackPressed() {
        Intent intAct1 = new Intent();
        d = random.nextDouble()*10;
        intAct1.putExtra("rndD", d);
        setResult(RESULT_OK, intAct1);
        finish();
    }
}
