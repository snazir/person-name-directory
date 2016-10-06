package com.salmannazir.namelist.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.salmannazir.namelist.R;
import com.salmannazir.namelist.adapters.NamesListAdapter;
import com.salmannazir.namelist.fragments.PersonNameFragmentDialog;
import com.salmannazir.namelist.interfaces.OnPersonAddDialogResult;
import com.salmannazir.namelist.models.Person;
import org.json.JSONObject;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    RecyclerView mListView;
    NamesListAdapter mPersonAdapter;
    ArrayList<Person> mPersonList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.floating_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                PersonNameFragmentDialog mDialog = new PersonNameFragmentDialog();
                mDialog.setDialogResultListener(mDialogResultListener);
                mDialog.show(getFragmentManager(),"Add Person");

            }
        });



        mListView = (RecyclerView)findViewById(R.id.person_list_view);
        mPersonList = prepareDummyPersonNamesList();
        mPersonAdapter= new NamesListAdapter(this, mPersonList);
        mListView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mListView.setLayoutManager(mLayoutManager);
        mListView.setAdapter( mPersonAdapter);

    }

    OnPersonAddDialogResult mDialogResultListener = new OnPersonAddDialogResult() {
        @Override
        public void finish(Person person) {
            mPersonAdapter.addItem(person);

        }
    };

    private ArrayList<Person> prepareDummyPersonNamesList() {
        ArrayList<Person> mPersonList = new ArrayList<>();

        try {

            JSONObject jsonPerson1 = new JSONObject();
            JSONObject jsonPerson2 = new JSONObject();
            JSONObject jsonPerson3 = new JSONObject();
            JSONObject jsonPerson4 = new JSONObject();
            JSONObject jsonPerson5 = new JSONObject();

            jsonPerson1.put("first_name", "Salman");
            jsonPerson1.put("last_name", "Nazir");

            jsonPerson2.put("first_name", "Umer");
            jsonPerson2.put("last_name", "Ali");

            jsonPerson3.put("first_name", "Usman");
            jsonPerson3.put("last_name", "Ahmed");

            jsonPerson4.put("first_name", "Hassan");
            jsonPerson4.put("last_name", "Nazir");

            jsonPerson5.put("first_name", "Shumail");
            jsonPerson5.put("last_name", "Muhammad");

            Person personObject1= new Person(jsonPerson1);
            Person personObject2= new Person(jsonPerson2);
            Person personObject3= new Person(jsonPerson3);
            Person personObject4= new Person(jsonPerson4);
            Person personObject5= new Person(jsonPerson5);

            mPersonList.add(personObject1);
            mPersonList.add(personObject2);
            mPersonList.add(personObject3);
            mPersonList.add(personObject4);
            mPersonList.add(personObject5);

        }catch (Exception e){

            e.printStackTrace();
        }

        return mPersonList;

    }

}
