package com.example.athaya.athayaputrislavia_1202150252_studycase4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.InputStream;

public class Main3Activity extends AppCompatActivity {

    //mendeklarasikan objek yang digunakan
    EditText URL;
    Button Klik;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //mengambil id dari objek yang telah dideklarasikan
        URL = findViewById(R.id.url);
        Klik = findViewById(R.id.klik);
        image = findViewById(R.id.gambar);
    }

    public void Cari(View view) {

        //untuk mengambil niali dari url gambar yang dicari
        String UrlGambar = URL.getText().toString();
        //untuk menggambil gambar sesuai dengan urlnya tersebut
        new DownloadGambar().execute(UrlGambar);
    }

    class DownloadGambar extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Bitmap doInBackground(String... voids) {

            String imageURL = voids[0];

            Bitmap bitmap = null;
            try {

                // mendownload gambar dari url yang dicari
                InputStream input = new java.net.URL(imageURL).openStream();

                // menjadikan input dari url ke bitmap
                bitmap = BitmapFactory.decodeStream(input);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {

            // mengeset bitmap ke dalam imageView yang sudah di sediakan
            image.setImageBitmap(result);

        }
    }
}
