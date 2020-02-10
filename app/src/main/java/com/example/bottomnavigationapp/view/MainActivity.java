package com.example.bottomnavigationapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bottomnavigationapp.R;
import com.example.bottomnavigationapp.view.comments.CommentsFragment;
import com.example.bottomnavigationapp.view.post.PostsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigation;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private boolean bottomNavSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createFragment(new PostsFragment());
        bottomNavigation = findViewById(R.id.bottom_nav);
        bottomNavigation.setOnNavigationItemSelectedListener(listener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.post:
                           createFragment(new PostsFragment());
                           break;
                        case R.id.comment:
                            createFragment(new CommentsFragment());
                            break;
                    }
                    return true;
                }
            };

    public void createFragment(Fragment fragment) {

        manager = getSupportFragmentManager();

        transaction = manager.beginTransaction();

        transaction.replace(R.id.fragment_container, fragment).commit();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

}
