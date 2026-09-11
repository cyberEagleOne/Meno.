# Meno — Technical Architecture

## 1. Overview

Meno is a native Android application designed to help users build a consistent Bible reading habit through guided reading journeys, daily reading, reminders, and lightweight gamification.

The MVP follows a **local-first architecture**.

The application does not require a backend server, user account, or cloud database for the core experience.

---

# 2. MVP Architecture Goals

The architecture should support the following core experience:

```text
Choose a Journey
       ↓
Read
       ↓
Complete
       ↓
Earn XP
       ↓
Maintain Streak
       ↓
Track Progress
       ↓
Continue
```

The architecture prioritizes:

1. Simplicity
2. Reliability
3. Maintainability
4. Clear separation of responsibilities
5. Offline-first functionality
6. Easy future expansion

---

# 3. Technology Stack

## Programming Language

**Kotlin**

Kotlin is the primary programming language for the Android application.

---

## UI Framework

**Jetpack Compose**

Jetpack Compose is used to build the application's user interface.

It allows Meno's design system to be implemented through reusable UI components.

---

## UI Foundation

**Material 3**

Material 3 provides foundational UI components and theming.

Meno will customize Material 3 through its own:

* Colors
* Typography
* Shapes
* Spacing
* Components

The application should not rely on the default Material 3 appearance.

---

## Architecture Pattern

**MVVM (Model–View–ViewModel)**

MVVM is used to separate UI presentation from application state and logic.

---

## Navigation

**Navigation Compose**

Used to manage navigation between Compose screens.

---

## Local Database

**Room**

Room is used for structured application data that changes during user activity.

Examples:

* XP
* Streak
* Reading progress
* Completed chapters
* Journey progress

---

## Preferences

**DataStore**

DataStore is used for small preference and configuration values.

Examples:

* Onboarding completion
* Reminder settings
* Selected preferences
* User configuration

---

## Asynchronous Programming

**Kotlin Coroutines**

Coroutines are used for asynchronous operations such as database access and other background work.

---

## Reactive Data

**Kotlin Flow**

Flow is used to observe changing application data and provide updated state to the UI.

Examples:

```text
XP changes
    ↓
Flow
    ↓
ViewModel
    ↓
UI updates
```

---

## Notifications

**WorkManager + Android Notification APIs**

WorkManager is used to schedule reminder-related background work.

The MVP uses local notifications and does not require a notification backend.

---

## Scripture Data

**Local bundled Scripture data**

ILT3.Yes Scripture content is stored locally within the application.

The Scripture content is separated from user-generated application data.

A dedicated Scripture data layer is used so that the UI does not directly depend on the raw Scripture file format.

---

## Testing

Recommended testing tools:

* JUnit
* Compose UI testing
* Android testing framework

Testing priority should focus on critical MVP functionality.

---

## Version Control

**Git + GitHub**

Git is used for source control and GitHub is used as the project's remote repository.

---

# 4. Architecture Overview

Meno follows a layered architecture:

```text
┌─────────────────────────────┐
│        Presentation         │
│                             │
│ Compose UI + ViewModels     │
└──────────────┬──────────────┘
               │
               ↓
┌─────────────────────────────┐
│           Domain            │
│                             │
│ Reading / XP / Streak Logic │
└──────────────┬──────────────┘
               │
               ↓
┌─────────────────────────────┐
│            Data             │
│                             │
│ Repositories + Local Data   │
└──────────────┬──────────────┘
               │
        ┌──────┴──────┐
        ↓             ↓
      Room       Scripture Data
        │
        ↓
    DataStore
```

The purpose of this separation is to prevent UI code from directly managing storage or complex application logic.

---

# 5. Presentation Layer

The presentation layer contains everything directly related to what the user sees and interacts with.

Main technologies:

* Jetpack Compose
* ViewModel
* Navigation Compose

Example screens:

```text
OnboardingScreen
HomeScreen
JourneyScreen
ReadingScreen
CompletionScreen
ProgressScreen
ProfileScreen
```

The UI should primarily:

* Display state
* Receive user interactions
* Trigger actions
* Navigate between screens

Business logic should not be placed directly inside Compose UI components.

---

# 6. ViewModel

Each major feature may have a ViewModel responsible for managing UI state and coordinating application logic.

Example:

```text
ReadingScreen
      ↓
ReadingViewModel
      ↓
ReadingRepository
```

The ViewModel may manage:

* Current chapter
* Current reading state
* Completion state
* Loading state
* Error state

For example:

```text
User taps "Complete Reading"
            ↓
ReadingViewModel
            ↓
Complete reading
            ↓
Update XP
            ↓
Update streak
            ↓
Save progress
            ↓
UI displays completion
```

---

# 7. Domain Layer

The domain layer contains the application's core rules and logic.

Important domain concepts include:

### Reading

Determines:

* What chapter the user should read
* Whether a chapter is complete
* What reading comes next

### XP

Determines:

* XP awarded for completion
* Current XP
* XP-related progress

### Streak

Determines:

* Current streak
* Whether today's reading continues the streak
* When a streak should be updated

### Progress

Determines:

* Completed chapters
* Journey progress
* Current reading position

The domain layer should not depend directly on Compose UI.

---

# 8. Data Layer

The data layer manages access to application data.

Main components:

```text
Repositories
    ↓
Local Data Sources
    ↓
Room / DataStore / Scripture Files
```

Repositories provide a clean interface between the rest of the application and the underlying storage.

---

# 9. Scripture Architecture

Scripture is treated as application content rather than user-generated data.

Recommended structure:

```text
data/
└── scripture/
    └── ilt3/
        └── ilt3.json
```

The exact file organization may be adjusted depending on the final Scripture dataset.

The application should access Scripture through a dedicated provider/repository.

Example:

```text
ReadingScreen
      ↓
ReadingViewModel
      ↓
ScriptureRepository
      ↓
ScriptureProvider
      ↓
ILT3 data
```

This prevents the Reading Screen from directly reading JSON files.

---

# 10. Scripture Data Model

The Scripture data should represent the hierarchy:

```text
Book
 ↓
Chapter
 ↓
Verse
```

Example conceptual structure:

```text
Genesis
 ├── Chapter 1
 │    ├── Verse 1
 │    ├── Verse 2
 │    └── Verse 3
 │
 └── Chapter 2
      ├── Verse 1
      └── Verse 2
```

The exact JSON structure will be determined after the final ILT3 dataset is prepared.

---

# 11. User Data

User-generated application data is stored separately from Scripture.

Conceptually:

```text
User Data
├── XP
├── Streak
├── Reading Progress
├── Completed Chapters
└── Journey Progress
```

This information is stored using Room where structured persistence is required.

---

# 12. Room Database

Room is responsible for persistent structured data.

Possible entities:

```text
UserProgress
ReadingProgress
JourneyProgress
ReadingHistory
```

The exact entities should remain minimal for the MVP.

Do not create database tables for features that are not yet implemented.

---

# 13. DataStore

DataStore is used for simple preferences.

Possible values:

```text
onboardingCompleted
selectedJourney
reminderEnabled
reminderTime
```

DataStore should not be used as the primary database for complex relational data.

---

# 14. Repository Pattern

Repositories provide a single access point for application data.

Examples:

```text
ScriptureRepository
ReadingRepository
ProgressRepository
SettingsRepository
```

For example:

```text
ReadingViewModel
       ↓
ReadingRepository
       ↓
ScriptureRepository + ProgressRepository
       ↓
Local Data
```

This makes the application easier to change later.

---

# 15. Reading Completion Flow

When a user completes a reading:

```text
User taps COMPLETE
        ↓
ReadingViewModel
        ↓
Validate reading
        ↓
Mark chapter complete
        ↓
Award XP
        ↓
Update streak
        ↓
Update progress
        ↓
Save data
        ↓
Show Completion Screen
```

The completion action should be treated as one logical application operation.

---

# 16. XP System

The MVP uses a simple XP system.

Example:

