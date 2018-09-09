package com.osmananilozcan.kalicidegiskenler;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int sayac = 0;
    Button btnSayac;
    TextView tvSayac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSayac = findViewById(R.id.tvSayac);

        // Bir değişiklik olduysa burası çalışacak.
        if (savedInstanceState != null) {
            sayac = savedInstanceState.getInt("sayac");
            tvSayac.setText("Sayaç: " + sayac);
        } else { // Bir değişiklik olmadıysa yani uygulama ilk kez açıldığında çalışacak yer.
            sayac = 0;
        }

        btnSayac = findViewById(R.id.btnSayac);
        btnSayac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayac++;
                tvSayac.setText("Sayaç: " + sayac);
            }
        });
    }

    // protected olmasına dikkat edin.
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Değişen değeri buradan alıyor. If içerisinde burada verilen etiket ile çağırılıyor.
        outState.putInt("sayac", sayac);
    }
}
