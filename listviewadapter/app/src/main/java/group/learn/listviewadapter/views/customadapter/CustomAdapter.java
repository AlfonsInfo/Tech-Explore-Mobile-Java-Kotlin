package group.learn.listviewadapter.views.customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import group.learn.listviewadapter.R;
import group.learn.listviewadapter.data.Music;

import java.util.List;
import java.util.Objects;

public class CustomAdapter <T> extends BaseAdapter {

    private final Context context;
    private final List<T> data;

    public CustomAdapter(Context context, List<T> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(Objects.isNull(convertView)){
           convertView =  LayoutInflater.from(context)
                    .inflate(R.layout.custom_list_item, parent, false);

           holder = new ViewHolder();
           holder.title = convertView.findViewById(R.id.title);
           holder.details = convertView.findViewById(R.id.details);
           convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        T currentItem = data.get(position);
        if(currentItem instanceof String){
            holder.title.setText((CharSequence) currentItem);
        }

        return convertView;
    }


    static class ViewHolder{
        TextView title ;
        TextView details;
    }
}
