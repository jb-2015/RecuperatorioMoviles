package com.juanbecerra.recuperatoriomobiles_becerra_juan.ui.Cargar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.juanbecerra.recuperatoriomobiles_becerra_juan.Inmueble;
import com.juanbecerra.recuperatoriomobiles_becerra_juan.MainActivity;
import com.juanbecerra.recuperatoriomobiles_becerra_juan.R;
import com.juanbecerra.recuperatoriomobiles_becerra_juan.databinding.FragmentCargarBinding;

public class Cargar extends Fragment {

    private CargarViewModel mViewModel;

    public static Cargar newInstance() {
        return new Cargar();
    }
    private FragmentCargarBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding= FragmentCargarBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CargarViewModel.class);

        binding.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Inmueble i = new Inmueble(
                        Integer.parseInt(binding.etCodigo.getText().toString()),
                        binding.etDescripcion.getText().toString(),
                        Integer.parseInt(binding.etCantAmbientes.getText().toString()),
                        Float.parseFloat(binding.etPrecio.getText().toString())
                );

                mViewModel.setLiveInmueble(i);
            }
        });

        mViewModel.getmInmueble().observe(getViewLifecycleOwner(), new Observer<Inmueble>() {
            @Override
            public void onChanged(Inmueble inmueble) {
                MainActivity.inmuebles.add(inmueble);
                Toast.makeText(getActivity(),"Se agrego inmueble",Toast.LENGTH_SHORT).show();
            }
        });
    }


}