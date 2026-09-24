# Meno — Application Architecture

> **Meno — Read. Remain. Grow.**
>
> Technical architecture for the Meno Android MVP.

---

## 1. Architecture Overview

Meno is a native Android application designed to help users build a consistent Bible reading habit through guided reading journeys and lightweight gamification.

The MVP uses a **local-first architecture**, meaning the core application functionality works without requiring a backend, account, or internet connection.

The architecture is designed to be:

- Simple enough for the MVP development timeline
- Easy to understand and maintain
- Separated into clear responsibilities
- Testable
- Offline-capable
- Reusable
- Extensible for future development

### Core Architecture

```text
┌─────────────────────────────────────┐
│           Presentation              │
│                                     │
│  Jetpack Compose                    │
│  Screens                            │
│  Components                         │
│  ViewModels                         │
└──────────────────┬──────────────────┘
                   │
                   ▼
┌─────────────────────────────────────┐
│              Domain                 │
│                                     │
│  Business Models                    │
│  Use Cases                          │
│  Repository Interfaces              │
│  Business Rules                     │
└──────────────────┬──────────────────┘
                   │
                   ▼
┌─────────────────────────────────────┐
│               Data                  │
│                                     │
│  Repository Implementations         │
│  Room Database                      │
│  DataStore                          │
│  Scripture Provider                 │
│  Local Assets                       │
└─────────────────────────────────────┘
````

---

## 2. Architecture Goals

The architecture follows these main goals:

1. Keep the MVP simple enough to implement within the course timeline.
2. Separate UI, business logic, and data management.
3. Make the application work offline.
4. Avoid unnecessary backend infrastructure.
5. Make features easy to test and modify.
6. Keep the codebase understandable for a student development team.
7. Allow future expansion without requiring a complete rewrite.

---

## 3. Technology Stack

| Area              | Technology                      |
| ----------------- | ------------------------------- |
| Platform          | Android                         |
| Language          | Kotlin                          |
| UI                | Jetpack Compose                 |
| Design System     | Material 3 + Meno Design System |
| Architecture      | Layered Architecture            |
| State Management  | StateFlow                       |
| Navigation        | Navigation Compose              |
| Local Database    | Room                            |
| Preferences       | DataStore                       |
| Async Operations  | Kotlin Coroutines               |
| Background Tasks  | WorkManager                     |
| Notifications     | Android Notifications           |
| Scripture Storage | Local JSON / bundled assets     |
| Build System      | Gradle                          |
| Version Control   | Git + GitHub                    |

The MVP intentionally avoids:

* Backend servers
* User authentication
* Cloud databases
* Cloud synchronization
* Social APIs
* Online leaderboards

---

## 4. Application Architecture

Meno follows a three-layer architecture:

```text
Presentation
     │
     ▼
Domain
     │
     ▼
Data
```

### Presentation

Responsible for:

* Displaying UI
* Handling user interaction
* Collecting UI state
* Calling ViewModels

### Domain

Responsible for:

* Application rules
* Use cases
* Business logic
* Domain models
* Repository contracts

### Data

Responsible for:

* Persistent storage
* Scripture data
* Room database
* DataStore
* Repository implementations

---

## 5. Presentation Layer

The presentation layer uses **Jetpack Compose**.

Main responsibilities:

* Render screens
* Display application state
* Receive user interactions
* Trigger ViewModel actions
* Navigate between screens

The UI should not directly access:

* Room DAOs
* DataStore
* JSON files
* Repository implementations

Instead:

```text
Composable
    ↓
ViewModel
    ↓
Use Case
    ↓
Repository
    ↓
Data Source
```

---

## 6. ViewModel Architecture

Each major screen can have its own ViewModel when state management becomes complex.

Example:

```text
HomeViewModel
JourneyViewModel
ReadingViewModel
ProgressViewModel
ProfileViewModel
```

ViewModels are responsible for:

* Loading data
* Calling use cases
* Managing UI state
* Handling user actions
* Exposing StateFlow

Example conceptual flow:

```text
HomeScreen
     │
     ▼
HomeViewModel
     │
     ▼
GetTodaysReadingUseCase
     │
     ▼
