package com.example.p05_06_07;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.p05_06_07.bookService.BookRepository;
import com.example.p05_06_07.bookService.response.Main;

import java.util.List;

public class SearchActivityViewModel extends ViewModel {
    private final MutableLiveData<String> title = new MutableLiveData<>();
    private final MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private final MutableLiveData<List<Main>> bookList = new MutableLiveData<>();

    public void getBookByTitle(boolean isConnected, String titleArg, Context ctx) {
        title.setValue("");
        if (!isConnected) {
            errorMessage.setValue("Sem internet. Tente novamente mais tarde");
            return;
        }

        BookRepository.getBookByTitle(titleArg, new BookRepository.BookCallback() {
            @Override
            public void onSuccess(List<Main> rbookList) {
                title.setValue(titleArg);
                bookList.setValue(rbookList);
            }

            @Override
            public void onError(String msg) {
                errorMessage.setValue(msg);
            }
        }, ctx);
    }

    public MutableLiveData<String> getTitle() {
        return title;
    }

    public MutableLiveData<List<Main>> getBookList() {
        return bookList;
    }

    public MutableLiveData<String> getErrorMessage() {
        return errorMessage;
    }
}
