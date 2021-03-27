package com.example.crm_alvarez_diaz.ui.proveedores;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProveedoresViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ProveedoresViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ventana proveedores");
    }

    public LiveData<String> getText() {
        return mText;
    }
}