package cl.ipvg.nutrilabel_v2;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cl.ipvg.nutrilabel_v2.clases.etiqueta;
import cl.ipvg.nutrilabel_v2.clases.ingrediente;
import cl.ipvg.nutrilabel_v2.clases.receta;
import cl.ipvg.nutrilabel_v2.databinding.ActivityMainBinding;
import cl.ipvg.nutrilabel_v2.databinding.FragmentGalleryBinding;
import cl.ipvg.nutrilabel_v2.databinding.FragmentHomeBinding;
import cl.ipvg.nutrilabel_v2.databinding.FragmentSlideshowBinding;
import cl.ipvg.nutrilabel_v2.ui.gallery.GalleryFragment;

public class MainActivity extends AppCompatActivity {
    private double energiaI, proteinasI, grasasI, HdcI, sodioI;
    private double etGr1;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private FragmentGalleryBinding galleryBinding;
    private FragmentHomeBinding homeBinding;
    private FragmentSlideshowBinding slideshowBinding;

    private Layout layoutG, layoutH, layoutS;

    private Button crearBt, agregarBt, eliminarBt, generarBt, descBt;
    private Spinner ing1, ing2, ing3, eti1;
    private EditText editNomR, editGr1, editGr2, editGr3, editNomI, editE, editP, editGt, editHc, editS;
    private ListView listviewEt;

    private List<ingrediente> ListIng = new ArrayList<ingrediente>();

    private List<String> ListI = new ArrayList<String>();

    private List<receta> ListRec = new ArrayList<receta>();

    private List<String> ListR = new ArrayList<>();

    private List<etiqueta> ListEti = new ArrayList<etiqueta>();

    private List<String> ListE = new ArrayList<>();

    ArrayAdapter<ingrediente> arrayAdapterIngrediente;

    ArrayAdapter<receta> arrayAdapterReceta;

    ArrayAdapter<etiqueta> arrayAdapterEtiqueta;
    ArrayAdapter<String> arrayAdapterString;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ingrediente ing = new ingrediente();

        crearBt = findViewById(R.id.button3);
        agregarBt = findViewById(R.id.button2);
        generarBt = findViewById(R.id.button);
        descBt = findViewById(R.id.button5);

        ing1 = findViewById(R.id.spinner2);
        ing2 = findViewById(R.id.spinner3);
        ing3 = findViewById(R.id.spinner5);
        eti1 = findViewById(R.id.spinner);

        editNomR = findViewById(R.id.editTextText);
        editGr1 = findViewById(R.id.editTextText10);
        editGr2 = findViewById(R.id.editTextText11);
        editGr3 = findViewById(R.id.editTextText12);
        editNomI = findViewById(R.id.editTextText2);
        editE = findViewById(R.id.editTextText3);
        editP = findViewById(R.id.editTextText4);
        editGt = findViewById(R.id.editTextText5);
        editHc = findViewById(R.id.editTextText6);
        editS = findViewById(R.id.editTextText7);

        listviewEt = findViewById(R.id.ListviewEt);

        inicializarFireBase();

        listarDatosI();
        listarDatosR();
        listarDatosE();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "En preparación", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });










        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void listarDatosI() {
        databaseReference.child("ingrediente").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ListIng.clear();
                for (DataSnapshot objs : snapshot.getChildren()){
                    ingrediente ing = objs.getValue(ingrediente.class);
                    ListIng.add(ing);
                    ListI.add("" + ing.getNombre() + "" + ing.getEnergia() + "" + ing.getProteinas() + "" + ing.getGrasasT() + "" + ing.getHdC() + "" + ing.getSodio());
                    arrayAdapterString = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1,ListI);
                    ing1.setAdapter(arrayAdapterString);
                    ing2.setAdapter(arrayAdapterString);
                    ing3.setAdapter(arrayAdapterString);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void listarDatosR(){
        databaseReference.child("receta").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ListRec.clear();
                for (DataSnapshot objs : snapshot.getChildren()){
                    receta rec = objs.getValue(receta.class);
                    ListRec.add(rec);
                    ListR.add(""+ rec.getNombreR() + "" + rec.getEneR() + "" + rec.getProR() + "" + rec.getGraR() + "" + rec.getHdcR() + "" + rec.getSodR());
                    arrayAdapterString = new ArrayAdapter<String>( MainActivity.this , android.R.layout.simple_expandable_list_item_1,ListE);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void listarDatosE(){
        databaseReference.child("etiqueta").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ListEti.clear();
                for (DataSnapshot objs : snapshot.getChildren()){
                    etiqueta et = objs.getValue(etiqueta.class);
                    ListEti.add(et);
                    ListE.add("Etiqueta nutricional" + "" + et.getEnergiaEt() + et.getProtEt() + "" + et.getGrasEt() + "" + et.getHdcEt() + "" + et.getSodEt());
                    arrayAdapterString = new ArrayAdapter<String>( MainActivity.this , android.R.layout.simple_expandable_list_item_1, ListE);
                    listviewEt.setAdapter(arrayAdapterString);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void inicializarFireBase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase =FirebaseDatabase.getInstance();
        databaseReference =firebaseDatabase.getReference();
    }
}