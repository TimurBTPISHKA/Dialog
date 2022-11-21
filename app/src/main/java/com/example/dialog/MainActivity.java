package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCloseButtonClick(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Выход из приложения")
                .setIcon(R.drawable.ic_baseline_close_24)
                .setMessage("Вы уверены, что хотите закрыть приложение?")
                .setPositiveButton("ОК",
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                finish();
                            }
                        })
                .setNegativeButton("Отмена",
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog,int id){
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void choiceButtonClick(View view){
        String[] mIngredients = { "Колбаса", "Сыр", "Помидор", "Листья салата", "Огурец"};
        final boolean[] mSelectedIngredients = { false, false, false, false, false };

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Выберите ингредиенты для вашего бутерброда")
                .setIcon(R.drawable.ic)
                .setCancelable(false)
                .setMultiChoiceItems(mIngredients, null, new DialogInterface.OnMultiChoiceClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked){
                        mSelectedIngredients[which] = isChecked;
                    }
                })
                .setPositiveButton("ОК",
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                //
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();

    }
}