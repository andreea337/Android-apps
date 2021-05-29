package com.example.order_system;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {

    TextView mtxtName;
    EditText medtDrink;
    Button mbtnSend;
    RadioButton mradBtnIceMin, mradBtnIceMed, mradBtnIceMax;
    RadioButton mradBtnSweetMin, mradBtnSweetMed, mradBtnSweetMax;
    RadioGroup mradGrpIce, mradGrpSweet;
    Boolean first = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        itemSetting();
        /* https://nnosnhoj.pixnet.net/blog/post/43603513
        Any local variable, formal parameter, or exception parameter
        used but not declared in an inner class must be declared final.
        HashMap<String, String>傳入onclick的時候會報錯，傳入List即可
         */
        ArrayList<HashMap<String, String>> list = new ArrayList<>();

        //get object from MainActivity
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");
        mtxtName.setText("訂購人 " + name);


        //when btnSend click then create a alert dialog
        mbtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save the data into list
                HashMap<String, String> map = new HashMap<>();
                map = getData(map);
                if(map.get("ice") == null){
                    Toast.makeText(getApplicationContext(), "沒有點選冰度", Toast.LENGTH_LONG)
                            .show();
                }
                if(map.get("sweet") == null){
                    Toast.makeText(getApplicationContext(), "沒有點選糖度", Toast.LENGTH_LONG)
                            .show();

                }
                if(map.get("ice") != null && map.get("sweet") != null){
                    if(first == false){
                        list.add(map);
                        first = true;
                    }
                    else{
                        change(list, map);
                    }

                    //alert dialog
                    AlertDialog.Builder dialog = new AlertDialog.Builder(Main2Activity.this);
                    dialog.setTitle("確認訂單")
                            .setMessage("飲料名稱 : " +  list.get(0).get("drink") + '\n'
                                    + "甜度 : " +  list.get(0).get("sweet") + '\n'
                                    + "冰塊 : " + list.get(0).get("ice"))
                            .setPositiveButton("確認",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent1 = new Intent(Main2Activity.this, MainActivity.class);
                                            Bundle bundle1 = new Bundle();
                                            //putSerializable: List, Map
                                            bundle1.putSerializable("map", list.get(0));
                                            intent1.putExtras(bundle1);
                                            setResult(RESULT_OK, intent1);
                                            finish();
                                        }
                                    })
                            .show();
                }
            }
        });


    }

    private void itemSetting(){
        medtDrink = findViewById(R.id.edtDrink);
        mtxtName = findViewById(R.id.txtName);
        mradGrpIce = findViewById(R.id.radGrpIce);
        mradGrpSweet = findViewById(R.id.radGrpSweet);
        mradBtnIceMax = findViewById(R.id.radBtnIceMax);
        mradBtnIceMed = findViewById(R.id.radBtnIceMed);
        mradBtnIceMin = findViewById(R.id.radBtnIceMin);
        mradBtnSweetMax = findViewById(R.id.radBtnSweetMax);
        mradBtnSweetMed = findViewById(R.id.radBtnSweetMed);
        mradBtnSweetMin = findViewById(R.id.radBtnSweetMin);
        mbtnSend = findViewById(R.id.btnSend);
    }

    private HashMap<String, String> getData(HashMap<String, String> map){

        switch (mradGrpIce.getCheckedRadioButtonId()){
            case R.id.radBtnIceMax:
                map.put("ice", mradBtnIceMax.getText().toString());
                break;
            case R.id.radBtnIceMed:
                map.put("ice", mradBtnIceMed.getText().toString());
                break;
            case R.id.radBtnIceMin:
                map.put("ice", mradBtnIceMin.getText().toString());

        }

        switch (mradGrpSweet.getCheckedRadioButtonId()){
            case R.id.radBtnSweetMax:
                map.put("sweet", mradBtnSweetMax.getText().toString());
                break;
            case R.id.radBtnSweetMed:
                map.put("sweet", mradBtnSweetMed.getText().toString());
                break;
            case R.id.radBtnSweetMin:
                map.put("sweet", mradBtnSweetMin.getText().toString());
                break;
            default:
                Toast.makeText(getApplicationContext(), "沒有點選糖度", Toast.LENGTH_LONG);
        }

        map.put("drink", medtDrink.getText().toString());
        return map;
    }

    private void change(ArrayList<HashMap<String, String>> list, HashMap<String, String> map){
        //compare the data that store in arrayList and the "new" data that store in map
        //if its not the same, then change the list data to new data
        if(list.get(0).get("drink") != map.get("drink") ||
        list.get(0).get("ice") != map.get("ice") ||
        list.get(0).get("sweet") != map.get("sweet")){
            list.remove(0);
            list.add(map);
        }
    }
}