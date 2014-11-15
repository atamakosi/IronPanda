package co.humantraffik.ironpanda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Shows all available demos.
 *
 * @author wiktor@estimote.com (Wiktor Gworek)
 */
public class AllDemosActivity extends Activity {

    private EditText pIdTextView;


    @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.all_demos);
      pIdTextView = (EditText) findViewById(R.id.pUUID);
      pIdTextView.setText("0");

    findViewById(R.id.distance_demo_button).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(AllDemosActivity.this, ListBeaconsActivity.class);
          Bundle extras = new Bundle();
          extras.putString(ListBeaconsActivity.EXTRAS_TARGET_ACTIVITY, TestActivity.class.getName());
          extras.putString(TestActivity.PHONE_UID, TestActivity.class.getName());
//        intent.putExtra(ListBeaconsActivity.EXTRAS_TARGET_ACTIVITY, TestActivity.class.getName());
//        intent.putExtra(TestActivity.PHONE_UID, TestActivity.class.getName());
          intent.putExtras(extras);
        startActivity(intent);
      }
    });
//    findViewById(R.id.notify_demo_button).setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        Intent intent = new Intent(AllDemosActivity.this, ListBeaconsActivity.class);
//        intent.putExtra(ListBeaconsActivity.EXTRAS_TARGET_ACTIVITY, NotifyDemoActivity.class.getName());
//        startActivity(intent);
//      }
//    });
//    findViewById(R.id.characteristics_demo_button).setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        Intent intent = new Intent(AllDemosActivity.this, ListBeaconsActivity.class);
//        intent.putExtra(ListBeaconsActivity.EXTRAS_TARGET_ACTIVITY, CharacteristicsDemoActivity.class.getName());
//        startActivity(intent);
//      }
//    });
  }
}
