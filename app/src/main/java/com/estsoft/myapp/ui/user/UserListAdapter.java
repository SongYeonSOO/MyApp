package com.estsoft.myapp.ui.user;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.estsoft.myapp.R;
import com.estsoft.myapp.core.domain.User;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by kickscar on 2016-05-31.
 */
public class UserListAdapter extends ArrayAdapter<User> {

    LayoutInflater layoutInflater;
    private DisplayImageOptions displayImageOption;

    public UserListAdapter(Context context) {
        super(context, R.layout.row_user_list);

        layoutInflater = LayoutInflater.from(context);

        displayImageOption = new DisplayImageOptions.Builder()
                // .showImageOnLoading( R.drawable.ic_default_profile )// resource or drawable
                .showImageForEmptyUri( R.drawable.ic_default_profile )// resource or drawable
                .showImageOnFail( R.drawable.ic_default_profile )// resource or drawable
                //.resetViewBeforeLoading( false )// default
                .delayBeforeLoading( 0 )
                //.cacheInMemory( false )// default
                .cacheOnDisc( true )// false is default
                //.preProcessor(...)
                //.postProcessor(...)
                //.extraForDownloader(...)
                //.considerExifParams( false )// default
                //.imageScaleType( ImageScaleType.IN_SAMPLE_POWER_OF_2 )// default
                //.bitmapConfig( Bitmap.Config.ARGB_8888 )// default
                //.decodingOptions(...)
                //.displayer( new SimpleBitmapDisplayer() )// default
                //.handler( new Handler() )// default
                .build();

    }

    public void add(List<User> listUser) {

        if (listUser == null) {
            return;
        }

        for (User user : listUser) {
            add(user);
        }

         /* ArrayAdapter의 add를 호출하게 되면 notifyDataSetChanged() 생략 */
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent ) {
        View view = convertView;
        if( view == null ) {
            view = layoutInflater.inflate( R.layout.row_user_list, parent, false );
        }

        User user = getItem( position );

        ImageLoader.getInstance().displayImage( user.getProfilePic(), (ImageView)view.findViewById( R.id.profile ), displayImageOption );
        ( (TextView) view.findViewById( R.id.name ) ).setText( user.getName() );

        return view;
    }

}
