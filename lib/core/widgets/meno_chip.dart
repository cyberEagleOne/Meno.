import 'package:flutter/material.dart';
import '../theme/meno_colors.dart';
import '../theme/meno_typography.dart';

/// Reusable pill chip widget for XP, streak badges, and status labels
class MenoChip extends StatelessWidget {
  final String label;
  final IconData? icon;
  final Color backgroundColor;
  final Color textColor;
  final Color? iconColor;
  final VoidCallback? onTap;

  const MenoChip({
    super.key,
    required this.label,
    this.icon,
    this.backgroundColor = MenoColors.amberLight,
    this.textColor = MenoColors.amberDark,
    this.iconColor,
    this.onTap,
  });

  factory MenoChip.streak({required int days, VoidCallback? onTap}) {
    return MenoChip(
      label: '$days Days',
      icon: Icons.local_fire_department_rounded,
      backgroundColor: MenoColors.amberLight,
      textColor: MenoColors.amberDark,
      iconColor: MenoColors.amber,
      onTap: onTap,
    );
  }

  factory MenoChip.xp({required int xp, VoidCallback? onTap}) {
    return MenoChip(
      label: '$xp XP',
      icon: Icons.star_rounded,
      backgroundColor: MenoColors.amberLight,
      textColor: MenoColors.amberDark,
      iconColor: MenoColors.amber,
      onTap: onTap,
    );
  }

  @override
  Widget build(BuildContext context) {
    Widget content = Container(
      padding: const EdgeInsets.symmetric(horizontal: 12, vertical: 6),
      decoration: BoxDecoration(
        color: backgroundColor,
        borderRadius: BorderRadius.circular(50),
      ),
      child: Row(
        mainAxisSize: MainAxisSize.min,
        children: [
          if (icon != null) ...[
            Icon(
              icon,
              size: 16,
              color: iconColor ?? textColor,
            ),
            const SizedBox(width: 4),
          ],
          Text(
            label,
            style: MenoTypography.caption.copyWith(
              color: textColor,
              fontWeight: FontWeight.bold,
            ),
          ),
        ],
      ),
    );

    if (onTap != null) {
      return GestureDetector(
        onTap: onTap,
        child: content,
      );
    }

    return content;
  }
}
