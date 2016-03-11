package at.ums.lieferscheinums.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import at.ums.lieferscheinums.R;
import at.ums.lieferscheinums.sqlite.OperacionesBaseDatos;


public class LieferscheinView extends AppCompatActivity {

    private EditText etLieferscheinnummer, etDatum, etBemerkung, etMenge, etEH;
    private ImageView imageViewPhoto, imageViewSignature;
    private Button mBotonZuruck, mBotonSpeichern, mBotonSenden;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lieferschein_view);

        etLieferscheinnummer = (EditText) findViewById(R.id.etLieferscheinnummer);
        etDatum = (EditText) findViewById(R.id.etDatum);
        etBemerkung = (EditText) findViewById(R.id.etBemerkung);
        etMenge = (EditText) findViewById(R.id.etMenge);
        etEH = (EditText) findViewById(R.id.etEH);
        imageViewPhoto = (ImageView) findViewById(R.id.imageViewPhoto);
        imageViewSignature = (ImageView) findViewById(R.id.imageViewSignature);

        mBotonSpeichern = (Button)findViewById(R.id.buttonSpeichern);
        mBotonSpeichern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }




}
