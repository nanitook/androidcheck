package xyz.nanitook.androidcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView versionAPICode = findViewById(R.id.androidApiLevel);
        TextView versionName = findViewById(R.id.androidVersionName);
        TextView deviceName = findViewById(R.id.deviceName);

        versionAPICode.setText(String.valueOf(Build.VERSION.SDK_INT));

        Field[] fields = Build.VERSION_CODES.class.getFields();
        String androidName = fields[Build.VERSION.SDK_INT].getName();
        versionName.setText(androidName);

        deviceName.setText(String.format("%s | %s", Build.MODEL, Build.MANUFACTURER));
    }
}