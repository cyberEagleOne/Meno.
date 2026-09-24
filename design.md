# Meno — Design System & UI/UX Specification

> **Meno — Read. Remain. Grow.**
>
> UI/UX and visual design specification for the Meno Android MVP.

---

## 1. Design Overview

Meno is a gamified Bible reading application designed to help users build a consistent Scripture reading habit.

The visual design should communicate:

- Welcoming
- Calm
- Encouraging
- Playful
- Modern
- Trustworthy
- Motivating
- Spiritual without being overly formal

Meno takes inspiration from the engagement principles of modern gamified learning applications, while maintaining its own visual identity.

The interface should feel:

> **Fun enough to encourage users to return, but mature enough to feel like a meaningful reading application.**

---

## 2. Design Goals

The Meno design system has five primary goals:

1. Make Bible reading feel approachable for beginners.
2. Make progress visible and rewarding.
3. Create a welcoming experience rather than a rigid reading tool.
4. Maintain visual consistency across the application.
5. Support fast and comfortable interaction on mobile devices.

---

## 3. Core Design Principles

### 3.1 Welcoming Over Formal

Meno should feel approachable.

Avoid making the interface feel like:

- A traditional Bible study application
- A corporate productivity dashboard
- A school assignment
- A dense reading/reference tool

Prefer:

- Friendly language
- Rounded components
- Soft visual hierarchy
- Encouraging feedback
- Character-driven moments

---

### 3.2 Playful but Not Childish

Meno uses gamification and illustration, but the application is not intended to look like a children's application.

The visual balance should be:

```text
Playful
   │
   ├── Mascot
   ├── Friendly illustrations
   ├── XP
   ├── Streaks
   └── Celebration
   │
   ▼
Modern & Mature
   │
   ├── Clean typography
   ├── Controlled colors
   ├── Simple layouts
   └── Strong readability
````

Avoid:

* Excessive cartoon elements
* Baby-like illustrations
* Too many bright colors
* Overly exaggerated expressions
* Excessive decorative elements

---

### 3.3 Progress Should Feel Visible

Users should understand:

* What they are reading
* What they have completed
* How much progress they have made
* What they should do next

Progress should be visually obvious without overwhelming the screen.

---

### 3.4 One Primary Action

Each screen should have a clear primary action.

Examples:

```text
Home
→ Continue Reading

Journey
→ Start Reading

Reading
→ Complete Reading

Completion
→ Continue
```

Secondary actions should have lower visual priority.

---

### 3.5 Reduce Cognitive Load

The application is designed for users who may not know:

* Where to begin reading
* Which book to choose
* What order to follow
* How much to read

Meno should make these decisions simple through guided journeys.

---

# 4. Brand Identity

## 4.1 Brand Name

**Meno**

The name is short, friendly, memorable, and visually flexible.

---

## 4.2 Tagline

> **Read. Remain. Grow.**

The tagline represents the core product philosophy:

```text
Read
  ↓
Build consistency
  ↓
Remain
  ↓
Develop a habit
  ↓
