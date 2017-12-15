package com.example.pranali_deogade.callback;

import android.content.Intent;
import android.os.Handler;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements MyResultReceiver.Receiver{
    Button bt;
    public  MyResultReceiver myResultReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);
        myResultReceiver=new MyResultReceiver(new Handler());
        myResultReceiver.setmReceiver(this);
        bt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (v.getId()==R.id.button){
                            Intent intent=new Intent(MainActivity.this,MyIntentService.class);
                            intent.putExtra("nameTag","Pran");
                          //  myResultReceiver = intent.getParcelableExtra(SyncStateContract.Constants.RECEIVER);
                            intent.putExtra("receiverTag",myResultReceiver);
                            startService(intent);
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Hello",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );

    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        Log.d("Pran","Received result from service "+resultData.getString("serviceTag"));
    }
}
