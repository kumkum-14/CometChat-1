package com.example.cometchatdemo1;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.ComponentActivity;

import com.cometchat.chat.core.CometChat;
import com.cometchat.chat.exceptions.CometChatException;
import com.cometchat.chat.models.User;
import com.cometchat.chatuikit.shared.cometchatuikit.CometChatUIKit;
import com.cometchat.chatuikit.shared.cometchatuikit.UIKitSettings;

public class MainActivity extends ComponentActivity {

    private static final String TAG = "MainActivity";

    private final String appID = "APP ID"; // Replace with your App ID
    private final String region = "REGION"; // Replace with your App Region
    private final String authKey = "AUTH KEY"; // Replace with your Auth Key

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getWindow().setDecorFitsSystemWindows(false);
            // Equivalent to enableEdgeToEdge()
        }


        UIKitSettings uiKitSettings = new UIKitSettings.UIKitSettingsBuilder()
                .setRegion(region)
                .setAppId(appID)
                .setAuthKey(authKey)
                .subscribePresenceForAllUsers()
                .build();

        CometChatUIKit.init(this, uiKitSettings, new CometChat.CallbackListener<String>() {
            @Override
            public void onSuccess(String success) {
                Log.d(TAG, "Initialization completed successfully");
                loginUser();
            }

            @Override
            public void onError(CometChatException e) {
                Log.e(TAG, "Initialization failed: " + (e != null ? e.getMessage() : "Unknown error"));
            }
        });
    }

    private void loginUser() {
        CometChatUIKit.login("cometchat-uid-1", new CometChat.CallbackListener<User>() {
            @Override
            public void onSuccess(User user) {
                Log.d(TAG, "Login successful for user: " + user.getUid());

                // Launch Conversation List + Message View
                startActivity(new Intent(MainActivity.this, ConversationActivity.class));
                finish();
            }

            @Override
            public void onError(CometChatException e) {
                Log.e("Login", "Login failed: " + (e != null ? e.getMessage() : "Unknown error"));
            }
        });
    }

}
