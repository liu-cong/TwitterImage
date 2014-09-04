package twitter_image.Activity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import twitter_image.Activity.R;

/*The first interface of this app. The user input the topic and the number of pictures related to this topic, 
 * and then press "Search" button. A photo gallery will show the searching results.*/
public class InterfaceActivity  extends Activity{
	   Button btnSearch;
	   EditText txtNo;
	   EditText txtTopic;
      
	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_main);

	      btnSearch = (Button) findViewById(R.id.btnSearch);//search button
	      txtTopic = (EditText) findViewById(R.id.editTextTopic);
	      txtNo = (EditText) findViewById(R.id.editTextNo);
	      btnSearch.setOnClickListener(new View.OnClickListener() {
	         public void onClick(View view) {
	        	String q=txtTopic.getText().toString();
	        	String No=txtNo.getText().toString();
	        	if(q.length()==0) q="worldcup";
	        	if(No.length()==0) No="5";
                SearchTweets st=new SearchTweets(q,"en",Integer.valueOf(No));
	            Intent intent = new Intent(InterfaceActivity.this, MainActivity.class);
	            startActivity(intent);
	         }
	      });

	   }
	   
	
}
