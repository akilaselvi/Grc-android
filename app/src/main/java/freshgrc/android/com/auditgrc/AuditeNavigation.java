package freshgrc.android.com.auditgrc;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import freshgrc.android.com.auditgrc.auditeFragment.PlanFragment;
import freshgrc.android.com.auditgrc.auditeFragment.DoFragment;


public class AuditeNavigation extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 8 ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tab_layout,null);

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        getActivity().setTitle("Autitee");
        return view;

    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new PlanFragment();
                case 1 : return new DoFragment();
//                case 2 : return new RoleFragment();
//                case 3 : return new UserFragment();
//                case 4 : return new LibrariesFragment();
//                case 5 : return new WeightageFragment();
                case 6 : return new PlanFragment();


            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "PLAN";
                case 1 :
                    return "DO";
                case 2 :
                    return "CHECK";
                case 3 :
                    return "ACT";
                case 4 :
                    return "PUBLISH";

            }
            return null;
        }
    }


}