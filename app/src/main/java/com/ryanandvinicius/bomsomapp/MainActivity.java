package com.ryanandvinicius.bomsomapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ryanandvinicius.bomsomapp.Homeprox;
import com.ryanandvinicius.bomsomapp.MeAche.MeAche;
import com.ryanandvinicius.bomsomapp.aboutus.animelist;
import com.ryanandvinicius.bomsomapp.fakeDatabase.ClientRepo;
import com.ryanandvinicius.bomsomapp.fakeDatabase.EmployeeRepo;
import com.ryanandvinicius.bomsomapp.fakeDatabase.ProjectRepo;
import com.ryanandvinicius.bomsomapp.forms.FormClientActivity;
import com.ryanandvinicius.bomsomapp.forms.FormEmployeeActivity;
import com.ryanandvinicius.bomsomapp.forms.FormProjectActivity;
import com.ryanandvinicius.bomsomapp.homepage.home;
import com.ryanandvinicius.bomsomapp.menulateral.Callback;
import com.ryanandvinicius.bomsomapp.menulateral.ItensDoMenu;
import com.ryanandvinicius.bomsomapp.menulateral.MenuEdit;
import com.ryanandvinicius.bomsomapp.menulateral.MenuNec;
import com.ryanandvinicius.bomsomapp.model.Client;
import com.ryanandvinicius.bomsomapp.model.Employee;
import com.ryanandvinicius.bomsomapp.model.MusicStyle;
import com.ryanandvinicius.bomsomapp.model.Project;

import java.sql.Date;
import java.util.Calendar;
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
        addClient();
        Intent ListaCliente = new Intent(this, listacliente.class);
        startActivity(ListaCliente);

    }

    public void startListaEmpregado(View view) {
        addEmployee();
        Intent ListaEmpregado = new Intent(this, listaempregado.class);
        startActivity(ListaEmpregado);
    }

    public void startListaProjeto(View view) {
        addProject();
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


    private void addClient(){

        try{
            TextView clientName = (TextView) findViewById(R.id.client_name);
            TextView clientCpf = (TextView) findViewById(R.id.client_cpf);
            TextView clientPhone = (TextView) findViewById(R.id.client_phone);
            TextView clientEmail = (TextView) findViewById(R.id.client_email);
            Spinner musicStyle = (Spinner) findViewById(R.id.music_style_spinner);
            MusicStyle musicStyleEnum;

            if (musicStyle.getSelectedItem().toString().equals("Axé")){
                musicStyleEnum = MusicStyle.AXE;
            }else if (musicStyle.getSelectedItem().toString().equals("Pop")){
                musicStyleEnum = MusicStyle.POP;
            }else if (musicStyle.getSelectedItem().toString().equals("Rock")){
                musicStyleEnum = MusicStyle.ROCK;
            }else if (musicStyle.getSelectedItem().toString().equals("Funk")){
                musicStyleEnum = MusicStyle.FUNK;
            }else if (musicStyle.getSelectedItem().toString().equals("Brega")){
                musicStyleEnum = MusicStyle.BREGA;
            }else{
                musicStyleEnum = MusicStyle.OUTROS;
            }
            //-----------------------------------Address---------------------------
            TextView addressStreet = (TextView) findViewById(R.id.client_address_street);
            TextView addressNumber = (TextView) findViewById(R.id.client_address_number);
            TextView addressComplement = (TextView) findViewById(R.id.client_address_complement);
            TextView addressDistrict = (TextView) findViewById(R.id.client_address_district);

            Client client = new Client(clientCpf.getText().toString(),clientName.getText().toString(),clientEmail.getText().toString(),clientPhone.getText().toString(), musicStyleEnum,addressStreet.getText().toString(),addressDistrict.getText().toString(),Integer.parseInt(addressNumber.getText().toString()),addressComplement.getText().toString());
            ClientRepo.addClient(client);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Crash");
        }
    }


    private void addEmployee(){

        try{
            TextView employeeName = (TextView) findViewById(R.id.employee_name);
            TextView employeeCpf = (TextView) findViewById(R.id.employee_cpf);
            TextView employeeEmail = (TextView) findViewById(R.id.employee_email);

            //-----------------------------------Address---------------------------
            TextView addressStreet = (TextView) findViewById(R.id.employee_address_street);
            TextView addressNumber = (TextView) findViewById(R.id.employee_address_number);
            TextView addressComplement = (TextView) findViewById(R.id.employee_address_complement);
            TextView addressDistrict = (TextView) findViewById(R.id.employee_address_district);

            Employee employee = new Employee(employeeCpf.getText().toString(),employeeName.getText().toString(),employeeEmail.getText().toString(),"", Calendar.getInstance().getTime(),addressStreet.getText().toString(),addressDistrict.getText().toString(),Integer.parseInt(addressNumber.getText().toString()),addressComplement.getText().toString());
            EmployeeRepo.addEmployee(employee);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Crash");
        }
    }


    private void addProject(){

        try{
            TextView projectName = (TextView) findViewById(R.id.project_name);
            TextView projectDescription = (TextView) findViewById(R.id.project_description);
            TextView projectPortifolio = (TextView) findViewById(R.id.project_portifolio);
            TextView clientId = (TextView) findViewById(R.id.project_client_id);
            TextView employeeId = (TextView) findViewById(R.id.project_employee_id);

            //-----------------------------------Address---------------------------
            TextView addressStreet = (TextView) findViewById(R.id.project_address_street);
            TextView addressNumber = (TextView) findViewById(R.id.project_address_number);
            TextView addressComplement = (TextView) findViewById(R.id.project_address_complement);
            TextView addressDistrict = (TextView) findViewById(R.id.project_address_district);

            Project project = new Project("",projectName.getText().toString(),projectDescription.getText().toString(),EmployeeRepo.find(employeeId.getText().toString()), ClientRepo.find(clientId.getText().toString()),Calendar.getInstance().getTime(), addressStreet.getText().toString(),addressDistrict.getText().toString(),Integer.parseInt(addressNumber.getText().toString()),addressComplement.getText().toString());
            ProjectRepo.addProject(project);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Crash");
        }
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



