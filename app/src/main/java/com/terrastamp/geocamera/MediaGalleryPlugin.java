package com.terrastamp.geocamera;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import java.io.OutputStream;

@CapacitorPlugin(name = "MediaGallery")
public class MediaGalleryPlugin extends Plugin {

    @PluginMethod
    public void saveToGallery(PluginCall call) {
        String base64Data = call.getString("base64Data");
        String filename = call.getString("filename", "micastamp-" + System.currentTimeMillis() + ".jpg");

        if (base64Data == null || base64Data.isEmpty()) {
            call.reject("Base64 data is required");
            return;
        }

        try {
            if (base64Data.contains(",")) {
                base64Data = base64Data.split(",")[1];
            }
            byte[] imageBytes = Base64.decode(base64Data, Base64.DEFAULT);

            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.DISPLAY_NAME, filename);
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                values.put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + "/MicaStamp");
                values.put(MediaStore.Images.Media.IS_PENDING, 1);
            }

            Uri uri = getContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            if (uri == null) {
                call.reject("Failed to create MediaStore entry");
                return;
            }

            OutputStream out = getContext().getContentResolver().openOutputStream(uri);
            if (out != null) {
                out.write(imageBytes);
                out.close();
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                values.clear();
                values.put(MediaStore.Images.Media.IS_PENDING, 0);
                getContext().getContentResolver().update(uri, values, null, null);
            }

            JSObject ret = new JSObject();
            ret.put("success", true);
            ret.put("uri", uri.toString());
            call.resolve(ret);
        } catch (Exception e) {
            call.reject("Failed to save image to gallery: " + e.getMessage(), e);
        }
    }
}
