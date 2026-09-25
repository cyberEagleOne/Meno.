# Meno — Design System & UI/UX Specification

> **Meno — Read. Remain. Grow.**
>
> UI/UX and visual design specification for the Meno Flutter Application.

---

## 1. Design Overview

Meno is a gamified Bible reading application designed to help users build a consistent Scripture reading habit.

The visual design communicates:

* Welcoming
* Calm & Encouraging
* Warm & Playful
* Modern & Tactile
* Trustworthy & Motivating
* Spiritual without being overly formal

Meno takes inspiration from the engagement and usability principles of modern habit-building applications while maintaining its distinct visual and tactile identity.

The interface is crafted according to the core principle:

> **Fun and encouraging enough to motivate daily returns, but calm and distraction-free during active Scripture reading.**

---

## 2. Design Goals

The Meno design system serves five primary goals:

1. **Make Bible reading approachable**: Eliminate intimidating dense layouts for beginners.
2. **Make progress visually clear**: Provide instant, rewarding feedback for completed readings.
3. **Establish a tactile visual identity**: Use rounded bevel buttons and warm surfaces that feel responsive and engaging.
4. **Maintain strict visual consistency**: Use centralized design tokens across all Flutter widgets.
5. **Prioritize reading ergonomics**: Ensure Scripture text is comfortably readable with optimal line heights and typography contrast.

---

## 3. Core Design Principles

### 3.1 Welcoming Over Formal

Meno feels approachable and friendly. It avoids looking like a corporate utility or an academic Bible study database.

Prefer:
* Friendly, encouraging microcopy
* Soft, warm surfaces and rounded containers
* Clear visual hierarchy with obvious primary actions
* Character-driven mascot feedback moments

### 3.2 Playful but Not Childish

Meno balances gamification elements (XP, streaks, celebrations) with a mature, modern layout.

```text
Playful Elements
   │  ├── Bean Mascot moments
   │  ├── Tactile bevel buttons
   │  ├── XP & streak indicators
   │  └── Subtle celebration feedback
   ▼
Modern & Readable UI
      ├── Clean Outfit headings & Plus Jakarta Sans body
      ├── Curated warm off-white surfaces
      ├── Generous whitespace
      └── Uncluttered reading experience
```

### 3.3 Visible & Meaningful Progress

Users should immediately grasp:
* What passage to read today.
* How many readings are complete in their active journey.
* Their active daily reading streak.
* What step comes next.

### 3.4 One Primary Action per Screen

Every screen highlights a single prominent primary action button (e.g., `Start Journey`, `Continue Reading`, `Complete Reading`). Secondary actions maintain lower visual weight.

---

## 4. Brand Identity

### 4.1 Brand Name & Tagline

* **Name**: **Meno**
* **Tagline**: **Read. Remain. Grow.**

The tagline reflects the core product philosophy:

```text
Read (Start daily Scripture)
  ↓
Remain (Build consistency through streaks)
  ↓
Grow (Develop a lasting spiritual habit)
```

### 4.2 Brand Personality Spectrum

| Trait | Target Intensity |
| :--- | :--- |
| **Friendly & Welcoming** | High |
| **Tactile & Responsive** | High |
| **Modern & Clean** | High |
| **Playful** | Medium–High |
| **Calm / Spiritual** | Medium–High (High on Reader screen) |
| **Formal / Academic** | Low |
| **Childish / Cartoonish** | Low |
| **Corporate / Sterile** | Low |

---

## 5. Color System

Meno uses a refined Teal primary palette paired with warm Amber accents and soft, paper-like background surfaces.

### 5.1 Palette Tokens

