package com.fc.test001;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private int name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test(new Man());
    }


    private void test(Object man) {
        Log.e(TAG, "man instanceof Person "+(man instanceof Person)
                +" \n man instanceof Student "+(man instanceof Student)
                +" \n man instanceof Man " +(man instanceof Man)
                +" \n  man instanceof View " +(man instanceof View)
                +" \n  man instanceof Object " +(man instanceof Object));

        Man m = new Man();
        Log.e(TAG, "test: "+(m instanceof Person) );
    }
    /**
     * 不在see标签中需要使用{@link xxxxx}
     *          {@link android.os.Build}  类
     *          {@link android.os.Build.VERSION_CODES#M} 类内变量或常量
     *          {@link #setAutofillHints(String...)}     方法
     *          {@value #AUTOFILL_HINT_EMAIL_ADDRESS}    变量
     *
     * @see #test(Object o) 一个see标签对应一个跳转 #表示方法或变量，不能没有
     * @see android.os.Build 类
     * @see android.os.Build.VERSION#HARDWARE 类内部变量
     * @see android.os.Build.VERSION#getSerial() 类内部方法
     *
     * @return {@code true} 表示具体数值
     *
     * @param 参数
     * @return 返回值
     * @exception 异常
     * @throw 异常
     * @see 有哪些相关类或者方法 变量
     * @since 版本
     * @deprecated 过时 需要标明应该用哪个方法代替
     *
     */


    public void serviceH(){
        startService(new Intent(this, MService.class));
        stopService(new Intent(this, MService.class));


        MReceiver receiver = new MReceiver();
        IntentFilter filter = new IntentFilter("HELLO_WORLD");
        registerReceiver(receiver, filter);//动态注册
        unregisterReceiver(receiver);//取消注册，只有动态注册需要

        sendBroadcast(new Intent("HELLO_WORLD"));//发送广播
        sendOrderedBroadcast(new Intent("HELLO_WORLD"),null);//发送有序广播

        //本地广播
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("HELLO_WORLD"));
        LocalBroadcastManager.getInstance(this).sendBroadcastSync(new Intent("HELLO_WORLD"));//同步广播  会堵塞
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, filter);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);



    }


}
