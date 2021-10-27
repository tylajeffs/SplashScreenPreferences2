package edu.byuh.cis.cs203.numberedsquares;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;
import android.preference.ListPreference;
import android.view.MotionEvent;
import android.widget.Switch;

//import androidx.preference.ListPreference;
import androidx.preference.SeekBarPreference;

import java.util.List;

public class SettingsActivity extends PreferenceActivity
{



    /**
     * takes care of all initialization stuff
     * @param b bundle (required)
     */
    @Override
    public void onCreate(Bundle b)
    {
        super.onCreate(b);

        //create preferences screen
        PreferenceScreen ps = getPreferenceManager().createPreferenceScreen(this);


        //create switch setting for music
        SwitchPreference music = new SwitchPreference(this);
        //set music title and words
        music.setTitle("Background Music");
        music.setSummaryOn("on");
        music.setSummaryOff("off");
        //default the music to be on
        music.setDefaultValue(true);
        //set key
        music.setKey("music setting");





        //create switch setting for background color
        SwitchPreference backgroundColor = new SwitchPreference(this);
        //set music title and words
        backgroundColor.setTitle("Background Color");
        backgroundColor.setSummaryOn("light");
        backgroundColor.setSummaryOff("dark");
        //default the music to be on
        backgroundColor.setDefaultValue(true);
        //set key
        backgroundColor.setKey("background color");





        //create setting for square speed
        ListPreference speed = new ListPreference(this);
        //set title and words
        speed.setTitle("Square Speed");
        speed.setSummary("How fast will the squares move?");
        //set key
        speed.setKey("speed");
        //set the options
        String[] speedOptions = {"fast" ,"medium", "slow"};
        String[] speeds = {"5", "3", "1"};
        speed.setEntries(speedOptions);
        speed.setEntryValues(speeds);
        //set default
        speed.setDefaultValue("3");




        //create setting for square size
        ListPreference squareSize = new ListPreference(this);
        //set title and words
        squareSize.setTitle("Square Size");
        squareSize.setSummary("How large will the squares be?");
        //set key
        squareSize.setKey("square size");
        //set the options
        String[] sizes = {"large" ,"medium", "small"};
        String[] sizeValues = {"5", "7", "8"};
        squareSize.setEntries(sizes);
        squareSize.setEntryValues(sizeValues);
        //set default
        squareSize.setDefaultValue("3");






        //add the preferences to the screen
        ps.addPreference(music);
        ps.addPreference(backgroundColor);
        ps.addPreference(speed);
        ps.addPreference(squareSize);



        //set the preference screen
        setPreferenceScreen(ps);




    }





    /**
     * overridden touch event method - gets called when user touches screen
     *
     * @param m - motion event (required)
     * @return always returns true
     */
    @Override
    public boolean onTouchEvent(MotionEvent m)
    {
        //if user touches screen, start game
        if(m.getAction() == MotionEvent.ACTION_DOWN)
        {

            //start the game (MainActivity)
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

            //kill the beginning page/activity
            finish();

        }

        //always returns true
        return true;
    }





    /**
     * facade method to return whether or not the music is on in settings
     * @param c context
     * @return returns true if the sound is on, false if it is off
     */
    public static boolean soundOn(Context c)
    {
        return PreferenceManager.getDefaultSharedPreferences(c).getBoolean("music setting",true);
    }


    /**
     * facade method to return whether or not the background should be light
     * @param c context
     * @return true if light, false if dark
     */
    public static boolean backgroundIsLight(Context c)
    {
        return PreferenceManager.getDefaultSharedPreferences(c).getBoolean("background color",true);
    }





    /**
     * facade method to return the speed the velocity should be multiplied by
     * @param c context
     * @return the speed
     */
    public static int getSpeed(Context c)
    {
        return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(c).getString("speed","3"));
    }


    /**
     * facade mehtod to return the size that the square should be
     * @param c context
     * @return the int that will be the size of the square
     */
    public static int getSquareSize(Context c)
    {
        return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(c).getString("square size","8"));
    }
}
