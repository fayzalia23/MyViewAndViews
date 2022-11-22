package com.example.myviewandviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Thread view;
    private TextView tvDeskripsi;
    private TextView tvHarga;
    String nama, deskripsi, harga, jumlah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Acer Nitro 5 AN515-56");
        }

        tvDeskripsi = findViewById(R.id.tv_deskripsi);
        tvHarga = findViewById(R.id.tv_harga);

        nama = "Acer Nitro 5 AN515-56";
        deskripsi = tvDeskripsi.getText().toString();
        harga = tvHarga.getText().toString();
        jumlah = "1";

        Button btnBeli = findViewById(R.id.btn_beli);
        btnBeli.setOnClickListener(this);

        Button btnDialPhone = findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() ==  R.id.btn_beli){
            Intent moveIntent = new Intent(MainActivity.this, MovetoBeli.class);
            moveIntent.putExtra(MovetoBeli.EXTRA_NAMA, nama);
            moveIntent.putExtra(MovetoBeli.EXTRA_DESKRIPSI, deskripsi);
            moveIntent.putExtra(MovetoBeli.EXTRA_HARGA, harga);
            moveIntent.putExtra(MovetoBeli.EXTRA_JUMLAH, jumlah);
            startActivity(moveIntent);
        }
        else if (view.getId()== R.id.btn_dial_number){
            String phoneNumber = "085327665241";
            Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            startActivity(dialPhoneIntent);
        }
    }
}