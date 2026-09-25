import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'meno_colors.dart';

/// Centralized Meno typography pairing Outfit & Plus Jakarta Sans
abstract class MenoTypography {
  // Display Large (Outfit Bold)
  static TextStyle get displayLarge => GoogleFonts.outfit(
        fontSize: 34,
        fontWeight: FontWeight.bold,
        height: 1.2,
        color: MenoColors.textPrimary,
      );

  // Heading 1 (Outfit Bold)
  static TextStyle get heading1 => GoogleFonts.outfit(
        fontSize: 26,
        fontWeight: FontWeight.bold,
        height: 1.25,
        color: MenoColors.textPrimary,
      );

  // Heading 2 (Outfit SemiBold)
  static TextStyle get heading2 => GoogleFonts.outfit(
        fontSize: 22,
        fontWeight: FontWeight.w600,
        height: 1.3,
        color: MenoColors.textPrimary,
      );

  // Heading 3 (Outfit SemiBold)
  static TextStyle get heading3 => GoogleFonts.outfit(
        fontSize: 18,
        fontWeight: FontWeight.w600,
        height: 1.35,
        color: MenoColors.textPrimary,
      );

  // Gamification Number (Outfit Bold)
  static TextStyle get gamificationNumber => GoogleFonts.outfit(
        fontSize: 24,
        fontWeight: FontWeight.bold,
        height: 1.2,
        color: MenoColors.amberDark,
      );

  // Button Text (Outfit SemiBold)
  static TextStyle get buttonLabel => GoogleFonts.outfit(
        fontSize: 16,
        fontWeight: FontWeight.w600,
        height: 1.2,
        letterSpacing: 0.5,
        color: MenoColors.surface,
      );

  // Body Large (Plus Jakarta Sans Regular / Scripture Reader)
  static TextStyle get bodyLarge => GoogleFonts.plusJakartaSans(
        fontSize: 18,
        fontWeight: FontWeight.normal,
        height: 1.6,
        color: MenoColors.textPrimary,
      );

  // Body Medium (Plus Jakarta Sans Regular)
  static TextStyle get bodyMedium => GoogleFonts.plusJakartaSans(
        fontSize: 15,
        fontWeight: FontWeight.normal,
        height: 1.5,
        color: MenoColors.textPrimary,
      );

  // Caption (Plus Jakarta Sans Medium)
  static TextStyle get caption => GoogleFonts.plusJakartaSans(
        fontSize: 13,
        fontWeight: FontWeight.w500,
        height: 1.4,
        color: MenoColors.textSecondary,
      );

  // TextTheme representation for ThemeData integration
  static TextTheme get textTheme => TextTheme(
        displayLarge: displayLarge,
        headlineLarge: heading1,
        headlineMedium: heading2,
        headlineSmall: heading3,
        bodyLarge: bodyLarge,
        bodyMedium: bodyMedium,
        labelLarge: buttonLabel,
        bodySmall: caption,
      );
}
