import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import '../../features/showcase/design_system_showcase_screen.dart';

/// Declarative go_router router configuration for Meno foundation
abstract class AppRouter {
  static const String root = '/';

  static final GoRouter router = GoRouter(
    initialLocation: root,
    routes: <RouteBase>[
      GoRoute(
        path: root,
        builder: (BuildContext context, GoRouterState state) {
          return const DesignSystemShowcaseScreen();
        },
      ),
    ],
  );
}
