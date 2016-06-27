package com.grayraven.mywidgetapp;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String daysToGo = getResources().getString (R.string.days_to_go_format, "134");
        Log.d("MAIN", daysToGo);
        updateWidget();
    }

    private void updateWidget() {
        int widgetIDs[] = AppWidgetManager.getInstance(getApplication()).getAppWidgetIds(new ComponentName(getApplication(),ElectionWidget.class));
        AppWidgetManager.getInstance(getApplication()).notifyAppWidgetViewDataChanged(widgetIDs,R.id.days_to_go_txt);

    }
}
