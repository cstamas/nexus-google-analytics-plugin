package org.sonatype.nexus.plugins.ga;

import com.boxysystems.jgoogleanalytics.JGoogleAnalyticsTracker;

/**
 * A tracker cache. Keeps multiple ones in memory, keyed by trackerId for example.
 * 
 * @author cstamas
 */
public interface GATrackerCache
{
    JGoogleAnalyticsTracker getGATracker( NexusFPoint nexusFPoint );
}
