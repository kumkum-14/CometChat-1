Building an Android Chat App with CometChat UI Kit

Description

       This repository provides an Android sample app demonstrating how to integrate CometChat’s UI Kit for one-to-one and group chat functionality.
       
       The app features real-time messaging with session persistence, a compact interface combining conversations and messages on a single screen, and seamless navigation using Fragments or Jetpack Navigation. It is lightweight, responsive, and optimized for mobile devices.

Features

    -One-to-One & Group Chats
    -Real-Time Messaging with session persistence
    -Compact UI: Conversations and messages in a single screen
    -Seamless navigation using Fragments or Jetpack Navigation
    -Lightweight and responsive design

Getting Started
    
1. Create a CometChat Account

        -Visit the CometChat Dashboard:
            https://app.cometchat.com/signup
        -Register or log in to access the Dashboard.
3. Create an App on CometChat Dashboard

        -In the Dashboard, click + Add App.
        -Enter a name for your app and click Create App.
        -Navigate to Application → Credentials and copy the following values:
            App ID
            Auth Key
            Region
        -Store these values securely; you will reference them in your Android project configuration.

5. Install Dependencies

        -All dependency declarations and version catalogs are managed with Gradle.
        -Project-level Build Configuration
            Open build.gradle.kts to verify that mavenCentral() and the CometChat Maven repository are included under allprojects → repositories.
        -App-level Build Configuration
            Open app/build.gradle.kts and confirm the following dependencies:
                com.cometchat:chat-uikit-android (CometChat UI Kit)
                com.cometchat:calls-sdk-android (CometChat Calls SDK; optional if you want voice/video features)
        -For exact versions, refer to the version catalog in gradle/libs.versions.toml.
        -Sync Your Project
            In Android Studio, click Sync Now after making changes to Gradle files. This ensures the CometChat SDKs are downloaded.

6. Initialize CometChat UI Kit

        -Open the application class file app/src/main/java/…/MainActivity.kt.
        -Replace the placeholder values for App ID, Region, and Auth Key with the credentials you copied from the Dashboard.
        -Verify that CometChat.init(…) is invoked in the onCreate() method so the SDK initializes before any UI is rendered.

8. User Authentication

        -Open the main activity file app/src/main/java/…/MainActivity.kt.
        -Review the login logic, which calls CometChat.login(uid, authKey, …).
        -You can use pre-generated test UIDs (e.g., cometchat-uid-1, cometchat-uid-2) or create your own users via the Dashboard, the SDK, or the REST API.
        -Confirm that the Auth Key placeholder has been replaced with your own value.
        -Once login succeeds, the app navigates to ConversationActivity to display conversations.
   
10. Build the Chat Experience

-Conversation List & Message View Layout

    Inspect the layout files in app/src/main/res/layout/:
    activity_conversations.xml (Chat list overview)
    activity_message.xml(Single chat messages)

-Message Activity

    See app/src/main/java/com/example/cometchatdemo1/MessageActivity.java to understand how the CometChat UI Kit fragment is loaded.

-Key Components

    Chat Header: Displays user/group name, profile image, and status.
    Message List: Shows chat history and incoming messages.
    Message Composer: Allows users to send text, media, and reactions.

-Integration Steps

    i. Setup the conversation layout → activity_conversation.xml
    ii. Configure ConversationsActivity.kt → ConversationsActivity.kt
    iii. Set up message layouts (handled internally by the UI Kit)
    iv. Verify navigation between activities and fragments (implemented in MainActivity.java and ConversationActivity.java)

11. Customize Theme

        -To apply a global theme that matches CometChat’s styling, open app/src/main/res/values/themes.xml.
        -Ensure your root theme is set to inherit from CometChatTheme.DayNight:
            <style name="AppTheme" parent="CometChatTheme.DayNight" />
        -Open AndroidManifest.xml and confirm that <application> uses @style/AppTheme as its android:theme.

8. Run the App

        -Connect an Android device or start an emulator.
        -In Android Studio, click Run > Run ‘app’ or use the toolbar ▶ icon.
        -On the login screen, enter a valid CometChat UID (e.g., cometchat-uid-1) and tap Login.
        -The Conversation List → Message View interface should load.
        -Open a second instance or a separate device, log in with a different UID, and send a message to verify real-time delivery.

9. Troubleshooting

        -No Initialization: If the SDK does not initialize, verify that your App ID, Region, and Auth Key match those in the CometChat Dashboard.
        -Dependency Errors: If Gradle sync fails, confirm that gradle/libs.versions.toml includes the correct CometChat version references.
        -Login Fails: Ensure the UID you supply is registered in your CometChat app; create new users via the CometChat Dashboard or REST API if needed.

Repository Structure

    CometChat-1/
    ├── app/
    │   ├── src/
    │   │   ├── main/
    │   │   │   ├── java/com/example/cometchatdemo/
    │   │   │   │   ├── ConversationsActivity.kt
    │   │   │   │   ├── MainActivity.kt
    │   │   │   │   └── MessageActivity.kt
    │   │   │   ├── res/
    │   │   │   │   ├── layout/
    │   │   │   │   │   ├── activity_main.xml
    │   │   │   │   │   └── activity_message.xml
    │   │   │   │   │   └──activity_conversations.xml
    
    │   │   │   │   └── values/
    │   │   │   │       └── themes.xml
    │   │   │   └── AndroidManifest.xml
    │   │   └── build.gradle.kts
    │   └── build.gradle.kts
    ├── gradle/
    │   └── libs.versions.toml
    ├── build.gradle.kts
    ├── settings.gradle.kts
    └── README.md
        
Resources
        -CometChat Android UI Kit Docs (Getting Started)
        
        https://www.cometchat.com/docs/ui-kit/android/getting-started
        CometChat Android Conversation Guide
        https://www.cometchat.com/docs/ui-kit/android/android-conversation
