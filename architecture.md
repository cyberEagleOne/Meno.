# Meno — Application Architecture

> **Meno — Read. Remain. Grow.**
>
> Technical architecture specification for the Meno Flutter MVP.

---

## 1. Architecture Overview

Meno is a cross-platform mobile application (built with Flutter/Dart, targeting Android-first with iOS-compatible architecture) designed to help users build a consistent Bible reading habit through guided reading journeys and lightweight gamification.

The application uses a **local-first architecture**, meaning all core application functionality works without requiring a backend server, user account, or active internet connection.

The architecture follows a **feature-oriented layered hybrid approach**, designed to maintain proportionality with a university MVP scope while ensuring clean separation of concerns, testability, maintainability, and clear feature boundaries.

```text
Flutter + Dart
        │
        ▼
Feature-oriented Presentation (Widgets / Views)
        │
        ▼
Provider / ChangeNotifier (State Management)
        │
        ▼
Repositories / Services (Data Abstraction)
        │
        ▼
Local Persistence (SharedPreferences + Hive + Local Assets)
```

---

## 2. Technology Stack

| Area | Selected Technology | Justification / Role |
| :--- | :--- | :--- |
| **Framework** | Flutter (Dart) | Cross-platform, rapid UI development, strong widget system |
| **Target Platform** | Android-first (iOS compatible) | University course target with cross-platform scalability |
| **Architecture Pattern** | Feature-oriented Layered Hybrid | Practical folder separation balancing domain isolation with student project scale |
| **State Management** | Provider + ChangeNotifier | Lightweight, reactive, low boilerplate, official Flutter team recommendation |
| **Navigation** | `go_router` | Declarative, route-driven navigation with URL/deep-link support & clean parameter handling |
| **Simple Persistence** | `shared_preferences` | Key-value storage for app settings, onboarding status, and simple flags |
| **Structured Persistence** | `hive` / `hive_flutter` | Fast, lightweight NoSQL local key-value/object storage for reading history & XP |
| **Scripture Storage** | Bundled Local JSON Asset | Indonesian ILT3 Scripture dataset loaded from `assets/scripture/ilt3/ilt3.json` |
| **Local Reminders** | `flutter_local_notifications` + `timezone` | On-device scheduled notifications for daily reading reminders |
| **Design System** | Meno Tactile Design Tokens | Material 3 base with custom Teal/Amber palette, Outfit + Plus Jakarta Sans typography |

### Intentionally Excluded Infrastructure

The MVP intentionally excludes:
* Remote backend servers or APIs
* Firebase Cloud Messaging or backend push notifications
* User authentication (OAuth, email/password)
* Cloud database synchronization
* Code generation tooling overhead (e.g., build_runner required by complex state managers)

---

## 3. Architectural Principles

Meno adheres to seven core architectural principles:

1. **Keep It Simple & Proportional**: Avoid enterprise over-engineering. Match architectural complexity to the 12-meeting academic timeline.
2. **Local-First & Offline-Capable**: Core reading, progress calculation, and streak tracking operate entirely on-device without internet access.
3. **Feature-Oriented Modularization**: Keep feature screens, views, and local state together while sharing global repositories and models.
4. **Declarative & Reactive State**: Use ChangeNotifier to expose UI state, allowing widgets to reactively rebuild without tight coupling.
5. **Single Source of Truth for Data**: Repositories act as sole access points for Scripture and progress data, preventing direct file/database reads inside widgets.
6. **Reusable Tactile UI Components**: Visual elements (bevel buttons, cards, progress bars) are encapsulated into reusable Flutter widgets.
7. **Migration Continuity**: Retain clear architectural mapping from earlier project phases while strictly pursuing the Flutter execution path.

---

## 4. Folder Structure

The application adopts a feature-oriented conceptual structure:

