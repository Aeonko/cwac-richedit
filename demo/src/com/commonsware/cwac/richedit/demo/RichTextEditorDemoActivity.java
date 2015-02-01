/***
  Copyright (c) 2012 CommonsWare, LLC
  
  Licensed under the Apache License, Version 2.0 (the "License"); you may
  not use this file except in compliance with the License. You may obtain
  a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/    

package com.commonsware.cwac.richedit.demo;

import android.app.Activity;
import android.os.Bundle;
import android.text.Selection;
import android.view.Menu;
import android.view.MenuItem;
import com.commonsware.cwac.richedit.RichEditText;
import com.commonsware.cwac.richedit.URLEffect;

public class RichTextEditorDemoActivity extends Activity {
  RichEditText editor=null;
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    setContentView(R.layout.main);
    
    editor=(RichEditText)findViewById(R.id.editor);
    editor.enableActionModes(true);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.actions, menu);

    return(super.onCreateOptionsMenu(menu));
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch(item.getItemId()) {
      case R.id.add_link:
        int offset=editor.getText().length();
        editor.append(" CommonsWare rocks!");
        editor.setSelection(offset+1, editor.getText().length());
        editor.applyEffect(new URLEffect(), "https://commonsware.com");

        Selection.removeSelection(editor.getText());

        return(true);
    }

    return(super.onOptionsItemSelected(item));
  }
}
