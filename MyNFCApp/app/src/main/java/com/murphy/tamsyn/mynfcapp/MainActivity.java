package com.murphy.tamsyn.mynfcapp;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.nfc.tech.NfcA;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    NfcAdapter nfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nfcAdapter = NfcAdapter.getDefaultAdapter(this);

        if (nfcAdapter != null && nfcAdapter.isEnabled()) {
            Toast.makeText(this, "NFC is available", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "NFC is not available on this device", Toast.LENGTH_LONG).show();
        }
    }

    boolean hasNFC() {
        boolean hasFeature = getPackageManager().hasSystemFeature(PackageManager.FEATURE_NFC);
        boolean isEnabled = NfcAdapter.getDefaultAdapter(this).isEnabled();
        return hasFeature && isEnabled;
    }

    @Override
    protected void onNewIntent(Intent intent) {
       try {
           if (isNfcIntent(intent)) {
               NdefRecord uriRecord = NdefRecord.createUri("https://www.dropbox.com/s/e2hi6mvzba1wdig/app-release.apk?dl=0");

               NdefMessage ndefMessage = new NdefMessage(new NdefRecord[] { uriRecord });

               Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);

               boolean writeResult = writeNdefMessage(tag, ndefMessage);

               if (writeResult) {
                   Toast.makeText(this, "Tag Written!", Toast.LENGTH_SHORT).show();
               } else {
                   Toast.makeText(this, "Failed to write tag", Toast.LENGTH_SHORT).show();
               }
           }
       } catch (Exception e) {
           Log.e("onNewIntent", e.getMessage());
       }
        super.onNewIntent(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = new Intent(this, MainActivity.class).addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        IntentFilter[] intentFilter = new IntentFilter[] { };

        nfcAdapter.enableForegroundDispatch(this, pendingIntent, intentFilter, null);
    }

    @Override
    protected void onPause() {
        super.onPause();

        nfcAdapter.disableForegroundDispatch(this);
    }


    private boolean formatTag(Tag tag, NdefMessage ndefMessage) {
        try {
            NdefFormatable ndefFormatable = NdefFormatable.get(tag);

            if (ndefFormatable != null) {
                ndefFormatable.connect();

                ndefFormatable.format(ndefMessage);
                ndefFormatable.close();
                return true;
            }
        }

            catch (Exception e) {
                Log.e("formatTag", e.getMessage());
            }
            return false;
    }

    private boolean writeNdefMessage(Tag tag, NdefMessage ndefMessage) {
        try {
            if (tag != null) {
                Ndef ndef = Ndef.get(tag);
                if (ndef == null) {
                    return formatTag(tag, ndefMessage);
                }
                else {
                    ndef.connect();

                    if (ndef.isWritable()) {
                        ndef.writeNdefMessage(ndefMessage);
                        ndef.close();
                        return true;
                    }

                    ndef.close();
                }
            }
        } catch (Exception e) {
            Log.e("formatTag", e.getMessage());
        }

        return false;
    }

    private void enableForegroundDispatch() {
        Intent intent = new Intent(this, MainActivity.class).addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        IntentFilter[] intentFilter = new IntentFilter[] { };

        String[] [] techList = new String[][] { {
                android.nfc.tech.Ndef.class.getName() }, {
                android.nfc.tech.NdefFormatable.class.getName()
        }};

        if (Build.DEVICE.matches(".generic.*")) {
            //clean up the tech filter
            techList = null;
        }

        nfcAdapter.enableForegroundDispatch(this, pendingIntent, intentFilter, techList);
    }

    boolean isNfcIntent (Intent intent) {
        return intent.hasExtra(NfcAdapter.EXTRA_TAG);
    }

}
