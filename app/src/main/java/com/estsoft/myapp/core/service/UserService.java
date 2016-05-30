package com.estsoft.myapp.core.service;

import com.estsoft.android.network.JSONResult;
import com.estsoft.myapp.core.domain.User;
import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public List<User> fetchUserList() {

        String url = "http://192.168.0.3:8080/myapp-api/api/user/list";
        HttpRequest request = HttpRequest.get( url );

        request.contentType( HttpRequest.CONTENT_TYPE_JSON );
        request.accept( HttpRequest.CONTENT_TYPE_JSON );
        request.connectTimeout( 1000 );
        request.readTimeout( 3000 );

        int responseCode = request.code();
        if ( responseCode != HttpURLConnection.HTTP_OK  ) {
            /* 에러 처리 */
            return null;
        }

        JSONResultUserList result = null;

        try {
            result = fromJSON(request, JSONResultUserList.class);
        } catch( Exception ex) {
            ex.printStackTrace();
        }

        return result.getData();
    }

    public List<User> fetchUserMockList() {

        List<User> list = new ArrayList<User>();

        User user = new User();
        user.setId( 1L );
        user.setName( "안대혁" );
        user.setPhone( "010-4761-6934" );
        user.setEmail( "kickscar@gmail.com" );
        user.setProfilePic( "https://scontent.xx.fbcdn.net/v/t1.0-1/p160x160/936089_1019758748039064_7187347097932848216_n.jpg?oh=5642f471ad5fd56c7f1fcc57da155414&oe=57CBFBB2" );
        user.setStatus( 1 );
        list.add( user );

        user = new User();
        user.setId( 2L );
        user.setName( "홍마오" );
        user.setPhone( "010-4761-6934" );
        user.setEmail( "maohong@gmail.com" );
        user.setProfilePic( "https://scontent.xx.fbcdn.net/v/t1.0-1/c13.13.166.166/s160x160/562300_158663031006306_366519961_n.jpg?oh=c0cc8d2bbd3c32b410ae9efbef65fa50&oe=57DD538F" );
        user.setStatus( 1 );
        list.add( user );

        user = new User();
        user.setId( 3L );
        user.setName( "큰형님" );
        user.setPhone( "010-4761-6934" );
        user.setEmail( "bigbrother@gmail.com" );
        user.setProfilePic( "https://scontent.xx.fbcdn.net/v/t1.0-9/10407327_763440403771968_7237963528229249056_n.jpg?oh=b013f6908a979ca6f95e196352dacbb4&oe=57E5911B" );
        user.setStatus( 1 );
        list.add( user );

        user = new User();
        user.setId( 4L );
        user.setName( "김슬기" );
        user.setPhone( "010-4761-6934" );
        user.setEmail( "kimsmu@gmail.com" );
        user.setProfilePic( "https://scontent.xx.fbcdn.net/v/t1.0-9/993061_129033370635939_1916303504_n.jpg?oh=90fdb10ccb2b72970279252143994214&oe=57C4FC1B" );
        user.setStatus( 1 );
        list.add( user );

        user = new User();
        user.setId( 5L );
        user.setName( "김헐크" );
        user.setPhone( "010-4761-6934" );
        user.setEmail( "hulk@gmail.com" );
        user.setProfilePic( "https://scontent.xx.fbcdn.net/v/t1.0-1/c13.13.166.166/s160x160/562300_158663031006306_366519961_n.jpg?oh=c0cc8d2bbd3c32b410ae9efbef65fa50&oe=57DD538F" );
        user.setStatus( 1 );
        list.add( user );

        user = new User();
        user.setId( 6L );
        user.setName( "이윤임" );
        user.setPhone( "010-4761-6934" );
        user.setEmail( "yilee@gmail.com" );
        user.setProfilePic( "https://scontent.xx.fbcdn.net/v/t1.0-0/p526x296/558956_509556885826989_342898957_n.jpg?oh=7257652d590dd64560dc0d55933972b0&oe=57DC42D8g" );
        user.setStatus( 1 );
        list.add( user );

        user = new User();
        user.setId( 7L );
        user.setName( "홍네모" );
        user.setPhone( "010-4761-6934" );
        user.setEmail( "recthong@gmail.com" );
        user.setProfilePic( "https://scontent.xx.fbcdn.net/v/t1.0-9/1186118_146279165582758_1233784670_n.jpg?oh=1b583df1824869960964ff168f30705f&oe=57CF07BE" );
        user.setStatus( 1 );
        list.add( user );

        user = new User();
        user.setId( 8L );
        user.setName( "이우보" );
        user.setPhone( "010-4761-6934" );
        user.setEmail( "jingjing@gmail.com" );
        user.setProfilePic( "https://scontent.xx.fbcdn.net/v/t1.0-9/945025_125511240992884_1798446283_n.jpg?oh=c1c1ac824b1d2ccc08d34d1adb6fbe8d&oe=580E25AF" );
        user.setStatus( 1 );
        list.add( user );

        user = new User();
        user.setId( 9L );
        user.setName( "박빵" );
        user.setPhone( "010-4761-6934" );
        user.setEmail( "ppang@gmail.com" );
        user.setProfilePic( "https://scontent.xx.fbcdn.net/v/t1.0-9/12814426_1286138648067738_209971010977099459_n.jpg?oh=d6578ddf030ec9bc6a31252d68b8dc60&oe=57DE9FA4" );
        user.setStatus( 1 );
        list.add( user );

        user = new User();
        user.setId( 10L );
        user.setName( "짐모리슨" );
        user.setPhone( "010-4761-6934" );
        user.setEmail( "morison@gmail.com" );
        user.setProfilePic( "https://scontent.xx.fbcdn.net/v/t1.0-0/p526x296/11017819_767876689995006_5946805681565263893_n.jpg?oh=4430f1fbf7fa2411ca9f9072c9d71d99&oe=580DB060" );
        user.setStatus( 1 );
        list.add( user );

        return list;
    }

    protected <V> V fromJSON( HttpRequest request, Class<V> target ) throws IOException {

        Gson gson = new GsonBuilder().create();

        Reader reader = request.bufferedReader();
        V v = gson.fromJson( reader, target );
        reader.close();

        return v;
    }


    private class JSONResultUserList  extends JSONResult<List<User>> {}

}