Grow
```

---

## 4.3 Brand Personality

Meno should feel:

| Trait     | Direction   |
| --------- | ----------- |
| Friendly  | High        |
| Welcoming | High        |
| Playful   | Medium–High |
| Calm      | Medium–High |
| Modern    | High        |
| Spiritual | Present     |
| Formal    | Low         |
| Childish  | Low         |
| Corporate | Low         |

---

# 5. Color System

Meno uses a teal-based primary palette with orange as an energetic accent.

## 5.1 Primary Colors

### Meno Teal

```text
#006964
```

Primary brand color.

Used for:

* Primary buttons
* Navigation
* Important actions
* Progress indicators
* Selected states
* Brand elements

---

### Meno Teal Light

```text
#10847E
```

Secondary teal.

Used for:

* Secondary actions
* Supporting UI
* Cards
* Interactive elements
* Visual variation

---

### Meno Orange

```text
#FEA619
```

Accent color.

Used for:

* XP
* Rewards
* Streak highlights
* Celebration
* Important gamification feedback
* Small attention-grabbing elements

Orange should be used as an accent rather than the dominant screen color.

---

## 5.2 Background

Primary background should use a warm off-white rather than pure white.

Example:

```text
#FFFDF8
```

This creates a softer reading environment.

---

## 5.3 Text Colors

Primary text:

```text
#1F2937
```

Secondary text:

```text
#667085
```

Muted text:

```text
#98A2B3
```

These colors should maintain sufficient contrast against the background.

---

## 5.4 Semantic Colors

Success:

```text
#2E9B63
```

Warning:

```text
#F4A340
```

Error:

```text
#D64545
```

Information:

```text
#3B82A0
```

Semantic colors should not replace the primary Meno palette.

They should only communicate system states.

---

# 6. Typography

Meno uses **Outfit** as the primary typeface.

Outfit provides a modern and friendly appearance while remaining readable.

## 6.1 Typography Hierarchy

### Display

Used for:

* Major onboarding statements
* Celebration moments
* Large progress numbers

Suggested:

```text
Outfit Bold
32–40sp
```

---

### Heading 1

Used for:

* Screen titles
* Major sections

```text
Outfit Bold
26–30sp
```

---

### Heading 2

Used for:

* Card titles
* Section headings

```text
Outfit SemiBold
20–24sp
```

---

### Body

Used for:

* Descriptions
* Scripture supporting information
* Explanations

```text
Outfit Regular
15–17sp
```

---

### Caption

Used for:

* Metadata
* Supporting information
* Small labels

```text
Outfit Medium
12–14sp
```

---

### Button Text

```text
Outfit SemiBold
14–16sp
```

---

## 6.2 Typography Rules

Do:

* Use clear hierarchy
* Keep body text comfortable to read
* Use weight to establish importance
* Keep Scripture text highly readable

Avoid:

* Excessive font weights
* All-caps paragraphs
* Extremely small text
* Decorative fonts
* Multiple font families

---

# 7. Spacing System

Use an 8dp-based spacing system.

```text
4dp   → micro spacing
8dp   → small spacing
12dp  → compact spacing
16dp  → standard spacing
24dp  → section spacing
32dp  → major spacing
40dp  → large separation
48dp  → major visual separation
```

The most common spacing values should be:

```text
8
16
24
32
```

Consistency is more important than using every available value.

---

# 8. Layout System

Meno is designed primarily for mobile portrait screens.

Default structure:

```text
┌─────────────────────────┐
│       Top Area          │
├─────────────────────────┤
│                         │
│       Main Content      │
│                         │
│                         │
├─────────────────────────┤
│     Primary Action      │
└─────────────────────────┘
```

Screens should maintain comfortable horizontal padding.

Recommended default:

```text
16dp
```

Larger content blocks may use:

```text
20–24dp
```

---

# 9. Shape System

Meno uses rounded shapes to reinforce the friendly visual language.

## 9.1 Corner Radius

Recommended values:

```text
Small:
8dp

Medium:
12dp

Large:
16dp

Extra Large:
24dp

Pill:
50%
```

Primary cards should generally use:

```text
16–20dp
```

---

## 9.2 Buttons

Primary buttons:

```text
Rounded
12–16dp
```

Secondary buttons:

```text
Rounded
12–16dp
```

Pill-shaped buttons may be used for:

* Filters
* Tags
* XP indicators
* Small status elements

---

# 10. Elevation and Shadows

Meno should avoid excessive material elevation.

Prefer:

* Subtle shadows
* Soft borders
* Background contrast
* Layered cards

Cards should feel separated without looking heavily raised.

Example hierarchy:

```text
Background
   ↓
Card
   ↓
Primary content
```

Avoid:

```text
Heavy shadow
+ strong border
+ strong gradient
+ multiple layers
```

at the same time.

---

# 11. Illustration & Mascot System

The mascot is an important part of Meno's personality.

However, it should be used intentionally.

## 11.1 Mascot Purpose

The mascot can:

* Welcome the user
* Encourage progress
* Celebrate completion
* Explain empty states
* Appear during onboarding
* Provide emotional feedback

---

## 11.2 Mascot Usage

Good usage:

```text
Onboarding
     ↓
