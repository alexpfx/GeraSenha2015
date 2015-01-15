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
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.alexandrealessi.gerasenha2015.R;
import br.com.alexandrealessi.suseproject.api.Constants;
import br.com.alexandrealessi.suseproject.api.services.RandomPasswordGenerator;
import br.com.alexandrealessi.suseproject.api.services.SyllabicPasswordGenerator;

import static br.com.alexpfx.app.gerasenha2015.OverflowMenuRecyclerViewAdapter.ViewModel.createNew;
import static br.com.alexandrealessi.suseproject.api.services.SyllabicPasswordGenerator.*;


public class MainActivity extends ActionBarActivity implements OverflowMenuRecyclerViewAdapter.OnItemClick{


    private Toolbar toolbar;
    private TextView sessionTitleTextView;
    private RecyclerView overflowMenuRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private OverflowMenuRecyclerViewAdapter overflowMenuRecyclerViewAdapter;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private PasswordTypeStatus typeStatus;
    private TextView generatedPassTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTypeStatus(PasswordTypeStatus.ALEATORIAS);
        setupButtons();
        setupToolbar();
        setupRecyclerView();
        setupDrawerLayout();
    }

    private void setupButtons() {
        generatedPassTextView = (TextView) findViewById(R.id.generated_password_textview);
        ImageButton geraSenhaButton = (ImageButton) findViewById(R.id.new_pass_button);
        geraSenhaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //provisorio
                String pass = genPasswordByTypeStatus();
                generatedPassTextView.setText(pass);
            }
        });
    }

    private String genPasswordByTypeStatus() {
        if (typeStatus == null || typeStatus.equals(PasswordTypeStatus.ALEATORIAS)){
           return new RandomPasswordGenerator().createRandomPassword(10, Constants.ALPHABET);
        }else if (typeStatus.equals(PasswordTypeStatus.SILABICAS)){
            return new SyllabicPasswordGenerator().createSyllabicPassword(10, Constants.CONSONANTS, Constants.VOWELS, Constants.NUMBERS, Constants.SPECIAL_CHARS, new PatternType[]{PatternType.SYLLABLE, PatternType.NUMBER, PatternType.SPECIAL_CHAR});
        }else if (typeStatus.equals(PasswordTypeStatus.CONCATENADAS)){

        }
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
        overflowMenuRecyclerViewAdapter = new OverflowMenuRecyclerViewAdapter(getApplicationContext(), criarItemsMenuLateral(), this);
        overflowMenuRecyclerView.setAdapter(overflowMenuRecyclerViewAdapter);
    }

    private List<OverflowMenuRecyclerViewAdapter.ViewModel> criarItemsMenuLateral() {
        List<OverflowMenuRecyclerViewAdapter.ViewModel> lista = new ArrayList<OverflowMenuRecyclerViewAdapter.ViewModel>();
        ColorTriade clAleatorias = ColorTriade.create(getResources(), R.color.SenhasAleatorias_PrimaryColor, R.color.SenhasAleatorias_PrimaryColorDark, R.color.SenhasAleatorias_AccentColor);
        ColorTriade clSilabicas = ColorTriade.create(getResources(), R.color.SenhasSilabicas_PrimaryColor, R.color.SenhasSilabicas_PrimaryColorDark, R.color.SenhasSilabicas_AccentColor);
        ColorTriade clConcatenadas = ColorTriade.create(getResources(), R.color.SenhasConcatenadas_PrimaryColor, R.color.SenhasConcatenadas_PrimaryColorDark, R.color.SenhasConcatenadas_AccentColor);

        OverflowMenuRecyclerViewAdapter.ViewModel.createNew(R.drawable.ic_aleatoria, "Senhas Aleatórias", " Ex: a1&bC2*", clAleatorias).addTo(lista);
        OverflowMenuRecyclerViewAdapter.ViewModel.createNew(R.drawable.ic_silabica, "Senhas Silábicas", " Ex: Mo21Ce32&%", clSilabicas).addTo(lista);
        OverflowMenuRecyclerViewAdapter.ViewModel.createNew(R.drawable.ic_concatenada, "Senhas Concatenadas", " Ex: azul@tenis@pincel", clConcatenadas).addTo(lista);

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
    public void onItemClick(OverflowMenuRecyclerViewAdapter.ViewModel viewModel) {
        sessionTitleTextView.setText(viewModel.getItemTitle());
        drawerLayout.closeDrawer(overflowMenuRecyclerView);
    }

    public void setTypeStatus(PasswordTypeStatus typeStatus) {
        this.typeStatus = typeStatus;
    }


}
