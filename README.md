# amos-ss16-proj1
This is a project at the FU Berlin which aims at continuously testing consistency and correctness of ticket prices generated by the Deutsche Bahn ticket sales system.


## Installing

### Using Eclipse

Use the gradle wrapper (or your local gradle installation) and execute the following task:

```
gradle eclipse
```

Then, in Eclipse, use `File -> Import ...`, select `Existing Projects into Workspace` and navigate to the project directory and press `Finish`.

Note: since the Buildship Gradle plugin for Eclipse does not support web projects, only the classic option using the Gradle `eclipse-wtp` is viable.

### Using IntelliJ IDEA Ultimate

Use `Import Project`, navigate  to the project directory and select it. Use `Import project from external model` and select `Gradle`. Use the default settings in the following view and press `Finish`. In the navigation bar, use the run/debug configuration selector and press `Edit configurations...`. Click the `+`-button and select `Tomcat Server -> Local`. Configure the server by navigating to your Tomcat installation directory. In the `Deployment` tab, use the `+`-button to add the Gradle-generated WAR file. Press `OK` to apply your configuration.