Welcome mascot

Reading completion
     ↓
Celebration mascot

Empty state
     ↓
Helpful mascot
```

Avoid placing the mascot:

* On every screen
* Behind important text
* Inside every card
* As decoration without purpose

---

## 11.3 Mascot Personality

The mascot should communicate:

* Friendly
* Encouraging
* Curious
* Supportive
* Positive

Avoid making the mascot:

* Too childish
* Overly exaggerated
* Visually dominant
* Distracting

---

# 12. Iconography

Icons should use a consistent modern icon set.

Preferred characteristics:

* Simple
* Rounded
* Recognizable
* Minimal
* Consistent stroke weight

Icons should support text rather than replace important labels.

Examples:

```text
Home
Book
Journey
Progress
Profile
Bell
Flame
Star
Check
Arrow
```

---

# 13. Component System

Meno should use reusable UI components.

Recommended components:

```text
MenoButton
MenoSecondaryButton
MenoCard
MenoProgressBar
MenoChip
MenoTopBar
MenoBottomNavigation
MenoStatCard
MenoReadingCard
MenoJourneyCard
MenoMascot
MenoSectionHeader
MenoEmptyState
MenoLoadingState
MenoErrorState
```

Reusable components should be placed in:

```text
ui/components/
```

---

# 14. Primary Button

Primary buttons represent the main action.

Example:

```text
┌─────────────────────────┐
│      Continue Reading   │
└─────────────────────────┘
```

Characteristics:

* Meno Teal background
* High contrast text
* Rounded corners
* Comfortable touch target
* Clear action-oriented label

Examples:

```text
Continue Reading
Start Journey
Begin Reading
Complete Reading
Continue
```

Avoid vague labels such as:

```text
OK
Next
Click Here
Submit
```

when a more meaningful action can be shown.

---

# 15. Secondary Button

Secondary buttons should support the primary action.

Example:

```text
┌─────────────────────────┐
│        View Journey     │
└─────────────────────────┘
```

Visual treatment can use:

* Teal outline
* Light teal background
* Neutral surface

Secondary buttons should not compete visually with the primary button.

---

# 16. Cards

Cards are used to group related information.

Examples:

```text
Today's Reading
─────────────────────────
John 1:1–18

Read today's passage
              →
```

Journey card:

```text
Gospel Starter
─────────────────────────
Build your reading habit
from the beginning.

████████░░  80%

Continue →
```

Cards should have:

* Clear title
* Supporting information
* Strong hierarchy
* Appropriate padding
* One obvious action when applicable

---

# 17. Progress Components

Progress is a core part of Meno.

Possible progress representations:

### Linear Progress

```text
████████░░░░
```

Used for:

* Journey completion
* Daily progress

### Circular Progress

Used when:

* Showing percentage
* Highlighting a single metric

### Streak

Example:

```text
🔥 7 day streak
```

### XP

Example:

```text
⭐ 120 XP
```

Progress components should feel rewarding but not overly game-like.

---

# 18. Gamification Design

Gamification should encourage consistency rather than become the primary purpose of the application.

Core mechanics:

```text
Reading
   ↓
Completion
   ↓
XP
   ↓
Streak
   ↓
Visible Progress
   ↓
Motivation to continue
```

---

## 18.1 XP

XP is a lightweight reward for completing readings.

Example:

```text
+10 XP
```

XP can be displayed:

* On completion
* In the home screen
* In the progress screen
* In the profile screen

---

## 18.2 Streak

Example:

```text
🔥 7
Day Streak
```

The visual treatment should communicate achievement without creating pressure.

---

## 18.3 Completion Celebration

After finishing a reading:

```text
        ✓

    Reading Complete!

      +10 XP
    🔥 7 day streak

      Continue
```

Optional:

* Mascot animation
* Small confetti
* Scale animation
* XP counter animation

Animations should remain short and subtle.

---

# 19. Onboarding Design

The onboarding experience introduces the purpose of Meno.

Goals:

* Explain the application
* Make the user feel welcomed
* Reduce uncertainty
* Guide the user toward their first reading

Suggested structure:

```text
Welcome
   ↓
