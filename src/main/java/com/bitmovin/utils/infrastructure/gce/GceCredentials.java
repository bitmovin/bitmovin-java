package com.bitmovin.utils.infrastructure.gce;

import com.bitmovin.utils.auth.Credentials;
import org.apache.commons.codec.binary.Base64;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 4/20/16
 */
public class GceCredentials extends Credentials
{
    private Long id;

    private String clientEmail;

    private String privateKey;

    public GceCredentials()
    {

    }

    public GceCredentials(String clientEmail, String privateKey)
    {
        this.clientEmail = clientEmail;

        privateKey = privateKey.replaceAll("\\\\n", "\n");
        byte[] encodedBytes = Base64.encodeBase64(privateKey.getBytes());
        this.privateKey = new String(encodedBytes);
    }

    public String getClientEmail()
    {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail)
    {
        this.clientEmail = clientEmail;
    }

    public String getPrivateKey()
    {
        byte[] decodedBytes = Base64.decodeBase64(this.privateKey.getBytes());
        return new String(decodedBytes);
    }

    public void setPrivateKey(String privateKey)
    {
        privateKey = privateKey.replaceAll("\\\\n", "\n");
        byte[] encodedBytes = Base64.encodeBase64(privateKey.getBytes());
        this.privateKey = new String(encodedBytes);
    }
}
