package com.example.votescoutachbel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class LeaderAchbel extends AppCompatActivity {
    int aux = 0;
    CheckBox Achbel1,Achbel2,Achbel3,Achbel4,Achbel5,Achbel6;
    int vote_p1 , vote_p2, vote_p3, vote_p4, vote_p5, vote_p6;
    ArrayList<Integer> listedesvote = new ArrayList<>();
    List<voter> candidatlist;
    FirebaseDatabase databaseAchbel;
    DatabaseReference myReference;
    String name1, name2, name3, name4, name5, name6;
    Intent intent;
    String id_user_vote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_achbel);
        Achbel1 = findViewById(R.id.checkAchbel);
        Achbel2 = findViewById(R.id.checkAchbel2);
        Achbel3 = findViewById(R.id.checkAchbel3);
        Achbel4 = findViewById(R.id.checkAchebel4);
        Achbel5= findViewById(R.id.checkAchbel5);
        Achbel6 = findViewById(R.id.checkAchbel6);


        candidatlist= new ArrayList<>();
        databaseAchbel = FirebaseDatabase.getInstance();
        myReference = databaseAchbel.getReference().child("achbel");
        intent = getIntent();
        id_user_vote = intent.getStringExtra("id_leader-vote");
    }



    private void NotSelectedAchbel()
    {
        if (Achbel1.isChecked()) {
            Achbel1.setChecked(false);
        }
        if (Achbel2.isChecked()){
            Achbel2.setChecked(false);

        }
        if (Achbel3.isChecked()){
            Achbel3.setChecked(false);

        }
        if (Achbel4.isChecked()){
            Achbel4.setChecked(false);

        }
        if (Achbel5.isChecked()){
            Achbel5.setChecked(false);

        }
        if (Achbel6.isChecked()){
            Achbel6.setChecked(false);

        }

    }
    private ArrayList<Integer> nbr_vote()
    {

        if (Achbel1.isChecked()) {
            name1 = Achbel1.getText().toString();
            vote_p1 =1;
            voter cond = new voter(1, name1, vote_p1,id_user_vote);
            myReference.push().setValue(cond);

        }
        if (Achbel2.isChecked()) {
            name2 = Achbel2.getText().toString();
            vote_p2 = 1;
            voter cond = new voter(2, name2, vote_p2,id_user_vote);
            myReference.push().setValue(cond);
        }
        if (Achbel3.isChecked()) {
            name3 = Achbel3.getText().toString();
            vote_p3 = 1;
            voter cond = new voter(3, name3, vote_p3,id_user_vote);
            myReference.push().setValue(cond);
        }
        if (Achbel4.isChecked()) {
            name4 = Achbel4.getText().toString();
            vote_p4 = 1;
            voter cond = new voter(4, name4, vote_p4,id_user_vote);
            myReference.push().setValue(cond);
        }
        if (Achbel5.isChecked()) {
            name5 = Achbel5.getText().toString();
            vote_p5 = 1  ;
            voter cond = new voter(5, name5, vote_p5,id_user_vote);
            myReference.push().setValue(cond);
        }
        if (Achbel6.isChecked()) {
            name6 = Achbel6.getText().toString();
            vote_p6 = 1;
            voter cond = new voter(6, name6, vote_p6,id_user_vote);
            myReference.push().setValue(cond);
        }

        return listedesvote;

    }

    public void onCheckboxSelectedAchbel(View view){

        if (Achbel1.isChecked()) {
            aux = aux + 1;
        }
        if (Achbel2.isChecked()) {
            aux = aux + 1;

        }
        if (Achbel3.isChecked()) {
            aux = aux + 1;

        }
        if (Achbel4.isChecked()) {
            aux = aux + 1;

        }
        if (Achbel5.isChecked()) {
            aux = aux + 1;

        }
        if (Achbel6.isChecked()) {
            aux = aux + 1;
        }


        if (aux != 5)
        {
            Toast.makeText(LeaderAchbel.this,"الرجاء اختيار 5 مترشحين فقط", Toast.LENGTH_LONG).show();
            NotSelectedAchbel();
            aux= 0;}
        else
        {
            nbr_vote();
            Toast.makeText(LeaderAchbel.this,"شكرا لكم، لقد قمتم بعملية الانتخاب ", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(LeaderAchbel.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }




}