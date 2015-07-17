package com.xaviermaximin.sargawatch;

import android.app.Application;

import com.bugsnag.android.Bugsnag;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;
import com.parse.ParseCrashReporting;

/**
 * Created by xavier on 14/07/2015.
 */
public class SargaWatchApplication  extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        // third party service to capture exceptions
        Bugsnag.init(this);


        // Initialize Crash Reporting.
        ParseCrashReporting.enable(this);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(this);


        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}

