package com.nanochips.nanochips;


import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.nanochips.nanochips.adapter.NanoChipAdapter;

import java.util.ArrayList;

public class NanoChipClass {
    public static final String EXTRA_EMPTY_CHIP_VALUE = "nanoChips2020NanoChip2020";
    // private NanoChipAdapter chipAdapter;

    public NanoChipClass() {
    }

    public NanoChipClass(Context context, RecyclerView recyclerView) {
        NanoChipAdapter chipAdapter = new NanoChipAdapter(context);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(context);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(chipAdapter);
    }


    public NanoChipClass(Context context, RecyclerView recyclerView, ArrayList<String> list) {
        NanoChipAdapter chipAdapter = new NanoChipAdapter(context, list);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(context);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(chipAdapter);
    }

    public static ArrayList<String> getAllChipsValues() {
        ArrayList<String> arrList = new ArrayList<>();
        for (String chipValue : NanoChipAdapter.getChipValues()) {
            if (!chipValue.equalsIgnoreCase(EXTRA_EMPTY_CHIP_VALUE)) {
                arrList.add(chipValue);
            }
        }
        return arrList;
    }
}
