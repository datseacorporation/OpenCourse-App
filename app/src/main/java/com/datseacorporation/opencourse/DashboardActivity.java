package com.datseacorporation.opencourse;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class DashboardActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;
    private ExploreFragment exploreFragment;
    private RecommendedFragment recommendedFragment;
    private CommunityFragment communityFragment;
    private MyCourcesFragment myCourcesFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mMainFrame = findViewById(R.id.main_frame);
        mMainNav = findViewById(R.id.main_nav);
        exploreFragment = new ExploreFragment();
        recommendedFragment = new RecommendedFragment();
        communityFragment = new CommunityFragment();
        myCourcesFragment = new MyCourcesFragment();
        profileFragment = new ProfileFragment();
        mMainNav.setSelectedItemId(R.id.nav_community_item);
        mMainNav.setItemBackgroundResource(R.color.navColorCommunity);
        setFragment(communityFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case  R.id.nav_explore_item :
                        mMainNav.setItemBackgroundResource(R.color.navColorExp);
                        setFragment(exploreFragment);
                        return true;

                    case  R.id.nav_recommended_item :
                        mMainNav.setItemBackgroundResource(R.color.navColorRec);
                        setFragment(recommendedFragment);
                        return true;

                    case  R.id.nav_community_item :
                        mMainNav.setItemBackgroundResource(R.color.navColorCommunity);
                        setFragment(communityFragment);
                        return true;

                    case  R.id.nav_mycources_item :
                        mMainNav.setItemBackgroundResource(R.color.navColorMy);
                        setFragment(myCourcesFragment);
                        return true;

                    case  R.id.nav_profile_item :
                        mMainNav.setItemBackgroundResource(R.color.navColorProfile);
                        setFragment(profileFragment);
                        return true;

                    default:
                        return false;

                }

            }

        });

    }
    public  void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }
}
