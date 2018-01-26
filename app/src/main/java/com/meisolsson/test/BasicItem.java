package com.meisolsson.test;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.xwray.groupie.Item;

public class BasicItem extends Item<BasicItem.ViewHolder> {

    public final String text;

    public BasicItem(long id, String text) {
        super(id);
        this.text = text;
    }

    @Override
    public void bind(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.text.setText(text);
    }

    @Override
    public int getLayout() {
        return R.layout.basic_item;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BasicItem) {
            return ((BasicItem) obj).text.equals(text);
        }
        return super.equals(obj);
    }

    @NonNull
    @Override
    public ViewHolder createViewHolder(@NonNull View itemView) {
        return new ViewHolder(itemView);
    }

    class ViewHolder extends com.xwray.groupie.ViewHolder {

        TextView text;

        ViewHolder(@NonNull View rootView) {
            super(rootView);
            text = rootView.findViewById(android.R.id.text1);
        }
    }
}
