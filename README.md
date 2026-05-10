# JWebMP Session Storage Security

[![Maven Central](https://img.shields.io/maven-central/v/com.jwebmp.plugins/sessionstorage)](https://central.sonatype.com/artifact/com.jwebmp.plugins/sessionstorage)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue)](https://www.apache.org/licenses/LICENSE-2.0)

![Java 25+](https://img.shields.io/badge/Java-25%2B-green)
![Modular](https://img.shields.io/badge/Modular-JPMS-green)
![Angular](https://img.shields.io/badge/Angular-20-DD0031?logo=angular)
![JWebMP](https://img.shields.io/badge/JWebMP-2.0-0A7)

Provides access to read and write into the browser's session (per-tab) storage for tab-specific device identification and session management. Creates unique identifiers per browser tab via session storage, transported across WebSocket connections.

Built on JWebMP · [JWebMP Core](https://jwebmp.com/) · JPMS module `com.jwebmp.plugins.security.sessionstorage` · Java 25+

## Installation

```xml
<dependency>
  <groupId>com.jwebmp.plugins</groupId>
  <artifactId>sessionstorage</artifactId>
  <version>2.0.0-SNAPSHOT</version>
</dependency>
```

<details>
<summary>Gradle (Kotlin DSL)</summary>

```kotlin
implementation("com.jwebmp.plugins:sessionstorage:2.0.0-SNAPSHOT")
```
</details>

## Quick Start

### Prerequisites

- **Java 25 LTS** (required)
- **Maven 3.8+**
- **Node.js 18+** (for frontend builds)
- **Angular 21+** (auto-integrated via JWebMP)

### Basic Usage

The plugin auto-registers via ServiceLoader SPI. It automatically:
- Creates a unique per-tab identifier in the browser's session storage
- Transports session storage variables via WebSocket connections
- Provides `@Named("sessionstorage") UUID` and `@Named("sessionstorage") String` injection

```java
@Inject
@Named("sessionstorage")
private UUID tabId;
```

## Features

- **Zero Configuration** — Auto-registered via ServiceLoader SPI
- **Per-Tab Identification** — Unique UUID per browser tab via session storage
- **WebSocket Integration** — Session management via WebSocket message receiver
- **Guice Injection** — `@Named("sessionstorage")` UUID and String providers
- **JPMS Module** — Fully modular with explicit dependencies

## Testing

```bash
mvn clean test
```

## Links

- **GitHub Repository**: https://github.com/JWebMP/SessionStorage
- **Maven Central**: https://mvnrepository.com/artifact/com.jwebmp.plugins/sessionstorage
- **JWebMP Home**: https://jwebmp.com/

## License

Licensed under the [Apache License 2.0](LICENSE).

---

**Made with JWebMP**
