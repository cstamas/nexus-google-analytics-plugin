package org.sonatype.nexus.plugins.ga;

import com.boxysystems.jgoogleanalytics.FocusPoint;

/**
 * A simple class designating what and where should be notified.
 * 
 * @author cstamas
 */
public class NexusFPoint
{
    private final FocusPoint focusPoint;

    private final String trackerId;

    public NexusFPoint( FocusPoint focusPoint, String trackerId )
    {
        this.focusPoint = focusPoint;

        this.trackerId = trackerId;
    }

    public FocusPoint getFocusPoint()
    {
        return focusPoint;
    }

    public String getTrackerId()
    {
        return trackerId;
    }
}
