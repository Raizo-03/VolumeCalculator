package com.example.volumecalculatorapp;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

//This class will be responsible for creating
//the view for each item and binding data to it.

public class MyCustomAdapter extends ArrayAdapter<Shape> {
        private ArrayList<Shape> shapes;
        Context context;

    public MyCustomAdapter(ArrayList<Shape> shapes, Context context) {
        super(context, R.layout.grid_item_layout, shapes);
        this.shapes = shapes;
        this.context = context;
    }


    //ViewHolder : Used to cache the references of the views within an item layout
    private static class MyViewHolder{
        TextView shapeName;
        ImageView shapeImage;
    }

    //GetView : Used to create and return a view for a specific item in Grid

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //1. int position = get the position of the item
        Shape shapes = getItem(position);

        //2. Inflating the layout
        MyViewHolder holder;

        if(convertView == null){
            holder = new MyViewHolder();

            // no view went off the screen --> Create a new view
            //Layout inflater = inflates the views/ populates the views with items from data sources
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());

            convertView = layoutInflater.inflate(R.layout.grid_item_layout, parent, false);

            //Finding the views
            holder.shapeName = (TextView) convertView.findViewById(R.id.textView);
            holder.shapeImage = (ImageView) convertView.findViewById(R.id.imageView);

            convertView.setTag(holder);
        }else{
            // a view went off the screen --> Reuse the view
            holder = (MyViewHolder) convertView.getTag();


        }
        //Getting the data from the model class (Shape)
        holder.shapeName.setText(shapes.getShapeName());
        holder.shapeImage.setImageResource(shapes.getShapeImg());

        return convertView;
    }


}
