import 'package:flutter/material.dart';
import '../../core/theme/meno_colors.dart';
import '../../core/theme/meno_typography.dart';
import '../../core/widgets/meno_button.dart';
import '../../core/widgets/meno_card.dart';
import '../../core/widgets/meno_chip.dart';
import '../../core/widgets/meno_mascot.dart';
import '../../core/widgets/meno_progress_bar.dart';
import '../../core/widgets/meno_secondary_button.dart';

/// Design System Showcase Screen for Meetings 1–2 foundation verification
class DesignSystemShowcaseScreen extends StatefulWidget {
  const DesignSystemShowcaseScreen({super.key});

  @override
  State<DesignSystemShowcaseScreen> createState() => _DesignSystemShowcaseScreenState();
}

class _DesignSystemShowcaseScreenState extends State<DesignSystemShowcaseScreen> {
  double _demoProgress = 0.6;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Meno Design System'),
      ),
      body: SafeArea(
        child: SingleChildScrollView(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              // Header Card with Brand Tagline & Mascot
              MenoCard(
                backgroundColor: MenoColors.warmSurface,
                child: Row(
                  children: [
                    const MenoMascot(
                      state: MascotState.waving,
                      size: 72,
                    ),
                    const SizedBox(width: 16),
                    Expanded(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text('MENO', style: MenoTypography.heading1),
                          const SizedBox(height: 2),
                          Text(
                            'Read. Remain. Grow.',
                            style: MenoTypography.bodyMedium.copyWith(
                              color: MenoColors.secondary,
                              fontWeight: FontWeight.bold,
                            ),
                          ),
                          const SizedBox(height: 4),
                          Text(
                            'Meetings 1–2 Design Foundation',
                            style: MenoTypography.caption,
                          ),
                        ],
                      ),
                    ),
                  ],
                ),
              ),
              const SizedBox(height: 24),

              // Typography Section
              Text('Typography Pairing', style: MenoTypography.heading2),
              const SizedBox(height: 8),
              MenoCard(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text('Outfit — Display & Headings', style: MenoTypography.heading3),
                    const SizedBox(height: 4),
                    Text(
                      'Plus Jakarta Sans — Body, Scripture reading, and interface text. Simple, clear, and highly readable.',
                      style: MenoTypography.bodyMedium,
                    ),
                    const SizedBox(height: 8),
                    Row(
                      children: [
                        Text('Gamification: ', style: MenoTypography.caption),
                        Text('+10 XP', style: MenoTypography.gamificationNumber),
                      ],
                    ),
                  ],
                ),
              ),
              const SizedBox(height: 24),

              // Chips Section
              Text('Chips & Badges', style: MenoTypography.heading2),
              const SizedBox(height: 8),
              Wrap(
                spacing: 8,
                runSpacing: 8,
                children: [
                  MenoChip.streak(days: 7),
                  MenoChip.xp(xp: 120),
                  const MenoChip(
                    label: 'Gospel Starter',
                    icon: Icons.map_rounded,
                    backgroundColor: MenoColors.lightTeal,
                    textColor: MenoColors.primary,
                  ),
                ],
              ),
              const SizedBox(height: 24),

              // Progress Bar Section
              Text('Progress Indicator', style: MenoTypography.heading2),
              const SizedBox(height: 8),
              MenoCard(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        Text('Journey Completion', style: MenoTypography.bodyMedium),
                        Text('${(_demoProgress * 100).round()}%', style: MenoTypography.caption),
                      ],
                    ),
                    const SizedBox(height: 8),
                    MenoProgressBar(progress: _demoProgress),
                  ],
                ),
              ),
              const SizedBox(height: 24),

              // Tactile Buttons Section
              Text('Tactile Controls', style: MenoTypography.heading2),
              const SizedBox(height: 8),
              MenoButton(
                label: 'Continue Reading (4dp Bevel)',
                icon: Icons.play_arrow_rounded,
                onPressed: () {
                  setState(() {
                    _demoProgress = (_demoProgress + 0.1 > 1.0) ? 0.1 : _demoProgress + 0.1;
                  });
                  ScaffoldMessenger.of(context).showSnackBar(
                    const SnackBar(
                      content: Text('Tactile Primary Button Pressed!'),
                      duration: Duration(seconds: 1),
                    ),
                  );
                },
              ),
              const SizedBox(height: 12),
              MenoSecondaryButton(
                label: 'View Reading Journey',
                icon: Icons.explore_outlined,
                onPressed: () {},
              ),
              const SizedBox(height: 12),
              const MenoButton(
                label: 'Disabled Button',
                onPressed: null,
              ),
              const SizedBox(height: 32),
            ],
          ),
        ),
      ),
    );
  }
}