ReadingRepository
```

Business logic should not be placed directly inside Composable functions.

---

## 7. UI State

Each screen should expose a clear UI state.

Example:

```kotlin
data class HomeUiState(
    val isLoading: Boolean = false,
    val todaysReading: Reading? = null,
    val currentStreak: Int = 0,
    val totalXp: Int = 0,
    val errorMessage: String? = null
)
```

Possible states include:

```text
Loading
Success
Empty
Error
```

This keeps UI behavior predictable and easier to test.

---

## 8. Domain Layer

The domain layer contains the application's core logic.

It should not depend directly on:

* Jetpack Compose
* Android UI components
* Room implementation
* DataStore implementation

The domain layer contains:

```text
Domain
├── model
├── repository
└── usecase
```

Example:

```text
domain/
├── model/
│   ├── Reading.kt
│   ├── Journey.kt
│   ├── UserProgress.kt
│   └── ReadingProgress.kt
│
├── repository/
│   ├── ScriptureRepository.kt
│   ├── ReadingRepository.kt
│   ├── JourneyRepository.kt
│   ├── ProgressRepository.kt
│   └── SettingsRepository.kt
│
└── usecase/
    ├── GetTodaysReadingUseCase.kt
    ├── CompleteReadingUseCase.kt
    ├── GetJourneyProgressUseCase.kt
    ├── CalculateXpUseCase.kt
    └── UpdateStreakUseCase.kt
```

---

## 9. Use Cases

Use cases represent specific actions or operations within Meno.

Initial MVP use cases:

### Reading

```text
GetTodaysReadingUseCase
GetReadingUseCase
CompleteReadingUseCase
```

### Journey

```text
GetJourneyUseCase
GetJourneyProgressUseCase
```

### Progress

```text
GetReadingProgressUseCase
GetUserProgressUseCase
CalculateXpUseCase
UpdateStreakUseCase
```

### Reminder

```text
GetReminderSettingsUseCase
SaveReminderSettingsUseCase
```

Use cases should represent meaningful application behavior rather than simply duplicating database operations.

---

## 10. Data Layer

The data layer manages persistent and local data.

Main components:

```text
Data
├── local
│   ├── room
│   └── datastore
│
├── scripture
│   └── local assets
│
├── repository
│
└── mapper
```

The data layer implements the repository interfaces defined in the domain layer.

---

## 11. Room Database

Room is used for structured application data that needs to persist between sessions.

Room is appropriate for:

* Reading progress
* Journey progress
* XP
* Streak
* Reading history
* User progress

### Main Entities

```text
UserProgressEntity
ReadingProgressEntity
JourneyProgressEntity
ReadingHistoryEntity
```

### Example

```kotlin
@Entity(tableName = "user_progress")
data class UserProgressEntity(
    @PrimaryKey
    val id: Int = 1,

    val totalXp: Int,
    val currentStreak: Int,
    val longestStreak: Int,
    val lastReadingDate: String?
)
```

The exact implementation may change during development.

---

## 12. DataStore

DataStore is used for lightweight preferences and settings.

Examples:

```text
onboardingCompleted
selectedJourneyId
reminderEnabled
reminderTime
```

DataStore should not be used for large structured datasets.

The separation is:

```text
Room
→ structured persistent application data

DataStore
→ lightweight preferences/settings
```

---

## 13. Repository Pattern

Repositories provide an abstraction between the domain layer and the data layer.

Example:

```text
UI
 ↓
ViewModel
 ↓
Use Case
 ↓
Repository Interface
 ↓
Repository Implementation
 ↓
Room / DataStore / Local Asset
```

Example:

```kotlin
interface ProgressRepository {
    suspend fun getUserProgress(): UserProgress
    suspend fun updateUserProgress(progress: UserProgress)
}
```

The implementation may use Room internally without exposing Room details to the domain layer.

---

## 14. Scripture Architecture

Scripture content is bundled locally with the application.

The MVP does not require an online Scripture API.

Example asset structure:

```text
app/
└── src/
    └── main/
        └── assets/
            └── scripture/
                └── ilt3/
                    └── ilt3.json
```

The application loads Scripture content from the local asset.

Basic hierarchy:

```text
Bible
 └── Book
      └── Chapter
           └── Verse
