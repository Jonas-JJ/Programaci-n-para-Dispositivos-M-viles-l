package com.ucenm.appucenmpm01.Controlers;

import com.ucenm.appucenmpm01.Database.DBconfig;
import com.ucenm.appucenmpm01.Database.DatabaseHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.ucenm.appucenmpm01.Database.DatabaseHelper;
import com.ucenm.appucenmpm01.Models.Persona;

public class PersonaController
{
    private final DatabaseHelper databaseHelper;

    public PersonaController(Context context)
    {
        databaseHelper = new DatabaseHelper(context);
    }

    //Metodos crud
    public long AddPerson(Persona persona)
    {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(DBconfig.COLUMN_NAME, persona.getNombres());
        valores.put(DBconfig.COLUMN_APELLIDOS, persona.getApellidos());
        valores.put(DBconfig.COLUMN_FECHANAC, persona.getFechanac());
        valores.put(DBconfig.COLUMN_DIRECCION, persona.getDireccion());
        valores.put(DBconfig.COLUMN_TELEFONO, persona.getTelefono());
        valores.put(DBconfig.COLUMN_CORREO, persona.getCorreo());

        Long resultado = db.insert(DBconfig.DROP_TABLE_PERSONAS, null, valores);

        db.close();

        return resultado;
    }
}
