package com.juanbecerra.recuperatoriomobiles_becerra_juan.ui.Borrar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.juanbecerra.recuperatoriomobiles_becerra_juan.Inmueble;
import com.juanbecerra.recuperatoriomobiles_becerra_juan.MainActivity;
import com.juanbecerra.recuperatoriomobiles_becerra_juan.R;
import com.juanbecerra.recuperatoriomobiles_becerra_juan.databinding.FragmentBorrarBinding;

public class Borrar extends Fragment {

    private BorrarViewModel mViewModel;
    private FragmentBorrarBinding bind;

    public static Borrar newInstance() {
        return new Borrar();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        bind = FragmentBorrarBinding.inflate(inflater,container,false);
        return bind.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BorrarViewModel.class);
        // TODO: Use the ViewModel
        bind.etCodigoBuscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mViewModel.buscarInmueblePorCodigo(MainActivity.inmuebles,Integer.parseInt(bind.etCodigoBuscar.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mViewModel.getmInmueble().observe(getViewLifecycleOwner(), new Observer<Inmueble>() {
            @Override
            public void onChanged(Inmueble inmueble) {
                if(inmueble!=null){
                    bind.llInfo.setVisibility(getView().VISIBLE);
                    bind.tvCodigo.setText("Codigo: "+inmueble.getCodigo());
                    bind.tvDescripcion.setText("Descripcion: "+inmueble.getDescripcion());
                    bind.tvCantAmbientes.setText("Cantidad de ambientes: "+inmueble.getCant_ambientes());
                    bind.tvPrecio.setText("Precio: "+inmueble.getPrecio());

                    bind.btnBorrar.setEnabled(true);

                    bind.btnBorrar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            MainActivity.inmuebles.remove(inmueble);
                        }
                    });
                    Toast.makeText(getActivity(),"Inmueble Cargado",Toast.LENGTH_SHORT).show();
                } else{
                    bind.llInfo.setVisibility(View.INVISIBLE);
                    Toast.makeText(getActivity(),"Inmueble no encontrado",Toast.LENGTH_SHORT).show();
                    bind.btnBorrar.setEnabled(false);
                }

            }
        });

    }

}