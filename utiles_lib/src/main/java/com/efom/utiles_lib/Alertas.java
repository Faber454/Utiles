package com.efom.utiles_lib;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.TextView;

public class Alertas {
    public AlertDialog createSimpleDialog(Context context) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
        TextView title = new TextView(context);
        TextView message = new TextView(context);
        builder.setCustomTitle(title);
        message.setText("    Está seguro que desea cerrar sesión?  \n");
        message.setPadding(10, 300, 10, 400);
        builder.setView(message);

        builder.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        }).setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }});
        return builder.create();
    }

    public static AlertDialog createDialogList(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Filtro").setItems(R.array.filtro, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                String hacerAdaptable =  "calendarView.getLayoutParams().height = LinearLayout.LayoutParams.WRAP_CONTENT;";
                String darLasMedidas = "calendarView.getLayoutParams().height = 180;";
            }
        });
        return builder.create();
    }
}
