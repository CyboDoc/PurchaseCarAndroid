package cybodoc.garage.Activity;

/**
 * Created by pratheesh on 13-09-2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import cybodoc.carpurchase.R;


public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread timer = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(2000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Intent openAuto;
                    openAuto = new Intent(getApplicationContext(),ListCarBrandsActivity.class);
                    startActivity(openAuto);
                }

            }
        };
        timer.start();
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        finish();
    }
}
