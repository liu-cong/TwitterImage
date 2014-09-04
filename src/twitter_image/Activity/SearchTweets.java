package twitter_image.Activity;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.view.SurfaceHolder;

/*This class is used to search twitter and return picture urls*/
public class SearchTweets {
	static String[] defaultUrls= {
		    "http://pbs.twimg.com/media/Bwo1Z_IIgAAiNE2.jpg",
			"http://pbs.twimg.com/media/BwomfXoIAAAePDU.jpg",
			"http://pbs.twimg.com/media/Bskyj58IcAAVu3u.jpg",
				"http://pbs.twimg.com/media/Bq5oHZ5IEAAovLb.jpg",
				"http://pbs.twimg.com/media/Bwo9i4RIIAANVBQ.jpg",
				"http://pbs.twimg.com/media/BwpSWNlIMAARarE.jpg"
    };
	static SearchThread thread;
	static boolean notFound=true;
	static String[] urls;
	String q,lang;//q:topic of the query;lang:language
	int count;//number of pictures to show
	public SearchTweets(String q, String lang, int count){
		this.q=q;this.lang=lang;this.count=count;
	    urls=new String[count];
	    thread=new SearchThread();
	};
    private Twitter getTwitter() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
  	  cb.setOAuthConsumerKey("aaJYEt4n4P5I23e6Js1QHmiSX");
  	  cb.setOAuthConsumerSecret("XJoBXXFFteZ0JEN0k2QxKIIurOvdBMbxvLghlin6SJV9D5FHOz");
  	  cb.setOAuthAccessToken("2532076240-4K6HTd8qwK3tNKCRkLvgaKn5RN4C2ifE4rbZYGS");
  	  cb.setOAuthAccessTokenSecret("JpEWlFNm8bFP0eow1nfNeeeNJKpNy3mHK5MGXxjVhBPp0");
        return new TwitterFactory(cb.build()).getInstance();
    }

	public void fetchUrl () {//get urls of pictures from twitter
		notFound=false;
		Twitter twitter=getTwitter();
		int i=0;
		try {
			 Query query = new Query(q);
		        query.setCount(count);
		        query.setLang(lang);
			QueryResult result;
			//do 
			{
				result = twitter.search(query);
				List<Status> tweets = result.getTweets();
				for (Status tweet : tweets) {
					MediaEntity[] media= tweet.getMediaEntities();
					if (i>count-1) break;
					if(media.length>0)
					{urls[i]=media[0].getMediaURL();
					i++;}
				}
			} 
			//while ((query = result.nextQuery()) != null&&i<count);
		} catch (Exception e) {
			 notFound=true;
		}
	}
	   public static String[] getUrls(){
		   if(notFound) return defaultUrls;
		   else return urls;
		   }
	   public static void stopThread(){thread.setRunning(false);}
	   public class SearchThread extends Thread {
		   private boolean ifThreadRun=false;
            public SearchThread(){ifThreadRun=true;}
			public void setRunning(boolean b) 
			{ifThreadRun = b;}

			@Override
			public void run() {
				while (ifThreadRun) {fetchUrl();}				
					try {sleep(1000);} catch (Exception e) {}
				}
	   }
}