apply(plugin = "maven-publish")
apply(plugin = "signing")

group = "com.github.grigorevp"
version = "1.0.4"


afterEvaluate {
    configure<PublishingExtension> {
        publications {
            forEach {
                (it as? MavenPublication)?.pom {
                    name.set("native-defaults")
                    description.set("KMM implementation of user's preferences storage API")
                    url.set("https://github.com/grigorevp/native-defaults")
                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    developers {
                        developer {
                            id.set(findProperty("NEXUS_USERNAME") as? String)
                            name.set("Petr Grigorev")
                            email.set("grigoryev.pete@gmail.com")
                        }
                    }
                    scm {
                        connection.set("https://github.com/grigorevp/native-defaults.git")
                        developerConnection.set("git@github.com:grigorevp/native-defaults.git")
                        url.set("https://github.com/grigorevp/native-defaults")
                    }
                }
            }
        }

        repositories {
            maven {
                url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
                credentials {
                    username = findProperty("NEXUS_USERNAME") as? String
                    password = findProperty("NEXUS_PASSWORD") as? String
                }
            }
        }
    }

    configure<org.gradle.plugins.signing.SigningExtension> {
        configure<PublishingExtension> {
            sign(this.publications)
        }
    }
}