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

    private Button agregarBt, actuaBt, elimBt, genEtBt, descBt;
    private EditText nombre, ing1, ing2, ing3, gram1, gram2, gram3, codNum;
    private Spinner nomRec1, nomRec2;

    private View view1, view2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        agregarBt = (Button) findViewById(R.id.button3);
        actuaBt = (Button)  findViewById(R.id.button2);
        elimBt = (Button) findViewById(R.id.button4);
        genEtBt = (Button) findViewById(R.id.button);
        descBt = (Button) findViewById(R.id.button5);

        nombre = (EditText) findViewById(R.id.editTextText);
        ing1 = (EditText) findViewById(R.id.editTextText7);
        ing2 = (EditText) findViewById(R.id.editTextText8);
        ing3 = (EditText) findViewById(R.id.editTextText9);
        gram1 = (EditText) findViewById(R.id.editTextText10);
        gram2 = (EditText) findViewById(R.id.editTextText11);
        gram3 = (EditText) findViewById(R.id.editTextText12);
        codNum = (EditText) findViewById(R.id.editTextText5);

        nomRec1 = (Spinner) findViewById(R.id.spinner);
        nomRec2 = (Spinner) findViewById(R.id.spinner4);

        view1 = (View) findViewById(R.id.view);
        view2 = (View) findViewById(R.id.view2);



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