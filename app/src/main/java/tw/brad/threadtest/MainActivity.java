package tw.brad.threadtest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private UIHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv);
        handler = new UIHandler();

    }

    public void test1(View v){
        Thread1 t1 = new Thread1();
        t1.start();
    }

    public void test2(View v){
    }

    private class Thread1 extends Thread {
        @Override
        public void run() {
            for (int i=0; i<10; i++){
                Log.d("brad", "i=" + i);
                //tv.setText("i=" + i);
                handler.sendEmptyMessage(i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    private class UIHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tv.setText("i = " + msg.what);

        }
    }

}
