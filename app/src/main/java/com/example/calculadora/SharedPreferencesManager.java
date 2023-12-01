package com.example.calculadora;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {
    private static final String PREF_NAME = "Ulima Operacion";
    private static final String KEY_MY_VALUE = "operacion";

    public static void saveMyValue(Context context, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Guardar el valor en SharedPreferences
        editor.putString(KEY_MY_VALUE, value);
        editor.apply();
    }

    public static String getMyValue(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        // Obtener el valor desde SharedPreferences
        // El segundo parámetro es el valor predeterminado si no se encuentra la clave
        return sharedPreferences.getString(KEY_MY_VALUE, null);
    }
}