```text
lib/
├── main.dart                   # Application entry point & Provider registration
│
├── core/                       # Shared app-wide core infrastructure
│   ├── theme/                  # Theme configuration, color tokens, typography, shapes
│   │   ├── meno_colors.dart    # Primary Teal (#006964), Amber (#FEA619), background tokens
│   │   ├── meno_typography.dart# Outfit & Plus Jakarta Sans font pairings
│   │   ├── meno_shapes.dart    # Tactile bevel specs & corner radius tokens
│   │   └── meno_theme.dart     # ThemeData builder
│   ├── routing/                # go_router setup and route definitions
│   │   └── app_router.dart     # Router configuration & path constants
│   └── utils/                  # App-wide date formatting and helper utilities
│
├── data/                       # Shared data layer (Models, Repositories, Services)
│   ├── models/                 # Pure Dart data models
│   │   ├── scripture_model.dart# Book, Chapter, Verse representations
│   │   ├── journey_model.dart  # Reading Journey & passage specs
│   │   └── progress_model.dart # User progress, XP, and streak models
│   ├── repositories/           # Repositories exposing domain data
│   │   ├── scripture_repository.dart # Local ILT3 JSON parsing & search service
│   │   ├── reading_repository.dart   # Journey & daily reading logic
│   │   └── progress_repository.dart  # Streak & XP update management
│   └── services/               # Local persistence implementations
│       ├── storage_service.dart      # Hive box initialization & operations
│       ├── preferences_service.dart  # SharedPreferences wrapper
│       └── notification_service.dart # Local notifications scheduling
│
└── features/                   # Feature modules (UI Views + State)
    ├── onboarding/             # Onboarding flow (Welcome, Journey Select, Goal, Reminder)
    ├── home/                   # Dashboard, Today's Reading Card, Streak summary
    ├── journey/                # Guided Journey timeline & chapter breakdown
    ├── reading/                # Scripture Reader & passage viewer
    ├── completion/             # Celebration screen & XP reward sequence
    ├── review/                 # Reading history & progress review
    ├── profile/                # User stats & high-level settings summary
    └── settings/               # Reminder customization & reading preferences
```

---

## 5. Presentation Layer

The presentation layer is composed of declarative Flutter widgets organized by feature.

### Component Responsibilities

* **Screen Views**: Full-page layout widgets (e.g., `HomeScreen`, `ReadingScreen`) responsible for layout structure and listening to Providers.
* **Feature Components**: Feature-specific sub-widgets (e.g., `TodaysReadingCard`, `StreakHeaderWidget`).
* **Tactile Design System Widgets**: Shared atomic controls (e.g., `MenoButton`, `MenoCard`, `MenoProgressBar`) implementing Meno's bevel aesthetics.

### Interaction Rules

Widgets must **not**:
* Direct-parse JSON files or perform file I/O.
* Instantiate persistence storage instances directly.
* Perform raw date math or complex streak calculations in build methods.

Instead, widgets consume provided state:

```text
Widget View ──(User Action)──> ChangeNotifier ──> Repository ──> Local Storage / Assets
    ▲                                                                 │
    └─────────────────────(Notify Listeners)──────────────────────────┘
```

---

## 6. State Management

Meno uses **Provider + ChangeNotifier** as its official state management solution.

### Selection Rationale

* **Proportional Complexity**: Provides clean reactive state without the boilerplate of Bloc or the code-generation requirements of Riverpod/Freezed.
* **Low Friction for Student Project**: Easily understandable lifecycle and scoping ideal for an individual developer.
* **Official Flutter Pattern**: Built on Flutter's native `Listenable` and `InheritedWidget` foundation.

### Provider Strategy

To prevent over-engineering, providers are scoped at key levels:

1. **Global App State (Root Level)**:
   * `UserProgressProvider`: Manages total XP, current streak, longest streak, and completion dates.
   * `SettingsProvider`: Manages onboarding status, reminder times, and reading preferences.
2. **Feature Scoped Providers**:
   * `ReadingProvider`: Manages current active passage loading state, verse index, and completion submission.
   * `JourneyProvider`: Manages selected journey state and passage list loading.

Local UI-only transient states (e.g., current tab index, scroll position, animation triggers) use standard `StatefulWidget` state rather than creating unnecessary ChangeNotifier classes.

---

## 7. Data Layer

