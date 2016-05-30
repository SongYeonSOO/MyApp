package com.estsoft.myapp.ui.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.estsoft.android.network.SafeAsyncTask;
import com.estsoft.myapp.R;
import com.estsoft.myapp.core.domain.User;
import com.estsoft.myapp.core.service.UserService;

import java.util.List;

public class UserListFragment extends ListFragment {

    private UserListAdapter userListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        userListAdapter = new UserListAdapter( getActivity() );
        setListAdapter( userListAdapter );

        return inflater.inflate( R.layout.fragment_user_list, container, false );
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new FetchUserListTask().execute();
    }

    private class FetchUserListTask extends SafeAsyncTask<List<User>> {
        @Override
        public List<User> call() throws Exception {
            return new UserService().fetchUserList();
        }

        @Override
        protected void onException(Exception e) throws RuntimeException {
            super.onException(e);
            Log.d( "----->", e.toString() );
        }

        @Override
        protected void onSuccess(List<User> users) throws Exception {
            if( users.size() == 0 ) {
                return;
            }
            userListAdapter.add( users );
        }
    }
}
