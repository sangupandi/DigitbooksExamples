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
package fr.digitbooks.android.examples.util;

import java.util.Random;

public class RandomUtil {

    private static final Random RND = new Random();

    private RandomUtil() {
    }

    public static int getPositiveInt(int min, int max) {

        if (min < 0 || min > max) {
            throw new IllegalArgumentException();
        }

        return RND.nextInt(max - min) + min;
    }

    public static float getFloat(float min, float max) {

        if (min < 0 || min > max) {
            throw new IllegalArgumentException();
        }

        final int sign = RND.nextInt(2) == 0 ? -1 : 1;
        final float number = RND.nextFloat() * (max - min) + min;

        return sign * number;
    }
}
