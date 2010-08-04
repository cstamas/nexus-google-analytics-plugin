Nexus GA Plugin
===============

Capabilities:

* tracking the UI usage with GA
* tracking repo content (artifacts) acces using GA with different strategies:
  * by path
  * by M2 groupId of the artifact
  * by Repository Target name
  * feel free to add other "strategy"
* TBD can use multiple GA IDs, so tracking for "3rd party" (someone hosting artifacts at your Nexus that has Google Analitycs account) is possible too.

Known issues:

* will not work behind HTTP Proxy (unless JVM proxy is set). It needs to obey Nexus global proxy settings. TBD.
* can use only one GA UID, and it will be used for all, UI and Item tracking. Later, this will be expanded.
* no real config, using system properties to "sneak in the GA ID". See DefaultGoogleAnalyticsPluginConfiguration class.
* is hastily drafted. Ideas please!

Thank you
=========

A lot of thanks goes to Lars J. Nilsson for a great inspiration!

Have fun!  
~t~
