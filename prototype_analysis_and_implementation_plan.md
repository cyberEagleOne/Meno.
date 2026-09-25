# Meno Application — Prototype Analysis & Flutter Implementation Plan

> **Meno — Read. Remain. Grow.**
> 
> Technical report analyzing the `meno.prototipe/stitch_meno_bible_habit_app/` HTML/CSS prototype and detailing the implementation plan for native Flutter integration.

---

## 1. Implementation Status

> **Notice on Current Implementation Direction**:
>
> * **Historical Context**: This prototype analysis originally documented the early native Android (Kotlin + Jetpack Compose) technical direction.
> * **Current Source of Truth**: The active production implementation direction has officially migrated to **Flutter + Dart**.
> * **Authoritative Specifications**: [`README.md`](file:///c:/Users/siril/Documents/Meno/README.md), [`architecture.md`](file:///c:/Users/siril/Documents/Meno/architecture.md), and [`design.md`](file:///c:/Users/siril/Documents/Meno/design.md) serve as the authoritative project documentation.
> * **Purpose of Document**: This document preserves all visual, interaction, component, and UX findings from the HTML/Stitch prototype while updating implementation terminology, architecture mapping, and roadmap phases to match the current Flutter stack.

---

## 2. Executive Summary

This document presents a complete analysis of the **Meno HTML/CSS prototype** (`meno.prototipe/stitch_meno_bible_habit_app/`) and outlines a structured, multi-phase plan for translating its design and interaction patterns into the active Flutter codebase (`lib/`).

### Key Implementation Principles:
* **Native Flutter Widget Recreation**: No WebViews, no embedded HTML, no raw code translation. Widgets are implemented natively in Flutter using Dart.
* **Architecture Preservation**: Built on top of the established feature-oriented layered hybrid architecture documented in [`architecture.md`](file:///c:/Users/siril/Documents/Meno/architecture.md).
* **Visual & Design System Integrity**: Implements tactile warmth, Outfit & Plus Jakarta Sans typography, Meno Primary Teal (`#006964`/`#10847E`), Amber (`#FEA619`), and warm surface depth defined in [`design.md`](file:///c:/Users/siril/Documents/Meno/design.md).
* **Local-First & Offline First**: Aligned with [`README.md`](file:///c:/Users/siril/Documents/Meno/README.md). Uses local Hive boxes, SharedPreferences, and local Indonesian (ILT3) Scripture JSON assets (`assets/scripture/ilt3/ilt3.json`) without requiring cloud authentication or remote backend APIs.
* **Historical Reference Alignment**: Acknowledges the earlier Kotlin/Compose reference implementation while establishing the active Flutter execution path.

---

## 3. Complete Screen Inventory

The prototype contains **20 unique HTML screen views** across 21 directories (including the design system specification file).

| Prototype Screen Directory | Purpose & Description | Target Flutter Screen / Widget | Reusable Meno Components | Navigation Route (`go_router`) | MVP Status |
| :--- | :--- | :--- | :--- | :--- | :--- |
| `meno_01_splash` | Initial splash screen displaying brand logo, name, and tagline. | `SplashScreen` | `MenoMascot`, Brand Logo | `/splash` | **MVP** |
| `meno_02_welcome` | Onboarding Step 1: Welcome message, mascot greeting, value proposition. | `WelcomeScreen` | `MenoButton`, `MenoMascot`, `MenoCard` | `/onboarding/welcome` | **MVP** |
| `meno_03_choose_journey` | Onboarding Step 2: Reading journey selection cards (e.g., Gospel of Matthew, Psalms). | `JourneySelectionScreen` | `MenoJourneyCard`, `MenoButton`, `MenoTopBar` | `/onboarding/choose-journey` | **MVP** |
| `meno_04_daily_goal` | Onboarding Step 3: Daily reading pace selection (5, 10, 15, 20 mins). | `DailyGoalScreen` | `MenoChip`, `MenoButton`, `MenoCard` | `/onboarding/daily-goal` | **MVP** |
| `meno_05_reminder_setup` | Onboarding Step 4: Time picker and reminder schedule configuration. | `ReminderSetupScreen` | `MenoButton`, `MenoCard`, `MenoTopBar` | `/onboarding/reminder-setup` | **MVP** |
| `meno_06_onboarding_complete` | Onboarding Step 5: Commitment seal summary and "Begin First Reading" action. | `OnboardingCompleteScreen` | `MenoButton`, `MenoMascot`, `MenoCard` | `/onboarding/complete` | **MVP** |
| `meno_home` | Main Dashboard: Streak/XP header, "Today's Path" card, vertical journey map, bottom bar. | `HomeScreen` | `MenoStatCard`, `MenoReadingCard`, `MenoBottomNavigation`, `MenoMascot` | `/home` | **MVP** |
| `meno_08_reading_journey` | Roadmap view: Winding journey path nodes, active day speech bubble, locked/completed nodes. | `JourneyRoadmapScreen` | `MenoJourneyCard`, `MenoProgressBar`, `MenoBottomNavigation` | `/journey` | **MVP** |
| `meno_11_journey_chapter_detail` | Chapter overview sheet: Duration, themes, section breakdown, XP reward. | `ChapterDetailSheet` / `Screen` | `MenoCard`, `MenoButton`, `MenoChip` | `/journey/detail` | **MVP-Supporting** |
| `meno_reading_scripture` | Distraction-free Scripture reading view: Top progress, font size, theme toggle, complete button. | `ReadingScreen` | `MenoProgressBar`, `MenoButton`, `MenoTopBar` | `/reading/:readingId` | **MVP** |
| `meno_reading_complete` | Completion celebration modal: Mascot animation, XP popup (+10 XP), streak update, actions. | `CompletionScreen` | `MenoMascot`, `MenoButton`, `MenoSecondaryButton`, `MenoCard` | `/completion` | **MVP** |
| `meno_12_review_history` | History list: Log of completed readings, dates, duration, bookmarks, filter tabs. | `ReviewHistoryScreen` | `MenoCard`, `MenoChip`, `MenoBottomNavigation` | `/review` | **MVP-Supporting** |
| `meno_13_review_empty_state` | Empty state when no reading history exists: Mascot illustration & prompt. | `ReviewEmptyState` (Widget) | `MenoEmptyState`, `MenoButton`, `MenoMascot` | Embedded in `/review` | **MVP-Supporting** |
| `meno_14_profile` | User profile & stats: Streak flame, total XP, level badge, recent badges, settings shortcuts. | `ProfileScreen` | `MenoStatCard`, `MenoCard`, `MenoBottomNavigation` | `/profile` | **MVP** |
| `meno_15_achievements` | Badges grid: Filter tabs (Milestones, Consistency, Journeys), locked/unlocked state. | `AchievementsScreen` | `MenoCard`, `MenoChip`, `MenoProgressBar` | `/achievements` | Future / Secondary |
| `meno_16_achievement_unlocked` | Celebration popup when a new badge milestone (e.g. 7-day streak) is unlocked. | `AchievementUnlockedDialog` | `MenoMascot`, `MenoButton`, `MenoSecondaryButton` | Dialog route | Future / Secondary |
| `meno_17_streak` | Detailed streak breakdown: Current streak, weekly calendar, monthly activity heat map. | `StreakDetailScreen` | `MenoStatCard`, `MenoCard`, `MenoButton` | `/streak-detail` | **MVP-Supporting** |
| `meno_18_missed_day_return` | Gentle recovery screen after missing a day: Grace freeze prompt or fresh start. | `MissedDayReturnScreen` | `MenoMascot`, `MenoButton`, `MenoSecondaryButton` | `/missed-day-return` | MVP-Supporting |
| `meno_19_settings` | Sanctuary settings: Reading preferences, reminder time, journey change, local data. | `SettingsScreen` | `MenoCard`, `MenoTopBar` | `/settings` | **MVP** |
| `meno_20_reading_preferences` | Appearance customizer: Font sizes (16-26sp), Serene/Sepia/Night theme colors. | `ReadingPreferencesScreen` | `MenoCard`, `MenoChip`, `MenoTopBar` | `/reading-preferences` | **MVP-Supporting** |

---

## 4. Visual & Aesthetic Architecture Mapping

The prototype introduces distinct visual polish details defined in `peaceful_habit_companion/DESIGN.md` and authorized in [`design.md`](file:///c:/Users/siril/Documents/Meno/design.md):

```text
┌────────────────────────────────────────────────────────────────────────┐
│                        VISUAL FIDELITY SYSTEM                          │
├────────────────────────────────────────────────────────────────────────┤
│ 1. Tactile Bevel Buttons (MenoButton Flutter Widget):                  │
│    - Primary Meno Teal (#006964) with 4dp solid bottom bevel (#00504C) │
│    - Press state: 4dp Y-translation down for responsive tactile feel   │
│                                                                        │
│ 2. Color Palette & Canvas (meno_colors.dart):                          │
│    - Canvas Surface: Warm paper off-white background (#FBF9F6)         │
│    - Surface Container / Card Fill: #FFFFFF with 1.5px border #BDC9C7  │
│    - Streak & XP Accents: Warm Amber (#FEA619 accent, #FEF3C7 light)   │
│                                                                        │
│ 3. Winding Journey Path (Snaking Nodes):                               │
│    - Active Node in #006964 with glowing pulse animation ring          │
│    - Floating speech bubble tooltip ("Today's Reading") anchored above │
│    - Alternating 24dp-40dp horizontal offsets forming a curved path    │
└────────────────────────────────────────────────────────────────────────┘
```

### Component Mapping & Reuse Strategy

1. **`MenoButton` & `MenoSecondaryButton` Flutter Widgets**:
   * Implement the 4dp bottom bevel shadow (`#00504C`) and downward press translation.
   * Retain pill shapes (`BorderRadius.circular(50)`) or rounded 12-16dp corners as specified in `design.md`.

2. **`MenoMascot` Flutter Widget**:
   * Renders local vector/PNG mascot assets (`assets/images/mascot_*.png` or SVG equivalents).
   * Supports mascot states (`Waving`, `Reading`, `Celebrating`, `Supportive`).

3. **`MenoCard` & `MenoStatCard` Flutter Widgets**:
   * Use `#FFFFFF` background with soft border `#BDC9C7` and 16dp corner radius.
   * Maintain visual contrast for streak counters, XP stats, and reading cards.

4. **`MenoBottomNavigation` Flutter Widget**:
   * Implements 4 main tabs: `Home`, `Journey`, `Review`, `Profile`.

---

## 5. Asset Inventory & Strategy

| Asset Type | Prototype Source | Flutter Asset Location | Strategy |
| :--- | :--- | :--- | :--- |
| **Mascot Artwork** | Google AIDA web images in HTML | `assets/images/mascot_*.png` | **Use Local Assets**. Render local image/vector assets bundled inside the Flutter app package. |
| **Meno Logo** | SVG / HTML text | `assets/images/logo_meno.png` | **Use Local Asset**. Crisp vector or high-res PNG bundled in package. |
| **Typography** | Google Fonts (Outfit & Plus Jakarta Sans) | `assets/fonts/*.ttf` or `google_fonts` package | **Use Configured Fonts**. Pair Outfit (headings/gamification) with Plus Jakarta Sans (body/Scripture) as defined in `design.md`. |
| **Icons** | Material Symbols in HTML | Flutter `Icon(Icons.rounded_*)` | **Use Material Rounded Icons** (`Icons.flame_rounded`, `Icons.book_rounded`, `Icons.check_rounded`, `Icons.settings_rounded`, `Icons.calendar_today_rounded`, `Icons.arrow_back_rounded`). |
| **Scripture Text** | English ESV sample snippets in HTML | `assets/scripture/ilt3/ilt3.json` | **Use Local Indonesian ILT3 JSON Asset**. Preserves project requirements while feeding the Flutter Scripture Reader. |

---

## 6. Navigation Architecture & Flow Map

Navigation is managed via **`go_router`** in `lib/core/routing/app_router.dart`:

```text
                     ┌─────────────────────────┐
                     │  /onboarding/welcome    │
                     └────────────┬────────────┘
                                  │
                                  ▼
                     ┌─────────────────────────┐
                     │          /home          │
                     └────────────┬────────────┘
                                  │
        ┌────────────────────────┼────────────────────────┐
        ▼                        ▼                        ▼
┌──────────────┐         ┌──────────────┐         ┌──────────────┐
│   /journey   │         │   /review    │         │   /profile   │
└───────┬──────┘         └──────────────┘         └───────┬──────┘
        │                                                 │
        ▼                                                 ▼
┌──────────────┐                                  ┌──────────────┐
│/journey/detail│                                 │/streak-detail│
└───────┬──────┘                                  └──────────────┘
        │
        ▼
┌──────────────────────────┐
│  /reading/:readingId     │
└───────┬──────────────────┘
        │
        ▼
┌──────────────────────────┐
│       /completion        │
└──────────────────────────┘
```

---

## 7. Data Architecture & Storage Mapping

| Screen / Feature | Data Storage Mechanism | Architecture Layer | Data Entities / Models |
| :--- | :--- | :--- | :--- |
| **Onboarding State** | `shared_preferences` | Data Layer (`PreferencesService`) | `onboardingCompleted: bool`, `userName: String` |
| **Selected Journey** | `shared_preferences` | Data Layer (`PreferencesService`) | `selectedJourneyId: String` |
| **Daily Reading Goal** | `shared_preferences` | Data Layer (`PreferencesService`) | `dailyGoalMinutes: int` |
| **Reminder Schedule** | `shared_preferences` + `flutter_local_notifications` | Data Layer (`NotificationService`) | `reminderEnabled: bool`, `reminderTime: String` |
| **Scripture Content** | Bundled JSON Asset (`rootBundle`) | Data Layer (`ScriptureRepository`) | `ILT3 Scripture Dataset` (`ScriptureVerse`, `Chapter`, `Book`) |
| **Journey & Reading Plans** | Bundled JSON Asset / Hive | Data Layer (`ReadingRepository`) | `JourneyModel`, `ReadingModel` |
| **User XP & Streak** | `hive` Document Box | Data Layer (`ProgressRepository`) | `UserProgress` (`totalXp`, `currentStreak`, `lastReadingDate`) |
| **Reading Progress** | `hive` Document Box | Data Layer (`ProgressRepository`) | `ReadingProgress` (`readingId`, `isCompleted`, `completedAt`) |
| **Reading Preferences** | `shared_preferences` | Data Layer (`PreferencesService`) | `textSizeSp: double`, `themeMode: String` |

---

## 8. MVP Prioritization Matrix

```text
                      HIGH VALUE FOR MVP
                              │
    Meeting 3–4: Onboarding   │  Meeting 5–8: Home & Reading Flow
    - Welcome                 │  - Home Dashboard
    - Choose Journey          │  - Journey Roadmap
    - Daily Goal Pace         │  - Scripture Reader
    - Reminder Setup          │  - Completion Celebration
    - Commitment Seal         │  
LOW ──────────────────────────┼────────────────────────── HIGH
COMPLEXITY                    │                          COMPLEXITY
    Meeting 11: Settings      │  Meeting 9–10: Progress & Detail
    - Reading Preferences     │  - Streak Breakdown
    - Reminder Settings       │  - Review History
    - Profile Overview        │  - Chapter Detail Sheet
                              │
                      LOW VALUE FOR MVP (Future Scope)
                      - Achievements Grid (Secondary)
                      - Grace Freeze Mechanic (Secondary)
```

---

## 9. 12-Meeting Implementation Roadmap

### Meeting 1–2: Flutter Foundation & Design System Setup
* **Goal**: Initialize project architecture foundation, design system tokens, and core tactile widgets.
* **Tasks**:
  1. Configure `meno_colors.dart` (`#006964`, `#10847E`, `#FEA619`, `#FBF9F6`), `meno_typography.dart` (Outfit & Plus Jakarta Sans), and `meno_theme.dart`.
  2. Implement `MenoButton` Flutter widget with 4dp tactile bevel (`#00504C`) and downward press animation.
  3. Build `MenoMascot` and `MenoCard` shared Flutter widgets.

### Meeting 3–4: Onboarding Sequence & Preferences Persistence
* **Goal**: Implement 5-step onboarding wizard backed by `shared_preferences`.
* **Screens**: `WelcomeScreen` → `JourneySelectionScreen` → `DailyGoalScreen` → `ReminderSetupScreen` → `OnboardingCompleteScreen`.
* **State & Persistence**: Store `onboardingCompleted`, `selectedJourneyId`, and goal preferences via `PreferencesService`.

### Meeting 5–6: Home Dashboard & Scripture Data Provider
* **Goal**: Build Home dashboard and connect local Indonesian ILT3 JSON parsing.
* **Screens**: `HomeScreen` (with "Today's Reading" hero card), `ScriptureRepository` asset parsing via `rootBundle`.
* **State & Data**: Wire `ReadingProvider` to load active daily reading passages from `ilt3.json`.

### Meeting 7–8: Scripture Reader, Reading Completion & Gamification
* **Goal**: Build distraction-free Reader interface, completion screen, and local persistence for XP/streaks.
* **Screens**: `ReadingScreen` (custom text size, comfortable line height), `CompletionScreen` (mascot celebration, +10 XP award popup).
* **State & Persistence**: Implement `UserProgressProvider` backed by `hive` to increment XP (+10 XP) and calculate consecutive calendar day streaks.

### Meeting 9–10: Journey Roadmap & Local Scheduled Reminders
* **Goal**: Implement guided journey path view and on-device scheduled reminders.
* **Screens**: `JourneyRoadmapScreen`, `ChapterDetailSheet`.
* **Services**: Configure `NotificationService` with `flutter_local_notifications` + `timezone` for daily scheduled alerts.

### Meeting 11–12: Profile, Review History, Polish & Release APK
* **Goal**: Complete auxiliary views, perform visual refinement, test offline flows, and build release APK.
* **Screens**: `ProfileScreen`, `ReviewHistoryScreen` (with empty state), `SettingsScreen`, `ReadingPreferencesScreen`.
* **Quality Assurance**: Verify offline Hive storage, test `go_router` navigation paths, build production Android APK.

---

## 10. Conflict Resolution & Project Alignment

1. **Scripture Text Language**:
   * *Prototype*: English ESV sample snippets in HTML.
   * *Authoritative Spec*: Indonesian ILT3 local dataset (`assets/scripture/ilt3/ilt3.json`).
   * *Resolution*: Load local Indonesian ILT3 JSON data while implementing the prototype's typography, spacing, and distraction-free reader layout.

2. **Cloud Accounts & Remote Synchronization**:
   * *Prototype*: Displays mock email sync settings (`natasha.miller@example.com`).
   * *Authoritative Spec*: Local-first architecture; backend servers, accounts, and cloud sync are explicitly out of scope for MVP.
   * *Resolution*: Render user profile as a local offline profile without remote network endpoints.

3. **Asset Loading**:
   * *Prototype*: External Google AIDA web image URLs.
   * *Authoritative Spec*: Local Flutter app assets.
   * *Resolution*: Map all mascot visual states to bundled local image/vector assets in `assets/images/`.

---

## 11. Historical Reference Note

> **Historical Reference — Native Kotlin/Compose Prototype Plan**:
>
> In earlier planning phases (prior to the Flutter migration audit), the project outlined a native Android Compose implementation plan (with `app/src/main/java/com/meno/app`, Room DAOs, DataStore Preferences, and WorkManager Workers).
>
> That initial plan is retained in project history as reference material. All active development tasks described in this document now target the **Flutter + Dart** implementation specified in [`architecture.md`](file:///c:/Users/siril/Documents/Meno/architecture.md).

---

## 12. Current Implementation Reference

```text
┌────────────────────────────────────────────────────────────────────────┐
│                   CURRENT IMPLEMENTATION SUMMARY                       │
├────────────────────────────────────────────────────────────────────────┤
│ Framework:            Flutter                                          │
│ Language:             Dart                                             │
│ State Management:     Provider / ChangeNotifier                        │
│ Navigation:           go_router                                        │
│ Simple Persistence:   shared_preferences                               │
│ Structured Storage:   Hive                                             │
│ Scripture Source:     Bundled ILT3 JSON (assets/scripture/ilt3/ilt3.json)│
│ Notifications:        flutter_local_notifications + timezone           │
│ Architecture:         Feature-oriented Layered Hybrid                  │
│ Prototype Role:       Visual & Interaction Design Reference Only       │
└────────────────────────────────────────────────────────────────────────┘
```

---

## End of Document