The data layer manages raw data models, repository abstractions, and persistence services.

### Models

Pure Dart objects representing business entities:

```dart
class ScriptureVerse {
  final int number;
  final String text;
  const ScriptureVerse({required this.number, required this.text});
}

class UserProgress {
  final int totalXp;
  final int currentStreak;
  final int longestStreak;
  final DateTime? lastReadingDate;
  const UserProgress({
    required this.totalXp,
    required this.currentStreak,
    required this.longestStreak,
    this.lastReadingDate,
  });
}
```

### Repositories

Repositories encapsulate data sources behind clean asynchronous APIs:

* `ScriptureRepository`: Loads and parses `ilt3.json` from assets, providing passage lookups by book, chapter, and verse ranges.
* `ReadingRepository`: Defines structured reading journeys (e.g., "Gospel Starter") and maps daily readings to Scripture passages.
* `ProgressRepository`: Coordinates local persistence for user completion status, streak calculations, and XP additions.

---

## 8. Local Persistence

Meno uses a dual persistence strategy:

```text
                             ┌──────────────────────┐
                             │ Local Persistence    │
                             └──────────┬───────────┘
                                        │
           ┌────────────────────────────┴───────────────────────────┐
           ▼                                                        ▼
┌─────────────────────────────┐                          ┌────────────────────┐
│    SharedPreferences        │                          │        Hive        │
├─────────────────────────────┤                          ├────────────────────┤
│ Simple Preferences:         │                          │ Structured Data:   │
│ • onboardingCompleted (bool)│                          │ • completedReadings│
│ • selectedJourneyId (String)│                          │ • readingHistory   │
│ • dailyGoalMinutes (int)    │                          │ • userXP (int)     │
│ • reminderTime (String)     │                          │ • streakData (map) │
│ • reminderEnabled (bool)    │                          │                    │
└─────────────────────────────┘                          └────────────────────┘
```

### Persistence Guidelines

* Do **not** recreate heavy relational ORM architectures (like SQLite/Room) when key-value and document boxes in Hive provide lighter execution.
* Store completion records using canonical identifiers (e.g., `journey_gospel_day_01`), rather than duplication of full Scripture passage text.

---

## 9. Scripture Data Flow

The Indonesian ILT3 Scripture dataset is bundled as a read-only JSON asset.

```text
assets/scripture/ilt3/ilt3.json
              │
              ▼
ScriptureRepository (AssetBundle.loadString)
              │
              ▼
    ScriptureVerse Models
              │
              ▼
       ReadingProvider
              │
              ▼
   ScriptureReaderWidget
```

1. **Asset Loading**: On initial access or app startup, `ScriptureRepository` loads `ilt3.json` via `rootBundle`.
2. **In-Memory Cache**: Parsed book and chapter structures are cached in memory for zero-latency passage switching.
3. **Passage Extraction**: Given a reading specification (e.g., `John 1:1–18`), the repository slices the appropriate verse range and returns it to `ReadingProvider`.

---

## 10. Navigation

Meno uses **`go_router`** for declarative route management.

### App Route Tree

```text
/splash                           (Splash Screen)
├── /onboarding                   (Welcome & Setup Wizard)
│   ├── /choose-journey           (Select Initial Reading Journey)
│   ├── /daily-goal               (Set Target Daily Goal)
│   └── /reminder-setup           (Configure Reminder Time)
│
└── /main                         (ShellRoute with Bottom Navigation Bar)
    ├── /home                     (Dashboard & Today's Reading Card)
    ├── /journey                  (Journey Progress & Timeline)
    │   └── /journey/detail       (Chapter & Passage Overview)
    ├── /review                   (Reading History & Completed List)
    └── /profile                  (User Summary Stats & Settings Access)

Standalone Routes:
/reading/:readingId               (Scripture Reading Interface)
/completion                       (Celebration & Award Screen)
/settings                         (AppSettings & Preferences)
```

Navigation parameters pass simple primitive keys (`readingId`, `journeyId`) rather than heavy serialized objects.

---

## 11. Notifications

