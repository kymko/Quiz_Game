package kg.geektech.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Locale;
import java.util.SplittableRandom;


import kg.geektech.fragments.HeaderFragment;
import kg.geektech.quizgame.R;

public class MainActivity extends AppCompatActivity {

    private TextView txtHeader;
    private Button btnAddFragments;
    private Button btnExit;
    private Switch aSwitch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadLocale();
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

        initViews();
        btnAddFragmentsClick();
        btnExitClick();
        chekSwitch();


    }

    private void chekSwitch() {
        if (loadState() == true ){
            Toast.makeText(this,"checked",Toast.LENGTH_SHORT).show();
            aSwitch.setChecked(true);

        }
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    setTheme(R.style.darkTheme);
                    saveState(true);
                    recreate();
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    saveState(false);
                    setTheme(R.style.AppTheme);
                }
            }
        });
    }

    private void saveState(boolean b) {
        SharedPreferences preferences = getSharedPreferences("Positive",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("NightMode",b);
        editor.apply();
    }

    private boolean loadState() {
        SharedPreferences preferences = getSharedPreferences("Positive",MODE_PRIVATE);
        Boolean b = preferences.getBoolean("NightMode",false);
        return b;

    }


    private void btnExitClick() {
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void btnAddFragmentsClick() {
        btnAddFragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

            }
        });
    }

    private void initViews() {
        btnAddFragments = findViewById(R.id.btn_add_fragment);
        btnExit = findViewById(R.id.btn_exit);
        txtHeader = findViewById(R.id.quiz_txt);
        aSwitch = findViewById(R.id.switch_theme);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_language,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.en:

                changeLanguages();

        }
        return true;
    }

    private void changeLanguages() {
        final String[] languages = {"English","Kyrgyz"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose language");
        builder.setSingleChoiceItems(languages, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if (i == 0){
                    setLocal("en");
                    recreate();
                }else if (i == 1){
                    setLocal("ky");
                    recreate();
                }
                dialog.dismiss();
            }
        });
        AlertDialog mDialog = builder.create();
        mDialog.show();
    }

    private void setLocal(String lang) {

        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("lang",lang);
        editor.apply();

    }
    public void loadLocale(){
        SharedPreferences preferences = getSharedPreferences("Settings",MODE_PRIVATE);
        String lang = preferences.getString("lang","");
        setLocal(lang);

    }
}