package org.sonatype.nexus.plugins.ga.strategy;

import java.util.ArrayList;
import java.util.Collection;

import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;
import org.sonatype.nexus.plugins.ga.GoogleAnalyticsPluginConfiguration;
import org.sonatype.nexus.plugins.ga.NexusFPoint;
import org.sonatype.nexus.proxy.item.RepositoryItemUid;
import org.sonatype.nexus.proxy.target.TargetMatch;
import org.sonatype.nexus.proxy.target.TargetRegistry;
import org.sonatype.nexus.proxy.target.TargetSet;

import com.boxysystems.jgoogleanalytics.FocusPoint;

@Component( role = PointSelectionStrategy.class, hint = "ItemTargetSelectionStrategy" )
public class ItemTargetSelectionStrategy
    implements PointSelectionStrategy
{
    @Requirement
    private GoogleAnalyticsPluginConfiguration configuration;

    @Requirement
    private TargetRegistry targetRegistry;

    public Collection<NexusFPoint> getNexusFPointFor( RepositoryItemUid uid )
    {
        TargetSet targetSet = targetRegistry.getTargetsForRepositoryPath( uid.getRepository(), uid.getPath() );

        ArrayList<NexusFPoint> result = new ArrayList<NexusFPoint>( targetSet.getMatches().size() );

        FocusPoint repoFp = new FocusPoint( uid.getRepository().getId() );

        for ( TargetMatch targetMatch : targetSet.getMatches() )
        {
            FocusPoint fp = new FocusPoint( targetMatch.getTarget().getName(), repoFp );

            // TODO: trackerID!!!
            NexusFPoint nfp = new NexusFPoint( fp, configuration.getUITrackerId() );

            result.add( nfp );
        }

        return result;
    }

}
