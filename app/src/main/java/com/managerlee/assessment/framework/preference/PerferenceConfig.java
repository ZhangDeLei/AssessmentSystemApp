package com.managerlee.assessment.framework.preference;

import android.content.Context;

import com.managerlee.assessment.framework.config.GlobalConfig;
import com.managerlee.assessment.framework.preference.type.IntPreferences;
import com.managerlee.assessment.framework.preference.type.StringPreferences;

/**
 * Created by anins on 2018/3/23.
 */

public class PerferenceConfig {

    public static final SharedPreferencesWrapper SHARED_PREFERENCES_INIT = new SharedPreferencesWrapper(GlobalConfig.getAppContext(), "connect", Context.MODE_PRIVATE);

    public static StringPreferences TOKEN = new StringPreferences(SHARED_PREFERENCES_INIT, "token", "");

    public static StringPreferences UserAccount = new StringPreferences(SHARED_PREFERENCES_INIT, "userAccount", "");

    public static StringPreferences NickName = new StringPreferences(SHARED_PREFERENCES_INIT, "nickName", "");

    public static IntPreferences UserId = new IntPreferences(SHARED_PREFERENCES_INIT, "userId", -1);

    public static IntPreferences CompanyId = new IntPreferences(SHARED_PREFERENCES_INIT, "companyId", -1);

}