```text
Complete reading
       ↓
   +10 XP
```

The exact XP values can be adjusted during implementation.

XP should be stored persistently so it remains available when the application is reopened.

---

# 17. Streak System

The streak system is designed to encourage consistency.

Basic concept:

```text
Read today
    ↓
Continue streak

Read again tomorrow
    ↓
Streak +1
```

The application should store enough information to determine the user's last completed reading date.

The MVP should avoid overly complex streak recovery mechanics.

---

# 18. Reading Progress

Reading progress tracks where the user is within their selected journey.

Conceptually:

```text
Journey
  ↓
Chapter
  ↓
Completed?
```

Example:

```text
Beginner Journey

Genesis 1   ✓
Genesis 2   ✓
Genesis 3   → Current
Genesis 4   🔒
```

---

# 19. Navigation Architecture

Navigation is handled through Navigation Compose.

Conceptual navigation graph:

```text
Onboarding
    ↓
Home
    ↓
Journey
    ↓
Reading
    ↓
Completion
    ↓
Home
```

The next-day flow:

```text
Notification
     ↓
Open Meno
     ↓
Home
     ↓
Today's Reading
     ↓
Reading
     ↓
Completion
     ↓
Home
```

---

# 20. Notification Architecture

Meno uses local scheduled notifications.

Basic flow:

```text
User enables reminder
        ↓
Select reminder time
        ↓
Schedule local work
        ↓
WorkManager
        ↓
Android Notification
        ↓
User opens Meno
```

No backend push notification service is required for the MVP.

---

# 21. Dependency Management

The MVP should avoid unnecessary dependency injection complexity.

Manual dependency management is acceptable during the initial implementation.

A dependency injection framework such as Hilt can be introduced later if the project becomes large enough to justify it.

The goal is to keep the initial implementation understandable.

---

# 22. Project Structure

Recommended initial project structure:

```text
app/
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── meno/
        │           ├── data/
        │           │   ├── local/
        │           │   ├── scripture/
        │           │   └── repository/
        │           │
        │           ├── domain/
        │           │   ├── model/
        │           │   └── usecase/
        │           │
        │           ├── ui/
        │           │   ├── onboarding/
        │           │   ├── home/
        │           │   ├── journey/
        │           │   ├── reading/
        │           │   ├── completion/
        │           │   └── progress/
        │           │
        │           ├── navigation/
        │           │
        │           └── MainActivity.kt
        │
        └── assets/
            └── scripture/
                └── ilt3/
```

The exact package names may be adjusted when the Android project is initialized.

---

# 23. MVP Feature Mapping

| Feature            | Main Technology                |
| ------------------ | ------------------------------ |
| Onboarding         | Jetpack Compose + DataStore    |
| Journey Selection  | Compose + ViewModel            |
| Home               | Compose + ViewModel            |
| Scripture Reading  | Compose + Scripture Repository |
| ILT3 Content       | Local bundled data             |
| Reading Completion | ViewModel + Repository         |
| XP                 | Room                           |
| Streak             | Room                           |
| Reading Progress   | Room                           |
| Journey Progress   | Room                           |
| Reminder Settings  | DataStore                      |
| Daily Reminder     | WorkManager + Notifications    |
| Navigation         | Navigation Compose             |

---

# 24. Backend Decision

## MVP

**No backend.**

Meno does not currently require:

* User accounts
* Cloud synchronization
* Online authentication
* Server-side XP
* Social features
* Leaderboards
* Cloud database

The MVP can operate using local storage.

```text
                  MENO
                   │
          ┌────────┴────────┐
          ↓                 ↓
   Scripture Data       User Data
     Local                Local
      JSON             Room/DataStore
```

This reduces development complexity and allows the core experience to be completed within the project timeline.

---

# 25. Future Backend Possibility

A backend may be considered in a future version if Meno introduces:

* User accounts
* Cloud synchronization
* Multiple devices
* Online statistics
* Social features
* Leaderboards
* Remote content management

If this happens, the repository architecture allows the data source to be changed without completely rewriting the UI.

---

