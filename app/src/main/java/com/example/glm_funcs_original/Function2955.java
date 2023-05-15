package com.example.glm_funcs_original;

import android.content.Context;
import android.icu.text.UnicodeSetIterator;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import io.reactivex.SingleEmitter;
import kotlin.jvm.internal.Intrinsics;

public class Function2955 {



    public static final void m19307downloadTextFile$lambda2(String fileUrl, Context context, SingleEmitter emitter) {
        Intrinsics.checkNotNullParameter(fileUrl, "$fileUrl");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(FirebasePerfUrlConnection.openStream(new URL(fileUrl))));
            String str = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                String str2 = readLine + "\n";
                if (readLine != null) {
                    str = str + ((Object) str2);
                } else {
                    bufferedReader.close();
                    emitter.onSuccess(str);
                    return;
                }
            }
        }
//        catch (MalformedURLException e) {
//            emitter.onError(new Throwable(context.getString(C2929R.string.file_url_invalid_error), e));
//        } catch (IOException e2) {
//            emitter.onError(new Throwable(context.getString(C2929R.string.file_download_failed_error), e2));
//        }
        catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
      }
}