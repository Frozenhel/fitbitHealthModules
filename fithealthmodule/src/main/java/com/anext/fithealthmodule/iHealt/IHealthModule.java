package com.anext.fithealthmodule.iHealt;

import android.content.Intent;
import android.net.Uri;

/**
 * Created by Jiri on 18/07/17.
 */

public class IHealthModule {

    public Intent buildIntent(){
        StringBuilder sb = new StringBuilder();

        sb.append("http://sandboxapi.ihealthlabs.com/OpenApiV2/OAuthv2/userauthorization/");
        sb.append("?client_id=" + Informations.CLIENT_ID);
        sb.append("&response_type=code");
        sb.append("&redirect_uri=https://www.testcallback.com");
        sb.append("&APIName=testAPI");

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(sb.toString()));
        return intent;
    }

    public void authorize(){

    }

}
