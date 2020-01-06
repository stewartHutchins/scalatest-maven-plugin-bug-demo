# scalatest-maven-plugin

This repo provides an example of a project with the issue outlined in (TODO: Add link once issue is raised).

####Overview
If the scalatest-maven-plugin is executed but scalatest is not on the classpath, the maven build fails with the following:

```log
[INFO] --- scalatest-maven-plugin:2.0.0:test (test) @ ideal-scenario ---
Error: Could not find or load main class org.scalatest.tools.Runner
Caused by: java.lang.ClassNotFoundException: org.scalatest.tools.Runner
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for ideal-scenario 1.0-SNAPSHOT:
[INFO]
[INFO] ideal-scenario ..................................... FAILURE [ 21.851 s]
[INFO] java-module ........................................ SKIPPED
[INFO] mixed-java-scala-module ............................ SKIPPED
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  23.325 s
[INFO] Finished at: 2020-01-03T21:01:43Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.scalatest:scalatest-maven-plugin:2.0.0:test (test) on project ideal-scenario: There are test failures -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
```
(NB: output of `mvn clean install -e -X` is at the bottom of the page)

There is a mismatch of errors. Maven incorrectly claims that there are test failures, however this is not
the case, the failures are actually due to scalatest not being on the classpath. 
Indicated by a subsection of the log:
```log
Error: Could not find or load main class org.scalatest.tools.Runner
Caused by: java.lang.ClassNotFoundException: org.scalatest.tools.Runner
```

####Workaround
The simplest workaround is to add scalatest as a dependency test at the top level of the project, forcing the all sub-modules
to have this dependency.



