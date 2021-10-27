package edu.byuh.cis.cs203.numberedsquares;

import android.app.Activity;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * created by tylajeffs
 */

public class MainActivity extends Activity
{

    //fields
    private GameView gv;



    /**
     * It all starts here
     * @param savedInstanceState - passed in by OS. Ignore for now.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //create new view
        gv = new GameView(this);
        setContentView(gv);


    }


    @Override
    protected void onResume()
    {
        super.onResume();

        gv.resume();

    }


    @Override
    protected void onPause()
    {
        super.onPause();

        gv.pause();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        gv.shutdownCleanup();
    }

}
