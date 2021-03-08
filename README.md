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
setString(key: String, value: String)

setInt(key: String, value: Int)

setFloat(key: String, value: Float)

setBoolean(key: String, value: Boolean)

setStringSet(key: String, value: Set<String>)
```

To get values use:

```kotlin
getString(key: String): String?

getInt(key: String): Int?

getFloat(key: String): Float?

getBoolean(key: String): Boolean?

getStringSet(key: String): Set<String>?
```

To clear a value for key use:

```kotlin
clearValue(key: String)
```