What is Meno?
   ↓
Choose Reading Journey
   ↓
Set Daily Goal
   ↓
Start Reading
```

The onboarding should not contain excessive text.

Each screen should communicate one primary idea.

---

# 20. Home Screen

The home screen is the user's main starting point.

Priority hierarchy:

```text
1. Today's Reading
2. Current Streak
3. XP / Progress
4. Journey Progress
5. Supporting content
```

Example structure:

```text
Good morning!

🔥 7 day streak

Today's Reading
──────────────────
John 1:1–18

Read today's passage
          →

Journey
──────────────────
Gospel Starter

████████░░
8 / 10 readings
```

The primary reading action should be visually dominant.

---

# 21. Journey Screen

The Journey screen shows the user's guided reading path.

Example:

```text
Gospel Starter

Your Journey

✓ Reading 1
✓ Reading 2
✓ Reading 3
● Reading 4
○ Reading 5
○ Reading 6
```

The current reading should have the strongest visual emphasis.

Completed readings should be recognizable but visually secondary.

Locked or upcoming readings should remain understandable without appearing inaccessible or frustrating.

---

# 22. Reading Screen

The reading screen prioritizes Scripture readability.

Recommended structure:

```text
← John 1

John 1:1–18

"In the beginning..."

[ Scripture Text ]

────────────────────

        Complete
```

Important principles:

* Minimal distractions
* Comfortable line height
* Large enough reading text
* Strong contrast
* Clear progress context
* Fixed or easily accessible completion action

Avoid unnecessary gamification elements while the user is actively reading.

---

# 23. Scripture Typography

Scripture text should receive special treatment.

Recommended:

```text
Font:
Outfit Regular

Size:
17–19sp

Line Height:
1.5–1.7

Paragraph Spacing:
16–24dp
```

The exact values may be adjusted after device testing.

The reading experience should prioritize comfort over compactness.

---

# 24. Completion Screen

The completion screen is an emotional reward moment.

Suggested hierarchy:

```text
Mascot / Illustration

Reading Complete!

+10 XP

🔥 7 day streak

Journey Progress
████████░░

[ Continue ]
```

The screen should feel:

* Rewarding
* Warm
* Positive
* Brief

It should not become a complex statistics dashboard.

---

# 25. Progress Screen

The Progress screen provides a simple overview of activity.

Possible information:

```text
Your Progress

🔥 Current Streak
7 days

⭐ Total XP
120 XP

📖 Readings Completed
12

Journey Progress
████████░░
80%
```

The screen should prioritize useful information over excessive metrics.

---

# 26. Profile Screen

The Profile screen contains user preferences and lightweight settings.

Possible sections:

```text
Profile

Reading Journey
Gospel Starter

Daily Reminder
07:00 PM

Notifications
On

About Meno
```

The MVP should avoid unnecessary profile complexity because users do not have accounts.

---

# 27. Reminder Settings

Reminder settings should be simple.

Example:

```text
Daily Reading Reminder

[ ON ]

Reminder Time

07:00 PM

You will receive a reminder
to continue your reading journey.
```

Use clear language.

Avoid overly technical notification settings.

---

# 28. Navigation Bar

If bottom navigation is used, it should contain only the most important destinations.

Recommended:

```text
Home
Journey
Progress
Profile
```

The currently selected destination should use the primary Meno color.

The navigation bar should not contain too many items.

---

# 29. Interaction States

Every interactive component should account for multiple states.

### Default

Normal appearance.

### Pressed

Slight visual feedback.

### Disabled

Reduced emphasis.

### Loading

Display progress indication.

### Success

Display successful completion feedback.

### Error

Display a clear recovery action.

Example:

```text
Default
   ↓
Pressed
   ↓
Loading
   ↓
Success
```

---

# 30. Loading States

Loading states should feel lightweight.

Avoid large blocking loading screens unless necessary.

Preferred:

```text
Small progress indicator
+
Existing screen structure
```

Skeleton loading can be introduced later if required.

---

# 31. Empty States

Empty states should explain what the user can do next.

Example:

```text
No reading history yet.

