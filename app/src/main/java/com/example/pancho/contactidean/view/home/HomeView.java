package com.example.pancho.contactidean.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pancho.contactidean.R;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeView extends AppCompatActivity {

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tvEmail)
    TextView tvEmail;
    @BindView(R.id.tvPhoneNumber)
    TextView tvPhoneNumber;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.ivProfile_image)
    CircularImageView ivProfileImage;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();

        loadInfo();
    }

    @Override
    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.log_out:
                LogOut();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void LogOut() {
        FirebaseAuth.getInstance().signOut();
        LoginManager.getInstance().logOut();
        Toast.makeText(this, "Sign out successfully", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void loadInfo() {
        String img = mAuth.getCurrentUser().getPhotoUrl().toString();
        String nombre = mAuth.getCurrentUser().getDisplayName();
        String email = mAuth.getCurrentUser().getEmail();
        String phone = mAuth.getCurrentUser().getPhoneNumber();

        Picasso.with(getApplicationContext()).load(img).into(ivProfileImage);

        tvName.setText(nombre);
        tvEmail.setText(email);
        tvPhoneNumber.setText(phone);
    }
}
