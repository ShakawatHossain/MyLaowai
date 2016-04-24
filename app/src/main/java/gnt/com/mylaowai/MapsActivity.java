package gnt.com.mylaowai;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MapsActivity extends AppCompatActivity {

    WebView web;
    FloatingActionButton fab;
    MyLaowaiFragment fragment;
    FragmentManager fManager;
    FragmentTransaction fTransaction;
    FrameLayout f;
    TextView state_name;
    ListView lv;
    String [] state_array;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setVisibility(View.GONE);
        init();
    }
    private void init(){
        web = (WebView) findViewById(R.id.webview);
        web.getSettings().setJavaScriptEnabled(true);
//        web.getSettings().setUseWideViewPort(true);
//        web.setInitialScale(10000);
//        web.getSettings().setLoadsImagesAutomatically(true);
//        web.getSettings().setLoadWithOverviewMode(true);

        web.getSettings().setSupportZoom(true);
        web.getSettings().setBuiltInZoomControls(true);
        web.setWebViewClient(new HelloWebViewClient());
        web.loadUrl("http://mylaowai.net/map/map.html");
        f = (FrameLayout) findViewById(R.id.mpas_fragment);
        state_name = (TextView) findViewById(R.id.state_name);
        state_name.setVisibility(View.GONE);
        lv = (ListView) findViewById(R.id.list_view);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.states_array, android.R.layout.simple_spinner_dropdown_item);
        lv.setAdapter(adapter);
        state_array = getResources().getStringArray(R.array.states_array);


        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.GONE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        state_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv.setVisibility(View.VISIBLE);
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lv.setVisibility(View.GONE);
                state_name.setText(state_array[position]);
            }
        });
    }

    private class HelloWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            view.setVisibility(View.GONE);
            /*Showing fragment*/
            fragment = new MyLaowaiFragment();
            fManager = getFragmentManager();
            fTransaction = fManager.beginTransaction();
            fTransaction.add(R.id.mpas_fragment, fragment);
            fTransaction.commit();
            Log.d("onPageStarted", "show fragment");
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d("override", "show fragment");
            view.setVisibility(View.GONE);
            /*Shown the value to the TextView*/
            String [] str = url.split("/",4);
            state_name.setText(str[3]);
            web.loadUrl("http://mylaowai.net/map/map.html");
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            Log.d("onPageFinished", "fragment gone");
            /*Invisible the fragment*/
            f.setVisibility(View.GONE);
            fab.setVisibility(View.VISIBLE);
            state_name.setVisibility(View.VISIBLE);
            toolbar.setVisibility(View.VISIBLE);
//            fTransaction.hide(fragment);
//            fTransaction.remove(fragment);
//            fTransaction.commit();
            view.setVisibility(View.VISIBLE);
            super.onPageFinished(view, url);
        }
    }
}