Complete your first reading
to start building your progress.

[ Start Reading ]
```

A mascot may be used when it helps communicate the message.

---

# 32. Error States

Errors should be friendly and actionable.

Example:

```text
Something went wrong.

We couldn't load this reading.

[ Try Again ]
```

Avoid technical messages such as:

```text
SQLiteException
NullPointerException
JSON parsing error
```

in the user-facing UI.

---

# 33. Motion & Animation

Animation should reinforce interaction rather than distract from content.

Recommended animation moments:

* Button press
* XP increase
* Progress update
* Completion
* Mascot reaction
* Screen transitions

Recommended duration:

```text
Short:
150–200ms

Standard:
200–300ms

Celebration:
300–600ms
```

Avoid:

* Constant movement
* Long transitions
* Excessive bouncing
* Animation during Scripture reading

---

# 34. Gamification Feedback Animation

A completion animation can follow:

```text
Complete
   ↓
Checkmark appears
   ↓
XP counter increases
   ↓
Streak updates
   ↓
Mascot reacts
   ↓
Continue button appears
```

The sequence should be quick enough that the user can continue without waiting.

---

# 35. Accessibility

Meno should remain usable for a wide range of users.

### Requirements

* Sufficient color contrast
* Readable text sizes
* Adequate touch targets
* Content descriptions for meaningful icons
* Avoid relying only on color
* Support system font scaling where practical
* Avoid overly dense layouts

Interactive elements should generally provide a comfortable touch target.

---

# 36. Responsive & Adaptive Layout

Although Meno is primarily designed for phones, layouts should avoid assuming one exact screen size.

The UI should adapt to:

* Small phones
* Standard phones
* Large phones
* Landscape where applicable
* Accessibility font scaling

Content should use:

* Flexible width
* Scrollable containers
* Adaptive spacing
* Responsive components

Avoid hardcoding large fixed dimensions where possible.

---

# 37. Design Tokens

The design system should centralize reusable visual values.

Example:

```kotlin
object MenoColors {
    val Primary = Color(0xFF006964)
    val Secondary = Color(0xFF10847E)
    val Accent = Color(0xFFFEA619)
    val Background = Color(0xFFFFFDF8)
    val TextPrimary = Color(0xFF1F2937)
    val TextSecondary = Color(0xFF667085)
}
```

Spacing:

```kotlin
object MenoSpacing {
    val XS = 4.dp
    val SM = 8.dp
    val MD = 16.dp
    val LG = 24.dp
    val XL = 32.dp
}
```

Corner radius:

```kotlin
object MenoShapes {
    val Small = 8.dp
    val Medium = 12.dp
    val Large = 16.dp
    val ExtraLarge = 24.dp
}
```

The exact implementation can be adjusted to fit the project's Compose theme structure.

---

# 38. Jetpack Compose Mapping

The design system should map directly to reusable Compose components.

Example:

```text
Design System
      ↓
Compose Theme
      ↓
Reusable Components
      ↓
Screen UI
```

Suggested structure:

```text
ui/
├── components/
│   ├── MenoButton.kt
│   ├── MenoCard.kt
│   ├── MenoProgressBar.kt
│   ├── MenoStatCard.kt
│   ├── MenoReadingCard.kt
│   └── MenoMascot.kt
│
└── theme/
    ├── Color.kt
    ├── Type.kt
    ├── Shape.kt
    └── Theme.kt
```

---

# 39. Design-to-Architecture Relationship

The design system should align with the application architecture.

```text
┌─────────────────────────────────┐
│           Design System         │
│                                 │
│ Colors                          │
│ Typography                     │
│ Shapes                         │
│ Components                     │
└───────────────┬─────────────────┘
                │
                ▼
┌─────────────────────────────────┐
│        Presentation Layer       │
│                                 │
│ Compose Screens                 │
│ ViewModels                      │
│ UI State                        │
└───────────────┬─────────────────┘
                │
                ▼
