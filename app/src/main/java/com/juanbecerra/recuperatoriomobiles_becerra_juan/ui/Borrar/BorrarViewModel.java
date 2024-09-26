package com.juanbecerra.recuperatoriomobiles_becerra_juan.ui.Borrar;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.juanbecerra.recuperatoriomobiles_becerra_juan.Inmueble;
import com.juanbecerra.recuperatoriomobiles_becerra_juan.MainActivity;

import java.util.ArrayList;

public class BorrarViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<Inmueble> mInmueble;

    public BorrarViewModel (){
        mInmueble= new MutableLiveData<>();
    }

    public MutableLiveData<Inmueble> getmInmueble() {
        return mInmueble;
    }

    public void setmInmueble(Inmueble i) {
        mInmueble.setValue(i);

    }

    public void  buscarInmueblePorCodigo(ArrayList<Inmueble> lista, int codigo)
    {

        Inmueble aux = new Inmueble();

        aux.setCodigo(codigo);
        if(lista.contains(aux)){
            setmInmueble(lista.get(lista.indexOf(aux)));

        }else{
            setmInmueble(null);
        }
    }




}