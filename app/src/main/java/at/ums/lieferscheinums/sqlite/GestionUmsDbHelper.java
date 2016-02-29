package at.ums.lieferscheinums.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.provider.BaseColumns;

import at.ums.lieferscheinums.sqlite.ContratoGestionUmsDb.Kunden;
import at.ums.lieferscheinums.sqlite.ContratoGestionUmsDb.Lieferschein;
import at.ums.lieferscheinums.sqlite.ContratoGestionUmsDb.Mitarbeiter;

/**
 * Created by luna-aleixos on 29.02.2016.
 * Clase que administra la conexión de la base de datos y su estructuración
 */
public class GestionUmsDbHelper extends SQLiteOpenHelper {

    //Creamos las variables generales de la Db

    private static final int version = 1;
    private static final String nombreDb = "GestionUmsDb";
    private final Context contexto;

    interface Tablas {
        String KUNDEN = "kunden";
        String LIEFERSCHEIN = "lieferschein";
        String MITARBEITER = "mitarbeiter";

    }

    interface Referencias {
        String ID_KUNDEN = String.format("REFERENCES %s(%s) ON DELETE CASCADE",
                Tablas.KUNDEN, Kunden.ID);

        String ID_MITARBEITER = String.format("REFERENCES %s(%s)",
                Tablas.MITARBEITER, Mitarbeiter.ID);

        String ID_LIEFERSCHEIN = String.format("REFERENCES %s(%s)",
                Tablas.LIEFERSCHEIN, Lieferschein.ID);
    }


    public GestionUmsDbHelper(Context contexto) {
        super(contexto, nombreDb, null, version);
        this.contexto = contexto;
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
                db.setForeignKeyConstraintsEnabled(true);
            }else{
                db.execSQL("PRAGMA foreign_keys=ON");
            }
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creamos tabla Kunden
        db.execSQL( "CREATE TABLE " + Tablas.KUNDEN +
                "( " + Kunden.ID + " TEXT PRIMARY KEY," +
                Kunden.NAME +" TEXT," +
                Kunden.ADRESSE +" TEXT," +
                Kunden.ORT +" TEXT," +
                Kunden.PLZ +" TEXT," +
                Kunden.TELEFON +" TEXT," +
                Kunden.EMAIL +" TEXT)");


        //Creamos tabla Lieferschein
        db.execSQL("CREATE TABLE "+ Tablas.LIEFERSCHEIN +
                "( " + Lieferschein.ID + " TEXT PRIMARY KEY," +
                Lieferschein.ID_KUNDE + " TEXT CONSTRAINT kundeFK REFERENCES " + Tablas.KUNDEN +
                                "(" + Kunden.ID + ") ON DELETE CASCADE ON UPDATE CASCADE," +
                Lieferschein.DATUM + " DATE," +
                Lieferschein.ARTIKEL + " TEXT," +
                Lieferschein.MENGE + " NUMERIC," +
                Lieferschein.EH + " TEXT," +
                Lieferschein.PHOTO + " TEXT," +
                Lieferschein.SIGNATURE + " TEXT," +
                Lieferschein.ID_MITARBEITER + " TEXT CONSTRAINT mitarbeiterFK REFERENCES " +
                                Tablas.MITARBEITER + "("+ Mitarbeiter.ID +") ON DELETE CASCADE ON UPDATE CASCADE)");


        //Creamos tabla Mitarbeiter en un estilo distinto con String.format y sustituciones de "%s"
        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY," +
                        "%s TEXT NOT NULL,%s TEXT NOT NULL,%s TEXT NOT NULL)",
                Tablas.MITARBEITER, BaseColumns._ID,
                Mitarbeiter.ID, Mitarbeiter.NAME, Mitarbeiter.PRÄFIX));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.KUNDEN);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.LIEFERSCHEIN);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.MITARBEITER);

        onCreate(db);
    }
}
