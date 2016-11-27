package com.example.musto.aik;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class layout2 extends AppCompatActivity {
EditText mEditTextYourName;
    Button mButtonOrder;
    Context mcontext;
    RadioGroup mradiogroup;
    RadioButton mradiobuttonblue,mradiobuttoncokelat;
    Spinner mspinner;
    List<String> mlistmenu=new ArrayList<>();
    int harga=0;
    int qty=0;
    TextView mTextQty,mTextHarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mEditTextYourName=(EditText)  findViewById(R.id.mEditextYourName);
        mButtonOrder=(Button) findViewById(R.id.mButtonOrder);
        mradiogroup = (RadioGroup) findViewById(R.id.mradiogroup);
        mradiobuttonblue= (RadioButton) findViewById(R.id.mRadioBlue);
        mradiobuttoncokelat= (RadioButton) findViewById(R.id.mRadioCokelat);
        mcontext=getApplicationContext();
        mspinner=(Spinner)findViewById(R.id.spinner1);
        mTextHarga=(TextView) findViewById(R.id.mTextViewHarga );
        mTextQty=(TextView) findViewById(R.id.mTextViewQty);


        mlistmenu.add("---------");
        mlistmenu.add("Martabak");
        mlistmenu.add("Piscok Bakar");
        mlistmenu.add("Ice cream sandwich");
      ArrayAdapter<String> dataadapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,mlistmenu);
        dataadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinner.setAdapter(dataadapter);

        mradiobuttonblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext,"Item Blue dipilih",Toast.LENGTH_LONG).show();
            }
        });
        mradiobuttoncokelat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(layout2.this, "Item Cokelat dipilih", Toast.LENGTH_LONG).show();
            }
        });

//        mButtonOrder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),mEditTextYourName.getText(),Toast.LENGTH_LONG).show();
//            }
//        });

    }
    public void ordert(View view){
        Intent emailintent=new Intent(Intent.ACTION_SEND);
        emailintent.setData(Uri.parse("mailto:"));
        emailintent.setType("Text/Plain");
        emailintent.putExtra(Intent.EXTRA_EMAIL,"arieridwansyah@gmail.com");
        emailintent.putExtra(Intent.EXTRA_SUBJECT,mEditTextYourName.getText());
        emailintent.putExtra(Intent.EXTRA_TEXT,
                "saya pesan "
        +mspinner.getSelectedItem() + " sebanyak "
        + mEditTextYourName.getText() + " seharga " +mEditTextYourName.getText());
        try{
            startActivity(Intent.createChooser(emailintent,"send mail...."));
            finish();
        } catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"there is no email client installed",Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.home){

            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
    public void onClickPlus(View view){
        harga = harga + 5;
        qty = qty + 1;
        mTextQty.setText(qty+"");
        mTextHarga.setText("$"+harga);
    }

    public void onClickMin(View view){
        if(harga != 0) {
            harga = harga - 5;
            qty = qty - 1;
            mTextQty.setText(qty+"");
            mTextHarga.setText("$"+harga);
        }
        else {
            harga = 0;
            qty = 0;
            mTextQty.setText(qty+"");
            mTextHarga.setText("$"+harga);
        }
    }

    public void onClickReset(View v){
        harga = 0;
        qty = 0;
        mEditTextYourName.setText("");
        mTextHarga.setText("$"+harga);
        mTextQty.setText(qty+"");
    }
}






