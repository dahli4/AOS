package com.pipa.android17;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListViewAdapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<ListItem> listViewItemList = new ArrayList<ListItem>() ;

    // ListViewAdapter의 생성자
    public CustomListViewAdapter() {

    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View curView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (curView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            curView = inflater.inflate(R.layout.layout_list_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView ivICon = (ImageView) curView.findViewById(R.id.ivICon) ;
        TextView tvTitle = (TextView) curView.findViewById(R.id.tvTitle) ;
        TextView tvDescription = (TextView) curView.findViewById(R.id.tvDescription) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ListItem itemData = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        ivICon.setImageDrawable(itemData.getIcon());
        tvTitle.setText(itemData.getTitle());
        tvDescription.setText(itemData.getDescription());

        return curView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(Drawable icon, String title, String description ) {
        ListItem item = new ListItem();

        item.setIcon(icon);
        item.setTitle(title);
        item.setDescription(description);

        listViewItemList.add(item);
        this.notifyDataSetChanged();
    }
}
