package org.sonatype.nexus.plugins.ga.strategy;

import java.util.Collection;

import org.sonatype.nexus.plugins.ga.NexusFPoint;
import org.sonatype.nexus.proxy.item.RepositoryItemUid;

public interface PointSelectionStrategy
{
    Collection<NexusFPoint> getNexusFPointFor( RepositoryItemUid uid );
}
