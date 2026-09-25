import 'package:flutter/material.dart';
import 'meno_colors.dart';
import 'meno_shapes.dart';
import 'meno_typography.dart';

/// Global Meno ThemeData builder
abstract class MenoTheme {
  static ThemeData get lightTheme {
    return ThemeData(
      useMaterial3: true,
      scaffoldBackgroundColor: MenoColors.background,
      colorScheme: const ColorScheme.light(
        primary: MenoColors.primary,
        secondary: MenoColors.secondary,
        tertiary: MenoColors.amber,
        surface: MenoColors.surface,
        onPrimary: MenoColors.surface,
        onSecondary: MenoColors.surface,
        onSurface: MenoColors.textPrimary,
        outline: MenoColors.outline,
        outlineVariant: MenoColors.outlineVariant,
      ),
      textTheme: MenoTypography.textTheme,
      cardTheme: CardThemeData(
        color: MenoColors.surface,
        elevation: 0,
        shape: MenoShapes.shapeLarge,
        margin: EdgeInsets.zero,
      ),
      appBarTheme: AppBarTheme(
        backgroundColor: MenoColors.background,
        surfaceTintColor: Colors.transparent,
        elevation: 0,
        centerTitle: true,
        titleTextStyle: MenoTypography.heading3,
        iconTheme: const IconThemeData(color: MenoColors.textPrimary),
      ),
      dividerTheme: const DividerThemeData(
        color: MenoColors.outlineVariant,
        thickness: 1,
        space: 1,
      ),
    );
  }
}
