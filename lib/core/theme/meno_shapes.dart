import 'package:flutter/material.dart';

/// Centralized Meno corner radius and shape specifications
abstract class MenoShapes {
  static const double radiusSmall = 8.0;
  static const double radiusMedium = 12.0;
  static const double radiusLarge = 16.0;
  static const double radiusExtraLarge = 24.0;
  static const double radiusPill = 50.0;

  static final BorderRadius borderSmall = BorderRadius.circular(radiusSmall);
  static final BorderRadius borderMedium = BorderRadius.circular(radiusMedium);
  static final BorderRadius borderLarge = BorderRadius.circular(radiusLarge);
  static final BorderRadius borderExtraLarge = BorderRadius.circular(radiusExtraLarge);
  static final BorderRadius borderPill = BorderRadius.circular(radiusPill);

  static final RoundedRectangleBorder shapeSmall = RoundedRectangleBorder(borderRadius: borderSmall);
  static final RoundedRectangleBorder shapeMedium = RoundedRectangleBorder(borderRadius: borderMedium);
  static final RoundedRectangleBorder shapeLarge = RoundedRectangleBorder(borderRadius: borderLarge);
  static final RoundedRectangleBorder shapePill = RoundedRectangleBorder(borderRadius: borderPill);
}
