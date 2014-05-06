package twitter_image;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import twitter_image.Widget.GalleryViewPager;
import twitter_image.Widget.UrlPagerAdapter;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class MainActivity extends Activity {

	private LinearLayout layout;
	private GalleryViewPager vp;
    @SuppressLint("InlinedApi")
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout = new LinearLayout(getApplicationContext());
        vp=new GalleryViewPager(getApplicationContext());
        vp.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY );
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		WindowManager w = getWindowManager();
        Display d = w.getDefaultDisplay();
		Point tem_point=new Point();
		d.getSize(tem_point);
        layout.addView(vp,tem_point.x,tem_point.y);
        setContentView(layout);
        String[] urls = {
                "http://pbs.twimg.com/media/Bm17UA1IQAEyUKe.jpg",
                "http://pbs.twimg.com/media/Bm6G21EIIAAccWs.jpg",
                "http://pbs.twimg.com/media/Bm6IGdTCYAAB6hb.jpg",
                "http://pbs.twimg.com/media/Bm6xqaaIYAA71H0.jpg",
                "http://pbs.twimg.com/media/BmyqewIIUAAfaaJ.jpg",
                "http://pbs.twimg.com/media/Bm6aS9xCUAAKbzH.jpg",
                "http://pbs.twimg.com/media/Bm0vNl6CcAEutvE.jpg",
                "http://pbs.twimg.com/media/Bm6qJ35CAAAdzMX.jpg",
                "http://pbs.twimg.com/media/Bm6AkRkCAAAlVxb.jpg",
                "http://pbs.twimg.com/media/Bm5rnKvCUAAhf-o.jpg"
        };
        List<String> items = new ArrayList<String>();
        Collections.addAll(items, urls);

        UrlPagerAdapter pagerAdapter = new UrlPagerAdapter(this, items);
        vp.setOffscreenPageLimit(3);
        vp.setAdapter(pagerAdapter);
        
    }

}