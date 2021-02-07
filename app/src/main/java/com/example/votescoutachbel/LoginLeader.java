package com.example.votescoutachbel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;

public class LoginLeader extends AppCompatActivity {
    EditText editid, namedit;
    Button btn_connecte, btndelet;
    String editTex;
    List<user> everyone;
    List<user> newList;
    DataBaseHAlper dataBaseHAlper, database2;
    String getEdit;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_leader);
        editid = findViewById(R.id.edit_id);
        btn_connecte = findViewById(R.id.btn_connecter);
        user achbel67 = new user("11111111111", "exemple1", "voteF");
        user achbel68 = new user("12222222222", "exemple2", "voteF");
        user achbel69 = new user("13333333333", "exemple3", "voteF");
        user achbel70 = new user("14444444444", "exemple4", "voteF");
        user achbel71 = new user("15555555555", "exemple5", "voteF");
        user achbel72 = new user("16666666666", "exemple6", "voteF");
        user achbel73 = new user("17777777777", "exemple7", "voteF");
        user achbel74 = new user("18888888888", "exemple8", "voteF");
        dataBaseHAlper = new DataBaseHAlper(LoginLeader.this);
        dataBaseHAlper.addOne(achbel67);
        dataBaseHAlper.addOne(achbel68);
        dataBaseHAlper.addOne(achbel69);
        dataBaseHAlper.addOne(achbel70);
        dataBaseHAlper.addOne(achbel71);
        dataBaseHAlper.addOne(achbel72);
        dataBaseHAlper.addOne(achbel73);
        dataBaseHAlper.addOne(achbel74);
        btn_connecte.setOnClickListener(v -> {

            everyone = dataBaseHAlper.getTousLaListe();
          // Toast.makeText(LoginLeader.this, ""+newList.size(), Toast.LENGTH_LONG).show();
            newList= new ArrayList<>();

            String Ch = "1";
            Ch = Ch + editid.getText().toString().trim();

            getEdit = editid.getText().toString().trim();
           boolean aux=false;
            if (getEdit.length() != 10) {
                Toast.makeText(LoginLeader.this, "الرجاء ادخال المعرف الكشفي متكون من 10 أرقام", Toast.LENGTH_SHORT).show();
            }
            if (!getEdit.isEmpty()) {
                for (user element : everyone) {
                    if (Ch.equals(element.getId_user())) {
                        Intent intent = new Intent(LoginLeader.this,LeaderAchbel.class);
                        intent.putExtra("id_leader-vote",element.getId_user());
                        startActivity(intent);


                    }


                }}});


    }
}