---
####Full output
Output of `mvn clean install -e -X`:
```log
[DEBUG] Dependency collection stats: {ConflictMarker.analyzeTime=429200, ConflictMarker.markTime=136700, ConflictMarker.nodeCount=79, ConflictIdSorter.graphTime=269000, ConflictIdSorter.
topsortTime=125700, ConflictIdSorter.conflictIdCount=32, ConflictIdSorter.conflictIdCycleCount=0, ConflictResolver.totalTime=3242700, ConflictResolver.conflictItemCount=77, DefaultDepend
encyCollector.collectTime=25544600, DefaultDependencyCollector.transformTime=4308200}
[DEBUG] org.scalatest:scalatest-maven-plugin:jar:2.0.0:
[DEBUG]    org.apache.maven:maven-plugin-api:jar:3.3.9:compile
[DEBUG]       org.apache.maven:maven-model:jar:3.3.9:compile
[DEBUG]       org.apache.maven:maven-artifact:jar:3.3.9:compile
[DEBUG]       org.eclipse.sisu:org.eclipse.sisu.plexus:jar:0.3.2:compile
[DEBUG]          javax.enterprise:cdi-api:jar:1.0:compile
[DEBUG]             javax.annotation:jsr250-api:jar:1.0:compile
[DEBUG]          org.eclipse.sisu:org.eclipse.sisu.inject:jar:0.3.2:compile
[DEBUG]    org.apache.maven:maven-core:jar:3.3.9:compile
[DEBUG]       org.apache.maven:maven-settings:jar:3.3.9:compile
[DEBUG]       org.apache.maven:maven-settings-builder:jar:3.3.9:compile
[DEBUG]          org.apache.maven:maven-builder-support:jar:3.3.9:compile
[DEBUG]       org.apache.maven:maven-repository-metadata:jar:3.3.9:compile
[DEBUG]       org.apache.maven:maven-model-builder:jar:3.3.9:compile
[DEBUG]          com.google.guava:guava:jar:18.0:compile
[DEBUG]       org.apache.maven:maven-aether-provider:jar:3.3.9:compile
[DEBUG]          org.eclipse.aether:aether-spi:jar:1.0.2.v20150114:compile
[DEBUG]       org.eclipse.aether:aether-impl:jar:1.0.2.v20150114:compile
[DEBUG]       org.eclipse.aether:aether-api:jar:1.0.2.v20150114:compile
[DEBUG]       org.eclipse.aether:aether-util:jar:1.0.2.v20150114:compile
[DEBUG]       com.google.inject:guice:jar:no_aop:4.0:compile
[DEBUG]          javax.inject:javax.inject:jar:1:compile
[DEBUG]          aopalliance:aopalliance:jar:1.0:compile
[DEBUG]       org.codehaus.plexus:plexus-interpolation:jar:1.21:compile
[DEBUG]       org.codehaus.plexus:plexus-utils:jar:3.0.22:compile
[DEBUG]       org.codehaus.plexus:plexus-classworlds:jar:2.5.2:compile
[DEBUG]       org.codehaus.plexus:plexus-component-annotations:jar:1.6:compile
[DEBUG]       org.sonatype.plexus:plexus-sec-dispatcher:jar:1.3:compile
[DEBUG]          org.sonatype.plexus:plexus-cipher:jar:1.4:compile
[DEBUG]       org.apache.commons:commons-lang3:jar:3.4:compile
[DEBUG]    org.apache.maven.reporting:maven-reporting-api:jar:3.0:compile
[DEBUG]       org.apache.maven.doxia:doxia-sink-api:jar:1.0:compile
[DEBUG] Created new class realm plugin>org.scalatest:scalatest-maven-plugin:2.0.0
[DEBUG] Importing foreign packages into class realm plugin>org.scalatest:scalatest-maven-plugin:2.0.0
[DEBUG]   Imported:  < maven.api
[DEBUG] Populating class realm plugin>org.scalatest:scalatest-maven-plugin:2.0.0
[DEBUG]   Included: org.scalatest:scalatest-maven-plugin:jar:2.0.0
[DEBUG]   Included: javax.enterprise:cdi-api:jar:1.0
[DEBUG]   Included: org.eclipse.sisu:org.eclipse.sisu.inject:jar:0.3.2
[DEBUG]   Included: org.apache.maven:maven-builder-support:jar:3.3.9
[DEBUG]   Included: com.google.guava:guava:jar:18.0
[DEBUG]   Included: org.eclipse.aether:aether-util:jar:1.0.2.v20150114
[DEBUG]   Included: com.google.inject:guice:jar:no_aop:4.0
[DEBUG]   Included: aopalliance:aopalliance:jar:1.0
[DEBUG]   Included: org.codehaus.plexus:plexus-interpolation:jar:1.21
[DEBUG]   Included: org.codehaus.plexus:plexus-utils:jar:3.0.22
[DEBUG]   Included: org.codehaus.plexus:plexus-component-annotations:jar:1.6
[DEBUG]   Included: org.sonatype.plexus:plexus-sec-dispatcher:jar:1.3
[DEBUG]   Included: org.sonatype.plexus:plexus-cipher:jar:1.4
[DEBUG]   Included: org.apache.commons:commons-lang3:jar:3.4
[DEBUG]   Included: org.apache.maven.reporting:maven-reporting-api:jar:3.0
[DEBUG]   Included: org.apache.maven.doxia:doxia-sink-api:jar:1.0
[DEBUG] Configuring mojo org.scalatest:scalatest-maven-plugin:2.0.0:test from plugin realm ClassRealm[plugin>org.scalatest:scalatest-maven-plugin:2.0.0, parent: jdk.internal.loader.Class
Loaders$AppClassLoader@6e5e91e4]
[DEBUG] Configuring mojo 'org.scalatest:scalatest-maven-plugin:2.0.0:test' with basic configurator -->
[DEBUG]   (f) debugForkedProcess = false
[DEBUG]   (f) debuggerPort = 5005
[DEBUG]   (f) forkMode = once
[DEBUG]   (f) forkedProcessTimeoutInSeconds = 0
[DEBUG]   (f) logForkedProcessCommand = false
[DEBUG]   (f) outputDirectory = C:\Git\scalatest-maven-plugin-experementation\base-example\target\classes
[DEBUG]   (f) project = MavenProject: com.stewarthutchins.scalatest.experementation:ideal-scenario:1.0-SNAPSHOT @ C:\Git\scalatest-maven-plugin-experementation\base-example\pom.xml
[DEBUG]   (f) reportsDirectory = C:\Git\scalatest-maven-plugin-experementation\base-example\target\scalatest-reports
[DEBUG]   (f) testOutputDirectory = C:\Git\scalatest-maven-plugin-experementation\base-example\target\test-classes
[DEBUG] -- end configuration --
[DEBUG] [-R, C:\Git\scalatest-maven-plugin-experementation\base-example\target\classes C:\Git\scalatest-maven-plugin-experementation\base-example\target\test-classes, -o]
[DEBUG] Forking ScalaTest via: cmd.exe /X /C "java -Dbasedir=C:\Git\scalatest-maven-plugin-experementation\base-example org.scalatest.tools.Runner -R "C:\Git\scalatest-maven-plugin-exper
ementation\base-example\target\classes C:\Git\scalatest-maven-plugin-experementation\base-example\target\test-classes" -o"
Error: Could not find or load main class org.scalatest.tools.Runner
Caused by: java.lang.ClassNotFoundException: org.scalatest.tools.Runner
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for ideal-scenario 1.0-SNAPSHOT:
[INFO]
[INFO] ideal-scenario ..................................... FAILURE [ 10.595 s]
[INFO] java-module ........................................ SKIPPED
[INFO] mixed-java-scala-module ............................ SKIPPED
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  11.898 s
[INFO] Finished at: 2020-01-03T21:46:33Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.scalatest:scalatest-maven-plugin:2.0.0:test (test) on project ideal-scenario: There are test failures -> [Help 1]
org.apache.maven.lifecycle.LifecycleExecutionException: Failed to execute goal org.scalatest:scalatest-maven-plugin:2.0.0:test (test) on project ideal-scenario: There are test failures
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:215)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:156)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:148)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:117)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:81)
    at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build (SingleThreadedBuilder.java:56)
    at org.apache.maven.lifecycle.internal.LifecycleStarter.execute (LifecycleStarter.java:128)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:305)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:192)
    at org.apache.maven.DefaultMaven.execute (DefaultMaven.java:105)
    at org.apache.maven.cli.MavenCli.execute (MavenCli.java:956)
    at org.apache.maven.cli.MavenCli.doMain (MavenCli.java:288)
    at org.apache.maven.cli.MavenCli.main (MavenCli.java:192)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
    at jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:566)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced (Launcher.java:282)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launch (Launcher.java:225)
    at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode (Launcher.java:406)
    at org.codehaus.plexus.classworlds.launcher.Launcher.main (Launcher.java:347)
Caused by: org.apache.maven.plugin.MojoFailureException: There are test failures
    at org.scalatest.tools.maven.TestMojo.execute (TestMojo.java:107)
    at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo (DefaultBuildPluginManager.java:137)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:210)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:156)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:148)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:117)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:81)
    at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build (SingleThreadedBuilder.java:56)
    at org.apache.maven.lifecycle.internal.LifecycleStarter.execute (LifecycleStarter.java:128)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:305)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:192)
    at org.apache.maven.DefaultMaven.execute (DefaultMaven.java:105)
    at org.apache.maven.cli.MavenCli.execute (MavenCli.java:956)
    at org.apache.maven.cli.MavenCli.doMain (MavenCli.java:288)
    at org.apache.maven.cli.MavenCli.main (MavenCli.java:192)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
    at jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:566)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced (Launcher.java:282)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launch (Launcher.java:225)
    at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode (Launcher.java:406)
    at org.codehaus.plexus.classworlds.launcher.Launcher.main (Launcher.java:347)
[ERROR]
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
```