package antonio.ejemplos.listviewcosasquehacer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import  android.R.*;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    private ListView lista;
    private ArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        usarToolbar();

        //String[]origendeDatos={"LEVANTARSE","DESAYUNAR","DUCHARME","COMER","ESTUDIAR","CENAR","VER LA TELE","ACOSTARSE","ESCUCHAR LA RADIO","DORMIR"};

        //Cambiamos el origen de datos por un ArrayList que utiliza como modelo la clase Tarea

        ArrayList<Tarea> Tareas=new ArrayList<>();

        Tareas.add(new Tarea("LEVANTARSE","07:00"));
        Tareas.add(new Tarea("DESAYUNAR","08:00"));
        Tareas.add(new Tarea("DUCHARSE","09:00"));
        Tareas.add(new Tarea("COMER","10:00"));
        Tareas.add(new Tarea("ESTUDIAR","11:00"));
        Tareas.add(new Tarea("CENAR","12:30"));
        Tareas.add(new Tarea("VER LA TELE","13:45"));
        Tareas.add(new Tarea("ACOSTARSE","03:00"));
        Tareas.add(new Tarea("ESCUCHAR LA RADIO","04:00"));
        Tareas.add(new Tarea("DORMIR","05:00"));
        Tareas.add(new Tarea("LEVANTARSE","07:00"));
        Tareas.add(new Tarea("LEVANTARSE","07:00"));
        Tareas.add(new Tarea("LEVANTARSE","07:00"));
        Tareas.add(new Tarea("LEVANTARSE","07:00"));
        Tareas.add(new Tarea("LEVANTARSE","07:00"));






        lista=(ListView)findViewById(R.id.lista);
        //adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_2,origendeDatos);

        //Ahora traemos el adaptador personalizado con su propio tipo de layout por lo qu solo pasamos contexto y origen de datos...
        adaptador=new TareaArrayAdapter<Tarea>(this,Tareas);

        lista.setAdapter(adaptador);

    }

    private void usarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
}
