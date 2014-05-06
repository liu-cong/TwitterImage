package twitter_image.Widget;

import java.util.List;

import android.content.Context;
import android.view.ViewGroup;
import twitter_image.TouchView.UrlTouchImageView;


/**
 Class wraps URLs to adapter, then it instantiates {@link UrlTouchImageView} objects to paging up through them.
 */
public class UrlPagerAdapter extends BasePagerAdapter {
	
	public UrlPagerAdapter(Context context, List<String> resources)
	{
		super(context, resources);
	}
    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        ((GalleryViewPager)container).mCurrentView = ((UrlTouchImageView)object).getImageView();
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position){
        final UrlTouchImageView iv = new UrlTouchImageView(mContext);
        iv.setUrl(mResources.get(position));
        iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        
        collection.addView(iv, 0);
        return iv;
    }
}
