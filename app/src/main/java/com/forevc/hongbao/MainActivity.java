package com.forevc.hongbao;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mapsdk.raster.model.BitmapDescriptorFactory;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.map.MapActivity;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.TencentMap;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;


public class MainActivity extends MapActivity implements TencentLocationListener {

    MapView mapView = null;
    TextView cityView = null;
    ScrollView scrollWallet = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapView = (MapView) findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        cityView = (TextView) findViewById(R.id.text_view_city);

        // 请求定位权限
        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION}, 0);

        // 腾讯定位请求
        TencentLocationRequest request = TencentLocationRequest.create();
        request.setInterval(180000);
        TencentLocationManager locationManager = TencentLocationManager.getInstance(getApplicationContext());
        locationManager.requestLocationUpdates(request, this);

        scrollWallet = (ScrollView) findViewById(R.id.scrollview_wallet);

        final ImageButton buttonWallet = (ImageButton)findViewById(R.id.button_wallet);
        final ImageButton buttonHongBao = (ImageButton)findViewById(R.id.button_hongbao);
        buttonWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadWalletWebView();
                // 隐藏标题栏和地图栏
                findViewById(R.id.title).setVisibility(View.INVISIBLE);
                findViewById(R.id.map_view).setVisibility(View.INVISIBLE);
                // 显示我的钱包
                findViewById(R.id.my_wallet).setVisibility(View.VISIBLE);
                scrollWallet.scrollTo(0, 0);
                // 改变按钮样式
                buttonWallet.setImageResource(R.mipmap.ic_tab_wallet_selected);
                buttonHongBao.setImageResource(R.mipmap.ic_tab_hongbao_normal);
            }
        });
        buttonHongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 显示标题栏和地图栏
                findViewById(R.id.title).setVisibility(View.VISIBLE);
                findViewById(R.id.map_view).setVisibility(View.VISIBLE);
                // 隐藏我的钱包
                findViewById(R.id.my_wallet).setVisibility(View.INVISIBLE);
                // 改变按钮样式
                buttonWallet.setImageResource(R.mipmap.ic_tab_wallet_normal);
                buttonHongBao.setImageResource(R.mipmap.ic_tab_hongbao_selected);
            }
        });

    }

    private void loadWalletWebView() {
        WebView view = (WebView) findViewById(R.id.web_view_wallet);
        view.loadUrl("file:///android_asset/wallet.html");
    }

    @Override
    public void onLocationChanged(TencentLocation tencentLocation, int i, String s) {

        LatLng position = new LatLng(tencentLocation.getLatitude(), tencentLocation.getLongitude());

        TencentMap tencentMap = mapView.getMap();
        tencentMap.setCenter(position);
        tencentMap.setZoom(15);

        tencentMap.addMarker(new MarkerOptions()
                .position(position)
                .anchor(0.5f, 0.5f)
                .icon(BitmapDescriptorFactory.defaultMarker()));

        cityView.setText(tencentLocation.getAddress());
    }

    @Override
    public void onStatusUpdate(String s, int i, String s1) {
        // todo
    }
}
