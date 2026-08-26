package gal.rodrigosambade.multimedia.localhostvideo;

import java.util.Locale;
import java.util.regex.Pattern;

final class LoopUrlValidator {
    private static final Pattern EMULATOR_HOST_URL = Pattern.compile(
            "^https?://10\\.0\\.2\\.2(?::[0-9]{1,5})?(?:/.*)?$",
            Pattern.CASE_INSENSITIVE);

    private LoopUrlValidator() {}

    static boolean isEmulatorHostUrl(String value) {
        if (value == null) {
            return false;
        }
        String normalized = value.trim().toLowerCase(Locale.ROOT);
        return EMULATOR_HOST_URL.matcher(normalized).matches();
    }
}
