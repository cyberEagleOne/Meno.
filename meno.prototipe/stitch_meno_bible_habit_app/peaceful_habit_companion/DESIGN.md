---
name: Peaceful Habit Companion
colors:
  surface: '#fbf9f6'
  surface-dim: '#dbdad7'
  surface-bright: '#fbf9f6'
  surface-container-lowest: '#ffffff'
  surface-container-low: '#f5f3f0'
  surface-container: '#efeeeb'
  surface-container-high: '#eae8e5'
  surface-container-highest: '#e4e2df'
  on-surface: '#1b1c1a'
  on-surface-variant: '#3e4948'
  inverse-surface: '#30312f'
  inverse-on-surface: '#f2f0ed'
  outline: '#6e7978'
  outline-variant: '#bdc9c7'
  surface-tint: '#006a65'
  primary: '#006964'
  on-primary: '#ffffff'
  primary-container: '#10847e'
  on-primary-container: '#ffffff'
  inverse-primary: '#77d6cf'
  secondary: '#855300'
  on-secondary: '#ffffff'
  secondary-container: '#fea619'
  on-secondary-container: '#684000'
  tertiary: '#ab3035'
  on-tertiary: '#ffffff'
  tertiary-container: '#cd484b'
  on-tertiary-container: '#ffffff'
  error: '#ba1a1a'
  on-error: '#ffffff'
  error-container: '#ffdad6'
  on-error-container: '#93000a'
  primary-fixed: '#94f3eb'
  primary-fixed-dim: '#77d6cf'
  on-primary-fixed: '#00201e'
  on-primary-fixed-variant: '#00504c'
  secondary-fixed: '#ffddb8'
  secondary-fixed-dim: '#ffb95f'
  on-secondary-fixed: '#2a1700'
  on-secondary-fixed-variant: '#653e00'
  tertiary-fixed: '#ffdad8'
  tertiary-fixed-dim: '#ffb3b0'
  on-tertiary-fixed: '#410006'
  on-tertiary-fixed-variant: '#8b1721'
  background: '#fbf9f6'
  on-background: '#1b1c1a'
  surface-variant: '#e4e2df'
typography:
  display-lg:
    fontFamily: Outfit
    fontSize: 40px
    fontWeight: '700'
    lineHeight: 48px
  display-lg-mobile:
    fontFamily: Outfit
    fontSize: 30px
    fontWeight: '700'
    lineHeight: 38px
  headline-lg:
    fontFamily: Outfit
    fontSize: 28px
    fontWeight: '600'
    lineHeight: 36px
  headline-sm:
    fontFamily: Outfit
    fontSize: 20px
    fontWeight: '600'
    lineHeight: 28px
  title-md:
    fontFamily: Plus Jakarta Sans
    fontSize: 18px
    fontWeight: '600'
    lineHeight: 26px
  body-lg:
    fontFamily: Plus Jakarta Sans
    fontSize: 18px
    fontWeight: '400'
    lineHeight: 30px
  body-md:
    fontFamily: Plus Jakarta Sans
    fontSize: 15px
    fontWeight: '400'
    lineHeight: 24px
  label-lg:
    fontFamily: Plus Jakarta Sans
    fontSize: 14px
    fontWeight: '600'
    lineHeight: 20px
  label-sm:
    fontFamily: Plus Jakarta Sans
    fontSize: 12px
    fontWeight: '500'
    lineHeight: 16px
rounded:
  sm: 0.25rem
  DEFAULT: 0.5rem
  md: 0.75rem
  lg: 1rem
  xl: 1.5rem
  full: 9999px
spacing:
  gutter: 1rem
  margin: 1.25rem
  space-xs: 0.25rem
  space-sm: 0.5rem
  space-md: 1rem
  space-lg: 1.5rem
  space-xl: 2.25rem
---

## Brand & Style

This design system blends the deliberate calm of contemplative devotion with the warm, motivating delight of habit-forming mechanics. Built for believers and seekers desiring consistency without anxiety, the interface replaces urgency and streak-shaming with peaceful invitation, gentle progress, and restorative warmth.

The design movement bridges **Tactile Warmth** and **Friendly Minimalism**:
- **Tactile Softness:** Dimensional, pillowy surfaces that feel satisfying to touch, paired with pill-shaped buttons possessing subtle bottom-lip shadows for physical feedback.
- **Organic Serenity:** Generous margins, warm parchment canvases, and pill-shaped elements that eliminate harsh angles and computational rigidity.
- **Grounded Playfulness:** Guided by the mascot illustrations—a warm, round character carrying open books and warm drinks—gamification remains humble, pastoral, and encouraging rather than noisy or arcade-like.

## Colors

The palette balances restorative green-teals, inviting warm creams, and joyful yet restrained accents.

- **Primary Teal (`#10847E`, dark `#0D6E69`, tint `#E6F4F1`):** Represents spiritual peace, renewal, and clarity. Used for primary calls-to-action, active journey nodes, completed milestones, and top-level navigation states.
- **Warm Neutral (`#FAF8F5` surface, `#F4EFEA` container, `#EDE6DE` border):** Evokes rich, tactile bible paper and linen. Avoids harsh digital whites (`#FFFFFF` is reserved strictly for elevated card faces). Text sits on deep warm espresso charcoal (`#2D2A26`) to preserve reading comfort over long sessions.
- **Streak & Warmth Amber (`#F59E0B`, tint `#FEF3C7`):** Celebrates daily consistency, inner flame, and spiritual warmth without using stress-inducing reds.
- **Praise Coral (`#F26465`, tint `#FEE2E2`):** Reserved for badges, celebration highlights, and warm character interactions.
- **Contemplative Violet (`#8B5CF6`, tint `#EDE9FE`) & Sky (`#38BDF8`, tint `#E0F2FE`):** Applied selectively to reflection prompts, prayer requests, and audio/psalm moments.