┌─────────────────────────────────┐
│         Domain + Data           │
│                                 │
│ Business Logic                  │
│ Progress                        │
│ Scripture                       │
│ Persistence                     │
└─────────────────────────────────┘
```

Design decisions should not introduce unnecessary changes to the underlying application architecture.

---

# 40. Visual Hierarchy

Every screen should establish a clear hierarchy.

Recommended order:

```text
Primary Information
        ↓
Primary Action
        ↓
Supporting Information
        ↓
Secondary Actions
```

Example Home screen:

```text
Today's Reading
        ↓
Read Today's Passage
        ↓
Streak / XP
        ↓
Journey Progress
```

This prevents screens from becoming visually noisy.

---

# 41. Content & Microcopy

Meno's language should be:

* Short
* Friendly
* Encouraging
* Clear
* Human

Prefer:

```text
Keep going!
You're building a habit.

Ready for today's reading?

You've got this.

Reading complete!
```

Avoid overly formal language:

```text
Your Scripture reading task
has been successfully completed.
```

The application should feel like a supportive companion rather than an instructor.

---

# 42. Microcopy for Gamification

XP:

```text
+10 XP
```

Streak:

```text
🔥 7 day streak
```

Completion:

```text
Reading complete!
```

Progress:

```text
You're 80% through this journey.
```

Encouragement:

```text
Keep going!
One reading at a time.
```

Avoid excessive motivational messages on every interaction.

---

# 43. Do & Don't

## Do

* Use rounded cards
* Use consistent spacing
* Use teal as the main brand color
* Use orange as an accent
* Use mascot moments intentionally
* Make progress visible
* Keep Scripture highly readable
* Use friendly microcopy
* Keep primary actions obvious
* Maintain visual consistency

## Don't

* Use too many colors
* Put the mascot everywhere
* Make every screen highly animated
* Overuse gradients
* Make the app look like a children's game
* Make the reading screen visually noisy
* Use excessive shadows
* Create unnecessary dashboards
* Use tiny text
* Add unnecessary UI elements

---

# 44. MVP Design Scope

The MVP design includes:

```text
✓ Brand identity
✓ Color system
✓ Typography
✓ Design tokens
✓ Onboarding
✓ Home
✓ Journey
✓ Reading
✓ Completion
✓ Progress
✓ Profile
✓ Reminder settings
✓ Mascot system
✓ Gamification components
✓ Navigation
✓ Loading states
✓ Empty states
✓ Error states
✓ Accessibility foundation
```

---

# 45. Future Design Expansion

Potential future additions:

```text
Advanced statistics
Achievements
Badges
Multiple journeys
Multiple Scripture translations
Bookmarks
Highlights
Notes
Social features
Leaderboards
Profile customization
Themes
Dark mode
```

These should only be added when they provide meaningful value.

---

# 46. Source of Truth

The following hierarchy should be used when implementing the design:

```text
1. Meno Design System
        ↓
2. Reusable Compose Components
        ↓
3. Screen Specifications
        ↓
4. Individual Screen Implementation
```

If a screen conflicts with the design system, the reusable design system should generally take priority.

---

# 47. Design Acceptance Criteria

A screen is considered visually aligned with Meno when:

* It uses the Meno color system.
* It uses the defined typography hierarchy.
* It follows the spacing system.
* It uses consistent corner radii.
* It has a clear primary action.
* It maintains readable visual hierarchy.
* It does not introduce unnecessary colors.
* It does not overuse illustrations.
* It supports appropriate loading/error/empty states.
* It remains consistent with the welcoming but mature personality.

---

# 48. Final Design Direction

Meno should ultimately feel like:

> **A welcoming reading companion that makes building a Bible reading habit feel simple, rewarding, and enjoyable.**

The visual experience should combine:

```text
Modern UI
     +
Friendly Illustration
     +
Light Gamification
     +
Strong Readability
     +
Calm Spiritual Atmosphere
```

The target feeling is:

```text
"I want to come back tomorrow."
```

rather than:

```text
"I have to complete a task."
```

Meno should encourage consistency through positive reinforcement, visible progress, and a warm visual identity while keeping Scripture reading itself calm and distraction-free.

---

## End

```
```
