package dramaandcompany.dongyeon.assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by dylee on 2015-12-08.
 */
public class StoryListItemAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater;
    private int mLayout;

    private ArrayList<StoryItemInfo> mStoryListItem;

    public StoryListItemAdapter(Context context, int layout, ArrayList<StoryItemInfo> storylistitem) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = layout;
        mStoryListItem = storylistitem;
    }

    @Override
    public int getCount() {
        return mStoryListItem.size();
    }

    @Override
    public String getItem(int position) {
        return getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(mLayout, parent, false);
        }
        ImageView storyImage = (ImageView) convertView.findViewById(R.id.storyListItemImage);
        TextView storyTitle = (TextView) convertView.findViewById(R.id.storyListItemTitleText);
        TextView storyDate = (TextView) convertView.findViewById(R.id.storyListItemDate);

        return convertView;
    }
}
