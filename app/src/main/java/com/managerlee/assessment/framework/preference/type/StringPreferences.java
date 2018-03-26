package com.managerlee.assessment.framework.preference.type;


import com.managerlee.assessment.framework.preference.SharedPreferencesWrapper;

/**
 * @author jingzuo
 */
public class StringPreferences extends BasePreferences {

    private String defaultValue;

    public StringPreferences(SharedPreferencesWrapper sharedPreferencesWrapper, String sharedPreferencesKey, String sharedPreferencesDefaultValue) {
        super(sharedPreferencesWrapper, sharedPreferencesKey);
        defaultValue = sharedPreferencesDefaultValue;
    }

    public void set(String value) {
        getSharedPreferences().edit().putString(getSharedPreferencesKey(), value).commit();
    }

    public String get() {
        return getSharedPreferences().getString(getSharedPreferencesKey(), getDefaultValue());
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}
