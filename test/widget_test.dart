import 'package:flutter_test/flutter_test.dart';
import 'package:meno/main.dart';

void main() {
  testWidgets('Meno Design System showcase screen loads cleanly', (WidgetTester tester) async {
    // Build our app and trigger a frame.
    await tester.pumpWidget(const MenoApp());

    // Verify title and tagline text.
    expect(find.text('MENO'), findsOneWidget);
    expect(find.text('Read. Remain. Grow.'), findsOneWidget);

    // Verify buttons render.
    expect(find.text('Continue Reading (4dp Bevel)'), findsOneWidget);
    expect(find.text('View Reading Journey'), findsOneWidget);
  });
}