# 26. Development Strategy

Development should follow the user experience rather than building every technical layer first.

Recommended order:

### Phase 1 — Project Setup

* Create Android project
* Configure Kotlin
* Configure Jetpack Compose
* Configure Material 3
* Implement Meno theme
* Connect design system

### Phase 2 — Static UI

Build:

```text
Onboarding
Home
Journey
Reading
Completion
```

using the approved Stitch prototype and `design.md`.

### Phase 3 — Navigation

Connect:

```text
Onboarding
 ↓
Home
 ↓
Journey
 ↓
Reading
 ↓
Completion
```

### Phase 4 — Scripture

Add:

* ILT3 data
* Scripture model
* Scripture provider
* Scripture repository
* Reading screen integration

### Phase 5 — User Progress

Implement:

* XP
* Streak
* Reading completion
* Journey progress
* Persistent local storage

### Phase 6 — Reminder

Implement:

* Reminder settings
* Scheduled notifications
* Daily reading reminder

### Phase 7 — Testing

Test the complete main flow:

```text
Open Meno
 ↓
Onboarding
 ↓
Choose Journey
 ↓
Home
 ↓
Today's Reading
 ↓
Read
 ↓
Complete
 ↓
XP + Streak + Progress
 ↓
Close App
 ↓
Reopen App
 ↓
Data remains
```

---

# 27. MVP Success Criteria

The Meno MVP is considered successful when:

### Core Flow

The user can:

* Complete onboarding
* Select a reading journey
* Access today's reading
* Read Scripture
* Complete the reading
* Receive XP
* Maintain a streak
* See reading progress

### Persistence

User progress remains available after closing and reopening the application.

### Scripture

The application can reliably load and display the required ILT3 Scripture content.

### Reminder

The user can enable a daily reading reminder and receive a local notification.

### Device

The core application can run reliably on a real Android device.

---

# 28. Out of Scope for MVP

The following are intentionally excluded from the initial architecture:

* Audio Bible
* AI assistant
* Social features
* Leaderboards
* Multiple Bible translations
* Cloud synchronization
* User authentication
* Online accounts
* Complex recommendation systems

These may be considered in future versions.

---

# 29. Future Features

Potential future features include:

* Achievements
* Reading history
* Bookmarks
* Throwbacks / review
* Statistics
* Additional reading journeys
* Additional content types
* Cloud synchronization
* User accounts

These features should only be implemented after the core reading experience is stable.

---

# 30. Architecture Principles

The Meno project follows these principles:

### Keep It Simple

Do not introduce a technology unless the project needs it.

### Local First

The core experience should work without an internet connection whenever possible.

### Separate Content From User Data

Scripture content and user progress should remain separate.

### UI Should Not Own Business Logic

Compose screens should display state and respond to user interaction.

### Reuse Components

Common UI patterns should become reusable Meno components.

### Build for the MVP First

Future scalability should not make the current project unnecessarily complicated.

---

# 31. Final Architecture

The final MVP architecture can be summarized as:

```text
                         MENO
                          │
              ┌───────────┴───────────┐
              │                       │
        Presentation               Navigation
              │
      Jetpack Compose
              │
         ViewModels
              │
              ↓
           Domain
              │
       Reading / XP /
      Streak / Progress
              │
              ↓
            Data
              │
      ┌───────┼────────┐
      ↓       ↓        ↓
    Room   DataStore  Scripture
                     Local Data
```

## Official MVP Stack

```text
Language       → Kotlin
UI             → Jetpack Compose
UI Foundation  → Material 3
Architecture   → MVVM + Layered Architecture
Navigation     → Navigation Compose
Database       → Room
Preferences    → DataStore
Async          → Kotlin Coroutines
Reactive State → Kotlin Flow
Notifications  → WorkManager + Android Notifications
Scripture      → Local ILT3.Yes data
Testing        → JUnit + Compose UI Testing
Version Control→ Git + GitHub
Backend        → None for MVP
```

Meno's architecture is intentionally designed to be **simple enough for a student project while still being structured enough to support future development**.
