package com.nanochips.nanochips.adapter;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.nanochips.nanochips.R;

import java.util.ArrayList;

import static com.nanochips.nanochips.NanoChipClass.EXTRA_EMPTY_CHIP_VALUE;

public class NanoChipAdapter extends RecyclerView.Adapter<NanoChipAdapter.ItemRowHolder> {
    static ArrayList<String> response;
    private Context context;

    //call this method to show blank nano chip
    public NanoChipAdapter(Context activity) {
        context = activity;
        response = new ArrayList<>();
        response.add(EXTRA_EMPTY_CHIP_VALUE);
    }

    //call this method to add nano chips
    public NanoChipAdapter(Context activity, ArrayList<String> listModels) {
        context = activity;
        response = listModels;
        response.add(EXTRA_EMPTY_CHIP_VALUE);
    }

    @NonNull
    @Override
    public NanoChipAdapter.ItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.nanochip_adapter_layout, parent, false);
        return new NanoChipAdapter.ItemRowHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull final NanoChipAdapter.ItemRowHolder holder, final int position) {
        int nsize = response.size() - 1;

        if (response.size() >= 1) {
            holder.readOnlyLayout.setVisibility(View.VISIBLE);
            holder.editableLayout.setVisibility(View.GONE);
            holder.chipTextView.setText(response.get(position));

            if (response.get(position).equalsIgnoreCase(EXTRA_EMPTY_CHIP_VALUE)) {
                holder.readOnlyLayout.setVisibility(View.GONE);
                holder.editableLayout.setVisibility(View.VISIBLE);
            }

            if (nsize == position) {
                holder.editableLayout.setVisibility(View.VISIBLE);
            }
        }

        holder.cancelChip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                response.remove(holder.chipTextView.getText().toString());
                if (response.size() == 0) {
                    response.add(EXTRA_EMPTY_CHIP_VALUE);
                    notifyDataSetChanged();
                } else {
                    int nsize = response.size() - 1;
                    if (nsize == position) {
                        holder.editableLayout.setVisibility(View.VISIBLE);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, response.size());
                    } else
                        notifyDataSetChanged();
                }
            }
        });

        holder.chipEditText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    if (holder.chipEditText.getText().toString().trim().isEmpty()) {
                        holder.chipEditText.setError("Empty");
                        holder.chipEditText.requestFocus();
                    } else {
                        response.add(holder.chipEditText.getText().toString());
                        response.remove(EXTRA_EMPTY_CHIP_VALUE);
                        holder.chipEditText.setText("");
                        notifyDataSetChanged();
                        return true;
                    }
                }
                return false;
            }
        });
    }

    //below code to create unique item in recyclerView
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return response.size();
    }

    public static ArrayList<String> getChipValues() {
        return response;
    }

    class ItemRowHolder extends RecyclerView.ViewHolder {
        TextView chipTextView;
        AutoCompleteTextView chipEditText;
        ImageView cancelChip;
        RelativeLayout editableLayout, readOnlyLayout;

        public ItemRowHolder(View itemView) {
            super(itemView);
            this.chipTextView = itemView.findViewById(R.id.custom_chip_textview);
            this.chipEditText = itemView.findViewById(R.id.custom_chip_edittext);
            this.cancelChip = itemView.findViewById(R.id.custom_chip_cancel);
            this.editableLayout = itemView.findViewById(R.id.custom_chip_editable_layout);
            this.readOnlyLayout = itemView.findViewById(R.id.custom_chip_readonly_layout);
        }
    }
}
