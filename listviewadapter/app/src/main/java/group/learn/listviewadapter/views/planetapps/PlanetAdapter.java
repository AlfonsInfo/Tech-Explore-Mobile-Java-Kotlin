package group.learn.listviewadapter.views.planetapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import group.learn.listviewadapter.R;
import group.learn.listviewadapter.data.Planet;
import java.util.List;

public class PlanetAdapter extends ArrayAdapter<Planet> {


    public PlanetAdapter(List<Planet> planets, Context context) {
        super(context, R.layout.planet_item, planets);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //planet object for the current position
        Planet planet = getItem(position);

        //layout inflate
        ViewHolder viewHolder;
        final View resultView;

        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.planet_item,
                    parent,
                    false);

            //Finding View
            viewHolder.planetName =  convertView.findViewById(R.id.txtTitle);
            viewHolder.details = convertView.findViewById(R.id.txtTitle2);
            viewHolder.planetImages =  convertView.findViewById(R.id.item_image);

            resultView = convertView;
            convertView.setTag(viewHolder);
        }else{
            //recycle view
            viewHolder = (ViewHolder) convertView.getTag();
            resultView = convertView;
        }

        if(planet != null){
            viewHolder.planetName.setText(planet.getPlanetName());
            viewHolder.details.setText(planet.getMoonCount());
            viewHolder.planetImages.setImageResource(planet.getPlanetImage());
        }



        return resultView;
    }

    private static class ViewHolder{
            TextView planetName;
            TextView details;
            ImageView planetImages;
    }
}


