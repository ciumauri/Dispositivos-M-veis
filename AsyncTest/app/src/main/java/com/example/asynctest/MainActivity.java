package com.example.asynctest;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asynctest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnProcessar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ProcessarTask task = new ProcessarTask(binding.btnProcessar, binding.txtStatus, binding.pgbProgresso);
        binding.pgbProgresso.setMax(15);
        task.execute(15);
    }
}