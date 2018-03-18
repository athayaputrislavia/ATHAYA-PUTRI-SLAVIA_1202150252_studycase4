package com.example.athaya.athayaputrislavia_1202150252_studycase4;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    //membuat array yang berisi nama mahasiswa
    private String[] nama = { "Arnes","Anggita", "Anita", "Ambar", "Bagas", "Bima", "Budi", "Bambang",
            "Caca", "Deni", "Dennis", "Dinar","Raihan", "Zaky", "Zeze"};

    //mendeklarasikan objek yang digunakan
    ListView listView;
    Button btnmulai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //memanggil id dari objek yang telah dideklarasikan
        listView = findViewById(R.id.listnama);
        btnmulai = findViewById(R.id.mulai);

        //mengeset adapter array
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,new ArrayList<String>()));

        }

        @Override
         public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    //membuat aktivitas dari button AsyncTask
        public void Mulaii(View view) {
        new mytask().execute();
    }

        class mytask extends AsyncTask<Void,String,String>{

        //mendeklarasikan arrayadapter, progress dialog dan kondisi
        ArrayAdapter<String> adapter;
        ProgressDialog progressdialog;
        int count;


        @Override
        protected void onPreExecute() {
            //mengambil adapter dari array yang telah dibuat
            adapter = (ArrayAdapter<String>)listView.getAdapter();

            //membuat object progress dialog
            progressdialog = new ProgressDialog(Main2Activity.this);
            //menetapkan judul progress dialog
            progressdialog.setTitle("Loading...");
            progressdialog.setProgressStyle(progressdialog.STYLE_HORIZONTAL);
            progressdialog.setMax(15);
            progressdialog.setProgress(0);
            //menampilkan progress dialog
            progressdialog.show();
            //memastikan perhitungan sebelum di jalankan = 0
            count = 0;
        }


        @Override
        protected String doInBackground(Void... voids) {
            //membuat perulangan untuk memunculkan nama mahasiswa
            for (String namamhs : nama){
                publishProgress(namamhs);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            //mengembalikan nilai dengan tulisan
            return "Data sudah lengkap";
        }

        @Override
        protected void onProgressUpdate(String... values) {

            //amemluai dari array 0
            adapter.add(values[0]);

            //hitungan pada saat progress dialog berjalan
            count++;

            //mengeset hitungan di dalam progress dialog
            progressdialog.setProgress(count);
        }

        @Override
        protected void onPostExecute(String result) {
        //menampilkan nilai dari return yang ada di method doInBackground
            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
            //setelah loading progress sudah full maka otomatis akan hilang progress dialognya
            progressdialog.hide();


        }

    }


}
