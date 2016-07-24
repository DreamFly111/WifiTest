package duoy.cn.wifitest;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import junit.framework.Test;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        isWifiConnected(this);
        //测试新版本
    }

    public void isWifiConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if(networkInfo.isConnected()){
            Log.i("test","true");
            Intent intent = new Intent(context, Test1.class);
            startActivity(intent);
            finish();
        }else{
            Intent intent = new Intent(context,Test2.class);
            startActivity(intent);
            Log.i("test","false");
            finish();
        }
    }
}
