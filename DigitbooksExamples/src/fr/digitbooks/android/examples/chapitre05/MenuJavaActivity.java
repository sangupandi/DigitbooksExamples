/*
 * Copyright (C) 2010   Cyril Mottier & Ludovic Perrier
 *              (http://www.digitbooks.fr/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.digitbooks.android.examples.chapitre05;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import fr.digitbooks.android.examples.R;

public class MenuJavaActivity extends Activity {

    private static final int FIRST_MENU_ID = Menu.FIRST;
    private static final int SECOND_MENU_ID = Menu.FIRST + 1;

    private boolean mMenuDisplayed = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu);

        final Button button = (Button) findViewById(R.id.button);
        button.setText("Cacher le menu");
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                button.setText(mMenuDisplayed ? "Montrer le menu" : "Cacher le menu");
                mMenuDisplayed = !mMenuDisplayed;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, FIRST_MENU_ID, 0, "Menu 1");
        menu.add(0, SECOND_MENU_ID, 0, "Menu 2");
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        return mMenuDisplayed;
    }

}
