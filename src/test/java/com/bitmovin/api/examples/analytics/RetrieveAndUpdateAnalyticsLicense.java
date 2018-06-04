package com.bitmovin.api.examples.analytics;

import com.bitmovin.api.BitmovinApi;
import com.bitmovin.api.analytics.license.AnalyticsLicense;
import com.bitmovin.api.analytics.license.AnalyticsLicenseDomain;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;

public class RetrieveAndUpdateAnalyticsLicense
{
    private static final String apiKey = "<INSERT_YOUR_APIKEY>";
    private static final String analyticsLicenseId = "<INSERT_YOUR_ANALYTICS_LICENSEKEY_ID>";
    private static final String newDomainUrl = "<INSERT_YOUR_NEW_DOMAIN>";
    private BitmovinApi bitmovinApi;

    @Before
    public void setUp() throws Exception
    {
        this.bitmovinApi = new BitmovinApi(apiKey);
    }

    @Test
    public void testGetAllLicenses() throws Exception
    {
        List<AnalyticsLicense> licenses = bitmovinApi.analytics.licenses.getAnalyticsLicenses();
        for (AnalyticsLicense license : licenses)
        {
            printLicenseDetails(license);
        }
    }

    @Test
    public void testGetLicense() throws Exception
    {
        AnalyticsLicense license = bitmovinApi.analytics.licenses.getAnalyticsLicense(analyticsLicenseId);
        printLicenseDetails(license);
    }

    @Test
    public void testAddAndDeleteDomain() throws Exception
    {
        AnalyticsLicense analyticsLicense = bitmovinApi.analytics.licenses.getAnalyticsLicense(analyticsLicenseId);
        AnalyticsLicenseDomain domain =  bitmovinApi.analytics.domains.addDomain(analyticsLicense, newDomainUrl);

        // Wait a bit to make sure that the query returns updated data
        TimeUnit.SECONDS.sleep(2);
        List<AnalyticsLicenseDomain> domains = bitmovinApi.analytics.licenses.getAnalyticsLicense(analyticsLicenseId).getDomains();

        assertThat(domains, is(not(empty())));
        boolean foundDomain = false;
        for (AnalyticsLicenseDomain d: domains)
            if (d.getUrl().equals(newDomainUrl))
                foundDomain = true;

        Assert.assertTrue(foundDomain);

        bitmovinApi.analytics.domains.deleteDomain(analyticsLicense, domain);
        domains = bitmovinApi.analytics.licenses.getAnalyticsLicense(analyticsLicenseId).getDomains();

        foundDomain = false;
        for (AnalyticsLicenseDomain d: domains)
            if (d.getUrl().equals(newDomainUrl))
                foundDomain = true;

        Assert.assertFalse(foundDomain);
    }

    private void printLicenseDetails(AnalyticsLicense license)
    {
        System.out.println("-----------------------------------------------------");
        System.out.println("Analytics license details");
        System.out.println(String.format("AnalyticsLicense Id: %s", license.getId()));
        System.out.println(String.format("AnalyticsLicense Key: %s", license.getLicenseKey()));
        System.out.println(String.format("AnalyticsLicense Name: %s", license.getName()));
        System.out.println(String.format("AnalyticsLicense MaxImpressions: %s", license.getMaxImpressions()));
        System.out.println(String.format("AnalyticsLicense Impressions: %s", license.getImpressions()));

        for (AnalyticsLicenseDomain d : license.getDomains())
        {
            System.out.println("AnalyticsLicense Domains:");
            System.out.println(String.format("\tAnalyticsLicense AnalyticsLicenseDomain Id: %s", d.getId()));
            System.out.println(String.format("\tAnalyticsLicense AnalyticsLicenseDomain URL: %s", d.getUrl()));
        }
        System.out.println("-----------------------------------------------------");
    }
}
