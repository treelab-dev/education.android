/*
 * Copyright (c) 2020. rogergcc
 */

package com.appsnipp.education.ui.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.appsnipp.education.App;
import com.appsnipp.education.R;

import java.util.Arrays;
import java.util.List;


public class MyMatchesCourses {

    public static MyMatchesCourses get() {
        return new MyMatchesCourses();
    }

    public List<MatchCourse> getData() {
        return Arrays.asList(
                new MatchCourse(1, "Digital Marketing", "12 courses available", R.drawable.education_2),
                new MatchCourse(2, "Business", "50 courses available", R.drawable.education_3),
                new MatchCourse(3, "Development", "265 courses available", R.drawable.education_4),
                new MatchCourse(4, "Security", "18 courses available", R.drawable.education_1),
                new MatchCourse(5, "Ethical Hacking", "36 courses available", R.drawable.education_5),
                new MatchCourse(6, "Mobile", "145 courses available", R.drawable.education_6)
        );
    }
}
