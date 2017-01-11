package freshgrc.android.com.auditgrc.auditeFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import freshgrc.android.com.auditgrc.R;

/**
 * Created by akila on 3/11/16.
 */

public class DoFragment extends Fragment {

    private LinearLayoutManager lLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_entity, container, false);

//        List<ItemObject> rowListItem = getAllItemList();
//        lLayout = new LinearLayoutManager(getActivity());
//        getActivity().setTitle("OverView");
//        RecyclerView rView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
//        rView.setLayoutManager(lLayout);
//
//        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(getActivity(), rowListItem);
//        rView.setAdapter(rcAdapter);
        return rootView;
    }

//    private List<ItemObject> getAllItemList(){
//
//        List<ItemObject> allItems = new ArrayList<ItemObject>();
////        allItems.add(new ItemObject("Pie chart", R.drawable.pie_chart));
////        allItems.add(new ItemObject("Bar chart", R.drawable.bar_chart));
////        allItems.add(new ItemObject("Line chart", R.drawable.line_chart));
////        allItems.add(new ItemObject("Pie chart", R.drawable.pie_chart));
////        allItems.add(new ItemObject("Bar chart", R.drawable.bar_chart));
//
//        return allItems;
//    }
}