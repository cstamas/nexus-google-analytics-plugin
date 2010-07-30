package org.sonatype.nexus.plugins.ga.impl;

import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.Initializable;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.InitializationException;
import org.sonatype.nexus.plugins.ga.GoogleAnalyticsPluginConfiguration;

/**
 * TODO: this is just for quick usability, later this will be expanded!
 * 
 * @author cstamas
 */
@Component( role = GoogleAnalyticsPluginConfiguration.class )
public class DefaultGoogleAnalyticsPluginConfiguration
    implements GoogleAnalyticsPluginConfiguration, Initializable
{
    private String gaTrackerId;

    public boolean isUITrackingEnabled()
    {
        return gaTrackerId != null;
    }

    public String getUITrackerId()
    {
        return gaTrackerId;
    }

    public boolean isItemTrackingEnabled()
    {
        return gaTrackerId != null;
    }

    public void initialize()
        throws InitializationException
    {
        gaTrackerId = System.getProperty( "nexus.ga.trackerId" );
    }
}
