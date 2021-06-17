package com.ryanandvinicius.bomsomapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ryanandvinicius.bomsomapp.Homeprox;
import com.ryanandvinicius.bomsomapp.MeAche.MeAche;
import com.ryanandvinicius.bomsomapp.aboutus.animelist;
import com.ryanandvinicius.bomsomapp.forms.FormClientActivity;
import com.ryanandvinicius.bomsomapp.forms.FormEmployeeActivity;
import com.ryanandvinicius.bomsomapp.forms.FormProjectActivity;
import com.ryanandvinicius.bomsomapp.homepage.home;
import com.ryanandvinicius.bomsomapp.menulateral.Callback;
import com.ryanandvinicius.bomsomapp.menulateral.ItensDoMenu;
import com.ryanandvinicius.bomsomapp.menulateral.MenuEdit;
import com.ryanandvinicius.bomsomapp.menulateral.MenuNec;

import java.util.List;


public class MainActivity  extends AppCompatActivity implements Callback {
    RecyclerView VMenu;
    List<ItensDoMenu> itensMenu;
    MenuEdit mudando;
    int selectedMenuPosition = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupSideMenu();
        setHomePage();


    }

    public void startSecondActivity(View view) {

        Intent Aboutus = new Intent(this, Homeprox.class);
        startActivity(Aboutus);
        setupSideMenu();
       
    }

    public void startCadastroCliente(View view) {

        Intent CadastroCliente = new Intent(this, cadastrocliente.class);
        startActivity(CadastroCliente);
        String name = "Dragão";
        Intent nextActivity = new Intent(this, listacliente.class);
        nextActivity.putExtra("my_name", name);
        startActivity(nextActivity);

    }

    public void startCadastroFuncionario(View view) {

        Intent CadastroFuncionario = new Intent(this, cadastrofuncionario.class);
        startActivity(CadastroFuncionario);

    }

    public void startCadastroProjeto(View view) {

        Intent CadastroProjeto = new Intent(this, cadastroprojeto.class);
        startActivity(CadastroProjeto);

    }

    public void startListaClient(View view) {

        Intent ListaCliente = new Intent(this, listacliente.class);
        startActivity(ListaCliente);

    }

    public void startListaEmpregado(View view) {

        Intent ListaEmpregado = new Intent(this, listaempregado.class);
        startActivity(ListaEmpregado);
    }

    public void startListaProjeto(View view) {

        Intent ListaProjeto = new Intent(this, listaprojeto.class);
        startActivity(ListaProjeto);
    }
    public void startSobreBs(View view) {

        Intent SobreBs = new Intent(this, sobrebomsom.class);
        startActivity(SobreBs);
    }

    void setAnimeFrag() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new animelist()).commit();
    }

    void setHomePage() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new home()).commit();
    }

    void setLocFrag() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MeAche()).commit();
    }

    void setCadastroClient() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new FormClientActivity()).commit();

    }

    void setCadastroFuncionario() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new FormEmployeeActivity()).commit();

    }

    void setCadastroProject() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new FormProjectActivity()).commit();

    }

    

    public void botaoinsta(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/bomsomrv/"));
        startActivity(browserIntent);
    }

    public void botaoface(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Bom-Som-101827612092396"));
        startActivity(browserIntent);
    }

    public void botaobs(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ryanrangebarros.github.io/BomSomStudio/"));
        startActivity(browserIntent);
    }


    @Override
    public void onSideMenuItemClick(int i) {

        switch (itensMenu.get(i).getCode()) {
            case MenuNec.PROJECT:
                setCadastroProject();
                break;
            case MenuNec.FUNCIO:
                setCadastroFuncionario();
                break;
            case MenuNec.CLIENT:
                setCadastroClient();
                break;
            case MenuNec.LAPTOP:
                setAnimeFrag();
                break;
            case MenuNec.LOC:
                setLocFrag();
                break;
            case MenuNec.HOME:
                setHomePage();
            default:
                setHomePage();
        }

        itensMenu.get(selectedMenuPosition).setSelected(false);
        itensMenu.get(i).setSelected(true);
        selectedMenuPosition = i;
        mudando.notifyDataSetChanged();


    }

    private void setupSideMenu() {

        VMenu = findViewById(R.id.rv_side_menu);


        itensMenu = MenuNec.getMenuList();
        mudando = new MenuEdit(itensMenu, this);
        VMenu.setLayoutManager(new LinearLayoutManager(this));
        VMenu.setAdapter(mudando);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sobre:
                Intent i = new Intent(this,sobrebomsom.class);
                this.startActivity(i);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}



