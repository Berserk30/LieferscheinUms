package at.ums.lieferscheinums.sqlite;

import android.provider.BaseColumns;

/**
 * Created by luna-aleixos on 29.02.2016.
 * Clase que establece los nombres a usar en la base de datos
 */
public class ContratoGestionUmsDb {

    interface ColumnasKunden {
        String ID = BaseColumns._ID;;
        String NAME = "name";
        String ADRESSE = "adresse";
        String ORT = "ort";
        String PLZ = "plz";
        String TELEFON = "telefon";
        String EMAIL = "email";
    }

    interface ColumnasLieferschein {
        String ID = BaseColumns._ID;
        String ID_KUNDE = "idKunde";
        String DATUM = "datum";
        String ARTIKEL = "artikel";
        String MENGE = "menge";
        String EH = "eh";
        String PHOTO = "photo";
        String SIGNATURE = "signature";
        String ID_MITARBEITER = "idMitarbeiter";
    }

    interface ColumnasMitarbeiter {
        String ID = BaseColumns._ID;
        String NAME = "name";
        String PRÄFIX = "präfix";
    }

    public static class Kunden implements ColumnasKunden{
        //Metodos auxiliares
    }

    public static class Lieferschein implements ColumnasLieferschein{
        //Metodos auxiliares
    }

    public static class Mitarbeiter implements ColumnasMitarbeiter{
        //Metodos auxiliares
    }


    private ContratoGestionUmsDb(){

    }

}
