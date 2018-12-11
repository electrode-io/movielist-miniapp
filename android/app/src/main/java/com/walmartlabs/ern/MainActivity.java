package com.walmartlabs.ern;

import android.content.Intent;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ernnavigation.ern.api.NavigateData;
import com.ernnavigation.ern.api.NavigationApi;
import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeRequestHandler;
import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeResponseListener;
import com.walmartlabs.ern.RunnerConfig;
import com.walmartlabs.ern.container.ElectrodeMiniAppActivity;
import com.walmartlabs.ern.container.miniapps.MiniAppsConfig;

// This is the main activity that gets launched upon app start
// It just launches the activity containing the miniapp
// Feel free to modify it at your convenience.
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationApi.requests().registerNavigateRequestHandler(new ElectrodeBridgeRequestHandler<NavigateData, Boolean>() {
            @Override
            public void onRequest(@Nullable NavigateData navigateData, @NonNull ElectrodeBridgeResponseListener<Boolean> responseListener) {
                if (!MainActivity.this.isFinishing()) {
                    if (navigateData != null) {
                        Log.d("NAVIGATION", "" + navigateData.getminiAppName());
                        Log.d("NAVIGATION", "" + navigateData.getinitialPayload());
                        Class activityClass = MiniAppsConfig.MINIAPP_ACTIVITIES.get(navigateData.getminiAppName());
                        if (activityClass != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("payload", navigateData.getinitialPayload());
                            Intent intent = new Intent(MainActivity.this, activityClass);
                            ElectrodeMiniAppActivity.addInitialProps(intent, bundle);
                            MainActivity.this.startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "No activity found to navigate for: " + navigateData.getminiAppName(), Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Log.d("NAVIGATION", "Not enough data provided to navigate");
                    }
                }
            }
        });

        Intent i = new Intent(this, RunnerConfig.MAIN_MINIAPP_ACTIVITY_CLASS);
        this.startActivity(i);
    }
}
