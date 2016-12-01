package com.gdeaditya.simplechat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.qiscus.sdk.Qiscus;
import com.qiscus.sdk.data.model.QiscusAccount;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //you can customize what your chat looks like
        Qiscus.getChatConfig()
                .setStatusBarColor(R.color.colorPrimaryDark)
                .setAppBarColor(R.color.colorPrimary);

        //initialize email and password for user account
        showLoading();
        Qiscus.setUser(getString(R.string.my_email), "userKey")
                .withUsername(getResources().getString(R.string.kim_name))
                .save(new Qiscus.SetUserListener() {
                    @Override
                    public void onSuccess(QiscusAccount qiscusAccount) {
                        dismissLoading();
                        Toast.makeText(getApplication(), "Success Login", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        dismissLoading();
                        Toast.makeText(getApplication(), "Failed", Toast.LENGTH_LONG).show();
                    }
                });

        //initialize email and name for person 1
        findViewById(R.id.btn_chat1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Qiscus.buildChatWith(getString(R.string.kim_email))
                        .withTitle(getString(R.string.kim_name))
                        .build(MainActivity.this, new Qiscus.ChatActivityBuilderListener() {
                            @Override
                            public void onSuccess(Intent intent) {
                                startActivity(intent);
                            }
                            @Override
                            public void onError(Throwable throwable) {
                                throwable.printStackTrace();
                                Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        //initialize email and name for person 2
        findViewById(R.id.btn_chat2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Qiscus.buildChatWith(getString(R.string.clara_email))
                        .withTitle(getString(R.string.clara_name))
                        .build(MainActivity.this, new Qiscus.ChatActivityBuilderListener() {
                            @Override
                            public void onSuccess(Intent intent) {
                                startActivity(intent);
                            }
                            @Override
                            public void onError(Throwable throwable) {
                                throwable.printStackTrace();
                                Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        //initialize email and name for person 3
        findViewById(R.id.btn_chat3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Qiscus.buildChatWith(getString(R.string.anna_email))
                        .withTitle(getString(R.string.anna_name))
                        .build(MainActivity.this, new Qiscus.ChatActivityBuilderListener() {
                            @Override
                            public void onSuccess(Intent intent) {
                                startActivity(intent);
                            }
                            @Override
                            public void onError(Throwable throwable) {
                                throwable.printStackTrace();
                                Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    public void showLoading() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Please wait...");
        }
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void dismissLoading() {
        progressDialog.dismiss();
    }
}
