# Meno — Design System

## 1. Overview

Meno is a mobile Bible reading habit application designed to help users build a consistent reading routine through guided reading journeys and gentle gamification.

The design combines:

* Calm and contemplative visual language
* Friendly and approachable interactions
* Gamification inspired by habit-building applications
* Clear reading-focused interfaces
* A warm visual identity that feels welcoming without looking childish

Meno should feel like a **peaceful reading companion**, rather than a traditional Bible study application or a children's learning app.

---

# 2. Design Principles

## 2.1 Calm First

Meno should create a sense of calm and focus.

Avoid:

* Aggressive notifications
* Excessive animations
* Streak-shaming
* Overly competitive elements
* Visually overwhelming screens

The interface should encourage users to return without making them feel guilty when they miss a day.

---

## 2.2 Friendly, Not Childish

Meno takes inspiration from the welcoming interaction design of gamified learning applications such as Duolingo, while maintaining a more mature visual identity.

The interface can be:

* Playful
* Warm
* Expressive
* Character-driven
* Rewarding

But should avoid looking like a children's education application.

---

## 2.3 Tactile Warmth

UI elements should feel soft and approachable.

Use:

* Rounded cards
* Pill-shaped buttons
* Soft shadows
* Subtle depth
* Generous spacing
* Warm neutral backgrounds

Interactive elements should feel tangible without becoming visually heavy.

---

## 2.4 Gentle Gamification

Gamification exists to encourage consistency, not competition.

Primary mechanics:

* XP
* Streak
* Reading progress
* Journey progression
* Completion feedback

Celebration should feel encouraging rather than excessive.

---

# 3. Brand Identity

## Product Name

**Meno**

The name connects with the idea of:

* Memorizing
* Remembering
* Making notes
* Keeping something meaningful in mind

The brand should communicate a feeling of **remembering and returning to something meaningful**.

---

# 4. Visual Direction

## Overall Style

Meno follows a combination of:

### Friendly Minimalism

Clean layouts with enough visual personality to avoid feeling sterile.

### Organic Serenity

Warm neutral surfaces, soft rounded shapes, and generous whitespace.

### Grounded Playfulness

Mascot illustrations and gamification elements provide personality while maintaining a mature appearance.

---

# 5. Color System

Meno uses a warm neutral base with teal as its primary brand color.

## Primary

**Meno Teal**

```text
#10847E
```

Used for:

* Primary buttons
* Active navigation
* Active journey nodes
* Completion states
* Important actions
* Progress indicators

Supporting teal:

```text
Dark Teal: #0D6E69
Light Tint: #E6F4F1
```

---

## Warm Neutral

Main application background:

```text
#FAF8F5
```

Supporting surfaces:

```text
Container: #F4EFEA
Border: #EDE6DE
Primary Text: #2D2A26
White: #FFFFFF
```

White should primarily be used for elevated cards and important content surfaces.

---

## Amber

```text
#F59E0B
```

Used for:

* Streak
* Warmth
* XP highlights
* Positive rewards
* Small celebratory elements

Tint:

```text
#FEF3C7
```

---

## Coral

```text
#F26465
```

Used selectively for:

* Badges
* Celebrations
* Achievement feedback
* Important positive emphasis

Tint:

```text
#FEE2E2
```

---

## Secondary Accent Colors

Violet:

```text
#8B5CF6
```

Sky:

```text
#38BDF8
```

These colors should be used selectively for special content or future features such as reflections, prayer moments, or Psalm-related content.

They should not compete with teal as the primary brand color.

---

# 6. Typography

## Primary Typeface

**Outfit**

Outfit is currently used as Meno's primary typeface because of its clean, rounded, and modern appearance.

Typography should remain friendly while maintaining readability and maturity.

### Type Scale

```text
Display Large
Outfit
40px / 48px
Weight: 700

Display Large Mobile
Outfit
30px / 38px
Weight: 700

Headline Large
Outfit
28px / 36px
Weight: 600

Headline Small
Outfit
20px / 28px
Weight: 600

Title Medium
Outfit
18px / 26px
Weight: 600

Body Large
Outfit
18px / 30px
Weight: 400

Body Medium
Outfit
15px / 24px
Weight: 400

Label Large
Outfit
14px / 20px
Weight: 600

Label Small
Outfit
12px / 16px
Weight: 500
```

### Scripture Reading

Bible text should prioritize readability over decorative styling.

Recommended:

```text
Font size: 18px
Line height: 30px
Weight: 400
```

Scripture screens should have generous spacing between verses and avoid unnecessary UI distractions.

---

# 7. Layout

Meno follows a **mobile-first** layout.

## Horizontal Margins

Default:

```text
20px
```

Smaller supporting spacing:

```text
16px
```

---

## Content Width

On larger screens, reading and primary content should remain focused instead of stretching across the entire screen.

Recommended maximum content width:

```text
480–680px
```

---

# 8. Spacing System

```text
XS: 4px
SM: 8px
MD: 16px
LG: 24px
XL: 36px
```

