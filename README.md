# 高德地图

**不要忘记在AndroidManifest.xml中配置key**

```xml
<meta-data android:name="com.amap.api.v2.apikey" android:value="您的key" />
```

添加混淆

```
-keep class com.amap.api.location.**{*;}
-keep class com.amap.api.fence.**{*;}
-keep class com.autonavi.aps.amapapi.model.**{*;}
```