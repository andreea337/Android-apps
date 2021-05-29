package com.example.order_system;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button mbtnCommit;
    EditText medtName;
    TextView mtxtDriknkres, mtxtIceres, mtxtSweetres;

    public static final int FUNC_RETURN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemSetting();

        mbtnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //bundle
                String tmp = medtName.getText().toString();
                if(tmp.isEmpty()){
                    Toast.makeText(getApplicationContext(), "請輸入訂購人姓名", Toast.LENGTH_LONG)
                            .show();
                }

                if(!tmp.isEmpty()) {
                    //intent(this class, to class)
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name", tmp); //bundle.put*VAL_type*("key", value)
                    intent.putExtras(bundle);
                    startActivityForResult(intent, 1);
                    //startActivity(intent);
                }
            }
        });


    }

    private void itemSetting(){
        mbtnCommit = findViewById(R.id.btnCommit);
        medtName = findViewById(R.id.edtName);
        mtxtDriknkres = findViewById(R.id.txtDrinkRes);
        mtxtIceres = findViewById(R.id.txtIceRes);
        mtxtSweetres = findViewById(R.id.txtSweetRes);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == FUNC_RETURN){
            if(resultCode == RESULT_OK){
                Bundle bundle = data.getExtras();
                HashMap<String, String> map = (HashMap<String, String>)bundle.getSerializable("map");
                String drink = map.get("drink");
                String ice = map.get("ice");
                String sweet = map.get("sweet");
                setTxt(drink, ice, sweet);
            }
            else {
                finish();
            }
        }
    }

    private void setTxt(String drink, String ice, String sweet){
        mtxtDriknkres.setText("你的飲料 : " + drink);
        mtxtIceres.setText("冰度 : " + ice);
        mtxtSweetres.setText("甜度 : " + sweet);
    }
}