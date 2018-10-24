package cn.gdcp.alertdialogdemo;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button alert_dialog_1;
    private Button alert_dialog_2;
    private Button alert_dialog_3;
    private Button alert_dialog_4;
    private Button alert_dialog_5;
    private Button alert_dialog_6;
    private Button alert_dialog_7;
    private EditText et_name;
    private EditText et_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showAlertDialog_1();
        showAlertDialog_2();
        showAlertDialog_3();
        showAlertDialog_4();
        showAlertDialog_5();
        showAlertDialog_6();
        showAlertDialog_7();
    }

    private void showAlertDialog_7() {
        alert_dialog_7=(Button)findViewById(R.id.alert_dialog_7);
        alert_dialog_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builer=new AlertDialog.Builder(MainActivity.this);
                builer.create();
                builer.setTitle("自定义编辑框");
                View dialog_view=getLayoutInflater().from(MainActivity.this).inflate(R.layout.dialog,null);
                builer.setView(dialog_view);

               et_name=(EditText)dialog_view.findViewById(R.id.et_name);
               et_password=(EditText)dialog_view.findViewById(R.id.et_password);
                builer.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"用户名"+et_name.getText().toString().trim()+" "+"密码"+et_password.getText().toString().trim(),Toast.LENGTH_LONG).show();
                    }
                });
                builer.show();
            }
        });
    }

    private void showAlertDialog_6() {
        alert_dialog_6=(Button)findViewById(R.id.alert_dialog_6);
        alert_dialog_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText editText=new EditText(MainActivity.this);
                AlertDialog.Builder builer=new AlertDialog.Builder(MainActivity.this);
                builer.create();
                builer.setTitle("这是一个编辑框").setView(editText);
                builer.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),editText.getText().toString().trim(),Toast.LENGTH_LONG).show();
                    }
                });
                builer.show();
            }
        });
    }

    private void showAlertDialog_5() {
        alert_dialog_5=(Button)findViewById(R.id.alert_dialog_5);
        alert_dialog_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("这是一个等待框");
                progressDialog.setMessage("等待中...");
                progressDialog.setIndeterminate(true);
                progressDialog.setCancelable(false);
                progressDialog.show();
            }
        });
    }

    private void showAlertDialog_2() {
        alert_dialog_2=(Button)findViewById(R.id.alert_dialog_2);
        final String[] classes={"1班","2班","3班","4班"};
        alert_dialog_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder buider=new AlertDialog.Builder(MainActivity.this);
                buider.create();
                buider.setTitle("列表框");
                buider.setItems(classes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),classes[i],Toast.LENGTH_LONG).show();
                    }
                });
                buider.show();
            }
        });
    }

    private void showAlertDialog_4() {
        final List<Integer> list=new ArrayList<Integer>();
        alert_dialog_4=(Button)findViewById(R.id.alert_dialog_4);
        final String[] hobbys={"打篮球","听音乐","打电动","跑步"};
        final boolean[] checked=new boolean[hobbys.length];
        list.clear();
        alert_dialog_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builer=new AlertDialog.Builder(MainActivity.this);
                builer.create();
                builer.setMultiChoiceItems(hobbys, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if (b){
                            list.add(i);
                        }else {
                            list.remove(i);
                        }
                    }
                });
                builer.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builer.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String str="";
                        for (int j=0;j<list.size();j++){
                            str+=hobbys[list.get(j)]+" ";
                        }
                        Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
                    }
                });
                builer.show();
            }
        });
    }

    private void showAlertDialog_3() {
        alert_dialog_3=(Button)findViewById(R.id.alert_dialog_3);
        final String[] citys={"北京","上海","广州","深圳"};
        alert_dialog_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builer=new AlertDialog.Builder(MainActivity.this);
                builer.create();
                builer.setTitle("这是一个单选框!");
                builer.setSingleChoiceItems(citys, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),citys[i],Toast.LENGTH_LONG).show();
                    }
                });
                builer.show();
            }
        });
    }

    private void showAlertDialog_1() {
        alert_dialog_1=(Button)findViewById(R.id.alert_dialog_1);
        alert_dialog_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builer=new AlertDialog.Builder(MainActivity.this);
                builer.create();
                builer.setTitle("这是一个普通复选框!");
                builer.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builer.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builer.show();
            }
        });
    }
}
