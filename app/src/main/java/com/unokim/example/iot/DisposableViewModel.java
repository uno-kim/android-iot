package com.unokim.example.iot;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class DisposableViewModel extends AndroidViewModel {

    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public DisposableViewModel(@NonNull Application application) {
        super(application);
    }

    void addDisposable(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.clear();
        super.onCleared();
    }
}
