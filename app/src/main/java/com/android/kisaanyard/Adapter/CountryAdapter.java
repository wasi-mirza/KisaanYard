package com.android.kisaanyard.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.kisaanyard.Model.CountryInfor;
import com.android.kisaanyard.R;

import java.util.List;

public class CountryAdapter extends ArrayAdapter<CountryInfor>

    {

        private Activity activity;

 public CountryAdapter(Activity activity, int resource, int textViewResourceId,
        List<CountryInfor> countries){
        super(activity, resource, textViewResourceId, countries);
        this.activity = activity;

    }

        @Override
        public View getView (int position, View convertView, ViewGroup parent){

        ViewHolder holder = null;
        LayoutInflater inflater =
                (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        // If holder not exist then locate all view from UI file.
        if (convertView == null) {
            // inflate UI from XML file
            convertView = inflater.inflate(R.layout.item_listview, parent, false);
            // get all UI view
            holder = new ViewHolder(convertView);
            // set tag for holder
            convertView.setTag(holder);
        } else {
            // if holder created, get tag from view
            holder = (ViewHolder) convertView.getTag();
        }

        CountryInfor country = getItem(position);

        holder.countryName.setText(country.getName());
        holder.countryName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.maize, 0, 0, 0);

        return convertView;
    }

        private static class ViewHolder {
            private TextView countryName;

            public ViewHolder(View v) {
                countryName = (TextView) v.findViewById(R.id.country_name);
            }
        }
    }

