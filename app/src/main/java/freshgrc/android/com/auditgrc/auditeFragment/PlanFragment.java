package freshgrc.android.com.auditgrc.auditeFragment;

/**
 * Created by mufsira on 22/10/16.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import freshgrc.android.com.auditgrc.ItemObject;
import freshgrc.android.com.auditgrc.R;
import freshgrc.android.com.auditgrc.auditeActivity.EntityActivity;


public class PlanFragment extends Fragment {

    private LinearLayoutManager lLayout;
    public FloatingActionButton btn_add;
    Activity context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_dashboard, container, false);

//        List<ItemObject> rowListItem = getAllItemList();
//        lLayout = new LinearLayoutManager(getActivity());
        context=getActivity();
        getActivity().setTitle("OverView");



//        RecyclerView rView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
//        rView.setLayoutManager(lLayout);

//        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(getActivity(), rowListItem);
//        rView.setAdapter(rcAdapter);

        btn_add = (FloatingActionButton) rootView.findViewById(R.id.add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myint = new Intent(context,EntityActivity.class);
                startActivity(myint);
            }
        });
        Snackbar snackbar = Snackbar
                .make(rootView.findViewById(R.id.myCoordinatorLayout), "Message is Add", Snackbar.LENGTH_LONG)
                .setAction("ADD", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(rootView.findViewById(R.id.myCoordinatorLayout), "Message is restored!", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });

        snackbar.show();

//        Snackbar.make(rootView.findViewById(R.id.myCoordinatorLayout), R.string.email_sent ,
//                Snackbar.LENGTH_SHORT)
//                .show();
//


        return rootView;
    }





    private List<ItemObject> getAllItemList(){

        List<ItemObject> allItems = new ArrayList<ItemObject>();
//        allItems.add(new ItemObject("Pie chart", R.drawable.pie_chart));
//        allItems.add(new ItemObject("Bar chart", R.drawable.bar_chart));
//        allItems.add(new ItemObject("Line chart", R.drawable.line_chart));
//        allItems.add(new ItemObject("Pie chart", R.drawable.pie_chart));
//        allItems.add(new ItemObject("Bar chart", R.drawable.bar_chart));

        return allItems;
    }
}