```

The Scripture provider is responsible for reading and parsing the local Scripture data.

---

## 15. Scripture Data Model

A simplified Scripture model can be represented as:

```text
Book
├── id
├── name
└── chapters

Chapter
├── number
└── verses

Verse
├── number
└── text
```

Reading selections should reference Scripture using structured identifiers rather than storing large amounts of Scripture text in progress tables.

For example:

```text
Book: John
Chapter: 1
Start Verse: 1
End Verse: 18
```

---

## 16. Reading Architecture

A reading represents one unit of the user's guided reading plan.

Example:

```text
Reading
├── id
├── journeyId
├── book
├── chapter
├── startVerse
├── endVerse
└── order
```

Example:

```text
Reading #1
Journey: Gospel Starter
Book: John
Chapter: 1
Verses: 1–18
Order: 1
```

The Reading model connects the journey structure with the Scripture provider.

---

## 17. Journey Architecture

A journey is a structured collection of readings.

Example:

```text
Journey
├── id
├── name
├── description
└── readings
```

Example journey:

```text
Gospel Starter
│
├── Reading 1
├── Reading 2
├── Reading 3
├── Reading 4
└── ...
```

Journey data can initially be bundled locally because the MVP does not require a backend.

---

## 18. Progress Architecture

Meno separates progress into three main concepts:

### User Progress

Tracks overall user activity.

```text
User Progress
├── total XP
├── current streak
├── longest streak
└── last reading date
```

### Journey Progress

Tracks progress within a selected journey.

```text
Journey Progress
├── journey ID
├── completed readings
└── progress percentage
```

### Reading Progress

Tracks whether an individual reading has been completed.

```text
Reading Progress
├── reading ID
├── completed
└── completedAt
```

This separation makes progress easier to calculate and display.

---

## 19. Reading Completion Flow

When a user completes a reading:

```text
User taps "Complete"
        │
        ▼
CompleteReadingUseCase
        │
        ├── Check if already completed
        │
        ├── Mark reading completed
        │
        ├── Calculate XP
        │
        ├── Update streak
        │
        ├── Update journey progress
        │
        └── Persist changes
        │
        ▼
CompletionScreen
```

The completion process should avoid awarding XP multiple times for the same reading.

---

## 20. XP System

The MVP uses a simple XP system.

Example:

```text
Complete reading
        ↓
      +10 XP
```

The exact XP value can be adjusted later.

The MVP should avoid overly complex mechanics such as:

* XP multipliers
* Skill trees
* Energy systems
* Hearts
* Complex reward economies

The goal is to encourage consistency rather than create unnecessary complexity.

---

## 21. Streak System

The streak system measures consecutive reading days.

Basic logic:

```text
Read today
    │
    ├── Yesterday was a reading day
    │       ↓
    │   Increase streak
    │
    └── Otherwise
            ↓
        Start streak
```

The MVP does not require:

* Streak freezes
* Streak recovery
* Complex grace periods
* Social streak comparison

A basic consecutive-day implementation is sufficient.

---

## 22. Navigation Architecture

Navigation Compose manages movement between major screens.

Main routes:

```text
onboarding
home
journey/{journeyId}
reading/{readingId}
completion
progress
profile
```

Conceptual navigation:

```text
Onboarding
    │
    ▼
Home
    │
    ├── Journey
    │     │
    │     ▼
    │   Reading
    │     │
    │     ▼
    │   Completion
    │
    ├── Progress
    │
    └── Profile
```

Navigation arguments should use stable identifiers such as:

```text
journeyId
readingId
```

rather than passing large objects between screens.

---

## 23. Reminder Architecture

Meno uses local Android notifications for reading reminders.

Flow:

```text
User changes reminder settings
        │
        ▼
SaveReminderSettingsUseCase
        │
        ▼
DataStore
        │
        ▼
WorkManager
        │
        ▼
