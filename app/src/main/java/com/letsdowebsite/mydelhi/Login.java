package com.letsdowebsite.mydelhi;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {
    TextView textStatus;
    TextView button;

    Fragment fragment;
    ImageView imageView4;
    private TextView email;
    private TextView gender;
    private TextView facebookName;
    private CallbackManager callbackManager;
    LoginButton fbloginButton;
    //ImageView imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        FacebookSdk.sdkInitialize(Login.this);

        setContentView( R.layout.activity_login );
        //  login_button =(Button) findViewById( R.id.login_button );

       /* initializeControls();
        loginWithFB();*/
        imageView4=(ImageView) findViewById( R.id.imageView4 );
        imageView4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( Login.this, dashboardActivity.class );
                startActivity( intent );

            }
        } );
        fbloginButton = (LoginButton) findViewById(R.id.login_button);


        //facebook callback
        fbloginButton.setReadPermissions("email");
        callbackManager = CallbackManager.Factory.create();
        fbloginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(
                                    JSONObject object,
                                    GraphResponse response) {
                                // Application code
                                Log.v("LoginActivity", response.toString());
                                String name = null, email = null, id = null, link = null;
                                try {
                                    JSONObject data = response.getJSONObject();
                                    email = data.getString("email");
                                    name = data.getString("name");
                                    id = data.getString("id");
                                    link = data.getString("link");
                                    link = link.replace("https://www.facebook.com/app_scoped_user_id/", "");
                                    link = link.replace("/", "");
                                    Log.e("profilelink", "" + link);
                                    link = "graph.facebook.com/" + link + "/picture?height=500";
                                    MyPreferences.getActiveInstance(Login.this).setEmailId(email);
                                    MyPreferences.getActiveInstance(Login.this).setfacebookimage(link);
                                    Intent intent = new Intent( Login.this, dashboardActivity.class );
                                    startActivity( intent );
                                } catch (JSONException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender, birthday,link");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {

            }
            @Override
            public void onError(FacebookException error) {
                // TODO Auto-generated method stub

            }
        });


    }
}