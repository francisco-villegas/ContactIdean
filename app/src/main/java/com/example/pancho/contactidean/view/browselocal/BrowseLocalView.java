package com.example.pancho.contactidean.view.browselocal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.pancho.contactidean.App;
import com.example.pancho.contactidean.R;
import com.example.pancho.contactidean.entities.User;
import com.example.pancho.contactidean.injection.browselocal.BrowseLocalModule;
import com.example.pancho.contactidean.injection.browselocal.DaggerBrowseLocalComponent;
import com.example.pancho.contactidean.view.Contract;
import com.example.pancho.contactidean.view.ViewModel;
import com.example.pancho.contactidean.view.home.HomeView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import icepick.Icepick;
import icepick.State;

public class BrowseLocalView extends AppCompatActivity implements Contract.View, FirstAdapter.UserListener {

    @Inject
    ViewModel viewModel;

    @Inject
    SharedPreferences prefs;

    @BindView(R.id.recycler)
    RecyclerView recycler;

    LinearLayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    FirstAdapter firstAdapter;

    @State
    ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_local);

        setTitle("Browse Local");

        ButterKnife.bind(this);

        setupDaggerComponent();

        Icepick.restoreInstanceState(this, savedInstanceState);

        initRecycler();

        initViewModel();

        viewModel.getUsers(((App) getApplication()).getDaoSession());
    }

    private void initRecycler() {
        layoutManager = new LinearLayoutManager(getApplicationContext());
        itemAnimator = new DefaultItemAnimator();
        recycler.setLayoutManager(layoutManager);
        recycler.setItemAnimator(itemAnimator);
        recycler.setHasFixedSize(true);
        recycler.setItemViewCacheSize(20);
        recycler.setDrawingCacheEnabled(true);
        recycler.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        firstAdapter = new FirstAdapter(userList);
        recycler.setAdapter(firstAdapter);
        firstAdapter.notifyDataSetChanged();

    }

    private void initViewModel() {
        viewModel.attachView(this);
        viewModel.attachRemote();
    }

    /**
     * Setup dagger with the sharepreferences as a dependency
     **/
    private void setupDaggerComponent() {
        DaggerBrowseLocalComponent.builder()
                .sharedPreferencesComponent(((App) getApplicationContext()).getSharePreferencesComponent())
                .browseLocalModule(new BrowseLocalModule())
                .build()
                .inject(this);
    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void sendInfo(User user) {
    }

    @Override
    public void sendResult(List<User> users) {
    }

    @Override
    public void sendUsers(List<User> users) {
        if(users.size()>0) {
            firstAdapter = new FirstAdapter(users);
            recycler.setAdapter(firstAdapter);
            firstAdapter.notifyDataSetChanged();

            this.userList = new ArrayList<User>(users);
        }
        else
            Toast.makeText(this, "There are no contact records stored.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ItemClick(User item) {
        Intent intent = new Intent(this, HomeView.class);
        intent.putExtra(getString(R.string.user),item);
        startActivity(intent);
    }

    /**
     * Save the instance of the recyclerview using Icepick
     **/
    @Override public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }
}
