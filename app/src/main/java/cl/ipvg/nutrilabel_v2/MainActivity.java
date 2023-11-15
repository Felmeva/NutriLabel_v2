package cl.ipvg.nutrilabel_v2;

import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {
    private double energiaI, proteinasI, grasasI, HdcI, sodioI;

    private double etGr1;

    private String etTex1;

    private String text1, text2, text3, text4, text5;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

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
        text1 = editE.getText().toString();
        energiaI = Double.parseDouble(text1);
        text2 = editP.getText().toString();
        proteinasI = Double.parseDouble(text2);
        text3 = editGt.getText().toString();
        grasasI = Double.parseDouble(text3);
        text4 = editHc.getText().toString();
        HdcI = Double.parseDouble(text4);
        text5 = editS.getText().toString();
        sodioI = Double.parseDouble(text5);

        etTex1 = editGr1.getText().toString();
        etGr1 = Double.parseDouble(etTex1);


        ingrediente ing = new ingrediente();




        crearBt = (Button) findViewById(R.id.button3);
        agregarBt = (Button) findViewById(R.id.button2);
        eliminarBt = (Button) findViewById(R.id.button4);
        generarBt = (Button) findViewById(R.id.button);
        descBt = (Button) findViewById(R.id.button5);

        ing1 = (Spinner) findViewById(R.id.spinner2);
        ing2 = (Spinner) findViewById(R.id.spinner3);
        ing3 = (Spinner) findViewById(R.id.spinner5);
        eti1 = (Spinner) findViewById(R.id.spinner);

        editNomR = (EditText) findViewById(R.id.editTextText);
        editGr1 = (EditText) findViewById(R.id.editTextText10);
        editGr2 = (EditText) findViewById(R.id.editTextText11);
        editGr3 = (EditText) findViewById(R.id.editTextText11);
        editNomI = (EditText) findViewById(R.id.editTextText2);
        editE = (EditText) findViewById(R.id.editTextText3);
        editP = (EditText) findViewById(R.id.editTextText4);
        editGt = (EditText) findViewById(R.id.editTextText5);
        editHc = (EditText) findViewById(R.id.editTextText6);
        editS = (EditText) findViewById(R.id.editTextText7);

        listviewEt = (ListView) findViewById(R.id.ListviewEt);





        ;


        inicializarFireBase();
        listarDatosI();
        listarDatosR();
        listarDatosR();





        agregarBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ingrediente ing1 = new ingrediente();
                ing1.setIdIng(UUID.randomUUID().toString());
                ing1.setNombre(editNomI.getText().toString());
                ing1.setEnergia(energiaI);
                ing1.setProteinas(proteinasI);
                ing1.setGrasasT(grasasI);
                ing1.setHdC(HdcI);
                ing1.setSodio(sodioI);
                databaseReference.child("ingrediente").child(ing1.getIdIng()).setValue(ing1);

            }
        });

        crearBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                receta recet1 = new receta();
                recet1.setIdReceta(UUID.randomUUID().toString());
                recet1.setNombreR(editNomR.getText().toString());
                recet1.setEneR(ing.calcularEner(energiaI,etGr1));
                recet1.setProR(ing.calcularProte(proteinasI, etGr1));
                recet1.setGraR(ing.calcularGrasas(grasasI, etGr1));
                recet1.setHdcR(ing.calcularHdC(HdcI, etGr1));
                recet1.setSodR(ing.calcularSodio(sodioI, etGr1));


                databaseReference.child("receta").child(recet1.getIdReceta()).setValue(recet1);
            }
        });


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
                    ListI.add("" + ing.getNombre());
                    arrayAdapterString = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1,ListR);
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
                    ListE.add("" + et.getNombreEt()+ "" + et.getEnergiaEt() + et.getProtEt() + "" + et.getGrasEt() + "" + et.getHdcEt() + "" + et.getSodEt());
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