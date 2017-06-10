package msoff.tajikcuisine;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<DataModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView grid_name;
        TextView sub_grid_name;
        ImageView grid_image;
        TextView timing;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.grid_name = (TextView) itemView.findViewById(R.id.grid_text);
            this.sub_grid_name = (TextView) itemView.findViewById(R.id.sub_grid_text);
            this.grid_image = (ImageView) itemView.findViewById(R.id.grid_image);
            this.timing = (TextView)itemView.findViewById(R.id.timings);
        }
    }

    public CustomAdapter(ArrayList<DataModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cat_card_layout, parent, false);

        view.setOnClickListener(Category.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView grid_name = holder.grid_name;
        TextView sub_grid_name = holder.sub_grid_name;
        ImageView grid_image = holder.grid_image;
        TextView timing = holder.timing;

        grid_name.setText(dataSet.get(listPosition).getName());
        sub_grid_name.setText(dataSet.get(listPosition).getSubName());
        grid_image.setImageResource(dataSet.get(listPosition).getImage());
        timing.setText(dataSet.get(listPosition).getTime());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}