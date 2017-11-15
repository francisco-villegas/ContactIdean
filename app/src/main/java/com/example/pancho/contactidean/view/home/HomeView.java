package com.example.pancho.contactidean.view.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pancho.contactidean.App;
import com.example.pancho.contactidean.R;
import com.example.pancho.contactidean.entities.User;
import com.example.pancho.contactidean.injection.home.DaggerHomeComponent;
import com.example.pancho.contactidean.injection.home.HomeModule;
import com.example.pancho.contactidean.view.Contract;
import com.example.pancho.contactidean.view.ViewModel;
import com.example.pancho.contactidean.view.browselocal.BrowseLocalView;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;
import com.varunest.sparkbutton.SparkButton;
import com.varunest.sparkbutton.SparkEventListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeView extends AppCompatActivity implements Contract.View, SparkEventListener {

    @Inject
    ViewModel viewModel;

    @Inject
    SharedPreferences prefs;

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
    @BindView(R.id.hearth_button)
    SparkButton hearthButton;

    private FirebaseAuth mAuth;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setTitle("Profile");

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();

        loadInfo();

        setupDaggerComponent();

        initViewModel();

        hearthButton.setEventListener(this);

        initColor();
    }

    private void initViewModel() {
        viewModel.attachView(this);
        viewModel.attachRemote();
    }

    /**
     * Setup dagger with the sharepreferences as a dependency
     **/
    private void setupDaggerComponent() {
        DaggerHomeComponent.builder()
                .sharedPreferencesComponent(((App) getApplicationContext()).getSharePreferencesComponent())
                .homeModule(new HomeModule())
                .build()
                .inject(this);
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
            case R.id.fetch_user:
                FetchUser();
                break;
            case R.id.browse_local:
                BrowseLocal();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void BrowseLocal() {
        Intent intent = new Intent(this,BrowseLocalView.class);
        startActivity(intent);
    }

    private void FetchUser() {
        viewModel.FetchRandomUser();
    }

    private void LogOut() {
        FirebaseAuth.getInstance().signOut();
        LoginManager.getInstance().logOut();
        Toast.makeText(this, "Sign out successfully", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void loadInfo() {
        user = getIntent().getParcelableExtra(getString(R.string.user));
        if(user != null) {
            String img = "";
            if (user.getImg_url() != null)
                img = user.getImg_url().toString();
            String name = user.getName();
            String email = user.getEmail();
            String phone = user.getPhone();

            Picasso.with(getApplicationContext()).load(img).into(ivProfileImage);

            tvName.setText(name);
            tvEmail.setText(email);
            tvPhoneNumber.setText(phone);
        }
    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void sendInfo(User user) {
        Intent intent = new Intent(this, HomeView.class);
        intent.putExtra(getString(R.string.user),user);
        startActivity(intent);
    }

    @Override
    public void sendResult(List<User> users) {
        if (users != null && users.size() > 0) {
            hearthButton.setChecked(true);
        }
    }

    @Override
    public void sendUsers(List<User> users) {

    }

    /**
     * Send an action to the viewmodel to verify if the element has a like or not
     **/
    private void initColor() {
        if(user != null)
            viewModel.localquery(((App) getApplication()).getDaoSession(), user);
    }

    /**
     * Listeners replacing OnclickListener from the custom hearth
     **/
    @Override
    public void onEvent(ImageView button, boolean buttonState) {
        viewModel.saveChecked(((App) getApplication()).getDaoSession(), buttonState, user);
    }

    @Override
    public void onEventAnimationEnd(ImageView button, boolean buttonState) {

    }

    @Override
    public void onEventAnimationStart(ImageView button, boolean buttonState) {

    }
}
