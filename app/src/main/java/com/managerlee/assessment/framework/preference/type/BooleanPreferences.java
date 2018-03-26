package com.managerlee.assessment.framework.preference.type;

import com.managerlee.assessment.framework.preference.SharedPreferencesWrapper;

/**
 * @author jingzuo
 */
public class BooleanPreferences extends BasePreferences {

    private boolean defaultValue;

    public BooleanPreferences(SharedPreferencesWrapper sharedPreferencesWrapper, String sharedPreferencesKey, boolean sharedPreferencesDefaultValue) {
        super(sharedPreferencesWrapper, sharedPreferencesKey);
        defaultValue = sharedPreferencesDefaultValue;
    }

    public void set(boolean value) {
        getSharedPreferences().edit().putBoolean(getSharedPreferencesKey(), value).commit();
    }

    public boolean get() {
        return getSharedPreferences().getBoolean(getSharedPreferencesKey(), getDefaultValue());
    }

    public boolean getDefaultValue() {
        return defaultValue;
    }
}
