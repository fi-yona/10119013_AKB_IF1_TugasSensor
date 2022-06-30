package com.example.a10119013_akb_if1_tugassensor.ui.restoran;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a10119013_akb_if1_tugassensor.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;


public class RestoranFragment extends Fragment {

    private FusedLocationProviderClient client;
    SupportMapFragment mMapFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_restoran, container, false);
        client = LocationServices.getFusedLocationProviderClient(getActivity());
        mMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_resto);
        getLokasiResto();
        return view;
    }

    private void getLokasiResto() {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }

        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null){
                    mMapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {
                            LatLng lokasi = new LatLng(-0.9596813633506655, 100.3647286275552);
                            LatLng pecelLeleMbakTatik = new LatLng(-0.9591604172914744, 100.36459116434752);
                            LatLng ngulik = new LatLng(-0.9584314978207071, 100.36527446376793);
                            LatLng hdResto = new LatLng(-0.9596605443270317, 100.36528216287259);
                            LatLng kopiDariHati = new LatLng(-0.9589876651715178, 100.3648708394839);
                            LatLng kiniCheeseTea = new LatLng(-0.959492932798731, 100.36491471335326);

                            googleMap.addMarker(new MarkerOptions().position(lokasi).title("Rumah"));
                            googleMap.addMarker(new MarkerOptions().position(pecelLeleMbakTatik).title("Pecel Lele Mbak Tatik"));
                            googleMap.addMarker(new MarkerOptions().position(ngulik).title("Ngulik Gelato & Playground"));
                            googleMap.addMarker(new MarkerOptions().position(hdResto).title("HD Resto"));
                            googleMap.addMarker(new MarkerOptions().position(kopiDariHati).title("FOODPEDIA & Kopi dari Hati"));
                            googleMap.addMarker(new MarkerOptions().position(kiniCheeseTea).title("KINI Cheese Tea"));

                            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi, 17));
                        }
                    });
                }
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}