Android Notification
```

The reminder system should support:

* Enable / disable reminder
* Select reminder time
* Schedule local reminder

The MVP does not require a remote notification service.

---

## 24. Offline Architecture

Meno is designed as an offline-first application.

The following should work without an internet connection:

* Opening the application
* Viewing the current journey
* Reading Scripture
* Completing readings
* Updating XP
* Updating streak
* Viewing progress
* Managing reminder settings

Because Scripture content and core application data are local, the MVP does not depend on network availability.

---

## 25. Project Structure

Recommended Android project structure:

```text
app/
└── src/
    └── main/
        ├── java/
        │   └── com.meno.app/
        │       │
        │       ├── data/
        │       │   ├── local/
        │       │   │   ├── room/
        │       │   │   └── datastore/
        │       │   │
        │       │   ├── repository/
        │       │   ├── scripture/
        │       │   └── mapper/
        │       │
        │       ├── domain/
        │       │   ├── model/
        │       │   ├── repository/
        │       │   └── usecase/
        │       │
        │       ├── ui/
        │       │   ├── components/
        │       │   ├── theme/
        │       │   ├── onboarding/
        │       │   ├── home/
        │       │   ├── journey/
        │       │   ├── reading/
        │       │   ├── completion/
        │       │   ├── progress/
        │       │   └── profile/
        │       │
        │       ├── navigation/
        │       │
        │       ├── reminder/
        │       │
        │       └── MainActivity.kt
        │
        └── assets/
            └── scripture/
                └── ilt3/
                    └── ilt3.json
```

The structure may be simplified during early development if some packages are not yet needed.

---

## 26. Dependency Rules

The following dependency rules should be maintained:

```text
Presentation
     ↓
Domain
     ↓
Data
```

### Presentation can depend on:

* Domain models
* Domain use cases
* UI components
* Navigation

### Domain can depend on:

* Domain models
* Repository interfaces
* Use cases

### Data can depend on:

* Domain repository interfaces
* Domain models
* Room
* DataStore
* Android APIs
* Local assets

### Presentation should NOT directly access:

```text
Room
DataStore
JSON files
Repository implementations
```

This prevents the UI from becoming tightly coupled to implementation details.

---

## 27. MVP Feature Mapping

| Feature            | Main Architecture            |
| ------------------ | ---------------------------- |
| Onboarding         | Compose + DataStore          |
| Reading Journey    | Compose + Journey Repository |
| Daily Reading      | Compose + Reading Repository |
| Scripture Reader   | Compose + Scripture Provider |
| Reading Completion | Use Case + Room              |
| XP                 | Progress Repository          |
| Streak             | Progress Repository          |
| Progress Tracking  | Room + ViewModel             |
| Reminders          | DataStore + WorkManager      |
| Mascot             | Compose UI                   |
| Local Scripture    | Assets                       |
| Offline Usage      | Local-first architecture     |

---

## 28. Error Handling

The MVP should provide basic error handling for common cases.

Examples:

```text
Scripture failed to load
        ↓
Show readable error state
        ↓
Allow retry
```

Possible error states:

* Scripture unavailable
* Reading not found
* Journey not found
* Database operation failed
* Invalid navigation ID

Errors should not cause the application to crash when they can be handled gracefully.

---

## 29. Loading and Empty States

Screens that load persistent or local data should support appropriate states.

### Loading

```text
Loading
  ↓
Display progress indicator
```

### Success

```text
Data available
  ↓
Display content
```

### Empty

```text
No data
  ↓
Display helpful empty state
```

### Error

```text
Error
  ↓
Display message
  ↓
Retry
```

The UI should avoid exposing technical error messages directly to users.

---

## 30. Testing Strategy

The MVP should use a practical testing strategy rather than attempting exhaustive coverage.

### Unit Tests

Focus on:

* XP calculation
* Streak calculation
* Reading completion
* Journey progress
* Data mapping
* Use cases

Example:

```text
Given:
Reading is not completed

When:
CompleteReadingUseCase is executed

