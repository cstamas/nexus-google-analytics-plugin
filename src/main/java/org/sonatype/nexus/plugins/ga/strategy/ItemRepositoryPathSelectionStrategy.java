package org.sonatype.nexus.plugins.ga.strategy;

import java.util.Collection;
import java.util.Collections;

import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;
import org.sonatype.nexus.plugins.ga.GoogleAnalyticsPluginConfiguration;
import org.sonatype.nexus.plugins.ga.NexusFPoint;
import org.sonatype.nexus.proxy.item.RepositoryItemUid;

import com.boxysystems.jgoogleanalytics.FocusPoint;

@Component( role = PointSelectionStrategy.class, hint = "ItemRepositoryPathSelectionStrategy" )
public class ItemRepositoryPathSelectionStrategy
    implements PointSelectionStrategy
{
    @Requirement
    private GoogleAnalyticsPluginConfiguration configuration;

    public Collection<NexusFPoint> getNexusFPointFor( RepositoryItemUid uid )
    {
        FocusPoint fp = new FocusPoint( uid.getPath(), new FocusPoint( uid.getRepository().getId() ) );

        // TODO: trackerID!!!
        NexusFPoint result = new NexusFPoint( fp, configuration.getUITrackerId() );

        return Collections.singletonList( result );
    }
}