## Typography

The typographic hierarchy harmonizes geometric friendliness with devotional clarity:

- **Outfit (Headings & Milestones):** Clean, rounded, confident sans-serif. Used for screen titles, celebration amounts (`+25 XP`), streak counters, and path milestones. Its open geometric curves lend approachable authority.
- **Plus Jakarta Sans (Interface & Reading):** Highly legible, humanistic, and friendly. Standard body copy maintains generous 1.6–1.7x line-height ratios to prevent eye strain during sustained scripture reading.
- **Reading View:** Scripture reading utilizes `body-lg` at 18px with relaxed line spacing (30px) and dark warm ink (`#24211E`) against the `#FAF8F5` surface to honor the rhythm of slow, meditative reading.

## Layout & Spacing

The layout is mobile-first, centering around a single-column devotional path and card-driven dashboard.

- **Mobile Viewport (< 640px):** Single-column fluid stack with `1.25rem` (20px) safe margins. Journey nodes (representing daily readings) snake vertically down the center line with organic left/right offsets of `1.5rem` to `2.5rem`, creating an engaging path to walk.
- **Tablet / Desktop (≥ 640px):** Content is locked to a focused reading column max-width of `480px` to `680px`. Floating navigation bars dock at the bottom of the safe viewport or pin cleanly to the side without sprawling.
- **Rhythm:** Spacing tokens govern internal card padding (`space-lg` = 24px) and layout breathing room (`space-xl` = 36px between distinct journey phases), preventing clutter and visual noise.

## Elevation & Depth

Visual hierarchy uses physical, pillowy depth rather than cold, high-altitude drop shadows:

- **Base Canvas:** Flat warm cream (`#FAF8F5`) with no shadow.
- **Surface Cards:** Pure `#FFFFFF` elevated above the cream canvas with an ultra-soft ambient shadow: `0 4px 16px rgba(45, 42, 38, 0.05)`. Finished with a delicate, tone-on-tone border (`1.5px solid #F0EAE1`).
- **Tactile Buttons & Journey Nodes:** Gamified elements feature physical bottom depth. Instead of blur, they use a solid 4px base offset:
  - Primary Teal button: background `#10847E`, bottom edge shadow `0 4px 0 #0B5C57`.
  - Amber Streak pill: background `#F59E0B`, bottom edge shadow `0 3px 0 #D97706`.
  - When pressed, the element translates `2px` down along the Y-axis and reduces the bottom shadow to `1px`, providing responsive physical haptics.
- **Modal Overlays:** Warm tinted backdrops (`rgba(45, 42, 38, 0.45)`) featuring an 8px gaussian blur to softly unfocus background Scripture and bring reflections or badge celebrations to the forefront.

## Shapes

The shape system is friendly, soft, and organic:

- **Cards & Reading Panels:** `20px` to `24px` corner radii (`rounded-xl`), creating inviting containers that feel comfortable in the palm.
- **Interactive Chips & Controls:** Full pill shapes (`rounded-full` / 9999px) for streak badges, XP counters, tags, and secondary pills.
- **Milestone Nodes:** Perfect circles (`64px` to `76px` diameter) along the journey path, with an inner inset ring or glowing pulse state to indicate "Today's Reading."
- **Mascot Anchors:** Character artwork sits inside soft organic blobs or grounded circular platforms to integrate naturally into UI cards.

## Components

### Buttons
- **Primary Action (e.g., "Start Reading", "Continue Journey"):** Full-width or auto pill button in `#10847E` with white bold typography (`label-lg`), 4px bottom bevel (`#0B5C57`), and a tactile press state.
- **Secondary / Ghost:** Soft cream background (`#F4EFEA`) with `#0D6E69` text and a subtle 1.5px outline (`#E0D7CD`), depressing 2px on tap.

### Journey Pathway Nodes
- **Active Node:** A 72px circular button in `#10847E` featuring an open book or star icon, surrounded by an animated glowing concentric ring in `#E6F4F1`. Above it floats a friendly speech bubble tooltip ("Today's Reading") anchored with a small downward triangle.
- **Completed Node:** 64px circle in soft primary tint (`#E6F4F1`) with a deep teal checkmark.
- **Locked Node:** 60px circle in muted neutral (`#E9E3DB`) with an engraved lock glyph.

### Streak & XP Badges
- Compact pill-shaped modules displayed in the app header:
  - **Streak Pill:** Amber icon (flame/sprout) alongside the streak number (e.g., "🔥 7 Days") on a warm `#FEF3C7` background.
  - **XP Pill:** Subtle teal container (`#E6F4F1`) with bold text (`+25 XP`) that floats upward with an ease-out bounce when a reading completes.

### Scripture Reading View
- A distraction-free reading card:
  - Header displays chapter name and progress bar (`4px` height, filled with primary teal).
  - High-readability verses with soft verse numbers in muted tertiary tones (`#A39E97`).
  - Bottom sticky bar housing the "Complete Reading" tactile button.

### Completion & Celebration Sheet
- A cheerful modal presenting the bean character celebrating with open arms.
- Displays sequential reward summaries: `+XP Earned`, `Streak Updated`, and `Chapter Complete`.
- Concludes with a single pill button: "Return Home."