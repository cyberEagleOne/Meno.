import 'package:flutter/material.dart';
import '../theme/meno_colors.dart';

enum MascotState {
  waving,
  reading,
  celebrating,
  defaultState,
}

/// Foundation widget for displaying the Meno Bean mascot
class MenoMascot extends StatelessWidget {
  final MascotState state;
  final double size;

  const MenoMascot({
    super.key,
    this.state = MascotState.defaultState,
    this.size = 120.0,
  });

  @override
  Widget build(BuildContext context) {
    // Render local mascot image asset if available, or clean mascot illustration badge
    return Container(
      width: size,
      height: size,
      decoration: BoxDecoration(
        color: MenoColors.lightTeal.withValues(alpha: 0.3),
        shape: BoxShape.circle,
        border: Border.all(color: MenoColors.tealFixedDim, width: 2),
      ),
      child: Center(
        child: ClipOval(
          child: Image.asset(
            'assets/images/logo_meno.png',
            width: size * 0.75,
            height: size * 0.75,
            fit: BoxFit.contain,
            errorBuilder: (context, error, stackTrace) {
              // Fallback visual indicator if image asset is not present
              return Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Icon(
                    _getMascotIcon(),
                    size: size * 0.4,
                    color: MenoColors.primary,
                  ),
                  const SizedBox(height: 4),
                  Text(
                    'Meno',
                    style: TextStyle(
                      fontSize: size * 0.12,
                      fontWeight: FontWeight.bold,
                      color: MenoColors.primary,
                    ),
                  ),
                ],
              );
            },
          ),
        ),
      ),
    );
  }

  IconData _getMascotIcon() {
    switch (state) {
      case MascotState.waving:
        return Icons.waving_hand_rounded;
      case MascotState.reading:
        return Icons.menu_book_rounded;
      case MascotState.celebrating:
        return Icons.celebration_rounded;
      case MascotState.defaultState:
        return Icons.sentiment_satisfied_alt_rounded;
    }
  }
}
