package kvaepnrosh.firstapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;


public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityHolder> {

    private List<String> cityList = new ArrayList<>();

    public void setItems(Collection<String> cities) {
        cityList.addAll(cities);
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

        public CityHolder(@NonNull View itemView) {
            super(itemView);
            cityItemTextView = itemView.findViewById(R.id.cityItemTextView);
            dataItemTextView = itemView.findViewById(R.id.dataItemTextView);
            temperatureItemTextView = itemView.findViewById(R.id.temperatureItemTextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //переход к основному окну
                    int positionIndex = getAdapterPosition();
                    Toast.makeText(v.getContext(), String.valueOf(positionIndex), Toast.LENGTH_SHORT).show();
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
