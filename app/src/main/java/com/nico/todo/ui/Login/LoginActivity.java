package com.nico.todo.ui.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nico.todo.R;
import com.nico.todo.util.ActivityUtils;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginFragment loginFragment =
                (LoginFragment) getFragmentManager().findFragmentById(R.id.contentFrame);
        if (loginFragment == null) {
            // Create the fragment
            loginFragment = LoginFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getFragmentManager(), loginFragment, R.id.contentFrame);
        }

    }


}