```text
Primary Palette (Teal):
┌─────────────────────────┬───────────┬──────────────────────────────────────────┐
│ Token Name              │ Hex Code  │ Primary Role                             │
├─────────────────────────┼───────────┼──────────────────────────────────────────┤
│ Meno Primary Teal       │ #006964   │ Brand identity, primary buttons, headers │
│ Meno Secondary Teal     │ #10847E   │ Interactive accents, secondary elements  │
│ Light Teal              │ #94F3EB   │ Active highlights, selection backgrounds │
│ Teal Fixed Dim          │ #77D6CF   │ Muted teal borders, subtle chips         │
│ Tactile Bevel           │ #00504C   │ 4dp bottom bevel shadow for buttons      │
└─────────────────────────┴───────────┴──────────────────────────────────────────┘

Accent Palette (Amber / Gamification):
┌─────────────────────────┬───────────┬──────────────────────────────────────────┐
│ Token Name              │ Hex Code  │ Primary Role                             │
├─────────────────────────┼───────────┼──────────────────────────────────────────┤
│ Amber (Accent)          │ #FEA619   │ XP rewards, streak flames, star badges   │
│ Amber Dark              │ #855300   │ Streak text contrast, dark accent borders│
│ Amber Fixed             │ #FFDDB8   │ Warm badge container fills               │
│ Amber Light             │ #FEF3C7   │ Celebration banners, highlight cards     │
└─────────────────────────┴───────────┴──────────────────────────────────────────┘

Background & Surface System (Warm Warm-Tones):
┌─────────────────────────┬───────────┬──────────────────────────────────────────┐
│ Token Name              │ Hex Code  │ Primary Role                             │
├─────────────────────────┼───────────┼──────────────────────────────────────────┤
│ Background              │ #FBF9F6   │ Primary app screen background (soft paper)│
│ Surface                 │ #FFFFFF   │ Pure white card containers & modals      │
│ Warm Surface            │ #F5F3F0   │ Secondary card fills & list items        │
│ Warm Surface Alt 1      │ #EFEEEB   │ Subtle divider & container fills         │
│ Warm Surface Alt 2      │ #EAE8E5   │ Inactive control fills                   │
│ Warm Surface Alt 3      │ #E4E2DF   │ Disabled borders                         │
└─────────────────────────┴───────────┴──────────────────────────────────────────┘

Text & Outline System:
┌─────────────────────────┬───────────┬──────────────────────────────────────────┐
│ Token Name              │ Hex Code  │ Primary Role                             │
├─────────────────────────┼───────────┼──────────────────────────────────────────┤
│ Primary Text            │ #1B1C1A   │ Headings, primary titles, Scripture text │
│ Secondary Text          │ #3E4948   │ Subtitles, captions, supporting labels   │
│ Outline                 │ #6E7978   │ Card borders, active input outlines      │
│ Outline Variant         │ #BDC9C7   │ Muted card dividers & soft borders       │
└─────────────────────────┴───────────┴──────────────────────────────────────────┘
```

---

## 6. Typography

Meno employs a distinct two-font typography pairing:

1. **Outfit**: Display, Headings, Gamification numbers, and prominent UI labels.
2. **Plus Jakarta Sans**: Body text, general UI controls, Scripture reading passages, and supporting information.

### 6.1 Font Hierarchy Specifications

```text
Display Large (Outfit Bold / 32–36dp / height 1.2)
└── Onboarding main titles, milestone celebrations

Heading 1 (Outfit Bold / 24–28dp / height 1.25)
└── Screen headers, major section titles

Heading 2 (Outfit SemiBold / 20–22dp / height 1.3)
└── Card titles, dialog headers, journey names

Heading 3 (Outfit SemiBold / 16–18dp / height 1.35)
└── Sub-section titles, list item headers

Body Large (Plus Jakarta Sans Regular / 16–18dp / height 1.6)
└── Scripture reading text, primary narrative descriptions

Body Medium (Plus Jakarta Sans Regular / 14–15dp / height 1.5)
└── Card body text, feature summaries, instructions

Caption (Plus Jakarta Sans Medium / 12–13dp / height 1.4)
└── Metadata, verse numbers, dates, timestamps

Button Text (Outfit SemiBold / 16dp / height 1.2 / letter-spacing 0.5)
└── Tactile bevel button labels
```

