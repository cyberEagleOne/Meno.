import 'package:flutter/material.dart';
import '../theme/meno_colors.dart';
import '../theme/meno_typography.dart';

/// Secondary Outlined / Warm Surface Button widget matching Meno design system
class MenoSecondaryButton extends StatelessWidget {
  final String label;
  final VoidCallback? onPressed;
  final IconData? icon;
  final bool fullWidth;
  final double height;
  final double borderRadius;

  const MenoSecondaryButton({
    super.key,
    required this.label,
    this.onPressed,
    this.icon,
    this.fullWidth = true,
    this.height = 50.0,
    this.borderRadius = 16.0,
  });

  @override
  Widget build(BuildContext context) {
    final bool isEnabled = onPressed != null;
    final Color textColor = isEnabled ? MenoColors.primary : MenoColors.textSecondary;
    final Color borderColor = isEnabled ? MenoColors.outlineVariant : MenoColors.warmSurfaceAlt3;
    final Color backgroundColor = isEnabled ? MenoColors.surface : MenoColors.warmSurfaceAlt2;

    return OutlinedButton(
      onPressed: onPressed,
      style: OutlinedButton.styleFrom(
        minimumSize: Size(fullWidth ? double.infinity : 0, height),
        backgroundColor: backgroundColor,
        foregroundColor: textColor,
        side: BorderSide(color: borderColor, width: 1.5),
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(borderRadius),
        ),
        padding: const EdgeInsets.symmetric(horizontal: 20),
      ),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.center,
        mainAxisSize: fullWidth ? MainAxisSize.max : MainAxisSize.min,
        children: [
          if (icon != null) ...[
            Icon(icon, color: textColor, size: 20),
            const SizedBox(width: 8),
          ],
          Text(
            label,
            style: MenoTypography.buttonLabel.copyWith(color: textColor),
          ),
        ],
      ),
    );
  }
}
