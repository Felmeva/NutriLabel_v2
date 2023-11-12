package cl.ipvg.nutrilabel_v2;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import cl.ipvg.nutrilabel_v2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    private Button crearBt, agregarBt, eliminarBt, generarBt, descBt;
    private Spinner ing1, ing2, ing3, eti1;
    private EditText editNomR, editGr1, editGr2, editGr3, editNomI, editE, editP, editGt, editHc, editS;
    private View viewEt;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        viewEt = (View) findViewById(R.id.view2);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
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
}