Meno uses **`flutter_local_notifications`** combined with **`timezone`** for scheduled local reminders.

```text
User updates reminder settings
             │
             ▼
      SettingsProvider
             │
             ▼
    NotificationService
             │
             ▼
flutter_local_notifications (Scheduled Local Notification)
```

### Notification Rules

* Reminders are scheduled strictly on-device using local timezones.
* No remote servers, FCM tokens, or backend webhooks are used.
* Notification permissions are requested during the onboarding reminder setup step.

---

## 12. Asset Management

All application assets are stored locally within the Flutter package directory:

```text
assets/
├── scripture/
│   └── ilt3/
│       └── ilt3.json            # Indonesian ILT3 Scripture dataset
├── images/
│   ├── mascot_waving.png        # Mascot welcoming state
│   ├── mascot_reading.png       # Mascot active reading state
│   ├── mascot_celebrating.png   # Mascot completion state
│   └── logo_meno.png            # Meno brand mark
└── icons/
    └── app_icon.png             # Application launcher icon
```

Assets are declared in `pubspec.yaml` and loaded via Flutter's `Image.asset()` or custom SVG/vector rendering widgets. No external CDN dependencies are permitted for core assets.

---

## 13. Design System Integration

The design system maps cleanly to Flutter tokens and custom tactile widget primitives.

### Color Tokens (`meno_colors.dart`)

```dart
class MenoColors {
  static const Color primary = Color(0xFF006964);
  static const Color secondary = Color(0xFF10847E);
  static const Color lightTeal = Color(0xFF94F3EB);
  static const Color tealFixedDim = Color(0xFF77D6CF);
  static const Color tactileBevel = Color(0xFF00504C);

  static const Color amber = Color(0xFFFEA619);
  static const Color amberDark = Color(0xFF855300);
  static const Color amberFixed = Color(0xFFFFDDB8);
  static const Color amberLight = Color(0xFFFEF3C7);

  static const Color background = Color(0xFFFBF9F6);
  static const Color surface = Color(0xFFFFFFFF);
  static const Color warmSurface = Color(0xFFF5F3F0);
  static const Color warmSurfaceSecondary = Color(0xFFEFEEEB);

  static const Color textPrimary = Color(0xFF1B1C1A);
  static const Color textSecondary = Color(0xFF3E4948);
  static const Color outline = Color(0xFF6E7978);
  static const Color outlineVariant = Color(0xFFBDC9C7);
}
```

### Typography Pairing (`meno_typography.dart`)

* **Outfit**: Used for Display, Headings, Gamification numbers, and prominent UI labels.
* **Plus Jakarta Sans**: Used for Body text, UI interface labels, Scripture reading passages, and supporting content.

### Tactile Bevel Helper (`MenoButton`)

Tactile buttons utilize a stacked shadow/container effect with a 4dp bottom bevel (`tactileBevel: #00504C`) that visually translates downward upon press gesture detection.

---

## 14. Feature Boundaries

Each feature is isolated with clear inputs and output contracts:

1. **Onboarding**: Inputs: none. Outputs: `onboardingCompleted` flag, selected journey key, initial goal.
2. **Home**: Inputs: `UserProgressProvider`, `ReadingProvider`. Outputs: Navigation trigger to Reader or Journey.
3. **Journey**: Inputs: `ReadingRepository`. Outputs: Selected passage details.
4. **Reading**: Inputs: `readingId`. Outputs: Completion signal to `UserProgressProvider`.
5. **Completion**: Inputs: Earned XP, streak update state. Outputs: Navigation back to Home.
6. **Review / Profile / Settings**: Inputs: Historical Hive data boxes. Outputs: Updated preference values.

---

## 15. Data Flow

Complete sequence for completing a daily reading:

```text
[User Taps "Complete Reading"]
              │
              ▼
     ReadingScreen (Widget)
              │
              ▼
   ReadingProvider.completeActiveReading()
              │
              ▼
   ProgressRepository.markCompleted(readingId)
              │
              ├─► Updates Hive box ('completed_readings')
              ├─► Calculates new XP (+10 XP)
              ├─► Evaluates streak (consecutive calendar day check)
              └─► Saves updated UserProgress entity in Hive
              │
              ▼
   UserProgressProvider.notifyListeners()
              │
              ▼
   go_router.go('/completion') ──► Renders Celebration View with updated XP/Streak
```

