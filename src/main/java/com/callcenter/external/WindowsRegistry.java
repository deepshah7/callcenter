package com.callcenter.external;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.prefs.Preferences;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
@Component
public class WindowsRegistry {

    private static final Logger logger = Logger.getLogger(WindowsRegistry.class);

    private static final int HKEY_CURRENT_USER = 0x80000001;
    private static final int KEY_QUERY_VALUE = 1;
    private static final int KEY_SET_VALUE = 2;
    private static final int KEY_READ = 0x20019;

    private static final Preferences USER_ROOT = Preferences.userRoot();
    private static final Preferences SYSTEM_ROOT = Preferences.systemRoot();

    public String readLocalMachineKey(final String registryPath, final String property) {
        return readRegistry(SYSTEM_ROOT, registryPath, property);
    }

    public String readCurrentUserKey(final String registryPath, final String property) {
        return readRegistry(USER_ROOT, registryPath, property);
    }

    private String readRegistry(Preferences preferencesRoot, String registryPath, String property) {
        final Class clz = preferencesRoot.getClass();
        try {
            final Method openKey = clz.getDeclaredMethod("openKey",
                    byte[].class, int.class, int.class);
            openKey.setAccessible(true);

            final Method closeKey = clz.getDeclaredMethod("closeKey",
                    int.class);
            closeKey.setAccessible(true);

            final Method winRegQueryValue = clz.getDeclaredMethod(
                    "WindowsRegQueryValueEx", int.class, byte[].class);
            winRegQueryValue.setAccessible(true);
            final Method winRegEnumValue = clz.getDeclaredMethod(
                    "WindowsRegEnumValue1", int.class, int.class, int.class);
            winRegEnumValue.setAccessible(true);
            final Method winRegQueryInfo = clz.getDeclaredMethod(
                    "WindowsRegQueryInfoKey1", int.class);
            winRegQueryInfo.setAccessible(true);


            byte[] valb;
            String vals;
            Integer handle;

            handle = (Integer) openKey.invoke(preferencesRoot, toCstr(registryPath), KEY_READ, KEY_READ);
            valb = (byte[]) winRegQueryValue.invoke(preferencesRoot, handle.intValue(),
                    toCstr(property));
            vals = (valb != null ? new String(valb).trim() : null);
            logger.debug("The value in registry path: " + registryPath + " for property: " + property + " is: " + vals);
            closeKey.invoke(Preferences.userRoot(), handle);
            return vals;
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static byte[] toCstr(String str) {
        byte[] result = new byte[str.length() + 1];
        for (int i = 0; i < str.length(); i++) {
            result[i] = (byte) str.charAt(i);
        }
        result[str.length()] = 0;
        return result;
    }
}