Then:
Reading becomes completed
XP increases
Journey progress updates
```

### UI Tests

Important flows:

```text
Onboarding → Home
Home → Reading
Reading → Completion
Completion → Home
Home → Progress
Profile → Reminder Settings
```

---

## 31. Development Strategy

Development should be incremental.

### Phase 1 — Foundation

Implement:

* Android project
* Compose
* Theme
* Navigation
* Basic project structure

### Phase 2 — Core Reading

Implement:

* Scripture provider
* Journey data
* Reading screen
* Completion flow

### Phase 3 — Progress

Implement:

* Room
* XP
* Streak
* Journey progress
* Progress screen

### Phase 4 — Engagement

Implement:

* Mascot
* Animations
* Completion feedback
* Reminder system

### Phase 5 — Polish

Implement:

* Error states
* Loading states
* Accessibility improvements
* UI consistency
* Testing
* Bug fixing

---

## 32. Git Workflow

The project uses Git and GitHub for version control.

Recommended branch structure:

```text
main
│
├── feature/onboarding
├── feature/reading
├── feature/progress
├── feature/reminder
└── feature/ui-polish
```

Commits should be small and descriptive.

Examples:

```text
feat: add onboarding flow
feat: add scripture reader
feat: implement reading completion
feat: add XP tracking
feat: add streak calculation
feat: add reminder scheduling
fix: prevent duplicate XP rewards
style: refine reading screen UI
docs: update architecture documentation
```

---

## 33. Future Expansion

The architecture intentionally leaves room for future features.

Possible future additions:

### Authentication

```text
Authentication
     ↓
User Account
```

### Cloud Sync

```text
Local Database
      ↕
Cloud Backend
```

### Social Features

```text
Friends
Leaderboards
Shared Progress
```

### Additional Scripture Features

```text
Multiple translations
Bookmarks
Highlights
Notes
Search
Audio
```

### Advanced Analytics

```text
Reading statistics
Weekly activity
Monthly activity
Completion trends
```

These features are outside the MVP scope.

---

## 34. MVP Scope

The MVP focuses on one clear problem:

> Helping users build a consistent Bible reading habit.

### Included

* Onboarding
* Guided reading journey
* Daily reading
* Scripture reading
* Reading completion
* XP
* Streak
* Progress tracking
* Local reminders
* Mascot / visual feedback
* Offline functionality
* Local Scripture data

### Not Included

* Backend
* Authentication
* User accounts
* Cloud synchronization
* Social network
* Leaderboards
* AI assistant
* Audio Bible
* Online community
* Advanced analytics
* Multiple device synchronization
* Complex reward economy

Keeping these features outside the MVP prevents unnecessary architectural complexity.

---

## 35. Architecture Principles

Meno follows several core principles.

### 1. Keep It Simple

Do not introduce infrastructure that is not required by the MVP.

### 2. Local First

Core functionality should remain available without an internet connection.

### 3. Separation of Concerns

UI, business logic, and data access should have clear responsibilities.

### 4. Reusable Components

Common UI and business functionality should be reusable.

### 5. Testable Logic

Important business rules should exist outside Composable functions.

### 6. Progressive Complexity

Only introduce more complex architecture when the feature actually requires it.

### 7. Future-Friendly

The MVP should allow future backend and synchronization features without forcing them into the initial implementation.

---

## 36. Architecture Summary

The final Meno MVP architecture can be summarized as:

```text
                    ┌──────────────────┐
                    │      Meno UI     │
                    │  Jetpack Compose │
                    └────────┬─────────┘
                             │
                             ▼
                    ┌──────────────────┐
                    │    ViewModels    │
                    │   StateFlow      │
                    └────────┬─────────┘
                             │
                             ▼
                    ┌──────────────────┐
                    │     Use Cases    │
                    │     Domain       │
                    └────────┬─────────┘
                             │
                             ▼
                    ┌──────────────────┐
                    │   Repositories   │
                    └────────┬─────────┘
                             │
              ┌──────────────┼──────────────┐
              ▼              ▼              ▼
        ┌──────────┐   ┌───────────┐  ┌─────────────┐
        │   Room   │   │ DataStore │  │  Scripture  │
        │ Database │   │ Preferences│  │ Local Asset │
        └──────────┘   └───────────┘  └─────────────┘
```

### Core Flow

```text
User
 ↓
Compose UI
 ↓
ViewModel
 ↓
Use Case
 ↓
Repository
 ↓
Local Data
 ↓
Updated State
 ↓
Compose UI
```

This architecture provides Meno with a lightweight, maintainable, offline-first foundation while keeping the MVP small enough to implement within the course project timeline.

---

## End

```