---

## 16. MVP Scope

The 12-meeting MVP scope is strictly focused on the complete offline user reading loop:

* User Onboarding (Welcome, Journey Selection, Goal Setup, Reminder Config)
* Home Dashboard with Today's Reading Card and Streak counter
* Guided Journey Timeline (e.g., Gospel Starter plan)
* Scripture Reader Interface with Indonesian ILT3 text
* Completion Flow with celebration feedback, +10 XP reward, and streak updates
* Reading Review & Progress history view
* Profile & Local Reminder settings management
* Offline operation with SharedPreferences and Hive storage

---

## 17. Out of Scope

The following features are explicitly excluded from the current MVP architecture:

* User authentication, user logins, and profile accounts
* Cloud storage, cloud sync, or remote database synchronization
* Backend server APIs or web sockets
* Firebase Cloud Messaging (FCM) push notifications
* AI assistance, automated commentary, or AI Bible interpretation
* Audio Bible recording streaming or text-to-speech integration
* Social feeds, friend lists, or community chat
* Competitive leaderboards or online multiplayer rankings
* Complex skill trees, energy systems, or virtual item stores

---

## 18. Testing Strategy

The architecture supports straightforward, low-friction testing without requiring elaborate mock servers:

### Unit Tests (`test/unit/`)
* **Streak Logic**: Verify consecutive day calculations, same-day duplicate handling, and missed day resets.
* **XP System**: Ensure XP is awarded exactly once per completed reading ID.
* **Scripture Parsing**: Verify JSON loading and range extraction for multi-verse passages.

### Widget Tests (`test/widget/`)
* **Tactile Controls**: Verify `MenoButton` gesture press transformations and callback execution.
* **Reader Interface**: Verify Scripture text rendering and typography scaling.
* **Onboarding Flow**: Verify navigation progression through the setup wizard.

---

## 19. Migration Notes from Kotlin

> **Architectural Transition Summary**:
>
> Meno's initial technical design was developed using native Android (Kotlin, Jetpack Compose, Room, DataStore, WorkManager, Navigation Compose). During project review, the project officially adopted a **Flutter + Dart** stack.
>
> ### Concept Mapping Reference
>
> | Native Kotlin / Android Concept | Approved Flutter Equivalent | Notes |
> | :--- | :--- | :--- |
> | Jetpack Compose | Flutter Widgets (`StatelessWidget`, `StatefulWidget`) | Declarative UI rebuilding |
> | ViewModel + StateFlow | `ChangeNotifier` + `Provider` / `ListenableBuilder` | Reactive state management |
> | Room Database | `Hive` document boxes | Lightweight local NoSQL storage |
> | DataStore Preferences | `shared_preferences` package | Key-value settings storage |
> | WorkManager | `flutter_local_notifications` + `timezone` | Local scheduled reminders |
> | Navigation Compose | `go_router` | Declarative route management |
> | `Color.kt` / `Type.kt` | `meno_colors.dart` / `meno_typography.dart` | Centralized design tokens |
>
> The previous Kotlin codebase under `app/` is retained purely as historical project work and migration context. It is **not** part of the active compilation or implementation path.

---

## 20. Future Extension Guidelines

Should future project phases call for expanded scope beyond the university MVP, the current architecture supports extension without structural rewrites:

* **Adding Authentication**: Introduce an `AuthRepository` interface in `lib/data/repositories/` and wrap root routes with a security guard in `app_router.dart`.
* **Adding Cloud Sync**: Implement a `SyncService` that listens to Hive box mutations and pushes sync payloads to a remote endpoint when online.
* **Adding Multiple Translations**: Expand `assets/scripture/` to include additional translation subdirectories (e.g., `tb/`, `niv/`) and update `ScriptureRepository` to accept a `translationId` key.

---

## End of Architecture Specification
