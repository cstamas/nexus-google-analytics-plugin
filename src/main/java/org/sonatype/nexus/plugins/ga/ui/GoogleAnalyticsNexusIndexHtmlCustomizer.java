package org.sonatype.nexus.plugins.ga.ui;

import java.io.IOException;
import java.util.Map;

import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;
import org.codehaus.plexus.util.IOUtil;
import org.codehaus.plexus.util.StringUtils;
import org.sonatype.nexus.plugins.ga.GoogleAnalyticsPluginConfiguration;
import org.sonatype.nexus.plugins.rest.AbstractNexusIndexHtmlCustomizer;
import org.sonatype.nexus.plugins.rest.NexusIndexHtmlCustomizer;

/**
 * A GA NexusResourceBundle, that's solely purpose is to contribute to index.html header only with the well-known Google
 * Analytics scripts. This bundle uses GoogleAnalyticsPluginConfiguration component to get the trackerId to be inserted
 * into the script snippet. If the aforementioned component is not able to find/get any trackerId (it returns null or
 * empty string), this plugin will refuse to contribute and will just sit silently on system and the Nexus instance will
 * not be tracked by GA (until you set up a valid trackerId source). For details, see
 * DefaultGoogleAnalyticsPluginConfiguration.
 * 
 * @author cstamas
 */
@Component( role = NexusIndexHtmlCustomizer.class, hint = "GoogleAnalyticsNexusIndexHtmlCustomizer" )
public class GoogleAnalyticsNexusIndexHtmlCustomizer
    extends AbstractNexusIndexHtmlCustomizer
{
    @Requirement
    private GoogleAnalyticsPluginConfiguration configuration;

    @Override
    public String getPostHeadContribution( final Map<String, Object> ctx )
    {
        if ( !configuration.isUITrackingEnabled() )
        {
            return null;
        }

        final String trackerId = configuration.getUITrackerId();

        if ( !StringUtils.isEmpty( trackerId ) )
        {
            try
            {
                String snippet = IOUtil.toString( getClass().getResourceAsStream( "/ga-snippet.js" ), "UTF-8" );

                ctx.put( "trackerId", trackerId );

                return snippet;
            }
            catch ( IOException e )
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }
}
