package at.ums.lieferscheinums;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import at.ums.lieferscheinums.ui.LieferscheinView;

import at.ums.lieferscheinums.sqlite.OperacionesBaseDatos;

public class ActividadPrincipal extends AppCompatActivity {

    OperacionesBaseDatos datos;

    private Button mBotonAddLieferschein; //Para ejecutar el intent del boton addLieferschein


    public class TareaPruebaDatos extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... params) {
            //falta implementar todas las tareas de prueba


            //Consultas
            Log.d("Kunden", "Kunden");
            DatabaseUtils.dumpCursor(datos.obtenerKunden());

            Log.d("Lieferschein", "Lieferschein");
            DatabaseUtils.dumpCursor(datos.obtenerLieferschein());

            Log.d("Mitarbeiter", "Mitarbeiter");
            DatabaseUtils.dumpCursor(datos.obtenerMitarbeiter());
            return null;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);

        getApplicationContext().deleteDatabase("GestionUmsDb.db");
        datos = OperacionesBaseDatos.obtenerInstancia(getApplicationContext());

        new TareaPruebaDatos().execute();

        mBotonAddLieferschein = (Button) findViewById(R.id.buttonAddLieferschein);
        mBotonAddLieferschein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreAddLieferschein();
            }
        });


    }


    private void abreAddLieferschein(){
        Intent intento = new Intent(this, LieferscheinView.class);
        startActivity(intento);

    }


}
