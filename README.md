# MENO

> **Read. Remain. Grow.**

MENO is a gamified Bible-reading mobile application designed to help beginners start reading Scripture, follow a guided reading journey, and build a consistent daily reading habit.

---

## 📌 Project Overview

### Problem

Starting to read the Bible can be overwhelming, especially for beginners. Users may not know where to start, which books or passages to read first, or how to maintain a consistent reading habit.

Traditional Bible-reading applications may also provide many features that can make the experience feel overwhelming for users who simply want a clear and guided way to start reading.

MENO addresses this problem by providing a simple and structured reading experience. Instead of focusing on theology, extensive Bible interpretation, or complex features, MENO focuses on helping users **start reading and continue reading consistently**.

### Core Experience

**Choose a Journey → Read → Complete → Earn XP → Maintain Streak → Track Progress → Continue**

---

## 👤 Target Users

MENO is primarily designed for:

* Beginners who want to start reading the Bible.
* Young adults and university students.
* Users who have difficulty maintaining a consistent daily reading habit.
* Users who prefer simple, guided, and interactive mobile experiences.
* Users who need a clear starting point rather than choosing Scripture passages by themselves.

---

## 💡 Benefits of the Application

MENO provides the following benefits:

* Gives beginners a clear starting point for reading the Bible.
* Provides a structured reading journey so users know what to read next.
* Encourages users to develop a consistent daily reading habit.
* Makes reading progress easier to understand and track.
* Uses lightweight gamification such as XP and streaks to encourage consistency.
* Provides daily reminders to help users return to their reading.
* Keeps the experience simple and focused on reading rather than overwhelming users with unnecessary features.

---

## 🚀 Core Features

The following features are the main features planned to be implemented within the 12-meeting project period.

### 1. User Onboarding

Introduces MENO to new users and guides them through the initial setup.

### 2. Reading Journey Selection

Allows users to choose where they want to start their Bible-reading journey.

### 3. Guided Daily Reading

Provides users with a specific Scripture reading for each day based on their selected journey.

### 4. Scripture Reading Interface

Provides a simple interface for users to read the assigned Scripture passage.

### 5. Reading Completion

Allows users to mark their daily reading as completed.

### 6. XP System

Users receive XP after successfully completing their daily reading.

### 7. Reading Streak

Tracks consecutive days of completed Bible reading to encourage consistency.

### 8. Progress Tracking

Shows the user's progress through their selected reading journey.

### 9. Local Data Storage

Stores essential user progress, such as completed readings, XP, streaks, and selected reading journey locally on the device.

### 10. Reading Reminder

Provides a daily reminder to encourage users to return to MENO and complete their reading.

---

## 🚫 Out of Scope

To keep the project realistic and achievable within the 12-meeting academic project period, the following features will **not** be implemented:

* User accounts and cloud synchronization.
* Social or community features.
* Online multiplayer or competitive features.
* Leaderboards.
* AI-generated Bible interpretation or theological analysis.
* Extensive theological explanations.
* Advanced Bible search.
* Multiple Bible translation support.
* Payment or subscription systems.
* Complex achievement and reward systems.
* Advanced reading analytics.
* Full social sharing functionality.

These features may be considered as future development ideas but are outside the scope of the current project.

---

## ✅ Success Criteria

MENO will be considered successfully implemented when the core user flow can be completed from onboarding to daily reading completion.

The application is considered successful if users can:

* Complete the onboarding process.
* Choose a reading journey.
* Access their assigned daily Scripture.
* Read the assigned Scripture passage.
* Mark the reading as completed.
* Receive XP after completing the reading.
* View and maintain their reading streak.
* View their reading progress.
* Receive a daily reading reminder.
* Continue their reading journey on the following day.

From a technical and project perspective, the application should be able to perform the core reading flow using locally stored data without requiring a cloud-based account system.

---

## 📖 Scripture Data

MENO is planned to use the **Indonesian Literal Translation 3 (ILT3)** as its Scripture text source.

Scripture data will be organized using the following structure:

**Book → Chapter → Verse**

The use and distribution of Scripture text will follow the applicable copyright and distribution permissions.

---

## 🛠️ Technology Stack

* **Platform**: Native Android
* **Language**: Kotlin
* **UI Framework**: Jetpack Compose + Material 3
* **Navigation**: Navigation Compose
* **Local Database**: Room
* **Preferences**: DataStore
* **Background Tasks**: WorkManager
* **Async Operations**: Kotlin Coroutines + Flow
* **Build System**: Gradle (Version Catalog `libs.versions.toml`)

---

## 🗺️ Development Roadmap

MENO is being developed as an individual academic project over a **12-meeting development period**.

### Phase 1 — Define

* Problem identification
* Target user definition
* Application concept
* Feature scope
* Main user flow
* Screen planning
* Flowchart development

### Phase 2 — Design & Build

* UI structure & Design System (Meno Theme)
* Navigation graph & placeholder screens
* Layered Architecture (Domain, Data, Presentation)
* Scripture asset provider setup
* Local data storage foundation (Room & DataStore)
* Reading reminder notification worker foundation

### Phase 3 — Implement & Test

* XP system & Streak calculations
* Scripture JSON parser & reading plan population
* Progress tracking integration
* Reading reminders scheduling
* Functional testing & UI refinement

### Phase 4 — Finalize

* Bug fixing
* Final testing
* APK build
* Documentation
* Project presentation
* Final demonstration

---

## 📱 Project Status

**Current Status: 🟡 In Development**

### Week 1
* Problem identified
* Target users defined
* Application concept defined
* Core features identified
* Project scope defined
* Main user flow planned

### Week 2
* Created initial Android project structure & 3-layer local-first architecture (Domain, Data, Presentation)
* Configured Meno design system tokens (Colors, Typography, Shapes, Theme) in Jetpack Compose
* Implemented Navigation Compose graph with placeholder screen structures (Onboarding, Home, Journey, Reading, Completion, Progress, Profile)
* Created Room database entities/DAOs, DataStore preferences, Repository contracts, and WorkManager notification worker foundation

### Next Steps
* Integrate ILT3 Scripture dataset JSON
* Implement Room database persistence & reading plan data
* Wire up XP calculation, streak logic, and WorkManager reminder scheduling

---

## 🎓 Academic Context

MENO is an individual mobile application project developed for the **Pemrograman Mobile** course.

The project follows an iterative development process involving:

* Planning
* Design
* AI-assisted development
* Self-review
* Peer review
* Testing
* Documentation
* Regular progress evidence

AI tools may be used during development for brainstorming, scaffolding, debugging, testing ideas, and code review. All generated code is reviewed, tested, understood, and modified when necessary.

---

## 👤 Author

**Cyril Natasha Setiawan**

Informatics Technology Student
Pradita University

---

## 📄 License

This project is developed for educational and portfolio purposes.

See the project documentation for information regarding third-party software, libraries, and Scripture data.
