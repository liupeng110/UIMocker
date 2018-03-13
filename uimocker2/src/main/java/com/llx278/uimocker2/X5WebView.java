package com.llx278.uimocker2;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Message;
import android.view.View;

import java.lang.reflect.Method;
import java.util.Map;

import de.robv.android.xposed.XposedBridge;

/**
 * Created by llx on 2018/3/13.
 */

class X5WebView implements WebViewProxy {

    private Object mOriginalWebView;
    private Class<?> mClass;

    X5WebView(Object originalWebView) {
        mOriginalWebView = originalWebView;
        mClass = mOriginalWebView.getClass();
    }

    @Override
    public void addJavascriptInterface(Object object, String name) {

    }

    @Override
    public boolean canGoBack() {
        return false;
    }

    @Override
    public boolean canGoBackOrForward(int steps) {
        return false;
    }

    @Override
    public boolean canGoForward() {
        return false;
    }

    @Override
    public boolean canZoomIn() {
        return false;
    }

    @Override
    public boolean canZoomOut() {
        return false;
    }

    @Override
    public View findFocus() {
        return null;
    }

    @Override
    public void findNext(boolean forward) {

    }

    @Override
    public String getOriginalUrl() {
        return null;
    }

    @Override
    public int getProgress() {
        return 0;
    }

    @Override
    public float getScale() {
        return 0;
    }

    @Override
    public Object getSettings() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public void goBack() {

    }

    @Override
    public void goBackOrForward(int steps) {

    }

    @Override
    public void goForward() {

    }

    @Override
    public void invokeZoomPicker() {

    }

    @Override
    public void loadData(String data, String mimeType, String encoding) {

    }

    @Override
    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {

    }

    @Override
    public void loadUrl(String url) {

        try {
            enableJavascript();
            Method loadUrl = mClass.getMethod("loadUrl", String.class);
            loadUrl.invoke(mOriginalWebView,url);
        } catch (Exception e) {
            XposedBridge.log(e);
        }
    }

    @Override
    public void loadUrl(String url, Map<String, String> additionalHttpHeaders) {

    }

    @Override
    public boolean pageDown(boolean bottom) {
        return false;
    }

    @Override
    public boolean pageUp(boolean top) {
        return false;
    }

    @Override
    public void pauseTimers() {

    }

    @Override
    public boolean performLongClick() {
        return false;
    }

    @Override
    public void postUrl(String url, byte[] postData) {

    }

    @Override
    public void reload() {

    }

    @Override
    public void removeJavascriptInterface(String name) {

    }

    @Override
    public boolean requestChildRectangleOnScreen(View child, Rect rect, boolean immediate) {
        return false;
    }

    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        return false;
    }

    @Override
    public void requestFocusNodeHref(Message hrefMsg) {

    }

    @Override
    public void requestImageRef(Message msg) {

    }

    @Override
    public void saveWebArchive(String filename) {

    }

    @Override
    public void setBackgroundColor(int color) {

    }

    @Override
    public void setDownloadListener(Object listener) {

    }

    @Override
    public void setFindListener(Object listener) {

    }

    @Override
    public void setHttpAuthUsernamePassword(String host, String realm, String username, String password) {

    }

    @Override
    public void setInitialScale(int scaleInPercent) {

    }

    @Override
    public void setLayerType(int layerType, Paint paint) {

    }

    @Override
    public void setMapTrackballToArrowKeys(boolean setMap) {

    }

    @Override
    public void setNetworkAvailable(boolean networkUp) {

    }

    @Override
    public void setWebChromeClient(Object client) {

    }

    @Override
    public void setWebViewClient(Object client) {

    }

    @Override
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void zoomBy(float zoomFactor) {

    }

    @Override
    public boolean zoomIn() {
        return false;
    }

    @Override
    public boolean zoomOut() {
        return false;
    }

    private void enableJavascript() throws Exception {
        Method getSettings = mClass.getMethod("getSettings");
        Object webSettings = getSettings.invoke(mOriginalWebView);
        Class<?> aClass = webSettings.getClass();
        Method setJavaScriptEnabled = aClass.getMethod("setJavaScriptEnabled", boolean.class);
        setJavaScriptEnabled.invoke(webSettings,true);
    }
}
