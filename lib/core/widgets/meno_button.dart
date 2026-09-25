import 'package:flutter/material.dart';
import '../theme/meno_colors.dart';
import '../theme/meno_typography.dart';

/// Tactile Bevel Primary Button widget matching Meno design system
class MenoButton extends StatefulWidget {
  final String label;
  final VoidCallback? onPressed;
  final IconData? icon;
  final bool fullWidth;
  final double height;
  final double borderRadius;

  const MenoButton({
    super.key,
    required this.label,
    this.onPressed,
    this.icon,
    this.fullWidth = true,
    this.height = 52.0,
    this.borderRadius = 16.0,
  });

  @override
  State<MenoButton> createState() => _MenoButtonState();
}

class _MenoButtonState extends State<MenoButton> {
  bool _isPressed = false;

  bool get _isEnabled => widget.onPressed != null;

  void _onTapDown(TapDownDetails details) {
    if (!_isEnabled) return;
    setState(() => _isPressed = true);
  }

  void _onTapUp(TapUpDetails details) {
    if (!_isEnabled) return;
    setState(() => _isPressed = false);
  }

  void _onTapCancel() {
    if (!_isEnabled) return;
    setState(() => _isPressed = false);
  }

  @override
  Widget build(BuildContext context) {
    const double bevelDepth = 4.0;
    final double currentTranslateY = (_isPressed || !_isEnabled) ? bevelDepth : 0.0;

    final Color surfaceColor = _isEnabled ? MenoColors.primary : MenoColors.warmSurfaceAlt2;
    final Color bevelColor = _isEnabled ? MenoColors.tactileBevel : MenoColors.warmSurfaceAlt3;
    final Color textColor = _isEnabled ? MenoColors.surface : MenoColors.textSecondary;

    Widget child = Container(
      height: widget.height,
      padding: const EdgeInsets.symmetric(horizontal: 24),
      decoration: BoxDecoration(
        color: surfaceColor,
        borderRadius: BorderRadius.circular(widget.borderRadius),
      ),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.center,
        mainAxisSize: widget.fullWidth ? MainAxisSize.max : MainAxisSize.min,
        children: [
          if (widget.icon != null) ...[
            Icon(widget.icon, color: textColor, size: 20),
            const SizedBox(width: 8),
          ],
          Text(
            widget.label,
            style: MenoTypography.buttonLabel.copyWith(color: textColor),
          ),
        ],
      ),
    );

    return GestureDetector(
      onTapDown: _onTapDown,
      onTapUp: _onTapUp,
      onTapCancel: _onTapCancel,
      onTap: _isEnabled ? widget.onPressed : null,
      behavior: HitTestBehavior.opaque,
      child: SizedBox(
        width: widget.fullWidth ? double.infinity : null,
        height: widget.height + bevelDepth,
        child: Stack(
          children: [
            // Tactile Bevel Base Shadow
            Positioned(
              left: 0,
              right: 0,
              bottom: 0,
              height: widget.height,
              child: Container(
                decoration: BoxDecoration(
                  color: bevelColor,
                  borderRadius: BorderRadius.circular(widget.borderRadius),
                ),
              ),
            ),
            // Top Action Surface (Translates downward when pressed)
            AnimatedPositioned(
              duration: const Duration(milliseconds: 60),
              curve: Curves.easeOut,
              top: currentTranslateY,
              left: 0,
              right: 0,
              child: child,
            ),
          ],
        ),
      ),
    );
  }
}
