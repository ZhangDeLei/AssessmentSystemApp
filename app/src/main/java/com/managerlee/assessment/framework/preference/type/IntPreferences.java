package com.managerlee.assessment.framework.preference.type;


import com.managerlee.assessment.framework.preference.SharedPreferencesWrapper;

/**
 * @author jingzuo
 */
public class IntPreferences extends BasePreferences {

    private int defaultValue;

    public IntPreferences(SharedPreferencesWrapper sharedPreferencesWrapper, String sharedPreferencesKey, int sharedPreferencesDefaultValue) {
        super(sharedPreferencesWrapper, sharedPreferencesKey);
        defaultValue = sharedPreferencesDefaultValue;
    }

    public void set(int value) {
        getSharedPreferences().edit().putInt(getSharedPreferencesKey(), value).commit();
    }

    public int get() {
        return getSharedPreferences().getInt(getSharedPreferencesKey(), getDefaultValue());
    }

    public int getDefaultValue() {
        return defaultValue;
    }
}
