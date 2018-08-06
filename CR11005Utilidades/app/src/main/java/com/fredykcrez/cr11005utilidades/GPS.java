package com.fredykcrez.cr11005utilidades;

import java.util.List;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GPS extends Activity {
    Button obtenerDir;
    EditText edtlatitud;
    EditText edtlongitud;
    EditText edtaltitud;
    TextView edtdireccion;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);
        obtenerDir = (Button) findViewById(R.id.btnObtenerDatosPos);
        edtlatitud = (EditText) findViewById(R.id.edtLatitud);
        edtlongitud = (EditText) findViewById(R.id.edtlongitud);
        edtaltitud = (EditText) findViewById(R.id.edtAltitud);
        edtdireccion = (TextView) findViewById(R.id.edtDireccion);
        obtenerDir.setOnClickListener(onClickDireccion);
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
    }

    OnClickListener onClickDireccion = new OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Geocoder g = new Geocoder(getApplicationContext());
            List<Address> ad = null;
            try {
                ad = g.getFromLocation(
                        Double.valueOf(edtlatitud.getText().toString()),
                        Double.valueOf(edtlongitud.getText().toString()),
                        1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (ad != null && ad.isEmpty() == false) {
                edtdireccion.setText(ad.get(0).getThoroughfare() + "," + ad.get(0).getSubAdminArea() + "," + ad.get(0).getCountryName());
            }
        }
    };

    LocationListener locationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            // TODO Auto-generated method stub
            edtlatitud.setText(String.valueOf(location.getLatitude()));
            edtlongitud.setText(String.valueOf(location.getLongitude()));
            edtaltitud.setText(String.valueOf(location.getAltitude()));
        }
        public void onProviderDisabled(String provider) {
            //TODO Auto-generated method stub
        }
        public void onProviderEnabled(String provider) {
            //TODO Auto-generated method stub
        }
        public void onStatusChanged(String provider, int status, Bundle extras) {
            //TODO Auto-generated method stub
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        locationManager.removeUpdates(locationListener);
    }
    @Override
    public void onResume() {
        super.onResume();
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
    }
}