Primary screen gutter:

```text
16–20px
```

Spacing should generally be generous to maintain the calm visual character of Meno.

---

# 9. Corner Radius

```text
Small: 4px
Default: 8px
Medium: 12px
Large: 16px
Extra Large: 24px
Pill: 9999px
```

Cards should generally use:

```text
20–24px
```

for the main Meno visual language.

---

# 10. Elevation and Shadows

Meno should use subtle elevation.

Preferred approach:

* Warm cream background
* White elevated cards
* Soft shadows
* Very subtle bottom depth on primary interactive components

Avoid strong black shadows or excessive Material elevation.

Primary buttons may use a subtle:

```text
4px bottom depth
```

to create a tactile feeling.

---

# 11. Buttons

## Primary Button

Characteristics:

* Teal background
* White text
* Bold label
* Pill shape
* Full width when used as the primary mobile action
* Subtle bottom depth

Example:

```text
┌─────────────────────────┐
│      START READING      │
└─────────────────────────┘
```

---

## Secondary Button

Characteristics:

* Warm neutral or transparent background
* Teal text
* Subtle border
* Pill shape

Used for secondary actions.

---

# 12. Journey Nodes

Reading journeys are represented using vertically connected nodes.

## Active Node

```text
Size: ~72px
Color: Meno Teal
```

Contains:

* Book icon
* Reading icon
* Star
* Other appropriate journey symbol

Active nodes may have a subtle glow.

---

## Completed Node

```text
Size: ~64px
```

Uses:

* Soft teal tint
* Checkmark
* Reduced visual emphasis compared to active nodes

---

## Locked Node

```text
Size: ~60px
```

Uses:

* Muted neutral colors
* Lock icon
* Lower visual contrast

---

# 13. Mascot

The Meno mascot is a recurring visual element that provides personality and emotional feedback.

The mascot should feel:

* Friendly
* Warm
* Expressive
* Simple
* Approachable
* Mature enough for young adults and adults

Possible visual context:

* Carrying an open book
* Sitting with a book
* Holding a warm drink
* Celebrating completion
* Encouraging the user

The mascot should support the interface rather than dominate every screen.

---

# 14. Gamification Components

## XP

XP should be visually associated with:

* Progress
* Completion
* Positive feedback

Example:

```text
⭐ 120 XP
```

---

## Streak

Streak uses amber as its primary visual accent.

Example:

```text
🔥 7 day streak
```

The design should celebrate consistency without punishing users for missing a day.

---

## Progress

Progress should be communicated through:

* Journey nodes
* Progress bars
* Completion states
* Chapter progress

Progress indicators should remain visually simple.

---

# 15. Scripture Reading Screen

The reading screen is one of the most important screens in Meno.

The primary objective is:

> **Help the user read without unnecessary distractions.**

Recommended structure:

```text
← Genesis 1

Genesis
Chapter 1

━━━━━━━ 60%

1  Scripture text...

2  Scripture text...

3  Scripture text...

...

┌─────────────────────┐
│   COMPLETE READING  │
└─────────────────────┘
```

Characteristics:

* Clear chapter heading
* Progress indicator
* Comfortable typography
* Generous line spacing
* Minimal distractions
* Sticky completion action when appropriate

---

# 16. Completion Screen

After completing a reading session, Meno provides gentle positive feedback.

Example:

```text
        📖
     Great job!

       +10 XP

    🔥 8 day streak

    Genesis 1 complete

   [ RETURN HOME ]
```

The mascot may appear on this screen.

Celebration should be short and satisfying rather than overwhelming.

---

# 17. Navigation

The navigation system should remain simple.

Primary destinations may include:

* Home
* Journey
* Progress
* Profile

The MVP should only expose navigation that is actually implemented.

Avoid creating empty or placeholder sections purely for visual completeness.

---

# 18. Accessibility

Meno should maintain:

* Readable text sizes
* Sufficient contrast
* Large touch targets
* Clear button labels
* Icons accompanied by text when necessary
* Avoidance of color-only communication

Scripture reading should prioritize comfortable long-form reading.

---

# 19. Responsive Behavior

Meno is designed mobile-first.

On larger screens:

* Maintain focused content width
* Avoid unnecessarily expanding reading text
* Keep major actions accessible
* Preserve the visual hierarchy of the mobile design

---

# 20. Design-to-Code Principles

The implementation should translate the design system into reusable Compose components.

Examples:

```text
MenoButton
MenoCard
MenoPill
MenoProgressBar
JourneyNode
XPBadge
StreakBadge
ScriptureText
CompletionCard
MascotContainer
```

Components should use centralized theme values rather than hard-coded colors throughout the application.

---

# 21. Design Goal

The final Meno interface should feel:

> **Peaceful enough to read.
> Friendly enough to return to.
> Rewarding enough to build a habit.**

Meno should take inspiration from the welcoming interaction philosophy of gamified learning applications while maintaining its own identity as a warm and mature Bible reading companion.
