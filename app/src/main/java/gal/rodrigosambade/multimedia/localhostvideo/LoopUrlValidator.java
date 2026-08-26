package gal.rodrigosambade.multimedia.localhostvideo;

import android.net.Uri;

final class LoopUrlValidator {
    private LoopUrlValidator() {}

    static boolean isEmulatorHostUrl(String value) {
        Uri uri = Uri.parse(value);
        String scheme = uri.getScheme();
        return ("http".equals(scheme) || "https".equals(scheme))
                && "10.0.2.2".equals(uri.getHost());
    }
}
