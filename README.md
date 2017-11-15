# Contact Application

Coding challenge consisting in a contact list, with the option of generate a random user and show the details of each one.

The architecture followed the MVVM architecture and SOLID principles, all the code is well organized and decoupled, it includes testing, use of the latest material design available, and the most popular and efficient android libraries at this moment.

This code includes the next libraries:

# Material Design libraries
    RecyclerView
    CardView
    Bootstrap
    Picasso
    Sparkbutton
    Circularimageview
    
# Dependency injection, decoupling

    Dagger2
    Butterknife
    IcePick

# Backend

    DB Debug
    OKHttp3
    GSON
    Retrofit
    RxJava
    Green DAO
    Firebase
    Authentication with facebook

# User statistics

    Firebase push notifications
    Flurry
    Answers
    Crashlytics

# Testing

    Mockito
    JUnit
    Espresso
    
    
    
# Objective: 
Create an Android Contacts application using the following libraries:
- Dagger
- RxJava
- Firebase Auth
- Firebase(Digits 2FA)
- Push notifications (Firebase)
- MVVM
- Databinding
- Retrofit
- Junit (Unit Testing)
- Mockito (Unit Testing)
- JaCoCo

Architecture: MVVM

Requirements: 

The application will allow a user to login with the Authentication.

The application will allow a user fetch a random person using the randomuser.me API service by doing a network call. 

Send a push notification saying that login was successful 

Login screen:
The first screen the user should see containing the Facebook Login button.
Then it should ask for 2FA

Homescreen:
Once the information is ready, it would present it to the user including information but not limited to the person's full name, address, email, profile picture.

In this same screen the user can decide to fetch a new user or save it locally into a SQLite database.

While in the homescreen a user can click a button to start another activity and browse a list of the locally stored people.

Contact Records list screen:
If the database is empty then it should display a label that states "There are no contact records stored."
Otherwise, it should display the list of users using a Linear RecyclerView and shows each contact as a card (CardView), showing just a thumbnail of the picture and the contact's name.
When a user taps on a card, it should open a Contact Detail screen that shows the selectec contact's information.

Since we are senior developers and professional consultants, we value high quality in code, so make sure your code is presentable before any commit is made, and provide at least one Unit Test per ViewModel and at least one UI Test with Espresso. 

Deliverables: 

The GitHub link to the repositiory hosting this application and that clearly shows atomic commits relevant to each story being implemented. 

Communication expectations: 
At the beginning and end of every day you should update your project's Skype group chat by filling the below template.
Should you get stuck or have any doubts, request for clarification/assistance in the project chat group as well, ideally if half an hour has gone by and you haven't made any progress.

