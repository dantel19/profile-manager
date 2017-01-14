#Profile Manager
<sub>*User preferences are different from each other and constantly evolving. Every person has different interests and if they all look the same object each of us looks different aspects of it.*</sub>

**Profile Manager** is a Java Web. It allows registered users of a service to specify a few simple preferences (e.g., preferences on their work or on their passions) to automatically define the type of their profile and the associated informations of interest to the user.

**Profile Manager** is a support tool to the analysis carried out in a particular case study (about the users profiling in the field of Smart Mobility and Tourism) of a European project called [INCIPICT](http://incipict.univaq.it/)

##Pre-Requisites

1. JDK 1.8

  > JDK 1.8 or later

2. Maven 3

  > Profile Manager is a Maven application. Apache Maven is a software project management and comprehension tool. Can you download Maven [here](https://maven.apache.org/download.cgi)
  
##Technologies

 1. Spring [version 4.2.8.RELEASE]
 2. Apache Tiles [version 3.0.7]
 3. JSP [version 2.3.1]

##Getting Starded
in order to generate the bundle open your terminal and type the following command:

    mvn -P build-tomcat

This will generate a .zip file output that will be reached in the path /profile-manager/target/ called **profile-manager-[version].zip**

Now you can simply unzip the file and run the server with a double click on the file **./bin/startup.bat** (for Windows) or **./bin/startup.sh** (for Unix-based Systems)

Your web application is reachable by this URL:

    http://localhost:9091/profilemanager/

##License
Licensed under the GPL version 3.0 license.
