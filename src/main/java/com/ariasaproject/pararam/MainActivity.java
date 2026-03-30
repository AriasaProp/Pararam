package com.ariasaproject.pararam;

import static android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
		List<ResolveInfo> apps = new ArrayList<ResolveInfo>();
		Adapter adpt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final RecyclerView cv = (RecyclerView) findViewById(R.id.apps);
        cv.setLayoutManager(new GridLayoutManager(this, 3, RecyclerView.HORIZONTAL, false));
        adpt =  new Adapter<AppHolder>() {
                    final LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                    @Override
                    public AppHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                        View itemView = inflater.inflate(R.layout.app_layout, parent, false);
                        return new AppHolder(itemView);
                    }

                    @Override
                    public void onBindViewHolder(AppHolder holder, int position) {
                        final ResolveInfo c = apps.get(position);
                        final PackageManager pm = MainActivity.this.getPackageManager();
                        holder.label.setText(c.loadLabel(pm));
                        holder.icon.setImageDrawable(c.loadIcon(pm));
                    }

                    @Override
                    public int getItemCount() {
                        return apps.size();
                    }
                };
        cv.setAdapter(adpt);
        checkBatteryOptimizations();
        updateAppList();
		}

    private static final int REQUEST_BATTERY_OPTIMIZATIONS = 1001;

    private void checkBatteryOptimizations() {
        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        if (powerManager != null && !powerManager.isIgnoringBatteryOptimizations(getPackageName())) {
            // Jika izin tidak diizinkan, tampilkan dialog untuk meminta izin
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, REQUEST_BATTERY_OPTIMIZATIONS);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            default:
                break;
            case REQUEST_BATTERY_OPTIMIZATIONS:
                PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
                if (powerManager != null && powerManager.isIgnoringBatteryOptimizations(getPackageName())) {
                    // Izin diberikan, lanjutkan dengan operasi normal
                } else {
                    // Izin ditolak, berikan pengguna instruksi lebih lanjut atau tindakan yang
                    // sesuai
                }
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    
    void updateAppList(){
    		Intent intent = new Intent(Intent.ACTION_MAIN, null);
    		intent.addCategory(Intent.CATEGORY_LAUNCHER);
    		apps = getApplicationContext().getPackageManager().queryIntentActivities(intent, 0);
    		adpt.notifyDataSetChanged();
    }
    
    class AppHolder extends RecyclerView.ViewHolder {
        TextView label;
        ImageView icon;

        public AppHolder(View itemView) {
            super(itemView);
            label = itemView.findViewById(R.id.text_view);
            icon = itemView.findViewById(R.id.image_view);
        }
    }
}



