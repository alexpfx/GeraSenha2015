package br.com.alexpfx.app.gerasenha2015;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import br.com.alexandrealessi.gerasenha2015.R;
import br.com.alexpfx.app.gerasenha2015.fragments.CurrentPasswordFragment;
import br.com.alexpfx.app.gerasenha2015.managers.ConcatenatedPasswordManager;
import br.com.alexpfx.app.gerasenha2015.managers.PasswordGeneratorManager;
import br.com.alexpfx.app.gerasenha2015.managers.SimplyPasswordGeneratorManager;
import br.com.alexpfx.app.gerasenha2015.managers.SyllabicPasswordGeneratorManager;
import br.com.alexpfx.supersenha.lib.ConcatenatedPasswordGenerator;
import br.com.alexpfx.supersenha.lib.PasswordGenerator;
import br.com.alexpfx.supersenha.lib.SimplyPasswordGenerator;
import br.com.alexpfx.supersenha.lib.SyllabicPasswordGenerator;

import static br.com.alexpfx.app.gerasenha2015.OverflowMenuRecyclerViewAdapter.OnItemClick;
import static br.com.alexpfx.app.gerasenha2015.OverflowMenuRecyclerViewAdapter.ViewModel;


public class MainActivity extends ActionBarActivity implements OnItemClick{

    public static final String TAG = MainActivity.class.getName();

    private Toolbar toolbar;
    private TextView sessionTitleTextView;
    private RecyclerView overflowMenuRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private OverflowMenuRecyclerViewAdapter overflowMenuRecyclerViewAdapter;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private TextView generatedPassTextView;
    private SenhaMenuItem activeMenuItem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generatedPassTextView = (TextView) findViewById(R.id.generated_password_textview);
        setupToolbar();
        setupRecyclerView();
        setupDrawerLayout();
    }

    private void setupButtons() {

    }

    private String genPasswordByTypeStatus() {
        return "";
    }

    private void setupDrawerLayout() {
        drawerLayout = (DrawerLayout) findViewById(R.id.overflow_menu_drawerlayout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.abrir, R.string.fechar);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(drawerToggle);
    }

    private void setupRecyclerView() {
        overflowMenuRecyclerView = (RecyclerView) findViewById(R.id.overflow_menu_recyclerview);
        overflowMenuRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        overflowMenuRecyclerView.setLayoutManager(layoutManager);
        overflowMenuRecyclerViewAdapter = new OverflowMenuRecyclerViewAdapter(getApplicationContext(), setupMenuItems(), this);
        overflowMenuRecyclerView.setAdapter(overflowMenuRecyclerViewAdapter);
    }

    private List<OverflowMenuRecyclerViewAdapter.ViewModel> setupMenuItems() {
        List<OverflowMenuRecyclerViewAdapter.ViewModel> lista = new ArrayList<OverflowMenuRecyclerViewAdapter.ViewModel>();
        //TODO externalizar strings
        CommonPasswordOptionsDialogFragment dialogFragment = new CommonPasswordOptionsDialogFragment();

        SenhaMenuItem simplyPasswordMenuItem = new SenhaMenuItem.Builder()
                .title("Senhas Aleatorias")
                .subTitle(" Ex: a1&bC2*")
                .itemIconImgSrc(R.drawable.ic_aleatoria)
                .passwordGeneratorManager(new SimplyPasswordGeneratorManager())
                .build();

        SenhaMenuItem syllabicPasswordMenuItem = new SenhaMenuItem.Builder()
                .title("Senhas Silábicas").subTitle(" Ex: Mo21Ce32&%")
                .itemIconImgSrc(R.drawable.ic_silabica)
                .passwordGeneratorManager(new SyllabicPasswordGeneratorManager())
                .build();

        InputStream is = getResources().openRawResource(R.raw.ptbr);
        SenhaMenuItem concatenatedPasswordMenuItem = new SenhaMenuItem.Builder()
                .title("Senhas Concatenadas")
                .subTitle(" Ex: casa@tapete@ferro")
                .itemIconImgSrc(R.drawable.ic_concatenada)
                .passwordGeneratorManager(new ConcatenatedPasswordManager(new BufferedReader(new InputStreamReader(is))))
                .build();

        ViewModel.createNew(simplyPasswordMenuItem).addTo(lista);
        ViewModel.createNew(syllabicPasswordMenuItem).addTo(lista);
        ViewModel.createNew(concatenatedPasswordMenuItem).addTo(lista);
        return lista;
    }

    private void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sessionTitleTextView = (TextView) toolbar.findViewById(R.id.session_title_textview);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onItemClick(ViewModel viewModel) {
        sessionTitleTextView.setText(viewModel.getSenhaMenuItem().getTitle());
        drawerLayout.closeDrawer(overflowMenuRecyclerView);
        PasswordGeneratorManager passwordGeneratorManager = viewModel.getSenhaMenuItem().getPasswordGeneratorManager();
        CurrentPasswordFragment f = (CurrentPasswordFragment) getSupportFragmentManager().findFragmentById(R.id.current_password_fragment);
        if (f != null){
            f.setPasswordGeneratorManager(passwordGeneratorManager);

        }

    }

    private void setActiveMenuItem(SenhaMenuItem senhaMenuItem) {
        this.activeMenuItem = senhaMenuItem;
    }



}
