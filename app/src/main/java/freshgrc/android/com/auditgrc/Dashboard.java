package freshgrc.android.com.auditgrc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends Fragment {

    private LinearLayoutManager lLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_entitylist, container, false);

        List<ItemObject> rowListItem = getAllItemList();
        lLayout = new LinearLayoutManager(getActivity());
        RecyclerView rView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        rView.setLayoutManager(lLayout);
        getActivity().setTitle("Dashboard");

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);
        return rootView;
    }

    private List<ItemObject> getAllItemList(){

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Pie chart", R.drawable.pie_chart));
        allItems.add(new ItemObject("Bar chart", R.drawable.bar_chart));
        allItems.add(new ItemObject("Line chart", R.drawable.line_chart));
        allItems.add(new ItemObject("Pie chart", R.drawable.pie_chart));
        allItems.add(new ItemObject("Bar chart", R.drawable.bar_chart));

        return allItems;
    }



}
