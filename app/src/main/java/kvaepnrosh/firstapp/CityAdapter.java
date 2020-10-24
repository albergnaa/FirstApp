package kvaepnrosh.firstapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityHolder> implements Constants{

    private final static int RESULT_OK = 1;

    private List<String> cityList;
    private Context ctx;

    public CityAdapter(List<String> cityList, Context ctx) {
        this.cityList = cityList;
        this.ctx = ctx;
    }

    public void setItems() {
        cityList.addAll(cityList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        cityList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CityHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.city_item_view, viewGroup, false);
        return new CityHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityHolder cityHolder, int i) {
        cityHolder.bind(cityList.get(i));
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    class CityHolder extends RecyclerView.ViewHolder {

        private TextView cityItemTextView;
        private TextView dataItemTextView;
        private TextView temperatureItemTextView;

        public CityHolder(@NonNull final View itemView) {
            super(itemView);
            cityItemTextView = itemView.findViewById(R.id.cityItemTextView);
            dataItemTextView = itemView.findViewById(R.id.dataItemTextView);
            temperatureItemTextView = itemView.findViewById(R.id.temperatureItemTextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String city = cityList.get(getAdapterPosition());
                    Intent intentResult = new Intent();
                    intentResult.putExtra(CITY_NAME, city);
                    ((Activity)v.getContext()).setResult(RESULT_OK, intentResult);
                    ((Activity)v.getContext()).finish();

                }
            });
        }

        //реализовать привязку местного времени по названию города
        //+ температура
        public void bind(String city) {
            cityItemTextView.setText(city);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            dataItemTextView.setText(sdf.format(Calendar.getInstance().getTime()));
            temperatureItemTextView.setText("13");
        }


    }
}
