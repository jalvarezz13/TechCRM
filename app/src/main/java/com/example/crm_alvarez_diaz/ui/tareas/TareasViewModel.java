package com.example.crm_alvarez_diaz.ui.tareas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TareasViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TareasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ventana tareas");
    }

    public LiveData<String> getText() {
        return mText;
    }
}