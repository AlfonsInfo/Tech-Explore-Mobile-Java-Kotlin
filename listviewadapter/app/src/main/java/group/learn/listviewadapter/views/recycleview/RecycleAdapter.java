package group.learn.listviewadapter.views.recycleview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import group.learn.listviewadapter.R;
import group.learn.listviewadapter.data.Item;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder>  {

    private final List<Item> items;

    public ItemClickListener clickListener;

    public void setClickListener(ItemClickListener listener){
        this.clickListener = listener;
    }





    public RecycleAdapter(List<Item> items) {
        this.items = items;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        //responsible for creating new holders for your items
        Log.i("Debug", "onCreateViewHolder:");
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.recycle_layout, parent , false);
        //not attached, attached later
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        //responsible binding data from data set to the views within the view holder
        Log.i("Debug", "onBindViewHolder: ");
        Item item = items.get(position);
        holder.title.setText(item.getItemName());
        holder.description.setText(item.getItemDesc());
        holder.imageView.setImageResource(item.getItemImg());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        TextView title;
        TextView description;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.recycle_imageview);
            title = itemView.findViewById(R.id.recycle_title);
            description = itemView.findViewById(R.id.recycle_description);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(clickListener != null){
                clickListener.onClick(v, getAdapterPosition());
            }
        }
    }
}
