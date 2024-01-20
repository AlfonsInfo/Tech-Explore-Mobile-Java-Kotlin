package group.learn.listviewadapter.views.gridview;

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
import group.learn.listviewadapter.data.Shape;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GridAdapter extends ArrayAdapter<Shape> {

    //Constructor
    public GridAdapter(Context context, List<Shape> shapes) {
        super(context, R.layout.grid_item_layout, shapes);
    }

    //Get View
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //planet object for the current position
        Shape shape = getItem(position);
        CreateAndRecycleView result = getCreateAndRecycleView(convertView, parent);
        setValueOnView(shape, result.viewHolder());
        return result.resultView();
    }

    @NotNull
    private CreateAndRecycleView getCreateAndRecycleView(@org.jetbrains.annotations.Nullable View convertView, @NotNull ViewGroup parent) {
        ViewHolder viewHolder;
        final View resultView;

        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.grid_item_layout,
                    parent,
                    false);

            //Finding View
            viewHolder.title =  convertView.findViewById(R.id.textview);
            viewHolder.image = convertView.findViewById(R.id.imageView);

            resultView = convertView;
            convertView.setTag(viewHolder);
        }else{
            //recycle view
            viewHolder = (ViewHolder) convertView.getTag();
            resultView = convertView;
        }
        return new CreateAndRecycleView(viewHolder, resultView);
    }

    private record CreateAndRecycleView(ViewHolder viewHolder, View resultView) {
    }

    private static void setValueOnView(Shape shape, ViewHolder viewHolder) {
        if(shape != null){
            viewHolder.title.setText(shape.getShapeName());
            viewHolder.image.setImageResource(shape.getShapeImg());
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class ViewHolder{
        private ImageView image;
        private TextView title;
    }
}
