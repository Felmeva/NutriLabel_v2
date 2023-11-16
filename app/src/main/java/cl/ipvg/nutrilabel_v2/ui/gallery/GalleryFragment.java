package cl.ipvg.nutrilabel_v2.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;

import cl.ipvg.nutrilabel_v2.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {



    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        final Button btAgregar= binding.button2;

        btAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "boton Aceptar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        return root;




    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}