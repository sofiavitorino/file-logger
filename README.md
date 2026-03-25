# File Logger

A Java logging system that records events with severity levels, persists to file with formatted timestamps, and automatically rotates log files when they reach a size limit.

Inspired by log management behavior in z/OS environments (SA z/OS / OPS/MVS), where log datasets are automatically rotated to prevent disk exhaustion in continuous production systems.

Features: generates random log events in real time, classifies events by severity (INFO, WARNING, ERROR), writes to file with append mode, rotates log files automatically on size limit with timestamp-based naming.

```
[2026-03-25 16:47:49] [ERROR] High memory usage
[2026-03-25 16:47:50] [INFO ] User authentication failed.
[2026-03-25 16:47:51] [WARNING] CPU usage over threshold
[LOG ROTATOR] File rotated: app_2026-03-25_164759.log
[2026-03-25 16:47:52] [INFO ] Backup completed successfully.
```

Running locally:
```
git clone https://github.com/sofiavitorino/file-logger.git
cd file-logger
mvn compile
mvn exec:java -Dexec.mainClass="com.sofia.filelogger.Main"
```

Java 21+ and Maven required.

---

Concepts practiced: File I/O, enums, separation of concerns, `LocalDateTime`, real-time application simulation.
