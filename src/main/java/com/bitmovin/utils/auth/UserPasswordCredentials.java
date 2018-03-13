package com.bitmovin.utils.auth;

/**
 * Created by chris on 12/01/16.
 */
public class UserPasswordCredentials extends Credentials
{
    public static final String USERNAME = "Username";
    public static final String PASSWORD = "Password";

    public UserPasswordCredentials (String username, String password)
    {
        this.addCredentials(USERNAME, username);
        this.addCredentials(PASSWORD, password);
    }

    public String getUsername ()
    {
        return this.credentials.get(USERNAME);
    }

    public String getPassword ()
    {
        return this.credentials.get(PASSWORD);
    }
}