---

## 7. Spacing & Layout System

Meno uses a standard **8dp grid system**:

```text
4dp   → Micro spacing (badge padding, icon-text gap)
8dp   → Small spacing (chip padding, tight list item gaps)
12dp  → Compact spacing (card internal element padding)
16dp  → Standard screen margin & card padding
24dp  → Section separation gap
32dp  → Major section gap / header spacing
48dp  → Hero section top/bottom padding
```

Default screen horizontal padding: **16dp** (expanding up to 24dp on wider mobile displays).

---

## 8. Shape System & Tactile Language

Meno's visual signature is defined by friendly rounded corners and tactile 3D bevel buttons.

### 8.1 Corner Radii

* **Small**: `8dp` (chips, small badges, input fields)
* **Medium**: `12dp` (standard buttons, list items)
* **Large**: `16dp` (primary cards, dialog boxes)
* **Extra Large**: `24dp` (bottom sheets, hero containers)
* **Pill**: `50%` / `999dp` (streak pills, tag badges)

### 8.2 Tactile Bevel Button Mechanism

Primary buttons (`MenoButton`) feature a 3D tactile bevel effect:

```text
Default State:
┌─────────────────────────┐
│     Continue Reading    │  ◄── Primary Fill (#006964)
└─────────────────────────┘
  ▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀  ◄── 4dp Tactile Bevel Shadow (#00504C)

Pressed State:
┌─────────────────────────┐
│     Continue Reading    │  ◄── Translates 4dp down on Y-axis
└─────────────────────────┘      Bevel shadow compresses
```

When pressed, the top surface translates 4dp downward, compressing the bevel shadow to provide immediate visual feedback.

---

## 9. Mascot System

The Meno mascot ("Bean") provides friendly visual accompaniment across key journey touchpoints.

### Mascot States & Placements

* **Mascot Waving**: Welcomes users on the Splash and Onboarding screens.
* **Mascot Reading**: Appears on the Home screen dashboard when a reading is pending.
* **Mascot Celebrating**: Appears on the Completion screen with confetti and XP rewards.
* **Mascot Encouraging**: Accompanies empty states or returning user prompts.

### Usage Rules

* Do **not** place the mascot on every screen.
* Do **not** overlay the mascot on top of Scripture text.
* Store mascot graphics locally under `assets/images/`.

---

## 10. Reusable Component Specifications

All UI controls are built as reusable Flutter widgets in `lib/core/` and feature packages.

```text
Component Overview:
├── MenoButton              # Primary tactile bevel button (#006964 + #00504C bevel)
├── MenoSecondaryButton     # Outlined / warm surface button for secondary choices
├── MenoCard                # White/Warm surface container with 16dp radius & soft border
├── MenoProgressBar         # Rounded linear progress bar in Primary Teal / Amber
├── MenoChip                # Small pill badge for status, XP, or streak count
├── MenoStatCard            # Stat box displaying XP, streak days, or readings complete
├── MenoReadingCard         # Dashboard hero card displaying today's passage details
├── MenoJourneyCard         # Journey selection card with progress indicator
├── MenoMascot              # Mascot wrapper handling asset rendering and subtle scale
├── MenoTopBar              # Custom app header bar with back navigation & route title
├── MenoBottomNavigation    # 4-item bottom navigation bar (Home, Journey, Review, Profile)
├── MenoEmptyState          # Friendly state widget with illustration and recovery action
├── MenoLoadingState        # Circular progress spinner in Meno Teal with warm backdrop
└── MenoErrorState          # Error message container with friendly retry action
```

---

## 11. Core Screen Specifications

### 11.1 Onboarding Flow

Wizard sequence introducing Meno's guided approach:

