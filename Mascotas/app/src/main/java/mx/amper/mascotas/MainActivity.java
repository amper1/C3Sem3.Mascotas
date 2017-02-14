package mx.amper.mascotas;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import mx.amper.mascotas.adaptador.PageAdapter;
import mx.amper.mascotas.fragment.MascotasFragment;
import mx.amper.mascotas.fragment.RecyclerviewFragment;

import static mx.amper.mascotas.R.layout.activity_main;

public class MainActivity extends AppCompatActivity  {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setupViewPager();

        ImageButton btnRanking  = (ImageButton) findViewById(R.id.ibStar);
        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clic", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Favoritos.class);
                startActivity(intent);
            }
        });

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    private ArrayList <Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerviewFragment());
        fragments.add(new MascotasFragment());
        return fragments;

    }

    private void setupViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog);
    }

}
