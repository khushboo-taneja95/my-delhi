package com.letsdowebsite.mydelhi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    ImageView profileImageView;
    TextView profileInfoTextView;
    CallbackManager callbackManager;
    FacebookCallback<LoginResult> facebookCallback;
    ProfileTracker profileTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Initialize Facebook SDK
        FacebookSdk.sdkInitialize(getApplicationContext());

        //Initialize the CallbackManager using the
        // CallbackManager.Factory.create() method to
        // create a new instance of it.
        callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_main);

        //Initialize the ImageView and TextView
        profileImageView = (ImageView) findViewById(R.id.profile_image);
        profileInfoTextView = (TextView) findViewById(R.id.profile_info_textview);

        //Initialize the FacebookCallback and then override its methods
        // for performing actions.
        facebookCallback = new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                //This code will be performed when a user is
                // successfully logged in.
                Log.d(TAG, "FacebookCallback was Successful");
            }

            @Override
            public void onCancel() {
                //This code will be performed when a user
                // login is cancelled.
                Log.d(TAG, "FacebookCallback Cancelled");
            }

            @Override
            public void onError(FacebookException e) {
                //This code will be performed when a users login
                // attempt gets errors.
                Log.d(TAG, "FacebookCallback had Errors with n" + e);
            }
        };

        //Initialize loginButton and register the
        // CallbackManager and FacebookCallback
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.registerCallback(callbackManager,facebookCallback);

        //Initialize the ProfileTracker and override its
        // onCurrentProfileChanged(...) method.
        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {
                //Whenever the user profile is changed,
                //this method will be called.
                if (newProfile == null) {
                    profileImageView.setImageResource(R.drawable.com_facebook_profile_picture_blank_square);
                    profileInfoTextView.setText("");
                }else{
                    setUpImageAndInfo(newProfile);
                }
            }
        };
        profileTracker.startTracking();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Profile userProfile = Profile.getCurrentProfile();
        if (userProfile != null){
            setUpImageAndInfo(userProfile);
        }else{
            Log.d(TAG,"Profile is Null");
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        profileTracker.stopTracking();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //When the login  button is clicked and user logs in.
        // After that, onActivityResult method is called
        callbackManager.onActivityResult(requestCode, resultCode, data);

    }

    public void setUpImageAndInfo(Profile userProfile) {
        //This method will fill up the ImageView and TextView
        // that we initialized before.
        final String userInfo = "<u>First Name:</u> " + userProfile.getFirstName() +
                "<br/><u>Last Name:</u> " + userProfile.getLastName() +
                "<br/><u>User Id:</u> " + userProfile.getId() +
                "<br/><u>Profile Link:</u> " + userProfile.getLinkUri().toString();
        profileInfoTextView.setText(Html.fromHtml(userInfo));

        //I am using the Picasso library to download the image
        // from URL and then load it to the ImageView.
        Picasso.with(this)
                .load("https://graph.facebook.com/" + userProfile.getId().toString() + "/picture?type=large")
                .into(profileImageView);
    }
}
