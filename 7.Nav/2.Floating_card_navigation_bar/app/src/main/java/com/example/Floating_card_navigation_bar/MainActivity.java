package com.example.Floating_card_navigation_bar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ramotion.expandingcollection.ECCardContentListItemAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        public class CardListItemAdapter extends ECCardContentListItemAdapter<String> {

            public CardListItemAdapter(@NonNull Context context, @NonNull List<String> objects) {
                super(context, R.layout.list_item, objects);
            }

            @SuppressLint("InflateParams")
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                ViewHolder viewHolder;
                View rowView = convertView;

                if (rowView == null) {
                    LayoutInflater inflater = LayoutInflater.from(getContext());
                    rowView = inflater.inflate(R.layout.list_item, null);
                    viewHolder = new ViewHolder();
                    viewHolder.itemText = (TextView) rowView.findViewById(R.id.list_item_text);
                    rowView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) rowView.getTag();
                }

                String item = getItem(position);
                if (item != null) {
                    viewHolder.itemText.setText(item);
                }
                return rowView;
            }

            static class ViewHolder {
                TextView itemText;
            }

        }
    }
}