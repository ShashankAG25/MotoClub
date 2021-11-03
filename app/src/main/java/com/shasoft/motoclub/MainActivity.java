package com.shasoft.motoclub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Firebase objects
    DatabaseReference dbref;
    DatabaseReference reference;
    DataBaseMain dbmain;
    //vibrator init
    private Vibrator my_vibrator;
    RecyclerView recyclerView;
    //recyclerAdapter reAdapter;
    //List<String> childs;

    String search_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        /*
        childs = new ArrayList<>();
        reAdapter =new recyclerAdapter(childs);


        recyclerView.setAdapter(reAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration) ;

        childs.add("KA47J8845");
        childs.add("asgkahf");
        childs.add("asfjkhas1");
        childs.add("asfjkhas3");
        childs.add("asfjkhas4");
        childs.add("asfjkhas5");*/
        //init all the fields
        final EditText bill_number = (EditText) findViewById(R.id.billnumID);
        final EditText date_in = (EditText) findViewById(R.id.dateinID);
        final EditText person_name = (EditText) findViewById(R.id.personnameID);
        final EditText phone_number = (EditText) findViewById(R.id.phonenumID);
        final EditText  register_number= (EditText) findViewById(R.id.regnumID);
        final EditText model = (EditText) findViewById(R.id.modelID);
        final EditText odometer_Running = (EditText) findViewById(R.id.odorunID);
        final EditText  r1_c1= (EditText) findViewById(R.id.row1col1);
        final EditText  r1_c2= (EditText) findViewById(R.id.row1col2);
        final EditText  r1_c3= (EditText) findViewById(R.id.row1col3);
        final EditText  r2_c1= (EditText) findViewById(R.id.row2col1);
        final EditText  r2_c2= (EditText) findViewById(R.id.row2col2);
        final EditText  r2_c3= (EditText) findViewById(R.id.row2col3);
        final EditText  r3_c1= (EditText) findViewById(R.id.row3col1);
        final EditText  r3_c2= (EditText) findViewById(R.id.row3col2);
        final EditText  r3_c3= (EditText) findViewById(R.id.row3col3);
        final EditText  r4_c1= (EditText) findViewById(R.id.row4col1);
        final EditText  r4_c2= (EditText) findViewById(R.id.row4col2);
        final EditText  r4_c3= (EditText) findViewById(R.id.row4col3);
        final EditText  r5_c1= (EditText) findViewById(R.id.row5col1);
        final EditText  r5_c2= (EditText) findViewById(R.id.row5col2);
        final EditText  r5_c3= (EditText) findViewById(R.id.row5col3);
        final EditText  r6_c1= (EditText) findViewById(R.id.row6col1);
        final EditText  r6_c2= (EditText) findViewById(R.id.row6col2);
        final EditText  r6_c3= (EditText) findViewById(R.id.row6col3);
        final EditText  r7_c1= (EditText) findViewById(R.id.row7col1);
        final EditText  r7_c2= (EditText) findViewById(R.id.row7col2);
        final EditText  r7_c3= (EditText) findViewById(R.id.row7col3);
        final EditText  r8_c1= (EditText) findViewById(R.id.row8col1);
        final EditText  r8_c2= (EditText) findViewById(R.id.row8col2);
        final EditText  r8_c3= (EditText) findViewById(R.id.row8col3);
        final EditText  r9_c1= (EditText) findViewById(R.id.row9col1);
        final EditText  r9_c2= (EditText) findViewById(R.id.row9col2);
        final EditText  r9_c3= (EditText) findViewById(R.id.row9col3);
        final EditText  r10_c1= (EditText) findViewById(R.id.row10col1);
        final EditText  r10_c2= (EditText) findViewById(R.id.row10col2);
        final EditText  r10_c3= (EditText) findViewById(R.id.row10col3);
        final EditText  r11_c1= (EditText) findViewById(R.id.row11col1);
        final EditText  r11_c2= (EditText) findViewById(R.id.row11col2);
        final EditText  r11_c3= (EditText) findViewById(R.id.row11col3);
        final EditText  r12_c1= (EditText) findViewById(R.id.row12col1);
        final EditText  r12_c2= (EditText) findViewById(R.id.row12col2);
        final EditText  r12_c3= (EditText) findViewById(R.id.row12col3);
        final EditText  r13_c1= (EditText) findViewById(R.id.row13col1);
        final EditText  r13_c2= (EditText) findViewById(R.id.row13col2);
        final EditText  r13_c3= (EditText) findViewById(R.id.row13col3);
        final EditText  r14_c1= (EditText) findViewById(R.id.row14col1);
        final EditText  r14_c2= (EditText) findViewById(R.id.row14col2);
        final EditText  r14_c3= (EditText) findViewById(R.id.row14col3);
        final EditText  r15_c1= (EditText) findViewById(R.id.row15col1);
        final EditText  r15_c2= (EditText) findViewById(R.id.row15col2);
        final EditText  r15_c3= (EditText) findViewById(R.id.row15col3);
        final EditText others = (EditText) findViewById(R.id.otherdetails);

        final  Button clear_button = (Button) findViewById(R.id.clearbtn);
        final Button save_button = (Button) findViewById(R.id.savebtn);
        final Button remove =(Button) findViewById(R.id.removedatabtn);
        final TextView total_amount = (TextView)  findViewById(R.id.Totalamount);

        my_vibrator = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        dbmain = new DataBaseMain();
        dbref = FirebaseDatabase.getInstance().getReference().child("TestDB");

        //Hide the clearButton at starting
        clear_button.setEnabled(false);
        clear_button.setVisibility(View.GONE);

        //Hide remove button at the Starting
        remove.setEnabled(false);
        remove.setVisibility(View.GONE);

        //Hide Save button on starting
        save_button.setEnabled(false);
        save_button.setVisibility(View.GONE);


        //Clear button action
        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clearMethod();
                Toast.makeText(MainActivity.this,"Cleared !!",Toast.LENGTH_SHORT).show();

                //Disable and hide Clear button After clearing
                clear_button.setEnabled(false);
                clear_button.setVisibility(View.GONE);

            }
        });


        //Calculating the total amount as entered
        TextWatcher auto_sum = new TextWatcher() {
            int sum_amount=0;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    int val1, val2, val3, val4, val5, val6, val7, val8, val9, val10, val11, val12, val13, val14, val15;
                    if (r1_c3.getText().toString().equals("")) val1 = 0;
                    else val1 = Integer.parseInt(r1_c3.getText().toString());
                    if (r2_c3.getText().toString().equals("")) val2 = 0;
                    else val2= Integer.parseInt(r2_c3.getText().toString());
                    if (r3_c3.getText().toString().equals("")) val3 = 0;
                    else val3 = Integer.parseInt(r3_c3.getText().toString());
                    if (r4_c3.getText().toString().equals("")) val4 = 0;
                    else val4 = Integer.parseInt(r4_c3.getText().toString());
                    if (r5_c3.getText().toString().equals("")) val5 = 0;
                    else val5 = Integer.parseInt(r5_c3.getText().toString());
                    if (r6_c3.getText().toString().equals("")) val6 = 0;
                    else val6 = Integer.parseInt(r6_c3.getText().toString());
                    if (r7_c3.getText().toString().equals("")) val7 = 0;
                    else val7 = Integer.parseInt(r7_c3.getText().toString());
                    if (r8_c3.getText().toString().equals("")) val8 = 0;
                    else val8 = Integer.parseInt(r8_c3.getText().toString());
                    if (r9_c3.getText().toString().equals("")) val9 = 0;
                    else val9 = Integer.parseInt(r9_c3.getText().toString());
                    if (r10_c3.getText().toString().equals("")) val10 = 0;
                    else val10 = Integer.parseInt(r10_c3.getText().toString());
                    if (r11_c3.getText().toString().equals("")) val11 = 0;
                    else val11 = Integer.parseInt(r11_c3.getText().toString());
                    if (r12_c3.getText().toString().equals("")) val12 = 0;
                    else val12 = Integer.parseInt(r12_c3.getText().toString());
                    if (r13_c3.getText().toString().equals("")) val13 = 0;
                    else val13 = Integer.parseInt(r13_c3.getText().toString());
                    if (r14_c3.getText().toString().equals("")) val14 = 0;
                    else val14 = Integer.parseInt(r14_c3.getText().toString());
                    if (r15_c3.getText().toString().equals("")) val15 = 0;
                    else val15 = Integer.parseInt(r15_c3.getText().toString());
                    sum_amount = val1 + val2 + val3 + val4 + val5 + val6 + val7 + val8 + val9 + val10 + val11 + val12 + val13 + val14 + val15;
                    total_amount.setText(String.valueOf(sum_amount));
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        };

        r1_c3.addTextChangedListener(auto_sum);
        r2_c3.addTextChangedListener(auto_sum);
        r3_c3.addTextChangedListener(auto_sum);
        r4_c3.addTextChangedListener(auto_sum);
        r5_c3.addTextChangedListener(auto_sum);
        r6_c3.addTextChangedListener(auto_sum);
        r7_c3.addTextChangedListener(auto_sum);
        r8_c3.addTextChangedListener(auto_sum);
        r9_c3.addTextChangedListener(auto_sum);
        r10_c3.addTextChangedListener(auto_sum);
        r11_c3.addTextChangedListener(auto_sum);
        r12_c3.addTextChangedListener(auto_sum);
        r13_c3.addTextChangedListener(auto_sum);
        r14_c3.addTextChangedListener(auto_sum);
        r15_c3.addTextChangedListener(auto_sum);

        //text watcher to enable clear button on typing bill number
        TextWatcher enable_clear = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                clear_button.setEnabled(true);
                clear_button.setVisibility(View.VISIBLE);
                save_button.setEnabled(true);
                save_button.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        bill_number.addTextChangedListener(enable_clear);


        //Save button action
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int phnolen = phone_number.getText().length();
                if(bill_number.getText().toString().isEmpty()){
                   AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Cannot be Empty ! ");
                    alert.setMessage("Please enter the Bill Number .");
                    alert.setPositiveButton("OK", null);
                    alert.show();
                    my_vibrator.vibrate(50);
                    bill_number.setError("Enter Bill Number "); }
               else if (person_name.getText().toString().isEmpty()){
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Cannot be Empty ! ");
                    alert.setMessage("Please enter Owner Name .");
                    alert.setPositiveButton("OK", null);
                    alert.show();
                    my_vibrator.vibrate(50);
                   person_name.setError("Enter name ");}
               else if (phone_number.getText().toString().isEmpty()){
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Cannot be Empty ! ");
                    alert.setMessage("Please enter the Phone Number .");
                    alert.setPositiveButton("OK", null);
                    alert.show();
                    my_vibrator.vibrate(50);
                   phone_number.setError("Enter Phone number"); }
               else  if (phnolen != 10 ){
                    Toast.makeText(MainActivity.this,"Invalid Phone number",Toast.LENGTH_SHORT).show();

                }
               else if (register_number.getText().toString().isEmpty()){
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Cannot be Empty ! ");
                    alert.setMessage("Please enter the Register Number .");
                    alert.setPositiveButton("OK", null);
                    alert.show();
                    my_vibrator.vibrate(50);
                   register_number.setError("Enter car number "); }
                else {
                    int bill_number_temp = Integer.parseInt(bill_number.getText().toString().trim());
                    dbmain.setBill_number(bill_number_temp);
                    if (!date_in.getText().toString().isEmpty()) {
                        dbmain.setDate_in(date_in.getText().toString().trim());
                    }
                    dbmain.setPerson_name(person_name.getText().toString().trim());
                    Long phone_number_temp = Long.parseLong(phone_number.getText().toString().trim());
                    dbmain.setPhone_number(phone_number_temp);
                    dbmain.setRegister_number(register_number.getText().toString().trim());
                    if (!model.getText().toString().isEmpty()) {
                        dbmain.setModel(model.getText().toString().trim());
                    }
                    if (!odometer_Running.getText().toString().isEmpty()) {
                        Long Odometer_running_temp = Long.parseLong(odometer_Running.getText().toString().trim());
                        dbmain.setOdometer_running(Odometer_running_temp);
                    }

                    if (!r1_c1.getText().toString().isEmpty()) {
                        dbmain.setR1_c1(r1_c1.getText().toString().trim());
                    }
                    if (!r1_c2.getText().toString().isEmpty()) {
                        int r1_c2_temp = Integer.parseInt(r1_c2.getText().toString().trim());
                        dbmain.setR1_c2(r1_c2_temp);
                    }
                    if (!r1_c3.getText().toString().isEmpty()) {
                        int r1_c3_temp = Integer.parseInt(r1_c3.getText().toString().trim());
                        dbmain.setR1_c3(r1_c3_temp);
                    }
                    if (!r2_c1.getText().toString().isEmpty()) {
                        dbmain.setR2_c1(r2_c1.getText().toString().trim());
                    }
                    if (!r2_c2.getText().toString().isEmpty()) {
                        int r2_c2_temp = Integer.parseInt(r2_c2.getText().toString().trim());
                        dbmain.setR2_c2(r2_c2_temp);
                    }
                    if (!r2_c3.getText().toString().isEmpty()) {
                        int r2_c3_temp = Integer.parseInt(r2_c3.getText().toString().trim());
                        dbmain.setR2_c3(r2_c3_temp);
                    }
                    if (!r3_c2.getText().toString().isEmpty()) {
                        dbmain.setR3_c1(r3_c1.getText().toString().trim());
                    }
                    if (!r3_c2.getText().toString().isEmpty()) {
                        int r3_c2_temp = Integer.parseInt(r3_c2.getText().toString().trim());
                        dbmain.setR3_c2(r3_c2_temp);
                    }
                    if (!r3_c3.getText().toString().isEmpty()) {
                        int r3_c3_temp = Integer.parseInt(r3_c3.getText().toString().trim());
                        dbmain.setR3_c3(r3_c3_temp);
                    }
                    if (!r4_c1.getText().toString().isEmpty()) {
                        dbmain.setR4_c1(r4_c1.getText().toString().trim());
                    }
                    if (!r4_c2.getText().toString().isEmpty()) {
                        int r4_c2_temp = Integer.parseInt(r4_c2.getText().toString().trim());
                        dbmain.setR4_c2(r4_c2_temp);
                    }
                    if (!r4_c3.getText().toString().isEmpty()) {
                        int r4_c3_temp = Integer.parseInt(r4_c3.getText().toString().trim());
                        dbmain.setR4_c3(r4_c3_temp);
                    }
                    if (!r5_c1.getText().toString().isEmpty()) {
                        dbmain.setR5_c1(r5_c1.getText().toString().trim());
                    }
                    if (!r5_c2.getText().toString().isEmpty()) {
                        int r5_c2_temp = Integer.parseInt(r5_c2.getText().toString().trim());
                        dbmain.setR5_c2(r5_c2_temp);
                    }
                    if (!r5_c3.getText().toString().isEmpty()) {
                        int r5_c3_temp = Integer.parseInt(r5_c3.getText().toString().trim());
                        dbmain.setR5_c3(r5_c3_temp);
                    }
                    if (!r6_c1.getText().toString().isEmpty()) {
                        dbmain.setR6_c1(r6_c1.getText().toString().trim());
                    }
                    if (!r6_c2.getText().toString().isEmpty()) {
                        int r6_c2_temp = Integer.parseInt(r6_c2.getText().toString().trim());
                        dbmain.setR6_c2(r6_c2_temp);
                    }
                    if (!r6_c3.getText().toString().isEmpty()) {
                        int r6_c3_temp = Integer.parseInt(r6_c3.getText().toString().trim());
                        dbmain.setR6_c3(r6_c3_temp);
                    }
                    if (!r7_c1.getText().toString().isEmpty()) {
                        dbmain.setR7_c1(r7_c1.getText().toString().trim());
                    }
                    if (!r7_c2.getText().toString().isEmpty()) {
                        int r7_c2_temp = Integer.parseInt(r7_c2.getText().toString().trim());
                        dbmain.setR7_c2(r7_c2_temp);
                    }
                    if (!r7_c3.getText().toString().isEmpty()) {
                        int r7_c3_temp = Integer.parseInt(r7_c3.getText().toString().trim());
                        dbmain.setR7_c3(r7_c3_temp);
                    }
                    if (!r8_c1.getText().toString().isEmpty()) {
                        dbmain.setR8_c1(r8_c1.getText().toString().trim());
                    }
                    if (!r8_c2.getText().toString().isEmpty()) {
                        int r8_c2_temp = Integer.parseInt(r8_c2.getText().toString().trim());
                        dbmain.setR8_c2(r8_c2_temp);
                    }
                    if (!r8_c3.getText().toString().isEmpty()) {
                        int r8_c3_temp = Integer.parseInt(r8_c3.getText().toString().trim());
                        dbmain.setR8_c3(r8_c3_temp);
                    }
                    if (!r9_c1.getText().toString().isEmpty()) {
                        dbmain.setR9_c1(r9_c1.getText().toString().trim());
                    }
                    if (!r9_c2.getText().toString().isEmpty()) {
                        int r9_c2_temp = Integer.parseInt(r9_c2.getText().toString().trim());
                        dbmain.setR9_c2(r9_c2_temp);
                    }
                    if (!r9_c3.getText().toString().isEmpty()) {
                        int r9_c3_temp = Integer.parseInt(r9_c3.getText().toString().trim());
                        dbmain.setR9_c3(r9_c3_temp);
                    }
                    if (!r10_c1.getText().toString().isEmpty()) {
                        dbmain.setR10_c1(r10_c1.getText().toString().trim());
                    }
                    if (!r10_c2.getText().toString().isEmpty()) {
                        int r10_c2_temp = Integer.parseInt(r10_c2.getText().toString().trim());
                        dbmain.setR10_c2(r10_c2_temp);
                    }
                    if (!r10_c3.getText().toString().isEmpty()) {
                        int r10_c3_temp = Integer.parseInt(r10_c3.getText().toString().trim());
                        dbmain.setR10_c3(r10_c3_temp);
                    }
                    if (!r11_c1.getText().toString().isEmpty()) {
                        dbmain.setR11_c1(r11_c1.getText().toString().trim());
                    }
                    if (!r11_c2.getText().toString().isEmpty()) {
                        int r11_c2_temp = Integer.parseInt(r11_c2.getText().toString().trim());
                        dbmain.setR11_c2(r11_c2_temp);
                    }
                    if (!r11_c3.getText().toString().isEmpty()) {
                        int r11_c3_temp = Integer.parseInt(r11_c3.getText().toString().trim());
                        dbmain.setR11_c3(r11_c3_temp);
                    }
                    if (!r12_c1.getText().toString().isEmpty()) {
                        dbmain.setR12_c1(r12_c1.getText().toString().trim());
                    }
                    if (!r12_c2.getText().toString().isEmpty()) {
                        int r12_c2_temp = Integer.parseInt(r12_c2.getText().toString().trim());
                        dbmain.setR12_c2(r12_c2_temp);
                    }
                    if (!r12_c3.getText().toString().isEmpty()) {
                        int r12_c3_temp = Integer.parseInt(r12_c3.getText().toString().trim());
                        dbmain.setR12_c3(r12_c3_temp);
                    }
                    if (!r13_c1.getText().toString().isEmpty()) {
                        dbmain.setR13_c1(r13_c1.getText().toString().trim());
                    }
                    if (!r13_c2.getText().toString().isEmpty()) {
                        int r13_c2_temp = Integer.parseInt(r13_c2.getText().toString().trim());
                        dbmain.setR13_c2(r13_c2_temp);
                    }
                    if (!r13_c3.getText().toString().isEmpty()) {
                        int r13_c3_temp = Integer.parseInt(r13_c3.getText().toString().trim());
                        dbmain.setR13_c3(r13_c3_temp);
                    }
                    if (!r14_c1.getText().toString().isEmpty()) {
                        dbmain.setR14_c1(r14_c1.getText().toString().trim());
                    }
                    if (!r14_c2.getText().toString().isEmpty()) {
                        int r14_c2_temp = Integer.parseInt(r14_c2.getText().toString().trim());
                        dbmain.setR14_c2(r14_c2_temp);
                    }
                    if (!r14_c3.getText().toString().isEmpty()) {
                        int r14_c3_temp = Integer.parseInt(r14_c3.getText().toString().trim());
                        dbmain.setR14_c3(r14_c3_temp);
                    }
                    if (!r15_c2.getText().toString().isEmpty()) {
                        dbmain.setR15_c1(r15_c1.getText().toString().trim());
                    }
                    if (!r15_c2.getText().toString().isEmpty()) {
                        int r15_c2_temp = Integer.parseInt(r15_c2.getText().toString().trim());
                        dbmain.setR15_c2(r15_c2_temp);
                    }
                    if (!r15_c2.getText().toString().isEmpty()) {
                        int r15_c3_temp = Integer.parseInt(r15_c3.getText().toString().trim());
                        dbmain.setR15_c3(r15_c3_temp);
                    }
                    if (!total_amount.getText().toString().isEmpty()) {
                        dbmain.setTotal_amount(total_amount.getText().toString().trim());
                    }
                    if (!others.getText().toString().isEmpty()) {
                        dbmain.setOthers(others.getText().toString());
                    }

                    String db_child_name = register_number.getText().toString().trim();
                    dbref.child(db_child_name).setValue(dbmain);
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Success ! ");
                    alert.setMessage("Data Saved successfully !");
                    alert.setPositiveButton("OK", null);
                    alert.show();

                }

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.searchmain, menu);
        MenuItem item = menu.findItem(R.id.search_main);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
             /*   final EditText bill_number = (EditText) findViewById(R.id.billnumID);
                final EditText date_in = (EditText) findViewById(R.id.dateinID);
                final EditText person_name = (EditText) findViewById(R.id.personnameID);
                final EditText phone_number = (EditText) findViewById(R.id.phonenumID);
                final EditText  register_number= (EditText) findViewById(R.id.regnumID);
                final EditText model = (EditText) findViewById(R.id.modelID);
                final EditText odometer_Running = (EditText) findViewById(R.id.odorunID);
                final EditText  r1_c1= (EditText) findViewById(R.id.row1col1);
                final EditText  r1_c2= (EditText) findViewById(R.id.row1col2);
                final EditText  r1_c3= (EditText) findViewById(R.id.row1col3);
                final EditText  r2_c1= (EditText) findViewById(R.id.row2col1);
                final EditText  r2_c2= (EditText) findViewById(R.id.row2col2);
                final EditText  r2_c3= (EditText) findViewById(R.id.row2col3);
                final EditText  r3_c1= (EditText) findViewById(R.id.row3col1);
                final EditText  r3_c2= (EditText) findViewById(R.id.row3col2);
                final EditText  r3_c3= (EditText) findViewById(R.id.row3col3);
                final EditText  r4_c1= (EditText) findViewById(R.id.row4col1);
                final EditText  r4_c2= (EditText) findViewById(R.id.row4col2);
                final EditText  r4_c3= (EditText) findViewById(R.id.row4col3);
                final EditText  r5_c1= (EditText) findViewById(R.id.row5col1);
                final EditText  r5_c2= (EditText) findViewById(R.id.row5col2);
                final EditText  r5_c3= (EditText) findViewById(R.id.row5col3);
                final EditText  r6_c1= (EditText) findViewById(R.id.row6col1);
                final EditText  r6_c2= (EditText) findViewById(R.id.row6col2);
                final EditText  r6_c3= (EditText) findViewById(R.id.row6col3);
                final EditText  r7_c1= (EditText) findViewById(R.id.row7col1);
                final EditText  r7_c2= (EditText) findViewById(R.id.row7col2);
                final EditText  r7_c3= (EditText) findViewById(R.id.row7col3);
                final EditText  r8_c1= (EditText) findViewById(R.id.row8col1);
                final EditText  r8_c2= (EditText) findViewById(R.id.row8col2);
                final EditText  r8_c3= (EditText) findViewById(R.id.row8col3);
                final EditText  r9_c1= (EditText) findViewById(R.id.row9col1);
                final EditText  r9_c2= (EditText) findViewById(R.id.row9col2);
                final EditText  r9_c3= (EditText) findViewById(R.id.row9col3);
                final EditText  r10_c1= (EditText) findViewById(R.id.row10col1);
                final EditText  r10_c2= (EditText) findViewById(R.id.row10col2);
                final EditText  r10_c3= (EditText) findViewById(R.id.row10col3);
                final EditText  r11_c1= (EditText) findViewById(R.id.row11col1);
                final EditText  r11_c2= (EditText) findViewById(R.id.row11col2);
                final EditText  r11_c3= (EditText) findViewById(R.id.row11col3);
                final EditText  r12_c1= (EditText) findViewById(R.id.row12col1);
                final EditText  r12_c2= (EditText) findViewById(R.id.row12col2);
                final EditText  r12_c3= (EditText) findViewById(R.id.row12col3);
                final EditText  r13_c1= (EditText) findViewById(R.id.row13col1);
                final EditText  r13_c2= (EditText) findViewById(R.id.row13col2);
                final EditText  r13_c3= (EditText) findViewById(R.id.row13col3);
                final EditText  r14_c1= (EditText) findViewById(R.id.row14col1);
                final EditText  r14_c2= (EditText) findViewById(R.id.row14col2);
                final EditText  r14_c3= (EditText) findViewById(R.id.row14col3);
                final EditText  r15_c1= (EditText) findViewById(R.id.row15col1);
                final EditText  r15_c2= (EditText) findViewById(R.id.row15col2);
                final EditText  r15_c3= (EditText) findViewById(R.id.row15col3);
                final EditText others = (EditText) findViewById(R.id.otherdetails);


                final  Button clear_button = (Button) findViewById(R.id.clearbtn);
                final Button save_button = (Button) findViewById(R.id.savebtn);

                final Button remove =(Button) findViewById(R.id.removedatabtn);

                final TextView total_amount = (TextView)  findViewById(R.id.Totalamount);

                if (query.isEmpty()) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Empty !");
                    alert.setMessage("Enter the register number to search ");
                    alert.setPositiveButton("OK", null);
                    alert.show();
                }


                else {

                    reference = FirebaseDatabase.getInstance().getReference().child("TestDB").child(query);
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {

                                String billno = snapshot.child("bill_number").getValue().toString();
                                bill_number.setText(billno);

                                if (snapshot.child("date_in").exists()) {
                                    String datein = snapshot.child("date_in").getValue().toString();
                                    date_in.setText(datein);
                                }

                                String ownername = snapshot.child("person_name").getValue().toString();
                                person_name.setText(ownername);
                                String phonenumber = snapshot.child("phone_number").getValue().toString();
                                phone_number.setText(phonenumber);
                                String registernumber = snapshot.child("register_number").getValue().toString();
                                register_number.setText(registernumber);

                                if (snapshot.child("model").exists()) {
                                    String getmmodel = snapshot.child("model").getValue().toString();
                                    model.setText(getmmodel);
                                }
                                if (snapshot.child("odometer_running").exists()) {
                                    String odorunnung = snapshot.child("odometer_running").getValue().toString();
                                    odometer_Running.setText(odorunnung);
                                }


                                if (snapshot.child("r1_c1").exists()) {
                                    String r1c1 = snapshot.child("r1_c1").getValue().toString();
                                    r1_c1.setText(r1c1);
                                }
                                if (snapshot.child("r1_c2").exists()) {
                                    String r1c2 = snapshot.child("r1_c2").getValue().toString();
                                    r1_c2.setText(r1c2);
                                }
                                if (snapshot.child("r1_c3").exists()) {
                                    String r1c3 = snapshot.child("r1_c3").getValue().toString();
                                    r1_c3.setText(r1c3);
                                }

                                if (snapshot.child("r2_c1").exists()) {
                                    String r2c1 = snapshot.child("r2_c1").getValue().toString();
                                    r2_c1.setText(r2c1);
                                }
                                if (snapshot.child("r2_c2").exists()) {
                                    String r2c2 = snapshot.child("r2_c2").getValue().toString();
                                    r2_c2.setText(r2c2);
                                }
                                if (snapshot.child("r2_c3").exists()) {
                                    String r2c3 = snapshot.child("r2_c3").getValue().toString();
                                    r2_c3.setText(r2c3);
                                }


                                if (snapshot.child("r3_c1").exists()) {
                                    String r3c1 = snapshot.child("r3_c1").getValue().toString();
                                    r3_c1.setText(r3c1);
                                }
                                if (snapshot.child("r3_c2").exists()) {
                                    String r3c2 = snapshot.child("r3_c2").getValue().toString();
                                    r3_c2.setText(r3c2);
                                }
                                if (snapshot.child("r3_c3").exists()) {
                                    String r3c3 = snapshot.child("r3_c3").getValue().toString();
                                    r3_c3.setText(r3c3);
                                }


                                if (snapshot.child("r4_c1").exists()) {
                                    String r4c1 = snapshot.child("r4_c1").getValue().toString();
                                    r4_c1.setText(r4c1);
                                }
                                if (snapshot.child("r4_c2").exists()) {
                                    String r4c2 = snapshot.child("r4_c2").getValue().toString();
                                    r4_c2.setText(r4c2);
                                }
                                if (snapshot.child("r4_c3").exists()) {
                                    String r4c3 = snapshot.child("r4_c3").getValue().toString();
                                    r4_c3.setText(r4c3);
                                }


                                if (snapshot.child("r5_c1").exists()) {
                                    String r5c1 = snapshot.child("r5_c1").getValue().toString();
                                    r5_c1.setText(r5c1);
                                }
                                if (snapshot.child("r5_c2").exists()) {
                                    String r5c2 = snapshot.child("r5_c2").getValue().toString();
                                    r5_c2.setText(r5c2);
                                }
                                if (snapshot.child("r5_c3").exists()) {
                                    String r5c3 = snapshot.child("r5_c3").getValue().toString();
                                    r5_c3.setText(r5c3);
                                }


                                if (snapshot.child("r6_c1").exists()) {
                                    String r6c1 = snapshot.child("r6_c1").getValue().toString();
                                    r6_c1.setText(r6c1);
                                }
                                if (snapshot.child("r6_c2").exists()) {
                                    String r6c2 = snapshot.child("r6_c2").getValue().toString();
                                    r6_c2.setText(r6c2);
                                }
                                if (snapshot.child("r6_c3").exists()) {
                                    String r6c3 = snapshot.child("r6_c3").getValue().toString();
                                    r6_c3.setText(r6c3);
                                }


                                if (snapshot.child("r7_c1").exists()) {
                                    String r7c1 = snapshot.child("r7_c1").getValue().toString();
                                    r7_c1.setText(r7c1);
                                }
                                if (snapshot.child("r7_c2").exists()) {
                                    String r7c2 = snapshot.child("r7_c2").getValue().toString();
                                    r7_c2.setText(r7c2);
                                }
                                if (snapshot.child("r7_c3").exists()) {
                                    String r7c3 = snapshot.child("r7_c3").getValue().toString();
                                    r7_c3.setText(r7c3);
                                }


                                if (snapshot.child("r8_c1").exists()) {
                                    String r8c1 = snapshot.child("r8_c1").getValue().toString();
                                    r8_c1.setText(r8c1);
                                }
                                if (snapshot.child("r8_c2").exists()) {
                                    String r8c2 = snapshot.child("r8_c2").getValue().toString();
                                    r8_c2.setText(r8c2);
                                }
                                if (snapshot.child("r8_c3").exists()) {
                                    String r8c3 = snapshot.child("r8_c3").getValue().toString();
                                    r8_c3.setText(r8c3);
                                }


                                if (snapshot.child("r9_c1").exists()) {
                                    String r9c1 = snapshot.child("r9_c1").getValue().toString();
                                    r9_c1.setText(r9c1);
                                }
                                if (snapshot.child("r9_c2").exists()) {
                                    String r9c2 = snapshot.child("r9_c2").getValue().toString();
                                    r9_c2.setText(r9c2);
                                }
                                if (snapshot.child("r9_c3").exists()) {
                                    String r9c3 = snapshot.child("r9_c3").getValue().toString();
                                    r9_c3.setText(r9c3);
                                }


                                if (snapshot.child("r10_c1").exists()) {
                                    String r10c1 = snapshot.child("r10_c1").getValue().toString();
                                    r10_c1.setText(r10c1);
                                }
                                if (snapshot.child("r10_c2").exists()) {
                                    String r10c2 = snapshot.child("r10_c2").getValue().toString();
                                    r10_c2.setText(r10c2);
                                }
                                if (snapshot.child("r10_c3").exists()) {
                                    String r10c3 = snapshot.child("r10_c3").getValue().toString();
                                    r10_c3.setText(r10c3);
                                }


                                if (snapshot.child("r11_c1").exists()) {
                                    String r11c1 = snapshot.child("r11_c1").getValue().toString();
                                    r11_c1.setText(r11c1);
                                }
                                if (snapshot.child("r11_c2").exists()) {
                                    String r11c2 = snapshot.child("r11_c2").getValue().toString();
                                    r11_c2.setText(r11c2);
                                }
                                if (snapshot.child("r11_c3").exists()) {
                                    String r11c3 = snapshot.child("r11_c3").getValue().toString();
                                    r11_c3.setText(r11c3);
                                }


                                if (snapshot.child("r12_c1").exists()) {
                                    String r12c1 = snapshot.child("r12_c1").getValue().toString();
                                    r12_c1.setText(r12c1);
                                }
                                if (snapshot.child("r12_c2").exists()) {
                                    String r12c2 = snapshot.child("r12_c2").getValue().toString();
                                    r12_c2.setText(r12c2);
                                }
                                if (snapshot.child("r12_c3").exists()) {
                                    String r12c3 = snapshot.child("r12_c3").getValue().toString();
                                    r12_c3.setText(r12c3);
                                }


                                if (snapshot.child("r13_c1").exists()) {
                                    String r13c1 = snapshot.child("r13_c1").getValue().toString();
                                    r13_c1.setText(r13c1);
                                }
                                if (snapshot.child("r13_c2").exists()) {
                                    String r13c2 = snapshot.child("r13_c2").getValue().toString();
                                    r13_c2.setText(r13c2);
                                }
                                if (snapshot.child("r13_c3").exists()) {
                                    String r13c3 = snapshot.child("r13_c3").getValue().toString();
                                    r13_c3.setText(r13c3);
                                }


                                if (snapshot.child("r14_c1").exists()) {
                                    String r14c1 = snapshot.child("r14_c1").getValue().toString();
                                    r14_c1.setText(r14c1);
                                }
                                if (snapshot.child("r14_c2").exists()) {
                                    String r14c2 = snapshot.child("r14_c2").getValue().toString();
                                    r14_c2.setText(r14c2);
                                }
                                if (snapshot.child("r14_c3").exists()) {
                                    String r14c3 = snapshot.child("r14_c3").getValue().toString();
                                    r14_c3.setText(r14c3);
                                }


                                if (snapshot.child("r15_c1").exists()) {
                                    String r15c1 = snapshot.child("r15_c1").getValue().toString();
                                    r15_c1.setText(r15c1);
                                }
                                if (snapshot.child("r15_c2").exists()) {
                                    String r15c2 = snapshot.child("r15_c2").getValue().toString();
                                    r15_c2.setText(r15c2);
                                }
                                if (snapshot.child("r15_c3").exists()) {
                                    String r15c3 = snapshot.child("r15_c3").getValue().toString();
                                    r15_c3.setText(r15c3);
                                }


                                if (snapshot.child("total_amount").exists()) {
                                    String totalamount = snapshot.child("total_amount").getValue().toString();
                                    total_amount.setText(totalamount);
                                }

                                if (snapshot.child("others").exists()) {
                                    String getother = snapshot.child("others").getValue().toString();
                                    others.setText(getother);
                                }

                                save_button.setEnabled(false);
                                save_button.setVisibility(View.GONE);

                                remove.setEnabled(true);
                                remove.setVisibility(View.VISIBLE);


                            } else {
                                Toast.makeText(MainActivity.this, "No Data !!", Toast.LENGTH_SHORT).show();
                            }

                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }

                remove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                        alert.setTitle("Delete !!");
                        alert.setMessage("Do you want to delete data?");
                        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                reference.removeValue();
                            }
                        });
                        alert.show();
                        remove.setEnabled(false);
                        remove.setVisibility(View.GONE);
                        save_button.setEnabled(true);
                        save_button.setVisibility(View.VISIBLE);

                    }

                });
                */

             search_data =query;
             firebaseDataSearch();
                return false;
            }


            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }



    public void firebaseDataSearch(){
        //Query query = FirebaseDatabase.getInstance().getReference().child("TestDB");
            Query query = dbref.child(search_data);
        FirebaseRecyclerOptions<datain> options =
                new FirebaseRecyclerOptions.Builder<datain>()
                        .setQuery(query, datain.class)
                        .build();

        FirebaseRecyclerAdapter<datain,datainViewHolder> firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<datain, datainViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull datainViewHolder holder, int position, @NonNull datain model) {

                holder.setIsRecyclable(model.getRegister_number(), model.getDate_in());
            }

            @NonNull
            @Override
            public datainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row,parent,false);
                return new datainViewHolder(view);
            }
        };
        firebaseRecyclerAdapter.startListening();
        recyclerView.setAdapter(firebaseRecyclerAdapter);



    }


    public  class datainViewHolder extends  RecyclerView.ViewHolder{

        View dataView;
        TextView regno = (TextView) findViewById(R.id.rr_regnumber);
        TextView dat = (TextView) findViewById(R.id.rr_datein);
        public datainViewHolder(@NonNull View itemView) {
            super(itemView);
            dataView = itemView;

        }

        public void setIsRecyclable(String register_number, String date_in) {

            regno.setText(register_number);
            dat.setText(date_in);

        }
    }





    //clear method
    public  void clearMethod(){

        final EditText bill_number = (EditText) findViewById(R.id.billnumID);
        final EditText date_in = (EditText) findViewById(R.id.dateinID);
        final EditText person_name = (EditText) findViewById(R.id.personnameID);
        final EditText phone_number = (EditText) findViewById(R.id.phonenumID);
        final EditText  register_number= (EditText) findViewById(R.id.regnumID);
        final EditText model = (EditText) findViewById(R.id.modelID);
        final EditText odometer_Running = (EditText) findViewById(R.id.odorunID);
        final EditText  r1_c1= (EditText) findViewById(R.id.row1col1);
        final EditText  r1_c2= (EditText) findViewById(R.id.row1col2);
        final EditText  r1_c3= (EditText) findViewById(R.id.row1col3);
        final EditText  r2_c1= (EditText) findViewById(R.id.row2col1);
        final EditText  r2_c2= (EditText) findViewById(R.id.row2col2);
        final EditText  r2_c3= (EditText) findViewById(R.id.row2col3);
        final EditText  r3_c1= (EditText) findViewById(R.id.row3col1);
        final EditText  r3_c2= (EditText) findViewById(R.id.row3col2);
        final EditText  r3_c3= (EditText) findViewById(R.id.row3col3);
        final EditText  r4_c1= (EditText) findViewById(R.id.row4col1);
        final EditText  r4_c2= (EditText) findViewById(R.id.row4col2);
        final EditText  r4_c3= (EditText) findViewById(R.id.row4col3);
        final EditText  r5_c1= (EditText) findViewById(R.id.row5col1);
        final EditText  r5_c2= (EditText) findViewById(R.id.row5col2);
        final EditText  r5_c3= (EditText) findViewById(R.id.row5col3);
        final EditText  r6_c1= (EditText) findViewById(R.id.row6col1);
        final EditText  r6_c2= (EditText) findViewById(R.id.row6col2);
        final EditText  r6_c3= (EditText) findViewById(R.id.row6col3);
        final EditText  r7_c1= (EditText) findViewById(R.id.row7col1);
        final EditText  r7_c2= (EditText) findViewById(R.id.row7col2);
        final EditText  r7_c3= (EditText) findViewById(R.id.row7col3);
        final EditText  r8_c1= (EditText) findViewById(R.id.row8col1);
        final EditText  r8_c2= (EditText) findViewById(R.id.row8col2);
        final EditText  r8_c3= (EditText) findViewById(R.id.row8col3);
        final EditText  r9_c1= (EditText) findViewById(R.id.row9col1);
        final EditText  r9_c2= (EditText) findViewById(R.id.row9col2);
        final EditText  r9_c3= (EditText) findViewById(R.id.row9col3);
        final EditText  r10_c1= (EditText) findViewById(R.id.row10col1);
        final EditText  r10_c2= (EditText) findViewById(R.id.row10col2);
        final EditText  r10_c3= (EditText) findViewById(R.id.row10col3);
        final EditText  r11_c1= (EditText) findViewById(R.id.row11col1);
        final EditText  r11_c2= (EditText) findViewById(R.id.row11col2);
        final EditText  r11_c3= (EditText) findViewById(R.id.row11col3);
        final EditText  r12_c1= (EditText) findViewById(R.id.row12col1);
        final EditText  r12_c2= (EditText) findViewById(R.id.row12col2);
        final EditText  r12_c3= (EditText) findViewById(R.id.row12col3);
        final EditText  r13_c1= (EditText) findViewById(R.id.row13col1);
        final EditText  r13_c2= (EditText) findViewById(R.id.row13col2);
        final EditText  r13_c3= (EditText) findViewById(R.id.row13col3);
        final EditText  r14_c1= (EditText) findViewById(R.id.row14col1);
        final EditText  r14_c2= (EditText) findViewById(R.id.row14col2);
        final EditText  r14_c3= (EditText) findViewById(R.id.row14col3);
        final EditText  r15_c1= (EditText) findViewById(R.id.row15col1);
        final EditText  r15_c2= (EditText) findViewById(R.id.row15col2);
        final EditText  r15_c3= (EditText) findViewById(R.id.row15col3);
        final EditText others = (EditText) findViewById(R.id.otherdetails);


        final  Button clear_button = (Button) findViewById(R.id.clearbtn);
        final Button save_button = (Button) findViewById(R.id.savebtn);

        final Button remove =(Button) findViewById(R.id.removedatabtn);

        final TextView total_amount = (TextView)  findViewById(R.id.Totalamount);



        bill_number.getText().clear();
        date_in.getText().clear();
        person_name.getText().clear();
        phone_number.getText().clear();
        register_number.getText().clear();
        model.getText().clear();
        odometer_Running.getText().clear();
        r1_c1.getText().clear();
        r1_c2.getText().clear();
        r1_c3.getText().clear();
        r2_c1.getText().clear();
        r2_c2.getText().clear();
        r2_c3.getText().clear();
        r3_c1.getText().clear();
        r3_c2.getText().clear();
        r3_c3.getText().clear();
        r4_c1.getText().clear();
        r4_c2.getText().clear();
        r4_c3.getText().clear();
        r5_c1.getText().clear();
        r5_c2.getText().clear();
        r5_c3.getText().clear();
        r6_c1.getText().clear();
        r6_c2.getText().clear();
        r6_c3.getText().clear();
        r7_c1.getText().clear();
        r7_c2.getText().clear();
        r7_c3.getText().clear();
        r8_c1.getText().clear();
        r8_c2.getText().clear();
        r8_c3.getText().clear();
        r9_c1.getText().clear();
        r9_c2.getText().clear();
        r9_c3.getText().clear();
        r10_c1.getText().clear();
        r10_c2.getText().clear();
        r10_c3.getText().clear();
        r11_c1.getText().clear();
        r11_c2.getText().clear();
        r11_c3.getText().clear();
        r12_c1.getText().clear();
        r12_c2.getText().clear();
        r12_c3.getText().clear();
        r13_c1.getText().clear();
        r13_c2.getText().clear();
        r13_c3.getText().clear();
        r14_c1.getText().clear();
        r14_c2.getText().clear();
        r14_c3.getText().clear();
        r15_c1.getText().clear();
        r15_c2.getText().clear();
        r15_c3.getText().clear();
        others.getText().clear();

        save_button.setEnabled(true);
        save_button.setVisibility(View.VISIBLE);
        remove.setEnabled(false);
        remove.setVisibility(View.GONE);
    }


}


 /*class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.ViewHolder> {

    List<String>  childs;

    public recyclerAdapter(List<String> childs) {
        this.childs = childs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.rrRegnum.setText(childs.get(position));
        holder.rrdatein.setText((childs.get(position)));


    }

    @Override
    public int getItemCount() {
        return childs.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView rrRegnum;
        TextView rrdatein;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rrRegnum = itemView.findViewById(R.id.rr_regnumber);
            rrdatein = itemView.findViewById(R.id.rr_datein);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            Toast.makeText(view.getContext(),"clicked",Toast.LENGTH_LONG).show();
        }
    }



}*/