package com.example.inventory;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    DatabaseHelperUser dbHelper;
    EditText TxNoInduk, TxPassword;

    public static final String FILENAME = "login";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //views to object


        /*dbHelper = new DatabaseHelperUser(this);*/

        TxNoInduk = (EditText)findViewById(R.id.et_login_nomorinduk);
        TxPassword = (EditText)findViewById(R.id.et_login_password);
        Button btLogin = (Button) findViewById(R.id.btDoneRegister);


        dbHelper = new DatabaseHelperUser(this);

        Button btRegister = (Button) findViewById(R.id.btRegister);

        btRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent( LoginActivity.this, RegisterActivity.class));
            }

        });




        btLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String noinduk = TxNoInduk.getText().toString().trim();
                String password = TxPassword.getText().toString().trim();

                Boolean res = dbHelper.checkUser(noinduk, password);
                if (res == true)
                {
                    Toast.makeText(LoginActivity.this, "Login Sukses", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, DashboardUserActivity.class));
                }else {
                    Toast.makeText(LoginActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }

        });



        /*btRegister.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });*/

        /*btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_login_nomorinduk = findViewById(R.id.et_login_nomorinduk);
                et_login_password = findViewById(R.id.et_login_password);

                String nomor_induk = et_login_nomorinduk.getText().toString();
                String password = et_login_password.getText().toString();

                if (login(nomor_induk, password)) {
                    Toast.makeText(LoginActivity.this, "Login berhasil", Toast.LENGTH_SHORT).show();
                    // ganti dengan intent ke halaman selanjutnya setelah login berhasil
                } else {
                    Toast.makeText(LoginActivity.this, "Username atau password salah", Toast.LENGTH_SHORT).show();
                }
            }
        });*/

        //event handler
        //btLogin.setOnClickListener(v -> login());










    }

    public static Spanned fromHtml(String html)
    {
        Spanned result;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
        {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        }
        else
        {
            result = Html.fromHtml(html);
        }
        return result;
    }

            /*private boolean login(String no_induk, String password) {
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                String selection = "no_induk = ? AND password = ?";
                String[] selectionArgs = {no_induk, password};
                Cursor cursor = db.query("user", null, selection, selectionArgs, null, null, null);
                int count = cursor.getCount();
                cursor.close();
                return count > 0;
            }*/
}
