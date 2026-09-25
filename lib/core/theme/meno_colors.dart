import 'package:flutter/material.dart';

/// Centralized Meno color tokens as defined in design.md
abstract class MenoColors {
  // Primary Palette (Teal)
  static const Color primary = Color(0xFF006964);
  static const Color secondary = Color(0xFF10847E);
  static const Color lightTeal = Color(0xFF94F3EB);
  static const Color tealFixedDim = Color(0xFF77D6CF);
  static const Color tactileBevel = Color(0xFF00504C);

  // Accent Palette (Amber / Gamification)
  static const Color amber = Color(0xFFFEA619);
  static const Color amberDark = Color(0xFF855300);
  static const Color amberFixed = Color(0xFFFFDDB8);
  static const Color amberLight = Color(0xFFFEF3C7);

  // Background & Surface System (Warm Off-White / Parchment)
  static const Color background = Color(0xFFFBF9F6);
  static const Color surface = Color(0xFFFFFFFF);
  static const Color warmSurface = Color(0xFFF5F3F0);
  static const Color warmSurfaceAlt1 = Color(0xFFEFEEEB);
  static const Color warmSurfaceAlt2 = Color(0xFFEAE8E5);
  static const Color warmSurfaceAlt3 = Color(0xFFE4E2DF);

  // Text & Outline System
  static const Color textPrimary = Color(0xFF1B1C1A);
  static const Color textSecondary = Color(0xFF3E4948);
  static const Color outline = Color(0xFF6E7978);
  static const Color outlineVariant = Color(0xFFBDC9C7);
}
