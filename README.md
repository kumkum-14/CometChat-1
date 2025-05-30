CometChat Android Chat Tutorial: Conversation List + Message View

    Highlights:
    -Compact UI – Single-screen layout for mobile; tap a conversation to open the message view.
    -One-to-One & Group Chats – Handle private and group conversations natively.
    -Session Persistence – Messages and read states sync across devices.
    -Real-Time Messaging – Seamless updates for both message view and conversation list.
    -Smooth Navigation – Intuitive stack-based flow using FragmentManager or Jetpack Navigation.
    -Lightweight & performant – Designed for mobile responsiveness and low memory footprint

1. Create a CometChat Account

       Go to https://app.cometchat.com/signup.
       Register on CometChat's dashboard
   
2. Create App on CometChat Dashboard

       After logging in, go to the CometChat Dashboard
       Click on + Add App     
       give your app a name.
       Click Create App.

3. Get Credentials

       Navigate to Application
       Then select the Credentials section and copy these:
         -App ID
         -Auth Key
         -Region
       You'll need them in your Android project.

4. Install Dependencies

    i. Add the CometChat Repository
        In your build.gradle (Project):

        allprojects {
            repositories {
                google()
                mavenCentral()
                maven { url 'https://dl.cloudsmith.io/public/cometchat/cometchat-pro-android/maven/' }
            }
        }
    ii. Add the CometChat Dependency
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

       The UI Kit is initialized in `MainActivity.java` using `UIKitSettings`.
       Initialization requires your `App ID`, `Region`, and `Auth Key`.
   
6. Authenticate the user

       After initialization, the app logs in a user by their UID.
       To authenticate a user in CometChat, you need the UID (unique user ID). There are two main options for getting this UID:
        
       1. Pre-generated test users:
           cometchat-uid-1 
           cometchat-uid-2 
           cometchat-uid-3  
           cometchat-uid-4  
           cometchat-uid-5
   
       2. Or create users:
       create your own users via CometChat Dashboard,CometChat SDK method or via API.

       Use the provided MainActivity code to initialize CometChat UI Kit and perform user login.
       Replace appID, region, and authKey with your own credentials.
       Use one of the pre-generated test UIDs or create your own users.
   
8. Build the Chat Experience

          Stitch the Components: Conversation + Message View
          Key Components
          -Chat Header : Displays user/group name, profile image, and status.
          -Message List : Shows chat history and new messages.
          -Message Composer : Allows users to send messages, media, and reactions.

           i.  Setup the conversation Layout
           ii. Setup the Conversation Activity
           iii.Setup the Messages Layout
           iv. Setup the MessageActivity
       
9. Run the App
    
10. Customise
    
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
