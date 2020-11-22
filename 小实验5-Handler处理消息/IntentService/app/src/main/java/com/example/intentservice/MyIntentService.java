package com.example.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

public class MyIntentService extends IntentService {
    private static final String ACTION_FOO = "com.example.intentService.action.FOO";
    private static final String ACTION_BAZ = "com.example.intentService.action.BAZ";

    private static final String EXTRA_PARAM1 = "com.example.intentService.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.example.intentService.extra.PARAM2";

    public MyIntentService() {
        super("MyIntentService");
    }

    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
        }
    }

    private void handleActionFoo(String param1, String param2) {
        int num=Integer.parseInt(param1);
        boolean is=true;
        for(int i=2;i<num/2+1;i++){
            if(num%i==0){
                is=false;
                break;
            }
        }
        if (is) Log.e("Thread1",num+"是素数");
        else Log.e("Thread1",num+"不是素数");
    }
    private void handleActionBaz(String param1, String param2) {
        int num=Integer.parseInt(param1);
        int sum=1;
        for (int i=2;i<=num;i++){
            sum=sum*i;
        }
        Log.e("Thread2",num+"!="+sum);
    }
}