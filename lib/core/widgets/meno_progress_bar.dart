import 'package:flutter/material.dart';
import '../theme/meno_colors.dart';

/// Reusable progress bar widget supporting custom progress fills and heights
class MenoProgressBar extends StatelessWidget {
  final double progress; // Value between 0.0 and 1.0
  final double height;
  final Color progressColor;
  final Color backgroundColor;
  final double borderRadius;

  const MenoProgressBar({
    super.key,
    required this.progress,
    this.height = 10.0,
    this.progressColor = MenoColors.primary,
    this.backgroundColor = MenoColors.warmSurfaceAlt1,
    this.borderRadius = 50.0,
  });

  @override
  Widget build(BuildContext context) {
    final double clampedProgress = progress.clamp(0.0, 1.0);

    return Container(
      height: height,
      decoration: BoxDecoration(
        color: backgroundColor,
        borderRadius: BorderRadius.circular(borderRadius),
      ),
      child: LayoutBuilder(
        builder: (context, constraints) {
          final double fillWidth = constraints.maxWidth * clampedProgress;
          return Align(
            alignment: Alignment.centerLeft,
            child: AnimatedContainer(
              duration: const Duration(milliseconds: 300),
              curve: Curves.easeOutCubic,
              width: fillWidth,
              height: height,
              decoration: BoxDecoration(
                color: progressColor,
                borderRadius: BorderRadius.circular(borderRadius),
              ),
            ),
          );
        },
      ),
    );
  }
}
