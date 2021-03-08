[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.grigorevp/native-defaults/badge.svg)](https://search.maven.org/artifact/com.github.grigorevp/native-defaults/1.0.5/jar)
[![Kotlin](https://img.shields.io/badge/kotlin-1.4.30-success)](https://plugins.jetbrains.com/plugin/6954-kotlin/versions)

# native-defaults

### Overview
A simple KMM implementation of user's preferences storage API, using SharedPreferences for Android and UserDefaults for iOS.

### Add dependency
Specify a dependency in your `commonMain` part to add `native-defaults` to your project:
```kotlin
implementation("com.github.grigorevp:native-defaults:${latestVersion}")
```
Don't forget to include `mavenCentral()` in repository list if it's not already there.

### Use in common module
To start working with `native-defaults` one should firstly initialize an instance. You can either use standard initializer to store defaults in a standard domain (persistence) or specify a name, to create isolated domains:
```kotlin
//This will create an instance holding standard domain
val defaults = NativeDefaults()

//This will create an instance for a domain with a specified name:
val myDefaults = NativeDefaults("MyRepo")
```
Please avoid specifying `"Standard"` domain name as it is reserved and will throw an error.

To add values to the perisitence domain use:

```kotlin
defaults.setString(key: String, value: String)

defaults.setInt(key: String, value: Int)

defaults.setFloat(key: String, value: Float)

defaults.setBoolean(key: String, value: Boolean)

defaults.setStringSet(key: String, value: Set<String>)
```

To get values use:

```kotlin
defaults.getString(key: String): String?

defaults.getInt(key: String): Int?

defaults.getFloat(key: String): Float?

defaults.getBoolean(key: String): Boolean?

defaults.getStringSet(key: String): Set<String>?
```

To clear a value for key use:

```kotlin
defaults.clearValue(key: String)
```

