package co.humantraffik.ironpanda;

import android.net.Uri;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import co.humantraffik.ironpanda.TestActivity.LocationData;

/**
 * Created by Adam on 11/15/2014.
 */
public class UploadAsyncTask extends AsyncTask<TestActivity.LocationData, Void, Void> {

    private final String BASKET_BASE_URL = "";
    private final String RCVR_LAT = "";
    private final String RCVR_LNG = "";
    private final String BASKET_BEACON_DIST = "";
    private final String BEACON_UUID = "";
    private final String PHONE_UUID = "";
    private LocationData locationData;

    public UploadAsyncTask(TestActivity.LocationData locationData) {
        super();
        this.locationData = locationData;
    }

    @Override
    protected Void doInBackground(LocationData... voids) {
        String lat = String.valueOf(locationData.lat);
        String lng = String.valueOf(locationData.lng);
        String dist = String.valueOf(locationData.meters);
        String bUUID = locationData.b_uuid;
        String pUUID = locationData.p_uuid;

        HttpURLConnection urlConnection = null;
        Uri builtUri = Uri.parse(BASKET_BASE_URL).buildUpon()
                .appendQueryParameter(RCVR_LAT, lat)
                .appendQueryParameter(RCVR_LNG, lng)
                .appendQueryParameter(BEACON_UUID, bUUID)
                .appendQueryParameter(PHONE_UUID, pUUID)
                .appendQueryParameter(BASKET_BEACON_DIST, dist)
                .build();
        try {
            URL url = new URL(builtUri.toString());

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.connect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
