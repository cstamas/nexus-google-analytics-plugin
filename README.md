Nexus GA Plugin
===============

Known issues:

* will not work behind HTTP Proxy (unless JVM proxy is set). It needs to obey Nexus global proxy settings. TBD.
* can use only one GA UID, and it will be used for all, UI and Item tracking. Later, this will be expanded.
* no real config, using system properties to "sneak in the GA ID". See DefaultGoogleAnalyticsPluginConfiguration class.
* is hastily drafted. Ideas please!

Have fun!  
~t~
