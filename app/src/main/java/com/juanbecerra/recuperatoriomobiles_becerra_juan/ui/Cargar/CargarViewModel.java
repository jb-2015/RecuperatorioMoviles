package com.juanbecerra.recuperatoriomobiles_becerra_juan.ui.Cargar;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.juanbecerra.recuperatoriomobiles_becerra_juan.Inmueble;

public class CargarViewModel extends ViewModel {
    private MutableLiveData<Inmueble> mInmueble;

    public CargarViewModel() {
        mInmueble = new MutableLiveData<>();
    }

    public MutableLiveData<Inmueble> getmInmueble() {
        return mInmueble;
    }

    public void setLiveInmueble(Inmueble i) {
        mInmueble.setValue(i);
    }
}
