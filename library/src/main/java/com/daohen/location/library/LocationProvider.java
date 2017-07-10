package com.daohen.location.library;

import android.content.Context;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.daohen.personal.toolbox.library.Singleton;

/**
 * CREATE BY ALUN
 * EMAIL: alunfeixue2011@gmail.com
 * DATA : 2017/07/08 15:29
 */
public class LocationProvider {

    private AMapLocationClient aMapLocationClient;

    private static final Singleton<LocationProvider> gDefault = new Singleton<LocationProvider>() {
        @Override
        protected LocationProvider create() {
            return new LocationProvider();
        }
    };

    public void init(Context context){
        aMapLocationClient = new AMapLocationClient(context);
        aMapLocationClient.setLocationOption(getDefaultOption());
    }

    public void startLocation(){
        if (checkNull())
            return;

        aMapLocationClient.startLocation();
    }

    public void stopLocation(){
        if (checkNull())
            return;

        aMapLocationClient.stopLocation();
    }

    public void setCallback(AMapLocationListener listener){
        if (checkNull())
            return;

        aMapLocationClient.setLocationListener(listener);
    }

    public void onDestory(){
        if (checkNull())
            return;

        aMapLocationClient.onDestroy();
        aMapLocationClient = null;
    }

    private boolean checkNull(){
        return aMapLocationClient == null;
    }

    private AMapLocationClientOption getDefaultOption(){
        AMapLocationClientOption option = new AMapLocationClientOption();
        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);//可选，设置定位模式，可选的模式有高精度、仅设备、仅网络。默认为高精度模式
        option.setGpsFirst(false);//可选，设置是否gps优先，只在高精度模式下有效。默认关闭
        option.setHttpTimeOut(30000);//可选，设置网络请求超时时间。默认为30秒。在仅设备模式下无效
        option.setInterval(2000);//可选，设置定位间隔。默认为2秒
        option.setNeedAddress(true);//可选，设置是否返回逆地理地址信息。默认是true
        option.setOnceLocation(true);//可选，设置是否单次定位。默认是false
        option.setOnceLocationLatest(false);//可选，设置是否等待wifi刷新，默认为false.如果设置为true,会自动变为单次定位，持续定位时不要使用
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTP);//可选， 设置网络请求的协议。可选HTTP或者HTTPS。默认为HTTP
        option.setSensorEnable(false);//可选，设置是否使用传感器。默认是false
        option.setWifiScan(true); //可选，设置是否开启wifi扫描。默认为true，如果设置为false会同时停止主动刷新，停止以后完全依赖于系统刷新，定位位置可能存在误差
        option.setLocationCacheEnable(true); //可选，设置是否使用缓存定位，默认为true
        return option;
    }
}
