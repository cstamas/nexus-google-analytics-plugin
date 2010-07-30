package org.sonatype.nexus.plugins.ga;

/**
 * A Component that simply provides the trackerId for GA plugin. The source of the trackerId may be whatever.
 * 
 * @author cstamas
 */
public interface GoogleAnalyticsPluginConfiguration
{
    boolean isUITrackingEnabled();

    String getUITrackerId();

    boolean isItemTrackingEnabled();
}
