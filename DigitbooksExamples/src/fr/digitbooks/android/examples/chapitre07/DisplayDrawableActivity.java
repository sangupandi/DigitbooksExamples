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
package fr.digitbooks.android.examples.chapitre07;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import fr.digitbooks.android.examples.R;

public class DisplayDrawableActivity extends Activity {

    public static final String INDEX_INTENT_KEY = "indexIntentKey";

    private static final int START_OFFSET = 500;
    private static final int TRANSITION_DURATION = 3000;

    private static final int COLOR_DRAWABLE_INDEX = 0;

    private static final int GRADIENT_DRAWABLE_JAVA_INDEX = 1;
    private static final int GRADIENT_DRAWABLE_XML_INDEX = 2;

    private static final int BITMAP_DRAWABLE_JAVA_INDEX = 3;
    private static final int BITMAP_DRAWABLE_XML_INDEX = 4;
    private static final int NINE_PATCH_DRAWABLE_INDEX = 5;

    private static final int INSET_DRAWABLE_INDEX = 6;

    private static final int CLIP_DRAWABLE_INDEX = 7;
    private static final int SCALE_DRAWABLE_INDEX = 8;
    private static final int ROTATE_DRAWABLE_INDEX = 9;

    private static final int ANIMATION_LIST_DRAWABLE_INDEX = 10;

    private static final int LAYER_DRAWABLE_INDEX = 11;
    private static final int TRANSITION_DRAWABLE_INDEX = 12;

    private static final int LEVEL_LIST_DRAWABLE_INDEX = 13;
    private static final int STATE_LIST_DRAWABLE_INDEX = 14;

    private static final int DEFAULT_INDEX = COLOR_DRAWABLE_INDEX;

    private final Handler mHandler = new Handler();
    private Drawable mCurrentDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Intent intent = getIntent();
        final Resources res = getResources();

        if (intent != null) {

            int index = intent.getIntExtra(INDEX_INTENT_KEY, DEFAULT_INDEX);

            switch (index) {
                case COLOR_DRAWABLE_INDEX:
                    mCurrentDrawable = res.getDrawable(R.drawable.color);
                    break;

                case GRADIENT_DRAWABLE_JAVA_INDEX:
                    mCurrentDrawable = new GradientDrawable(Orientation.BOTTOM_TOP, new int[] {
                            Color.RED, Color.GREEN, Color.BLUE
                    });
                    mCurrentDrawable.setDither(true);
                    break;
                case GRADIENT_DRAWABLE_XML_INDEX:
                    mCurrentDrawable = res.getDrawable(R.drawable.gradient);
                    break;

                case BITMAP_DRAWABLE_JAVA_INDEX:
                    BitmapDrawable bd = (BitmapDrawable) res.getDrawable(R.drawable.droid_logo);
                    bd.setGravity(Gravity.CENTER);
                    bd.setAntiAlias(true);
                    mCurrentDrawable = bd;
                    break;
                case BITMAP_DRAWABLE_XML_INDEX:
                    mCurrentDrawable = res.getDrawable(R.drawable.bitmap);
                    break;
                case NINE_PATCH_DRAWABLE_INDEX:
                    mCurrentDrawable = res.getDrawable(R.drawable.nine_patch);
                    break;

                case INSET_DRAWABLE_INDEX:
                    mCurrentDrawable = res.getDrawable(R.drawable.inset);
                    break;

                case CLIP_DRAWABLE_INDEX:
                    mCurrentDrawable = res.getDrawable(R.drawable.clip);
                    break;
                case SCALE_DRAWABLE_INDEX:
                    mCurrentDrawable = res.getDrawable(R.drawable.scale);
                    break;
                case ROTATE_DRAWABLE_INDEX:
                    mCurrentDrawable = res.getDrawable(R.drawable.rotate);
                    break;

                case ANIMATION_LIST_DRAWABLE_INDEX:
                    mCurrentDrawable = res.getDrawable(R.drawable.animation_list);
                    mHandler.postDelayed(new Runnable() {

                        public void run() {
                            ((AnimationDrawable) mCurrentDrawable).start();
                        }

                    }, START_OFFSET);
                    break;

                case LAYER_DRAWABLE_INDEX:
                    mCurrentDrawable = res.getDrawable(R.drawable.layer_list);
                    break;
                case TRANSITION_DRAWABLE_INDEX:
                    mCurrentDrawable = res.getDrawable(R.drawable.transition);
                    mHandler.postDelayed(new Runnable() {

                        public void run() {
                            ((TransitionDrawable) mCurrentDrawable).startTransition(TRANSITION_DURATION);
                        }

                    }, START_OFFSET);
                    break;

                case LEVEL_LIST_DRAWABLE_INDEX:
                    mCurrentDrawable = res.getDrawable(R.drawable.level_list);
                    break;

                case STATE_LIST_DRAWABLE_INDEX:
                    mCurrentDrawable = res.getDrawable(R.drawable.state_list);
                    break;
            }

            if (mCurrentDrawable != null) {

                setContentView(R.layout.display_drawable);
                findViewById(R.id.testView).setBackgroundDrawable(mCurrentDrawable);

                // L'interface dispose d'une SeekBar permettant de modifier en
                // temps r�el le "level" du drawable affich�. Il est ainsi
                // possible d'analyser le comportement du Drawable en fonction
                // du level courant
                SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
                seekBar.setMax(10000);
                seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }

                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        mCurrentDrawable.setLevel(progress);
                    }

                });
            }
        }
    }
}
