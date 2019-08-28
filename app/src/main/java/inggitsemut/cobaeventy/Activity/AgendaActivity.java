package inggitsemut.cobaeventy.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import inggitsemut.cobaeventy.Adapter.RecyclerViewBannerAdapter;
import inggitsemut.cobaeventy.Adapter.RecyclerViewDateAgendaAdapter;
import inggitsemut.cobaeventy.Model.Agenda;
import inggitsemut.cobaeventy.R;

public class AgendaActivity extends AppCompatActivity {

    private ArrayList<Agenda> listDate = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewDate = findViewById(R.id.rv_date);
        recyclerViewDate.setLayoutManager(layoutManager);
        RecyclerViewDateAgendaAdapter adapter = new RecyclerViewDateAgendaAdapter(getApplicationContext(), listDate);
        recyclerViewDate.setAdapter(adapter);

        listDate.add(new Agenda("14","WED"));
        listDate.add(new Agenda("15","THU"));
        listDate.add(new Agenda("16","FRI"));
        listDate.add(new Agenda("17","SAT"));

    }
}
