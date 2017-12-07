package com.digitalflow.Kwanzaa;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.digitalflow.Kwanzaa360.R;

import java.util.List;

import static android.content.ContentValues.TAG;


public class CustomPagerAdapter extends PagerAdapter {
    private Context context;
    private List<KwanzaaDay> listofkwanzaadays;
    private LayoutInflater mLayoutInflater;

    CustomPagerAdapter(Context context, List<KwanzaaDay> listofkwanzaadays) {
        this.context = context;
        this.listofkwanzaadays = listofkwanzaadays;
        this.mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {

        return listofkwanzaadays.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.i(TAG, "Instantiate for position " + position + " [ item " + (position + 1) + " ]");
        View Itemview = mLayoutInflater.inflate(R.layout.activity_viewpager_item, container, false);
        TextView tvEnglish = Itemview.findViewById(R.id.viewPagerTextItemEnglish);
        TextView tvSwahili = Itemview.findViewById(R.id.viewPagerTextItemSwahili);
        TextView tvDescription = Itemview.findViewById(R.id.viewPagerTextDescription);
        ImageView imageView = Itemview.findViewById(R.id.viewPagerImageItem);
        ImageView ivBreadCrumb = Itemview.findViewById(R.id.imageviewbreadcrumb);
        KwanzaaDay kwanzaaDay = listofkwanzaadays.get(position);
        tvEnglish.setText(kwanzaaDay.EnglishName);
        tvSwahili.setText(kwanzaaDay.SwahiliName);
        tvDescription.setText(kwanzaaDay.ShortExplanation);
        imageView.setImageResource(kwanzaaDay.ImageId);
        ivBreadCrumb.setImageResource(kwanzaaDay.BreadCrumb);
        container.addView(Itemview);
        return Itemview;


    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.i(TAG, "Destroy item at position " + position + " [ item " + (position + 1) + " ]");
        container.removeView((ConstraintLayout) object);

    }
}
