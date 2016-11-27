package com.example.musto.aik;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onclickme(View v){
//        Intent i=new Intent(MainActivity.this,layout2.class);
//        startActivity(i);
        Intent i=new Intent(this,layout2.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.about:
                Intent i=new Intent(this,est.class);
                startActivity(i);
                break;
            case R.id.order:
                Intent a=new Intent(this,layout2.class);
                startActivity(a);
                break;
            case R.id.quit:
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("Anda Yakin Ingin Keluar");
                builder.setPositiveButton("ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog quit=builder.create();
                quit.show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
