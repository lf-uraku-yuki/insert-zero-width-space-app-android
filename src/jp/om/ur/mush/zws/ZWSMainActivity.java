package jp.om.ur.mush.zws;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ZWSMainActivity extends Activity {

	private static final String ACTION_INTERCEPT = "com.adamrocker.android.simeji.ACTION_INTERCEPT";
	private static final String REPLACE_KEY = "replace_key";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent sourceIt = getIntent();
		String action = sourceIt.getAction();
		/* マッシュルームとして起動 */
		if (action != null && ACTION_INTERCEPT.equals(action)) {
			// インテントから元文字列を取得
			String source = sourceIt.getStringExtra(REPLACE_KEY);
			source += "\u200B";
			// インテントで文字列を送り返す
			Intent returnIt = new Intent();
			returnIt.putExtra(REPLACE_KEY, source);
			setResult(RESULT_OK, returnIt);
			finish();
		}
	}
}
