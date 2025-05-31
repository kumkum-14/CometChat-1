CometChat Android Chat Tutorial: Conversation List + Message View

    Highlights:
     -One-to-One & Group Chats
     -Real-Time Messaging with session persistence
     -Compact UI – Conversations and messages in a single screen
     -Seamless navigation using Fragments or Jetpack Navigation
     -Lightweight and responsive, optimized for mobile devices

1. Create a CometChat Account

       -Visit https://app.cometchat.com/signup.
       -Register and login to CometChat's dashboard
2. Create App on CometChat Dashboard
   
        -Go to Dashboard
        -Click + Add App
        -Name your app and click Create App         
3. Get Credentials

       -Navigate to Application
       -Then select the Credentials section and copy these:
         App ID
         Auth Key
         Region
       You'll need them in your Android project.
4. Install Dependencies
    a. Add the CometChat Repository
        In your build.gradle (Project):

        allprojects {
            repositories {
                google()
                mavenCentral()
                maven { url 'https://dl.cloudsmith.io/public/cometchat/cometchat-pro-android/maven/' }
            }
        }
    b. Add the CometChat Dependency
      In build.gradle (App):
         
          dependencies {
              implementation(libs.cometchat.ui.kit)
          
              // (Optional) Include if using voice/video calling features
              implementation(libs.cometchat.calls.sdk)
          }
      Inside libs.versions.toml,
      
        [versions]
        cometchat-ui-kit = "5.0.2"
        cometchat-calls-sdk = "4.1.0"
    
        [libraries]
        cometchat-ui-kit = { module = "com.cometchat:chat-uikit-android", version.ref = "cometchat-ui-kit" }
        cometchat-calls-sdk = { module = "com.cometchat:calls-sdk-android", version.ref = "cometchat-calls-sdk" }  
5. Initialize CometChat UI Kit  

       -The UI Kit is initialized in `MainActivity.java` using `UIKitSettings`.
       -Initialization requires your `App ID`, `Region`, and `Auth Key`.
6. User Authentication

       -After initialization, the app logs in a user by their UID.
       -To authenticate a user in CometChat, you need the UID (unique user ID).
       -There are two main options for getting this UID:
        
       a. Pre-generated test users:
           cometchat-uid-1 
           cometchat-uid-2 
           cometchat-uid-3  
           cometchat-uid-4  
           cometchat-uid-5
   
       b. Or create users:
       create your own users via CometChat Dashboard,CometChat SDK method or via API.

       -Use the provided MainActivity code to initialize CometChat UI Kit and perform user login.
       -Replace appID, region, and authKey with your own credentials. 
7. Build the Chat Experience

       -Stitch the Components: Conversation + Message View
       -Key Components
            Chat Header : Displays user/group name, profile image, and status.
            Message List : Shows chat history and new messages.
            Message Composer : Allows users to send messages, media, and reactions.
       -Integration Steps:
           i.  Setup the conversation Layout
           ii. Setup the Conversation Activity
           iii.Setup the Messages Layout
           iv. Setup the MessageActivity      
8. Customise
    
           Set Up Global Theme
           -To customize component styling across your application in one place, you need to set up the CometChat Theme.
           -Use the CometChatTheme.DayNight style, which is built on Theme.MaterialComponents.DayNight.NoActionBar.
           -Apply the Theme
           -Set CometChatTheme.DayNight as the parent theme for your application in the themes.xml file.
     themes.xml
    
        <style name="YourAppParentTheme" parent="CometChatTheme.DayNight"/>
     AndroidManifest.xml   
    
           <application
            android:theme="@style/YourAppParentTheme"
            ...
            ...
        >
    
        </application>
   9. Run the app
