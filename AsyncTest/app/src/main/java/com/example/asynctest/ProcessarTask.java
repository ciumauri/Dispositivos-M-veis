package com.example.asynctest;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProcessarTask extends AsyncTask<Integer, Integer, Void> {
    private Button btnProcessar;
    private TextView txtStatus;
    private ProgressBar pgbProgresso;

    public ProcessarTask(Button btnProcessar, TextView txtStatus, ProgressBar pgbProgresso) {
        this.btnProcessar = btnProcessar;
        this.txtStatus = txtStatus;
        this.pgbProgresso = pgbProgresso;
    }

    @Override
    protected void onPreExecute() {
        pgbProgresso.setVisibility(View.VISIBLE);
        pgbProgresso.setMax(15);
        pgbProgresso.setProgress(0);
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        int max = integers[0];
        for (int i=0; i<=max; i++){
            SystemClock.sleep(1000);
            publishProgress(i);
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
         int progress = values[0];
        pgbProgresso.setProgress(progress);
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        pgbProgresso.setVisibility(View.INVISIBLE);
        txtStatus.setText("Processamento concluído");
    }
}
