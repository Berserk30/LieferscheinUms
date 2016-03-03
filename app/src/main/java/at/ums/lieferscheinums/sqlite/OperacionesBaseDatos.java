package at.ums.lieferscheinums.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;


import at.ums.lieferscheinums.sqlite.GestionUmsDbHelper.Tablas;
import at.ums.lieferscheinums.modelo.Kunden;
import at.ums.lieferscheinums.modelo.Lieferschein;
import at.ums.lieferscheinums.modelo.Mitarbeiter;
/**
 * Created by luna-aleixos on 29.02.2016.
 *  * Clase auxiliar que implementa a {@link GestionUmsDbHelper para llevar a cabo el CRUD
 * sobre las entidades existentes.
 */
public final class OperacionesBaseDatos {

    private static GestionUmsDbHelper baseDatos;
    private static OperacionesBaseDatos instancia = new OperacionesBaseDatos();

    private OperacionesBaseDatos(){
    }

    public static OperacionesBaseDatos obtenerInstancia(Context contexto) {
        if (baseDatos == null) {
            baseDatos = new GestionUmsDbHelper(contexto);
        }
        return instancia;
    }

    // OPERACIONES KUNDEN

    public Cursor obtenerKunden() {
        SQLiteDatabase db = baseDatos.getReadableDatabase();

        String sql = "SELECT * FROM " + Tablas.KUNDEN;

        return db.rawQuery(sql, null);
    }

    // OPERACIONES LIEFERSCHEIN

    public Cursor obtenerLieferschein() {
        SQLiteDatabase db = baseDatos.getReadableDatabase();

        String sql = "SELECT * FROM " + Tablas.LIEFERSCHEIN;

        return  db.rawQuery(sql, null);
    }


    public String insertarLieferschein(Lieferschein lieferschein) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

//        // Generar Pk
//        String idCabeceraPedido = Lieferschein.generarIdCabeceraPedido();

        ContentValues valores = new ContentValues();
        valores.put(Lieferschein., lieferschein.ID);
        valores.put(Lieferschein.DATUM, lieferschein.DATUM);
        valores.put(Lieferschein., pedido.idCliente);
        valores.put(CabecerasPedido.ID_FORMA_PAGO, pedido.idFormaPago);

        // Insertar cabecera
        db.insertOrThrow(Tablas.CABECERA_PEDIDO, null, valores);

        return idCabeceraPedido;
    }




    // OPERACIONES MITARBEITER

    public Cursor obtenerMitarbeiter() {
        SQLiteDatabase db = baseDatos.getReadableDatabase();

        String sql = "SELECT * FROM " + Tablas.MITARBEITER;

        return  db.rawQuery(sql, null);
    }

//    public String insertarMitarbeieter(Mitarbeiter mitarbeiter) {
//        ContentValues valores = new ContentValues();
//        // Generar Pk??
//        valores.put(Mitarbeiter.ID, mitarbeiter.idMitarbeiter);
//        valores.put(Mitarbeiter.NAME, mitarbeiter.);
//    }


}
