package ga.leliadoura.dam2.tarea2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private Button boton1, boton2, boton3, botonc;
    Random random = new Random();

    private int i = 0;
    private Double d = 0.0;
    private String str = "";
    private static final int ACTIVIDAD1 = 1;
    private static final int ACTIVIDAD2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            i = savedInstanceState.getInt("id_i", 0);
            d = savedInstanceState.getDouble("id_d", 0.0);
            str = savedInstanceState.getString("str");
        } else {
            i = 0;
            d = 0.0;
            str = "";
        }


        boton1 = (Button)findViewById(R.id.button1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b1intent = new Intent(MainActivity.this, Actividad1.class);
                i = (int) (random.nextDouble()*11);
                b1intent.putExtra("datoExtra", i);
                startActivityForResult(b1intent, ACTIVIDAD1);
                //Log.i("valor", String.valueOf(i));
            }
        });

        boton2 = (Button)findViewById(R.id.button2);
        boton2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent b2intent = new Intent(MainActivity.this, Actividad2.class);
                b2intent.setData(Uri.parse("www.alumnodam213.com"));
                startActivityForResult(b2intent, ACTIVIDAD2);

            }
        });

        boton3 = (Button)findViewById(R.id.button3);
        boton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent b3intent = new Intent(Intent.ACTION_DIAL);
                startActivity(b3intent);

            }
        });

        botonc = (Button) findViewById(R.id.buttoncomp);
        botonc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("valor", String.valueOf(i));
                Log.i("valor", String.valueOf(d));
                Log.i("valor", str);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == ACTIVIDAD1){
            d = data.getDoubleExtra("rndD", 0);
            //Log.i("valor", String.valueOf(d));

        }
        if(requestCode == ACTIVIDAD2){
            str = data.getStringExtra("textoAct2");
            //Log.i("valor", str);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("id_i", i);
        outState.putDouble("id_d", d);
        outState.putString("str", str);
        super.onSaveInstanceState(outState);
    }

}
