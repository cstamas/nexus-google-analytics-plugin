package org.sonatype.nexus.plugins.ga.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;
import org.sonatype.nexus.plugins.ga.NexusFPoint;
import org.sonatype.nexus.plugins.ga.NexusFPointSelector;
import org.sonatype.nexus.plugins.ga.strategy.PointSelectionStrategy;
import org.sonatype.nexus.proxy.item.RepositoryItemUid;

@Component( role = NexusFPointSelector.class )
public class DefaultNexusFPointSelector
    implements NexusFPointSelector
{
    @Requirement
    private Map<String, PointSelectionStrategy> strategies;

    public Collection<NexusFPoint> getNexusFPointFor( RepositoryItemUid uid )
    {
        ArrayList<NexusFPoint> result = new ArrayList<NexusFPoint>();

        for ( PointSelectionStrategy strategy : strategies.values() )
        {
            result.addAll( strategy.getNexusFPointFor( uid ) );
        }

        return result;
    }

}