1. **Splash**: Brand mark, mascot waving, tagline "Read. Remain. Grow."
2. **Welcome**: Value proposition summary ("Start your Bible reading habit").
3. **Choose Journey**: Select starting plan (e.g., *Gospel Starter*).
4. **Daily Goal**: Select target reading pace (e.g., 5 mins / 1 chapter per day).
5. **Reminder Setup**: Pick preferred daily notification time (e.g., 07:00 PM).
6. **Onboarding Complete**: Final encouraging prompt leading into Home.

### 11.2 Home Screen (Dashboard)

The user's central daily hub:

* **Top Header**: User greeting, streak counter pill (`🔥 7 Days`), XP total (`⭐ 120 XP`).
* **Hero Card (`MenoReadingCard`)**: Highlights "Today's Reading" (e.g., *John 1:1–18*) with a prominent `Continue Reading` tactile button.
* **Journey Snapshot**: Shows active journey progress bar (e.g., 8 / 10 readings completed).

### 11.3 Journey Screen

Displays the complete guided roadmap:

* Timeline of readings organized sequentially.
* Completed readings marked with Teal checkmarks.
* Active daily reading highlighted with Amber accent.
* Upcoming readings shown in clean, locked/future state.

### 11.4 Scripture Reading Screen

Designed for maximum reading focus:

* **Header**: Passage title (*John 1:1–18*) and back button.
* **Content Container**: High contrast text in **Plus Jakarta Sans**, size 17–19dp, line-height 1.6, on Warm Background (`#FBF9F6`).
* **Bottom Action**: Fixed bottom container featuring `Complete Reading` tactile button.
* Zero distraction: No ads, floating badges, or clutter during reading.

### 11.5 Completion Screen

Celebratory reward screen shown immediately upon marking a reading complete:

* **Illustration**: Mascot celebrating graphic with optional subtle confetti.
* **Headline**: "Reading Complete!" (Outfit Bold).
* **Reward Badges**: `+10 XP` awarded pop-up and updated Streak count (`🔥 8 Day Streak`).
* **Action**: `Continue` tactile button returning user to Home.

### 11.6 Review / History Screen

* Displays past completed readings organized by date.
* Allows re-reading previous passages.

### 11.7 Profile & Settings Screens

* Displays summary statistics (Total XP, Longest Streak, Total Chapters Read).
* Simple notification toggle and reminder time selector.
* App version and educational project attribution.

---

## 12. Prototype Relationship

The HTML/Stitch prototype located under `meno.prototipe/stitch_meno_bible_habit_app/` serves strictly as a **visual and interaction reference**.

* It models screen layouts, color applications, mascot moments, and tactile button feedback.
* The production application is built **natively using Flutter widgets** (`StatelessWidget`, `StatefulWidget`).
* WebViews will **not** be used to display prototype HTML files.

---

## 13. Flutter Theme Architecture

Design tokens are declared in pure Dart classes and wired to Flutter's `ThemeData`:

```text
lib/core/theme/
├── meno_colors.dart        # Static Color constants (#006964, #FEA619, etc.)
├── meno_typography.dart    # TextTheme definitions pairing Outfit & Plus Jakarta Sans
├── Supported font files:   # Google Fonts asset configuration for offline loading
│   ├── Outfit-Bold.ttf
│   ├── Outfit-SemiBold.ttf
│   ├── PlusJakartaSans-Regular.ttf
│   └── PlusJakartaSans-Medium.ttf
└── meno_theme.dart         # Returns ThemeData configured with Meno tokens
```

---

## 14. Design Acceptance Criteria

A screen is considered visually compliant with Meno when:

1. It uses colors strictly from the defined Meno palette (`#006964`, `#FEA619`, `#FBF9F6`, etc.).
2. It pairs **Outfit** for headings/numbers with **Plus Jakarta Sans** for body/reading text.
3. Primary action buttons implement the 4dp bottom bevel (`#00504C`) tactile interaction.
4. Screen layouts conform to the 8dp grid spacing system.
5. Scripture reading passages maintain at least 1.5 line height and 17dp text size on warm background surfaces.
6. Appropriate loading, empty, and error state widgets are provided.

---

## End of Design System Specification
