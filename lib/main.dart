import 'package:flutter/material.dart';
import 'core/routing/app_router.dart';
import 'core/theme/meno_theme.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(const MenoApp());
}

class MenoApp extends StatelessWidget {
  const MenoApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp.router(
      title: 'Meno',
      debugShowCheckedModeBanner: false,
      theme: MenoTheme.lightTheme,
      routerConfig: AppRouter.router,
    );
  }
}
