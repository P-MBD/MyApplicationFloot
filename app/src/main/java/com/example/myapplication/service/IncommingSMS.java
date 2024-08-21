package com.example.myapplication.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class IncommingSMS extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("IncommingSMS", "BroadcastReceiver triggered");

        final Bundle bundle = intent.getExtras();
        if (bundle != null) {
            final Object[] pdusObj = (Object[]) bundle.get("pdus");

            if (pdusObj != null) {
                for (Object pdu : pdusObj) {
                    SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdu);

                    String phoneNumber = smsMessage.getDisplayOriginatingAddress();
                    String message = smsMessage.getDisplayMessageBody();

                    Log.d("IncommingSMS", "From: " + phoneNumber + " Message: " + message);
                }
            }
        } else {
            Log.d("IncommingSMS", "No bundle received");
        }
    }
}
