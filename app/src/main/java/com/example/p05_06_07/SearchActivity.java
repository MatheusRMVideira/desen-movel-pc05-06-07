package com.example.p05_06_07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.example.p05_06_07.adapter.MyRecycler;
import com.example.p05_06_07.bookService.BookRepository;
import com.example.p05_06_07.databinding.ActivitySearchBinding;
import com.example.p05_06_07.persistence.BookDao;
import com.example.p05_06_07.persistence.BookDatabase;
import com.google.android.material.snackbar.Snackbar;

public class SearchActivity extends AppCompatActivity {
    ActivitySearchBinding binding;
    private SearchActivityViewModel viewModel;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recyclerView = binding.bookRecycler;

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        viewModel = new ViewModelProvider(this).get(SearchActivityViewModel.class);
        viewModel.getBookList().observe(this, bookList -> {
            adapter = new MyRecycler(bookList);
            recyclerView.setAdapter(adapter);
        });

        viewModel.getErrorMessage().observe(this, errorMsg -> {
            Snackbar.make(binding.constraintLayout, "Error: " + errorMsg, Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK", v -> {})
                    .show();
        });

        binding.getButton.setOnClickListener(v -> {
            viewModel.getBookByTitle(SearchActivity.this.isNetworkAvailable(), String.valueOf(this.binding.userTitle.getText()), this);
        });
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
