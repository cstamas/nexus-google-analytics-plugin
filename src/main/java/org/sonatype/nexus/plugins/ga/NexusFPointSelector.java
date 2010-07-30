package org.sonatype.nexus.plugins.ga;

import java.util.Collection;

import org.sonatype.nexus.proxy.item.RepositoryItemUid;

public interface NexusFPointSelector
{
    /**
     * Will gather various nexus focus points depending on existing strategies. These may be directed to different UA
     * accounts, to different FocusPoints, etc. For example: may report artifact URI, nexus id, target id, etc.
     * 
     * @param uid
     * @return
     */
    Collection<NexusFPoint> getNexusFPointFor( RepositoryItemUid uid );
}
